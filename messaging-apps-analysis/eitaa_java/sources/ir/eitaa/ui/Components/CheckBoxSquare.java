package ir.eitaa.ui.Components;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class CheckBoxSquare extends View {
    private boolean attachedToWindow;
    private ObjectAnimator checkAnimator;
    private Bitmap drawBitmap;
    private Canvas drawCanvas;
    private boolean isAlert;
    private boolean isChecked;
    private boolean isDisabled;
    private String key1;
    private String key2;
    private String key3;
    private float progress;
    private RectF rectF;
    private final Theme.ResourcesProvider resourcesProvider;

    public CheckBoxSquare(Context context, boolean alert) {
        this(context, alert, null);
    }

    public CheckBoxSquare(Context context, boolean alert, Theme.ResourcesProvider resourcesProvider) throws Resources.NotFoundException {
        super(context);
        this.resourcesProvider = resourcesProvider;
        if (Theme.checkboxSquare_backgroundPaint == null) {
            Theme.createCommonResources(context);
        }
        boolean z = this.isAlert;
        this.key1 = z ? "dialogCheckboxSquareUnchecked" : "checkboxSquareUnchecked";
        this.key2 = z ? "dialogCheckboxSquareBackground" : "checkboxSquareBackground";
        this.key3 = z ? "dialogCheckboxSquareCheck" : "checkboxSquareCheck";
        this.rectF = new RectF();
        this.drawBitmap = Bitmap.createBitmap(AndroidUtilities.dp(18.0f), AndroidUtilities.dp(18.0f), Bitmap.Config.ARGB_4444);
        this.drawCanvas = new Canvas(this.drawBitmap);
        this.isAlert = alert;
    }

    public void setColors(String unchecked, String checked, String check) {
        this.key1 = unchecked;
        this.key2 = checked;
        this.key3 = check;
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

    private void cancelCheckAnimator() {
        ObjectAnimator objectAnimator = this.checkAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void animateToCheckedState(boolean newCheckedState) {
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

    public void setDisabled(boolean disabled) {
        this.isDisabled = disabled;
        invalidate();
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        if (getVisibility() != 0) {
            return;
        }
        int themedColor = getThemedColor(this.key1);
        int themedColor2 = getThemedColor(this.key2);
        float f3 = this.progress;
        if (f3 <= 0.5f) {
            f2 = f3 / 0.5f;
            Theme.checkboxSquare_backgroundPaint.setColor(Color.rgb(Color.red(themedColor) + ((int) ((Color.red(themedColor2) - Color.red(themedColor)) * f2)), Color.green(themedColor) + ((int) ((Color.green(themedColor2) - Color.green(themedColor)) * f2)), Color.blue(themedColor) + ((int) ((Color.blue(themedColor2) - Color.blue(themedColor)) * f2))));
            f = f2;
        } else {
            Theme.checkboxSquare_backgroundPaint.setColor(themedColor2);
            f = 2.0f - (f3 / 0.5f);
            f2 = 1.0f;
        }
        if (this.isDisabled) {
            Theme.checkboxSquare_backgroundPaint.setColor(getThemedColor(this.isAlert ? "dialogCheckboxSquareDisabled" : "checkboxSquareDisabled"));
        }
        float fDp = AndroidUtilities.dp(1.0f) * f;
        this.rectF.set(fDp, fDp, AndroidUtilities.dp(18.0f) - fDp, AndroidUtilities.dp(18.0f) - fDp);
        this.drawBitmap.eraseColor(0);
        this.drawCanvas.drawRoundRect(this.rectF, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.checkboxSquare_backgroundPaint);
        if (f2 != 1.0f) {
            float fMin = Math.min(AndroidUtilities.dp(7.0f), (AndroidUtilities.dp(7.0f) * f2) + fDp);
            this.rectF.set(AndroidUtilities.dp(2.0f) + fMin, AndroidUtilities.dp(2.0f) + fMin, AndroidUtilities.dp(16.0f) - fMin, AndroidUtilities.dp(16.0f) - fMin);
            this.drawCanvas.drawRect(this.rectF, Theme.checkboxSquare_eraserPaint);
        }
        if (this.progress > 0.5f) {
            Theme.checkboxSquare_checkPaint.setColor(getThemedColor(this.key3));
            float f4 = 1.0f - f;
            this.drawCanvas.drawLine(AndroidUtilities.dp(7.0f), (int) AndroidUtilities.dpf2(13.0f), (int) (AndroidUtilities.dp(7.0f) - (AndroidUtilities.dp(3.0f) * f4)), (int) (AndroidUtilities.dpf2(13.0f) - (AndroidUtilities.dp(3.0f) * f4)), Theme.checkboxSquare_checkPaint);
            this.drawCanvas.drawLine((int) AndroidUtilities.dpf2(7.0f), (int) AndroidUtilities.dpf2(13.0f), (int) (AndroidUtilities.dpf2(7.0f) + (AndroidUtilities.dp(7.0f) * f4)), (int) (AndroidUtilities.dpf2(13.0f) - (AndroidUtilities.dp(7.0f) * f4)), Theme.checkboxSquare_checkPaint);
        }
        canvas.drawBitmap(this.drawBitmap, 0.0f, 0.0f, (Paint) null);
    }

    protected int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
