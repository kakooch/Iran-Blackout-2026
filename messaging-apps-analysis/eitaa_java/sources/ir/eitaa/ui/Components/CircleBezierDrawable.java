package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.Random;

/* loaded from: classes3.dex */
public class CircleBezierDrawable {
    private final float L;
    private final int N;
    public float radius;
    public float radiusDiff;
    float[] randomAdditionals;
    public float randomK;
    private Path path = new Path();
    private float[] pointStart = new float[4];
    private float[] pointEnd = new float[4];
    private Matrix m = new Matrix();
    float globalRotate = 0.0f;
    public float idleStateDiff = 0.0f;
    public float cubicBezierK = 1.0f;
    final Random random = new Random();

    public CircleBezierDrawable(int n) {
        this.N = n;
        double d = n * 2;
        Double.isNaN(d);
        this.L = (float) (Math.tan(3.141592653589793d / d) * 1.3333333333333333d);
        this.randomAdditionals = new float[n];
        calculateRandomAdditionals();
    }

    public void calculateRandomAdditionals() {
        for (int i = 0; i < this.N; i++) {
            this.randomAdditionals[i] = (this.random.nextInt() % 100) / 100.0f;
        }
    }

    public void setAdditionals(int[] additionals) {
        for (int i = 0; i < this.N; i += 2) {
            float[] fArr = this.randomAdditionals;
            fArr[i] = additionals[i / 2];
            fArr[i + 1] = 0.0f;
        }
    }

    public void draw(float cX, float cY, Canvas canvas, Paint paint) {
        float f = this.radius;
        float f2 = this.idleStateDiff;
        float f3 = this.radiusDiff;
        float f4 = (f - (f2 / 2.0f)) - (f3 / 2.0f);
        float f5 = f + (f3 / 2.0f) + (f2 / 2.0f);
        float fMax = this.L * Math.max(f4, f5) * this.cubicBezierK;
        this.path.reset();
        int i = 0;
        while (i < this.N) {
            this.m.reset();
            this.m.setRotate((360.0f / this.N) * i, cX, cY);
            float f6 = i % 2 == 0 ? f4 : f5;
            float f7 = this.randomK;
            float[] fArr = this.randomAdditionals;
            float f8 = f6 + (fArr[i] * f7);
            float[] fArr2 = this.pointStart;
            fArr2[0] = cX;
            float f9 = cY - f8;
            fArr2[1] = f9;
            fArr2[2] = cX + fMax + (f7 * fArr[i] * this.L);
            fArr2[3] = f9;
            this.m.mapPoints(fArr2);
            int i2 = i + 1;
            int i3 = i2 >= this.N ? 0 : i2;
            float f10 = i3 % 2 == 0 ? f4 : f5;
            float f11 = this.randomK;
            float[] fArr3 = this.randomAdditionals;
            float f12 = f10 + (fArr3[i3] * f11);
            float[] fArr4 = this.pointEnd;
            fArr4[0] = cX;
            float f13 = cY - f12;
            fArr4[1] = f13;
            fArr4[2] = (cX - fMax) + (f11 * fArr3[i3] * this.L);
            fArr4[3] = f13;
            this.m.reset();
            this.m.setRotate((360.0f / this.N) * i3, cX, cY);
            this.m.mapPoints(this.pointEnd);
            if (i == 0) {
                Path path = this.path;
                float[] fArr5 = this.pointStart;
                path.moveTo(fArr5[0], fArr5[1]);
            }
            Path path2 = this.path;
            float[] fArr6 = this.pointStart;
            float f14 = fArr6[2];
            float f15 = fArr6[3];
            float[] fArr7 = this.pointEnd;
            path2.cubicTo(f14, f15, fArr7[2], fArr7[3], fArr7[0], fArr7[1]);
            i = i2;
        }
        canvas.save();
        canvas.rotate(this.globalRotate, cX, cY);
        canvas.drawPath(this.path, paint);
        canvas.restore();
    }
}
