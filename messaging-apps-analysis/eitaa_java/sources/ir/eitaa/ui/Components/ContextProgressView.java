package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ContextProgressView extends View {
    private RectF cicleRect;
    private int innerColor;
    private String innerKey;
    private Paint innerPaint;
    private long lastUpdateTime;
    private int outerColor;
    private String outerKey;
    private Paint outerPaint;
    private int radOffset;

    public ContextProgressView(Context context, int colorType) {
        super(context);
        this.innerPaint = new Paint(1);
        this.outerPaint = new Paint(1);
        this.cicleRect = new RectF();
        this.radOffset = 0;
        this.innerPaint.setStyle(Paint.Style.STROKE);
        this.innerPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.outerPaint.setStyle(Paint.Style.STROKE);
        this.outerPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.outerPaint.setStrokeCap(Paint.Cap.ROUND);
        if (colorType == 0) {
            this.innerKey = "contextProgressInner1";
            this.outerKey = "contextProgressOuter1";
        } else if (colorType == 1) {
            this.innerKey = "contextProgressInner2";
            this.outerKey = "contextProgressOuter2";
        } else if (colorType == 2) {
            this.innerKey = "contextProgressInner3";
            this.outerKey = "contextProgressOuter3";
        } else if (colorType == 3) {
            this.innerKey = "contextProgressInner4";
            this.outerKey = "contextProgressOuter4";
        }
        updateColors();
    }

    public void setColors(int innerColor, int outerColor) {
        this.innerKey = null;
        this.outerKey = null;
        this.innerColor = innerColor;
        this.outerColor = outerColor;
        updateColors();
    }

    public void updateColors() {
        String str = this.innerKey;
        if (str != null) {
            this.innerPaint.setColor(Theme.getColor(str));
        } else {
            this.innerPaint.setColor(this.innerColor);
        }
        String str2 = this.outerKey;
        if (str2 != null) {
            this.outerPaint.setColor(Theme.getColor(str2));
        } else {
            this.outerPaint.setColor(this.outerColor);
        }
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        this.lastUpdateTime = System.currentTimeMillis();
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
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        this.radOffset = (int) (this.radOffset + ((j * 360) / 1000.0f));
        this.cicleRect.set((getMeasuredWidth() / 2) - AndroidUtilities.dp(9.0f), (getMeasuredHeight() / 2) - AndroidUtilities.dp(9.0f), r0 + AndroidUtilities.dp(18.0f), r2 + AndroidUtilities.dp(18.0f));
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, AndroidUtilities.dp(9.0f), this.innerPaint);
        canvas.drawArc(this.cicleRect, this.radOffset - 90, 90.0f, false, this.outerPaint);
        invalidate();
    }
}
