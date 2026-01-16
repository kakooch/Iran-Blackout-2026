package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.view.View;
import android.view.animation.LinearInterpolator;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class PullToRefreshProgressView extends View {
    private float arcTime;
    private Paint baseCirclePaint;
    private RectF circleBound;
    private int circlePadding;
    private long currentLoopingTime;
    private State currentState;
    private Paint fillingCirclePaint;
    private float fillingSweepAngle;
    private LinearInterpolator loopingInterpolator;
    private Paint loopingPaint;
    private Shader loopingShader;
    private float loopingStartAngle;
    private long loopingStartTime;
    private float scale;
    private float scaleDuration;
    private long scaleStartTime;
    private boolean showScaleAnimation;

    private enum State {
        Filling,
        Looping
    }

    private float getInterpolator(float f) {
        return ((double) f) <= 0.5d ? f * 2.0f : 1.0f - (1.0f - ((1.0f - f) * 2.0f));
    }

    public PullToRefreshProgressView(Context context) {
        super(context);
        this.scale = 1.0f;
        this.scaleDuration = 200.0f;
        this.scaleStartTime = 0L;
        this.fillingSweepAngle = 270.0f;
        this.loopingStartAngle = 270.0f;
        this.loopingStartTime = 0L;
        this.arcTime = 800.0f;
        this.loopingInterpolator = new LinearInterpolator();
        init();
    }

    private void init() {
        setBackgroundColor(0);
        this.currentState = State.Filling;
        Paint paint = new Paint(1);
        this.baseCirclePaint = paint;
        paint.setColor(-1052689);
        this.baseCirclePaint.setStyle(Paint.Style.STROKE);
        this.baseCirclePaint.setStrokeWidth(AndroidUtilities.dp(1.25f));
        this.baseCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint(1);
        this.fillingCirclePaint = paint2;
        paint2.setColor(-3684409);
        this.fillingCirclePaint.setStyle(Paint.Style.STROKE);
        this.fillingCirclePaint.setStrokeWidth(AndroidUtilities.dp(1.25f));
        this.fillingCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        this.circleBound = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.circlePadding = AndroidUtilities.dp(1.0f);
        float fDp = AndroidUtilities.dp(16.5f);
        this.loopingShader = new SweepGradient(fDp, fDp, new int[]{-3684409, -1052689}, (float[]) null);
        Paint paint3 = new Paint(1);
        this.loopingPaint = paint3;
        paint3.setShader(this.loopingShader);
        this.loopingPaint.setStyle(Paint.Style.STROKE);
        this.loopingPaint.setStrokeWidth(AndroidUtilities.dp(1.25f));
        this.loopingPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void resetState() {
        this.currentState = State.Filling;
        this.fillingSweepAngle = 270.0f;
    }

    public void setProgress(float f) {
        if (f < 1.0f) {
            this.fillingSweepAngle = f * 360.0f;
        } else if (this.currentState == State.Filling) {
            this.showScaleAnimation = true;
            this.currentState = State.Looping;
            this.loopingStartTime = System.currentTimeMillis();
        }
        invalidate();
    }

    private void updateLoopingProgress() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.scaleStartTime == 0 && this.showScaleAnimation) {
            this.scaleStartTime = System.currentTimeMillis();
        }
        long j = jCurrentTimeMillis - this.loopingStartTime;
        this.currentLoopingTime = j;
        this.loopingStartAngle = this.loopingInterpolator.getInterpolation(j / this.arcTime) * 360.0f;
        if (this.showScaleAnimation) {
            float f = (jCurrentTimeMillis - this.scaleStartTime) / this.scaleDuration;
            if (f >= 1.0f) {
                this.scaleStartTime = 0L;
                this.scale = 1.0f;
                this.showScaleAnimation = false;
            } else {
                this.scale = (getInterpolator(f) * 0.2f) + 1.0f;
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        RectF rectF = this.circleBound;
        int i3 = this.circlePadding;
        rectF.left = i3;
        rectF.right = size - i3;
        rectF.top = i3;
        rectF.bottom = size - i3;
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = this.scale;
        canvas.scale(f, f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        canvas.drawArc(this.circleBound, 0.0f, 360.0f, false, this.baseCirclePaint);
        if (this.currentState == State.Filling) {
            canvas.drawArc(this.circleBound, 270.0f, this.fillingSweepAngle, false, this.fillingCirclePaint);
            return;
        }
        canvas.save();
        canvas.rotate(this.loopingStartAngle, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        RectF rectF = this.circleBound;
        float f2 = this.loopingStartAngle;
        canvas.drawArc(rectF, -f2, f2 + 360.0f, false, this.loopingPaint);
        canvas.restore();
        updateLoopingProgress();
    }
}
