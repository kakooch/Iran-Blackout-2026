package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Property;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.analytics.AnalyticsListener;
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import ir.medu.shad.R;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Scroller;
import org.rbmain.ui.Components.TimerParticles;
import org.rbmain.ui.Components.VideoPlayer;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes4.dex */
public class SecretMediaViewer implements NotificationCenter.NotificationCenterDelegate, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private static volatile SecretMediaViewer Instance;
    private ActionBar actionBar;
    private float animateToClipBottom;
    private float animateToClipHorizontal;
    private float animateToClipTop;
    private float animateToScale;
    private float animateToX;
    private float animateToY;
    private long animationStartTime;
    private float animationValue;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private float clipBottom;
    private float clipHorizontal;
    private float clipTop;
    private long closeTime;
    private boolean closeVideoAfterWatch;
    private FrameLayoutDrawer containerView;
    private int currentAccount;
    private AnimatorSet currentActionBarAnimation;
    private int currentChannelId;
    private MessageObject currentMessageObject;
    private PhotoViewer.PhotoViewerProvider currentProvider;
    private ImageReceiver.BitmapHolder currentThumb;
    private boolean disableShowCheck;
    private boolean discardTap;
    private boolean doubleTap;
    private float dragY;
    private boolean draggingDown;
    private GestureDetector gestureDetector;
    private AnimatorSet imageMoveAnimation;
    private boolean invalidCoords;
    private boolean isPhotoVisible;
    private boolean isPlaying;
    private boolean isVideo;
    private boolean isVisible;
    private Object lastInsets;
    private float maxX;
    private float maxY;
    private float minX;
    private float minY;
    private float moveStartX;
    private float moveStartY;
    private boolean moving;
    private long openTime;
    private Activity parentActivity;
    private Runnable photoAnimationEndRunnable;
    private int photoAnimationInProgress;
    private long photoTransitionAnimationStartTime;
    private float pinchCenterX;
    private float pinchCenterY;
    private float pinchStartDistance;
    private float pinchStartX;
    private float pinchStartY;
    private int playerRetryPlayCount;
    private Scroller scroller;
    private SecretDeleteTimer secretDeleteTimer;
    private boolean textureUploaded;
    private float translationX;
    private float translationY;
    private boolean useOvershootForScale;
    private VelocityTracker velocityTracker;
    private float videoCrossfadeAlpha;
    private long videoCrossfadeAlphaLastTime;
    private boolean videoCrossfadeStarted;
    private VideoPlayer videoPlayer;
    private TextureView videoTextureView;
    private boolean videoWatchedOneTime;
    private WindowManager.LayoutParams windowLayoutParams;
    private FrameLayout windowView;
    private boolean zoomAnimation;
    private boolean zooming;
    private ImageReceiver centerImage = new ImageReceiver();
    private boolean isActionBarVisible = true;
    private PhotoBackgroundDrawable photoBackgroundDrawable = new PhotoBackgroundDrawable(-16777216);
    private Paint blackPaint = new Paint();
    private float scale = 1.0f;
    private DecelerateInterpolator interpolator = new DecelerateInterpolator(1.5f);
    private float pinchStartScale = 1.0f;
    private boolean canDragDown = true;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    static /* synthetic */ int access$1110(SecretMediaViewer secretMediaViewer) {
        int i = secretMediaViewer.playerRetryPlayCount;
        secretMediaViewer.playerRetryPlayCount = i - 1;
        return i;
    }

    private class FrameLayoutDrawer extends FrameLayout {
        public FrameLayoutDrawer(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            SecretMediaViewer.this.processTouchEvent(motionEvent);
            return true;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            SecretMediaViewer.this.onDraw(canvas);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            return view != SecretMediaViewer.this.aspectRatioFrameLayout && super.drawChild(canvas, view, j);
        }
    }

    private class SecretDeleteTimer extends FrameLayout {
        private Paint afterDeleteProgressPaint;
        private Paint circlePaint;
        private RectF deleteProgressRect;
        private long destroyTime;
        private long destroyTtl;
        private Drawable drawable;
        private Paint particlePaint;
        private TimerParticles timerParticles;
        private boolean useVideoProgress;

        public SecretDeleteTimer(Context context) {
            super(context);
            this.deleteProgressRect = new RectF();
            this.timerParticles = new TimerParticles();
            setWillNotDraw(false);
            Paint paint = new Paint(1);
            this.particlePaint = paint;
            paint.setStrokeWidth(AndroidUtilities.dp(1.5f));
            this.particlePaint.setColor(-1644826);
            this.particlePaint.setStrokeCap(Paint.Cap.ROUND);
            this.particlePaint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint(1);
            this.afterDeleteProgressPaint = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.afterDeleteProgressPaint.setStrokeCap(Paint.Cap.ROUND);
            this.afterDeleteProgressPaint.setColor(-1644826);
            this.afterDeleteProgressPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
            Paint paint3 = new Paint(1);
            this.circlePaint = paint3;
            paint3.setColor(2130706432);
            this.drawable = context.getResources().getDrawable(R.drawable.flame_small);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDestroyTime(long j, long j2, boolean z) {
            this.destroyTime = j;
            this.destroyTtl = j2;
            this.useVideoProgress = z;
            invalidate();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.deleteProgressRect.set(getMeasuredWidth() - AndroidUtilities.dp(49.0f), (getMeasuredHeight() / 2) - (AndroidUtilities.dp(28.0f) / 2), getMeasuredWidth() - AndroidUtilities.dp(21.0f), r6 + AndroidUtilities.dp(28.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (SecretMediaViewer.this.currentMessageObject == null || SecretMediaViewer.this.currentMessageObject.messageOwner.destroyTime == 0) {
                return;
            }
            canvas.drawCircle(getMeasuredWidth() - AndroidUtilities.dp(35.0f), getMeasuredHeight() / 2, AndroidUtilities.dp(16.0f), this.circlePaint);
            float fMax = 1.0f;
            if (this.useVideoProgress) {
                if (SecretMediaViewer.this.videoPlayer != null) {
                    long duration = SecretMediaViewer.this.videoPlayer.getDuration();
                    long currentPosition = SecretMediaViewer.this.videoPlayer.getCurrentPosition();
                    if (duration != -9223372036854775807L && currentPosition != -9223372036854775807L) {
                        fMax = 1.0f - (currentPosition / duration);
                    }
                }
            } else {
                fMax = Math.max(0L, this.destroyTime - (System.currentTimeMillis() + (ConnectionsManager.getInstance(SecretMediaViewer.this.currentAccount).getTimeDifference() * CloseCodes.NORMAL_CLOSURE))) / (this.destroyTtl * 1000.0f);
            }
            int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(40.0f);
            int measuredHeight = ((getMeasuredHeight() - AndroidUtilities.dp(14.0f)) / 2) - AndroidUtilities.dp(0.5f);
            this.drawable.setBounds(measuredWidth, measuredHeight, AndroidUtilities.dp(10.0f) + measuredWidth, AndroidUtilities.dp(14.0f) + measuredHeight);
            this.drawable.draw(canvas);
            float f = (-360.0f) * fMax;
            canvas.drawArc(this.deleteProgressRect, -90.0f, f, false, this.afterDeleteProgressPaint);
            this.timerParticles.draw(canvas, this.particlePaint, this.deleteProgressRect, f, 1.0f);
            invalidate();
        }
    }

    private class PhotoBackgroundDrawable extends ColorDrawable {
        private Runnable drawRunnable;
        private int frame;

        public PhotoBackgroundDrawable(int i) {
            super(i);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        @Keep
        public void setAlpha(int i) {
            if (SecretMediaViewer.this.parentActivity instanceof LaunchActivity) {
                ((LaunchActivity) SecretMediaViewer.this.parentActivity).drawerLayoutContainer.setAllowDrawContent((SecretMediaViewer.this.isPhotoVisible && i == 255) ? false : true);
            }
            super.setAlpha(i);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Runnable runnable;
            super.draw(canvas);
            if (getAlpha() != 0) {
                if (this.frame == 2 && (runnable = this.drawRunnable) != null) {
                    runnable.run();
                    this.drawRunnable = null;
                } else {
                    invalidateSelf();
                }
                this.frame++;
            }
        }
    }

    public static SecretMediaViewer getInstance() {
        SecretMediaViewer secretMediaViewer = Instance;
        if (secretMediaViewer == null) {
            synchronized (PhotoViewer.class) {
                secretMediaViewer = Instance;
                if (secretMediaViewer == null) {
                    secretMediaViewer = new SecretMediaViewer();
                    Instance = secretMediaViewer;
                }
            }
        }
        return secretMediaViewer;
    }

    public static boolean hasInstance() {
        return Instance != null;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.messagesDeleted) {
            if (!((Boolean) objArr[2]).booleanValue() && this.currentMessageObject != null && ((Integer) objArr[1]).intValue() == 0 && ((ArrayList) objArr[0]).contains(Long.valueOf(this.currentMessageObject.getId()))) {
                if (this.isVideo && !this.videoWatchedOneTime) {
                    this.closeVideoAfterWatch = true;
                    return;
                } else {
                    closePhoto(true, true);
                    return;
                }
            }
            return;
        }
        if (i == NotificationCenter.didCreatedNewDeleteTask) {
            if (this.currentMessageObject == null || this.secretDeleteTimer == null) {
                return;
            }
            SparseArray sparseArray = (SparseArray) objArr[0];
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                int iKeyAt = sparseArray.keyAt(i3);
                ArrayList arrayList = (ArrayList) sparseArray.get(iKeyAt);
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    long jLongValue = ((Long) arrayList.get(i4)).longValue();
                    if (i4 == 0) {
                        int i5 = (int) (jLongValue >> 32);
                        if (i5 < 0) {
                            i5 = 0;
                        }
                        if (i5 != this.currentChannelId) {
                            return;
                        }
                    }
                    if (this.currentMessageObject.getId() == jLongValue) {
                        this.currentMessageObject.messageOwner.destroyTime = iKeyAt;
                        this.secretDeleteTimer.invalidate();
                        return;
                    }
                }
            }
            return;
        }
        if (i == NotificationCenter.updateMessageMedia) {
            if (this.currentMessageObject.getId() == ((TLRPC$Message) objArr[0]).id) {
                if (this.isVideo && !this.videoWatchedOneTime) {
                    this.closeVideoAfterWatch = true;
                } else {
                    closePhoto(true, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePlayer(File file) {
        if (this.parentActivity == null) {
            return;
        }
        releasePlayer();
        if (this.videoTextureView == null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.parentActivity);
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            aspectRatioFrameLayout.setVisibility(4);
            this.containerView.addView(this.aspectRatioFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
            TextureView textureView = new TextureView(this.parentActivity);
            this.videoTextureView = textureView;
            textureView.setOpaque(false);
            this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1, 17));
        }
        this.textureUploaded = false;
        this.videoCrossfadeStarted = false;
        TextureView textureView2 = this.videoTextureView;
        this.videoCrossfadeAlpha = 0.0f;
        textureView2.setAlpha(0.0f);
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = new VideoPlayer();
            this.videoPlayer = videoPlayer;
            videoPlayer.setTextureView(this.videoTextureView);
            this.videoPlayer.setDelegate(new AnonymousClass1(file));
        }
        this.videoPlayer.preparePlayer(Uri.fromFile(file), "other");
        this.videoPlayer.setPlayWhenReady(true);
    }

    /* renamed from: org.rbmain.ui.SecretMediaViewer$1, reason: invalid class name */
    class AnonymousClass1 implements VideoPlayer.VideoPlayerDelegate {
        final /* synthetic */ File val$file;

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass1(File file) {
            this.val$file = file;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean z, int i) {
            if (SecretMediaViewer.this.videoPlayer == null || SecretMediaViewer.this.currentMessageObject == null) {
                return;
            }
            if (i == 4 || i == 1) {
                try {
                    SecretMediaViewer.this.parentActivity.getWindow().clearFlags(128);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else {
                try {
                    SecretMediaViewer.this.parentActivity.getWindow().addFlags(128);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            if (i == 3 && SecretMediaViewer.this.aspectRatioFrameLayout.getVisibility() != 0) {
                SecretMediaViewer.this.aspectRatioFrameLayout.setVisibility(0);
            }
            if (!SecretMediaViewer.this.videoPlayer.isPlaying() || i == 4) {
                if (SecretMediaViewer.this.isPlaying) {
                    SecretMediaViewer.this.isPlaying = false;
                    if (i == 4) {
                        SecretMediaViewer.this.videoWatchedOneTime = true;
                        if (!SecretMediaViewer.this.closeVideoAfterWatch) {
                            SecretMediaViewer.this.videoPlayer.seekTo(0L);
                            SecretMediaViewer.this.videoPlayer.play();
                            return;
                        } else {
                            SecretMediaViewer.this.closePhoto(true, true);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (SecretMediaViewer.this.isPlaying) {
                return;
            }
            SecretMediaViewer.this.isPlaying = true;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer videoPlayer, Exception exc) {
            if (SecretMediaViewer.this.playerRetryPlayCount > 0) {
                SecretMediaViewer.access$1110(SecretMediaViewer.this);
                final File file = this.val$file;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SecretMediaViewer$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$0(file);
                    }
                }, 100L);
                return;
            }
            FileLog.e(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0(File file) {
            SecretMediaViewer.this.preparePlayer(file);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            if (SecretMediaViewer.this.aspectRatioFrameLayout != null) {
                if (i3 != 90 && i3 != 270) {
                    i2 = i;
                    i = i2;
                }
                SecretMediaViewer.this.aspectRatioFrameLayout.setAspectRatio(i == 0 ? 1.0f : (i2 * f) / i, i3);
            }
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (SecretMediaViewer.this.textureUploaded) {
                return;
            }
            SecretMediaViewer.this.textureUploaded = true;
            SecretMediaViewer.this.containerView.invalidate();
        }
    }

    private void releasePlayer() {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            this.playerRetryPlayCount = 0;
            videoPlayer.releasePlayer(true);
            this.videoPlayer = null;
        }
        try {
            Activity activity = this.parentActivity;
            if (activity != null) {
                activity.getWindow().clearFlags(128);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            this.containerView.removeView(aspectRatioFrameLayout);
            this.aspectRatioFrameLayout = null;
        }
        if (this.videoTextureView != null) {
            this.videoTextureView = null;
        }
        this.isPlaying = false;
    }

    public void setParentActivity(Activity activity) {
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.centerImage.setCurrentAccount(i);
        if (this.parentActivity == activity) {
            return;
        }
        this.parentActivity = activity;
        this.scroller = new Scroller(activity);
        FrameLayout frameLayout = new FrameLayout(activity) { // from class: org.rbmain.ui.SecretMediaViewer.2
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 21 && SecretMediaViewer.this.lastInsets != null) {
                    WindowInsets windowInsets = (WindowInsets) SecretMediaViewer.this.lastInsets;
                    if (AndroidUtilities.incorrectDisplaySizeFix) {
                        int i5 = AndroidUtilities.displaySize.y;
                        if (size2 > i5) {
                            size2 = i5;
                        }
                        size2 += AndroidUtilities.statusBarHeight;
                    }
                    size2 -= windowInsets.getSystemWindowInsetBottom();
                    size -= windowInsets.getSystemWindowInsetRight();
                } else {
                    int i6 = AndroidUtilities.displaySize.y;
                    if (size2 > i6) {
                        size2 = i6;
                    }
                }
                setMeasuredDimension(size, size2);
                if (i4 >= 21 && SecretMediaViewer.this.lastInsets != null) {
                    size -= ((WindowInsets) SecretMediaViewer.this.lastInsets).getSystemWindowInsetLeft();
                }
                SecretMediaViewer.this.containerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                int systemWindowInsetLeft = (Build.VERSION.SDK_INT < 21 || SecretMediaViewer.this.lastInsets == null) ? 0 : ((WindowInsets) SecretMediaViewer.this.lastInsets).getSystemWindowInsetLeft() + 0;
                SecretMediaViewer.this.containerView.layout(systemWindowInsetLeft, 0, SecretMediaViewer.this.containerView.getMeasuredWidth() + systemWindowInsetLeft, SecretMediaViewer.this.containerView.getMeasuredHeight());
                if (z) {
                    if (SecretMediaViewer.this.imageMoveAnimation == null) {
                        SecretMediaViewer.this.scale = 1.0f;
                        SecretMediaViewer.this.translationX = 0.0f;
                        SecretMediaViewer.this.translationY = 0.0f;
                    }
                    SecretMediaViewer secretMediaViewer = SecretMediaViewer.this;
                    secretMediaViewer.updateMinMax(secretMediaViewer.scale);
                }
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                if (Build.VERSION.SDK_INT < 21 || !SecretMediaViewer.this.isVisible || SecretMediaViewer.this.lastInsets == null) {
                    return;
                }
                WindowInsets windowInsets = (WindowInsets) SecretMediaViewer.this.lastInsets;
                if (SecretMediaViewer.this.photoAnimationInProgress != 0) {
                    SecretMediaViewer.this.blackPaint.setAlpha(SecretMediaViewer.this.photoBackgroundDrawable.getAlpha());
                } else {
                    SecretMediaViewer.this.blackPaint.setAlpha(255);
                }
                canvas.drawRect(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight() + windowInsets.getSystemWindowInsetBottom(), SecretMediaViewer.this.blackPaint);
            }
        };
        this.windowView = frameLayout;
        frameLayout.setBackgroundDrawable(this.photoBackgroundDrawable);
        this.windowView.setFocusable(true);
        this.windowView.setFocusableInTouchMode(true);
        FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(activity) { // from class: org.rbmain.ui.SecretMediaViewer.3
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                if (SecretMediaViewer.this.secretDeleteTimer != null) {
                    int currentActionBarHeight = ((ActionBar.getCurrentActionBarHeight() - SecretMediaViewer.this.secretDeleteTimer.getMeasuredHeight()) / 2) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
                    SecretMediaViewer.this.secretDeleteTimer.layout(SecretMediaViewer.this.secretDeleteTimer.getLeft(), currentActionBarHeight, SecretMediaViewer.this.secretDeleteTimer.getRight(), SecretMediaViewer.this.secretDeleteTimer.getMeasuredHeight() + currentActionBarHeight);
                }
            }
        };
        this.containerView = frameLayoutDrawer;
        frameLayoutDrawer.setFocusable(false);
        this.windowView.addView(this.containerView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.containerView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 51;
        this.containerView.setLayoutParams(layoutParams);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.containerView.setFitsSystemWindows(true);
            this.containerView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: org.rbmain.ui.SecretMediaViewer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$setParentActivity$0(view, windowInsets);
                }
            });
            this.containerView.setSystemUiVisibility(1280);
        }
        GestureDetector gestureDetector = new GestureDetector(this.containerView.getContext(), this);
        this.gestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        ActionBar actionBar = new ActionBar(activity);
        this.actionBar = actionBar;
        actionBar.setTitleColor(-1);
        this.actionBar.setSubtitleColor(-1);
        this.actionBar.setBackgroundColor(2130706432);
        this.actionBar.setOccupyStatusBar(i2 >= 21);
        this.actionBar.setItemsBackgroundColor(1090519039, false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitleRightMargin(AndroidUtilities.dp(70.0f));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.SecretMediaViewer.4
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i3) {
                if (i3 == -1) {
                    SecretMediaViewer.this.closePhoto(true, false);
                }
            }
        });
        SecretDeleteTimer secretDeleteTimer = new SecretDeleteTimer(activity);
        this.secretDeleteTimer = secretDeleteTimer;
        this.containerView.addView(secretDeleteTimer, LayoutHelper.createFrame(119, 48.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams2;
        layoutParams2.height = -1;
        layoutParams2.format = -3;
        layoutParams2.width = -1;
        layoutParams2.gravity = 48;
        layoutParams2.type = 99;
        if (i2 >= 21) {
            layoutParams2.flags = -2147417848;
        } else {
            layoutParams2.flags = 8;
        }
        layoutParams2.flags |= 8192;
        this.centerImage.setParentView(this.containerView);
        this.centerImage.setForceCrossfade(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$setParentActivity$0(View view, WindowInsets windowInsets) {
        WindowInsets windowInsets2 = (WindowInsets) this.lastInsets;
        this.lastInsets = windowInsets;
        if (windowInsets2 == null || !windowInsets2.toString().equals(windowInsets.toString())) {
            this.windowView.requestLayout();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return WindowInsets.CONSUMED;
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    public void openMedia(MessageObject messageObject, PhotoViewer.PhotoViewerProvider photoViewerProvider, final Runnable runnable) {
        final PhotoViewer.PlaceProviderObject placeForPhoto;
        char c;
        if (this.parentActivity == null || messageObject == null || !messageObject.needDrawBluredPreview() || photoViewerProvider == null || (placeForPhoto = photoViewerProvider.getPlaceForPhoto(messageObject, null, 0, true)) == null) {
            return;
        }
        this.currentProvider = photoViewerProvider;
        this.openTime = System.currentTimeMillis();
        this.closeTime = 0L;
        this.isActionBarVisible = true;
        this.isPhotoVisible = true;
        this.draggingDown = false;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setVisibility(4);
        }
        releasePlayer();
        this.pinchStartDistance = 0.0f;
        this.pinchStartScale = 1.0f;
        this.pinchCenterX = 0.0f;
        this.pinchCenterY = 0.0f;
        this.pinchStartX = 0.0f;
        this.pinchStartY = 0.0f;
        this.moveStartX = 0.0f;
        this.moveStartY = 0.0f;
        this.zooming = false;
        this.moving = false;
        this.doubleTap = false;
        this.invalidCoords = false;
        this.canDragDown = true;
        updateMinMax(this.scale);
        this.photoBackgroundDrawable.setAlpha(0);
        this.containerView.setAlpha(1.0f);
        this.containerView.setVisibility(0);
        this.secretDeleteTimer.setAlpha(1.0f);
        this.isVideo = false;
        this.videoWatchedOneTime = false;
        this.closeVideoAfterWatch = false;
        this.disableShowCheck = true;
        this.centerImage.setManualAlphaAnimator(false);
        RectF drawRegion = placeForPhoto.imageReceiver.getDrawRegion();
        float fWidth = drawRegion.width();
        float fHeight = drawRegion.height();
        Point point = AndroidUtilities.displaySize;
        int i = point.x;
        int i2 = point.y;
        int i3 = Build.VERSION.SDK_INT;
        this.scale = Math.max(fWidth / i, fHeight / (i2 + (i3 >= 21 ? AndroidUtilities.statusBarHeight : 0)));
        float f = placeForPhoto.viewX;
        float f2 = drawRegion.left;
        this.translationX = ((f + f2) + (fWidth / 2.0f)) - (i / 2);
        this.translationY = ((placeForPhoto.viewY + drawRegion.top) + (fHeight / 2.0f)) - (r7 / 2);
        this.clipHorizontal = Math.abs(f2 - placeForPhoto.imageReceiver.getImageX());
        int iAbs = (int) Math.abs(drawRegion.top - placeForPhoto.imageReceiver.getImageY());
        int[] iArr = new int[2];
        placeForPhoto.parentView.getLocationInWindow(iArr);
        float f3 = iArr[1] - (i3 >= 21 ? 0 : AndroidUtilities.statusBarHeight);
        int i4 = placeForPhoto.viewY;
        float f4 = drawRegion.top;
        float f5 = (f3 - (i4 + f4)) + placeForPhoto.clipTopAddition;
        this.clipTop = f5;
        if (f5 < 0.0f) {
            this.clipTop = 0.0f;
        }
        float height = (((i4 + f4) + ((int) fHeight)) - ((iArr[1] + placeForPhoto.parentView.getHeight()) - (i3 >= 21 ? 0 : AndroidUtilities.statusBarHeight))) + placeForPhoto.clipBottomAddition;
        this.clipBottom = height;
        if (height < 0.0f) {
            this.clipBottom = 0.0f;
        }
        float f6 = iAbs;
        this.clipTop = Math.max(this.clipTop, f6);
        this.clipBottom = Math.max(this.clipBottom, f6);
        this.animationStartTime = System.currentTimeMillis();
        this.animateToX = 0.0f;
        this.animateToY = 0.0f;
        this.animateToClipBottom = 0.0f;
        this.animateToClipHorizontal = 0.0f;
        this.animateToClipTop = 0.0f;
        this.animateToScale = 1.0f;
        this.zoomAnimation = true;
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateMessageMedia);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didCreatedNewDeleteTask);
        TLRPC$Peer tLRPC$Peer = messageObject.messageOwner.peer_id;
        this.currentChannelId = tLRPC$Peer != null ? tLRPC$Peer.channel_id : 0;
        toggleActionBar(true, false);
        this.currentMessageObject = messageObject;
        TLRPC$Document document = messageObject.getDocument();
        ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
        if (bitmapHolder != null) {
            bitmapHolder.release();
            this.currentThumb = null;
        }
        this.currentThumb = placeForPhoto.imageReceiver.getThumbBitmapSafe();
        if (document != null) {
            if (MessageObject.isGifDocument(document)) {
                this.actionBar.setTitle(LocaleController.getString("DisappearingGif", R.string.DisappearingGif));
                c = 4;
                this.centerImage.setImage(ImageLocation.getForDocument(document), (String) null, this.currentThumb != null ? new BitmapDrawable(this.currentThumb.bitmap) : null, -1L, (String) null, messageObject, 1);
                SecretDeleteTimer secretDeleteTimer = this.secretDeleteTimer;
                TLRPC$Message tLRPC$Message = messageObject.messageOwner;
                secretDeleteTimer.setDestroyTime(tLRPC$Message.destroyTime * 1000, tLRPC$Message.ttl, false);
            } else {
                c = 4;
                this.playerRetryPlayCount = 1;
                this.actionBar.setTitle(LocaleController.getString("DisappearingVideo", R.string.DisappearingVideo));
                File file = new File(messageObject.messageOwner.attachPath);
                if (file.exists()) {
                    preparePlayer(file);
                } else {
                    File pathToMessage = FileLoader.getPathToMessage(messageObject.messageOwner);
                    File file2 = new File(pathToMessage.getAbsolutePath() + ".enc");
                    if (file2.exists()) {
                        pathToMessage = file2;
                    }
                    preparePlayer(pathToMessage);
                }
                this.isVideo = true;
                this.centerImage.setImage((ImageLocation) null, (String) null, this.currentThumb != null ? new BitmapDrawable(this.currentThumb.bitmap) : null, -1L, (String) null, messageObject, 2);
                if (messageObject.getDuration() * CloseCodes.NORMAL_CLOSURE > (messageObject.messageOwner.destroyTime * 1000) - (System.currentTimeMillis() + (ConnectionsManager.getInstance(this.currentAccount).getTimeDifference() * CloseCodes.NORMAL_CLOSURE))) {
                    this.secretDeleteTimer.setDestroyTime(-1L, -1L, true);
                } else {
                    SecretDeleteTimer secretDeleteTimer2 = this.secretDeleteTimer;
                    TLRPC$Message tLRPC$Message2 = messageObject.messageOwner;
                    secretDeleteTimer2.setDestroyTime(tLRPC$Message2.destroyTime * 1000, tLRPC$Message2.ttl, false);
                }
            }
        } else {
            c = 4;
            this.actionBar.setTitle(LocaleController.getString("DisappearingPhoto", R.string.DisappearingPhoto));
            this.centerImage.setImage(ImageLocation.getForObject(FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize()), messageObject.photoThumbsObject), (String) null, this.currentThumb != null ? new BitmapDrawable(this.currentThumb.bitmap) : null, -1L, (String) null, messageObject, 2);
            SecretDeleteTimer secretDeleteTimer3 = this.secretDeleteTimer;
            TLRPC$Message tLRPC$Message3 = messageObject.messageOwner;
            secretDeleteTimer3.setDestroyTime(tLRPC$Message3.destroyTime * 1000, tLRPC$Message3.ttl, false);
        }
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        ((WindowManager) this.parentActivity.getSystemService("window")).addView(this.windowView, this.windowLayoutParams);
        this.secretDeleteTimer.invalidate();
        this.isVisible = true;
        AnimatorSet animatorSet = new AnimatorSet();
        this.imageMoveAnimation = animatorSet;
        Animator[] animatorArr = new Animator[5];
        animatorArr[0] = ObjectAnimator.ofFloat(this.actionBar, (Property<ActionBar, Float>) View.ALPHA, 0.0f, 1.0f);
        animatorArr[1] = ObjectAnimator.ofFloat(this.secretDeleteTimer, (Property<SecretDeleteTimer, Float>) View.ALPHA, 0.0f, 1.0f);
        animatorArr[2] = ObjectAnimator.ofInt(this.photoBackgroundDrawable, (Property<PhotoBackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 0, 255);
        animatorArr[3] = ObjectAnimator.ofFloat(this.secretDeleteTimer, (Property<SecretDeleteTimer, Float>) View.ALPHA, 0.0f, 1.0f);
        animatorArr[c] = ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f);
        animatorSet.playTogether(animatorArr);
        this.photoAnimationInProgress = 3;
        this.photoAnimationEndRunnable = new Runnable() { // from class: org.rbmain.ui.SecretMediaViewer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openMedia$1(runnable);
            }
        };
        this.imageMoveAnimation.setDuration(250L);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.SecretMediaViewer.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SecretMediaViewer.this.photoAnimationEndRunnable != null) {
                    SecretMediaViewer.this.photoAnimationEndRunnable.run();
                    SecretMediaViewer.this.photoAnimationEndRunnable = null;
                }
            }
        });
        this.photoTransitionAnimationStartTime = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 18) {
            this.containerView.setLayerType(2, null);
        }
        this.imageMoveAnimation.setInterpolator(new DecelerateInterpolator());
        this.photoBackgroundDrawable.frame = 0;
        this.photoBackgroundDrawable.drawRunnable = new Runnable() { // from class: org.rbmain.ui.SecretMediaViewer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openMedia$2(placeForPhoto);
            }
        };
        this.imageMoveAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openMedia$1(Runnable runnable) {
        this.photoAnimationInProgress = 0;
        this.imageMoveAnimation = null;
        if (runnable != null) {
            runnable.run();
        }
        FrameLayoutDrawer frameLayoutDrawer = this.containerView;
        if (frameLayoutDrawer == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            frameLayoutDrawer.setLayerType(0, null);
        }
        this.containerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openMedia$2(PhotoViewer.PlaceProviderObject placeProviderObject) {
        this.disableShowCheck = false;
        placeProviderObject.imageReceiver.setVisible(false, true);
    }

    public boolean isShowingImage(MessageObject messageObject) {
        MessageObject messageObject2;
        return (!this.isVisible || this.disableShowCheck || messageObject == null || (messageObject2 = this.currentMessageObject) == null || messageObject2.getId() != messageObject.getId()) ? false : true;
    }

    private void toggleActionBar(boolean z, boolean z2) {
        if (z) {
            this.actionBar.setVisibility(0);
        }
        this.actionBar.setEnabled(z);
        this.isActionBarVisible = z;
        if (z2) {
            ArrayList arrayList = new ArrayList();
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr));
            AnimatorSet animatorSet = new AnimatorSet();
            this.currentActionBarAnimation = animatorSet;
            animatorSet.playTogether(arrayList);
            if (!z) {
                this.currentActionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.SecretMediaViewer.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (SecretMediaViewer.this.currentActionBarAnimation == null || !SecretMediaViewer.this.currentActionBarAnimation.equals(animator)) {
                            return;
                        }
                        SecretMediaViewer.this.actionBar.setVisibility(8);
                        SecretMediaViewer.this.currentActionBarAnimation = null;
                    }
                });
            }
            this.currentActionBarAnimation.setDuration(200L);
            this.currentActionBarAnimation.start();
            return;
        }
        this.actionBar.setAlpha(z ? 1.0f : 0.0f);
        if (z) {
            return;
        }
        this.actionBar.setVisibility(8);
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void destroyPhotoViewer() {
        FrameLayout frameLayout;
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateMessageMedia);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didCreatedNewDeleteTask);
        this.isVisible = false;
        this.currentProvider = null;
        ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
        if (bitmapHolder != null) {
            bitmapHolder.release();
            this.currentThumb = null;
        }
        releasePlayer();
        if (this.parentActivity != null && (frameLayout = this.windowView) != null) {
            try {
                if (frameLayout.getParent() != null) {
                    ((WindowManager) this.parentActivity.getSystemService("window")).removeViewImmediate(this.windowView);
                }
                this.windowView = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        Instance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.SecretMediaViewer.onDraw(android.graphics.Canvas):void");
    }

    @Keep
    public float getVideoCrossfadeAlpha() {
        return this.videoCrossfadeAlpha;
    }

    @Keep
    public void setVideoCrossfadeAlpha(float f) {
        this.videoCrossfadeAlpha = f;
        this.containerView.invalidate();
    }

    private boolean checkPhotoAnimation() {
        if (this.photoAnimationInProgress != 0 && Math.abs(this.photoTransitionAnimationStartTime - System.currentTimeMillis()) >= 500) {
            Runnable runnable = this.photoAnimationEndRunnable;
            if (runnable != null) {
                runnable.run();
                this.photoAnimationEndRunnable = null;
            }
            this.photoAnimationInProgress = 0;
        }
        return this.photoAnimationInProgress != 0;
    }

    public long getOpenTime() {
        return this.openTime;
    }

    public long getCloseTime() {
        return this.closeTime;
    }

    public MessageObject getCurrentMessageObject() {
        return this.currentMessageObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void closePhoto(boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.SecretMediaViewer.closePhoto(boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePhoto$3(PhotoViewer.PlaceProviderObject placeProviderObject) {
        this.imageMoveAnimation = null;
        this.photoAnimationInProgress = 0;
        if (Build.VERSION.SDK_INT >= 18) {
            this.containerView.setLayerType(0, null);
        }
        this.containerView.setVisibility(4);
        onPhotoClosed(placeProviderObject);
    }

    /* renamed from: org.rbmain.ui.SecretMediaViewer$7, reason: invalid class name */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        final /* synthetic */ PhotoViewer.PlaceProviderObject val$object;

        AnonymousClass7(PhotoViewer.PlaceProviderObject placeProviderObject) {
            this.val$object = placeProviderObject;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoViewer.PlaceProviderObject placeProviderObject = this.val$object;
            if (placeProviderObject != null) {
                placeProviderObject.imageReceiver.setVisible(true, true);
            }
            SecretMediaViewer.this.isVisible = false;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SecretMediaViewer$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            if (SecretMediaViewer.this.photoAnimationEndRunnable != null) {
                SecretMediaViewer.this.photoAnimationEndRunnable.run();
                SecretMediaViewer.this.photoAnimationEndRunnable = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePhoto$4(PhotoViewer.PlaceProviderObject placeProviderObject) {
        FrameLayoutDrawer frameLayoutDrawer = this.containerView;
        if (frameLayoutDrawer == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            frameLayoutDrawer.setLayerType(0, null);
        }
        this.containerView.setVisibility(4);
        this.photoAnimationInProgress = 0;
        onPhotoClosed(placeProviderObject);
        this.containerView.setScaleX(1.0f);
        this.containerView.setScaleY(1.0f);
    }

    private void onPhotoClosed(PhotoViewer.PlaceProviderObject placeProviderObject) {
        this.isVisible = false;
        this.currentProvider = null;
        this.disableShowCheck = false;
        releasePlayer();
        new ArrayList();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SecretMediaViewer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPhotoClosed$5();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPhotoClosed$5() {
        ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
        if (bitmapHolder != null) {
            bitmapHolder.release();
            this.currentThumb = null;
        }
        this.centerImage.setImageBitmap((Bitmap) null);
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.isPhotoVisible = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMinMax(float f) {
        int imageWidth = ((int) ((this.centerImage.getImageWidth() * f) - getContainerViewWidth())) / 2;
        int imageHeight = ((int) ((this.centerImage.getImageHeight() * f) - getContainerViewHeight())) / 2;
        if (imageWidth > 0) {
            this.minX = -imageWidth;
            this.maxX = imageWidth;
        } else {
            this.maxX = 0.0f;
            this.minX = 0.0f;
        }
        if (imageHeight > 0) {
            this.minY = -imageHeight;
            this.maxY = imageHeight;
        } else {
            this.maxY = 0.0f;
            this.minY = 0.0f;
        }
    }

    private int getContainerViewWidth() {
        return this.containerView.getWidth();
    }

    private int getContainerViewHeight() {
        return this.containerView.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0266 A[PHI: r3
      0x0266: PHI (r3v31 float) = (r3v26 float), (r3v27 float) binds: [B:112:0x0264, B:115:0x026c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0275 A[PHI: r3
      0x0275: PHI (r3v30 float) = (r3v28 float), (r3v29 float) binds: [B:118:0x0273, B:121:0x027b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02d7 A[PHI: r3
      0x02d7: PHI (r3v8 float) = (r3v3 float), (r3v4 float) binds: [B:141:0x02d5, B:144:0x02dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e8 A[PHI: r3
      0x02e8: PHI (r3v7 float) = (r3v5 float), (r3v6 float) binds: [B:147:0x02e6, B:150:0x02ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean processTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.SecretMediaViewer.processTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[PHI: r3
      0x0022: PHI (r3v4 float) = (r3v2 float), (r3v3 float) binds: [B:9:0x0020, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011 A[PHI: r3
      0x0011: PHI (r3v5 float) = (r3v0 float), (r3v1 float) binds: [B:3:0x000f, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkMinMax(boolean r6) {
        /*
            r5 = this;
            float r0 = r5.translationX
            float r1 = r5.translationY
            float r2 = r5.scale
            r5.updateMinMax(r2)
            float r2 = r5.translationX
            float r3 = r5.minX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L13
        L11:
            r0 = r3
            goto L1a
        L13:
            float r3 = r5.maxX
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L1a
            goto L11
        L1a:
            float r2 = r5.translationY
            float r3 = r5.minY
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
        L22:
            r1 = r3
            goto L2b
        L24:
            float r3 = r5.maxY
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L2b
            goto L22
        L2b:
            float r2 = r5.scale
            r5.animateTo(r2, r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.SecretMediaViewer.checkMinMax(boolean):void");
    }

    private void animateTo(float f, float f2, float f3, boolean z) {
        animateTo(f, f2, f3, z, 250);
    }

    private void animateTo(float f, float f2, float f3, boolean z, int i) {
        if (this.scale == f && this.translationX == f2 && this.translationY == f3) {
            return;
        }
        this.zoomAnimation = z;
        this.animateToScale = f;
        this.animateToX = f2;
        this.animateToY = f3;
        this.animationStartTime = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.imageMoveAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f));
        this.imageMoveAnimation.setInterpolator(this.interpolator);
        this.imageMoveAnimation.setDuration(i);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.SecretMediaViewer.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SecretMediaViewer.this.imageMoveAnimation = null;
                SecretMediaViewer.this.containerView.invalidate();
            }
        });
        this.imageMoveAnimation.start();
    }

    @Keep
    public void setAnimationValue(float f) {
        this.animationValue = f;
        this.containerView.invalidate();
    }

    @Keep
    public float getAnimationValue() {
        return this.animationValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.scale == 1.0f) {
            return false;
        }
        this.scroller.abortAnimation();
        this.scroller.fling(Math.round(this.translationX), Math.round(this.translationY), Math.round(f), Math.round(f2), (int) this.minX, (int) this.maxX, (int) this.minY, (int) this.maxY);
        this.containerView.postInvalidate();
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.discardTap) {
            return false;
        }
        toggleActionBar(!this.isActionBarVisible, true);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[PHI: r10
      0x0079: PHI (r10v10 float) = (r10v5 float), (r10v6 float) binds: [B:17:0x0077, B:20:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[PHI: r10
      0x0088: PHI (r10v9 float) = (r10v7 float), (r10v8 float) binds: [B:23:0x0086, B:26:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onDoubleTap(android.view.MotionEvent r10) {
        /*
            r9 = this;
            float r0 = r9.scale
            r1 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L17
            float r4 = r9.translationY
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L16
            float r4 = r9.translationX
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L17
        L16:
            return r1
        L17:
            long r4 = r9.animationStartTime
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L9a
            int r4 = r9.photoAnimationInProgress
            if (r4 == 0) goto L25
            goto L9a
        L25:
            r1 = 1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L95
            float r0 = r10.getX()
            int r2 = r9.getContainerViewWidth()
            int r2 = r2 / 2
            float r2 = (float) r2
            float r0 = r0 - r2
            float r2 = r10.getX()
            int r3 = r9.getContainerViewWidth()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r2 = r2 - r3
            float r3 = r9.translationX
            float r2 = r2 - r3
            float r3 = r9.scale
            r4 = 1077936128(0x40400000, float:3.0)
            float r3 = r4 / r3
            float r2 = r2 * r3
            float r0 = r0 - r2
            float r2 = r10.getY()
            int r3 = r9.getContainerViewHeight()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r2 = r2 - r3
            float r10 = r10.getY()
            int r3 = r9.getContainerViewHeight()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r10 = r10 - r3
            float r3 = r9.translationY
            float r10 = r10 - r3
            float r3 = r9.scale
            float r3 = r4 / r3
            float r10 = r10 * r3
            float r2 = r2 - r10
            r9.updateMinMax(r4)
            float r10 = r9.minX
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 >= 0) goto L7b
        L79:
            r0 = r10
            goto L82
        L7b:
            float r10 = r9.maxX
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 <= 0) goto L82
            goto L79
        L82:
            float r10 = r9.minY
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 >= 0) goto L8a
        L88:
            r2 = r10
            goto L91
        L8a:
            float r10 = r9.maxY
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 <= 0) goto L91
            goto L88
        L91:
            r9.animateTo(r4, r0, r2, r1)
            goto L98
        L95:
            r9.animateTo(r2, r3, r3, r1)
        L98:
            r9.doubleTap = r1
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.SecretMediaViewer.onDoubleTap(android.view.MotionEvent):boolean");
    }
}
