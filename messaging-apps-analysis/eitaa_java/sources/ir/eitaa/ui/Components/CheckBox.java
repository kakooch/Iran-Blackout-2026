package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class CheckBox extends View {
    private static Paint backgroundPaint;
    private static Paint eraser;
    private static Paint eraser2;
    private static Paint paint;
    private boolean attachedToWindow;
    private Canvas bitmapCanvas;
    private ObjectAnimator checkAnimator;
    private Bitmap checkBitmap;
    private Canvas checkCanvas;
    private Drawable checkDrawable;
    private int checkOffset;
    private String checkedText;
    private int color;
    private boolean drawBackground;
    private Bitmap drawBitmap;
    private boolean hasBorder;
    private boolean isCheckAnimation;
    private boolean isChecked;
    private float progress;
    private int size;
    private TextPaint textPaint;

    public CheckBox(Context context, int resId) {
        super(context);
        this.isCheckAnimation = true;
        this.size = 22;
        if (paint == null) {
            paint = new Paint(1);
            Paint paint2 = new Paint(1);
            eraser = paint2;
            paint2.setColor(0);
            eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Paint paint3 = new Paint(1);
            eraser2 = paint3;
            paint3.setColor(0);
            eraser2.setStyle(Paint.Style.STROKE);
            eraser2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Paint paint4 = new Paint(1);
            backgroundPaint = paint4;
            paint4.setColor(-1);
            backgroundPaint.setStyle(Paint.Style.STROKE);
        }
        eraser2.setStrokeWidth(AndroidUtilities.dp(28.0f));
        backgroundPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(18.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.checkDrawable = context.getResources().getDrawable(resId).mutate();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 0 && this.drawBitmap == null) {
            try {
                this.drawBitmap = Bitmap.createBitmap(AndroidUtilities.dp(this.size), AndroidUtilities.dp(this.size), Bitmap.Config.ARGB_4444);
                this.bitmapCanvas = new Canvas(this.drawBitmap);
                this.checkBitmap = Bitmap.createBitmap(AndroidUtilities.dp(this.size), AndroidUtilities.dp(this.size), Bitmap.Config.ARGB_4444);
                this.checkCanvas = new Canvas(this.checkBitmap);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public void setProgress(float value) {
        if (this.progress == value) {
            return;
        }
        this.progress = value;
        invalidate();
    }

    public void setDrawBackground(boolean value) {
        this.drawBackground = value;
    }

    public void setHasBorder(boolean value) {
        this.hasBorder = value;
    }

    public void setCheckOffset(int value) {
        this.checkOffset = value;
    }

    public void setSize(int size) {
        this.size = size;
        if (size == 40) {
            this.textPaint.setTextSize(AndroidUtilities.dp(24.0f));
        }
    }

    public void setStrokeWidth(int value) {
        backgroundPaint.setStrokeWidth(value);
    }

    @Keep
    public float getProgress() {
        return this.progress;
    }

    public void setColor(int backgroundColor, int checkColor) {
        this.color = backgroundColor;
        this.checkDrawable.setColorFilter(new PorterDuffColorFilter(checkColor, PorterDuff.Mode.MULTIPLY));
        this.textPaint.setColor(checkColor);
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int backgroundColor) {
        this.color = backgroundColor;
        invalidate();
    }

    public void setCheckColor(int checkColor) {
        this.checkDrawable.setColorFilter(new PorterDuffColorFilter(checkColor, PorterDuff.Mode.MULTIPLY));
        this.textPaint.setColor(checkColor);
        invalidate();
    }

    private void cancelCheckAnimator() {
        ObjectAnimator objectAnimator = this.checkAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.checkAnimator = null;
        }
    }

    private void animateToCheckedState(boolean newCheckedState) {
        this.isCheckAnimation = newCheckedState;
        float[] fArr = new float[1];
        fArr[0] = newCheckedState ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", fArr);
        this.checkAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.CheckBox.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(CheckBox.this.checkAnimator)) {
                    CheckBox.this.checkAnimator = null;
                }
                if (CheckBox.this.isChecked) {
                    return;
                }
                CheckBox.this.checkedText = null;
            }
        });
        this.checkAnimator.setDuration(300L);
        this.checkAnimator.start();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public void setChecked(boolean checked, boolean animated) {
        setChecked(-1, checked, animated);
    }

    public void setNum(int num) {
        if (num >= 0) {
            this.checkedText = "" + (num + 1);
        } else if (this.checkAnimator == null) {
            this.checkedText = null;
        }
        invalidate();
    }

    public void setChecked(int num, boolean checked, boolean animated) {
        if (num >= 0) {
            this.checkedText = "" + (num + 1);
            invalidate();
        }
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

    public boolean isChecked() {
        return this.isChecked;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.CheckBox.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.CheckBox");
        info.setCheckable(true);
        info.setChecked(this.isChecked);
    }
}
