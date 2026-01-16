package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.voip.EncryptionKeyEmojifier;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.TLRPC$PhoneCall;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.DarkAlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.HintView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.voip.AcceptDeclineView;
import ir.eitaa.ui.Components.voip.PrivateVideoPreviewDialog;
import ir.eitaa.ui.Components.voip.VoIPButtonsLayout;
import ir.eitaa.ui.Components.voip.VoIPFloatingLayout;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.Components.voip.VoIPNotificationsLayout;
import ir.eitaa.ui.Components.voip.VoIPOverlayBackground;
import ir.eitaa.ui.Components.voip.VoIPPiPView;
import ir.eitaa.ui.Components.voip.VoIPStatusTextView;
import ir.eitaa.ui.Components.voip.VoIPTextureView;
import ir.eitaa.ui.Components.voip.VoIPToggleButton;
import ir.eitaa.ui.Components.voip.VoIPWindowView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.webrtc.EglBase;
import org.webrtc.GlRectDrawer;
import org.webrtc.RendererCommon;
import org.webrtc.TextureViewRenderer;

/* loaded from: classes3.dex */
public class VoIPFragment implements VoIPService.StateListener, NotificationCenter.NotificationCenterDelegate {
    private static VoIPFragment instance;
    private AcceptDeclineView acceptDeclineView;
    private AccessibilityManager accessibilityManager;
    Activity activity;
    private ImageView backIcon;
    private Handler blurUpdateHandler;
    private View blurredView;
    View bottomShadow;
    private VoIPButtonsLayout buttonsLayout;
    boolean callingUserIsVideo;
    private VoIPFloatingLayout callingUserMiniFloatingLayout;
    private TextureViewRenderer callingUserMiniTextureRenderer;
    private BackupImageView callingUserPhotoView;
    private BackupImageView callingUserPhotoViewMini;
    private VoIPTextureView callingUserTextureView;
    private TextView callingUserTitle;
    boolean cameraForceExpanded;
    private Animator cameraShowingAnimator;
    private boolean canHideUI;
    private boolean canSwitchToPip;
    private ImageView coverCameraButton;
    private final int currentAccount;
    private int currentState;
    TLRPC$User currentUser;
    private VoIPFloatingLayout currentUserCameraFloatingLayout;
    boolean currentUserIsVideo;
    private VoIPTextureView currentUserTextureView;
    private boolean deviceIsLocked;
    private boolean emojiExpanded;
    LinearLayout emojiLayout;
    private boolean emojiLoaded;
    TextView emojiRationalTextView;
    boolean enterFromPiP;
    private float enterTransitionProgress;
    boolean fillNaviagtionBar;
    float fillNaviagtionBarValue;
    private ViewGroup fragmentView;
    boolean hideUiRunnableWaiting;
    private boolean isFinished;
    boolean isOutgoing;
    private boolean isVideoCall;
    long lastContentTapTime;
    private WindowInsets lastInsets;
    private boolean lockOnScreen;
    private LinearLayout menuLayout;
    private View menuShadow;
    ValueAnimator naviagtionBarAnimator;
    VoIPNotificationsLayout notificationsLayout;
    private VoIPOverlayBackground overlayBackground;
    private PrivateVideoPreviewDialog previewDialog;
    private int previousState;
    private boolean screenWasWakeup;
    private ImageView speakerPhoneIcon;
    LinearLayout statusLayout;
    private int statusLayoutAnimateToOffset;
    private VoIPStatusTextView statusTextView;
    private boolean switchingToPip;
    HintView tapToVideoTooltip;
    View topShadow;
    float touchSlop;
    ValueAnimator uiVisibilityAnimator;
    private ImageView videoQualityButton;
    private VoIPWindowView windowView;
    VoIPToggleButton[] bottomButtons = new VoIPToggleButton[4];
    private boolean blurState = false;
    private boolean hdState = false;
    ImageView[] emojiViews = new ImageView[4];
    Emoji.EmojiDrawable[] emojiDrawables = new Emoji.EmojiDrawable[4];
    Paint overlayPaint = new Paint();
    Paint overlayBottomPaint = new Paint();
    private boolean uiVisible = true;
    float uiVisibilityAlpha = 1.0f;
    int animationIndex = -1;
    ValueAnimator.AnimatorUpdateListener statusbarAnimatorListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$V22dOtoyG5mJ28YkDcrV-r-Ug5E
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f$0.lambda$new$0$VoIPFragment(valueAnimator);
        }
    };
    ValueAnimator.AnimatorUpdateListener navigationBarAnimationListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$zQmT72uTdj1Cz-WdoMot-F6dESM
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f$0.lambda$new$1$VoIPFragment(valueAnimator);
        }
    };
    Runnable hideUIRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$T9E9BHa33rPyR7U7Vg7PjU4zG-g
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$2$VoIPFragment();
        }
    };
    TLRPC$User callingUser = VoIPService.getSharedInstance().getUser();

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraFirstFrameAvailable() {
        VoIPService.StateListener.CC.$default$onCameraFirstFrameAvailable(this);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onScreenOnChange(boolean screenOn) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$VoIPFragment(ValueAnimator valueAnimator) {
        this.uiVisibilityAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        updateSystemBarColors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$VoIPFragment(ValueAnimator valueAnimator) {
        this.fillNaviagtionBarValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        updateSystemBarColors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$VoIPFragment() {
        this.hideUiRunnableWaiting = false;
        if (this.canHideUI && this.uiVisible && !this.emojiExpanded) {
            this.lastContentTapTime = System.currentTimeMillis();
            showUi(false);
            this.previousState = this.currentState;
            updateViewState();
        }
    }

    public static void show(Activity activity, int account) {
        show(activity, false, account);
    }

    public static void show(Activity activity, boolean overlay, int account) {
        boolean zIsScreenOn;
        VoIPFragment voIPFragment = instance;
        if (voIPFragment != null && voIPFragment.windowView.getParent() == null) {
            VoIPFragment voIPFragment2 = instance;
            if (voIPFragment2 != null) {
                voIPFragment2.callingUserTextureView.renderer.release();
                instance.currentUserTextureView.renderer.release();
                instance.callingUserMiniTextureRenderer.release();
                instance.destroy();
            }
            instance = null;
        }
        if (instance != null || activity.isFinishing()) {
            return;
        }
        boolean z = VoIPPiPView.getInstance() != null;
        if (VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().getUser() == null) {
            return;
        }
        final VoIPFragment voIPFragment3 = new VoIPFragment(account);
        voIPFragment3.activity = activity;
        instance = voIPFragment3;
        VoIPWindowView voIPWindowView = new VoIPWindowView(activity, !z) { // from class: ir.eitaa.ui.VoIPFragment.1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent event) throws IllegalStateException {
                VoIPService sharedInstance;
                if (voIPFragment3.isFinished || voIPFragment3.switchingToPip) {
                    return false;
                }
                int keyCode = event.getKeyCode();
                if (keyCode != 4 || event.getAction() != 1 || voIPFragment3.lockOnScreen) {
                    if ((keyCode == 25 || keyCode == 24) && voIPFragment3.currentState == 15 && (sharedInstance = VoIPService.getSharedInstance()) != null) {
                        sharedInstance.stopRinging();
                        return true;
                    }
                    return super.dispatchKeyEvent(event);
                }
                voIPFragment3.onBackPressed();
                return true;
            }
        };
        instance.deviceIsLocked = ((KeyguardManager) activity.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        PowerManager powerManager = (PowerManager) activity.getSystemService("power");
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            zIsScreenOn = powerManager.isInteractive();
        } else {
            zIsScreenOn = powerManager.isScreenOn();
        }
        VoIPFragment voIPFragment4 = instance;
        voIPFragment4.screenWasWakeup = true ^ zIsScreenOn;
        voIPWindowView.setLockOnScreen(voIPFragment4.deviceIsLocked);
        voIPFragment3.windowView = voIPWindowView;
        if (i >= 20) {
            voIPWindowView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$TDQZpaAwhAdPeIGLCraBRp1d83o
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return VoIPFragment.lambda$show$3(this.f$0, view, windowInsets);
                }
            });
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        WindowManager.LayoutParams layoutParamsCreateWindowLayoutParams = voIPWindowView.createWindowLayoutParams();
        if (overlay) {
            if (i >= 26) {
                layoutParamsCreateWindowLayoutParams.type = 2038;
            } else {
                layoutParamsCreateWindowLayoutParams.type = 2003;
            }
        }
        windowManager.addView(voIPWindowView, layoutParamsCreateWindowLayoutParams);
        voIPWindowView.addView(voIPFragment3.createView(activity));
        if (z) {
            voIPFragment3.enterTransitionProgress = 0.0f;
            voIPFragment3.startTransitionFromPiP();
        } else {
            voIPFragment3.enterTransitionProgress = 1.0f;
            voIPFragment3.updateSystemBarColors();
        }
    }

    static /* synthetic */ WindowInsets lambda$show$3(VoIPFragment voIPFragment, View view, WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            voIPFragment.setInsets(windowInsets);
        }
        if (i >= 30) {
            return WindowInsets.CONSUMED;
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackPressed() {
        if (this.isFinished || this.switchingToPip) {
            return;
        }
        PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
        if (privateVideoPreviewDialog != null) {
            privateVideoPreviewDialog.dismiss(false, false);
            return;
        }
        if (this.callingUserIsVideo && this.currentUserIsVideo && this.cameraForceExpanded) {
            this.cameraForceExpanded = false;
            this.currentUserCameraFloatingLayout.setRelativePosition(this.callingUserMiniFloatingLayout);
            this.previousState = this.currentState;
            updateViewState();
            return;
        }
        if (this.emojiExpanded) {
            expandEmoji(false);
            return;
        }
        if (this.emojiRationalTextView.getVisibility() != 8) {
            return;
        }
        if (this.canSwitchToPip && !this.lockOnScreen) {
            if (AndroidUtilities.checkInlinePermissions(this.activity)) {
                switchToPip();
                return;
            } else {
                requestInlinePermissions();
                return;
            }
        }
        this.windowView.finish();
    }

    public static void clearInstance() {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        if (instance != null) {
            if (VoIPService.getSharedInstance() != null) {
                int measuredHeight = instance.windowView.getMeasuredHeight();
                int i = Build.VERSION.SDK_INT;
                if (i >= 20 && (windowInsets2 = instance.lastInsets) != null) {
                    measuredHeight -= windowInsets2.getSystemWindowInsetBottom();
                }
                VoIPFragment voIPFragment = instance;
                if (voIPFragment.canSwitchToPip) {
                    VoIPPiPView.show(voIPFragment.activity, voIPFragment.currentAccount, voIPFragment.windowView.getMeasuredWidth(), measuredHeight, 0);
                    if (i >= 20 && (windowInsets = instance.lastInsets) != null) {
                        VoIPPiPView.topInset = windowInsets.getSystemWindowInsetTop();
                        VoIPPiPView.bottomInset = instance.lastInsets.getSystemWindowInsetBottom();
                    }
                }
            }
            instance.callingUserTextureView.renderer.release();
            instance.currentUserTextureView.renderer.release();
            instance.callingUserMiniTextureRenderer.release();
            instance.destroy();
        }
        instance = null;
    }

    public static VoIPFragment getInstance() {
        return instance;
    }

    private void setInsets(WindowInsets windowInsets) {
        this.lastInsets = windowInsets;
        ((FrameLayout.LayoutParams) this.buttonsLayout.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        ((FrameLayout.LayoutParams) this.acceptDeclineView.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        ((FrameLayout.LayoutParams) this.backIcon.getLayoutParams()).topMargin = this.lastInsets.getSystemWindowInsetTop();
        ((FrameLayout.LayoutParams) this.speakerPhoneIcon.getLayoutParams()).topMargin = this.lastInsets.getSystemWindowInsetTop();
        ((FrameLayout.LayoutParams) this.menuLayout.getLayoutParams()).topMargin = this.lastInsets.getSystemWindowInsetTop() + AndroidUtilities.dp(200.0f);
        ((FrameLayout.LayoutParams) this.menuShadow.getLayoutParams()).topMargin = this.lastInsets.getSystemWindowInsetTop() + AndroidUtilities.dp(144.0f);
        ((FrameLayout.LayoutParams) this.topShadow.getLayoutParams()).topMargin = this.lastInsets.getSystemWindowInsetTop();
        ((FrameLayout.LayoutParams) this.statusLayout.getLayoutParams()).topMargin = AndroidUtilities.dp(68.0f) + this.lastInsets.getSystemWindowInsetTop();
        ((FrameLayout.LayoutParams) this.emojiLayout.getLayoutParams()).topMargin = AndroidUtilities.dp(17.0f) + this.lastInsets.getSystemWindowInsetTop();
        ((FrameLayout.LayoutParams) this.callingUserPhotoViewMini.getLayoutParams()).topMargin = AndroidUtilities.dp(68.0f) + this.lastInsets.getSystemWindowInsetTop();
        ((FrameLayout.LayoutParams) this.currentUserCameraFloatingLayout.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        ((FrameLayout.LayoutParams) this.callingUserMiniFloatingLayout.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        ((FrameLayout.LayoutParams) this.callingUserTextureView.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        ((FrameLayout.LayoutParams) this.notificationsLayout.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        ((FrameLayout.LayoutParams) this.bottomShadow.getLayoutParams()).bottomMargin = this.lastInsets.getSystemWindowInsetBottom();
        this.currentUserCameraFloatingLayout.setInsets(this.lastInsets);
        this.callingUserMiniFloatingLayout.setInsets(this.lastInsets);
        this.fragmentView.requestLayout();
        PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
        if (privateVideoPreviewDialog != null) {
            privateVideoPreviewDialog.setBottomPadding(this.lastInsets.getSystemWindowInsetBottom());
        }
    }

    public VoIPFragment(int account) {
        this.currentAccount = account;
        this.currentUser = MessagesController.getInstance(account).getUser(Long.valueOf(UserConfig.getInstance(account).getClientUserId()));
        VoIPService.getSharedInstance().registerStateListener(this);
        this.isOutgoing = VoIPService.getSharedInstance().isOutgoing();
        this.previousState = -1;
        this.currentState = VoIPService.getSharedInstance().getCallState();
        NotificationCenter.getInstance(account).addObserver(this, NotificationCenter.voipServiceCreated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.closeInCallActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            sharedInstance.unregisterStateListener(this);
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.voipServiceCreated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.closeInCallActivity);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int state) {
        int i = this.currentState;
        if (i != state) {
            this.previousState = i;
            this.currentState = state;
            if (this.windowView != null) {
                updateViewState();
            }
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.voipServiceCreated) {
            if (this.currentState != 17 || VoIPService.getSharedInstance() == null) {
                return;
            }
            this.currentUserTextureView.renderer.release();
            this.callingUserTextureView.renderer.release();
            this.callingUserMiniTextureRenderer.release();
            initRenderers();
            VoIPService.getSharedInstance().registerStateListener(this);
            return;
        }
        if (id == NotificationCenter.emojiLoaded) {
            updateKeyView(true);
        } else if (id == NotificationCenter.closeInCallActivity) {
            this.windowView.finish();
        }
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onSignalBarsCountChanged(int count) {
        VoIPStatusTextView voIPStatusTextView = this.statusTextView;
        if (voIPStatusTextView != null) {
            voIPStatusTextView.setSignalBarCount(count);
        }
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onAudioSettingsChanged() {
        updateButtons(true);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onMediaStateUpdated(int audioState, int videoState) {
        this.previousState = this.currentState;
        if (videoState == 2 && !this.isVideoCall) {
            this.isVideoCall = true;
        }
        updateViewState();
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onCameraSwitch(boolean isFrontFace) {
        this.previousState = this.currentState;
        updateViewState();
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onVideoAvailableChange(boolean isAvailable) {
        this.previousState = this.currentState;
        if (isAvailable && !this.isVideoCall) {
            this.isVideoCall = true;
        }
        updateViewState();
    }

    public View createView(Context context) {
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(context, AccessibilityManager.class);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.VoIPFragment.2
            boolean check;
            long pressedTime;
            float pressedX;
            float pressedY;

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                int i = Build.VERSION.SDK_INT;
                if (i >= 20 && VoIPFragment.this.lastInsets != null) {
                    canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), VoIPFragment.this.lastInsets.getSystemWindowInsetTop(), VoIPFragment.this.overlayPaint);
                }
                if (i < 20 || VoIPFragment.this.lastInsets == null) {
                    return;
                }
                canvas.drawRect(0.0f, getMeasuredHeight() - VoIPFragment.this.lastInsets.getSystemWindowInsetBottom(), getMeasuredWidth(), getMeasuredHeight(), VoIPFragment.this.overlayBottomPaint);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    this.pressedX = event.getX();
                    this.pressedY = event.getY();
                    this.check = true;
                    this.pressedTime = System.currentTimeMillis();
                } else if (action != 1) {
                    if (action == 3) {
                        this.check = false;
                    }
                } else if (this.check) {
                    float x = event.getX() - this.pressedX;
                    float y = event.getY() - this.pressedY;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    float f = (x * x) + (y * y);
                    VoIPFragment voIPFragment = VoIPFragment.this;
                    float f2 = voIPFragment.touchSlop;
                    if (f < f2 * f2 && jCurrentTimeMillis - this.pressedTime < 300 && jCurrentTimeMillis - voIPFragment.lastContentTapTime > 300) {
                        voIPFragment.lastContentTapTime = System.currentTimeMillis();
                        if (VoIPFragment.this.emojiExpanded) {
                            VoIPFragment.this.expandEmoji(false);
                        } else if (VoIPFragment.this.canHideUI) {
                            VoIPFragment.this.showUi(!r10.uiVisible);
                            VoIPFragment voIPFragment2 = VoIPFragment.this;
                            voIPFragment2.previousState = voIPFragment2.currentState;
                            VoIPFragment.this.updateViewState();
                        }
                    }
                    this.check = false;
                }
                return this.check;
            }
        };
        boolean z = false;
        frameLayout.setClipToPadding(false);
        frameLayout.setClipChildren(false);
        updateSystemBarColors();
        this.fragmentView = frameLayout;
        frameLayout.setFitsSystemWindows(true);
        this.callingUserPhotoView = new BackupImageView(context) { // from class: ir.eitaa.ui.VoIPFragment.3
            int blackoutColor = ColorUtils.setAlphaComponent(-16777216, 76);

            @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                canvas.drawColor(this.blackoutColor);
            }
        };
        VoIPTextureView voIPTextureView = new VoIPTextureView(context, false, true, false, false);
        this.callingUserTextureView = voIPTextureView;
        TextureViewRenderer textureViewRenderer = voIPTextureView.renderer;
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
        textureViewRenderer.setScalingType(scalingType);
        this.callingUserTextureView.renderer.setEnableHardwareScaler(true);
        this.callingUserTextureView.scaleType = VoIPTextureView.SCALE_TYPE_NONE;
        frameLayout.addView(this.callingUserPhotoView);
        frameLayout.addView(this.callingUserTextureView);
        BackgroundGradientDrawable backgroundGradientDrawable = new BackgroundGradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-14994098, -14328963});
        backgroundGradientDrawable.startDithering(BackgroundGradientDrawable.Sizes.ofDeviceScreen(BackgroundGradientDrawable.Sizes.Orientation.PORTRAIT), new BackgroundGradientDrawable.ListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.4
            @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.ListenerAdapter, ir.eitaa.ui.Components.BackgroundGradientDrawable.Listener
            public void onAllSizesReady() {
                VoIPFragment.this.callingUserPhotoView.invalidate();
            }
        });
        VoIPOverlayBackground voIPOverlayBackground = new VoIPOverlayBackground(context);
        this.overlayBackground = voIPOverlayBackground;
        voIPOverlayBackground.setVisibility(8);
        this.callingUserPhotoView.getImageReceiver().setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$OznEljjNxcyOjqGkIKLker4B2gQ
            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver, boolean z2, boolean z3, boolean z4) {
                this.f$0.lambda$createView$4$VoIPFragment(imageReceiver, z2, z3, z4);
            }

            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver) {
                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver);
            }
        });
        this.callingUserPhotoView.setImage(ImageLocation.getForUserOrChat(this.callingUser, 0), (String) null, backgroundGradientDrawable, this.callingUser);
        VoIPFloatingLayout voIPFloatingLayout = new VoIPFloatingLayout(context);
        this.currentUserCameraFloatingLayout = voIPFloatingLayout;
        voIPFloatingLayout.setDelegate(new VoIPFloatingLayout.VoIPFloatingLayoutDelegate() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$hMpQczktcH3i9ykkaZNsUvKD8go
            @Override // ir.eitaa.ui.Components.voip.VoIPFloatingLayout.VoIPFloatingLayoutDelegate
            public final void onChange(float f, boolean z2) {
                this.f$0.lambda$createView$5$VoIPFragment(f, z2);
            }
        });
        this.currentUserCameraFloatingLayout.setRelativePosition(1.0f, 1.0f);
        VoIPTextureView voIPTextureView2 = new VoIPTextureView(context, true, false, true, true);
        this.currentUserTextureView = voIPTextureView2;
        voIPTextureView2.renderer.setIsCamera(true);
        this.currentUserTextureView.renderer.setUseCameraRotation(true);
        this.currentUserCameraFloatingLayout.setOnTapListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$-KstPS8gbP-sekoKtOQiQiKj6-s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$6$VoIPFragment(view);
            }
        });
        this.currentUserTextureView.renderer.setMirror(true);
        this.currentUserCameraFloatingLayout.addView(this.currentUserTextureView);
        VoIPFloatingLayout voIPFloatingLayout2 = new VoIPFloatingLayout(context);
        this.callingUserMiniFloatingLayout = voIPFloatingLayout2;
        voIPFloatingLayout2.alwaysFloating = true;
        voIPFloatingLayout2.setFloatingMode(true, false);
        TextureViewRenderer textureViewRenderer2 = new TextureViewRenderer(context);
        this.callingUserMiniTextureRenderer = textureViewRenderer2;
        textureViewRenderer2.setEnableHardwareScaler(true);
        this.callingUserMiniTextureRenderer.setIsCamera(false);
        this.callingUserMiniTextureRenderer.setFpsReduction(30.0f);
        this.callingUserMiniTextureRenderer.setScalingType(scalingType);
        View view = new View(context);
        view.setBackgroundColor(-14999773);
        this.callingUserMiniFloatingLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f));
        this.callingUserMiniFloatingLayout.addView(this.callingUserMiniTextureRenderer, LayoutHelper.createFrame(-1, -2, 17));
        this.callingUserMiniFloatingLayout.setOnTapListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$o6p8Gf2I83QZ6xELLEfnE5BLpVw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createView$7$VoIPFragment(view2);
            }
        });
        this.callingUserMiniFloatingLayout.setVisibility(8);
        frameLayout.addView(this.currentUserCameraFloatingLayout, LayoutHelper.createFrame(-2, -2.0f));
        frameLayout.addView(this.callingUserMiniFloatingLayout);
        View view2 = new View(context);
        this.blurredView = view2;
        view2.setVisibility(8);
        this.callingUserMiniFloatingLayout.addView(this.blurredView, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout.addView(this.overlayBackground);
        View view3 = new View(context);
        this.bottomShadow = view3;
        view3.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, ColorUtils.setAlphaComponent(-16777216, 127)}));
        frameLayout.addView(this.bottomShadow, LayoutHelper.createFrame(-1, 140, 80));
        View view4 = new View(context);
        this.topShadow = view4;
        view4.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtils.setAlphaComponent(-16777216, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle), 0}));
        frameLayout.addView(this.topShadow, LayoutHelper.createFrame(-1, 140, 48));
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.VoIPFragment.5
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                info.setVisibleToUser(VoIPFragment.this.emojiLoaded);
            }
        };
        this.emojiLayout = linearLayout;
        linearLayout.setOrientation(0);
        this.emojiLayout.setPadding(0, 0, 0, AndroidUtilities.dp(30.0f));
        this.emojiLayout.setClipToPadding(false);
        this.emojiLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$aP6BA8xEj9Z1XPz1euLubn20vik
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                this.f$0.lambda$createView$8$VoIPFragment(view5);
            }
        });
        TextView textView = new TextView(context);
        this.emojiRationalTextView = textView;
        textView.setText(LocaleController.formatString("CallEmojiKeyTooltip", R.string.CallEmojiKeyTooltip, UserObject.getFirstName(this.callingUser)));
        this.emojiRationalTextView.setTextSize(1, 16.0f);
        this.emojiRationalTextView.setTextColor(-1);
        this.emojiRationalTextView.setGravity(17);
        this.emojiRationalTextView.setVisibility(8);
        int i = 0;
        while (i < 4) {
            this.emojiViews[i] = new ImageView(context);
            this.emojiViews[i].setScaleType(ImageView.ScaleType.FIT_XY);
            this.emojiLayout.addView(this.emojiViews[i], LayoutHelper.createLinear(22, 22, i == 0 ? 0.0f : 4.0f, 0.0f, 0.0f, 0.0f));
            i++;
        }
        LinearLayout linearLayout2 = new LinearLayout(context) { // from class: ir.eitaa.ui.VoIPFragment.6
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                CharSequence text = VoIPFragment.this.callingUserTitle.getText();
                if (sharedInstance == null || TextUtils.isEmpty(text)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(text);
                sb.append(", ");
                TLRPC$PhoneCall tLRPC$PhoneCall = sharedInstance.privateCall;
                if (tLRPC$PhoneCall != null && tLRPC$PhoneCall.video) {
                    sb.append(LocaleController.getString("VoipInVideoCallBranding", R.string.VoipInVideoCallBranding));
                } else {
                    sb.append(LocaleController.getString("VoipInCallBranding", R.string.VoipInCallBranding));
                }
                long callDuration = sharedInstance.getCallDuration();
                if (callDuration > 0) {
                    sb.append(", ");
                    sb.append(LocaleController.formatDuration((int) (callDuration / 1000)));
                }
                info.setText(sb);
            }
        };
        this.statusLayout = linearLayout2;
        linearLayout2.setOrientation(1);
        this.statusLayout.setFocusable(true);
        this.statusLayout.setFocusableInTouchMode(true);
        BackupImageView backupImageView = new BackupImageView(context);
        this.callingUserPhotoViewMini = backupImageView;
        backupImageView.setImage(ImageLocation.getForUserOrChat(this.callingUser, 1), (String) null, Theme.createCircleDrawable(AndroidUtilities.dp(135.0f), -16777216), this.callingUser);
        this.callingUserPhotoViewMini.setRoundRadius(AndroidUtilities.dp(135.0f) / 2);
        this.callingUserPhotoViewMini.setVisibility(8);
        TextView textView2 = new TextView(context);
        this.callingUserTitle = textView2;
        textView2.setTextSize(1, 24.0f);
        TextView textView3 = this.callingUserTitle;
        TLRPC$User tLRPC$User = this.callingUser;
        textView3.setText(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
        this.callingUserTitle.setShadowLayer(AndroidUtilities.dp(3.0f), 0.0f, AndroidUtilities.dp(0.6666667f), 1275068416);
        this.callingUserTitle.setTextColor(-1);
        this.callingUserTitle.setGravity(1);
        this.callingUserTitle.setImportantForAccessibility(2);
        this.statusLayout.addView(this.callingUserTitle, LayoutHelper.createLinear(-2, -2, 1, 0, 0, 0, 6));
        VoIPStatusTextView voIPStatusTextView = new VoIPStatusTextView(context);
        this.statusTextView = voIPStatusTextView;
        ViewCompat.setImportantForAccessibility(voIPStatusTextView, 4);
        this.statusLayout.addView(this.statusTextView, LayoutHelper.createLinear(-2, -2, 1, 0, 0, 0, 6));
        this.statusLayout.setClipChildren(false);
        this.statusLayout.setClipToPadding(false);
        this.statusLayout.setPadding(0, 0, 0, AndroidUtilities.dp(15.0f));
        frameLayout.addView(this.callingUserPhotoViewMini, LayoutHelper.createFrame(135, 135.0f, 1, 0.0f, 68.0f, 0.0f, 0.0f));
        frameLayout.addView(this.statusLayout, LayoutHelper.createFrame(-1, -2.0f, 0, 0.0f, 68.0f, 0.0f, 0.0f));
        frameLayout.addView(this.emojiLayout, LayoutHelper.createFrame(-2, -2.0f, 1, 0.0f, 17.0f, 0.0f, 0.0f));
        frameLayout.addView(this.emojiRationalTextView, LayoutHelper.createFrame(-1, -2.0f, 17, 24.0f, 32.0f, 24.0f, 0.0f));
        this.buttonsLayout = new VoIPButtonsLayout(context);
        for (int i2 = 0; i2 < 4; i2++) {
            this.bottomButtons[i2] = new VoIPToggleButton(context);
            this.buttonsLayout.addView(this.bottomButtons[i2]);
        }
        AcceptDeclineView acceptDeclineView = new AcceptDeclineView(context);
        this.acceptDeclineView = acceptDeclineView;
        acceptDeclineView.setListener(new AcceptDeclineView.Listener() { // from class: ir.eitaa.ui.VoIPFragment.7
            @Override // ir.eitaa.ui.Components.voip.AcceptDeclineView.Listener
            public void onAccept() throws IllegalStateException, IOException {
                if (VoIPFragment.this.currentState == 17) {
                    Intent intent = new Intent(VoIPFragment.this.activity, (Class<?>) VoIPService.class);
                    intent.putExtra("user_id", VoIPFragment.this.callingUser.id);
                    intent.putExtra("is_outgoing", true);
                    intent.putExtra("start_incall_activity", false);
                    intent.putExtra("video_call", VoIPFragment.this.isVideoCall);
                    intent.putExtra("can_video_call", VoIPFragment.this.isVideoCall);
                    intent.putExtra("account", VoIPFragment.this.currentAccount);
                    try {
                        VoIPFragment.this.activity.startService(intent);
                        return;
                    } catch (Throwable th) {
                        FileLog.e(th);
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT >= 23 && VoIPFragment.this.activity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                    VoIPFragment.this.activity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle);
                } else if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().acceptIncomingCall();
                    if (VoIPFragment.this.currentUserIsVideo) {
                        VoIPService.getSharedInstance().requestVideoCall(false);
                    }
                }
            }

            @Override // ir.eitaa.ui.Components.voip.AcceptDeclineView.Listener
            public void onDicline() throws IllegalStateException, InterruptedException {
                if (VoIPFragment.this.currentState == 17) {
                    VoIPFragment.this.windowView.finish();
                } else if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().declineIncomingCall();
                }
            }
        });
        this.acceptDeclineView.setScreenWasWakeup(this.screenWasWakeup);
        frameLayout.addView(this.buttonsLayout, LayoutHelper.createFrame(-1, -2, 80));
        frameLayout.addView(this.acceptDeclineView, LayoutHelper.createFrame(-1, 186, 80));
        ImageView imageView = new ImageView(context);
        this.backIcon = imageView;
        imageView.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(-1, 76)));
        this.backIcon.setImageResource(R.drawable.ic_ab_back);
        this.backIcon.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
        this.backIcon.setContentDescription(LocaleController.getString("Back", R.string.Back));
        frameLayout.addView(this.backIcon, LayoutHelper.createFrame(56, 56, 51));
        ImageView imageView2 = new ImageView(context) { // from class: ir.eitaa.ui.VoIPFragment.8
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                info.setClassName(ToggleButton.class.getName());
                info.setCheckable(true);
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                if (sharedInstance != null) {
                    info.setChecked(sharedInstance.isSpeakerphoneOn());
                }
            }
        };
        this.speakerPhoneIcon = imageView2;
        imageView2.setContentDescription(LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker));
        this.speakerPhoneIcon.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(-1, 76)));
        this.speakerPhoneIcon.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
        frameLayout.addView(this.speakerPhoneIcon, LayoutHelper.createFrame(56, 56, 53));
        this.speakerPhoneIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$C3hv8URGOw0NHWbSUpplgsVbjaU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                this.f$0.lambda$createView$9$VoIPFragment(view5);
            }
        });
        this.menuShadow = new View(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{ColorUtils.setAlphaComponent(-16777216, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle), 0});
        gradientDrawable.setGradientType(1);
        gradientDrawable.setGradientRadius(AndroidUtilities.dp(122.0f));
        gradientDrawable.setGradientCenter(1.1f, 0.5f);
        this.menuShadow.setBackground(gradientDrawable);
        frameLayout.addView(this.menuShadow, LayoutHelper.createFrame(245, 245.0f, 5, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.menuLayout = linearLayout3;
        linearLayout3.setOrientation(1);
        this.menuLayout.setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp(26.0f), ColorUtils.setAlphaComponent(-1, 30)));
        frameLayout.addView(this.menuLayout, LayoutHelper.createFrame(-2, -2.0f, 5, 16.0f, 16.0f, 16.0f, 16.0f));
        ImageView imageView3 = new ImageView(context);
        this.coverCameraButton = imageView3;
        imageView3.setContentDescription(LocaleController.getString("VoipCoverCamera", R.string.VoipCoverCamera));
        this.coverCameraButton.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(-1, 76)));
        this.coverCameraButton.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
        this.coverCameraButton.setImageResource(R.drawable.blur_on);
        this.menuLayout.addView(this.coverCameraButton, LayoutHelper.createFrame(56, 56.0f, 1, 0.0f, 0.0f, 0.0f, 0.0f));
        this.coverCameraButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$uVlcV73i49hc5wVGRtRjrtwVSzI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                this.f$0.lambda$createView$10$VoIPFragment(view5);
            }
        });
        View view5 = new View(context);
        view5.setBackgroundColor(Theme.getColor("chats_actionIcon"));
        this.menuLayout.addView(view5, LayoutHelper.createFrame(-1, 1.0f, 1, 16.0f, 16.0f, 16.0f, 16.0f));
        ImageView imageView4 = new ImageView(context);
        this.videoQualityButton = imageView4;
        imageView4.setContentDescription(LocaleController.getString("VoipCoverCamera", R.string.VoipCoverCamera));
        this.videoQualityButton.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(-1, 76)));
        this.videoQualityButton.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
        this.videoQualityButton.setImageResource(R.drawable.hd_off);
        this.menuLayout.addView(this.videoQualityButton, LayoutHelper.createFrame(56, 56.0f, 1, 0.0f, 0.0f, 0.0f, 0.0f));
        this.menuLayout.setVisibility(8);
        this.videoQualityButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$R4IDtLc1Abj-X-P8jlzE9bPOA7s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                this.f$0.lambda$createView$11$VoIPFragment(view6);
            }
        });
        this.backIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$V_4BMGbc0auYrub2TSByubfhayg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                this.f$0.lambda$createView$12$VoIPFragment(view6);
            }
        });
        if (this.windowView.isLockOnScreen()) {
            this.backIcon.setVisibility(8);
        }
        VoIPNotificationsLayout voIPNotificationsLayout = new VoIPNotificationsLayout(context);
        this.notificationsLayout = voIPNotificationsLayout;
        voIPNotificationsLayout.setGravity(80);
        this.notificationsLayout.setOnViewsUpdated(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$5WZ-hL4iTBe8_TSjQ83Jc05ACYo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$13$VoIPFragment();
            }
        });
        frameLayout.addView(this.notificationsLayout, LayoutHelper.createFrame(-1, 200.0f, 80, 16.0f, 0.0f, 16.0f, 0.0f));
        HintView hintView = new HintView(context, 4);
        this.tapToVideoTooltip = hintView;
        hintView.setText(LocaleController.getString("TapToTurnCamera", R.string.TapToTurnCamera));
        frameLayout.addView(this.tapToVideoTooltip, LayoutHelper.createFrame(-2, -2.0f, 51, 19.0f, 0.0f, 19.0f, 8.0f));
        this.tapToVideoTooltip.setBottomOffset(AndroidUtilities.dp(4.0f));
        this.tapToVideoTooltip.setVisibility(8);
        updateViewState();
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            if (!this.isVideoCall) {
                TLRPC$PhoneCall tLRPC$PhoneCall = sharedInstance.privateCall;
                if (tLRPC$PhoneCall != null && tLRPC$PhoneCall.video) {
                    z = true;
                }
                this.isVideoCall = z;
            }
            initRenderers();
        }
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$VoIPFragment(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        ImageReceiver.BitmapHolder bitmapSafe = imageReceiver.getBitmapSafe();
        if (bitmapSafe != null) {
            this.overlayBackground.setBackground(bitmapSafe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$VoIPFragment(float f, boolean z) {
        this.currentUserTextureView.setScreenshareMiniProgress(f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$VoIPFragment(View view) {
        if (this.currentUserIsVideo && this.callingUserIsVideo && System.currentTimeMillis() - this.lastContentTapTime > 500) {
            AndroidUtilities.cancelRunOnUIThread(this.hideUIRunnable);
            this.hideUiRunnableWaiting = false;
            this.lastContentTapTime = System.currentTimeMillis();
            this.callingUserMiniFloatingLayout.setRelativePosition(this.currentUserCameraFloatingLayout);
            this.cameraForceExpanded = true;
            this.previousState = this.currentState;
            updateViewState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$VoIPFragment(View view) {
        if (!this.cameraForceExpanded || System.currentTimeMillis() - this.lastContentTapTime <= 500) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.hideUIRunnable);
        this.hideUiRunnableWaiting = false;
        this.lastContentTapTime = System.currentTimeMillis();
        this.currentUserCameraFloatingLayout.setRelativePosition(this.callingUserMiniFloatingLayout);
        this.cameraForceExpanded = false;
        this.previousState = this.currentState;
        updateViewState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$VoIPFragment(View view) {
        if (System.currentTimeMillis() - this.lastContentTapTime < 500) {
            return;
        }
        this.lastContentTapTime = System.currentTimeMillis();
        if (this.emojiLoaded) {
            expandEmoji(!this.emojiExpanded);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$VoIPFragment(View view) {
        if (this.speakerPhoneIcon.getTag() == null || VoIPService.getSharedInstance() == null) {
            return;
        }
        VoIPService.getSharedInstance().toggleSpeakerphoneOrShowRouteSheet(this.activity, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$VoIPFragment(View view) {
        boolean z = !this.blurState;
        this.blurState = z;
        if (!z) {
            this.blurredView.setVisibility(8);
            this.coverCameraButton.setImageResource(R.drawable.blur_on);
            stopBlurUpdate();
        } else {
            this.blurredView.setVisibility(0);
            startBlurUpdate();
            this.coverCameraButton.setImageResource(R.drawable.blur_off2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$11$VoIPFragment(View view) {
        if (this.hdState) {
            this.videoQualityButton.setImageResource(R.drawable.hd_off);
            VoIPService.getSharedInstance().sendBitrateUpdated(false);
        } else {
            this.videoQualityButton.setImageResource(R.drawable.hd_on);
            VoIPService.getSharedInstance().sendBitrateUpdated(true);
        }
        this.hdState = !this.hdState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$12$VoIPFragment(View view) {
        if (this.lockOnScreen) {
            return;
        }
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$VoIPFragment() {
        this.previousState = this.currentState;
        updateViewState();
    }

    /* renamed from: ir.eitaa.ui.VoIPFragment$9, reason: invalid class name */
    class AnonymousClass9 implements RendererCommon.RendererEvents {
        @Override // org.webrtc.RendererCommon.RendererEvents
        public void onFrameResolutionChanged(int videoWidth, int videoHeight, int rotation) {
        }

        AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onFirstFrameRendered$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onFirstFrameRendered$0$VoIPFragment$9() {
            VoIPFragment.this.updateViewState();
        }

        @Override // org.webrtc.RendererCommon.RendererEvents
        public void onFirstFrameRendered() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$9$AylXy8-QW9ZA9aWZhcOyvpryUjY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFirstFrameRendered$0$VoIPFragment$9();
                }
            });
        }
    }

    private void initRenderers() {
        this.currentUserTextureView.renderer.init(VideoCapturerDevice.getEglBase().getEglBaseContext(), new AnonymousClass9());
        this.callingUserTextureView.renderer.init(VideoCapturerDevice.getEglBase().getEglBaseContext(), new AnonymousClass10(), EglBase.CONFIG_PLAIN, new GlRectDrawer());
        this.callingUserMiniTextureRenderer.init(VideoCapturerDevice.getEglBase().getEglBaseContext(), null);
    }

    /* renamed from: ir.eitaa.ui.VoIPFragment$10, reason: invalid class name */
    class AnonymousClass10 implements RendererCommon.RendererEvents {
        @Override // org.webrtc.RendererCommon.RendererEvents
        public void onFrameResolutionChanged(int videoWidth, int videoHeight, int rotation) {
        }

        AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onFirstFrameRendered$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onFirstFrameRendered$0$VoIPFragment$10() {
            VoIPFragment.this.updateViewState();
        }

        @Override // org.webrtc.RendererCommon.RendererEvents
        public void onFirstFrameRendered() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$10$rZoUjloWvpf3t56ijTVyx7LpIrk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFirstFrameRendered$0$VoIPFragment$10();
                }
            });
        }
    }

    public void switchToPip() {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        if (this.isFinished || !AndroidUtilities.checkInlinePermissions(this.activity) || instance == null) {
            return;
        }
        this.isFinished = true;
        if (VoIPService.getSharedInstance() != null) {
            int measuredHeight = instance.windowView.getMeasuredHeight();
            int i = Build.VERSION.SDK_INT;
            if (i >= 20 && (windowInsets2 = instance.lastInsets) != null) {
                measuredHeight -= windowInsets2.getSystemWindowInsetBottom();
            }
            VoIPFragment voIPFragment = instance;
            VoIPPiPView.show(voIPFragment.activity, voIPFragment.currentAccount, voIPFragment.windowView.getMeasuredWidth(), measuredHeight, 1);
            if (i >= 20 && (windowInsets = instance.lastInsets) != null) {
                VoIPPiPView.topInset = windowInsets.getSystemWindowInsetTop();
                VoIPPiPView.bottomInset = instance.lastInsets.getSystemWindowInsetBottom();
            }
        }
        if (VoIPPiPView.getInstance() == null) {
            return;
        }
        ViewPropertyAnimator duration = this.speakerPhoneIcon.animate().alpha(0.0f).setDuration(150L);
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
        duration.setInterpolator(cubicBezierInterpolator).start();
        this.menuLayout.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.backIcon.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.emojiLayout.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.statusLayout.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.buttonsLayout.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.bottomShadow.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.topShadow.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.menuShadow.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.callingUserMiniFloatingLayout.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.blurredView.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.notificationsLayout.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        VoIPPiPView.switchingToPip = true;
        this.switchingToPip = true;
        Animator animatorCreatePiPTransition = createPiPTransition(false);
        this.animationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.animationIndex, null);
        animatorCreatePiPTransition.addListener(new AnonymousClass11());
        animatorCreatePiPTransition.setDuration(350L);
        animatorCreatePiPTransition.setInterpolator(cubicBezierInterpolator);
        animatorCreatePiPTransition.start();
    }

    /* renamed from: ir.eitaa.ui.VoIPFragment$11, reason: invalid class name */
    class AnonymousClass11 extends AnimatorListenerAdapter {
        AnonymousClass11() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            VoIPPiPView.getInstance().windowView.setAlpha(1.0f);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$11$sQmuQ1y9-PiDape-_00WOzIAlic
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0$VoIPFragment$11();
                }
            }, 200L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$VoIPFragment$11() {
            NotificationCenter.getInstance(VoIPFragment.this.currentAccount).onAnimationFinish(VoIPFragment.this.animationIndex);
            VoIPPiPView.getInstance().onTransitionEnd();
            VoIPFragment.this.currentUserCameraFloatingLayout.setCornerRadius(-1.0f);
            VoIPFragment.this.callingUserTextureView.renderer.release();
            VoIPFragment.this.currentUserTextureView.renderer.release();
            VoIPFragment.this.callingUserMiniTextureRenderer.release();
            VoIPFragment.this.destroy();
            VoIPFragment.this.windowView.finishImmediate();
            VoIPPiPView.switchingToPip = false;
            VoIPFragment.this.switchingToPip = false;
            VoIPFragment unused = VoIPFragment.instance = null;
        }
    }

    public void startTransitionFromPiP() {
        this.enterFromPiP = true;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null && sharedInstance.getVideoState(false) == 2) {
            this.callingUserTextureView.setStub(VoIPPiPView.getInstance().callingUserTextureView);
            this.currentUserTextureView.setStub(VoIPPiPView.getInstance().currentUserTextureView);
        }
        this.windowView.setAlpha(0.0f);
        updateViewState();
        this.switchingToPip = true;
        VoIPPiPView.switchingToPip = true;
        VoIPPiPView.prepareForTransition();
        this.animationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.animationIndex, null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$D1mQMVz9KgFT8k72UO1N5_cq7Ks
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startTransitionFromPiP$15$VoIPFragment();
            }
        }, 32L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startTransitionFromPiP$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startTransitionFromPiP$15$VoIPFragment() {
        this.windowView.setAlpha(1.0f);
        final Animator animatorCreatePiPTransition = createPiPTransition(true);
        this.backIcon.setAlpha(0.0f);
        this.emojiLayout.setAlpha(0.0f);
        this.statusLayout.setAlpha(0.0f);
        this.buttonsLayout.setAlpha(0.0f);
        this.bottomShadow.setAlpha(0.0f);
        this.topShadow.setAlpha(0.0f);
        this.menuShadow.setAlpha(0.0f);
        this.speakerPhoneIcon.setAlpha(0.0f);
        this.menuLayout.setAlpha(0.0f);
        this.notificationsLayout.setAlpha(0.0f);
        this.callingUserPhotoView.setAlpha(0.0f);
        this.currentUserCameraFloatingLayout.switchingToPip = true;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$GfFKRv95gqiRHPZE-iOhd-Qnl-g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startTransitionFromPiP$14$VoIPFragment(animatorCreatePiPTransition);
            }
        }, 32L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startTransitionFromPiP$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startTransitionFromPiP$14$VoIPFragment(Animator animator) {
        VoIPPiPView.switchingToPip = false;
        VoIPPiPView.finish();
        ViewPropertyAnimator duration = this.speakerPhoneIcon.animate().setDuration(150L);
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
        duration.setInterpolator(cubicBezierInterpolator).start();
        this.menuLayout.animate().setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.backIcon.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.emojiLayout.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.statusLayout.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.buttonsLayout.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        this.bottomShadow.animate().alpha(1.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.topShadow.animate().alpha(1.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.menuShadow.animate().alpha(1.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.notificationsLayout.animate().alpha(1.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        this.callingUserPhotoView.animate().alpha(1.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
        animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                NotificationCenter.getInstance(VoIPFragment.this.currentAccount).onAnimationFinish(VoIPFragment.this.animationIndex);
                VoIPFragment.this.currentUserCameraFloatingLayout.setCornerRadius(-1.0f);
                VoIPFragment.this.switchingToPip = false;
                VoIPFragment.this.currentUserCameraFloatingLayout.switchingToPip = false;
                VoIPFragment voIPFragment = VoIPFragment.this;
                voIPFragment.previousState = voIPFragment.currentState;
                VoIPFragment.this.updateViewState();
            }
        });
        animator.setDuration(350L);
        animator.setInterpolator(cubicBezierInterpolator);
        animator.start();
    }

    public Animator createPiPTransition(boolean enter) {
        final float measuredWidth;
        final float measuredHeight;
        final float f;
        final boolean z;
        float f2;
        float f3;
        float measuredWidth2;
        float measuredHeight2;
        float measuredWidth3;
        this.currentUserCameraFloatingLayout.animate().cancel();
        float f4 = VoIPPiPView.getInstance().windowLayoutParams.x + VoIPPiPView.getInstance().xOffset;
        float f5 = VoIPPiPView.getInstance().windowLayoutParams.y + VoIPPiPView.getInstance().yOffset;
        final float x = this.currentUserCameraFloatingLayout.getX();
        final float y = this.currentUserCameraFloatingLayout.getY();
        final float scaleX = this.currentUserCameraFloatingLayout.getScaleX();
        float f6 = VoIPPiPView.isExpanding() ? 0.4f : 0.25f;
        final float measuredWidth4 = f4 - ((this.callingUserTextureView.getMeasuredWidth() - (this.callingUserTextureView.getMeasuredWidth() * f6)) / 2.0f);
        final float measuredHeight3 = f5 - ((this.callingUserTextureView.getMeasuredHeight() - (this.callingUserTextureView.getMeasuredHeight() * f6)) / 2.0f);
        if (this.callingUserIsVideo) {
            int measuredWidth5 = this.currentUserCameraFloatingLayout.getMeasuredWidth();
            if (!this.currentUserIsVideo || measuredWidth5 == 0) {
                measuredWidth2 = 1.0f;
                measuredHeight2 = 1.0f;
                z = false;
                measuredWidth3 = 0.0f;
            } else {
                measuredWidth3 = (this.windowView.getMeasuredWidth() / measuredWidth5) * f6 * 0.4f;
                measuredWidth2 = (((f4 - ((this.currentUserCameraFloatingLayout.getMeasuredWidth() - (this.currentUserCameraFloatingLayout.getMeasuredWidth() * measuredWidth3)) / 2.0f)) + (VoIPPiPView.getInstance().parentWidth * f6)) - ((VoIPPiPView.getInstance().parentWidth * f6) * 0.4f)) - AndroidUtilities.dp(4.0f);
                measuredHeight2 = (((f5 - ((this.currentUserCameraFloatingLayout.getMeasuredHeight() - (this.currentUserCameraFloatingLayout.getMeasuredHeight() * measuredWidth3)) / 2.0f)) + (VoIPPiPView.getInstance().parentHeight * f6)) - ((VoIPPiPView.getInstance().parentHeight * f6) * 0.4f)) - AndroidUtilities.dp(4.0f);
                z = true;
            }
            measuredWidth = measuredWidth2;
            measuredHeight = measuredHeight2;
            f = measuredWidth3;
        } else {
            measuredWidth = f4 - ((this.currentUserCameraFloatingLayout.getMeasuredWidth() - (this.currentUserCameraFloatingLayout.getMeasuredWidth() * f6)) / 2.0f);
            measuredHeight = f5 - ((this.currentUserCameraFloatingLayout.getMeasuredHeight() - (this.currentUserCameraFloatingLayout.getMeasuredHeight() * f6)) / 2.0f);
            f = f6;
            z = true;
        }
        final float fDp = this.callingUserIsVideo ? AndroidUtilities.dp(4.0f) : 0.0f;
        final float fDp2 = (AndroidUtilities.dp(4.0f) * 1.0f) / f;
        final float f7 = 1.0f;
        if (this.callingUserIsVideo) {
            f2 = VoIPPiPView.isExpanding() ? 1.0f : 0.0f;
        } else {
            f2 = 1.0f;
        }
        if (enter) {
            if (z) {
                this.currentUserCameraFloatingLayout.setScaleX(f);
                this.currentUserCameraFloatingLayout.setScaleY(f);
                this.currentUserCameraFloatingLayout.setTranslationX(measuredWidth);
                this.currentUserCameraFloatingLayout.setTranslationY(measuredHeight);
                this.currentUserCameraFloatingLayout.setCornerRadius(fDp2);
                this.currentUserCameraFloatingLayout.setAlpha(f2);
            }
            this.callingUserTextureView.setScaleX(f6);
            this.callingUserTextureView.setScaleY(f6);
            this.callingUserTextureView.setTranslationX(measuredWidth4);
            this.callingUserTextureView.setTranslationY(measuredHeight3);
            this.callingUserTextureView.setRoundCorners((AndroidUtilities.dp(6.0f) * 1.0f) / f6);
            f3 = 0.0f;
            this.callingUserPhotoView.setAlpha(0.0f);
            this.callingUserPhotoView.setScaleX(f6);
            this.callingUserPhotoView.setScaleY(f6);
            this.callingUserPhotoView.setTranslationX(measuredWidth4);
            this.callingUserPhotoView.setTranslationY(measuredHeight3);
        } else {
            f3 = 0.0f;
        }
        float[] fArr = new float[2];
        fArr[0] = enter ? 1.0f : 0.0f;
        fArr[1] = enter ? 0.0f : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        if (!enter) {
            f3 = 1.0f;
        }
        this.enterTransitionProgress = f3;
        updateSystemBarColors();
        final float f8 = 1.0f;
        final float f9 = f2;
        final float f10 = 0.0f;
        final float f11 = 0.0f;
        final float f12 = f6;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$CY-m4HMpqN3SQF6DWFvcHmNoP7g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$createPiPTransition$16$VoIPFragment(z, scaleX, f, x, measuredWidth, y, measuredHeight, fDp, fDp2, f7, f9, f8, f12, f10, measuredWidth4, f11, measuredHeight3, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPiPTransition$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPiPTransition$16$VoIPFragment(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f17 = 1.0f - fFloatValue;
        this.enterTransitionProgress = f17;
        updateSystemBarColors();
        if (z) {
            float f18 = (f * f17) + (f2 * fFloatValue);
            this.currentUserCameraFloatingLayout.setScaleX(f18);
            this.currentUserCameraFloatingLayout.setScaleY(f18);
            this.currentUserCameraFloatingLayout.setTranslationX((f3 * f17) + (f4 * fFloatValue));
            this.currentUserCameraFloatingLayout.setTranslationY((f5 * f17) + (f6 * fFloatValue));
            this.currentUserCameraFloatingLayout.setCornerRadius((f7 * f17) + (f8 * fFloatValue));
            this.currentUserCameraFloatingLayout.setAlpha((f9 * f17) + (f10 * fFloatValue));
        }
        float f19 = (f11 * f17) + (f12 * fFloatValue);
        this.callingUserTextureView.setScaleX(f19);
        this.callingUserTextureView.setScaleY(f19);
        float f20 = (f13 * f17) + (f14 * fFloatValue);
        float f21 = (f15 * f17) + (f16 * fFloatValue);
        this.callingUserTextureView.setTranslationX(f20);
        this.callingUserTextureView.setTranslationY(f21);
        this.callingUserTextureView.setRoundCorners(((AndroidUtilities.dp(4.0f) * fFloatValue) * 1.0f) / f19);
        if (!this.currentUserCameraFloatingLayout.measuredAsFloatingMode) {
            this.currentUserTextureView.setScreenshareMiniProgress(fFloatValue, false);
        }
        this.callingUserPhotoView.setScaleX(f19);
        this.callingUserPhotoView.setScaleY(f19);
        this.callingUserPhotoView.setTranslationX(f20);
        this.callingUserPhotoView.setTranslationY(f21);
        this.callingUserPhotoView.setAlpha(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expandEmoji(boolean expanded) {
        if (this.emojiLoaded && this.emojiExpanded != expanded && this.uiVisible) {
            this.emojiExpanded = expanded;
            if (expanded) {
                AndroidUtilities.runOnUIThread(this.hideUIRunnable);
                this.hideUiRunnableWaiting = false;
                float measuredWidth = (this.windowView.getMeasuredWidth() - AndroidUtilities.dp(128.0f)) / this.emojiLayout.getMeasuredWidth();
                this.emojiLayout.animate().scaleX(measuredWidth).scaleY(measuredWidth).translationY((this.windowView.getHeight() / 2.0f) - this.emojiLayout.getBottom()).setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT).setDuration(250L).start();
                this.emojiRationalTextView.animate().setListener(null).cancel();
                if (this.emojiRationalTextView.getVisibility() != 0) {
                    this.emojiRationalTextView.setVisibility(0);
                    this.emojiRationalTextView.setAlpha(0.0f);
                }
                this.emojiRationalTextView.animate().alpha(1.0f).setDuration(150L).start();
                this.overlayBackground.animate().setListener(null).cancel();
                if (this.overlayBackground.getVisibility() != 0) {
                    this.overlayBackground.setVisibility(0);
                    this.overlayBackground.setAlpha(0.0f);
                    this.overlayBackground.setShowBlackout(this.currentUserIsVideo || this.callingUserIsVideo, false);
                }
                this.overlayBackground.animate().alpha(1.0f).setDuration(150L).start();
                return;
            }
            this.emojiLayout.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).setDuration(150L).start();
            if (this.emojiRationalTextView.getVisibility() != 8) {
                this.emojiRationalTextView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.13
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoIPService sharedInstance = VoIPService.getSharedInstance();
                        if (VoIPFragment.this.canHideUI && !VoIPFragment.this.hideUiRunnableWaiting && sharedInstance != null && !sharedInstance.isMicMute()) {
                            AndroidUtilities.runOnUIThread(VoIPFragment.this.hideUIRunnable, 3000L);
                            VoIPFragment.this.hideUiRunnableWaiting = true;
                        }
                        VoIPFragment.this.emojiRationalTextView.setVisibility(8);
                    }
                }).setDuration(150L).start();
                this.overlayBackground.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.14
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoIPFragment.this.overlayBackground.setVisibility(8);
                    }
                }).setDuration(150L).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:283:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0261 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateViewState() {
        /*
            Method dump skipped, instructions count: 1720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.VoIPFragment.updateViewState():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateViewState$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateViewState$17$VoIPFragment() {
        this.windowView.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateViewState$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateViewState$18$VoIPFragment(DialogInterface dialogInterface, int i) {
        this.windowView.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateViewState$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateViewState$19$VoIPFragment(boolean[] zArr, DialogInterface dialogInterface, int i) {
        zArr[0] = true;
        this.currentState = 17;
        Intent intent = new Intent(this.activity, (Class<?>) VoIPService.class);
        intent.putExtra("user_id", this.callingUser.id);
        intent.putExtra("is_outgoing", true);
        intent.putExtra("start_incall_activity", false);
        intent.putExtra("video_call", false);
        intent.putExtra("can_video_call", false);
        intent.putExtra("account", this.currentAccount);
        try {
            this.activity.startService(intent);
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateViewState$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateViewState$20$VoIPFragment(boolean[] zArr, DialogInterface dialogInterface) {
        if (zArr[0]) {
            return;
        }
        this.windowView.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateViewState$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateViewState$21$VoIPFragment() {
        this.windowView.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateViewState$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateViewState$22$VoIPFragment() {
        this.windowView.finish();
    }

    private void fillNavigationBar(boolean fill, boolean animated) {
        if (this.switchingToPip) {
            return;
        }
        if (!animated) {
            ValueAnimator valueAnimator = this.naviagtionBarAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.fillNaviagtionBarValue = fill ? 1.0f : 0.0f;
            this.overlayBottomPaint.setColor(ColorUtils.setAlphaComponent(-16777216, (int) ((fill ? 1.0f : 0.5f) * 255.0f)));
        } else if (fill != this.fillNaviagtionBar) {
            ValueAnimator valueAnimator2 = this.naviagtionBarAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            float[] fArr = new float[2];
            fArr[0] = this.fillNaviagtionBarValue;
            fArr[1] = fill ? 1.0f : 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            this.naviagtionBarAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.navigationBarAnimationListener);
            this.naviagtionBarAnimator.setDuration(300L);
            this.naviagtionBarAnimator.setInterpolator(new LinearInterpolator());
            this.naviagtionBarAnimator.start();
        }
        this.fillNaviagtionBar = fill;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUi(boolean show) {
        ValueAnimator valueAnimator = this.uiVisibilityAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!show && this.uiVisible) {
            ViewPropertyAnimator duration = this.speakerPhoneIcon.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(50.0f)).setDuration(150L);
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            duration.setInterpolator(cubicBezierInterpolator).start();
            this.menuLayout.animate().alpha(0.0f).translationX(AndroidUtilities.dp(100.0f)).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.backIcon.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(50.0f)).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.emojiLayout.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(50.0f)).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.statusLayout.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.buttonsLayout.animate().alpha(0.0f).translationY(AndroidUtilities.dp(50.0f)).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.bottomShadow.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.topShadow.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            this.menuShadow.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.uiVisibilityAlpha, 0.0f);
            this.uiVisibilityAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.statusbarAnimatorListener);
            this.uiVisibilityAnimator.setDuration(150L).setInterpolator(cubicBezierInterpolator);
            this.uiVisibilityAnimator.start();
            AndroidUtilities.cancelRunOnUIThread(this.hideUIRunnable);
            this.hideUiRunnableWaiting = false;
            this.buttonsLayout.setEnabled(false);
        } else if (show && !this.uiVisible) {
            this.tapToVideoTooltip.hide();
            ViewPropertyAnimator duration2 = this.speakerPhoneIcon.animate().alpha(1.0f).translationY(0.0f).setDuration(150L);
            CubicBezierInterpolator cubicBezierInterpolator2 = CubicBezierInterpolator.DEFAULT;
            duration2.setInterpolator(cubicBezierInterpolator2).start();
            this.menuLayout.animate().alpha(1.0f).translationX(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.backIcon.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.emojiLayout.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.statusLayout.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.buttonsLayout.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.bottomShadow.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.topShadow.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            this.menuShadow.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator2).start();
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.uiVisibilityAlpha, 1.0f);
            this.uiVisibilityAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.addUpdateListener(this.statusbarAnimatorListener);
            this.uiVisibilityAnimator.setDuration(150L).setInterpolator(cubicBezierInterpolator2);
            this.uiVisibilityAnimator.start();
            this.buttonsLayout.setEnabled(true);
        }
        this.uiVisible = show;
        this.windowView.requestFullscreen(!show);
        this.notificationsLayout.animate().translationY((-AndroidUtilities.dp(16.0f)) - (this.uiVisible ? AndroidUtilities.dp(80.0f) : 0)).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
    }

    private void showFloatingLayout(int state, boolean animated) {
        Animator animator;
        if (this.currentUserCameraFloatingLayout.getTag() == null || ((Integer) this.currentUserCameraFloatingLayout.getTag()).intValue() != 2) {
            this.currentUserCameraFloatingLayout.setUiVisible(this.uiVisible);
        }
        if (!animated && (animator = this.cameraShowingAnimator) != null) {
            animator.removeAllListeners();
            this.cameraShowingAnimator.cancel();
        }
        if (state != 0) {
            boolean z = (this.currentUserCameraFloatingLayout.getTag() == null || ((Integer) this.currentUserCameraFloatingLayout.getTag()).intValue() == 0) ? false : animated;
            if (animated) {
                if (this.currentUserCameraFloatingLayout.getTag() != null && ((Integer) this.currentUserCameraFloatingLayout.getTag()).intValue() == 0) {
                    if (this.currentUserCameraFloatingLayout.getVisibility() == 8) {
                        this.currentUserCameraFloatingLayout.setAlpha(0.0f);
                        this.currentUserCameraFloatingLayout.setScaleX(0.7f);
                        this.currentUserCameraFloatingLayout.setScaleY(0.7f);
                        this.currentUserCameraFloatingLayout.setVisibility(0);
                    }
                    Animator animator2 = this.cameraShowingAnimator;
                    if (animator2 != null) {
                        animator2.removeAllListeners();
                        this.cameraShowingAnimator.cancel();
                    }
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.currentUserCameraFloatingLayout, (Property<VoIPFloatingLayout, Float>) View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.currentUserCameraFloatingLayout, (Property<VoIPFloatingLayout, Float>) View.SCALE_X, 0.7f, 1.0f), ObjectAnimator.ofFloat(this.currentUserCameraFloatingLayout, (Property<VoIPFloatingLayout, Float>) View.SCALE_Y, 0.7f, 1.0f));
                    this.cameraShowingAnimator = animatorSet;
                    animatorSet.setDuration(150L).start();
                }
            } else {
                this.currentUserCameraFloatingLayout.setVisibility(0);
            }
            if (this.currentUserCameraFloatingLayout.getTag() == null || ((Integer) this.currentUserCameraFloatingLayout.getTag()).intValue() != 2) {
                VoIPFloatingLayout voIPFloatingLayout = this.currentUserCameraFloatingLayout;
                if (voIPFloatingLayout.relativePositionToSetX < 0.0f) {
                    voIPFloatingLayout.setRelativePosition(1.0f, 1.0f);
                }
            }
            this.currentUserCameraFloatingLayout.setFloatingMode(state == 2, z);
        } else if (animated) {
            if (this.currentUserCameraFloatingLayout.getTag() != null && ((Integer) this.currentUserCameraFloatingLayout.getTag()).intValue() != 0) {
                Animator animator3 = this.cameraShowingAnimator;
                if (animator3 != null) {
                    animator3.removeAllListeners();
                    this.cameraShowingAnimator.cancel();
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                VoIPFloatingLayout voIPFloatingLayout2 = this.currentUserCameraFloatingLayout;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(voIPFloatingLayout2, (Property<VoIPFloatingLayout, Float>) View.ALPHA, voIPFloatingLayout2.getAlpha(), 0.0f));
                if (this.currentUserCameraFloatingLayout.getTag() != null && ((Integer) this.currentUserCameraFloatingLayout.getTag()).intValue() == 2) {
                    VoIPFloatingLayout voIPFloatingLayout3 = this.currentUserCameraFloatingLayout;
                    Property property = View.SCALE_X;
                    float[] fArr = {voIPFloatingLayout3.getScaleX(), 0.7f};
                    VoIPFloatingLayout voIPFloatingLayout4 = this.currentUserCameraFloatingLayout;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(voIPFloatingLayout3, (Property<VoIPFloatingLayout, Float>) property, fArr), ObjectAnimator.ofFloat(voIPFloatingLayout4, (Property<VoIPFloatingLayout, Float>) View.SCALE_Y, voIPFloatingLayout4.getScaleX(), 0.7f));
                }
                this.cameraShowingAnimator = animatorSet2;
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.16
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoIPFragment.this.currentUserCameraFloatingLayout.setTranslationX(0.0f);
                        VoIPFragment.this.currentUserCameraFloatingLayout.setTranslationY(0.0f);
                        VoIPFragment.this.currentUserCameraFloatingLayout.setScaleY(1.0f);
                        VoIPFragment.this.currentUserCameraFloatingLayout.setScaleX(1.0f);
                        VoIPFragment.this.currentUserCameraFloatingLayout.setVisibility(8);
                    }
                });
                this.cameraShowingAnimator.setDuration(250L).setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.cameraShowingAnimator.setStartDelay(50L);
                this.cameraShowingAnimator.start();
            }
        } else {
            this.currentUserCameraFloatingLayout.setVisibility(8);
        }
        this.currentUserCameraFloatingLayout.setTag(Integer.valueOf(state));
    }

    private void showCallingUserAvatarMini(boolean show, boolean animated) {
        if (animated) {
            if (show && this.callingUserPhotoViewMini.getTag() == null) {
                this.callingUserPhotoViewMini.animate().setListener(null).cancel();
                this.callingUserPhotoViewMini.setVisibility(0);
                this.callingUserPhotoViewMini.setAlpha(0.0f);
                this.callingUserPhotoViewMini.setTranslationY(-AndroidUtilities.dp(135.0f));
                this.callingUserPhotoViewMini.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
            } else if (!show && this.callingUserPhotoViewMini.getTag() != null) {
                this.callingUserPhotoViewMini.animate().setListener(null).cancel();
                this.callingUserPhotoViewMini.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(135.0f)).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.17
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoIPFragment.this.callingUserPhotoViewMini.setVisibility(8);
                    }
                }).start();
            }
        } else {
            this.callingUserPhotoViewMini.animate().setListener(null).cancel();
            this.callingUserPhotoViewMini.setTranslationY(0.0f);
            this.callingUserPhotoViewMini.setAlpha(1.0f);
            this.callingUserPhotoViewMini.setVisibility(show ? 0 : 8);
        }
        this.callingUserPhotoViewMini.setTag(show ? 1 : null);
    }

    private void updateKeyView(boolean animated) {
        VoIPService sharedInstance;
        if (this.emojiLoaded || (sharedInstance = VoIPService.getSharedInstance()) == null) {
            return;
        }
        byte[] byteArray = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(sharedInstance.getEncryptionKey());
            byteArrayOutputStream.write(sharedInstance.getGA());
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (byteArray == null) {
            return;
        }
        String[] strArrEmojifyForCall = EncryptionKeyEmojifier.emojifyForCall(Utilities.computeSHA256(byteArray, 0, byteArray.length));
        for (int i = 0; i < 4; i++) {
            Emoji.EmojiDrawable emojiDrawable = Emoji.getEmojiDrawable(strArrEmojifyForCall[i]);
            if (emojiDrawable != null) {
                emojiDrawable.setBounds(0, 0, AndroidUtilities.dp(22.0f), AndroidUtilities.dp(22.0f));
                emojiDrawable.preload();
                this.emojiViews[i].setImageDrawable(emojiDrawable);
                this.emojiViews[i].setContentDescription(strArrEmojifyForCall[i]);
                this.emojiViews[i].setVisibility(8);
            }
            this.emojiDrawables[i] = emojiDrawable;
        }
        checkEmojiLoaded(animated);
    }

    private void checkEmojiLoaded(boolean animated) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            Emoji.EmojiDrawable[] emojiDrawableArr = this.emojiDrawables;
            if (emojiDrawableArr[i2] != null && emojiDrawableArr[i2].isLoaded()) {
                i++;
            }
        }
        if (i == 4) {
            this.emojiLoaded = true;
            for (int i3 = 0; i3 < 4; i3++) {
                if (this.emojiViews[i3].getVisibility() != 0) {
                    this.emojiViews[i3].setVisibility(0);
                    if (animated) {
                        this.emojiViews[i3].setAlpha(0.0f);
                        this.emojiViews[i3].setTranslationY(AndroidUtilities.dp(30.0f));
                        this.emojiViews[i3].animate().alpha(1.0f).translationY(0.0f).setDuration(200L).setStartDelay(i3 * 20).start();
                    }
                }
            }
        }
    }

    private void showAcceptDeclineView(boolean show, boolean animated) {
        if (!animated) {
            this.acceptDeclineView.setVisibility(show ? 0 : 8);
        } else {
            if (show && this.acceptDeclineView.getTag() == null) {
                this.acceptDeclineView.animate().setListener(null).cancel();
                if (this.acceptDeclineView.getVisibility() == 8) {
                    this.acceptDeclineView.setVisibility(0);
                    this.acceptDeclineView.setAlpha(0.0f);
                }
                this.acceptDeclineView.animate().alpha(1.0f);
            }
            if (!show && this.acceptDeclineView.getTag() != null) {
                this.acceptDeclineView.animate().setListener(null).cancel();
                this.acceptDeclineView.animate().setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoIPFragment.18
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoIPFragment.this.acceptDeclineView.setVisibility(8);
                    }
                }).alpha(0.0f);
            }
        }
        this.acceptDeclineView.setEnabled(show);
        this.acceptDeclineView.setTag(show ? 1 : null);
    }

    private void updateButtons(boolean animated) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (animated && Build.VERSION.SDK_INT >= 19) {
            TransitionSet transitionSet = new TransitionSet();
            Transition duration = new Visibility() { // from class: ir.eitaa.ui.VoIPFragment.19
                @Override // android.transition.Visibility
                public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(100.0f), 0.0f);
                    if (view instanceof VoIPToggleButton) {
                        view.setTranslationY(AndroidUtilities.dp(100.0f));
                        objectAnimatorOfFloat.setStartDelay(((VoIPToggleButton) view).animationDelay);
                    }
                    return objectAnimatorOfFloat;
                }

                @Override // android.transition.Visibility
                public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
                    return ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getTranslationY(), AndroidUtilities.dp(100.0f));
                }
            }.setDuration(150L);
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            transitionSet.addTransition(duration.setInterpolator(cubicBezierInterpolator)).addTransition(new ChangeBounds().setDuration(150L).setInterpolator(cubicBezierInterpolator));
            transitionSet.excludeChildren(VoIPToggleButton.class, true);
            TransitionManager.beginDelayedTransition(this.buttonsLayout, transitionSet);
        }
        int i = this.currentState;
        if (i == 15 || i == 17) {
            TLRPC$PhoneCall tLRPC$PhoneCall = sharedInstance.privateCall;
            if (tLRPC$PhoneCall != null && tLRPC$PhoneCall.video && i == 15) {
                if (!sharedInstance.isScreencast() && (this.currentUserIsVideo || this.callingUserIsVideo)) {
                    setFrontalCameraAction(this.bottomButtons[0], sharedInstance, animated);
                    if (this.uiVisible) {
                        this.speakerPhoneIcon.animate().alpha(1.0f).start();
                        this.menuLayout.animate().alpha(1.0f).start();
                    }
                } else {
                    setSpeakerPhoneAction(this.bottomButtons[0], sharedInstance, animated);
                    this.speakerPhoneIcon.animate().alpha(0.0f).start();
                    this.menuLayout.animate().alpha(0.0f).start();
                }
                setVideoAction(this.bottomButtons[1], sharedInstance, animated);
                setMicrohoneAction(this.bottomButtons[2], sharedInstance, animated);
            } else {
                this.bottomButtons[0].setVisibility(8);
                this.bottomButtons[1].setVisibility(8);
                this.bottomButtons[2].setVisibility(8);
            }
            this.bottomButtons[3].setVisibility(8);
        } else {
            if (instance == null) {
                return;
            }
            if (!sharedInstance.isScreencast() && (this.currentUserIsVideo || this.callingUserIsVideo)) {
                setFrontalCameraAction(this.bottomButtons[0], sharedInstance, animated);
                if (this.uiVisible) {
                    this.speakerPhoneIcon.setTag(1);
                    this.speakerPhoneIcon.animate().alpha(1.0f).start();
                    this.menuLayout.setTag(1);
                    this.menuLayout.animate().alpha(1.0f).start();
                }
            } else {
                setSpeakerPhoneAction(this.bottomButtons[0], sharedInstance, animated);
                this.speakerPhoneIcon.setTag(null);
                this.speakerPhoneIcon.animate().alpha(0.0f).start();
                this.menuLayout.setTag(null);
                this.menuLayout.animate().alpha(0.0f).start();
            }
            setVideoAction(this.bottomButtons[1], sharedInstance, animated);
            setMicrohoneAction(this.bottomButtons[2], sharedInstance, animated);
            this.bottomButtons[3].setData(R.drawable.calls_decline, -1, -1041108, LocaleController.getString("VoipEndCall", R.string.VoipEndCall), false, animated);
            this.bottomButtons[3].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$uhTWRNT4_QktuiTZDlJsxjUDLaA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalStateException, InterruptedException {
                    VoIPFragment.lambda$updateButtons$23(view);
                }
            });
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.bottomButtons[i3].getVisibility() == 0) {
                this.bottomButtons[i3].animationDelay = i2;
                i2 += 16;
            }
        }
        updateSpeakerPhoneIcon();
    }

    static /* synthetic */ void lambda$updateButtons$23(View view) throws IllegalStateException, InterruptedException {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().hangUp();
        }
    }

    private void setMicrohoneAction(VoIPToggleButton bottomButton, VoIPService service, boolean animated) {
        if (service.isMicMute()) {
            bottomButton.setData(R.drawable.calls_unmute, -16777216, -1, LocaleController.getString("VoipUnmute", R.string.VoipUnmute), true, animated);
        } else {
            bottomButton.setData(R.drawable.calls_unmute, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipMute", R.string.VoipMute), false, animated);
        }
        this.currentUserCameraFloatingLayout.setMuted(service.isMicMute(), animated);
        bottomButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$SlJvvDT6hgcIfaJf1MGowL8ALEc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setMicrohoneAction$24$VoIPFragment(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setMicrohoneAction$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setMicrohoneAction$24$VoIPFragment(View view) {
        String string;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            boolean z = !sharedInstance.isMicMute();
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                if (z) {
                    string = LocaleController.getString("AccDescrVoipMicOff", R.string.AccDescrVoipMicOff);
                } else {
                    string = LocaleController.getString("AccDescrVoipMicOn", R.string.AccDescrVoipMicOn);
                }
                view.announceForAccessibility(string);
            }
            sharedInstance.setMicMute(z, false, true);
            this.previousState = this.currentState;
            updateViewState();
        }
    }

    private void setVideoAction(VoIPToggleButton bottomButton, final VoIPService service, boolean animated) {
        if ((this.currentUserIsVideo || this.callingUserIsVideo) ? true : service.isVideoAvailable()) {
            if (this.currentUserIsVideo) {
                bottomButton.setData(service.isScreencast() ? R.drawable.calls_sharescreen : R.drawable.calls_video, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipStopVideo", R.string.VoipStopVideo), false, animated);
            } else {
                bottomButton.setData(R.drawable.calls_video, -16777216, -1, LocaleController.getString("VoipStartVideo", R.string.VoipStartVideo), true, animated);
            }
            bottomButton.setCrossOffset(-AndroidUtilities.dpf2(3.5f));
            bottomButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$H9uRSpAJ5a3CCKpZN7FFxH73niY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setVideoAction$26$VoIPFragment(service, view);
                }
            });
            bottomButton.setEnabled(true);
            return;
        }
        bottomButton.setData(R.drawable.calls_video, ColorUtils.setAlphaComponent(-1, 127), ColorUtils.setAlphaComponent(-1, 30), "Video", false, animated);
        bottomButton.setOnClickListener(null);
        bottomButton.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setVideoAction$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setVideoAction$26$VoIPFragment(final VoIPService voIPService, View view) {
        TLRPC$PhoneCall tLRPC$PhoneCall;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && this.activity.checkSelfPermission("android.permission.CAMERA") != 0) {
            this.activity.requestPermissions(new String[]{"android.permission.CAMERA"}, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle);
            return;
        }
        if (i < 21 && (tLRPC$PhoneCall = voIPService.privateCall) != null && !tLRPC$PhoneCall.video && !this.callingUserIsVideo && !voIPService.sharedUIParams.cameraAlertWasShowed) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
            builder.setMessage(LocaleController.getString("VoipSwitchToVideoCall", R.string.VoipSwitchToVideoCall));
            builder.setPositiveButton(LocaleController.getString("VoipSwitch", R.string.VoipSwitch), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$FcvzUiaZi1YRtds28AtP88BgHRM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$setVideoAction$25$VoIPFragment(voIPService, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            builder.create().show();
            return;
        }
        toggleCameraInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setVideoAction$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setVideoAction$25$VoIPFragment(VoIPService voIPService, DialogInterface dialogInterface, int i) {
        voIPService.sharedUIParams.cameraAlertWasShowed = true;
        toggleCameraInput();
    }

    private void updateSpeakerPhoneIcon() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (sharedInstance.isBluetoothOn()) {
            this.speakerPhoneIcon.setImageResource(R.drawable.calls_bluetooth);
            return;
        }
        if (sharedInstance.isSpeakerphoneOn()) {
            this.speakerPhoneIcon.setImageResource(R.drawable.calls_speaker);
        } else if (sharedInstance.isHeadsetPlugged()) {
            this.speakerPhoneIcon.setImageResource(R.drawable.calls_menu_headset);
        } else {
            this.speakerPhoneIcon.setImageResource(R.drawable.calls_menu_phone);
        }
    }

    private void setSpeakerPhoneAction(VoIPToggleButton bottomButton, VoIPService service, boolean animated) {
        if (service.isBluetoothOn()) {
            bottomButton.setData(R.drawable.calls_bluetooth, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth), false, animated);
            bottomButton.setChecked(false, animated);
        } else if (service.isSpeakerphoneOn()) {
            bottomButton.setData(R.drawable.calls_speaker, -16777216, -1, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, animated);
            bottomButton.setChecked(true, animated);
        } else {
            bottomButton.setData(R.drawable.calls_speaker, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, animated);
            bottomButton.setChecked(false, animated);
        }
        bottomButton.setCheckableForAccessibility(true);
        bottomButton.setEnabled(true);
        bottomButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$O_S4nV8hEbF-vATtd8AtV5Qn5VU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setSpeakerPhoneAction$27$VoIPFragment(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setSpeakerPhoneAction$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setSpeakerPhoneAction$27$VoIPFragment(View view) {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().toggleSpeakerphoneOrShowRouteSheet(this.activity, false);
        }
    }

    private void setFrontalCameraAction(VoIPToggleButton bottomButton, final VoIPService service, boolean animated) {
        if (!this.currentUserIsVideo) {
            bottomButton.setData(R.drawable.calls_flip, ColorUtils.setAlphaComponent(-1, 127), ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipFlip", R.string.VoipFlip), false, animated);
            bottomButton.setOnClickListener(null);
            bottomButton.setEnabled(false);
        } else {
            bottomButton.setEnabled(true);
            if (!service.isFrontFaceCamera()) {
                bottomButton.setData(R.drawable.calls_flip, -16777216, -1, LocaleController.getString("VoipFlip", R.string.VoipFlip), false, animated);
            } else {
                bottomButton.setData(R.drawable.calls_flip, -1, ColorUtils.setAlphaComponent(-1, 30), LocaleController.getString("VoipFlip", R.string.VoipFlip), false, animated);
            }
            bottomButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$PEi_pJoCokrBrpczrciDJpXlIzI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setFrontalCameraAction$28$VoIPFragment(service, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setFrontalCameraAction$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setFrontalCameraAction$28$VoIPFragment(VoIPService voIPService, View view) {
        String string;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                if (voIPService.isFrontFaceCamera()) {
                    string = LocaleController.getString("AccDescrVoipCamSwitchedToBack", R.string.AccDescrVoipCamSwitchedToBack);
                } else {
                    string = LocaleController.getString("AccDescrVoipCamSwitchedToFront", R.string.AccDescrVoipCamSwitchedToFront);
                }
                view.announceForAccessibility(string);
            }
            sharedInstance.switchCamera();
        }
    }

    public void onScreenCastStart() {
        PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
        if (privateVideoPreviewDialog == null) {
            return;
        }
        privateVideoPreviewDialog.dismiss(true, true);
    }

    private void toggleCameraInput() {
        String string;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                if (!this.currentUserIsVideo) {
                    string = LocaleController.getString("AccDescrVoipCamOn", R.string.AccDescrVoipCamOn);
                } else {
                    string = LocaleController.getString("AccDescrVoipCamOff", R.string.AccDescrVoipCamOff);
                }
                this.fragmentView.announceForAccessibility(string);
            }
            boolean z = false;
            if (!this.currentUserIsVideo) {
                boolean z2 = true;
                if (Build.VERSION.SDK_INT >= 21) {
                    if (this.previewDialog == null) {
                        sharedInstance.createCaptureDevice(false);
                        if (!sharedInstance.isFrontFaceCamera()) {
                            sharedInstance.switchCamera();
                        }
                        this.windowView.setLockOnScreen(true);
                        PrivateVideoPreviewDialog privateVideoPreviewDialog = new PrivateVideoPreviewDialog(this.fragmentView.getContext(), z, z2) { // from class: ir.eitaa.ui.VoIPFragment.20
                            @Override // ir.eitaa.ui.Components.voip.PrivateVideoPreviewDialog
                            public void onDismiss(boolean screencast, boolean apply) {
                                VoIPFragment.this.previewDialog = null;
                                VoIPService sharedInstance2 = VoIPService.getSharedInstance();
                                VoIPFragment.this.windowView.setLockOnScreen(false);
                                if (apply) {
                                    VoIPFragment.this.currentUserIsVideo = true;
                                    if (sharedInstance2 != null && !screencast) {
                                        sharedInstance2.requestVideoCall(false);
                                        sharedInstance2.setVideoState(false, 2);
                                    }
                                } else if (sharedInstance2 != null) {
                                    sharedInstance2.setVideoState(false, 0);
                                }
                                VoIPFragment voIPFragment = VoIPFragment.this;
                                voIPFragment.previousState = voIPFragment.currentState;
                                VoIPFragment.this.updateViewState();
                            }
                        };
                        this.previewDialog = privateVideoPreviewDialog;
                        WindowInsets windowInsets = this.lastInsets;
                        if (windowInsets != null) {
                            privateVideoPreviewDialog.setBottomPadding(windowInsets.getSystemWindowInsetBottom());
                        }
                        this.fragmentView.addView(this.previewDialog);
                        return;
                    }
                    return;
                }
                this.currentUserIsVideo = true;
                if (!sharedInstance.isSpeakerphoneOn()) {
                    VoIPService.getSharedInstance().toggleSpeakerphoneOrShowRouteSheet(this.activity, false);
                }
                sharedInstance.requestVideoCall(false);
                sharedInstance.setVideoState(false, 2);
            } else {
                this.currentUserTextureView.saveCameraLastBitmap();
                sharedInstance.setVideoState(false, 0);
                if (Build.VERSION.SDK_INT >= 21) {
                    sharedInstance.clearCamera();
                }
            }
            this.previousState = this.currentState;
            updateViewState();
        }
    }

    public static void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        VoIPFragment voIPFragment = instance;
        if (voIPFragment != null) {
            voIPFragment.onRequestPermissionsResultInternal(requestCode, permissions, grantResults);
        }
    }

    @TargetApi(23)
    private void onRequestPermissionsResultInternal(int requestCode, String[] permissions, int[] grantResults) throws IllegalStateException, InterruptedException, IOException {
        if (requestCode == 101) {
            if (VoIPService.getSharedInstance() == null) {
                this.windowView.finish();
                return;
            } else if (grantResults.length > 0 && grantResults[0] == 0) {
                VoIPService.getSharedInstance().acceptIncomingCall();
            } else if (!this.activity.shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO")) {
                VoIPService.getSharedInstance().declineIncomingCall();
                VoIPHelper.permissionDenied(this.activity, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$CWFmtilleFB3QLnjR7P2us-0nyY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onRequestPermissionsResultInternal$29$VoIPFragment();
                    }
                }, requestCode);
                return;
            }
        }
        if (requestCode == 102) {
            if (VoIPService.getSharedInstance() == null) {
                this.windowView.finish();
            } else {
                if (grantResults.length <= 0 || grantResults[0] != 0) {
                    return;
                }
                toggleCameraInput();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestPermissionsResultInternal$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestPermissionsResultInternal$29$VoIPFragment() {
        this.windowView.finish();
    }

    private void updateSystemBarColors() {
        this.overlayPaint.setColor(ColorUtils.setAlphaComponent(-16777216, (int) (this.uiVisibilityAlpha * 102.0f * this.enterTransitionProgress)));
        this.overlayBottomPaint.setColor(ColorUtils.setAlphaComponent(-16777216, (int) (((this.fillNaviagtionBarValue * 0.5f) + 0.5f) * 255.0f * this.enterTransitionProgress)));
        ViewGroup viewGroup = this.fragmentView;
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public static void onPause() {
        VoIPFragment voIPFragment = instance;
        if (voIPFragment != null) {
            voIPFragment.onPauseInternal();
        }
        if (VoIPPiPView.getInstance() != null) {
            VoIPPiPView.getInstance().onPause();
        }
    }

    public static void onResume() {
        VoIPFragment voIPFragment = instance;
        if (voIPFragment != null) {
            voIPFragment.onResumeInternal();
        }
        if (VoIPPiPView.getInstance() != null) {
            VoIPPiPView.getInstance().onResume();
        }
    }

    public void onPauseInternal() {
        boolean zIsScreenOn;
        VoIPService sharedInstance;
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        PowerManager powerManager = (PowerManager) this.activity.getSystemService("power");
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            zIsScreenOn = powerManager.isInteractive();
        } else {
            zIsScreenOn = powerManager.isScreenOn();
        }
        boolean zCheckInlinePermissions = AndroidUtilities.checkInlinePermissions(this.activity);
        if (this.canSwitchToPip && zCheckInlinePermissions) {
            int measuredHeight = instance.windowView.getMeasuredHeight();
            if (i >= 20 && (windowInsets2 = instance.lastInsets) != null) {
                measuredHeight -= windowInsets2.getSystemWindowInsetBottom();
            }
            VoIPFragment voIPFragment = instance;
            VoIPPiPView.show(voIPFragment.activity, voIPFragment.currentAccount, voIPFragment.windowView.getMeasuredWidth(), measuredHeight, 0);
            if (i >= 20 && (windowInsets = instance.lastInsets) != null) {
                VoIPPiPView.topInset = windowInsets.getSystemWindowInsetTop();
                VoIPPiPView.bottomInset = instance.lastInsets.getSystemWindowInsetBottom();
            }
        }
        if (this.currentUserIsVideo) {
            if ((zCheckInlinePermissions && zIsScreenOn) || (sharedInstance = VoIPService.getSharedInstance()) == null) {
                return;
            }
            sharedInstance.setVideoState(false, 1);
        }
    }

    public void onResumeInternal() {
        if (VoIPPiPView.getInstance() != null) {
            VoIPPiPView.finish();
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            if (sharedInstance.getVideoState(false) == 1) {
                sharedInstance.setVideoState(false, 2);
            }
            updateViewState();
        } else {
            this.windowView.finish();
        }
        this.deviceIsLocked = ((KeyguardManager) this.activity.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    private void showErrorDialog(CharSequence message) {
        if (this.activity.isFinishing()) {
            return;
        }
        AlertDialog alertDialogShow = new DarkAlertDialog.Builder(this.activity).setTitle(LocaleController.getString("VoipFailed", R.string.VoipFailed)).setMessage(message).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).show();
        alertDialogShow.setCanceledOnTouchOutside(true);
        alertDialogShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$YqSFk5IY2BDf_D4qumTu360SONg
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showErrorDialog$30$VoIPFragment(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showErrorDialog$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showErrorDialog$30$VoIPFragment(DialogInterface dialogInterface) {
        this.windowView.finish();
    }

    @SuppressLint({"InlinedApi"})
    private void requestInlinePermissions() {
        if (Build.VERSION.SDK_INT >= 21) {
            AlertsCreator.createDrawOverlayPermissionDialog(this.activity, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$VoIPFragment$RnOzAOd197qZf6rRMG_zMP3fGCo
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$requestInlinePermissions$31$VoIPFragment(dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$requestInlinePermissions$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$requestInlinePermissions$31$VoIPFragment(DialogInterface dialogInterface, int i) {
        VoIPWindowView voIPWindowView = this.windowView;
        if (voIPWindowView != null) {
            voIPWindowView.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareBlurBitmap() {
        Bitmap bitmap;
        if (this.blurredView == null || (bitmap = this.callingUserMiniTextureRenderer.getBitmap()) == null) {
            return;
        }
        Bitmap bitmapScaleBitmap = Utilities.scaleBitmap(bitmap, 0.16666667f);
        Utilities.stackBlurBitmap(bitmapScaleBitmap, 100);
        this.blurredView.setBackground(new BitmapDrawable(bitmapScaleBitmap));
        this.blurredView.setAlpha(1.0f);
        this.blurredView.setVisibility(0);
    }

    private void startBlurUpdate() {
        Handler handler = new Handler(this.activity.getMainLooper());
        this.blurUpdateHandler = handler;
        handler.postDelayed(new Runnable() { // from class: ir.eitaa.ui.VoIPFragment.21
            @Override // java.lang.Runnable
            public void run() {
                if (VoIPFragment.this.blurUpdateHandler == null || !VoIPFragment.this.blurState) {
                    return;
                }
                VoIPFragment.this.prepareBlurBitmap();
                VoIPFragment.this.callingUserTextureView.setBlurState(true);
                VoIPFragment.this.blurUpdateHandler.postDelayed(this, 30L);
            }
        }, 1L);
    }

    private void stopBlurUpdate() {
        this.blurUpdateHandler = null;
        this.callingUserTextureView.setBlurState(false);
    }
}
