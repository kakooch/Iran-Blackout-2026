package ir.eitaa.ui.Components.voip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.voip.VoIPPiPView;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.VoIPFragment;
import org.webrtc.EglBase;

/* loaded from: classes3.dex */
public class VoIPPiPView implements VoIPService.StateListener, NotificationCenter.NotificationCenterDelegate {
    public static int bottomInset = 0;
    private static VoIPPiPView expandedInstance = null;
    private static VoIPPiPView instance = null;
    public static boolean switchingToPip = false;
    public static int topInset;
    ValueAnimator animatorToCameraMini;
    boolean callingUserIsVideo;
    public final VoIPTextureView callingUserTextureView;
    ImageView closeIcon;
    private int currentAccount;
    boolean currentUserIsVideo;
    public final VoIPTextureView currentUserTextureView;
    ImageView enlargeIcon;
    ValueAnimator expandAnimator;
    public boolean expanded;
    private boolean expandedAnimationInProgress;
    FloatingView floatingView;
    AnimatorSet moveToBoundsAnimator;
    boolean moving;
    public final int parentHeight;
    public final int parentWidth;
    float progressToCameraMini;
    long startTime;
    float startX;
    float startY;
    View topShadow;
    public WindowManager.LayoutParams windowLayoutParams;
    private WindowManager windowManager;
    public FrameLayout windowView;
    public int xOffset;
    public int yOffset;
    ValueAnimator.AnimatorUpdateListener animatorToCameraMiniUpdater = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$YulSZDE1L7y7hepUt1u6erRM1fI
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f$0.lambda$new$0$VoIPPiPView(valueAnimator);
        }
    };
    float[] point = new float[2];
    int animationIndex = -1;
    Runnable collapseRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.voip.VoIPPiPView.1
        @Override // java.lang.Runnable
        public void run() {
            if (VoIPPiPView.instance != null) {
                VoIPPiPView.instance.floatingView.expand(false);
            }
        }
    };
    private ValueAnimator.AnimatorUpdateListener updateXlistener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.VoIPPiPView.2
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            VoIPPiPView voIPPiPView = VoIPPiPView.this;
            voIPPiPView.windowLayoutParams.x = (int) fFloatValue;
            if (voIPPiPView.windowView.getParent() != null) {
                WindowManager windowManager = VoIPPiPView.this.windowManager;
                VoIPPiPView voIPPiPView2 = VoIPPiPView.this;
                windowManager.updateViewLayout(voIPPiPView2.windowView, voIPPiPView2.windowLayoutParams);
            }
        }
    };
    private ValueAnimator.AnimatorUpdateListener updateYlistener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.VoIPPiPView.3
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            VoIPPiPView voIPPiPView = VoIPPiPView.this;
            voIPPiPView.windowLayoutParams.y = (int) fFloatValue;
            if (voIPPiPView.windowView.getParent() != null) {
                WindowManager windowManager = VoIPPiPView.this.windowManager;
                VoIPPiPView voIPPiPView2 = VoIPPiPView.this;
                windowManager.updateViewLayout(voIPPiPView2.windowView, voIPPiPView2.windowLayoutParams);
            }
        }
    };

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onAudioSettingsChanged() {
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraFirstFrameAvailable() {
        VoIPService.StateListener.CC.$default$onCameraFirstFrameAvailable(this);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onSignalBarsCountChanged(int count) {
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onVideoAvailableChange(boolean isAvailable) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$VoIPPiPView(ValueAnimator valueAnimator) {
        this.progressToCameraMini = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.floatingView.invalidate();
    }

    public static void show(Activity activity, int account, int parentWidth, int parentHeight, int animationType) {
        WindowManager windowManager;
        if (instance != null || VideoCapturerDevice.eglBase == null) {
            return;
        }
        WindowManager.LayoutParams layoutParamsCreateWindowLayoutParams = createWindowLayoutParams(activity, parentWidth, parentHeight, 0.25f);
        instance = new VoIPPiPView(activity, parentWidth, parentHeight, false);
        if (AndroidUtilities.checkInlinePermissions(activity)) {
            windowManager = (WindowManager) ApplicationLoader.applicationContext.getSystemService("window");
        } else {
            windowManager = (WindowManager) activity.getSystemService("window");
        }
        VoIPPiPView voIPPiPView = instance;
        voIPPiPView.currentAccount = account;
        voIPPiPView.windowManager = windowManager;
        voIPPiPView.windowLayoutParams = layoutParamsCreateWindowLayoutParams;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("voippipconfig", 0);
        instance.setRelativePosition(sharedPreferences.getFloat("relativeX", 1.0f), sharedPreferences.getFloat("relativeY", 0.0f));
        NotificationCenter.getGlobalInstance().addObserver(instance, NotificationCenter.didEndCall);
        windowManager.addView(instance.windowView, layoutParamsCreateWindowLayoutParams);
        instance.currentUserTextureView.renderer.init(VideoCapturerDevice.eglBase.getEglBaseContext(), null);
        instance.callingUserTextureView.renderer.init(VideoCapturerDevice.eglBase.getEglBaseContext(), null);
        if (animationType != 0) {
            if (animationType == 1) {
                instance.windowView.setAlpha(0.0f);
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService sharedInstance = VoIPService.getSharedInstance();
                    VoIPPiPView voIPPiPView2 = instance;
                    sharedInstance.setBackgroundSinks(voIPPiPView2.currentUserTextureView.renderer, voIPPiPView2.callingUserTextureView.renderer);
                    return;
                }
                return;
            }
            return;
        }
        instance.windowView.setScaleX(0.5f);
        instance.windowView.setScaleY(0.5f);
        instance.windowView.setAlpha(0.0f);
        instance.windowView.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).start();
        if (VoIPService.getSharedInstance() != null) {
            VoIPService sharedInstance2 = VoIPService.getSharedInstance();
            VoIPPiPView voIPPiPView3 = instance;
            sharedInstance2.setSinks(voIPPiPView3.currentUserTextureView.renderer, voIPPiPView3.callingUserTextureView.renderer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WindowManager.LayoutParams createWindowLayoutParams(Context context, int parentWidth, int parentHeight, float scale) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        float f = parentHeight;
        float f2 = f * 0.4f;
        float f3 = parentWidth;
        float f4 = 0.4f * f3;
        layoutParams.height = (int) ((f * scale) + ((((int) ((f2 * 1.05f) - f2)) / 2) * 2));
        layoutParams.width = (int) ((f3 * scale) + ((((int) ((1.05f * f4) - f4)) / 2) * 2));
        layoutParams.gravity = 51;
        layoutParams.format = -3;
        if (AndroidUtilities.checkInlinePermissions(context)) {
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2003;
            }
        } else {
            layoutParams.type = 99;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            layoutParams.flags |= Integer.MIN_VALUE;
        }
        layoutParams.flags = 16778120;
        return layoutParams;
    }

    public static void prepareForTransition() {
        if (expandedInstance != null) {
            instance.expandAnimator.cancel();
        }
    }

    public static void finish() {
        if (switchingToPip) {
            return;
        }
        VoIPPiPView voIPPiPView = expandedInstance;
        if (voIPPiPView != null) {
            voIPPiPView.finishInternal();
        }
        VoIPPiPView voIPPiPView2 = instance;
        if (voIPPiPView2 != null) {
            voIPPiPView2.finishInternal();
        }
        expandedInstance = null;
        instance = null;
    }

    public static boolean isExpanding() {
        return instance.expanded;
    }

    private void setRelativePosition(float x, float y) {
        Point point = AndroidUtilities.displaySize;
        float f = point.x;
        float f2 = point.y;
        float fDp = AndroidUtilities.dp(16.0f);
        float fDp2 = AndroidUtilities.dp(16.0f);
        float fDp3 = AndroidUtilities.dp(60.0f);
        float fDp4 = AndroidUtilities.dp(16.0f);
        float measuredWidth = this.parentWidth * 0.25f;
        float measuredHeight = this.parentHeight * 0.25f;
        if (this.floatingView.getMeasuredWidth() != 0) {
            measuredWidth = this.floatingView.getMeasuredWidth();
        }
        if (this.floatingView.getMeasuredWidth() != 0) {
            measuredHeight = this.floatingView.getMeasuredHeight();
        }
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.x = (int) ((x * (((f - fDp) - fDp2) - measuredWidth)) - (this.xOffset - fDp));
        layoutParams.y = (int) ((y * (((f2 - fDp3) - fDp4) - measuredHeight)) - (this.yOffset - fDp3));
        if (this.windowView.getParent() != null) {
            this.windowManager.updateViewLayout(this.windowView, this.windowLayoutParams);
        }
    }

    public static VoIPPiPView getInstance() {
        VoIPPiPView voIPPiPView = expandedInstance;
        return voIPPiPView != null ? voIPPiPView : instance;
    }

    public VoIPPiPView(final Context context, int parentWidth, int parentHeight, boolean expanded) {
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
        float f = parentHeight * 0.4f;
        this.yOffset = ((int) ((f * 1.05f) - f)) / 2;
        float f2 = parentWidth * 0.4f;
        this.xOffset = ((int) ((1.05f * f2) - f2)) / 2;
        final Drawable drawable = ContextCompat.getDrawable(context, R.drawable.calls_pip_outershadow);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.voip.VoIPPiPView.4
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                canvas.save();
                canvas.scale(VoIPPiPView.this.floatingView.getScaleX(), VoIPPiPView.this.floatingView.getScaleY(), VoIPPiPView.this.floatingView.getLeft() + VoIPPiPView.this.floatingView.getPivotX(), VoIPPiPView.this.floatingView.getTop() + VoIPPiPView.this.floatingView.getPivotY());
                drawable.setBounds(VoIPPiPView.this.floatingView.getLeft() - AndroidUtilities.dp(2.0f), VoIPPiPView.this.floatingView.getTop() - AndroidUtilities.dp(2.0f), VoIPPiPView.this.floatingView.getRight() + AndroidUtilities.dp(2.0f), VoIPPiPView.this.floatingView.getBottom() + AndroidUtilities.dp(2.0f));
                drawable.draw(canvas);
                canvas.restore();
                super.onDraw(canvas);
            }
        };
        this.windowView = frameLayout;
        frameLayout.setWillNotDraw(false);
        FrameLayout frameLayout2 = this.windowView;
        int i = this.xOffset;
        int i2 = this.yOffset;
        frameLayout2.setPadding(i, i2, i, i2);
        this.floatingView = new FloatingView(context);
        VoIPTextureView voIPTextureView = new VoIPTextureView(context, false, true);
        this.callingUserTextureView = voIPTextureView;
        voIPTextureView.scaleType = VoIPTextureView.SCALE_TYPE_NONE;
        VoIPTextureView voIPTextureView2 = new VoIPTextureView(context, false, true);
        this.currentUserTextureView = voIPTextureView2;
        voIPTextureView2.renderer.setMirror(true);
        this.floatingView.addView(voIPTextureView);
        this.floatingView.addView(voIPTextureView2);
        this.floatingView.setBackgroundColor(-7829368);
        this.windowView.addView(this.floatingView);
        this.windowView.setClipChildren(false);
        this.windowView.setClipToPadding(false);
        if (expanded) {
            View view = new View(context);
            this.topShadow = view;
            view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtils.setAlphaComponent(-16777216, 76), 0}));
            this.floatingView.addView(this.topShadow, -1, AndroidUtilities.dp(60.0f));
            ImageView imageView = new ImageView(context);
            this.closeIcon = imageView;
            imageView.setImageResource(R.drawable.pip_close);
            this.closeIcon.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            this.closeIcon.setContentDescription(LocaleController.getString("Close", R.string.Close));
            this.floatingView.addView(this.closeIcon, LayoutHelper.createFrame(40, 40.0f, 53, 4.0f, 4.0f, 4.0f, 0.0f));
            ImageView imageView2 = new ImageView(context);
            this.enlargeIcon = imageView2;
            imageView2.setImageResource(R.drawable.pip_enlarge);
            this.enlargeIcon.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            this.enlargeIcon.setContentDescription(LocaleController.getString("Open", R.string.Open));
            this.floatingView.addView(this.enlargeIcon, LayoutHelper.createFrame(40, 40.0f, 51, 4.0f, 4.0f, 4.0f, 0.0f));
            this.closeIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$6OCDKm7N-VmE4yJTS7l_V2fAYCY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) throws IllegalStateException, InterruptedException {
                    VoIPPiPView.lambda$new$1(view2);
                }
            });
            this.enlargeIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$aDAghMOayjRjkfHbLGKmWcz_peY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$2$VoIPPiPView(context, view2);
                }
            });
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            sharedInstance.registerStateListener(this);
        }
        updateViewState();
    }

    static /* synthetic */ void lambda$new$1(View view) throws IllegalStateException, InterruptedException {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            sharedInstance.hangUp();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$VoIPPiPView(Context context, View view) {
        boolean z = context instanceof LaunchActivity;
        if (z && !ApplicationLoader.mainInterfacePaused) {
            VoIPFragment.show((Activity) context, this.currentAccount);
        } else if (z) {
            Intent intent = new Intent(context, (Class<?>) LaunchActivity.class);
            intent.setAction("voip");
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishInternal() {
        this.currentUserTextureView.renderer.release();
        this.callingUserTextureView.renderer.release();
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            sharedInstance.unregisterStateListener(this);
        }
        this.windowView.setVisibility(8);
        if (this.windowView.getParent() != null) {
            this.floatingView.getRelativePosition(this.point);
            float fMin = Math.min(1.0f, Math.max(0.0f, this.point[0]));
            ApplicationLoader.applicationContext.getSharedPreferences("voippipconfig", 0).edit().putFloat("relativeX", fMin).putFloat("relativeY", Math.min(1.0f, Math.max(0.0f, this.point[1]))).apply();
            try {
                this.windowManager.removeView(this.windowView);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didEndCall);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int state) {
        if (state == 11 || state == 17 || state == 4 || state == 10) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$f-xNi6kZl2zTsVPSkyESbl7aSDI
                @Override // java.lang.Runnable
                public final void run() {
                    VoIPPiPView.finish();
                }
            }, 200L);
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            finish();
        } else if (state == 3 && !sharedInstance.isVideoAvailable()) {
            finish();
        } else {
            updateViewState();
        }
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onMediaStateUpdated(int audioState, int videoState) {
        updateViewState();
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onCameraSwitch(boolean isFrontFace) {
        updateViewState();
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onScreenOnChange(boolean screenOn) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (!screenOn && this.currentUserIsVideo) {
            sharedInstance.setVideoState(false, 1);
        } else if (screenOn && sharedInstance.getVideoState(false) == 1) {
            sharedInstance.setVideoState(false, 2);
        }
    }

    private void updateViewState() {
        boolean z = this.floatingView.getMeasuredWidth() != 0;
        boolean z2 = this.callingUserIsVideo;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            this.callingUserIsVideo = sharedInstance.getRemoteVideoState() == 2;
            this.currentUserIsVideo = sharedInstance.getVideoState(false) == 2 || sharedInstance.getVideoState(false) == 1;
            this.currentUserTextureView.renderer.setMirror(sharedInstance.isFrontFaceCamera());
            this.currentUserTextureView.setIsScreencast(sharedInstance.isScreencast());
            this.currentUserTextureView.setScreenshareMiniProgress(1.0f, false);
        }
        if (!z) {
            this.progressToCameraMini = this.callingUserIsVideo ? 1.0f : 0.0f;
            return;
        }
        if (z2 != this.callingUserIsVideo) {
            ValueAnimator valueAnimator = this.animatorToCameraMini;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            float[] fArr = new float[2];
            fArr[0] = this.progressToCameraMini;
            fArr[1] = this.callingUserIsVideo ? 1.0f : 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            this.animatorToCameraMini = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.animatorToCameraMiniUpdater);
            this.animatorToCameraMini.setDuration(300L).setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.animatorToCameraMini.start();
        }
    }

    public void onTransitionEnd() {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().swapSinks();
        }
    }

    public void onPause() {
        if (this.windowLayoutParams.type == 99) {
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (this.currentUserIsVideo) {
                sharedInstance.setVideoState(false, 1);
            }
        }
    }

    public void onResume() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null || sharedInstance.getVideoState(false) != 1) {
            return;
        }
        sharedInstance.setVideoState(false, 2);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.didEndCall) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class FloatingView extends FrameLayout {
        float bottomPadding;
        float leftPadding;
        float rightPadding;
        float topPadding;
        float touchSlop;

        public FloatingView(Context context) {
            super(context);
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            if (Build.VERSION.SDK_INT >= 21) {
                setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.voip.VoIPPiPView.FloatingView.1
                    @Override // android.view.ViewOutlineProvider
                    @TargetApi(21)
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), (1.0f / view.getScaleX()) * AndroidUtilities.dp(4.0f));
                    }
                });
                setClipToOutline(true);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.leftPadding = AndroidUtilities.dp(16.0f);
            this.rightPadding = AndroidUtilities.dp(16.0f);
            this.topPadding = AndroidUtilities.dp(60.0f);
            this.bottomPadding = AndroidUtilities.dp(16.0f);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            VoIPPiPView.this.currentUserTextureView.setPivotX(r0.callingUserTextureView.getMeasuredWidth());
            VoIPPiPView.this.currentUserTextureView.setPivotY(r0.callingUserTextureView.getMeasuredHeight());
            VoIPPiPView.this.currentUserTextureView.setTranslationX((-AndroidUtilities.dp(4.0f)) * (1.0f / getScaleX()) * VoIPPiPView.this.progressToCameraMini);
            VoIPPiPView.this.currentUserTextureView.setTranslationY((-AndroidUtilities.dp(4.0f)) * (1.0f / getScaleY()) * VoIPPiPView.this.progressToCameraMini);
            VoIPPiPView.this.currentUserTextureView.setRoundCorners(AndroidUtilities.dp(8.0f) * (1.0f / getScaleY()) * VoIPPiPView.this.progressToCameraMini);
            VoIPPiPView voIPPiPView = VoIPPiPView.this;
            voIPPiPView.currentUserTextureView.setScaleX(((1.0f - voIPPiPView.progressToCameraMini) * 0.6f) + 0.4f);
            VoIPPiPView voIPPiPView2 = VoIPPiPView.this;
            voIPPiPView2.currentUserTextureView.setScaleY(((1.0f - voIPPiPView2.progressToCameraMini) * 0.6f) + 0.4f);
            VoIPPiPView voIPPiPView3 = VoIPPiPView.this;
            voIPPiPView3.currentUserTextureView.setAlpha(Math.min(1.0f, 1.0f - voIPPiPView3.progressToCameraMini));
            super.dispatchDraw(canvas);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r15) {
            /*
                Method dump skipped, instructions count: 583
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.VoIPPiPView.FloatingView.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getRelativePosition(float[] point) {
            Point point2 = AndroidUtilities.displaySize;
            float f = point2.x;
            float f2 = point2.y;
            VoIPPiPView voIPPiPView = VoIPPiPView.this;
            float left = voIPPiPView.windowLayoutParams.x + voIPPiPView.floatingView.getLeft();
            float f3 = this.leftPadding;
            point[0] = (left - f3) / (((f - f3) - this.rightPadding) - VoIPPiPView.this.floatingView.getMeasuredWidth());
            VoIPPiPView voIPPiPView2 = VoIPPiPView.this;
            float top = voIPPiPView2.windowLayoutParams.y + voIPPiPView2.floatingView.getTop();
            float f4 = this.topPadding;
            point[1] = (top - f4) / (((f2 - f4) - this.bottomPadding) - VoIPPiPView.this.floatingView.getMeasuredHeight());
            point[0] = Math.min(1.0f, Math.max(0.0f, point[0]));
            point[1] = Math.min(1.0f, Math.max(0.0f, point[1]));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void expand(boolean expanded) {
            AndroidUtilities.cancelRunOnUIThread(VoIPPiPView.this.collapseRunnable);
            if (VoIPPiPView.instance == null || VoIPPiPView.this.expandedAnimationInProgress || VoIPPiPView.instance.expanded == expanded) {
                return;
            }
            VoIPPiPView.instance.expanded = expanded;
            VoIPPiPView voIPPiPView = VoIPPiPView.this;
            int i = voIPPiPView.parentWidth;
            int i2 = voIPPiPView.xOffset;
            float f = (i * 0.25f) + (i2 * 2);
            int i3 = voIPPiPView.parentHeight;
            int i4 = voIPPiPView.yOffset;
            float f2 = (i3 * 0.25f) + (i4 * 2);
            float f3 = (i * 0.4f) + (i2 * 2);
            float f4 = (i3 * 0.4f) + (i4 * 2);
            voIPPiPView.expandedAnimationInProgress = true;
            if (expanded) {
                Context context = VoIPPiPView.instance.windowView.getContext();
                VoIPPiPView voIPPiPView2 = VoIPPiPView.this;
                WindowManager.LayoutParams layoutParamsCreateWindowLayoutParams = VoIPPiPView.createWindowLayoutParams(context, voIPPiPView2.parentWidth, voIPPiPView2.parentHeight, 0.4f);
                Context context2 = getContext();
                VoIPPiPView voIPPiPView3 = VoIPPiPView.this;
                final VoIPPiPView voIPPiPView4 = new VoIPPiPView(context2, voIPPiPView3.parentWidth, voIPPiPView3.parentHeight, true);
                getRelativePosition(VoIPPiPView.this.point);
                VoIPPiPView voIPPiPView5 = VoIPPiPView.this;
                float[] fArr = voIPPiPView5.point;
                float f5 = fArr[0];
                float f6 = fArr[1];
                WindowManager.LayoutParams layoutParams = voIPPiPView5.windowLayoutParams;
                layoutParamsCreateWindowLayoutParams.x = (int) (layoutParams.x - ((f3 - f) * f5));
                layoutParamsCreateWindowLayoutParams.y = (int) (layoutParams.y - ((f4 - f2) * f6));
                voIPPiPView5.windowManager.addView(voIPPiPView4.windowView, layoutParamsCreateWindowLayoutParams);
                voIPPiPView4.windowView.setAlpha(1.0f);
                voIPPiPView4.windowLayoutParams = layoutParamsCreateWindowLayoutParams;
                voIPPiPView4.windowManager = VoIPPiPView.this.windowManager;
                VoIPPiPView unused = VoIPPiPView.expandedInstance = voIPPiPView4;
                swapRender(VoIPPiPView.instance, VoIPPiPView.expandedInstance);
                final float scaleX = VoIPPiPView.this.floatingView.getScaleX() * 0.625f;
                voIPPiPView4.floatingView.setPivotX(f5 * VoIPPiPView.this.parentWidth * 0.4f);
                voIPPiPView4.floatingView.setPivotY(f6 * VoIPPiPView.this.parentHeight * 0.4f);
                voIPPiPView4.floatingView.setScaleX(scaleX);
                voIPPiPView4.floatingView.setScaleY(scaleX);
                VoIPPiPView.expandedInstance.topShadow.setAlpha(0.0f);
                VoIPPiPView.expandedInstance.closeIcon.setAlpha(0.0f);
                VoIPPiPView.expandedInstance.enlargeIcon.setAlpha(0.0f);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$FloatingView$bVGBU5_TZXVBc4u036Zhbj4YYC4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$expand$1$VoIPPiPView$FloatingView(scaleX, voIPPiPView4);
                    }
                }, 64L);
                return;
            }
            if (VoIPPiPView.expandedInstance == null) {
                return;
            }
            VoIPPiPView.expandedInstance.floatingView.getRelativePosition(VoIPPiPView.this.point);
            float[] fArr2 = VoIPPiPView.this.point;
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            VoIPPiPView.instance.windowLayoutParams.x = (int) (VoIPPiPView.expandedInstance.windowLayoutParams.x + ((f3 - f) * f7));
            VoIPPiPView.instance.windowLayoutParams.y = (int) (VoIPPiPView.expandedInstance.windowLayoutParams.y + ((f4 - f2) * f8));
            final float scaleX2 = VoIPPiPView.this.floatingView.getScaleX() * 0.625f;
            VoIPPiPView.expandedInstance.floatingView.setPivotX(f7 * VoIPPiPView.this.parentWidth * 0.4f);
            VoIPPiPView.expandedInstance.floatingView.setPivotY(f8 * VoIPPiPView.this.parentHeight * 0.4f);
            showUi(false);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$FloatingView$wShhbS1ZCdnMdTMVn5t9K4rYz4k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VoIPPiPView.FloatingView.lambda$expand$2(scaleX2, valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(300L).setInterpolator(CubicBezierInterpolator.DEFAULT);
            valueAnimatorOfFloat.addListener(new AnonymousClass3(expanded));
            valueAnimatorOfFloat.start();
            VoIPPiPView.this.expandAnimator = valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$expand$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$expand$1$VoIPPiPView$FloatingView(final float f, final VoIPPiPView voIPPiPView) {
            if (VoIPPiPView.expandedInstance == null) {
                return;
            }
            VoIPPiPView.this.windowView.setAlpha(0.0f);
            try {
                VoIPPiPView.this.windowManager.removeView(VoIPPiPView.this.windowView);
            } catch (Throwable th) {
                FileLog.e(th);
            }
            animate().cancel();
            final float f2 = 1.0f;
            showUi(true);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$FloatingView$yIRNNp6NzqOm1BiVThe5bU2WCfE
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VoIPPiPView.FloatingView.lambda$expand$0(f, f2, voIPPiPView, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.VoIPPiPView.FloatingView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    VoIPPiPView.this.expandedAnimationInProgress = false;
                }
            });
            valueAnimatorOfFloat.setDuration(300L).setInterpolator(CubicBezierInterpolator.DEFAULT);
            valueAnimatorOfFloat.start();
            VoIPPiPView.this.expandAnimator = valueAnimatorOfFloat;
        }

        static /* synthetic */ void lambda$expand$0(float f, float f2, VoIPPiPView voIPPiPView, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f3 = (f * (1.0f - fFloatValue)) + (f2 * fFloatValue);
            voIPPiPView.floatingView.setScaleX(f3);
            voIPPiPView.floatingView.setScaleY(f3);
            voIPPiPView.floatingView.invalidate();
            voIPPiPView.windowView.invalidate();
            if (Build.VERSION.SDK_INT >= 21) {
                voIPPiPView.floatingView.invalidateOutline();
            }
        }

        static /* synthetic */ void lambda$expand$2(float f, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f2 = (1.0f - fFloatValue) + (f * fFloatValue);
            if (VoIPPiPView.expandedInstance != null) {
                VoIPPiPView.expandedInstance.floatingView.setScaleX(f2);
                VoIPPiPView.expandedInstance.floatingView.setScaleY(f2);
                VoIPPiPView.expandedInstance.floatingView.invalidate();
                if (Build.VERSION.SDK_INT >= 21) {
                    VoIPPiPView.expandedInstance.floatingView.invalidateOutline();
                }
                VoIPPiPView.expandedInstance.windowView.invalidate();
            }
        }

        /* renamed from: ir.eitaa.ui.Components.voip.VoIPPiPView$FloatingView$3, reason: invalid class name */
        class AnonymousClass3 extends AnimatorListenerAdapter {
            final /* synthetic */ boolean val$expanded;

            AnonymousClass3(final boolean val$expanded) {
                this.val$expanded = val$expanded;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (VoIPPiPView.expandedInstance == null) {
                    return;
                }
                FloatingView.this.swapRender(VoIPPiPView.expandedInstance, VoIPPiPView.instance);
                VoIPPiPView.instance.windowView.setAlpha(1.0f);
                VoIPPiPView.this.windowManager.addView(VoIPPiPView.instance.windowView, VoIPPiPView.instance.windowLayoutParams);
                final boolean z = this.val$expanded;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPPiPView$FloatingView$3$fp0h0WRFsBIRtEg-pZ7vsEIft3o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0$VoIPPiPView$FloatingView$3(z);
                    }
                }, 64L);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onAnimationEnd$0$VoIPPiPView$FloatingView$3(boolean z) {
                if (VoIPPiPView.instance == null || VoIPPiPView.expandedInstance == null) {
                    return;
                }
                VoIPPiPView.expandedInstance.windowView.setAlpha(0.0f);
                VoIPPiPView.expandedInstance.finishInternal();
                VoIPPiPView.this.expandedAnimationInProgress = false;
                if (z) {
                    AndroidUtilities.runOnUIThread(VoIPPiPView.this.collapseRunnable, 3000L);
                }
            }
        }

        private void showUi(boolean show) {
            if (VoIPPiPView.expandedInstance == null) {
                return;
            }
            if (show) {
                VoIPPiPView.expandedInstance.topShadow.setAlpha(0.0f);
                VoIPPiPView.expandedInstance.closeIcon.setAlpha(0.0f);
                VoIPPiPView.expandedInstance.enlargeIcon.setAlpha(0.0f);
            }
            ViewPropertyAnimator duration = VoIPPiPView.expandedInstance.topShadow.animate().alpha(show ? 1.0f : 0.0f).setDuration(300L);
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            duration.setInterpolator(cubicBezierInterpolator).start();
            VoIPPiPView.expandedInstance.closeIcon.animate().alpha(show ? 1.0f : 0.0f).setDuration(300L).setInterpolator(cubicBezierInterpolator).start();
            VoIPPiPView.expandedInstance.enlargeIcon.animate().alpha(show ? 1.0f : 0.0f).setDuration(300L).setInterpolator(cubicBezierInterpolator).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void swapRender(VoIPPiPView from, VoIPPiPView to) {
            to.currentUserTextureView.setStub(from.currentUserTextureView);
            to.callingUserTextureView.setStub(from.callingUserTextureView);
            from.currentUserTextureView.renderer.release();
            from.callingUserTextureView.renderer.release();
            EglBase eglBase = VideoCapturerDevice.eglBase;
            if (eglBase == null) {
                return;
            }
            to.currentUserTextureView.renderer.init(eglBase.getEglBaseContext(), null);
            to.callingUserTextureView.renderer.init(VideoCapturerDevice.eglBase.getEglBaseContext(), null);
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().setSinks(to.currentUserTextureView.renderer, to.callingUserTextureView.renderer);
            }
        }
    }
}
