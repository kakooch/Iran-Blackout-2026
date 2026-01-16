package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoLoadingCell extends FrameLayout {
    private boolean matchParent;
    private ProgressView progressBar;

    public RubinoLoadingCell(Context context, boolean z) {
        super(context);
        this.matchParent = z;
        ProgressView progressView = new ProgressView(context);
        this.progressBar = progressView;
        addView(progressView, LayoutHelper.createFrame(-2, -2.0f, 17, 16.0f, 16.0f, 16.0f, 16.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.matchParent) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        }
    }

    public static class ProgressView extends FrameLayout {
        private boolean animating;
        private float arcTime;
        private RectF circleRect;
        int[] colors1;
        private long currentProgressTime;
        private LinearInterpolator interpolator;
        float[] positions1;
        private final Paint progressPaint;
        private int size;
        private float startAngle;
        private long startTime;
        private final int strokeWidth;

        public ProgressView(Context context) {
            super(context);
            int iDp = AndroidUtilities.dp(2.0f);
            this.strokeWidth = iDp;
            this.animating = false;
            this.arcTime = 800.0f;
            this.interpolator = new LinearInterpolator();
            this.colors1 = new int[]{-1, -328966, -2039584, -5263441};
            this.positions1 = new float[]{0.0f, 0.3f, 0.5f, 1.0f};
            this.circleRect = new RectF();
            setWillNotDraw(false);
            Paint paint = new Paint(1);
            this.progressPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(iDp);
            paint.setColor(-1);
            this.animating = true;
            this.size = AndroidUtilities.dp(48.0f);
            this.startTime = System.currentTimeMillis();
        }

        public void setSize(int i) {
            this.size = i;
            requestLayout();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(this.size, 1073741824));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                SweepGradient sweepGradient = new SweepGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.colors1, this.positions1);
                Matrix matrix = new Matrix();
                matrix.setRotate(-95.0f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
                sweepGradient.setLocalMatrix(matrix);
                this.progressPaint.setShader(sweepGradient);
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int measuredWidth = (getMeasuredWidth() - this.size) / 2;
            int measuredHeight = (getMeasuredHeight() - this.size) / 2;
            RectF rectF = this.circleRect;
            int i = this.strokeWidth;
            rectF.set(measuredWidth + i, measuredHeight + i, (measuredWidth + r2) - i, (measuredHeight + r2) - i);
            canvas.save();
            canvas.rotate(this.startAngle, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
            RectF rectF2 = this.circleRect;
            float f = this.startAngle;
            canvas.drawArc(rectF2, -f, f + 360.0f, false, this.progressPaint);
            canvas.restore();
            if (this.animating) {
                updateAnimation();
            }
        }

        private void updateAnimation() {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.startTime;
            this.currentProgressTime = jCurrentTimeMillis;
            this.startAngle = this.interpolator.getInterpolation(jCurrentTimeMillis / this.arcTime) * 360.0f;
            invalidate();
        }
    }
}
