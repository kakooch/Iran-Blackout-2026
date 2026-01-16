package ir.eitaa.ui.Components;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class GroupCreateCheckBox extends View {
    private static Paint eraser;
    private static Paint eraser2;
    private boolean attachedToWindow;
    private Paint backgroundInnerPaint;
    private String backgroundKey;
    private Paint backgroundPaint;
    private Canvas bitmapCanvas;
    private ObjectAnimator checkAnimator;
    private String checkKey;
    private Paint checkPaint;
    private float checkScale;
    private Bitmap drawBitmap;
    private String innerKey;
    private int innerRadDiff;
    private boolean isCheckAnimation;
    private boolean isChecked;
    private float progress;

    public GroupCreateCheckBox(Context context) {
        super(context);
        this.isCheckAnimation = true;
        this.checkScale = 1.0f;
        this.backgroundKey = "checkboxCheck";
        this.checkKey = "checkboxCheck";
        this.innerKey = "checkbox";
        if (eraser == null) {
            Paint paint = new Paint(1);
            eraser = paint;
            paint.setColor(0);
            eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Paint paint2 = new Paint(1);
            eraser2 = paint2;
            paint2.setColor(0);
            eraser2.setStyle(Paint.Style.STROKE);
            eraser2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        this.backgroundPaint = new Paint(1);
        this.backgroundInnerPaint = new Paint(1);
        Paint paint3 = new Paint(1);
        this.checkPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.innerRadDiff = AndroidUtilities.dp(2.0f);
        this.checkPaint.setStrokeWidth(AndroidUtilities.dp(1.5f));
        eraser2.setStrokeWidth(AndroidUtilities.dp(28.0f));
        this.drawBitmap = Bitmap.createBitmap(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), Bitmap.Config.ARGB_4444);
        this.bitmapCanvas = new Canvas(this.drawBitmap);
        updateColors();
    }

    public void setColorKeysOverrides(String check, String inner, String back) {
        this.checkKey = check;
        this.innerKey = inner;
        this.backgroundKey = back;
        updateColors();
    }

    public void updateColors() {
        this.backgroundInnerPaint.setColor(Theme.getColor(this.innerKey));
        this.backgroundPaint.setColor(Theme.getColor(this.backgroundKey));
        this.checkPaint.setColor(Theme.getColor(this.checkKey));
        invalidate();
    }

    @Keep
    public void setProgress(float value) {
        if (this.progress == value) {
            return;
        }
        this.progress = value;
        invalidate();
    }

    @Keep
    public float getProgress() {
        return this.progress;
    }

    public void setCheckScale(float value) {
        this.checkScale = value;
    }

    private void cancelCheckAnimator() {
        ObjectAnimator objectAnimator = this.checkAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void animateToCheckedState(boolean newCheckedState) {
        this.isCheckAnimation = newCheckedState;
        float[] fArr = new float[1];
        fArr[0] = newCheckedState ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", fArr);
        this.checkAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.checkAnimator.start();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateColors();
        this.attachedToWindow = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
    }

    public void setChecked(boolean checked, boolean animated) {
        if (checked == this.isChecked) {
            return;
        }
        this.isChecked = checked;
        if (this.attachedToWindow && animated) {
            animateToCheckedState(checked);
        } else {
            cancelCheckAnimator();
            setProgress(checked ? 1.0f : 0.0f);
        }
    }

    public void setInnerRadDiff(int value) {
        this.innerRadDiff = value;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float fDp;
        if (getVisibility() == 0 && this.progress != 0.0f) {
            int measuredWidth = getMeasuredWidth() / 2;
            int measuredHeight = getMeasuredHeight() / 2;
            eraser2.setStrokeWidth(AndroidUtilities.dp(30.0f));
            this.drawBitmap.eraseColor(0);
            float f = this.progress;
            float f2 = f >= 0.5f ? 1.0f : f / 0.5f;
            float f3 = f < 0.5f ? 0.0f : (f - 0.5f) / 0.5f;
            if (!this.isCheckAnimation) {
                f = 1.0f - f;
            }
            if (f < 0.2f) {
                fDp = (AndroidUtilities.dp(2.0f) * f) / 0.2f;
            } else {
                fDp = f < 0.4f ? AndroidUtilities.dp(2.0f) - ((AndroidUtilities.dp(2.0f) * (f - 0.2f)) / 0.2f) : 0.0f;
            }
            if (f3 != 0.0f) {
                canvas.drawCircle(measuredWidth, measuredHeight, ((measuredWidth - AndroidUtilities.dp(2.0f)) + (AndroidUtilities.dp(2.0f) * f3)) - fDp, this.backgroundPaint);
            }
            float f4 = (measuredWidth - this.innerRadDiff) - fDp;
            float f5 = measuredWidth;
            float f6 = measuredHeight;
            this.bitmapCanvas.drawCircle(f5, f6, f4, this.backgroundInnerPaint);
            this.bitmapCanvas.drawCircle(f5, f6, f4 * (1.0f - f2), eraser);
            canvas.drawBitmap(this.drawBitmap, 0.0f, 0.0f, (Paint) null);
            float fDp2 = AndroidUtilities.dp(10.0f) * f3 * this.checkScale;
            float fDp3 = AndroidUtilities.dp(5.0f) * f3 * this.checkScale;
            int iDp = measuredWidth - AndroidUtilities.dp(1.0f);
            int iDp2 = measuredHeight + AndroidUtilities.dp(4.0f);
            float fSqrt = (float) Math.sqrt((fDp3 * fDp3) / 2.0f);
            float f7 = iDp;
            float f8 = iDp2;
            canvas.drawLine(f7, f8, f7 - fSqrt, f8 - fSqrt, this.checkPaint);
            float fSqrt2 = (float) Math.sqrt((fDp2 * fDp2) / 2.0f);
            float fDp4 = iDp - AndroidUtilities.dp(1.2f);
            canvas.drawLine(fDp4, f8, fDp4 + fSqrt2, f8 - fSqrt2, this.checkPaint);
        }
    }
}
