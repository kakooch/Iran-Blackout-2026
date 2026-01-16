package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsManifest;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.BringAppForegroundService;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$LiveStreamState;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateBroadcasting;
import ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateEnded;
import ir.eitaa.tgnet.TLRPC$TL_Live_getMedia;
import ir.eitaa.tgnet.TLRPC$TL_Live_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_Live_participants;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Components.CommentAvatarContainer;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PipVideoView;
import ir.eitaa.ui.Components.Pipable;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.Rect;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBar;
import ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto;
import ir.eitaa.ui.Components.VideoPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public class LiveVideoViewer implements NotificationCenter.NotificationCenterDelegate, Pipable {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile LiveVideoViewer Instance;
    private static volatile LiveVideoViewer PipInstance;
    private ActionBar actionBar;
    private Context actvityContext;
    private String alt_read_link;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private boolean attachedToWindow;
    private CommentAvatarContainer avatarContainer;
    private TextView captionTextView;
    private TextureView changedTextureView;
    private boolean changingTextureView;
    private FrameLayoutDrawer containerView;
    private int currentAccount;
    private Bitmap currentBitmap;
    protected TLRPC$Chat currentChat;
    private int currentEditMode;
    protected TLRPC$User currentUser;
    private boolean isInline;
    private boolean isVisible;
    private boolean keepScreenOnFlagSet;
    private Object lastInsets;
    private TLRPC$TL_messageMediaLiveStream messageMediaLiveStream;
    private MessageObject messageObject;
    private boolean needCaptionLayout;
    private Activity parentActivity;
    private boolean pipAnimationInProgress;
    private ActionBarMenuItem pipItem;
    private PipVideoView pipVideoView;
    private boolean pollingState;
    private RadialProgressView progressBar;
    private String read_link;
    private Runnable retryRunnable;
    private TextView stateTextView;
    private boolean switchingInlineMode;
    private ImageView textureImageView;
    private boolean textureUploaded;
    private VideoPlayer videoPlayer;
    private FrameLayout videoPlayerControlFrameLayout;
    private SeekBar videoPlayerSeekbar;
    private SimpleTextView videoPlayerTime;
    private TextureView videoTextureView;
    private AlertDialog visibleDialog;
    private int waitingForDraw;
    private int waitingForFirstTextureUpload;
    private boolean wasLayout;
    private WindowManager.LayoutParams windowLayoutParams;
    private FrameLayout windowView;
    private boolean isActionBarVisible = true;
    private Paint blackPaint = new Paint();
    private boolean bottomTouchEnabled = true;
    private long dialog_id = 0;
    private int msg_id = 0;
    private ColorDrawable backgroundDrawable = new ColorDrawable(-16777216);
    private int state = -2;
    private boolean ended = false;
    private String failedMessage = "";
    private Runnable statePollRunnable = null;
    private int allowedBehindSegment = 4;
    private long currentManifestIndex = 0;
    private boolean showGoToMessage = false;
    private ActionBarMenuItem headerItem = null;
    private boolean isPlaying = false;
    private Runnable updateProgressRunnable = new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.1
        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (LiveVideoViewer.this.videoPlayer != null) {
                if (!LiveVideoViewer.this.videoPlayerSeekbar.isDragging()) {
                    LiveVideoViewer.this.videoPlayerSeekbar.setProgress(LiveVideoViewer.this.videoPlayer.getCurrentPosition() / LiveVideoViewer.this.videoPlayer.getDuration());
                    LiveVideoViewer.this.videoPlayerControlFrameLayout.invalidate();
                    if (LiveVideoViewer.this.videoPlayer == null) {
                        str = String.format("%02d:%02d / %02d:%02d", 0, 0, 0, 0);
                    } else {
                        long currentPosition = LiveVideoViewer.this.videoPlayer.getCurrentPosition();
                        if (currentPosition < 0) {
                            currentPosition = 0;
                        }
                        long duration = LiveVideoViewer.this.videoPlayer.getDuration();
                        long j = duration >= 0 ? duration : 0L;
                        if (j == -9223372036854775807L || currentPosition == -9223372036854775807L) {
                            str = String.format("%02d:%02d / %02d:%02d", 0, 0, 0, 0);
                        } else {
                            long j2 = currentPosition / 1000;
                            long j3 = j / 1000;
                            str = String.format("%02d:%02d / %02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60), Long.valueOf(j3 / 60), Long.valueOf(j3 % 60));
                        }
                    }
                    LiveVideoViewer.this.videoPlayerTime.setText(str);
                }
                if (LiveVideoViewer.this.videoPlayer.isPlaying()) {
                    AndroidUtilities.runOnUIThread(LiveVideoViewer.this.updateProgressRunnable, 17L);
                }
            }
        }
    };
    private Runnable switchToInlineRunnable = new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.2
        @Override // java.lang.Runnable
        public void run() {
            LiveVideoViewer.this.switchingInlineMode = false;
            if (LiveVideoViewer.this.currentBitmap != null) {
                LiveVideoViewer.this.currentBitmap.recycle();
                LiveVideoViewer.this.currentBitmap = null;
            }
            LiveVideoViewer.this.changingTextureView = true;
            if (LiveVideoViewer.this.textureImageView != null) {
                try {
                    LiveVideoViewer liveVideoViewer = LiveVideoViewer.this;
                    liveVideoViewer.currentBitmap = Bitmaps.createBitmap(liveVideoViewer.videoTextureView.getWidth(), LiveVideoViewer.this.videoTextureView.getHeight(), Bitmap.Config.ARGB_8888);
                    LiveVideoViewer.this.videoTextureView.getBitmap(LiveVideoViewer.this.currentBitmap);
                } catch (Throwable th) {
                    if (LiveVideoViewer.this.currentBitmap != null) {
                        LiveVideoViewer.this.currentBitmap.recycle();
                        LiveVideoViewer.this.currentBitmap = null;
                    }
                    FileLog.e(th);
                }
                if (LiveVideoViewer.this.currentBitmap != null) {
                    LiveVideoViewer.this.textureImageView.setVisibility(0);
                    LiveVideoViewer.this.textureImageView.setImageBitmap(LiveVideoViewer.this.currentBitmap);
                } else {
                    LiveVideoViewer.this.textureImageView.setImageDrawable(null);
                }
            }
            LiveVideoViewer.this.isInline = true;
            LiveVideoViewer.this.pipVideoView = new PipVideoView(true);
            LiveVideoViewer liveVideoViewer2 = LiveVideoViewer.this;
            PipVideoView pipVideoView = liveVideoViewer2.pipVideoView;
            Activity activity = LiveVideoViewer.this.parentActivity;
            LiveVideoViewer liveVideoViewer3 = LiveVideoViewer.this;
            liveVideoViewer2.changedTextureView = pipVideoView.show(activity, liveVideoViewer3, null, liveVideoViewer3.aspectRatioFrameLayout.getAspectRatio(), LiveVideoViewer.this.aspectRatioFrameLayout.getVideoRotation(), null);
            LiveVideoViewer.this.changedTextureView.setVisibility(4);
            LiveVideoViewer.this.aspectRatioFrameLayout.removeView(LiveVideoViewer.this.videoTextureView);
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new AnonymousClass26();
    int prevOrientation = 1;

    static /* synthetic */ int access$2910(LiveVideoViewer liveVideoViewer) {
        int i = liveVideoViewer.waitingForDraw;
        liveVideoViewer.waitingForDraw = i - 1;
        return i;
    }

    static /* synthetic */ int access$5704(LiveVideoViewer liveVideoViewer) {
        int i = liveVideoViewer.allowedBehindSegment + 1;
        liveVideoViewer.allowedBehindSegment = i;
        return i;
    }

    private class FrameLayoutDrawer extends SizeNotifierFrameLayoutPhoto {
        private Paint paint;

        public FrameLayoutDrawer(Context context) {
            super(context, false);
            this.paint = new Paint();
            setWillNotDraw(false);
            this.paint.setColor(855638016);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    if (childAt == LiveVideoViewer.this.aspectRatioFrameLayout) {
                        measureChildWithMargins(childAt, widthMeasureSpec, 0, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.displaySize.y + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0), 1073741824), 0);
                    } else {
                        measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
            /*
                r8 = this;
                int r9 = r8.getChildCount()
                r0 = 0
            L5:
                if (r0 >= r9) goto L77
                android.view.View r1 = r8.getChildAt(r0)
                int r2 = r1.getVisibility()
                r3 = 8
                if (r2 != r3) goto L14
                goto L74
            L14:
                android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
                int r3 = r1.getMeasuredWidth()
                int r4 = r1.getMeasuredHeight()
                int r5 = r2.gravity
                r6 = -1
                if (r5 != r6) goto L29
                r5 = 51
            L29:
                r6 = r5 & 7
                r5 = r5 & 112(0x70, float:1.57E-43)
                r6 = r6 & 7
                r7 = 1
                if (r6 == r7) goto L3e
                r7 = 5
                if (r6 == r7) goto L38
                int r6 = r2.leftMargin
                goto L49
            L38:
                int r6 = r12 - r10
                int r6 = r6 - r3
                int r7 = r2.rightMargin
                goto L48
            L3e:
                int r6 = r12 - r10
                int r6 = r6 - r3
                int r6 = r6 / 2
                int r7 = r2.leftMargin
                int r6 = r6 + r7
                int r7 = r2.rightMargin
            L48:
                int r6 = r6 - r7
            L49:
                r7 = 16
                if (r5 == r7) goto L62
                r7 = 48
                if (r5 == r7) goto L5f
                r7 = 80
                if (r5 == r7) goto L58
                int r2 = r2.topMargin
                goto L6f
            L58:
                int r5 = r13 + 0
                int r5 = r5 - r11
                int r5 = r5 - r4
                int r2 = r2.bottomMargin
                goto L6d
            L5f:
                int r2 = r2.topMargin
                goto L6f
            L62:
                int r5 = r13 + 0
                int r5 = r5 - r11
                int r5 = r5 - r4
                int r5 = r5 / 2
                int r7 = r2.topMargin
                int r5 = r5 + r7
                int r2 = r2.bottomMargin
            L6d:
                int r2 = r5 - r2
            L6f:
                int r3 = r3 + r6
                int r4 = r4 + r2
                r1.layout(r6, r2, r3, r4)
            L74:
                int r0 = r0 + 1
                goto L5
            L77:
                r8.notifyHeightChanged()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LiveVideoViewer.FrameLayoutDrawer.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (LiveVideoViewer.this.aspectRatioFrameLayout != null && LiveVideoViewer.this.aspectRatioFrameLayout.getVisibility() == 0) {
                canvas.save();
                canvas.translate((LiveVideoViewer.this.getContainerViewWidth() / 2) + LiveVideoViewer.this.getAdditionX(), (LiveVideoViewer.this.getContainerViewHeight() / 2) + LiveVideoViewer.this.getAdditionY());
                int measuredWidth = LiveVideoViewer.this.videoTextureView.getMeasuredWidth();
                float containerViewWidth = LiveVideoViewer.this.getContainerViewWidth() / measuredWidth;
                float containerViewHeight = LiveVideoViewer.this.getContainerViewHeight() / LiveVideoViewer.this.videoTextureView.getMeasuredHeight();
                if (containerViewWidth > containerViewHeight) {
                    containerViewWidth = containerViewHeight;
                }
                canvas.translate((-((int) (r0 * containerViewWidth))) / 2, (-((int) (r1 * containerViewWidth))) / 2);
                LiveVideoViewer.this.aspectRatioFrameLayout.draw(canvas);
                canvas.restore();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                int i = AndroidUtilities.statusBarHeight;
            }
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            try {
                if (child != LiveVideoViewer.this.aspectRatioFrameLayout) {
                    if (super.drawChild(canvas, child, drawingTime)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }
    }

    public static LiveVideoViewer getPipInstance() {
        return PipInstance;
    }

    public static LiveVideoViewer getInstance() {
        LiveVideoViewer liveVideoViewer = Instance;
        if (liveVideoViewer == null) {
            synchronized (LiveVideoViewer.class) {
                liveVideoViewer = Instance;
                if (liveVideoViewer == null) {
                    liveVideoViewer = new LiveVideoViewer();
                    Instance = liveVideoViewer;
                }
            }
        }
        return liveVideoViewer;
    }

    public LiveVideoViewer() {
        this.blackPaint.setColor(-16777216);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0112  */
    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r8, int r9, java.lang.Object... r10) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LiveVideoViewer.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    public void setParentActivity(final Activity activity) {
        this.currentAccount = UserConfig.selectedAccount;
        if (this.parentActivity == activity) {
            return;
        }
        this.parentActivity = activity;
        this.actvityContext = new ContextThemeWrapper(this.parentActivity, R.style.Theme_TMessages);
        FrameLayout frameLayout = new FrameLayout(activity) { // from class: ir.eitaa.ui.LiveVideoViewer.7
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return super.onTouchEvent(event);
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                return super.drawChild(canvas, child, drawingTime);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                int i = Build.VERSION.SDK_INT;
                if (i >= 21 && LiveVideoViewer.this.lastInsets != null) {
                    WindowInsets windowInsets = (WindowInsets) LiveVideoViewer.this.lastInsets;
                    if (AndroidUtilities.incorrectDisplaySizeFix) {
                        int i2 = AndroidUtilities.displaySize.y;
                        if (size2 > i2) {
                            size2 = i2;
                        }
                        size2 += AndroidUtilities.statusBarHeight;
                    }
                    size2 -= windowInsets.getSystemWindowInsetBottom();
                    size -= windowInsets.getSystemWindowInsetRight();
                } else {
                    int i3 = AndroidUtilities.displaySize.y;
                    if (size2 > i3) {
                        size2 = i3;
                    }
                }
                setMeasuredDimension(size, size2);
                if (i >= 21 && LiveVideoViewer.this.lastInsets != null) {
                    size -= ((WindowInsets) LiveVideoViewer.this.lastInsets).getSystemWindowInsetLeft();
                }
                LiveVideoViewer.this.containerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int systemWindowInsetLeft = (Build.VERSION.SDK_INT < 21 || LiveVideoViewer.this.lastInsets == null) ? 0 : ((WindowInsets) LiveVideoViewer.this.lastInsets).getSystemWindowInsetLeft() + 0;
                LiveVideoViewer.this.containerView.layout(systemWindowInsetLeft, 0, LiveVideoViewer.this.containerView.getMeasuredWidth() + systemWindowInsetLeft, LiveVideoViewer.this.containerView.getMeasuredHeight());
                LiveVideoViewer.this.wasLayout = true;
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                LiveVideoViewer.this.attachedToWindow = true;
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                LiveVideoViewer.this.attachedToWindow = false;
                LiveVideoViewer.this.wasLayout = false;
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEventPreIme(KeyEvent event) {
                if (event != null && event.getKeyCode() == 4 && event.getAction() == 1) {
                    LiveVideoViewer.getInstance().closePhoto(true);
                    return true;
                }
                return super.dispatchKeyEventPreIme(event);
            }

            @Override // android.view.ViewGroup, android.view.ViewParent
            public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback, int type) {
                if (Build.VERSION.SDK_INT >= 23) {
                    View viewFindViewById = LiveVideoViewer.this.parentActivity.findViewById(android.R.id.content);
                    if (viewFindViewById instanceof ViewGroup) {
                        try {
                            return ((ViewGroup) viewFindViewById).startActionModeForChild(originalView, callback, type);
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    }
                }
                return super.startActionModeForChild(originalView, callback, type);
            }
        };
        this.windowView = frameLayout;
        frameLayout.setBackgroundDrawable(this.backgroundDrawable);
        this.windowView.setClipChildren(true);
        this.windowView.setFocusable(false);
        FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(activity) { // from class: ir.eitaa.ui.LiveVideoViewer.8
            @Override // ir.eitaa.ui.LiveVideoViewer.FrameLayoutDrawer, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (LiveVideoViewer.this.waitingForDraw != 0) {
                    LiveVideoViewer.access$2910(LiveVideoViewer.this);
                    if (LiveVideoViewer.this.waitingForDraw == 0) {
                        if (LiveVideoViewer.this.textureImageView != null) {
                            try {
                                LiveVideoViewer liveVideoViewer = LiveVideoViewer.this;
                                liveVideoViewer.currentBitmap = Bitmaps.createBitmap(liveVideoViewer.videoTextureView.getWidth(), LiveVideoViewer.this.videoTextureView.getHeight(), Bitmap.Config.ARGB_8888);
                                LiveVideoViewer.this.changedTextureView.getBitmap(LiveVideoViewer.this.currentBitmap);
                            } catch (Throwable th) {
                                if (LiveVideoViewer.this.currentBitmap != null) {
                                    LiveVideoViewer.this.currentBitmap.recycle();
                                    LiveVideoViewer.this.currentBitmap = null;
                                }
                                FileLog.e(th);
                            }
                            if (LiveVideoViewer.this.currentBitmap != null) {
                                LiveVideoViewer.this.textureImageView.setVisibility(0);
                                LiveVideoViewer.this.textureImageView.setImageBitmap(LiveVideoViewer.this.currentBitmap);
                            } else {
                                LiveVideoViewer.this.textureImageView.setImageDrawable(null);
                            }
                        }
                        LiveVideoViewer.this.pipVideoView.close();
                        LiveVideoViewer.this.pipVideoView = null;
                        return;
                    }
                    LiveVideoViewer.this.containerView.invalidate();
                }
            }
        };
        this.containerView = frameLayoutDrawer;
        frameLayoutDrawer.setFocusable(false);
        this.windowView.addView(this.containerView, LayoutHelper.createFrame(-1, -1, 51));
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            this.containerView.setFitsSystemWindows(true);
            this.containerView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.LiveVideoViewer.9
                @Override // android.view.View.OnApplyWindowInsetsListener
                @SuppressLint({"NewApi"})
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    WindowInsets windowInsets = (WindowInsets) LiveVideoViewer.this.lastInsets;
                    LiveVideoViewer.this.lastInsets = insets;
                    if (windowInsets == null || !windowInsets.toString().equals(insets.toString())) {
                        LiveVideoViewer.this.windowView.requestLayout();
                    }
                    return insets.consumeSystemWindowInsets();
                }
            });
            this.windowView.setSystemUiVisibility(1280);
            this.containerView.setSystemUiVisibility(1280);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 51;
        layoutParams.type = 99;
        if (i >= 21) {
            layoutParams.flags = -2147417848;
        } else {
            layoutParams.flags = 8;
        }
        ActionBar actionBar = new ActionBar(activity);
        this.actionBar = actionBar;
        actionBar.setTitleColor(-1);
        this.actionBar.setSubtitleColor(-1);
        this.actionBar.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-16777216, 0}));
        this.actionBar.setItemsBackgroundColor(-1, false);
        this.actionBar.setItemsColor(-1, false);
        this.actionBar.setBackButtonDrawable(new BackDrawable(true));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.LiveVideoViewer.10
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    LiveVideoViewer.this.closePhoto(true);
                    return;
                }
                if (id == 5) {
                    LiveVideoViewer.this.switchToPip();
                    return;
                }
                if (id == 1357) {
                    if (LiveVideoViewer.this.currentChat != null) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("chat_id", (int) LiveVideoViewer.this.currentChat.id);
                        bundle.putInt("message_id", LiveVideoViewer.this.currentChat.live_stream_msg_id);
                        ((LaunchActivity) LiveVideoViewer.this.parentActivity).presentFragment(new ChatActivity(bundle), false, true);
                    }
                    LiveVideoViewer.this.closePhoto(true);
                }
            }
        });
        CommentAvatarContainer commentAvatarContainer = new CommentAvatarContainer(this.actvityContext);
        this.avatarContainer = commentAvatarContainer;
        this.actionBar.addView(commentAvatarContainer, 0, LayoutHelper.createFrame(-2, -1.0f, 51, 56.0f, 0.0f, 40.0f, 0.0f));
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(5, R.drawable.ic_goinline);
        this.pipItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        ActionBarMenuItem actionBarMenuItemAddItem2 = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other);
        this.headerItem = actionBarMenuItemAddItem2;
        actionBarMenuItemAddItem2.addSubItem(1357, LocaleController.getString("LiveGoToMessage", R.string.LiveGoToMessage));
        RadialProgressView radialProgressView = new RadialProgressView(this.actvityContext);
        this.progressBar = radialProgressView;
        radialProgressView.setVisibility(4);
        this.containerView.addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
        TextView textView = new TextView(this.actvityContext);
        this.stateTextView = textView;
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.stateTextView.setVisibility(4);
        this.stateTextView.setGravity(17);
        this.stateTextView.setTextColor(-1);
        this.stateTextView.setBackgroundColor(855638016);
        this.stateTextView.setPadding(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f));
        this.containerView.addView(this.stateTextView, LayoutHelper.createFrame(-1, -1, 17));
        TextView textView2 = new TextView(this.actvityContext) { // from class: ir.eitaa.ui.LiveVideoViewer.11
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return LiveVideoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        this.captionTextView = textView2;
        textView2.setVisibility(8);
        this.captionTextView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f));
        this.captionTextView.setLinkTextColor(-1);
        this.captionTextView.setTextColor(-1);
        this.captionTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.captionTextView.setGravity(19);
        this.captionTextView.setTextSize(1, 16.0f);
        this.captionTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.captionTextView.setVisibility(4);
        this.captionTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.LiveVideoViewer.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(AndroidUtilities.dp(1.0f), -1711276033);
        gradientDrawable.setCornerRadius(AndroidUtilities.dp(16.0f));
        this.captionTextView.setBackgroundDrawable(gradientDrawable);
        ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        createVideoControlsInterface();
        this.avatarContainer.getSubtitleTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.LiveVideoViewer.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TLRPC$Chat tLRPC$Chat;
                TLRPC$Chat tLRPC$Chat2;
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
                if (LiveVideoViewer.this.messageObject == null || LiveVideoViewer.this.messageMediaLiveStream == null || !LiveVideoViewer.this.messageMediaLiveStream.state.isBroadCasting || LiveVideoViewer.this.messageObject.isForwarded() || (tLRPC$Chat = LiveVideoViewer.this.currentChat) == null) {
                    return;
                }
                if (ChatObject.hasAdminRights(tLRPC$Chat) || ((ChatObject.isMegagroup(LiveVideoViewer.this.currentChat) && LiveVideoViewer.this.currentChat.default_banned_rights == null) || !(((tLRPC$TL_chatBannedRights = (tLRPC$Chat2 = LiveVideoViewer.this.currentChat).default_banned_rights) == null || tLRPC$TL_chatBannedRights.view_participants) && (ChatObject.isMegagroup(tLRPC$Chat2) || ChatObject.isChannel(LiveVideoViewer.this.currentChat))))) {
                    LiveVideoViewer.this.showParticipants();
                }
            }
        });
    }

    private void createVideoControlsInterface() {
        SeekBar seekBar = new SeekBar(this.containerView);
        this.videoPlayerSeekbar = seekBar;
        seekBar.setLineHeight(AndroidUtilities.dp(4.0f));
        this.videoPlayerSeekbar.setColors(1728053247, 1728053247, -2764585, -1, -1);
        this.videoPlayerSeekbar.setDelegate(new SeekBar.SeekBarDelegate() { // from class: ir.eitaa.ui.LiveVideoViewer.14
            @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
            public /* synthetic */ void onSeekBarContinuousDrag(float f) {
                SeekBar.SeekBarDelegate.CC.$default$onSeekBarContinuousDrag(this, f);
            }

            @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
            public void onSeekBarDrag(float progress) {
                if (LiveVideoViewer.this.videoPlayer != null) {
                    if (LiveVideoViewer.this.videoPlayer.getDuration() == -9223372036854775807L) {
                        return;
                    }
                    LiveVideoViewer.this.videoPlayer.seekTo((int) (progress * r0));
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.containerView.getContext()) { // from class: ir.eitaa.ui.LiveVideoViewer.15
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                event.getX();
                event.getY();
                if (LiveVideoViewer.this.videoPlayerSeekbar.onTouch(event.getAction(), event.getX() - AndroidUtilities.dp(12.0f), event.getY())) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    invalidate();
                }
                return true;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                long j = 0;
                if (LiveVideoViewer.this.videoPlayer != null) {
                    long duration = LiveVideoViewer.this.videoPlayer.getDuration();
                    if (duration != -9223372036854775807L) {
                        j = duration;
                    }
                }
                long j2 = j / 1000;
                long j3 = j2 / 60;
                long j4 = j2 % 60;
                LiveVideoViewer.this.videoPlayerSeekbar.setSize((getMeasuredWidth() - AndroidUtilities.dp(28.0f)) - ((int) Math.ceil(LiveVideoViewer.this.videoPlayerTime.getPaint().measureText(String.format("%02d:%02d / %02d:%02d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4))))), getMeasuredHeight());
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                LiveVideoViewer.this.videoPlayerSeekbar.setProgress(LiveVideoViewer.this.videoPlayer != null ? LiveVideoViewer.this.videoPlayer.getCurrentPosition() / LiveVideoViewer.this.videoPlayer.getDuration() : 0.0f);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                canvas.save();
                canvas.translate(AndroidUtilities.dp(12.0f), 0.0f);
                LiveVideoViewer.this.videoPlayerSeekbar.draw(canvas);
                canvas.restore();
            }
        };
        this.videoPlayerControlFrameLayout = frameLayout;
        frameLayout.setWillNotDraw(false);
        this.containerView.addView(this.videoPlayerControlFrameLayout, LayoutHelper.createFrame(-1, 48, 83));
        SimpleTextView simpleTextView = new SimpleTextView(this.containerView.getContext());
        this.videoPlayerTime = simpleTextView;
        simpleTextView.setTextColor(-1);
        this.videoPlayerTime.setGravity(53);
        this.videoPlayerTime.setTextSize(13);
        this.videoPlayerControlFrameLayout.addView(this.videoPlayerTime, LayoutHelper.createFrame(-2, -1.0f, 53, 0.0f, 17.0f, 7.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        Object obj = this.lastInsets;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        return ((WindowInsets) obj).getSystemWindowInsetLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissInternal() {
        try {
            if (this.windowView.getParent() != null) {
                ((LaunchActivity) this.parentActivity).drawerLayoutContainer.setAllowDrawContent(true);
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void toggleActionBar(boolean show, final boolean animated) {
        if (show) {
            this.actionBar.setVisibility(0);
            this.captionTextView.getTag();
        }
        this.isActionBarVisible = show;
        this.actionBar.setEnabled(show);
        this.actionBar.setAlpha(show ? 1.0f : 0.0f);
        if (this.captionTextView.getTag() != null) {
            this.captionTextView.setAlpha(show ? 1.0f : 0.0f);
        }
        if (show) {
            return;
        }
        this.actionBar.setVisibility(8);
        if (this.captionTextView.getTag() != null) {
            this.captionTextView.setVisibility(4);
        }
    }

    private void onPhotoShow() throws Resources.NotFoundException {
        this.currentEditMode = 0;
        this.needCaptionLayout = false;
        this.allowedBehindSegment = 4;
        this.currentManifestIndex = 0L;
        this.containerView.setPadding(0, 0, 0, 0);
        this.captionTextView.setTranslationY(0.0f);
        this.actionBar.setTranslationY(0.0f);
        this.actionBar.setTitleRightMargin(0);
        this.actionBar.setSubtitle(null);
        this.captionTextView.setTag(null);
        this.captionTextView.setVisibility(4);
        this.needCaptionLayout = true;
        setCurrentCaption("write a comment");
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat != null) {
            this.avatarContainer.setChat(tLRPC$Chat);
            this.avatarContainer.setChatAvatar(this.currentChat);
            this.avatarContainer.setTitle(this.currentChat.title);
            this.avatarContainer.setSubtitle("");
        } else {
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User != null) {
                this.avatarContainer.setUser(tLRPC$User);
                this.avatarContainer.setUserAvatar(this.currentUser);
                CommentAvatarContainer commentAvatarContainer = this.avatarContainer;
                TLRPC$User tLRPC$User2 = this.currentUser;
                commentAvatarContainer.setTitle(ContactsController.formatName(tLRPC$User2.first_name, tLRPC$User2.last_name));
                this.avatarContainer.setSubtitle("");
            }
        }
        setVisible(true);
        setState(-1);
    }

    private void setCurrentCaption(final CharSequence caption) throws Resources.NotFoundException {
        ViewParent parent = this.captionTextView.getParent();
        FrameLayoutDrawer frameLayoutDrawer = this.containerView;
        if (parent != frameLayoutDrawer) {
            frameLayoutDrawer.addView(this.captionTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 4.0f, 4.0f, 4.0f, 4.0f));
        }
        this.captionTextView.setSingleLine(false);
        this.captionTextView.setMaxLines(10);
        if (!TextUtils.isEmpty(caption)) {
            Theme.createChatResources(null, true);
            CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(new SpannableStringBuilder(caption.toString()), this.captionTextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            this.captionTextView.setTag(charSequenceReplaceEmoji);
            try {
                this.captionTextView.setText(charSequenceReplaceEmoji);
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.captionTextView.setTextColor(-1);
            this.captionTextView.setAlpha(1.0f);
            return;
        }
        if (this.needCaptionLayout) {
            this.captionTextView.setText("write a comment");
            this.captionTextView.setTag("empty");
            this.captionTextView.setTextColor(-1291845633);
        } else {
            this.captionTextView.setTextColor(-1);
            this.captionTextView.setTag(null);
            this.captionTextView.setVisibility(4);
        }
    }

    public boolean openPhoto(final int chatId, int userId, int messageId) {
        TLRPC$Chat tLRPC$Chat;
        int i = 0;
        if (this.parentActivity == null) {
            return false;
        }
        this.currentUser = null;
        this.currentChat = null;
        if (PipInstance != null) {
            PipInstance.destroyPhotoViewer();
        }
        if (chatId == 0) {
            if (userId != 0) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(userId));
                this.currentUser = user;
                if (user == null) {
                    return false;
                }
                this.dialog_id = user.id;
            }
            return false;
        }
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(chatId));
        this.currentChat = chat;
        if (chat == null) {
            final Semaphore semaphore = new Semaphore(0);
            MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.17
                @Override // java.lang.Runnable
                public void run() {
                    LiveVideoViewer liveVideoViewer = LiveVideoViewer.this;
                    liveVideoViewer.currentChat = MessagesStorage.getInstance(liveVideoViewer.currentAccount).getChat(chatId);
                    semaphore.release();
                }
            });
            try {
                semaphore.acquire();
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (this.currentChat == null) {
                return false;
            }
            MessagesController.getInstance(this.currentAccount).putChat(this.currentChat, true);
        }
        if (chatId > 0) {
            this.dialog_id = -chatId;
        } else {
            this.dialog_id = AndroidUtilities.makeBroadcastId(chatId);
        }
        if (messageId == 0 && (tLRPC$Chat = this.currentChat) != null) {
            this.showGoToMessage = true;
            messageId = tLRPC$Chat.live_stream_msg_id;
        } else {
            this.showGoToMessage = false;
        }
        ActionBarMenuItem actionBarMenuItem = this.headerItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(this.showGoToMessage ? 0 : 8);
        }
        this.msg_id = messageId;
        this.lastInsets = null;
        WindowManager windowManager = (WindowManager) this.parentActivity.getSystemService("window");
        if (this.attachedToWindow) {
            try {
                windowManager.removeView(this.windowView);
            } catch (Exception unused) {
            }
        }
        try {
            WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
            layoutParams.type = 99;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                layoutParams.flags = -2147417848;
            } else {
                layoutParams.flags = 8;
            }
            layoutParams.softInputMode = 272;
            this.windowView.setFocusable(false);
            this.containerView.setFocusable(false);
            windowManager.addView(this.windowView, this.windowLayoutParams);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.emojiLoaded);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.replaceMessagesObjects);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didLoadedMessage);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.playerDidStartPlaying);
            toggleActionBar(true, false);
            if (i2 >= 21) {
                this.windowLayoutParams.flags = -2147417856;
            } else {
                this.windowLayoutParams.flags = 0;
            }
            WindowManager.LayoutParams layoutParams2 = this.windowLayoutParams;
            layoutParams2.softInputMode = 272;
            windowManager.updateViewLayout(this.windowView, layoutParams2);
            this.windowView.setFocusable(true);
            this.containerView.setFocusable(true);
            this.containerView.setAlpha(1.0f);
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.18
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveVideoViewer.this.msg_id != 0) {
                        LiveVideoViewer.this.pollState();
                    }
                    if (LiveVideoViewer.this.statePollRunnable != null) {
                        AndroidUtilities.runOnUIThread(LiveVideoViewer.this.statePollRunnable, 15000L);
                    }
                }
            };
            this.statePollRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 5000L);
            TLRPC$Chat tLRPC$Chat2 = this.currentChat;
            int i3 = tLRPC$Chat2 != null ? (int) tLRPC$Chat2.id : 0;
            TLRPC$User tLRPC$User = this.currentUser;
            int i4 = tLRPC$User != null ? (int) tLRPC$User.id : 0;
            if (tLRPC$Chat2 == null || ChatObject.isChannel(tLRPC$Chat2) || ChatObject.isMegagroup(this.currentChat)) {
                i = i3;
                i3 = i4;
            }
            MediaDataController.getInstance(this.currentAccount).loadMessage(i, i3, this.msg_id, true);
            this.retryRunnable = new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.19
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveVideoViewer.this.videoPlayer != null) {
                        if (LiveVideoViewer.this.read_link == null) {
                            if (LiveVideoViewer.this.alt_read_link != null) {
                                LiveVideoViewer liveVideoViewer = LiveVideoViewer.this;
                                liveVideoViewer.preparePlayer(Uri.parse(liveVideoViewer.alt_read_link));
                                return;
                            }
                            return;
                        }
                        LiveVideoViewer liveVideoViewer2 = LiveVideoViewer.this;
                        liveVideoViewer2.preparePlayer(Uri.parse(liveVideoViewer2.read_link));
                    }
                }
            };
            onPhotoShow();
            return true;
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pollState() {
        MessageObject messageObject = this.messageObject;
        if (messageObject == null || this.pollingState) {
            return;
        }
        this.pollingState = true;
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) messageObject.messageOwner.media;
        TLRPC$TL_Live_getMedia tLRPC$TL_Live_getMedia = new TLRPC$TL_Live_getMedia();
        tLRPC$TL_Live_getMedia.id = tLRPC$TL_messageMediaLiveStream.id;
        tLRPC$TL_Live_getMedia.access_hash = tLRPC$TL_messageMediaLiveStream.access_hash;
        tLRPC$TL_Live_getMedia.flags = 1;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_Live_getMedia, new RequestDelegate() { // from class: ir.eitaa.ui.LiveVideoViewer.20
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, final TLRPC$TL_error error) {
                if (error == null) {
                    final TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream2 = (TLRPC$TL_messageMediaLiveStream) response;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TLRPC$LiveStreamState tLRPC$LiveStreamState = tLRPC$TL_messageMediaLiveStream2.state;
                            if (tLRPC$LiveStreamState instanceof TLRPC$TL_LiveStreamStateEnded) {
                                LiveVideoViewer.this.ended = true;
                                if (LiveVideoViewer.this.state == 3 || LiveVideoViewer.this.state == 6) {
                                    LiveVideoViewer.this.setState(4);
                                }
                            } else if ((tLRPC$LiveStreamState instanceof TLRPC$TL_LiveStreamStateBroadcasting) && (tLRPC$LiveStreamState.flags & 1) != 0) {
                                LiveVideoViewer.this.setState(5);
                            } else if ((tLRPC$LiveStreamState instanceof TLRPC$TL_LiveStreamStateBroadcasting) && (tLRPC$LiveStreamState.flags & 1) == 0 && ((LiveVideoViewer.this.state == 5 || LiveVideoViewer.this.state == 6) && LiveVideoViewer.this.retryRunnable != null)) {
                                LiveVideoViewer.this.retryRunnable.run();
                            }
                            String str = LiveVideoViewer.this.alt_read_link;
                            if (error == null) {
                                TLRPC$LiveStreamState tLRPC$LiveStreamState2 = tLRPC$TL_messageMediaLiveStream2.state;
                                if (tLRPC$LiveStreamState2.isBroadCasting) {
                                    str = tLRPC$LiveStreamState2.liveStream.read_link;
                                }
                            }
                            LiveVideoViewer.this.read_link = str;
                            if (tLRPC$TL_messageMediaLiveStream2.total_viewers >= 0) {
                                LiveVideoViewer.this.avatarContainer.setSubtitle(String.format("%d", Integer.valueOf(tLRPC$TL_messageMediaLiveStream2.total_viewers)));
                            }
                        }
                    });
                }
                LiveVideoViewer.this.pollingState = false;
            }
        });
    }

    public void closePhoto(boolean animated) {
        try {
            AlertDialog alertDialog = this.visibleDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        releasePlayer();
        removeObservers();
        this.isActionBarVisible = false;
        onPhotoClosed();
    }

    private void removeObservers() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.replaceMessagesObjects);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didLoadedMessage);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.playerDidStartPlaying);
    }

    public void destroyPhotoViewer() {
        if (this.parentActivity == null || this.windowView == null) {
            return;
        }
        PipVideoView pipVideoView = this.pipVideoView;
        if (pipVideoView != null) {
            pipVideoView.close();
            this.pipVideoView = null;
        }
        removeObservers();
        releasePlayer();
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeViewImmediate(this.windowView);
            }
            this.windowView = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this == PipInstance) {
            PipInstance = null;
        } else {
            Instance = null;
        }
    }

    private void onPhotoClosed() {
        this.containerView.post(new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (LiveVideoViewer.this.windowView.getParent() != null) {
                        ((WindowManager) LiveVideoViewer.this.parentActivity.getSystemService("window")).removeView(LiveVideoViewer.this.windowView);
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
        AndroidUtilities.cancelRunOnUIThread(this.statePollRunnable);
        this.statePollRunnable = null;
        setVisible(false);
        this.msg_id = 0;
        this.currentUser = null;
        this.currentChat = null;
        this.allowedBehindSegment = 4;
        this.currentManifestIndex = 0L;
        this.ended = false;
        setState(-1);
        setMessageObject(null);
        this.messageMediaLiveStream = null;
        Instance = null;
        PipInstance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAdditionX() {
        int i = this.currentEditMode;
        if (i == 0 || i == 3) {
            return 0;
        }
        return AndroidUtilities.dp(14.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAdditionY() {
        int i = this.currentEditMode;
        if (i == 3) {
            return AndroidUtilities.dp(8.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
        }
        if (i != 0) {
            return AndroidUtilities.dp(14.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerViewWidth() {
        return getContainerViewWidth(this.currentEditMode);
    }

    private int getContainerViewWidth(int mode) {
        int width = this.containerView.getWidth();
        return (mode == 0 || mode == 3) ? width : width - AndroidUtilities.dp(28.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerViewHeight() {
        return getContainerViewHeight(this.currentEditMode);
    }

    private int getContainerViewHeight(int mode) {
        int iDp;
        int i = AndroidUtilities.displaySize.y;
        if (mode == 0 && Build.VERSION.SDK_INT >= 21) {
            i += AndroidUtilities.statusBarHeight;
        }
        if (mode == 1) {
            iDp = AndroidUtilities.dp(144.0f);
        } else if (mode == 2) {
            iDp = AndroidUtilities.dp(214.0f);
        } else {
            if (mode != 3) {
                return i;
            }
            iDp = AndroidUtilities.dp(48.0f) + ActionBar.getCurrentActionBarHeight();
        }
        return i - iDp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePlayer(String playVideoUrl) {
        if (this.parentActivity == null) {
            return;
        }
        releasePlayer();
        if (this.videoTextureView == null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.parentActivity) { // from class: ir.eitaa.ui.LiveVideoViewer.23
                @Override // com.google.android.exoplayer2.ui.AspectRatioFrameLayout, android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    if (LiveVideoViewer.this.textureImageView != null) {
                        ViewGroup.LayoutParams layoutParams = LiveVideoViewer.this.textureImageView.getLayoutParams();
                        layoutParams.width = getMeasuredWidth();
                        layoutParams.height = getMeasuredHeight();
                    }
                }
            };
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            aspectRatioFrameLayout.setVisibility(4);
            this.containerView.addView(this.aspectRatioFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
            TextureView textureView = new TextureView(this.parentActivity);
            this.videoTextureView = textureView;
            textureView.setPivotX(0.0f);
            this.videoTextureView.setPivotY(0.0f);
            this.videoTextureView.setOpaque(false);
            this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1, 17));
        }
        this.videoTextureView.setAlpha(1.0f);
        if (Build.VERSION.SDK_INT >= 21 && this.textureImageView == null) {
            ImageView imageView = new ImageView(this.parentActivity);
            this.textureImageView = imageView;
            imageView.setBackgroundColor(-65536);
            this.textureImageView.setPivotX(0.0f);
            this.textureImageView.setPivotY(0.0f);
            this.textureImageView.setVisibility(4);
            this.containerView.addView(this.textureImageView);
        }
        this.textureUploaded = false;
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = new VideoPlayer();
            this.videoPlayer = videoPlayer;
            videoPlayer.setTextureView(this.videoTextureView);
            this.videoPlayer.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: ir.eitaa.ui.LiveVideoViewer.24
                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
                    VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
                    VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
                    VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onStateChanged(boolean playWhenReady, int playbackState) {
                    if (LiveVideoViewer.this.videoPlayer == null) {
                        return;
                    }
                    if (LiveVideoViewer.this.state != 6) {
                        if (playbackState == 2 && (LiveVideoViewer.this.state == 1 || LiveVideoViewer.this.state == -1)) {
                            LiveVideoViewer.this.setState(2);
                        }
                        if (playbackState == 4 && (LiveVideoViewer.this.messageMediaLiveStream == null || !LiveVideoViewer.this.messageMediaLiveStream.state.isArchived)) {
                            if (LiveVideoViewer.this.ended) {
                                LiveVideoViewer.this.setState(4);
                            } else {
                                LiveVideoViewer.this.setState(5);
                            }
                        }
                        if (playbackState == 3) {
                            LiveVideoViewer.this.setState(1);
                            if (LiveVideoViewer.this.aspectRatioFrameLayout.getVisibility() != 0) {
                                LiveVideoViewer.this.aspectRatioFrameLayout.setVisibility(0);
                            }
                        }
                    }
                    if (!LiveVideoViewer.this.videoPlayer.isPlaying() || playbackState == 4) {
                        if (LiveVideoViewer.this.isPlaying) {
                            LiveVideoViewer.this.isPlaying = false;
                            AndroidUtilities.cancelRunOnUIThread(LiveVideoViewer.this.updateProgressRunnable);
                        }
                    } else if (!LiveVideoViewer.this.isPlaying) {
                        LiveVideoViewer.this.isPlaying = true;
                        AndroidUtilities.runOnUIThread(LiveVideoViewer.this.updateProgressRunnable);
                    }
                    if (!playWhenReady || playbackState == 4 || playbackState == 1) {
                        try {
                            if (LiveVideoViewer.this.windowView != null) {
                                LiveVideoViewer.this.windowView.setKeepScreenOn(false);
                            }
                            LiveVideoViewer.this.parentActivity.getWindow().clearFlags(128);
                            LiveVideoViewer.this.keepScreenOnFlagSet = false;
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    try {
                        if (LiveVideoViewer.this.windowView != null) {
                            LiveVideoViewer.this.windowView.setKeepScreenOn(true);
                        }
                        LiveVideoViewer.this.parentActivity.getWindow().addFlags(128);
                        LiveVideoViewer.this.keepScreenOnFlagSet = true;
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onError(VideoPlayer player, Exception e) {
                    if (e.getCause() instanceof BehindLiveWindowException) {
                        LiveVideoViewer.this.setState(2);
                        if (LiveVideoViewer.this.retryRunnable != null) {
                            LiveVideoViewer.this.retryRunnable.run();
                        }
                    }
                    if (!(e.getCause() instanceof HlsPlaylistTracker.PlaylistStuckException) || LiveVideoViewer.this.state == 5) {
                        AndroidUtilities.runOnUIThread(LiveVideoViewer.this.retryRunnable, 5000L);
                        LiveVideoViewer.this.failedMessage = e.getCause().getMessage();
                        LiveVideoViewer.this.setState(3);
                        FileLog.e(e);
                        return;
                    }
                    LiveVideoViewer.this.setState(6);
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
                    if (LiveVideoViewer.this.aspectRatioFrameLayout != null) {
                        if (unappliedRotationDegrees != 90 && unappliedRotationDegrees != 270) {
                            height = width;
                            width = height;
                        }
                        LiveVideoViewer.this.aspectRatioFrameLayout.setAspectRatio(width == 0 ? 1.0f : (height * pixelWidthHeightRatio) / width, unappliedRotationDegrees);
                    }
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onRenderedFirstFrame() {
                    if (LiveVideoViewer.this.textureUploaded) {
                        return;
                    }
                    LiveVideoViewer.this.textureUploaded = true;
                    LiveVideoViewer.this.containerView.invalidate();
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public boolean onSurfaceDestroyed(SurfaceTexture surface) {
                    if (LiveVideoViewer.this.changingTextureView) {
                        LiveVideoViewer.this.changingTextureView = false;
                        if (LiveVideoViewer.this.isInline) {
                            LiveVideoViewer.this.waitingForFirstTextureUpload = 1;
                            LiveVideoViewer.this.changedTextureView.setSurfaceTexture(surface);
                            LiveVideoViewer.this.changedTextureView.setSurfaceTextureListener(LiveVideoViewer.this.surfaceTextureListener);
                            LiveVideoViewer.this.changedTextureView.setVisibility(0);
                            return true;
                        }
                    }
                    return false;
                }

                @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    if (LiveVideoViewer.this.waitingForFirstTextureUpload == 2) {
                        if (LiveVideoViewer.this.textureImageView != null) {
                            LiveVideoViewer.this.textureImageView.setVisibility(4);
                            LiveVideoViewer.this.textureImageView.setImageDrawable(null);
                            if (LiveVideoViewer.this.currentBitmap != null) {
                                LiveVideoViewer.this.currentBitmap.recycle();
                                LiveVideoViewer.this.currentBitmap = null;
                            }
                        }
                        LiveVideoViewer.this.switchingInlineMode = false;
                        if (Build.VERSION.SDK_INT >= 21) {
                            int[] iArr = new int[2];
                            LiveVideoViewer.this.aspectRatioFrameLayout.getLocationInWindow(iArr);
                            iArr[0] = iArr[0] - LiveVideoViewer.this.getLeftInset();
                            iArr[1] = (int) (iArr[1] - LiveVideoViewer.this.containerView.getTranslationY());
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(ObjectAnimator.ofFloat(LiveVideoViewer.this.textureImageView, "scaleX", 1.0f), ObjectAnimator.ofFloat(LiveVideoViewer.this.textureImageView, "scaleY", 1.0f), ObjectAnimator.ofFloat(LiveVideoViewer.this.textureImageView, "translationX", iArr[0]), ObjectAnimator.ofFloat(LiveVideoViewer.this.textureImageView, "translationY", iArr[1]), ObjectAnimator.ofFloat(LiveVideoViewer.this.videoTextureView, "scaleX", 1.0f), ObjectAnimator.ofFloat(LiveVideoViewer.this.videoTextureView, "scaleY", 1.0f), ObjectAnimator.ofFloat(LiveVideoViewer.this.videoTextureView, "translationX", iArr[0] - LiveVideoViewer.this.aspectRatioFrameLayout.getX()), ObjectAnimator.ofFloat(LiveVideoViewer.this.videoTextureView, "translationY", iArr[1] - LiveVideoViewer.this.aspectRatioFrameLayout.getY()), ObjectAnimator.ofInt(LiveVideoViewer.this.backgroundDrawable, "alpha", 255), ObjectAnimator.ofFloat(LiveVideoViewer.this.actionBar, "alpha", 1.0f), ObjectAnimator.ofFloat(LiveVideoViewer.this.progressBar, "alpha", 1.0f), ObjectAnimator.ofFloat(LiveVideoViewer.this.stateTextView, "alpha", 1.0f));
                            animatorSet.setInterpolator(new DecelerateInterpolator());
                            animatorSet.setDuration(250L);
                            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.LiveVideoViewer.24.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
                                    LiveVideoViewer.this.pipAnimationInProgress = false;
                                }
                            });
                            animatorSet.start();
                        }
                        LiveVideoViewer.this.waitingForFirstTextureUpload = 0;
                    }
                }
            });
        }
        preparePlayer(Uri.parse(playVideoUrl));
    }

    private void releasePlayer() {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.releasePlayer(true);
            this.videoPlayer = null;
        }
        if (this.keepScreenOnFlagSet) {
            try {
                FrameLayout frameLayout = this.windowView;
                if (frameLayout != null) {
                    frameLayout.setKeepScreenOn(false);
                }
                this.parentActivity.getWindow().clearFlags(128);
                this.keepScreenOnFlagSet = false;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        if (this.isPlaying) {
            this.isPlaying = false;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            this.containerView.removeView(aspectRatioFrameLayout);
            this.aspectRatioFrameLayout = null;
        }
        if (this.videoTextureView != null) {
            this.videoTextureView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int newState) {
        int i = this.state;
        if (i != newState) {
            if (i != 4 || newState == -1) {
                this.stateTextView.setVisibility(4);
                this.progressBar.setVisibility(4);
                this.videoPlayerControlFrameLayout.setVisibility(8);
                MessageObject messageObject = this.messageObject;
                if (messageObject != null && ((TLRPC$TL_messageMediaLiveStream) messageObject.messageOwner.media).state.isArchived) {
                    this.videoPlayerControlFrameLayout.setVisibility(0);
                }
                switch (newState) {
                    case 1:
                        this.progressBar.setVisibility(4);
                        this.stateTextView.setVisibility(4);
                        break;
                    case 2:
                        this.progressBar.setVisibility(0);
                        break;
                    case 3:
                        this.stateTextView.setVisibility(0);
                        if (this.state == 2 && this.ended) {
                            this.stateTextView.setText(LocaleController.getString("LiveStreamStopped", R.string.LiveStreamStopped));
                            newState = 4;
                            break;
                        } else {
                            this.stateTextView.setText("پخش زنده با خطا مواجه شد\nدر حال تلاش مجدد...\n");
                            break;
                        }
                        break;
                    case 4:
                        this.stateTextView.setVisibility(0);
                        this.stateTextView.setText(LocaleController.getString("LiveStreamStopped", R.string.LiveStreamStopped));
                        break;
                    case 5:
                        this.stateTextView.setVisibility(0);
                        this.stateTextView.setText(LocaleController.getString("LiveStreamPaused", R.string.LiveStreamPaused));
                        break;
                    case 6:
                        this.progressBar.setVisibility(0);
                        break;
                    default:
                        this.stateTextView.setText((CharSequence) null);
                        this.progressBar.setVisibility(0);
                        break;
                }
                this.state = newState;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePlayer(Uri uri) {
        String str = "rtmp".equals(uri.getScheme()) ? "rtmp" : "other";
        String queryParameter = uri.getQueryParameter("type");
        if (queryParameter != null && queryParameter.length() > 0) {
            str = queryParameter;
        }
        this.videoPlayer.setPlayWhenReady(this.state != 6);
        this.videoPlayer.preparePlayer(uri, str);
        this.videoPlayer.addListener(new Player.EventListener() { // from class: ir.eitaa.ui.LiveVideoViewer.25
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsPlayingChanged(boolean z) {
                Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onLoadingChanged(boolean isLoading) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerError(ExoPlaybackException error) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPositionDiscontinuity(int reason) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onRepeatModeChanged(int repeatMode) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onSeekProcessed() {
            }

            /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
                if (manifest instanceof HlsManifest) {
                    HlsManifest hlsManifest = (HlsManifest) manifest;
                    List<HlsMediaPlaylist.Segment> list = hlsManifest.mediaPlaylist.segments;
                    long size = list.size() | (hlsManifest.mediaPlaylist.mediaSequence << 32);
                    long currentPosition = LiveVideoViewer.this.videoPlayer.getCurrentPosition() * 1000;
                    int i = -1;
                    int size2 = list.size();
                    long j = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            break;
                        }
                        j += list.get(i2).durationUs;
                        if (currentPosition <= j) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                    if (i >= 0 && size2 > 5) {
                        Log.v("hlsmanifestreason", "mediaSequence " + hlsManifest.mediaPlaylist.mediaSequence);
                        Log.v("hlsmanifestreason", "currentsegment " + i);
                        Log.v("hlsmanifestreason", "totalsegment " + list.size());
                        Log.v("hlsmanifestreason", "currentPosition " + LiveVideoViewer.this.videoPlayer.getCurrentPosition());
                        Log.v("hlsmanifestreason", "totalduration " + LiveVideoViewer.this.videoPlayer.getDuration());
                        if (i < size2 - LiveVideoViewer.this.allowedBehindSegment) {
                            LiveVideoViewer.access$5704(LiveVideoViewer.this);
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                }
                            });
                        }
                    }
                    if (LiveVideoViewer.this.currentManifestIndex != size || LiveVideoViewer.this.state != 6) {
                        if (LiveVideoViewer.this.state == 6) {
                            LiveVideoViewer.this.setState(2);
                            LiveVideoViewer.this.videoPlayer.setPlayWhenReady(true);
                        }
                    } else {
                        LiveVideoViewer.this.videoPlayer.setPlayWhenReady(false);
                    }
                    LiveVideoViewer.this.currentManifestIndex = size;
                }
            }
        });
    }

    /* renamed from: ir.eitaa.ui.LiveVideoViewer$26, reason: invalid class name */
    class AnonymousClass26 implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        }

        AnonymousClass26() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            if (LiveVideoViewer.this.videoTextureView == null || !LiveVideoViewer.this.changingTextureView) {
                return true;
            }
            if (LiveVideoViewer.this.switchingInlineMode) {
                LiveVideoViewer.this.waitingForFirstTextureUpload = 2;
            }
            LiveVideoViewer.this.videoTextureView.setSurfaceTexture(surface);
            LiveVideoViewer.this.videoTextureView.setVisibility(0);
            LiveVideoViewer.this.changingTextureView = false;
            LiveVideoViewer.this.containerView.invalidate();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (LiveVideoViewer.this.waitingForFirstTextureUpload == 1) {
                LiveVideoViewer.this.changedTextureView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.LiveVideoViewer.26.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        LiveVideoViewer.this.changedTextureView.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (LiveVideoViewer.this.textureImageView != null) {
                            LiveVideoViewer.this.textureImageView.setVisibility(4);
                            LiveVideoViewer.this.textureImageView.setImageDrawable(null);
                            if (LiveVideoViewer.this.currentBitmap != null) {
                                LiveVideoViewer.this.currentBitmap.recycle();
                                LiveVideoViewer.this.currentBitmap = null;
                            }
                        }
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.26.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveVideoViewer.this.isInline) {
                                    LiveVideoViewer.this.dismissInternal();
                                }
                            }
                        });
                        return true;
                    }
                });
                LiveVideoViewer.this.waitingForFirstTextureUpload = 0;
                LiveVideoViewer.this.changedTextureView.invalidate();
            }
        }
    }

    public void switchToPip() {
        if (this.videoPlayer == null || !this.textureUploaded || !checkInlinePermissions() || this.aspectRatioFrameLayout == null || this.changingTextureView || this.switchingInlineMode || this.isInline) {
            return;
        }
        if (PipInstance != null) {
            PipInstance.destroy();
        }
        PipInstance = Instance;
        Instance = null;
        this.switchingInlineMode = true;
        setVisible(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.pipAnimationInProgress = true;
            Rect pipRect = PipVideoView.getPipRect(this.aspectRatioFrameLayout.getAspectRatio());
            float width = pipRect.width / this.videoTextureView.getWidth();
            pipRect.y += AndroidUtilities.statusBarHeight;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.textureImageView, "scaleX", width), ObjectAnimator.ofFloat(this.textureImageView, "scaleY", width), ObjectAnimator.ofFloat(this.textureImageView, "translationX", pipRect.x), ObjectAnimator.ofFloat(this.textureImageView, "translationY", pipRect.y), ObjectAnimator.ofFloat(this.videoTextureView, "scaleX", width), ObjectAnimator.ofFloat(this.videoTextureView, "scaleY", width), ObjectAnimator.ofFloat(this.videoTextureView, "translationX", pipRect.x - this.aspectRatioFrameLayout.getX()), ObjectAnimator.ofFloat(this.videoTextureView, "translationY", pipRect.y - this.aspectRatioFrameLayout.getY()), ObjectAnimator.ofInt(this.backgroundDrawable, "alpha", 0), ObjectAnimator.ofFloat(this.actionBar, "alpha", 0.0f), ObjectAnimator.ofFloat(this.progressBar, "alpha", 0.0f), ObjectAnimator.ofFloat(this.stateTextView, "alpha", 0.0f));
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.setDuration(250L);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.LiveVideoViewer.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    LiveVideoViewer.this.pipAnimationInProgress = false;
                    LiveVideoViewer.this.switchToInlineRunnable.run();
                }
            });
            animatorSet.start();
            return;
        }
        this.switchToInlineRunnable.run();
        dismissInternal();
    }

    @Override // ir.eitaa.ui.Components.Pipable
    public void exitFromPip() {
        if (this.isInline) {
            Instance = PipInstance;
            PipInstance = null;
            this.isInline = false;
            this.switchingInlineMode = true;
            Bitmap bitmap = this.currentBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.currentBitmap = null;
            }
            this.changingTextureView = true;
            this.isInline = false;
            this.videoTextureView.setVisibility(4);
            this.aspectRatioFrameLayout.addView(this.videoTextureView);
            if (ApplicationLoader.mainInterfacePaused) {
                try {
                    this.parentActivity.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) BringAppForegroundService.class));
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.pipAnimationInProgress = true;
                Rect pipRect = PipVideoView.getPipRect(this.aspectRatioFrameLayout.getAspectRatio());
                float f = pipRect.width / this.textureImageView.getLayoutParams().width;
                pipRect.y += AndroidUtilities.statusBarHeight;
                this.textureImageView.setScaleX(f);
                this.textureImageView.setScaleY(f);
                this.textureImageView.setTranslationX(pipRect.x);
                this.textureImageView.setTranslationY(pipRect.y);
                this.videoTextureView.setScaleX(f);
                this.videoTextureView.setScaleY(f);
                this.videoTextureView.setTranslationX(pipRect.x - this.aspectRatioFrameLayout.getX());
                this.videoTextureView.setTranslationY(pipRect.y - this.aspectRatioFrameLayout.getY());
            } else {
                this.pipVideoView.close();
                this.pipVideoView = null;
            }
            try {
                setVisible(true);
                ((WindowManager) this.parentActivity.getSystemService("window")).addView(this.windowView, this.windowLayoutParams);
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.waitingForDraw = 4;
            }
        }
    }

    private void setVisible(boolean set) {
        this.isVisible = set;
        if (set) {
            this.prevOrientation = this.parentActivity.getRequestedOrientation();
            this.parentActivity.setRequestedOrientation(1);
        } else {
            this.parentActivity.setRequestedOrientation(this.prevOrientation);
        }
    }

    @Override // ir.eitaa.ui.Components.Pipable
    public void destroy() {
        destroyPhotoViewer();
    }

    private void setMessageObject(MessageObject messageObject) {
        TLRPC$User user;
        TLRPC$Peer tLRPC$Peer;
        this.messageObject = messageObject;
        TLRPC$Chat chat = null;
        if (messageObject == null) {
            this.messageMediaLiveStream = null;
            this.alt_read_link = null;
            this.read_link = null;
            return;
        }
        if (messageObject.isForwarded() && this.avatarContainer != null) {
            MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = messageObject.messageOwner.fwd_from;
            UserConfig.getInstance(this.currentAccount).getClientUserId();
            if (tLRPC$MessageFwdHeader != null && tLRPC$MessageFwdHeader.from_id.channel_id != 0) {
                user = null;
                chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(tLRPC$MessageFwdHeader.from_id.channel_id));
            } else {
                user = (tLRPC$MessageFwdHeader == null || (tLRPC$Peer = tLRPC$MessageFwdHeader.from_id) == null) ? null : messagesController.getUser(Long.valueOf(tLRPC$Peer.user_id));
            }
            if (chat != null) {
                this.avatarContainer.setChat(chat);
                this.avatarContainer.setChatAvatar(chat);
                this.avatarContainer.setTitle(chat.title);
            } else if (user != null) {
                this.avatarContainer.setUser(user);
                this.avatarContainer.setUserAvatar(user);
                this.avatarContainer.setTitle(ContactsController.formatName(user.first_name, user.last_name));
            }
        }
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message != null) {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaLiveStream) {
                this.messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) tLRPC$MessageMedia;
            }
        }
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = this.messageMediaLiveStream;
        if (tLRPC$TL_messageMediaLiveStream != null) {
            TLRPC$LiveStreamState tLRPC$LiveStreamState = tLRPC$TL_messageMediaLiveStream.state;
            if (tLRPC$LiveStreamState.isBroadCasting) {
                this.alt_read_link = tLRPC$LiveStreamState.liveStream.read_link;
            }
        }
    }

    public boolean checkInlinePermissions() {
        Activity activity = this.parentActivity;
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)) {
            return true;
        }
        new AlertDialog.Builder(this.parentActivity).setTitle(LocaleController.getString("AppName", R.string.AppName)).setMessage(LocaleController.getString("PermissionDrawAboveOtherApps", R.string.PermissionDrawAboveOtherApps)).setPositiveButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.LiveVideoViewer.28
            @Override // android.content.DialogInterface.OnClickListener
            @TargetApi(23)
            public void onClick(DialogInterface dialog, int which) {
                if (LiveVideoViewer.this.parentActivity != null) {
                    LiveVideoViewer.this.parentActivity.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + LiveVideoViewer.this.parentActivity.getPackageName())));
                }
            }
        }).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showParticipants() {
        if (this.messageObject == null) {
            return;
        }
        final boolean[] zArr = new boolean[1];
        Activity activity = this.parentActivity;
        BottomSheet.Builder builder = new BottomSheet.Builder(activity);
        builder.setUseHardwareLayer(false);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        builder.setCustomView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setLayoutParams(LayoutHelper.createLinear(-1, -2));
        linearLayout.addView(frameLayout);
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(new BackDrawable(true));
        TextView textView = new TextView(activity);
        textView.setLines(1);
        textView.setSingleLine(true);
        textView.setText(LocaleController.getString("LiveParticipantsTitle", R.string.LiveParticipantsTitle));
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(21.0f), AndroidUtilities.dp(4.0f));
        textView.setGravity(17);
        frameLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.LiveVideoViewer.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        final EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(activity);
        emptyTextProgressView.setText(LocaleController.getString("LiveParticipantsNoOne", R.string.LiveParticipantsNoOne));
        emptyTextProgressView.showProgress();
        emptyTextProgressView.setShowAtCenter(true);
        linearLayout.addView(emptyTextProgressView, LayoutHelper.createLinear(-1, 80));
        final RecyclerListView recyclerListView = new RecyclerListView(activity) { // from class: ir.eitaa.ui.LiveVideoViewer.30
        };
        recyclerListView.setEmptyView(emptyTextProgressView);
        recyclerListView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-1, -2));
        final ArrayList arrayList = new ArrayList();
        recyclerListView.setAdapter(new RecyclerView.Adapter() { // from class: ir.eitaa.ui.LiveVideoViewer.31

            /* renamed from: ir.eitaa.ui.LiveVideoViewer$31$Holder */
            class Holder extends RecyclerView.ViewHolder {
                public Holder(View itemView) {
                    super(itemView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Holder(new ProfileSearchCell(parent.getContext()));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ProfileSearchCell profileSearchCell = (ProfileSearchCell) holder.itemView;
                profileSearchCell.useSeparator = position != getItemCount() - 1;
                profileSearchCell.setData((TLObject) arrayList.get(position), null, null, LocaleController.getString("Online", R.string.Online), false, false);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return arrayList.size();
            }
        });
        final BottomSheet bottomSheetShow = builder.show();
        bottomSheetShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.LiveVideoViewer.32
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialog) {
                zArr[0] = true;
            }
        });
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) this.messageObject.messageOwner.media;
        TLRPC$TL_Live_getParticipants tLRPC$TL_Live_getParticipants = new TLRPC$TL_Live_getParticipants();
        tLRPC$TL_Live_getParticipants.id = tLRPC$TL_messageMediaLiveStream.id;
        tLRPC$TL_Live_getParticipants.access_hash = tLRPC$TL_messageMediaLiveStream.access_hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_Live_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.LiveVideoViewer.33
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, TLRPC$TL_error error) {
                if (error == null) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LiveVideoViewer.33.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass33 anonymousClass33 = AnonymousClass33.this;
                            if (zArr[0]) {
                                return;
                            }
                            emptyTextProgressView.showTextView();
                            arrayList.clear();
                            arrayList.addAll(((TLRPC$TL_Live_participants) response).users);
                            recyclerListView.getAdapter().notifyDataSetChanged();
                        }
                    });
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.LiveVideoViewer.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                bottomSheetShow.dismiss();
            }
        });
    }
}
