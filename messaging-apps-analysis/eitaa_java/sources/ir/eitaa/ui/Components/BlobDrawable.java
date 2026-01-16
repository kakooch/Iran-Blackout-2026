package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.Random;

/* loaded from: classes3.dex */
public class BlobDrawable {
    public static float AMPLITUDE_SPEED = 0.33f;
    public static float FORM_BIG_MAX = 0.6f;
    public static float FORM_SMALL_MAX = 0.6f;
    public static float GLOBAL_SCALE = 1.0f;
    public static float GRADIENT_SPEED_MAX = 0.01f;
    public static float GRADIENT_SPEED_MIN = 0.5f;
    public static float LIGHT_GRADIENT_SIZE = 0.5f;
    public static float MAX_SPEED = 8.2f;
    public static float MIN_SPEED = 0.8f;
    public static float SCALE_BIG = 0.807f;
    public static float SCALE_BIG_MIN = 0.878f;
    public static float SCALE_SMALL = 0.704f;
    public static float SCALE_SMALL_MIN = 0.926f;
    private final float L;
    private final float N;
    public float amplitude;
    private float[] angle;
    private float[] angleNext;
    private float animateAmplitudeDiff;
    private float animateToAmplitude;
    public float maxRadius;
    public float minRadius;
    private float[] progress;
    private float[] radius;
    private float[] radiusNext;
    private float[] speed;
    private Path path = new Path();
    public Paint paint = new Paint(1);
    private float[] pointStart = new float[4];
    private float[] pointEnd = new float[4];
    final Random random = new Random();
    public float cubicBezierK = 1.0f;
    private final Matrix m = new Matrix();

    public BlobDrawable(int n) {
        float f = n;
        this.N = f;
        double d = f * 2.0f;
        Double.isNaN(d);
        this.L = (float) (Math.tan(3.141592653589793d / d) * 1.3333333333333333d);
        this.radius = new float[n];
        this.angle = new float[n];
        this.radiusNext = new float[n];
        this.angleNext = new float[n];
        this.progress = new float[n];
        this.speed = new float[n];
        for (int i = 0; i < this.N; i++) {
            generateBlob(this.radius, this.angle, i);
            generateBlob(this.radiusNext, this.angleNext, i);
            this.progress[i] = 0.0f;
        }
    }

    private void generateBlob(float[] radius, float[] angle, int i) {
        float f = (360.0f / this.N) * 0.05f;
        float f2 = this.maxRadius;
        float f3 = this.minRadius;
        radius[i] = f3 + (Math.abs((this.random.nextInt() % 100.0f) / 100.0f) * (f2 - f3));
        angle[i] = ((360.0f / this.N) * i) + (((this.random.nextInt() % 100.0f) / 100.0f) * f);
        float[] fArr = this.speed;
        double dAbs = Math.abs(this.random.nextInt() % 100.0f) / 100.0f;
        Double.isNaN(dAbs);
        fArr[i] = (float) ((dAbs * 0.003d) + 0.017d);
    }

    public void update(float amplitude, float speedScale) {
        for (int i = 0; i < this.N; i++) {
            float[] fArr = this.progress;
            float f = fArr[i];
            float[] fArr2 = this.speed;
            fArr[i] = f + (fArr2[i] * MIN_SPEED) + (fArr2[i] * amplitude * MAX_SPEED * speedScale);
            if (fArr[i] >= 1.0f) {
                fArr[i] = 0.0f;
                float[] fArr3 = this.radius;
                float[] fArr4 = this.radiusNext;
                fArr3[i] = fArr4[i];
                float[] fArr5 = this.angle;
                float[] fArr6 = this.angleNext;
                fArr5[i] = fArr6[i];
                generateBlob(fArr4, fArr6, i);
            }
        }
    }

    public void draw(float cX, float cY, Canvas canvas, Paint paint) {
        this.path.reset();
        int i = 0;
        while (true) {
            float f = i;
            float f2 = this.N;
            if (f < f2) {
                float[] fArr = this.progress;
                float f3 = fArr[i];
                int i2 = i + 1;
                int i3 = ((float) i2) < f2 ? i2 : 0;
                float f4 = fArr[i3];
                float[] fArr2 = this.radius;
                float f5 = 1.0f - f3;
                float f6 = fArr2[i] * f5;
                float[] fArr3 = this.radiusNext;
                float f7 = f6 + (fArr3[i] * f3);
                float f8 = 1.0f - f4;
                float f9 = (fArr2[i3] * f8) + (fArr3[i3] * f4);
                float[] fArr4 = this.angle;
                float f10 = fArr4[i] * f5;
                float[] fArr5 = this.angleNext;
                float f11 = f10 + (fArr5[i] * f3);
                float f12 = (fArr4[i3] * f8) + (fArr5[i3] * f4);
                float fMin = this.L * (Math.min(f7, f9) + ((Math.max(f7, f9) - Math.min(f7, f9)) / 2.0f)) * this.cubicBezierK;
                this.m.reset();
                this.m.setRotate(f11, cX, cY);
                float[] fArr6 = this.pointStart;
                fArr6[0] = cX;
                float f13 = cY - f7;
                fArr6[1] = f13;
                fArr6[2] = cX + fMin;
                fArr6[3] = f13;
                this.m.mapPoints(fArr6);
                float[] fArr7 = this.pointEnd;
                fArr7[0] = cX;
                float f14 = cY - f9;
                fArr7[1] = f14;
                fArr7[2] = cX - fMin;
                fArr7[3] = f14;
                this.m.reset();
                this.m.setRotate(f12, cX, cY);
                this.m.mapPoints(this.pointEnd);
                if (i == 0) {
                    Path path = this.path;
                    float[] fArr8 = this.pointStart;
                    path.moveTo(fArr8[0], fArr8[1]);
                }
                Path path2 = this.path;
                float[] fArr9 = this.pointStart;
                float f15 = fArr9[2];
                float f16 = fArr9[3];
                float[] fArr10 = this.pointEnd;
                path2.cubicTo(f15, f16, fArr10[2], fArr10[3], fArr10[0], fArr10[1]);
                i = i2;
            } else {
                canvas.save();
                canvas.drawPath(this.path, paint);
                canvas.restore();
                return;
            }
        }
    }

    public void generateBlob() {
        for (int i = 0; i < this.N; i++) {
            generateBlob(this.radius, this.angle, i);
            generateBlob(this.radiusNext, this.angleNext, i);
            this.progress[i] = 0.0f;
        }
    }

    public void setValue(float value, boolean isBig) {
        this.animateToAmplitude = value;
        if (isBig) {
            float f = this.amplitude;
            if (value > f) {
                this.animateAmplitudeDiff = (value - f) / 205.0f;
                return;
            } else {
                this.animateAmplitudeDiff = (value - f) / 275.0f;
                return;
            }
        }
        float f2 = this.amplitude;
        if (value > f2) {
            this.animateAmplitudeDiff = (value - f2) / 320.0f;
        } else {
            this.animateAmplitudeDiff = (value - f2) / 375.0f;
        }
    }

    public void updateAmplitude(long dt) {
        float f = this.animateToAmplitude;
        float f2 = this.amplitude;
        if (f != f2) {
            float f3 = this.animateAmplitudeDiff;
            float f4 = f2 + (dt * f3);
            this.amplitude = f4;
            if (f3 > 0.0f) {
                if (f4 > f) {
                    this.amplitude = f;
                }
            } else if (f4 < f) {
                this.amplitude = f;
            }
        }
    }
}
