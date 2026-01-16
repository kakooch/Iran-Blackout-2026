package ir.eitaa.helper.live;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.material.snackbar.Snackbar;
import io.antmedia.android.broadcaster.ILiveVideoBroadcaster;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import ir.eitaa.helper.live.LiveHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Components.ChatCommentCell;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.FadingEdgeLayout;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PhotoViewerCaptionEnterView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class LiveVideoBroadcasterActivity extends Activity {
    private static final String TAG = LiveVideoBroadcasterActivity.class.getSimpleName();
    private View backButton;
    private LinearLayout bottomButtons;
    private PhotoViewerCaptionEnterView captionEditText;
    private TextView captionTextView;
    private TextView centeredButton;
    private ChatActivityAdapter chatAdapter;
    private LinearLayoutManager chatLayoutManager;
    private RecyclerListView chatListView;
    private LinearLayout closeButtonsLinear;
    private TextView connectionLog;
    private SizeNotifierFrameLayoutPhoto containerView;
    private CharSequence finalCaption;
    private ObjectAnimator hintAnimation;
    private TextView hintTextView;
    private LiveHelper.LiveHelperDelegate liveHelperDelegate;
    private TextView liveTextView;
    private FrameLayout liveTextViewContainer;
    private ServiceConnection mConnection;
    private long mElapsedTime;
    private GLSurfaceView mGLView;
    private LiveVideoBroadcaster mLiveVideoBroadcaster;
    private Intent mLiveVideoBroadcasterServiceIntent;
    private OrientationEventListener mOrientationListener;
    private Timer mTimer;
    public TimerHandler mTimerHandler;
    private int maxVideoWidth;
    private ImageView micToggle;
    private RadialProgressView progressBar;
    private ImageView qualityImageView;
    private RadioGroup qualityRadioGroup;
    private TextView signalBarText;
    private int signalBarsCount;
    private TextView stateTextView;
    private AspectRatioFrameLayout surfaceViewFrame;
    private ImageView switchCameraButton;
    private TextView timerTextView;
    private TextView totalViewerTextView;
    private TextView videoMuteTextView;
    private ImageView videoToggle;
    private int videoWidth;
    private long dialogId = 0;
    private int messageId = 0;
    boolean mIsStreaming = false;
    private int failedResult = 0;
    boolean mIsMuted = false;
    boolean mIsVideoMuted = false;
    protected ArrayList<MessageObject> messages = new ArrayList<>();
    private boolean bottomTouchEnabled = true;
    private int cameraId = 1;
    private boolean isMicEnabled = true;
    private boolean hasPipEnabled = false;
    private LiveHelper liveHelper = new LiveHelper();
    private boolean resumed = false;
    private int currentState = -10;

    public LiveVideoBroadcasterActivity() {
        int i = MessagesController.getInstance(UserConfig.selectedAccount).liveStreamConfig.maxVideoWidth;
        this.maxVideoWidth = i;
        this.videoWidth = i;
        this.signalBarsCount = 0;
        this.mConnection = new AnonymousClass1();
        this.liveHelperDelegate = new LiveHelper.LiveHelperDelegate() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.2
            @Override // ir.eitaa.helper.live.LiveHelper.LiveHelperDelegate
            public void onStateChanged(int newState) throws IllegalStateException, InterruptedException {
                LiveVideoBroadcasterActivity.this.setState(newState);
            }

            @Override // ir.eitaa.helper.live.LiveHelper.LiveHelperDelegate
            public void onNewTotalViewers(int totalViewers) {
                if (LiveVideoBroadcasterActivity.this.totalViewerTextView != null) {
                    LiveVideoBroadcasterActivity.this.totalViewerTextView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(totalViewers)));
                }
            }

            @Override // ir.eitaa.helper.live.LiveHelper.LiveHelperDelegate
            public void onMessageReceivedByServer(int messageId) {
                LiveVideoBroadcasterActivity.this.messageId = messageId;
            }

            @Override // ir.eitaa.helper.live.LiveHelper.LiveHelperDelegate
            public void onNewMessage(MessageObject messageObject) {
                if ((messageObject.messageOwner.flags & 32768) != 0) {
                    return;
                }
                LiveVideoBroadcasterActivity.this.messages.add(messageObject);
                LiveVideoBroadcasterActivity.this.chatAdapter.notifyItemInserted(LiveVideoBroadcasterActivity.this.messages.size() - 1);
                LiveVideoBroadcasterActivity.this.scrollToLastMessage();
            }
        };
    }

    static /* synthetic */ long access$3214(LiveVideoBroadcasterActivity liveVideoBroadcasterActivity, long j) {
        long j2 = liveVideoBroadcasterActivity.mElapsedTime + j;
        liveVideoBroadcasterActivity.mElapsedTime = j2;
        return j2;
    }

    /* renamed from: ir.eitaa.helper.live.LiveVideoBroadcasterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            LiveVideoBroadcaster.LocalBinder localBinder = (LiveVideoBroadcaster.LocalBinder) service;
            if (LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster == null) {
                LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster = (LiveVideoBroadcaster) localBinder.getService();
                LiveVideoBroadcaster liveVideoBroadcaster = LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster;
                LiveVideoBroadcasterActivity liveVideoBroadcasterActivity = LiveVideoBroadcasterActivity.this;
                liveVideoBroadcaster.init(liveVideoBroadcasterActivity, liveVideoBroadcasterActivity.mGLView);
                LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.setMaxVideoWidth(LiveVideoBroadcasterActivity.this.videoWidth);
                LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.setAdaptiveStreaming(true);
                LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.setDelegate(new LiveVideoBroadcaster.Delegate() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.1.1
                    int totalFrame = 0;

                    @Override // io.antmedia.android.broadcaster.LiveVideoBroadcaster.Delegate
                    public void onPreviewSizeChanged(final int width, final int height) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LiveVideoBroadcasterActivity.this.surfaceViewFrame != null) {
                                    LiveVideoBroadcasterActivity.this.surfaceViewFrame.setAspectRatio(height / width, 0);
                                    LiveVideoBroadcasterActivity.this.surfaceViewFrame.invalidate();
                                }
                            }
                        });
                    }

                    @Override // io.antmedia.android.broadcaster.LiveVideoBroadcaster.Delegate
                    public void onNewFrameAvailable() throws InterruptedException {
                        int i = this.totalFrame + 1;
                        this.totalFrame = i;
                        if (i <= 5 || !LiveVideoBroadcasterActivity.this.resumed) {
                            return;
                        }
                        LiveVideoBroadcasterActivity.this.resumed = false;
                        if (LiveVideoBroadcasterActivity.this.messageId == 0) {
                            LiveVideoBroadcasterActivity.this.liveHelper.onReady();
                        } else {
                            LiveVideoBroadcasterActivity.this.liveHelper.resume(LiveVideoBroadcasterActivity.this.messageId);
                        }
                    }

                    @Override // io.antmedia.android.broadcaster.LiveVideoBroadcaster.Delegate
                    public void onVideoMuted(final boolean muted, boolean fromUser) {
                        if (!fromUser && LiveVideoBroadcasterActivity.this.videoMuteTextView != null) {
                            LiveVideoBroadcasterActivity.this.videoMuteTextView.post(new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveVideoBroadcasterActivity.this.videoMuteTextView.setVisibility(muted ? 0 : 4);
                                }
                            });
                        }
                        if (!fromUser && LiveVideoBroadcasterActivity.this.videoToggle != null) {
                            LiveVideoBroadcasterActivity.this.videoToggle.post(new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.1.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveVideoBroadcasterActivity.this.videoToggle.setEnabled(!muted);
                                }
                            });
                        }
                        if (LiveVideoBroadcasterActivity.this.switchCameraButton != null) {
                            LiveVideoBroadcasterActivity.this.switchCameraButton.post(new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.1.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    LiveVideoBroadcasterActivity.this.switchCameraButton.setEnabled(!muted);
                                }
                            });
                        }
                    }
                });
            }
            LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.openCamera(LiveVideoBroadcasterActivity.this.cameraId);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName arg0) {
            LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster = null;
        }
    }

    public class ChatActivityAdapter extends RecyclerView.Adapter {
        public ChatActivityAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ChatCommentCell chatCommentCell = new ChatCommentCell(parent.getContext());
            chatCommentCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(chatCommentCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ChatCommentCell) holder.itemView).setMessageObject(LiveVideoBroadcasterActivity.this.messages.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LiveVideoBroadcasterActivity.this.messages.size();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(128);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(-16777216);
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.dialogId = intent.getLongExtra("dialog_id", 0L);
            this.messageId = intent.getIntExtra("msg_id", 0);
        }
        if (this.messageId != 0) {
            this.cameraId = getSharedPreferences("live-record-config", 0).getInt("cameraFacing", this.cameraId);
        } else {
            this.cameraId = 1;
        }
        Intent intent2 = new Intent(this, (Class<?>) LiveVideoBroadcaster.class);
        this.mLiveVideoBroadcasterServiceIntent = intent2;
        startService(intent2);
        this.liveHelper.setDelegate(this.liveHelperDelegate);
        this.liveHelper.registerNotifications();
        this.hasPipEnabled = getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        createView();
        setContentView(this.containerView);
        this.mTimerHandler = new TimerHandler(this, null);
        checkScreenRotation();
    }

    private void createView() {
        SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto = new SizeNotifierFrameLayoutPhoto(this, false) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.3
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (LiveVideoBroadcasterActivity.this.captionEditText != null) {
                    if (LiveVideoBroadcasterActivity.this.captionEditText.isPopupShowing() || LiveVideoBroadcasterActivity.this.captionEditText.getEmojiPadding() != 0 || ((!AndroidUtilities.usingHardwareInput || LiveVideoBroadcasterActivity.this.captionEditText.getTag() != null) && getKeyboardHeight() > 0)) {
                        if (child != LiveVideoBroadcasterActivity.this.captionEditText && child != LiveVideoBroadcasterActivity.this.surfaceViewFrame && !LiveVideoBroadcasterActivity.this.captionEditText.isPopupView(child)) {
                            return true;
                        }
                        LiveVideoBroadcasterActivity.this.bottomTouchEnabled = false;
                        return super.drawChild(canvas, child, drawingTime);
                    }
                    LiveVideoBroadcasterActivity.this.bottomTouchEnabled = true;
                    if (child == LiveVideoBroadcasterActivity.this.captionEditText) {
                        return false;
                    }
                    return super.drawChild(canvas, child, drawingTime);
                }
                return super.drawChild(canvas, child, drawingTime);
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00ab  */
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
                /*
                    Method dump skipped, instructions count: 221
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.AnonymousClass3.onLayout(boolean, int, int, int, int):void");
            }
        };
        this.containerView = sizeNotifierFrameLayoutPhoto;
        sizeNotifierFrameLayoutPhoto.setWithoutWindow(true);
        this.containerView.setFocusable(false);
        this.containerView.setKeepScreenOn(true);
        this.containerView.setClipChildren(false);
        this.containerView.setClipToPadding(false);
        this.containerView.setBackgroundColor(-16777216);
        if (Build.VERSION.SDK_INT >= 21) {
            this.containerView.setFitsSystemWindows(true);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this);
        this.surfaceViewFrame = aspectRatioFrameLayout;
        this.containerView.addView(aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this);
        this.mGLView = gLSurfaceView;
        gLSurfaceView.setVisibility(8);
        this.mGLView.setEGLContextClientVersion(2);
        this.mGLView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.4
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.v("mGlView", "width: " + width + " height: " + height);
            }
        });
        this.surfaceViewFrame.addView(this.mGLView, LayoutHelper.createFrame(-1, -1, 17));
        this.mGLView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.5
            ObjectAnimator animator;

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LiveVideoBroadcasterActivity.this.currentState == 5) {
                    ObjectAnimator objectAnimator = this.animator;
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                    }
                    if (LiveVideoBroadcasterActivity.this.chatListView.getVisibility() == 0) {
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.chatListView, "alpha", 0.0f);
                        this.animator = objectAnimatorOfFloat;
                        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.5.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                LiveVideoBroadcasterActivity.this.chatListView.setVisibility(8);
                            }
                        });
                    } else {
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.chatListView, "alpha", 1.0f);
                        this.animator = objectAnimatorOfFloat2;
                        objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.5.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animation) {
                                LiveVideoBroadcasterActivity.this.chatListView.setVisibility(0);
                            }
                        });
                    }
                    this.animator.setDuration(200L);
                    this.animator.start();
                }
            }
        });
        RadialProgressView radialProgressView = new RadialProgressView(this);
        this.progressBar = radialProgressView;
        this.containerView.addView(radialProgressView, LayoutHelper.createFrame(84, 84, 81));
        this.progressBar.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this);
        this.stateTextView = textView;
        textView.setGravity(17);
        this.stateTextView.setTextSize(1, 28.0f);
        this.stateTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.stateTextView.setTextColor(-1);
        this.stateTextView.setPadding(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f));
        linearLayout.addView(this.stateTextView, LayoutHelper.createLinear(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.closeButtonsLinear = linearLayout2;
        linearLayout2.setOrientation(1);
        this.closeButtonsLinear.setGravity(17);
        String[] strArr = {LocaleController.getString("LiveStreamCloseDialogArchive", R.string.LiveStreamCloseDialogArchive), LocaleController.getString("LiveStreamCloseDialogStop", R.string.LiveStreamCloseDialogStop), LocaleController.getString("Cancel", R.string.Cancel)};
        TextView[] textViewArr = new TextView[3];
        int i = 0;
        for (int i2 = 3; i < i2; i2 = 3) {
            String str = strArr[i];
            TextView textView2 = new TextView(this);
            textView2.setGravity(17);
            textView2.setTextSize(1, 16.0f);
            textView2.setTypeface(AndroidUtilities.getFontFamily(true));
            textView2.setTextColor(Theme.getColor("actionBarDefaultIcon"));
            textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("actionBarDefault"), 855638016));
            textView2.setPadding(AndroidUtilities.dp(17.0f), 0, AndroidUtilities.dp(17.0f), 0);
            textView2.setText(str);
            this.closeButtonsLinear.addView(textView2, LayoutHelper.createLinear(-2, 28, 8.0f, 8.0f, 8.0f, 8.0f));
            textViewArr[i] = textView2;
            i++;
        }
        linearLayout.addView(this.closeButtonsLinear);
        textViewArr[0].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.liveHelper.onArchiveClicked();
            }
        });
        textViewArr[1].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.liveHelper.onEndClicked();
            }
        });
        textViewArr[2].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.liveHelper.onCloseCanceled();
            }
        });
        TextView textView3 = new TextView(this) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.9
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return LiveVideoBroadcasterActivity.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        this.centeredButton = textView3;
        textView3.setGravity(17);
        this.centeredButton.setTextSize(1, 16.0f);
        this.centeredButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.centeredButton.setTextColor(Theme.getColor("actionBarDefaultIcon"));
        this.centeredButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("actionBarDefault"), 855638016));
        this.centeredButton.setPadding(AndroidUtilities.dp(17.0f), 0, AndroidUtilities.dp(17.0f), 0);
        linearLayout.addView(this.centeredButton, LayoutHelper.createLinear(-2, 28, 8.0f, 8.0f, 8.0f, 8.0f));
        ImageView imageView = new ImageView(this);
        this.qualityImageView = imageView;
        imageView.setLayoutParams(LayoutHelper.createLinear(-2, -2, 4.0f, 4.0f, 4.0f, 4.0f));
        RadioGroup radioGroup = new RadioGroup(this);
        this.qualityRadioGroup = radioGroup;
        radioGroup.setOrientation(0);
        int[] iArr = {720, 480, 240, 144};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 4; i3++) {
            if (iArr[i3] <= this.maxVideoWidth) {
                arrayList.add(Integer.valueOf(iArr[i3]));
                RadioButton radioButton = new RadioButton(this);
                final int i4 = iArr[i3];
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.10
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (!isChecked || LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster == null) {
                            return;
                        }
                        int i5 = i4;
                        if (i5 == 720) {
                            LiveVideoBroadcasterActivity.this.qualityImageView.setImageResource(R.drawable.video_720);
                        } else if (i5 == 480) {
                            LiveVideoBroadcasterActivity.this.qualityImageView.setImageResource(R.drawable.video_480);
                        } else if (i5 == 240) {
                            LiveVideoBroadcasterActivity.this.qualityImageView.setImageResource(R.drawable.video_240);
                        } else if (i5 == 144) {
                            LiveVideoBroadcasterActivity.this.qualityImageView.setImageResource(R.drawable.video_144);
                        }
                        LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.setMaxVideoWidth(i4);
                        LiveVideoBroadcasterActivity.this.getSharedPreferences("live-record-config", 0).edit().putInt("videoWidth", i4).apply();
                    }
                });
                radioButton.setText(iArr[i3] + "p");
                this.qualityRadioGroup.addView(radioButton);
            }
        }
        if (arrayList.size() > 0) {
            int i5 = this.maxVideoWidth;
            int iAbs = Math.abs(((Integer) arrayList.get(0)).intValue() - i5);
            int i6 = 0;
            for (int i7 = 1; i7 < arrayList.size(); i7++) {
                int iAbs2 = Math.abs(((Integer) arrayList.get(i7)).intValue() - i5);
                if (iAbs2 < iAbs) {
                    i6 = i7;
                    iAbs = iAbs2;
                }
            }
            this.videoWidth = ((Integer) arrayList.get(i6)).intValue();
            ((RadioButton) this.qualityRadioGroup.getChildAt(i6)).setChecked(true);
            LiveVideoBroadcaster liveVideoBroadcaster = this.mLiveVideoBroadcaster;
            if (liveVideoBroadcaster != null) {
                liveVideoBroadcaster.setMaxVideoWidth(this.videoWidth);
            }
            int i8 = this.videoWidth;
            if (i8 == 720) {
                this.qualityImageView.setImageResource(R.drawable.video_720);
            } else if (i8 == 480) {
                this.qualityImageView.setImageResource(R.drawable.video_480);
            } else if (i8 == 240) {
                this.qualityImageView.setImageResource(R.drawable.video_240);
            } else if (i8 == 144) {
                this.qualityImageView.setImageResource(R.drawable.video_144);
            }
        }
        linearLayout.addView(this.qualityRadioGroup, LayoutHelper.createLinear(-2, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        TextView textView4 = new TextView(this);
        this.hintTextView = textView4;
        textView4.setVisibility(4);
        this.hintTextView.setGravity(17);
        this.hintTextView.setTextSize(1, 16.0f);
        this.hintTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.hintTextView.setTextColor(-1);
        this.hintTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(12.0f), 1140850688));
        this.hintTextView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f));
        linearLayout.addView(this.hintTextView, LayoutHelper.createLinear(-2, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        TextView textView5 = new TextView(this);
        this.videoMuteTextView = textView5;
        textView5.setText(LocaleController.getString("LiveUploadLowVideoOff", R.string.LiveUploadLowVideoOff));
        this.videoMuteTextView.setVisibility(4);
        this.videoMuteTextView.setGravity(17);
        this.videoMuteTextView.setTextSize(1, 16.0f);
        this.videoMuteTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.videoMuteTextView.setTextColor(-1);
        this.videoMuteTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(12.0f), 1140850688));
        this.videoMuteTextView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f));
        linearLayout.addView(this.videoMuteTextView, LayoutHelper.createLinear(-2, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        this.containerView.addView(linearLayout, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout3 = new LinearLayout(this) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.11
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                try {
                    if (LiveVideoBroadcasterActivity.this.bottomTouchEnabled) {
                        return super.dispatchTouchEvent(ev);
                    }
                    return false;
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                try {
                    if (LiveVideoBroadcasterActivity.this.bottomTouchEnabled) {
                        return super.onInterceptTouchEvent(ev);
                    }
                    return false;
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return LiveVideoBroadcasterActivity.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        linearLayout3.setOrientation(0);
        this.containerView.addView(linearLayout3, LayoutHelper.createFrame(-1, -2, 80));
        ImageView imageView2 = new ImageView(this);
        this.micToggle = imageView2;
        imageView2.setImageResource(R.drawable.ic_mic_mute_on_24);
        this.micToggle.setContentDescription(LocaleController.getString("Mic", R.string.Mic));
        this.micToggle.setScaleType(ImageView.ScaleType.CENTER);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.micToggle, LayoutHelper.createFrame(38, 38.0f, 81, 0.0f, 0.0f, 0.0f, 10.0f));
        linearLayout3.addView(frameLayout, LayoutHelper.createLinear(0, -2, 1.0f));
        this.micToggle.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i9;
                String str2;
                LiveVideoBroadcasterActivity.this.toggleMute();
                ObjectAnimator duration = ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.micToggle, "scaleX", 0.0f).setDuration(100L);
                duration.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.12.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        LiveVideoBroadcasterActivity.this.micToggle.setImageResource(LiveVideoBroadcasterActivity.this.mIsMuted ? R.drawable.ic_mic_mute_off_24 : R.drawable.ic_mic_mute_on_24);
                        ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.micToggle, "scaleX", 1.0f).setDuration(100L).start();
                    }
                });
                duration.start();
                if (LiveVideoBroadcasterActivity.this.hintAnimation != null) {
                    LiveVideoBroadcasterActivity.this.hintAnimation.cancel();
                }
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.hintTextView, "alpha", 0.0f, 1.0f, 1.0f, 1.0f, 0.0f).setDuration(4000L);
                TextView textView6 = LiveVideoBroadcasterActivity.this.hintTextView;
                if (LiveVideoBroadcasterActivity.this.mIsMuted) {
                    i9 = R.string.LiveMicOff;
                    str2 = "LiveMicOff";
                } else {
                    i9 = R.string.LiveMicOn;
                    str2 = "LiveMicOn";
                }
                textView6.setText(LocaleController.getString(str2, i9));
                duration2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.12.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        LiveVideoBroadcasterActivity.this.hintTextView.setAlpha(0.0f);
                        LiveVideoBroadcasterActivity.this.hintTextView.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (LiveVideoBroadcasterActivity.this.hintAnimation == animator) {
                            LiveVideoBroadcasterActivity.this.hintAnimation = null;
                        }
                        LiveVideoBroadcasterActivity.this.hintTextView.setVisibility(4);
                    }
                });
                LiveVideoBroadcasterActivity.this.hintAnimation = duration2;
                duration2.start();
            }
        });
        ImageView imageView3 = new ImageView(this);
        this.switchCameraButton = imageView3;
        imageView3.setImageResource(isFrontCamera() ? R.drawable.camera_revert1 : R.drawable.camera_revert2);
        this.switchCameraButton.setScaleType(ImageView.ScaleType.CENTER);
        this.switchCameraButton.setContentDescription(LocaleController.getString("FlipCamera", R.string.FlipCamera));
        FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.addView(this.switchCameraButton, LayoutHelper.createFrame(38, 38.0f, 81, 0.0f, 0.0f, 0.0f, 10.0f));
        linearLayout3.addView(frameLayout2, LayoutHelper.createLinear(0, -2, 1.0f));
        this.switchCameraButton.setOnClickListener(new AnonymousClass13());
        ImageView imageView4 = new ImageView(this);
        this.videoToggle = imageView4;
        imageView4.setImageResource(R.drawable.ic_video_on);
        this.videoToggle.setScaleType(ImageView.ScaleType.CENTER);
        this.videoToggle.setContentDescription(LocaleController.getString("ChatCamera", R.string.ChatCamera));
        FrameLayout frameLayout3 = new FrameLayout(this);
        frameLayout3.addView(this.videoToggle, LayoutHelper.createFrame(38, 38.0f, 81, 0.0f, 0.0f, 0.0f, 10.0f));
        linearLayout3.addView(frameLayout3, LayoutHelper.createLinear(0, -2, 1.0f));
        this.videoToggle.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i9;
                String str2;
                LiveVideoBroadcasterActivity.this.toggleVideoMute();
                ObjectAnimator duration = ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.videoToggle, "scaleX", 0.0f).setDuration(100L);
                duration.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.14.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        LiveVideoBroadcasterActivity.this.videoToggle.setImageResource(LiveVideoBroadcasterActivity.this.mIsVideoMuted ? R.drawable.ic_no_video : R.drawable.ic_video_on);
                        ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.videoToggle, "scaleX", 1.0f).setDuration(100L).start();
                    }
                });
                duration.start();
                if (LiveVideoBroadcasterActivity.this.hintAnimation != null) {
                    LiveVideoBroadcasterActivity.this.hintAnimation.cancel();
                }
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.hintTextView, "alpha", 0.0f, 1.0f, 1.0f, 1.0f, 0.0f).setDuration(4000L);
                TextView textView6 = LiveVideoBroadcasterActivity.this.hintTextView;
                if (LiveVideoBroadcasterActivity.this.mIsVideoMuted) {
                    i9 = R.string.LiveVideoOff;
                    str2 = "LiveVideoOff";
                } else {
                    i9 = R.string.LiveVideoOn;
                    str2 = "LiveVideoOn";
                }
                textView6.setText(LocaleController.getString(str2, i9));
                duration2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.14.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        LiveVideoBroadcasterActivity.this.hintTextView.setAlpha(0.0f);
                        LiveVideoBroadcasterActivity.this.hintTextView.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (LiveVideoBroadcasterActivity.this.hintAnimation == animator) {
                            LiveVideoBroadcasterActivity.this.hintAnimation = null;
                        }
                        LiveVideoBroadcasterActivity.this.hintTextView.setVisibility(4);
                    }
                });
                LiveVideoBroadcasterActivity.this.hintAnimation = duration2;
                duration2.start();
            }
        });
        this.bottomButtons = linearLayout3;
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = new PhotoViewerCaptionEnterView(this, this.containerView, getWindow().getDecorView(), null) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.15
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                try {
                    if (LiveVideoBroadcasterActivity.this.bottomTouchEnabled) {
                        return false;
                    }
                    return super.dispatchTouchEvent(ev);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                try {
                    if (LiveVideoBroadcasterActivity.this.bottomTouchEnabled) {
                        return false;
                    }
                    return super.onInterceptTouchEvent(ev);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return !LiveVideoBroadcasterActivity.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        this.captionEditText = photoViewerCaptionEnterView;
        photoViewerCaptionEnterView.setDelegate(new PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.16
            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onEmojiViewCloseEnd() {
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onEmojiViewCloseStart() {
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onTextChanged(CharSequence text) {
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onWindowSizeChanged(int size) {
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onCaptionEnter() throws Resources.NotFoundException {
                LiveVideoBroadcasterActivity.this.closeCaptionEnter(true);
            }
        });
        this.captionEditText.setVisibility(8);
        this.captionEditText.onCreate();
        this.containerView.addView(this.captionEditText, LayoutHelper.createFrame(-1, -2, 83));
        TextView textView6 = new TextView(this) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.17
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return LiveVideoBroadcasterActivity.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        this.captionTextView = textView6;
        textView6.setMovementMethod(new LinkMovementMethod() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.18
            @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
            public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
                try {
                    boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
                    if (event.getAction() == 1 || event.getAction() == 3) {
                        Selection.removeSelection(buffer);
                    }
                    return zOnTouchEvent;
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }
        });
        this.captionTextView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f));
        this.captionTextView.setLinkTextColor(-1);
        this.captionTextView.setTextColor(-1);
        this.captionTextView.setHighlightColor(872415231);
        this.captionTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.captionTextView.setGravity(19);
        this.captionTextView.setTextSize(1, 16.0f);
        this.captionTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.captionTextView.setVisibility(4);
        this.captionTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.captionEditText.setTag(1);
                LiveVideoBroadcasterActivity.this.captionEditText.openKeyboard();
            }
        });
        this.captionTextView.setText(LocaleController.getString("LiveAddCaption", R.string.LiveAddCaption));
        this.captionTextView.setTag("empty");
        this.finalCaption = null;
        this.captionTextView.setTextColor(-1291845633);
        this.containerView.addView(this.captionTextView, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 0.0f, 50.0f));
        LinearLayout linearLayout4 = new LinearLayout(this) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.20
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                try {
                    if (LiveVideoBroadcasterActivity.this.bottomTouchEnabled) {
                        return super.dispatchTouchEvent(ev);
                    }
                    return false;
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                try {
                    if (LiveVideoBroadcasterActivity.this.bottomTouchEnabled) {
                        return super.onInterceptTouchEvent(ev);
                    }
                    return false;
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return LiveVideoBroadcasterActivity.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        linearLayout4.setClipChildren(false);
        linearLayout4.setClipToPadding(false);
        linearLayout4.setGravity(16);
        linearLayout4.setOrientation(0);
        linearLayout4.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        ImageView imageView5 = new ImageView(this);
        imageView5.setImageDrawable(new BackDrawable(true));
        imageView5.setBackgroundDrawable(Theme.createSelectorDrawable(-1));
        imageView5.setContentDescription(LocaleController.getString("Close", R.string.Close));
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.liveHelper.onClose();
            }
        });
        linearLayout4.addView(imageView5, LayoutHelper.createLinear(-2, -2));
        this.backButton = imageView5;
        linearLayout4.addView(new View(this), LayoutHelper.createLinear(0, 1, 1.0f));
        TextView textView7 = new TextView(this);
        this.signalBarText = textView7;
        textView7.setTextColor(-855638017);
        SignalBarsDrawable signalBarsDrawable = new SignalBarsDrawable(this, null);
        signalBarsDrawable.setBounds(0, 0, signalBarsDrawable.getIntrinsicWidth(), signalBarsDrawable.getIntrinsicHeight());
        this.signalBarText.setCompoundDrawables(signalBarsDrawable, null, null, null);
        this.signalBarText.setTypeface(AndroidUtilities.getFontFamily(true));
        this.signalBarText.setGravity(LocaleController.isRTL ? 5 : 3);
        this.signalBarText.setCompoundDrawablePadding(AndroidUtilities.dp(5.0f));
        this.signalBarText.setTextSize(1, 14.0f);
        linearLayout4.addView(this.signalBarText);
        TextView textView8 = new TextView(this);
        this.connectionLog = textView8;
        textView8.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.connectionLog.setTextColor(-1);
        this.connectionLog.setLayoutParams(LayoutHelper.createLinear(-2, -2, 4.0f, 0.0f, 4.0f, 0.0f));
        this.connectionLog.setGravity(21);
        this.connectionLog.setTextSize(1, 8.0f);
        this.connectionLog.setTypeface(AndroidUtilities.getFontFamily(true));
        this.connectionLog.setText(String.format(Locale.getDefault(), "fps: %d, ↑ %.1f Kbit", 0, Float.valueOf(0.0f)));
        this.connectionLog.setText(String.format(Locale.getDefault(), "%d", 0));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(855638016);
        gradientDrawable.setCornerRadius(AndroidUtilities.dp(8.0f));
        this.connectionLog.setBackground(gradientDrawable);
        linearLayout4.addView(this.connectionLog);
        TextView textView9 = new TextView(this);
        this.totalViewerTextView = textView9;
        textView9.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.totalViewerTextView.setTextColor(-1);
        this.totalViewerTextView.setLayoutParams(LayoutHelper.createLinear(-2, -2));
        this.totalViewerTextView.setGravity(21);
        this.totalViewerTextView.setTextSize(1, 16.0f);
        this.totalViewerTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.totalViewerTextView.setText(String.format(Locale.getDefault(), "%d", 0));
        this.totalViewerTextView.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
        this.totalViewerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tab_users, 0);
        this.totalViewerTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.showParticipants();
            }
        });
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(855638016);
        gradientDrawable2.setCornerRadius(AndroidUtilities.dp(8.0f));
        this.totalViewerTextView.setBackground(gradientDrawable2);
        linearLayout4.addView(this.totalViewerTextView);
        linearLayout4.addView(this.qualityImageView);
        TextView textView10 = new TextView(this);
        this.timerTextView = textView10;
        textView10.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.timerTextView.setTextColor(-1);
        this.timerTextView.setGravity(21);
        this.timerTextView.setTextSize(1, 14.0f);
        this.timerTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.timerTextView.setText("00:00");
        this.timerTextView.setVisibility(8);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setColor(-1711341568);
        gradientDrawable3.setCornerRadius(AndroidUtilities.dp(8.0f));
        this.timerTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.liveTextView.setVisibility(0);
                v.setVisibility(4);
            }
        });
        TextView textView11 = new TextView(this);
        this.liveTextView = textView11;
        textView11.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.liveTextView.setTextColor(-1);
        this.liveTextView.setGravity(21);
        this.liveTextView.setTextSize(1, 14.0f);
        this.liveTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.liveTextView.setText(LocaleController.getString("LiveStateOnAir", R.string.LiveStateOnAir));
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setColor(-1711341568);
        gradientDrawable4.setCornerRadius(AndroidUtilities.dp(8.0f));
        this.liveTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LiveVideoBroadcasterActivity.this.timerTextView.setVisibility(0);
                v.setVisibility(4);
            }
        });
        this.liveTextViewContainer = new FrameLayout(this);
        this.liveTextViewContainer.setMinimumWidth((int) this.liveTextView.getPaint().measureText("999:99"));
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setShape(0);
        gradientDrawable5.setColor(-1711341568);
        gradientDrawable5.setCornerRadius(AndroidUtilities.dp(8.0f));
        this.liveTextViewContainer.setBackground(gradientDrawable5);
        this.liveTextViewContainer.addView(this.liveTextView, LayoutHelper.createFrame(-2, -2.0f, 17, 4.0f, 0.0f, 4.0f, 0.0f));
        this.liveTextViewContainer.addView(this.timerTextView, LayoutHelper.createFrame(-2, -2.0f, 17, 4.0f, 0.0f, 4.0f, 0.0f));
        linearLayout4.addView(this.liveTextViewContainer, LayoutHelper.createLinear(-2, -2));
        this.liveTextViewContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LiveVideoBroadcasterActivity.this.liveTextView.getVisibility() == 4) {
                    LiveVideoBroadcasterActivity.this.liveTextView.setVisibility(0);
                    LiveVideoBroadcasterActivity.this.timerTextView.setVisibility(4);
                } else {
                    LiveVideoBroadcasterActivity.this.liveTextView.setVisibility(4);
                    LiveVideoBroadcasterActivity.this.timerTextView.setVisibility(0);
                }
            }
        });
        this.containerView.addView(linearLayout4, LayoutHelper.createFrame(-2, -2, 53));
        RecyclerListView recyclerListView = new RecyclerListView(this);
        this.chatListView = recyclerListView;
        ChatActivityAdapter chatActivityAdapter = new ChatActivityAdapter();
        this.chatAdapter = chatActivityAdapter;
        recyclerListView.setAdapter(chatActivityAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.26
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.chatLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.chatLayoutManager.setStackFromEnd(true);
        this.chatListView.setLayoutManager(this.chatLayoutManager);
        FadingEdgeLayout fadingEdgeLayout = new FadingEdgeLayout(this);
        fadingEdgeLayout.setFadeEdges(true, false, true, false);
        fadingEdgeLayout.setFadeSizes(AndroidUtilities.displaySize.y / 4, 0, AndroidUtilities.dp(8.0f), 0);
        FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(-1, -1.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f);
        layoutParamsCreateFrame.height = AndroidUtilities.displaySize.y / 2;
        this.containerView.addView(fadingEdgeLayout, layoutParamsCreateFrame);
        fadingEdgeLayout.addView(this.chatListView, LayoutHelper.createFrame(-1, -2, 83));
        this.liveHelper.setState(0);
    }

    /* renamed from: ir.eitaa.helper.live.LiveVideoBroadcasterActivity$13, reason: invalid class name */
    class AnonymousClass13 implements View.OnClickListener {
        boolean switchToBack = false;
        boolean backwardAnimation = false;
        Timer timer = null;
        float time = 0.0f;
        final float duration = 500.0f;
        Runnable cameraChanger = new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.13.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoBroadcasterActivity.this.changeCamera();
            }
        };

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.backwardAnimation = !this.backwardAnimation;
            }
            AndroidUtilities.cancelRunOnUIThread(this.cameraChanger);
            this.switchToBack = LiveVideoBroadcasterActivity.this.isFrontCamera();
            Timer timer2 = new Timer();
            this.timer = timer2;
            timer2.schedule(new AnonymousClass2(), 0L, 16L);
        }

        /* renamed from: ir.eitaa.helper.live.LiveVideoBroadcasterActivity$13$2, reason: invalid class name */
        class AnonymousClass2 extends TimerTask {
            long t = 0;

            AnonymousClass2() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.13.2.1
                    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() {
                        /*
                            Method dump skipped, instructions count: 255
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.AnonymousClass13.AnonymousClass2.AnonymousClass1.run():void");
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeCaptionEnter(boolean apply) throws Resources.NotFoundException {
        if (apply) {
            CharSequence[] charSequenceArr = {this.captionEditText.getFieldCharSequence()};
            MediaDataController.getInstance(UserConfig.selectedAccount).getEntities(charSequenceArr, true);
            setCurrentCaption(charSequenceArr[0]);
        }
        this.captionEditText.setTag(null);
        if (this.captionEditText.isPopupShowing()) {
            this.captionEditText.hidePopup();
        }
        this.captionEditText.closeKeyboard();
    }

    private void setCurrentCaption(final CharSequence caption) throws Resources.NotFoundException {
        this.captionTextView.getTag();
        if (!TextUtils.isEmpty(caption)) {
            Theme.createChatResources(null, true);
            CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(new SpannableStringBuilder(caption), this.captionTextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            this.captionTextView.setTag(charSequenceReplaceEmoji);
            try {
                this.finalCaption = charSequenceReplaceEmoji;
                this.captionTextView.setText(charSequenceReplaceEmoji);
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.captionTextView.setScrollY(0);
            this.captionTextView.setTextColor(-1);
            return;
        }
        this.captionTextView.setText(LocaleController.getString("LiveAddCaption", R.string.LiveAddCaption));
        this.finalCaption = null;
        this.captionTextView.setTag("empty");
        this.captionTextView.setVisibility(0);
        this.captionTextView.setTextColor(-1291845633);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCamera() {
        if (this.mLiveVideoBroadcaster != null) {
            this.cameraId = !isFrontCamera() ? 1 : 0;
            getSharedPreferences("live-record-config", 0).edit().putInt("cameraFacing", this.cameraId).apply();
            this.mLiveVideoBroadcaster.changeCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToLastMessage() {
        this.chatLayoutManager.scrollToPositionWithOffset(this.messages.size() - 1, (-999999) - this.chatListView.getPaddingTop());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        bindService(this.mLiveVideoBroadcasterServiceIntent, this.mConnection, 0);
    }

    @Override // android.app.Activity
    protected void onResume() throws InterruptedException, IOException {
        super.onResume();
        ConnectionsManager.getInstance(UserConfig.selectedAccount).setAppPaused(false, false);
        this.resumed = true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 8954) {
            return;
        }
        if (this.mLiveVideoBroadcaster.isPermissionGranted()) {
            this.mLiveVideoBroadcaster.openCamera(this.cameraId);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") || ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.RECORD_AUDIO")) {
            this.mLiveVideoBroadcaster.requestPermission();
        } else {
            new AlertDialog.Builder(this).setTitle(R.string.permission).setMessage(getString(R.string.app_doesnot_work_without_permissions)).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.27
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:" + LiveVideoBroadcasterActivity.this.getApplicationContext().getPackageName()));
                        LiveVideoBroadcasterActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        LiveVideoBroadcasterActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            }).show();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) throws IllegalStateException, InterruptedException {
        if (isInPictureInPictureMode) {
            setState(-10);
        } else {
            setState(this.currentState);
        }
    }

    @Override // android.app.Activity
    protected void onPause() throws IllegalStateException, InterruptedException, IOException {
        super.onPause();
        Log.i(TAG, "onPause");
        LiveVideoBroadcaster liveVideoBroadcaster = this.mLiveVideoBroadcaster;
        if (liveVideoBroadcaster != null) {
            liveVideoBroadcaster.pause();
        }
        ConnectionsManager.getInstance(UserConfig.selectedAccount).setAppPaused(true, false);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.liveHelper.onClose();
    }

    @Override // android.app.Activity
    protected void onStop() throws IllegalStateException, InterruptedException {
        super.onStop();
        this.liveHelper.onPause();
        triggerStopRecording();
        unbindService(this.mConnection);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.liveHelper.unRegisterNotifications();
        stopService(new Intent(this, (Class<?>) LiveVideoBroadcaster.class));
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        super.onDestroy();
    }

    public void showSetResolutionDialog(View v) {
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        Fragment fragmentFindFragmentByTag = getFragmentManager().findFragmentByTag("dialog");
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
        }
        this.mLiveVideoBroadcaster.getPreviewSizeList();
    }

    public void startBroadcasting(String url) {
        if (this.mIsStreaming) {
            return;
        }
        LiveVideoBroadcaster liveVideoBroadcaster = this.mLiveVideoBroadcaster;
        if (liveVideoBroadcaster != null) {
            if (!liveVideoBroadcaster.isConnected()) {
                new AsyncTask<String, String, Integer>() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.28
                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        LiveVideoBroadcasterActivity.this.liveHelper.onConnectionStarted();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public Integer doInBackground(String... url2) {
                        try {
                            return Integer.valueOf(LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.startBroadcasting(url2[0]));
                        } catch (Exception e) {
                            FileLog.e(e);
                            return -4000;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(Integer result) throws IllegalStateException, InterruptedException {
                        LiveVideoBroadcasterActivity.this.mIsStreaming = result.intValue() > 0;
                        if (result.intValue() > 0) {
                            LiveVideoBroadcasterActivity.this.liveHelper.onBroadcastingStarted();
                            LiveVideoBroadcasterActivity.this.startTimer();
                        } else {
                            LiveVideoBroadcasterActivity.this.failedResult = result.intValue();
                            LiveVideoBroadcasterActivity.this.liveHelper.onConnectionFailed();
                            LiveVideoBroadcasterActivity.this.triggerStopRecording();
                        }
                    }
                }.execute(url);
                return;
            } else {
                Snackbar.make(this.containerView, R.string.streaming_not_finished, 0).show();
                return;
            }
        }
        Snackbar.make(this.containerView, R.string.oopps_shouldnt_happen, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFrontCamera() {
        return this.cameraId == 1;
    }

    public void toggleMute() {
        boolean z = !this.mIsMuted;
        this.mIsMuted = z;
        this.mLiveVideoBroadcaster.setAudioEnable(!z);
    }

    public void toggleVideoMute() {
        boolean z = !this.mIsVideoMuted;
        this.mIsVideoMuted = z;
        this.mLiveVideoBroadcaster.setVideoMuted(z, true);
    }

    public void triggerStopRecording() throws IllegalStateException, InterruptedException {
        if (this.mIsStreaming) {
            stopTimer();
            this.mLiveVideoBroadcaster.stopBroadcasting();
        }
        this.mIsStreaming = false;
    }

    public void startTimer() {
        if (this.mTimer == null) {
            this.mTimer = new Timer();
        }
        this.mElapsedTime = 0L;
        this.mTimer.scheduleAtFixedRate(new TimerTask() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.29
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LiveVideoBroadcasterActivity.access$3214(LiveVideoBroadcasterActivity.this, 1L);
                LiveVideoBroadcasterActivity.this.mTimerHandler.obtainMessage(1).sendToTarget();
                if (LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster != null) {
                    LiveVideoBroadcasterActivity.this.mTimerHandler.obtainMessage(3, LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.getCurrentFrameRate(), LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.getCurrentBitrate()).sendToTarget();
                }
                if (LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster == null || !LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.isConnected()) {
                    LiveVideoBroadcasterActivity.this.mTimerHandler.obtainMessage(2).sendToTarget();
                }
            }
        }, 0L, 1000L);
    }

    public void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
        this.mElapsedTime = 0L;
    }

    private class TimerHandler extends Handler {
        private TimerHandler() {
        }

        /* synthetic */ TimerHandler(LiveVideoBroadcasterActivity liveVideoBroadcasterActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws IllegalStateException, InterruptedException {
            int i = msg.what;
            if (i == 1) {
                if (LiveVideoBroadcasterActivity.this.timerTextView != null) {
                    int messageStartTimeSec = LiveVideoBroadcasterActivity.this.liveHelper.getMessageStartTimeSec();
                    if (messageStartTimeSec == 0) {
                        LiveVideoBroadcasterActivity.this.timerTextView.setText((CharSequence) null);
                        return;
                    } else {
                        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - messageStartTimeSec);
                        LiveVideoBroadcasterActivity.this.timerTextView.setText(String.format("%02d:%02d", Integer.valueOf(iCurrentTimeMillis / 60), Integer.valueOf(iCurrentTimeMillis % 60)));
                        return;
                    }
                }
                return;
            }
            if (i == 2) {
                LiveVideoBroadcasterActivity.this.liveHelper.onConnectionLost();
                LiveVideoBroadcasterActivity.this.triggerStopRecording();
            } else {
                if (i != 3) {
                    return;
                }
                if (LiveVideoBroadcasterActivity.this.connectionLog != null) {
                    LiveVideoBroadcasterActivity.this.connectionLog.setText(String.format(Locale.getDefault(), "fps: %d, ↑ %d Kbyte", Integer.valueOf(msg.arg1), Integer.valueOf((int) ((msg.arg2 / 1000.0f) / 8.0f))));
                }
                if (LiveVideoBroadcasterActivity.this.signalBarText != null) {
                    LiveVideoBroadcasterActivity.this.signalBarsCount = (int) ((msg.arg2 / MessagesController.getInstance(UserConfig.selectedAccount).liveStreamConfig.maxVideoWidth) * 4.0f);
                    LiveVideoBroadcasterActivity.this.signalBarText.invalidate();
                }
            }
        }
    }

    /* renamed from: ir.eitaa.helper.live.LiveVideoBroadcasterActivity$30, reason: invalid class name */
    class AnonymousClass30 extends OrientationEventListener {
        AnimatorSet animatorSet;
        float lastRotation;

        AnonymousClass30(Context context) {
            super(context);
            this.lastRotation = 0.0f;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            float f = this.lastRotation;
            float f2 = ((orientation < 0 || orientation >= 5) && orientation <= 355) ? (85 >= orientation || orientation >= 95) ? (175 >= orientation || orientation >= 185) ? (265 >= orientation || orientation >= 275) ? f : 90.0f : 180.0f : 270.0f : 0.0f;
            if (f2 != f) {
                AnimatorSet animatorSet = this.animatorSet;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorSet = animatorSet2;
                animatorSet2.setDuration(150L);
                this.animatorSet.playTogether(ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.liveTextView, "rotation", f2), ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.totalViewerTextView, "rotation", f2), ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.micToggle, "rotation", f2), ObjectAnimator.ofFloat(LiveVideoBroadcasterActivity.this.switchCameraButton, "rotation", f2));
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.30.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (animation.equals(AnonymousClass30.this.animatorSet)) {
                            AnonymousClass30.this.animatorSet = null;
                        }
                    }
                });
                this.animatorSet.start();
            }
            this.lastRotation = f2;
        }
    }

    private void checkScreenRotation() {
        AnonymousClass30 anonymousClass30 = new AnonymousClass30(getApplicationContext());
        this.mOrientationListener = anonymousClass30;
        if (anonymousClass30.canDetectOrientation()) {
            this.mOrientationListener.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int newState) throws IllegalStateException, InterruptedException {
        String string;
        this.liveTextView.setVisibility(8);
        this.timerTextView.setVisibility(8);
        this.liveTextViewContainer.setVisibility(8);
        this.qualityImageView.setVisibility(8);
        this.captionTextView.setVisibility(8);
        this.captionEditText.setVisibility(8);
        this.stateTextView.setVisibility(8);
        this.centeredButton.setVisibility(8);
        this.centeredButton.setEnabled(false);
        this.centeredButton.setOnClickListener(null);
        this.bottomButtons.setVisibility(8);
        this.micToggle.setVisibility(8);
        this.videoToggle.setVisibility(8);
        this.progressBar.setVisibility(8);
        this.closeButtonsLinear.setVisibility(8);
        this.surfaceViewFrame.setVisibility(0);
        this.backButton.setVisibility(8);
        this.totalViewerTextView.setVisibility(8);
        this.signalBarText.setVisibility(8);
        this.qualityRadioGroup.setVisibility(8);
        this.connectionLog.setVisibility(8);
        this.chatListView.setVisibility(8);
        if (Build.VERSION.SDK_INT < 26 || !isInPictureInPictureMode()) {
            switch (newState) {
                case 0:
                    this.stateTextView.setVisibility(0);
                    this.stateTextView.setText(LocaleController.getString("LiveStatePreparing", R.string.LiveStatePreparing));
                    break;
                case 1:
                    this.centeredButton.setVisibility(0);
                    this.centeredButton.setEnabled(true);
                    this.centeredButton.setOnClickListener(new AnonymousClass31());
                    this.centeredButton.setText(LocaleController.getString("BotStart", R.string.BotStart));
                    this.qualityRadioGroup.setVisibility(0);
                    this.stateTextView.setVisibility(0);
                    String string2 = LocaleController.getString("StartLiveStream", R.string.StartLiveStream);
                    int iIndexOf = string2.indexOf(10);
                    SpannableString spannableString = new SpannableString(string2);
                    spannableString.setSpan(new RelativeSizeSpan(0.5f), iIndexOf, string2.length(), 33);
                    this.stateTextView.setText(spannableString);
                    this.captionTextView.setVisibility(0);
                    this.captionEditText.setVisibility(0);
                    this.bottomButtons.setVisibility(0);
                    this.backButton.setVisibility(0);
                    break;
                case 2:
                    this.progressBar.setVisibility(0);
                    break;
                case 3:
                    this.stateTextView.setVisibility(0);
                    this.stateTextView.setText("request live failed");
                    break;
                case 4:
                    this.progressBar.setVisibility(0);
                    if (!this.mIsStreaming) {
                        startBroadcasting(this.liveHelper.getWriteLink());
                        break;
                    }
                    break;
                case 5:
                    this.liveTextView.setVisibility(0);
                    this.timerTextView.setVisibility(4);
                    this.liveTextViewContainer.setVisibility(0);
                    this.qualityImageView.setVisibility(0);
                    this.backButton.setVisibility(0);
                    this.bottomButtons.setVisibility(0);
                    this.micToggle.setVisibility(0);
                    this.videoToggle.setVisibility(0);
                    this.totalViewerTextView.setVisibility(0);
                    this.chatListView.setVisibility(0);
                    break;
                case 7:
                case 17:
                    if (this.mIsStreaming) {
                        triggerStopRecording();
                    }
                    this.stateTextView.setVisibility(0);
                    TextView textView = this.stateTextView;
                    if (newState == 17) {
                        string = LocaleController.getString("LiveStoppedByDelete", R.string.LiveStoppedByDelete);
                    } else {
                        string = LocaleController.getString("LiveStoppedByServer", R.string.LiveStoppedByServer);
                    }
                    textView.setText(string);
                    this.backButton.setVisibility(0);
                    break;
                case 8:
                    this.progressBar.setVisibility(0);
                    break;
                case 9:
                    this.centeredButton.setVisibility(0);
                    this.centeredButton.setEnabled(true);
                    this.centeredButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.32
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            LiveVideoBroadcasterActivity.this.centeredButton.setEnabled(false);
                            LiveVideoBroadcasterActivity liveVideoBroadcasterActivity = LiveVideoBroadcasterActivity.this;
                            if (liveVideoBroadcasterActivity.mIsStreaming) {
                                return;
                            }
                            liveVideoBroadcasterActivity.startBroadcasting(liveVideoBroadcasterActivity.liveHelper.getWriteLink());
                        }
                    });
                    this.centeredButton.setText(LocaleController.getString("Resume", R.string.Resume));
                    this.stateTextView.setVisibility(0);
                    this.stateTextView.setText(LocaleController.getString("LiveStreamPaused", R.string.LiveStreamPaused));
                    this.bottomButtons.setVisibility(0);
                    this.backButton.setVisibility(0);
                    this.qualityRadioGroup.setVisibility(0);
                    break;
                case 10:
                    this.stateTextView.setText(LocaleController.getString("LiveConnectionLost", R.string.LiveConnectionLost));
                    this.stateTextView.setVisibility(0);
                    this.centeredButton.setVisibility(0);
                    this.centeredButton.setText(LocaleController.getString("Retry", R.string.Retry));
                    this.centeredButton.setEnabled(true);
                    this.centeredButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.33
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            LiveVideoBroadcasterActivity.this.centeredButton.setEnabled(false);
                            LiveVideoBroadcasterActivity liveVideoBroadcasterActivity = LiveVideoBroadcasterActivity.this;
                            if (liveVideoBroadcasterActivity.mIsStreaming) {
                                return;
                            }
                            liveVideoBroadcasterActivity.startBroadcasting(liveVideoBroadcasterActivity.liveHelper.getWriteLink());
                        }
                    });
                    this.backButton.setVisibility(0);
                    break;
                case 11:
                    this.progressBar.setVisibility(0);
                    break;
                case 12:
                    this.stateTextView.setText(LocaleController.getString("LiveStreamPaused", R.string.LiveStreamPaused));
                    this.stateTextView.setVisibility(0);
                    break;
                case 13:
                    SpannableString spannableString2 = new SpannableString(LocaleController.getString("LiveStreamCloseDialogMessage", R.string.LiveStreamCloseDialogMessage));
                    spannableString2.setSpan(new RelativeSizeSpan(0.5f), 0, spannableString2.length(), 17);
                    this.stateTextView.setText(spannableString2);
                    this.stateTextView.setVisibility(0);
                    this.closeButtonsLinear.setVisibility(0);
                    break;
                case 14:
                    finish();
                    break;
                case 15:
                    this.backButton.setVisibility(0);
                    this.centeredButton.setVisibility(0);
                    this.centeredButton.setEnabled(true);
                    this.centeredButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.34
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            LiveVideoBroadcasterActivity.this.centeredButton.setEnabled(false);
                            LiveVideoBroadcasterActivity liveVideoBroadcasterActivity = LiveVideoBroadcasterActivity.this;
                            if (liveVideoBroadcasterActivity.mIsStreaming) {
                                return;
                            }
                            liveVideoBroadcasterActivity.startBroadcasting(liveVideoBroadcasterActivity.liveHelper.getWriteLink());
                        }
                    });
                    this.centeredButton.setText(LocaleController.getString("Resume", R.string.Resume));
                    this.stateTextView.setVisibility(0);
                    this.stateTextView.setText(LocaleController.getString("LiveRtmpFailed", R.string.LiveRtmpFailed) + " " + this.failedResult);
                    this.bottomButtons.setVisibility(0);
                    break;
                case 16:
                    this.progressBar.setVisibility(0);
                    break;
            }
            this.currentState = newState;
        }
    }

    /* renamed from: ir.eitaa.helper.live.LiveVideoBroadcasterActivity$31, reason: invalid class name */
    class AnonymousClass31 implements View.OnClickListener {
        AnonymousClass31() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LiveVideoBroadcasterActivity.this.centeredButton.setEnabled(false);
            if (LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster != null) {
                LiveVideoBroadcasterActivity.this.mLiveVideoBroadcaster.takePhoto(new ILiveVideoBroadcaster.TakePhotoCallback() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.31.1
                    @Override // io.antmedia.android.broadcaster.ILiveVideoBroadcaster.TakePhotoCallback
                    public void onTakePhoto(Bitmap bitmap) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (width == 0 || height == 0) {
                            return;
                        }
                        float f = width;
                        float f2 = 90;
                        float f3 = height;
                        float fMax = Math.max(f / f2, f3 / f2);
                        Bitmap bitmapCreateScaledBitmap = Bitmaps.createScaledBitmap(bitmap, (int) (f / fMax), (int) (f3 / fMax), true);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        final byte[] byteArray = byteArrayOutputStream.toByteArray();
                        LiveVideoBroadcasterActivity.this.runOnUiThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.31.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String string = LiveVideoBroadcasterActivity.this.finalCaption != null ? LiveVideoBroadcasterActivity.this.finalCaption.toString() : null;
                                LiveVideoBroadcasterActivity.this.liveHelper.sendLiveStartRequest((string == null || string.length() != 0) ? string : null, byteArray);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showParticipants() {
        final boolean[] zArr = new boolean[1];
        BottomSheet.Builder builder = new BottomSheet.Builder(this);
        builder.setUseHardwareLayer(false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        builder.setCustomView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(LayoutHelper.createLinear(-1, -2));
        linearLayout.addView(frameLayout);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(new BackDrawable(true));
        TextView textView = new TextView(this);
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
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.35
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        final EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(this);
        emptyTextProgressView.setText(LocaleController.getString("LiveParticipantsNoOne", R.string.LiveParticipantsNoOne));
        emptyTextProgressView.showProgress();
        emptyTextProgressView.setShowAtCenter(true);
        linearLayout.addView(emptyTextProgressView, LayoutHelper.createLinear(-1, 80));
        final RecyclerListView recyclerListView = new RecyclerListView(this) { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.36
        };
        recyclerListView.setEmptyView(emptyTextProgressView);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-1, -2));
        final ArrayList arrayList = new ArrayList();
        recyclerListView.setAdapter(new RecyclerView.Adapter() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.37

            /* renamed from: ir.eitaa.helper.live.LiveVideoBroadcasterActivity$37$Holder */
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
        bottomSheetShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.38
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialog) {
                zArr[0] = true;
            }
        });
        this.liveHelper.getParticipants(new LiveHelper.GetParticipantsCallback() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.39
            @Override // ir.eitaa.helper.live.LiveHelper.GetParticipantsCallback
            public void participantsLoaded(List<TLRPC$User> users) {
                if (zArr[0]) {
                    return;
                }
                emptyTextProgressView.showTextView();
                arrayList.clear();
                arrayList.addAll(users);
                recyclerListView.getAdapter().notifyDataSetChanged();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.helper.live.LiveVideoBroadcasterActivity.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                bottomSheetShow.dismiss();
            }
        });
    }

    private class SignalBarsDrawable extends Drawable {
        private int[] barHeights;
        private int offsetStart;
        private Paint paint;
        private RectF rect;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        private SignalBarsDrawable() {
            this.barHeights = new int[]{AndroidUtilities.dp(3.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(9.0f), AndroidUtilities.dp(12.0f)};
            this.paint = new Paint(1);
            this.rect = new RectF();
            this.offsetStart = 6;
        }

        /* synthetic */ SignalBarsDrawable(LiveVideoBroadcasterActivity liveVideoBroadcasterActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.paint.setColor(-1);
            int iDp = getBounds().left + AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : this.offsetStart);
            int i = getBounds().top;
            int i2 = 0;
            while (i2 < 4) {
                int i3 = i2 + 1;
                this.paint.setAlpha(i3 <= LiveVideoBroadcasterActivity.this.signalBarsCount ? 242 : R.styleable.AppCompatTheme_textAppearanceSearchResultTitle);
                this.rect.set(AndroidUtilities.dp(i2 * 4) + iDp, (getIntrinsicHeight() + i) - this.barHeights[i2], (AndroidUtilities.dp(4.0f) * i2) + iDp + AndroidUtilities.dp(3.0f), getIntrinsicHeight() + i);
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(0.3f), AndroidUtilities.dp(0.3f), this.paint);
                i2 = i3;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return AndroidUtilities.dp(this.offsetStart + 15);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return AndroidUtilities.dp(12.0f);
        }
    }
}
