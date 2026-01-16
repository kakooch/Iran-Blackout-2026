package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class InfiniteProgress {
    private RectF cicleRect = new RectF();
    private float currentCircleLength;
    private float currentProgressTime;
    private long lastUpdateTime;
    private int progressColor;
    private Paint progressPaint;
    private float radOffset;
    private int radius;
    private boolean risingCircleLength;

    public InfiniteProgress(int rad) {
        this.radius = rad;
        Paint paint = new Paint(1);
        this.progressPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setAlpha(float alpha) {
        this.progressPaint.setAlpha((int) (alpha * Color.alpha(this.progressColor)));
    }

    public void setColor(int color) {
        this.progressColor = color;
        this.progressPaint.setColor(color);
    }

    private void updateAnimation() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        if (j > 17) {
            j = 17;
        }
        this.lastUpdateTime = jCurrentTimeMillis;
        float f = this.radOffset + ((360 * j) / 2000.0f);
        this.radOffset = f;
        this.radOffset = f - (((int) (f / 360.0f)) * 360);
        float f2 = this.currentProgressTime + j;
        this.currentProgressTime = f2;
        if (f2 >= 500.0f) {
            this.currentProgressTime = 500.0f;
        }
        if (this.risingCircleLength) {
            this.currentCircleLength = (AndroidUtilities.accelerateInterpolator.getInterpolation(this.currentProgressTime / 500.0f) * 266.0f) + 4.0f;
        } else {
            this.currentCircleLength = 4.0f - ((1.0f - AndroidUtilities.decelerateInterpolator.getInterpolation(this.currentProgressTime / 500.0f)) * 270.0f);
        }
        if (this.currentProgressTime == 500.0f) {
            boolean z = this.risingCircleLength;
            if (z) {
                this.radOffset += 270.0f;
                this.currentCircleLength = -266.0f;
            }
            this.risingCircleLength = !z;
            this.currentProgressTime = 0.0f;
        }
    }

    public void draw(Canvas canvas, float cx, float cy, float scale) {
        RectF rectF = this.cicleRect;
        int i = this.radius;
        rectF.set(cx - (i * scale), cy - (i * scale), cx + (i * scale), cy + (i * scale));
        this.progressPaint.setStrokeWidth(AndroidUtilities.dp(2.0f) * scale);
        canvas.drawArc(this.cicleRect, this.radOffset, this.currentCircleLength, false, this.progressPaint);
        updateAnimation();
    }
}
