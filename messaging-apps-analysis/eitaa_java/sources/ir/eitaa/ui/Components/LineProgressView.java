package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class LineProgressView extends View {
    private static DecelerateInterpolator decelerateInterpolator;
    private static Paint progressPaint;
    private float animatedAlphaValue;
    private float animatedProgressValue;
    private float animationProgressStart;
    private int backColor;
    private float currentProgress;
    private long currentProgressTime;
    private long lastUpdateTime;
    private int progressColor;
    private RectF rect;

    public LineProgressView(Context context) {
        super(context);
        this.animatedAlphaValue = 1.0f;
        this.rect = new RectF();
        if (decelerateInterpolator == null) {
            decelerateInterpolator = new DecelerateInterpolator();
            Paint paint = new Paint(1);
            progressPaint = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            progressPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
    }

    private void updateAnimation() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        float f = this.animatedProgressValue;
        if (f != 1.0f) {
            float f2 = this.currentProgress;
            if (f != f2) {
                float f3 = this.animationProgressStart;
                float f4 = f2 - f3;
                if (f4 > 0.0f) {
                    long j2 = this.currentProgressTime + j;
                    this.currentProgressTime = j2;
                    if (j2 >= 300) {
                        this.animatedProgressValue = f2;
                        this.animationProgressStart = f2;
                        this.currentProgressTime = 0L;
                    } else {
                        this.animatedProgressValue = f3 + (f4 * decelerateInterpolator.getInterpolation(j2 / 300.0f));
                    }
                }
                invalidate();
            }
        }
        float f5 = this.animatedProgressValue;
        if (f5 < 1.0f || f5 != 1.0f) {
            return;
        }
        float f6 = this.animatedAlphaValue;
        if (f6 != 0.0f) {
            float f7 = f6 - (j / 200.0f);
            this.animatedAlphaValue = f7;
            if (f7 <= 0.0f) {
                this.animatedAlphaValue = 0.0f;
            }
            invalidate();
        }
    }

    public void setProgressColor(int color) {
        this.progressColor = color;
    }

    public void setBackColor(int color) {
        this.backColor = color;
    }

    public void setProgress(float value, boolean animated) {
        if (!animated) {
            this.animatedProgressValue = value;
            this.animationProgressStart = value;
        } else {
            this.animationProgressStart = this.animatedProgressValue;
        }
        if (value != 1.0f) {
            this.animatedAlphaValue = 1.0f;
        }
        this.currentProgress = value;
        this.currentProgressTime = 0L;
        this.lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    public float getCurrentProgress() {
        return this.currentProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.backColor;
        if (i != 0 && this.animatedProgressValue != 1.0f) {
            progressPaint.setColor(i);
            progressPaint.setAlpha((int) (this.animatedAlphaValue * 255.0f));
            getWidth();
            this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
            canvas.drawRoundRect(this.rect, getHeight() / 2, getHeight() / 2, progressPaint);
        }
        progressPaint.setColor(this.progressColor);
        progressPaint.setAlpha((int) (this.animatedAlphaValue * 255.0f));
        this.rect.set(0.0f, 0.0f, getWidth() * this.animatedProgressValue, getHeight());
        canvas.drawRoundRect(this.rect, getHeight() / 2, getHeight() / 2, progressPaint);
        updateAnimation();
    }
}
