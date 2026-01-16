package ir.appp.rghapp.components.sshCrop;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.MediaController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class SSHCropAreaView extends View {
    private final RectF actualRect;
    private Animator animator;
    private final RectF bottomEdge;
    private final RectF bottomLeftCorner;
    private float bottomPadding;
    private final RectF bottomRightCorner;
    Paint dimPaint;
    Paint framePaint;
    Paint handlePaint;
    AccelerateDecelerateInterpolator interpolator;
    private final RectF leftEdge;
    Paint linePaint;
    private float lockAspectRatio;
    private final RectF rightEdge;
    Paint shadowPaint;
    private final float sidePadding;
    private final RectF topEdge;
    private final RectF topLeftCorner;
    private final RectF topRightCorner;

    public void setDimVisibility(boolean z) {
    }

    public void setFrameVisibility(boolean z) {
    }

    public SSHCropAreaView(Context context) {
        super(context);
        this.topLeftCorner = new RectF();
        this.topRightCorner = new RectF();
        this.bottomLeftCorner = new RectF();
        this.bottomRightCorner = new RectF();
        this.topEdge = new RectF();
        this.leftEdge = new RectF();
        this.bottomEdge = new RectF();
        this.rightEdge = new RectF();
        this.actualRect = new RectF();
        new RectF();
        this.interpolator = new AccelerateDecelerateInterpolator();
        this.sidePadding = AndroidUtilities.dp(0.0f);
        AndroidUtilities.dp(32.0f);
        Paint paint = new Paint();
        this.dimPaint = paint;
        paint.setColor(-872415232);
        Paint paint2 = new Paint();
        this.shadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.shadowPaint.setColor(436207616);
        this.shadowPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        Paint paint3 = new Paint();
        this.linePaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.linePaint.setColor(-1);
        this.linePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        Paint paint4 = new Paint();
        this.handlePaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.handlePaint.setColor(-1);
        Paint paint5 = new Paint();
        this.framePaint = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.framePaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
    }

    public void setBottomPadding(float f) {
        this.bottomPadding = f;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public void setBitmap(Bitmap bitmap, boolean z, boolean z2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (z) {
            bitmap.getHeight();
            bitmap.getWidth();
        } else {
            bitmap.getWidth();
            bitmap.getHeight();
        }
        if (!z2) {
            this.lockAspectRatio = 1.0f;
        }
        setActualRect(new RectF(MediaController.getInstance().getAddPostCropArea()));
    }

    public void setActualRect(float f) {
        calculateRect(this.actualRect, f);
        updateTouchAreas();
        invalidate();
    }

    public void setActualRect(RectF rectF) {
        this.actualRect.set(rectF);
        updateTouchAreas();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.actualRect.width() != this.actualRect.height()) {
            if (this.actualRect.width() > this.actualRect.height()) {
                RectF rectF = this.actualRect;
                canvas.drawRect(0.0f, 0.0f, rectF.right, rectF.top, this.framePaint);
                RectF rectF2 = this.actualRect;
                canvas.drawRect(0.0f, rectF2.bottom, rectF2.right, getHeight(), this.framePaint);
                return;
            }
            RectF rectF3 = this.actualRect;
            canvas.drawRect(0.0f, 0.0f, rectF3.left, rectF3.bottom, this.framePaint);
            canvas.drawRect(this.actualRect.right, 0.0f, getWidth(), this.actualRect.bottom, this.framePaint);
        }
    }

    private void updateTouchAreas() {
        int iDp = AndroidUtilities.dp(16.0f);
        RectF rectF = this.topLeftCorner;
        RectF rectF2 = this.actualRect;
        float f = rectF2.left;
        float f2 = iDp;
        float f3 = rectF2.top;
        rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
        RectF rectF3 = this.topRightCorner;
        RectF rectF4 = this.actualRect;
        float f4 = rectF4.right;
        float f5 = rectF4.top;
        rectF3.set(f4 - f2, f5 - f2, f4 + f2, f5 + f2);
        RectF rectF5 = this.bottomLeftCorner;
        RectF rectF6 = this.actualRect;
        float f6 = rectF6.left;
        float f7 = rectF6.bottom;
        rectF5.set(f6 - f2, f7 - f2, f6 + f2, f7 + f2);
        RectF rectF7 = this.bottomRightCorner;
        RectF rectF8 = this.actualRect;
        float f8 = rectF8.right;
        float f9 = rectF8.bottom;
        rectF7.set(f8 - f2, f9 - f2, f8 + f2, f9 + f2);
        RectF rectF9 = this.topEdge;
        RectF rectF10 = this.actualRect;
        float f10 = rectF10.left + f2;
        float f11 = rectF10.top;
        rectF9.set(f10, f11 - f2, rectF10.right - f2, f11 + f2);
        RectF rectF11 = this.leftEdge;
        RectF rectF12 = this.actualRect;
        float f12 = rectF12.left;
        rectF11.set(f12 - f2, rectF12.top + f2, f12 + f2, rectF12.bottom - f2);
        RectF rectF13 = this.rightEdge;
        RectF rectF14 = this.actualRect;
        float f13 = rectF14.right;
        rectF13.set(f13 - f2, rectF14.top + f2, f13 + f2, rectF14.bottom - f2);
        RectF rectF15 = this.bottomEdge;
        RectF rectF16 = this.actualRect;
        float f14 = rectF16.left + f2;
        float f15 = rectF16.bottom;
        rectF15.set(f14, f15 - f2, rectF16.right - f2, f15 + f2);
    }

    public float getLockAspectRatio() {
        return this.lockAspectRatio;
    }

    public void setLockedAspectRatio(float f) {
        this.lockAspectRatio = f;
    }

    public float getAspectRatio() {
        RectF rectF = this.actualRect;
        return (rectF.right - rectF.left) / (rectF.bottom - rectF.top);
    }

    public void resetAnimator() {
        Animator animator = this.animator;
        if (animator != null) {
            animator.cancel();
            this.animator = null;
        }
    }

    public float getCropLeft() {
        return this.actualRect.left;
    }

    private void setCropLeft(float f) {
        this.actualRect.left = f;
        invalidate();
    }

    public float getCropTop() {
        return this.actualRect.top;
    }

    private void setCropTop(float f) {
        this.actualRect.top = f;
        invalidate();
    }

    public float getCropRight() {
        return this.actualRect.right;
    }

    private void setCropRight(float f) {
        this.actualRect.right = f;
        invalidate();
    }

    public float getCropBottom() {
        return this.actualRect.bottom;
    }

    private void setCropBottom(float f) {
        this.actualRect.bottom = f;
        invalidate();
    }

    public float getCropCenterX() {
        RectF rectF = this.actualRect;
        float f = rectF.left;
        return f + ((rectF.right - f) / 2.0f);
    }

    public float getCropCenterY() {
        RectF rectF = this.actualRect;
        float f = rectF.top;
        return f + ((rectF.bottom - f) / 2.0f);
    }

    public float getCropWidth() {
        RectF rectF = this.actualRect;
        return rectF.right - rectF.left;
    }

    public float getCropHeight() {
        RectF rectF = this.actualRect;
        return rectF.bottom - rectF.top;
    }

    public RectF getTargetRectToFill() {
        RectF rectF = new RectF();
        calculateRect(rectF, getAspectRatio());
        return rectF;
    }

    public void calculateRect(RectF rectF, float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6 = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
        float measuredHeight = (getMeasuredHeight() - this.bottomPadding) - f6;
        float measuredWidth = getMeasuredWidth() / measuredHeight;
        float fMin = Math.min(getMeasuredWidth(), measuredHeight) - (this.sidePadding * 2.0f);
        float measuredWidth2 = getMeasuredWidth();
        float f7 = this.sidePadding;
        float f8 = measuredWidth2 - (f7 * 2.0f);
        float f9 = measuredHeight - (f7 * 2.0f);
        float measuredWidth3 = getMeasuredWidth() / 2.0f;
        float f10 = f6 + (measuredHeight / 2.0f);
        if (Math.abs(1.0f - f) < 1.0E-4d) {
            float f11 = fMin / 2.0f;
            f4 = measuredWidth3 - f11;
            f5 = f10 - f11;
            f2 = measuredWidth3 + f11;
            f3 = f10 + f11;
        } else if (f > measuredWidth) {
            float f12 = f8 / 2.0f;
            float f13 = measuredWidth3 - f12;
            float f14 = (f8 / f) / 2.0f;
            float f15 = f10 - f14;
            f2 = measuredWidth3 + f12;
            f3 = f10 + f14;
            f5 = f15;
            f4 = f13;
        } else {
            float f16 = (f * f9) / 2.0f;
            float f17 = measuredWidth3 - f16;
            float f18 = f9 / 2.0f;
            float f19 = f10 - f18;
            f2 = measuredWidth3 + f16;
            f3 = f10 + f18;
            f4 = f17;
            f5 = f19;
        }
        rectF.set(f4, 0.0f, f2, f3 - f5);
    }

    public void getCropRect(RectF rectF) {
        rectF.set(this.actualRect);
    }
}
