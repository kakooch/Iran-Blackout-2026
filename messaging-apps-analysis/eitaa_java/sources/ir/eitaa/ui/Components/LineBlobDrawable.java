package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.Random;

/* loaded from: classes3.dex */
public class LineBlobDrawable {
    private final float N;
    public float maxRadius;
    public float minRadius;
    private float[] progress;
    private float[] radius;
    private float[] radiusNext;
    private float[] speed;
    public Path path = new Path();
    public Paint paint = new Paint(1);
    final Random random = new Random();

    public LineBlobDrawable(int n) {
        this.N = n;
        int i = n + 1;
        this.radius = new float[i];
        this.radiusNext = new float[i];
        this.progress = new float[i];
        this.speed = new float[i];
        for (int i2 = 0; i2 <= this.N; i2++) {
            generateBlob(this.radius, i2);
            generateBlob(this.radiusNext, i2);
            this.progress[i2] = 0.0f;
        }
    }

    private void generateBlob(float[] radius, int i) {
        float f = this.maxRadius;
        float f2 = this.minRadius;
        radius[i] = f2 + (Math.abs((this.random.nextInt() % 100.0f) / 100.0f) * (f - f2));
        float[] fArr = this.speed;
        double dAbs = Math.abs(this.random.nextInt() % 100.0f) / 100.0f;
        Double.isNaN(dAbs);
        fArr[i] = (float) ((dAbs * 0.003d) + 0.017d);
    }

    public void update(float amplitude, float speedScale) {
        for (int i = 0; i <= this.N; i++) {
            float[] fArr = this.progress;
            float f = fArr[i];
            float[] fArr2 = this.speed;
            fArr[i] = f + (fArr2[i] * BlobDrawable.MIN_SPEED) + (fArr2[i] * amplitude * BlobDrawable.MAX_SPEED * speedScale);
            if (fArr[i] >= 1.0f) {
                fArr[i] = 0.0f;
                float[] fArr3 = this.radius;
                float[] fArr4 = this.radiusNext;
                fArr3[i] = fArr4[i];
                generateBlob(fArr4, i);
            }
        }
    }

    public void draw(float left, float top, float right, float bottom, Canvas canvas, Paint paint, float pinnedTop, float progressToPinned) {
        this.path.reset();
        this.path.moveTo(right, bottom);
        this.path.lineTo(left, bottom);
        int i = 0;
        while (true) {
            float f = i;
            float f2 = this.N;
            if (f > f2) {
                canvas.drawPath(this.path, paint);
                return;
            }
            if (i == 0) {
                float f3 = this.progress[i];
                this.path.lineTo(left, ((top - ((this.radius[i] * (1.0f - f3)) + (this.radiusNext[i] * f3))) * progressToPinned) + (pinnedTop * (1.0f - progressToPinned)));
            } else {
                float[] fArr = this.progress;
                int i2 = i - 1;
                float f4 = fArr[i2];
                float[] fArr2 = this.radius;
                float f5 = fArr2[i2] * (1.0f - f4);
                float[] fArr3 = this.radiusNext;
                float f6 = f5 + (fArr3[i2] * f4);
                float f7 = fArr[i];
                float f8 = (fArr2[i] * (1.0f - f7)) + (fArr3[i] * f7);
                float f9 = right - left;
                float f10 = (f9 / f2) * i2;
                float f11 = (f9 / f2) * f;
                float f12 = f10 + ((f11 - f10) / 2.0f);
                float f13 = (1.0f - progressToPinned) * pinnedTop;
                float f14 = ((top - f8) * progressToPinned) + f13;
                this.path.cubicTo(f12, ((top - f6) * progressToPinned) + f13, f12, f14, f11, f14);
                if (f == this.N) {
                    this.path.lineTo(right, bottom);
                }
            }
            i++;
        }
    }
}
