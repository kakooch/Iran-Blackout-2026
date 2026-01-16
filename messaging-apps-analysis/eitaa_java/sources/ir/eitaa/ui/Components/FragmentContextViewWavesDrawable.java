package ir.eitaa.ui.Components;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FragmentContextViewWavesDrawable {
    private float amplitude;
    private float amplitude2;
    private float animateAmplitudeDiff;
    private float animateAmplitudeDiff2;
    private float animateToAmplitude;
    WeavingState currentState;
    private long lastUpdateTime;
    WeavingState pausedState;
    WeavingState previousState;
    WeavingState[] states = new WeavingState[4];
    float progressToState = 1.0f;
    ArrayList<View> parents = new ArrayList<>();
    Paint paint = new Paint(1);
    LineBlobDrawable lineBlobDrawable = new LineBlobDrawable(5);
    LineBlobDrawable lineBlobDrawable1 = new LineBlobDrawable(7);
    LineBlobDrawable lineBlobDrawable2 = new LineBlobDrawable(8);
    RectF rect = new RectF();
    Path path = new Path();
    private final Paint selectedPaint = new Paint(1);

    public FragmentContextViewWavesDrawable() {
        for (int i = 0; i < 4; i++) {
            this.states[i] = new WeavingState(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[PHI: r4
      0x006d: PHI (r4v2 long) = (r4v1 long), (r4v39 long) binds: [B:27:0x004e, B:33:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(float r21, float r22, float r23, float r24, android.graphics.Canvas r25, ir.eitaa.ui.Components.FragmentContextView r26, float r27) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FragmentContextViewWavesDrawable.draw(float, float, float, float, android.graphics.Canvas, ir.eitaa.ui.Components.FragmentContextView, float):void");
    }

    private void checkColors() {
        int i = 0;
        while (true) {
            WeavingState[] weavingStateArr = this.states;
            if (i >= weavingStateArr.length) {
                return;
            }
            weavingStateArr[i].checkColor();
            i++;
        }
    }

    private void setState(int state, boolean animated) {
        WeavingState weavingState = this.currentState;
        if (weavingState == null || weavingState.currentState != state) {
            if (VoIPService.getSharedInstance() == null && this.currentState == null) {
                this.currentState = this.pausedState;
                return;
            }
            WeavingState weavingState2 = animated ? this.currentState : null;
            this.previousState = weavingState2;
            this.currentState = this.states[state];
            if (weavingState2 != null) {
                this.progressToState = 0.0f;
            } else {
                this.progressToState = 1.0f;
            }
        }
    }

    public void setAmplitude(float value) {
        this.animateToAmplitude = value;
        float f = this.amplitude;
        this.animateAmplitudeDiff = (value - f) / 250.0f;
        this.animateAmplitudeDiff2 = (value - f) / 120.0f;
    }

    public void addParent(View parent) {
        if (this.parents.contains(parent)) {
            return;
        }
        this.parents.add(parent);
    }

    public void removeParent(View parent) {
        this.parents.remove(parent);
        if (this.parents.isEmpty()) {
            this.pausedState = this.currentState;
            this.currentState = null;
            this.previousState = null;
        }
    }

    public void updateState(boolean z) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            int callState = sharedInstance.getCallState();
            if (!sharedInstance.isSwitchingStream() && (callState == 1 || callState == 2 || callState == 6 || callState == 5)) {
                setState(2, z);
                return;
            }
            ChatObject.Call call = sharedInstance.groupCall;
            if (call != null) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(sharedInstance.getSelfId());
                if (tLRPC$TL_groupCallParticipant != null && !tLRPC$TL_groupCallParticipant.can_self_unmute && tLRPC$TL_groupCallParticipant.muted && !ChatObject.canManageCalls(sharedInstance.getChat())) {
                    sharedInstance.setMicMute(true, false, false);
                    setState(3, z);
                    return;
                } else {
                    setState(sharedInstance.isMicMute() ? 1 : 0, z);
                    return;
                }
            }
            setState(sharedInstance.isMicMute() ? 1 : 0, z);
        }
    }

    public int getState() {
        WeavingState weavingState = this.currentState;
        if (weavingState != null) {
            return weavingState.currentState;
        }
        return 0;
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
        String greenKey1 = "voipgroup_topPanelGreen1";
        String greenKey2 = "voipgroup_topPanelGreen2";
        String blueKey1 = "voipgroup_topPanelBlue1";
        String blueKey2 = "voipgroup_topPanelBlue2";
        String mutedByAdmin = "voipgroup_mutedByAdminGradient";
        String mutedByAdmin2 = "voipgroup_mutedByAdminGradient2";
        String mutedByAdmin3 = "voipgroup_mutedByAdminGradient3";

        public WeavingState(int state) {
            this.currentState = state;
            createGradients();
        }

        private void createGradients() {
            int i = this.currentState;
            if (i == 0) {
                int color = Theme.getColor(this.greenKey1);
                this.color1 = color;
                int color2 = Theme.getColor(this.greenKey2);
                this.color2 = color2;
                this.shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{color, color2}, (float[]) null, Shader.TileMode.CLAMP);
                return;
            }
            if (i == 1) {
                int color3 = Theme.getColor(this.blueKey1);
                this.color1 = color3;
                int color4 = Theme.getColor(this.blueKey2);
                this.color2 = color4;
                this.shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{color3, color4}, (float[]) null, Shader.TileMode.CLAMP);
                return;
            }
            if (i == 3) {
                int color5 = Theme.getColor(this.mutedByAdmin);
                this.color1 = color5;
                int color6 = Theme.getColor(this.mutedByAdmin3);
                this.color3 = color6;
                int color7 = Theme.getColor(this.mutedByAdmin2);
                this.color2 = color7;
                this.shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{color5, color6, color7}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
            }
        }

        public void update(int height, int width, long dt, float amplitude) {
            if (this.currentState == 2) {
                return;
            }
            float f = this.duration;
            if (f == 0.0f || this.time >= f) {
                this.duration = Utilities.random.nextInt(700) + 500;
                this.time = 0.0f;
                if (this.targetX == -1.0f) {
                    int i = this.currentState;
                    if (i == 3) {
                        this.targetX = ((Utilities.random.nextInt(100) * 0.05f) / 100.0f) - 0.3f;
                        this.targetY = ((Utilities.random.nextInt(100) * 0.05f) / 100.0f) + 0.7f;
                    } else if (i == 0) {
                        this.targetX = ((Utilities.random.nextInt(100) * 0.2f) / 100.0f) - 0.3f;
                        this.targetY = ((Utilities.random.nextInt(100) * 0.3f) / 100.0f) + 0.7f;
                    } else {
                        this.targetX = ((Utilities.random.nextInt(100) / 100.0f) * 0.2f) + 1.1f;
                        this.targetY = (Utilities.random.nextInt(100) * 4.0f) / 100.0f;
                    }
                }
                this.startX = this.targetX;
                this.startY = this.targetY;
                int i2 = this.currentState;
                if (i2 == 3) {
                    this.targetX = ((Utilities.random.nextInt(100) * 0.05f) / 100.0f) - 0.3f;
                    this.targetY = ((Utilities.random.nextInt(100) * 0.05f) / 100.0f) + 0.7f;
                } else if (i2 == 0) {
                    this.targetX = ((Utilities.random.nextInt(100) * 0.2f) / 100.0f) - 0.3f;
                    this.targetY = ((Utilities.random.nextInt(100) * 0.3f) / 100.0f) + 0.7f;
                } else {
                    this.targetX = ((Utilities.random.nextInt(100) / 100.0f) * 0.2f) + 1.1f;
                    this.targetY = (Utilities.random.nextInt(100) * 4.0f) / 100.0f;
                }
            }
            float f2 = dt;
            float f3 = this.time + ((BlobDrawable.GRADIENT_SPEED_MIN + 0.5f) * f2) + (f2 * BlobDrawable.GRADIENT_SPEED_MAX * 2.0f * amplitude);
            this.time = f3;
            float f4 = this.duration;
            if (f3 > f4) {
                this.time = f4;
            }
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.time / f4);
            float f5 = width;
            float f6 = this.startX;
            float f7 = ((f6 + ((this.targetX - f6) * interpolation)) * f5) - 200.0f;
            float f8 = this.startY;
            float f9 = (height * (f8 + ((this.targetY - f8) * interpolation))) - 200.0f;
            float f10 = f5 / 400.0f;
            int i3 = this.currentState;
            float f11 = f10 * ((i3 == 0 || i3 == 3) ? 3.0f : 1.5f);
            this.matrix.reset();
            this.matrix.postTranslate(f7, f9);
            this.matrix.postScale(f11, f11, f7 + 200.0f, f9 + 200.0f);
            this.shader.setLocalMatrix(this.matrix);
        }

        public void checkColor() {
            int i = this.currentState;
            if (i == 0) {
                if (this.color1 == Theme.getColor(this.greenKey1) && this.color2 == Theme.getColor(this.greenKey2)) {
                    return;
                }
                createGradients();
                return;
            }
            if (i == 1) {
                if (this.color1 == Theme.getColor(this.blueKey1) && this.color2 == Theme.getColor(this.blueKey2)) {
                    return;
                }
                createGradients();
                return;
            }
            if (i == 3) {
                if (this.color1 == Theme.getColor(this.mutedByAdmin) && this.color2 == Theme.getColor(this.mutedByAdmin2)) {
                    return;
                }
                createGradients();
            }
        }

        public void setToPaint(Paint paint) {
            int i = this.currentState;
            if (i == 0 || i == 1 || i == 3) {
                paint.setShader(this.shader);
            } else {
                paint.setShader(null);
                paint.setColor(Theme.getColor("voipgroup_topPanelGray"));
            }
        }
    }
}
