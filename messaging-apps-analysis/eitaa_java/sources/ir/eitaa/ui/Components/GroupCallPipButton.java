package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.Random;

/* loaded from: classes3.dex */
public class GroupCallPipButton extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, VoIPService.StateListener {
    float amplitude;
    float animateAmplitudeDiff;
    float animateToAmplitude;
    private RLottieDrawable bigMicDrawable;
    BlobDrawable blobDrawable;
    BlobDrawable blobDrawable2;
    private final int currentAccount;
    WeavingState currentState;
    long lastStubUpdateAmplitude;
    Matrix matrix;
    private RLottieImageView muteButton;
    OvershootInterpolator overshootInterpolator;
    Paint paint;
    float pinnedProgress;
    boolean prepareToRemove;
    private final LinearGradient prepareToRemoveShader;
    float pressedProgress;
    boolean pressedState;
    WeavingState previousState;
    float progressToPrepareRemove;
    float progressToState;
    Random random;
    float removeAngle;
    public boolean removed;
    WeavingState[] states;
    private boolean stub;
    float wavesEnter;

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraFirstFrameAvailable() {
        VoIPService.StateListener.CC.$default$onCameraFirstFrameAvailable(this);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraSwitch(boolean z) {
        VoIPService.StateListener.CC.$default$onCameraSwitch(this, z);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onMediaStateUpdated(int i, int i2) {
        VoIPService.StateListener.CC.$default$onMediaStateUpdated(this, i, i2);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onScreenOnChange(boolean z) {
        VoIPService.StateListener.CC.$default$onScreenOnChange(this, z);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onSignalBarsCountChanged(int i) {
        VoIPService.StateListener.CC.$default$onSignalBarsCountChanged(this, i);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onVideoAvailableChange(boolean z) {
        VoIPService.StateListener.CC.$default$onVideoAvailableChange(this, z);
    }

    public GroupCallPipButton(Context context, int currentAccount, boolean stub) {
        super(context);
        this.paint = new Paint(1);
        this.blobDrawable = new BlobDrawable(8);
        this.blobDrawable2 = new BlobDrawable(9);
        this.progressToState = 1.0f;
        this.matrix = new Matrix();
        this.wavesEnter = 0.0f;
        this.random = new Random();
        this.states = new WeavingState[4];
        this.overshootInterpolator = new OvershootInterpolator();
        this.stub = stub;
        this.currentAccount = currentAccount;
        for (int i = 0; i < 4; i++) {
            this.states[i] = new WeavingState(i);
        }
        this.blobDrawable.maxRadius = AndroidUtilities.dp(37.0f);
        this.blobDrawable.minRadius = AndroidUtilities.dp(32.0f);
        this.blobDrawable2.maxRadius = AndroidUtilities.dp(37.0f);
        this.blobDrawable2.minRadius = AndroidUtilities.dp(32.0f);
        this.blobDrawable.generateBlob();
        this.blobDrawable2.generateBlob();
        this.bigMicDrawable = new RLottieDrawable(R.raw.voice_outlined, "2131624057", AndroidUtilities.dp(22.0f), AndroidUtilities.dp(30.0f), true, (int[]) null);
        setWillNotDraw(false);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.muteButton = rLottieImageView;
        rLottieImageView.setAnimation(this.bigMicDrawable);
        this.muteButton.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.muteButton);
        this.prepareToRemoveShader = new LinearGradient(0.0f, 0.0f, AndroidUtilities.dp(350.0f), 0.0f, new int[]{-2801343, -561538, 0}, new float[]{0.0f, 0.4f, 1.0f}, Shader.TileMode.CLAMP);
        if (stub) {
            setState(0);
        }
    }

    public void setPressedState(boolean pressedState) {
        this.pressedState = pressedState;
    }

    public void setPinnedProgress(float pinnedProgress) {
        this.pinnedProgress = pinnedProgress;
    }

    public static class WeavingState {
        int color1;
        int color2;
        int color3;
        private final int currentState;
        private float duration;
        public Shader shader;
        private float startX;
        private float startY;
        private float time;
        private float targetX = -1.0f;
        private float targetY = -1.0f;
        private final Matrix matrix = new Matrix();

        public WeavingState(int state) {
            this.currentState = state;
        }

        public void update(long dt, float amplitude) {
            int i = this.currentState;
            if (i == 0) {
                if (this.color1 != Theme.getColor("voipgroup_overlayGreen1") || this.color2 != Theme.getColor("voipgroup_overlayGreen2")) {
                    int color = Theme.getColor("voipgroup_overlayGreen1");
                    this.color1 = color;
                    int color2 = Theme.getColor("voipgroup_overlayGreen2");
                    this.color2 = color2;
                    this.shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{color, color2}, (float[]) null, Shader.TileMode.CLAMP);
                }
            } else if (i == 1) {
                if (this.color1 != Theme.getColor("voipgroup_overlayBlue1") || this.color2 != Theme.getColor("voipgroup_overlayBlue2")) {
                    int color3 = Theme.getColor("voipgroup_overlayBlue1");
                    this.color1 = color3;
                    int color4 = Theme.getColor("voipgroup_overlayBlue2");
                    this.color2 = color4;
                    this.shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{color3, color4}, (float[]) null, Shader.TileMode.CLAMP);
                }
            } else {
                if (i != 3) {
                    return;
                }
                if (this.color1 != Theme.getColor("voipgroup_mutedByAdminGradient") || this.color2 != Theme.getColor("voipgroup_mutedByAdminGradient2") || this.color3 != Theme.getColor("voipgroup_mutedByAdminGradient3")) {
                    int color5 = Theme.getColor("voipgroup_mutedByAdminGradient2");
                    this.color2 = color5;
                    int color6 = Theme.getColor("voipgroup_mutedByAdminGradient3");
                    this.color3 = color6;
                    int color7 = Theme.getColor("voipgroup_mutedByAdminGradient");
                    this.color1 = color7;
                    this.shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{color5, color6, color7}, (float[]) null, Shader.TileMode.CLAMP);
                }
            }
            int iDp = AndroidUtilities.dp(130.0f);
            float f = this.duration;
            if (f == 0.0f || this.time >= f) {
                this.duration = Utilities.random.nextInt(700) + 500;
                this.time = 0.0f;
                if (this.targetX == -1.0f) {
                    updateTargets();
                }
                this.startX = this.targetX;
                this.startY = this.targetY;
                updateTargets();
            }
            float f2 = dt;
            float f3 = this.time + ((BlobDrawable.GRADIENT_SPEED_MIN + 0.5f) * f2) + (f2 * BlobDrawable.GRADIENT_SPEED_MAX * 2.0f * amplitude);
            this.time = f3;
            float f4 = this.duration;
            if (f3 > f4) {
                this.time = f4;
            }
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.time / f4);
            float f5 = iDp;
            float f6 = this.startX;
            float f7 = ((f6 + ((this.targetX - f6) * interpolation)) * f5) - 200.0f;
            float f8 = this.startY;
            float f9 = ((f8 + ((this.targetY - f8) * interpolation)) * f5) - 200.0f;
            float f10 = (f5 / 400.0f) * (this.currentState != 3 ? 1.5f : 2.0f);
            this.matrix.reset();
            this.matrix.postTranslate(f7, f9);
            this.matrix.postScale(f10, f10, f7 + 200.0f, f9 + 200.0f);
            this.shader.setLocalMatrix(this.matrix);
        }

        private void updateTargets() {
            int i = this.currentState;
            if (i == 0) {
                this.targetX = ((Utilities.random.nextInt(100) * 0.1f) / 100.0f) + 0.2f;
                this.targetY = ((Utilities.random.nextInt(100) * 0.1f) / 100.0f) + 0.7f;
            } else if (i == 3) {
                this.targetX = ((Utilities.random.nextInt(100) * 0.1f) / 100.0f) + 0.6f;
                this.targetY = (Utilities.random.nextInt(100) * 0.1f) / 100.0f;
            } else {
                this.targetX = ((Utilities.random.nextInt(100) / 100.0f) * 0.2f) + 0.8f;
                this.targetY = Utilities.random.nextInt(100) / 100.0f;
            }
        }

        public void setToPaint(Paint paint) {
            if (this.currentState == 2) {
                paint.setShader(null);
                paint.setColor(Theme.getColor("voipgroup_topPanelGray"));
            } else {
                paint.setShader(this.shader);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0129  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupCallPipButton.onDraw(android.graphics.Canvas):void");
    }

    private void setAmplitude(double value) {
        float fMin = (float) (Math.min(8500.0d, value) / 8500.0d);
        this.animateToAmplitude = fMin;
        this.animateAmplitudeDiff = (fMin - this.amplitude) / ((BlobDrawable.AMPLITUDE_SPEED * 500.0f) + 100.0f);
    }

    public void setState(int state) {
        String string;
        WeavingState weavingState = this.currentState;
        if (weavingState == null || weavingState.currentState != state) {
            WeavingState weavingState2 = this.currentState;
            this.previousState = weavingState2;
            WeavingState weavingState3 = this.states[state];
            this.currentState = weavingState3;
            if (weavingState2 != null) {
                this.progressToState = 0.0f;
            } else {
                this.progressToState = 1.0f;
                this.wavesEnter = (weavingState3.currentState == 3 || this.currentState.currentState == 2) ? false : true ? 1.0f : 0.0f;
            }
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance != null && ChatObject.isChannelOrGiga(sharedInstance.getChat())) {
                string = LocaleController.getString("VoipChannelVoiceChat", R.string.VoipChannelVoiceChat);
            } else {
                string = LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat);
            }
            if (state == 0) {
                string = string + ", " + LocaleController.getString("VoipTapToMute", R.string.VoipTapToMute);
            } else if (state == 2) {
                string = string + ", " + LocaleController.getString("Connecting", R.string.Connecting);
            } else if (state == 3) {
                string = string + ", " + LocaleController.getString("VoipMutedByAdmin", R.string.VoipMutedByAdmin);
            }
            setContentDescription(string);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        int i;
        String str;
        super.onInitializeAccessibilityNodeInfo(info);
        if (Build.VERSION.SDK_INT < 21 || GroupCallPip.getInstance() == null) {
            return;
        }
        if (GroupCallPip.getInstance().showAlert) {
            i = R.string.AccDescrCloseMenu;
            str = "AccDescrCloseMenu";
        } else {
            i = R.string.AccDescrOpenMenu2;
            str = "AccDescrOpenMenu2";
        }
        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString(str, i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        if (this.stub) {
            return;
        }
        setAmplitude(0.0d);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.webRtcMicAmplitudeEvent);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupCallUpdated);
        boolean z = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().isMicMute();
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().registerStateListener(this);
        }
        this.bigMicDrawable.setCustomEndFrame(z ? 13 : 24);
        RLottieDrawable rLottieDrawable = this.bigMicDrawable;
        rLottieDrawable.setCurrentFrame(rLottieDrawable.getCustomEndFrame() - 1, false, true);
        updateButtonState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateButtonState() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null || sharedInstance.groupCall == null) {
            return;
        }
        int callState = sharedInstance.getCallState();
        if (callState == 1 || callState == 2 || callState == 6 || callState == 5) {
            setState(2);
            return;
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = sharedInstance.groupCall.participants.get(sharedInstance.getSelfId());
        if (tLRPC$TL_groupCallParticipant != null && !tLRPC$TL_groupCallParticipant.can_self_unmute && tLRPC$TL_groupCallParticipant.muted && !ChatObject.canManageCalls(sharedInstance.getChat())) {
            if (!sharedInstance.isMicMute()) {
                sharedInstance.setMicMute(true, false, false);
            }
            setState(3);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            if (getParent() != null) {
                ((View) getParent()).dispatchTouchEvent(motionEventObtain);
                return;
            }
            return;
        }
        setState(sharedInstance.isMicMute() ? 1 : 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.stub) {
            return;
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.webRtcMicAmplitudeEvent);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupCallUpdated);
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().unregisterStateListener(this);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.webRtcMicAmplitudeEvent) {
            setAmplitude(((Float) args[0]).floatValue() * 4000.0f);
        } else if (id == NotificationCenter.groupCallUpdated) {
            updateButtonState();
        }
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onAudioSettingsChanged() {
        boolean z = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().isMicMute();
        if (this.bigMicDrawable.setCustomEndFrame(z ? 13 : 24)) {
            if (z) {
                this.bigMicDrawable.setCurrentFrame(0);
            } else {
                this.bigMicDrawable.setCurrentFrame(12);
            }
        }
        this.muteButton.playAnimation();
        updateButtonState();
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int state) {
        updateButtonState();
    }

    public void setRemoveAngle(double angle) {
        this.removeAngle = (float) angle;
    }

    public void prepareToRemove(boolean prepare) {
        if (this.prepareToRemove != prepare) {
            invalidate();
        }
        this.prepareToRemove = prepare;
    }
}
