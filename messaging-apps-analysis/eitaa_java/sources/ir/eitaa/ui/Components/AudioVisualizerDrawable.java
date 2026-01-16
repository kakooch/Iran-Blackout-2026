package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.Random;

/* loaded from: classes3.dex */
public class AudioVisualizerDrawable {
    private float idleScale;
    private boolean idleScaleInc;
    private int lastAmplitudeCount;
    private int lastAmplitudePointer;
    private final Paint p1;
    private View parentView;
    float rotation;
    private final int[] tmpWaveform = new int[3];
    private final float[] animateTo = new float[8];
    private final float[] current = new float[8];
    private final float[] dt = new float[8];
    private final Random random = new Random();
    public float IDLE_RADIUS = AndroidUtilities.dp(6.0f) * 0.33f;
    public float WAVE_RADIUS = AndroidUtilities.dp(12.0f) * 0.36f;
    public float ANIMATION_DURATION = 120.0f;
    public int ALPHA = 61;
    final int MAX_SAMPLE_SUM = 6;
    private float[] lastAmplitude = new float[6];
    private final CircleBezierDrawable[] drawables = new CircleBezierDrawable[2];

    public AudioVisualizerDrawable() {
        for (int i = 0; i < 2; i++) {
            CircleBezierDrawable[] circleBezierDrawableArr = this.drawables;
            CircleBezierDrawable circleBezierDrawable = new CircleBezierDrawable(6);
            circleBezierDrawableArr[i] = circleBezierDrawable;
            circleBezierDrawable.idleStateDiff = 0.0f;
            circleBezierDrawable.radius = AndroidUtilities.dp(24.0f);
            circleBezierDrawable.radiusDiff = 0.0f;
            circleBezierDrawable.randomK = 1.0f;
        }
        this.p1 = new Paint(1);
    }

    public void setWaveform(boolean playing, boolean animate, float[] waveform) {
        int i = 0;
        if (!playing && !animate) {
            while (i < 8) {
                float[] fArr = this.animateTo;
                this.current[i] = 0.0f;
                fArr[i] = 0.0f;
                i++;
            }
            return;
        }
        boolean z = waveform != null && waveform[6] == 0.0f;
        float f = waveform == null ? 0.0f : waveform[6];
        if (waveform != null && f > 0.4d) {
            float[] fArr2 = this.lastAmplitude;
            int i2 = this.lastAmplitudePointer;
            fArr2[i2] = f;
            int i3 = i2 + 1;
            this.lastAmplitudePointer = i3;
            if (i3 > 5) {
                this.lastAmplitudePointer = 0;
            }
            this.lastAmplitudeCount++;
        } else {
            this.lastAmplitudeCount = 0;
        }
        if (z) {
            for (int i4 = 0; i4 < 6; i4++) {
                waveform[i4] = (this.random.nextInt() % 500) / 1000.0f;
            }
        }
        float f2 = this.ANIMATION_DURATION;
        if (z) {
            f2 *= 2.0f;
        }
        if (this.lastAmplitudeCount > 6) {
            float f3 = 0.0f;
            for (int i5 = 0; i5 < 6; i5++) {
                f3 += this.lastAmplitude[i5];
            }
            float f4 = f3 / 6.0f;
            if (f4 > 0.52f) {
                f2 -= this.ANIMATION_DURATION * (f4 - 0.4f);
            }
        }
        while (i < 7) {
            if (waveform == null) {
                this.animateTo[i] = 0.0f;
            } else {
                this.animateTo[i] = waveform[i];
            }
            if (this.parentView == null) {
                this.current[i] = this.animateTo[i];
            } else if (i == 6) {
                this.dt[i] = (this.animateTo[i] - this.current[i]) / (this.ANIMATION_DURATION + 80.0f);
            } else {
                this.dt[i] = (this.animateTo[i] - this.current[i]) / f2;
            }
            i++;
        }
        float[] fArr3 = this.animateTo;
        fArr3[7] = playing ? 1.0f : 0.0f;
        this.dt[7] = (fArr3[7] - this.current[7]) / 120.0f;
    }

    public void draw(Canvas canvas, float cx, float cy, boolean outOwner) {
        if (outOwner) {
            this.p1.setColor(Theme.getColor("chat_outLoader"));
            this.p1.setAlpha(this.ALPHA);
        } else {
            this.p1.setColor(Theme.getColor("chat_inLoader"));
            this.p1.setAlpha(this.ALPHA);
        }
        draw(canvas, cx, cy);
    }

    public void draw(Canvas canvas, float cx, float cy) {
        for (int i = 0; i < 8; i++) {
            float[] fArr = this.animateTo;
            float f = fArr[i];
            float[] fArr2 = this.current;
            if (f != fArr2[i]) {
                float f2 = fArr2[i];
                float[] fArr3 = this.dt;
                fArr2[i] = f2 + (fArr3[i] * 16.0f);
                if ((fArr3[i] > 0.0f && fArr2[i] > fArr[i]) || (fArr3[i] < 0.0f && fArr2[i] < fArr[i])) {
                    fArr2[i] = fArr[i];
                }
                this.parentView.invalidate();
            }
        }
        if (this.idleScaleInc) {
            float f3 = this.idleScale + 0.02f;
            this.idleScale = f3;
            if (f3 > 1.0f) {
                this.idleScaleInc = false;
                this.idleScale = 1.0f;
            }
        } else {
            float f4 = this.idleScale - 0.02f;
            this.idleScale = f4;
            if (f4 < 0.0f) {
                this.idleScaleInc = true;
                this.idleScale = 0.0f;
            }
        }
        float[] fArr4 = this.current;
        float f5 = fArr4[7];
        float f6 = fArr4[6] * fArr4[0];
        if (f5 == 0.0f && f6 == 0.0f) {
            return;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            this.tmpWaveform[i2] = (int) (this.current[i2] * this.WAVE_RADIUS);
        }
        this.drawables[0].setAdditionals(this.tmpWaveform);
        for (int i3 = 0; i3 < 3; i3++) {
            this.tmpWaveform[i3] = (int) (this.current[i3 + 3] * this.WAVE_RADIUS);
        }
        this.drawables[1].setAdditionals(this.tmpWaveform);
        float fDp = AndroidUtilities.dp(22.0f) + (AndroidUtilities.dp(4.0f) * f6) + (this.IDLE_RADIUS * f5);
        if (fDp > AndroidUtilities.dp(26.0f)) {
            fDp = AndroidUtilities.dp(26.0f);
        }
        CircleBezierDrawable[] circleBezierDrawableArr = this.drawables;
        CircleBezierDrawable circleBezierDrawable = circleBezierDrawableArr[0];
        circleBezierDrawableArr[1].radius = fDp;
        circleBezierDrawable.radius = fDp;
        canvas.save();
        double d = this.rotation;
        Double.isNaN(d);
        float f7 = (float) (d + 0.6d);
        this.rotation = f7;
        canvas.rotate(f7, cx, cy);
        canvas.save();
        float f8 = (this.idleScale * 0.04f) + 1.0f;
        canvas.scale(f8, f8, cx, cy);
        this.drawables[0].draw(cx, cy, canvas, this.p1);
        canvas.restore();
        canvas.rotate(60.0f, cx, cy);
        float f9 = ((1.0f - this.idleScale) * 0.04f) + 1.0f;
        canvas.scale(f9, f9, cx, cy);
        this.drawables[1].draw(cx, cy, canvas, this.p1);
        canvas.restore();
    }

    public void setParentView(View parentView) {
        this.parentView = parentView;
    }

    public View getParentView() {
        return this.parentView;
    }
}
