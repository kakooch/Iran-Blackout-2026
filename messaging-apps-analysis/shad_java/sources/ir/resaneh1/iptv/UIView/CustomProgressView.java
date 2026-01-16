package ir.resaneh1.iptv.UIView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class CustomProgressView extends View {
    private boolean animating;
    private RectF circleRect;
    private float currentCircleLength;
    private float currentProgressTime;
    private float distanceArcLength;
    private float initLength;
    private LinearInterpolator interpolator;
    private int progressColor;
    private int progressColor2;
    private Paint progressPaint;
    private boolean risingCircleLength;
    private float risingTime;
    private int size;
    private long startTime;
    private float targetLength;

    public CustomProgressView(Context context) {
        super(context);
        this.risingCircleLength = false;
        this.animating = false;
        this.circleRect = new RectF();
        this.distanceArcLength = 360.0f;
        this.risingTime = 5000.0f;
        this.size = AndroidUtilities.dp(40.0f);
        this.progressColor = -1;
        this.interpolator = new LinearInterpolator();
        Paint paint = new Paint(1);
        this.progressPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.progressPaint.setStrokeWidth(AndroidUtilities.dp(4.0f));
        this.progressPaint.setColor(this.progressColor);
    }

    private void updateAnimation() {
        if (this.distanceArcLength < 0.0f) {
            this.distanceArcLength = 0.0f;
        }
        if (this.distanceArcLength > 360.0f) {
            this.distanceArcLength = 360.0f;
        }
        float fCurrentTimeMillis = System.currentTimeMillis() - this.startTime;
        this.currentProgressTime = fCurrentTimeMillis;
        float f = this.risingTime;
        if (fCurrentTimeMillis >= f) {
            this.currentProgressTime = f;
        }
        if (this.risingCircleLength) {
            this.currentCircleLength = this.initLength + (this.distanceArcLength * this.interpolator.getInterpolation(this.currentProgressTime / f));
        } else {
            this.currentCircleLength = this.initLength - (this.distanceArcLength * this.interpolator.getInterpolation(this.currentProgressTime / f));
        }
        if (this.currentProgressTime == this.risingTime) {
            this.currentCircleLength = this.targetLength;
            this.risingCircleLength = false;
            this.animating = false;
            this.currentProgressTime = 0.0f;
        }
        changeColorIfNeeded();
        invalidate();
    }

    private void changeColorIfNeeded() {
        if (this.currentCircleLength > 270.0f) {
            this.progressPaint.setColor(this.progressColor2);
        } else {
            this.progressPaint.setColor(this.progressColor);
        }
    }

    public void setSize(int i, int i2) {
        this.size = AndroidUtilities.dp(i);
        this.progressPaint.setStrokeWidth(AndroidUtilities.dp(i2));
        invalidate();
    }

    public void setProgressColor(int i, int i2) {
        this.progressColor = i;
        this.progressColor2 = i2;
        this.progressPaint.setColor(i);
    }

    private void startAnimation(float f) {
        this.startTime = System.currentTimeMillis();
        this.risingTime = f;
        updateAnimation();
    }

    private void startAnimation() {
        this.startTime = System.currentTimeMillis();
        updateAnimation();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.circleRect.set((getMeasuredWidth() - this.size) / 2, (getMeasuredHeight() - this.size) / 2, r0 + r2, r1 + r2);
        canvas.drawArc(this.circleRect, -90.0f, this.currentCircleLength, false, this.progressPaint);
        if (this.animating) {
            updateAnimation();
        }
    }

    public void setProgress(int i) {
        this.initLength = 0.0f;
        this.distanceArcLength = 360.0f;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        float f = (i * 360) / 100;
        this.currentCircleLength = f;
        this.targetLength = f;
        this.animating = false;
        changeColorIfNeeded();
        invalidate();
    }

    public void setProgressWithAnimation(int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        float f = (i * 360) / 100;
        this.targetLength = f;
        float f2 = this.currentCircleLength;
        this.initLength = f2;
        if (f > f2) {
            this.distanceArcLength = f - f2;
            this.risingCircleLength = true;
        } else {
            this.distanceArcLength = f2 - f;
            this.risingCircleLength = false;
        }
        this.animating = true;
        startAnimation(i2);
    }

    public void setProgressWithoutAnim(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        float f = (i * 360) / 100;
        this.targetLength = f;
        float f2 = this.currentCircleLength;
        this.initLength = f2;
        if (f > f2) {
            this.distanceArcLength = f - f2;
            this.risingCircleLength = true;
        } else {
            this.distanceArcLength = f2 - f;
            this.risingCircleLength = false;
        }
        this.animating = true;
        startAnimation();
    }
}
