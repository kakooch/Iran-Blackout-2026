package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ContextProgressViewWithDelay extends View {
    private RectF cicleRect;
    private int currentColorType;
    private Paint innerPaint;
    private long lastTimeVisible;
    private long lastUpdateTime;
    private Paint outerPaint;
    private int radOffset;
    private int sweepAngle;

    public ContextProgressViewWithDelay(Context context, int i) {
        super(context);
        this.innerPaint = new Paint(1);
        this.outerPaint = new Paint(1);
        this.cicleRect = new RectF();
        this.radOffset = 0;
        this.sweepAngle = 90;
        this.lastTimeVisible = 0L;
        this.innerPaint.setStyle(Paint.Style.STROKE);
        this.innerPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.outerPaint.setStyle(Paint.Style.STROKE);
        this.outerPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.outerPaint.setStrokeCap(Paint.Cap.ROUND);
        this.currentColorType = i;
        updateColors();
    }

    public void updateColors() {
        int i = this.currentColorType;
        if (i == 0) {
            this.innerPaint.setColor(-4202506);
            this.outerPaint.setColor(-13920542);
        } else if (i == 1) {
            this.innerPaint.setColor(-14606047);
            this.outerPaint.setColor(-657931);
            this.sweepAngle = 90;
            this.outerPaint.setStrokeWidth(AndroidUtilities.dp(3.0f));
        } else if (i == 2) {
            this.innerPaint.setColor(-5000269);
            this.outerPaint.setColor(-1);
        } else if (i == 3) {
            this.innerPaint.setColor(2171169);
            this.outerPaint.setColor(-657931);
            this.sweepAngle = 270;
        }
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        this.lastUpdateTime = System.currentTimeMillis();
        if (i == 0 && visibility != 0) {
            this.lastTimeVisible = System.currentTimeMillis();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (getVisibility() != 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastTimeVisible;
        if (j > 0 && jCurrentTimeMillis - j < 300) {
            invalidate();
            return;
        }
        this.lastTimeVisible = 0L;
        long j2 = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        this.radOffset = (int) (this.radOffset + ((j2 * 360) / 1000.0f));
        this.cicleRect.set((getMeasuredWidth() / 2) - AndroidUtilities.dp(9.0f), (getMeasuredHeight() / 2) - AndroidUtilities.dp(9.0f), r0 + AndroidUtilities.dp(18.0f), r2 + AndroidUtilities.dp(18.0f));
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, AndroidUtilities.dp(9.0f), this.innerPaint);
        canvas.drawArc(this.cicleRect, this.radOffset - 90, this.sweepAngle, false, this.outerPaint);
        invalidate();
    }
}
