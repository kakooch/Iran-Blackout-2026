package ir.eitaa.ui.Components;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.Property;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AnimationProperties;

/* loaded from: classes3.dex */
public class WallpaperCheckBoxView extends View {
    public final Property<WallpaperCheckBoxView, Float> PROGRESS_PROPERTY;
    private Paint backgroundPaint;
    private ObjectAnimator checkAnimator;
    private Paint checkPaint;
    private int[] colors;
    private String currentText;
    private int currentTextSize;
    private Bitmap drawBitmap;
    private Canvas drawCanvas;
    private Paint eraserPaint;
    private boolean isChecked;
    private int maxTextSize;
    private View parentView;
    private float progress;
    private RectF rect;
    private TextPaint textPaint;

    public WallpaperCheckBoxView(Context context, boolean check, View parent) {
        super(context);
        this.colors = new int[4];
        this.PROGRESS_PROPERTY = new AnimationProperties.FloatProperty<WallpaperCheckBoxView>("progress") { // from class: ir.eitaa.ui.Components.WallpaperCheckBoxView.1
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(WallpaperCheckBoxView object, float value) {
                WallpaperCheckBoxView.this.progress = value;
                WallpaperCheckBoxView.this.invalidate();
            }

            @Override // android.util.Property
            public Float get(WallpaperCheckBoxView object) {
                return Float.valueOf(WallpaperCheckBoxView.this.progress);
            }
        };
        this.rect = new RectF();
        if (check) {
            this.drawBitmap = Bitmap.createBitmap(AndroidUtilities.dp(18.0f), AndroidUtilities.dp(18.0f), Bitmap.Config.ARGB_4444);
            this.drawCanvas = new Canvas(this.drawBitmap);
        }
        this.parentView = parent;
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(14.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        Paint paint = new Paint(1);
        this.checkPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.checkPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.checkPaint.setColor(0);
        this.checkPaint.setStrokeCap(Paint.Cap.ROUND);
        this.checkPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.eraserPaint = paint2;
        paint2.setColor(0);
        this.eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.backgroundPaint = new Paint(1);
    }

    public void setText(String text, int current, int max) {
        this.currentText = text;
        this.currentTextSize = current;
        this.maxTextSize = max;
    }

    public String getText() {
        return this.currentText;
    }

    public void setColor(int index, int color) {
        if (this.colors == null) {
            this.colors = new int[4];
        }
        this.colors[index] = color;
        invalidate();
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.maxTextSize + AndroidUtilities.dp(56.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Theme.applyServiceShaderMatrixForView(this, this.parentView);
        canvas.drawRoundRect(this.rect, getMeasuredHeight() / 2, getMeasuredHeight() / 2, Theme.chat_actionBackgroundPaint);
        if (Theme.hasGradientService()) {
            canvas.drawRoundRect(this.rect, getMeasuredHeight() / 2, getMeasuredHeight() / 2, Theme.chat_actionBackgroundGradientDarkenPaint);
        }
        this.textPaint.setColor(Theme.getColor("chat_serviceText"));
        int measuredWidth = ((getMeasuredWidth() - this.currentTextSize) - AndroidUtilities.dp(28.0f)) / 2;
        canvas.drawText(this.currentText, AndroidUtilities.dp(28.0f) + measuredWidth, AndroidUtilities.dp(21.0f), this.textPaint);
        canvas.save();
        canvas.translate(measuredWidth, AndroidUtilities.dp(7.0f));
        int i = 0;
        if (this.drawBitmap != null) {
            float f3 = this.progress;
            if (f3 <= 0.5f) {
                f = f3 / 0.5f;
                f2 = f;
            } else {
                f = 2.0f - (f3 / 0.5f);
                f2 = 1.0f;
            }
            float fDp = AndroidUtilities.dp(1.0f) * f;
            this.rect.set(fDp, fDp, AndroidUtilities.dp(18.0f) - fDp, AndroidUtilities.dp(18.0f) - fDp);
            this.drawBitmap.eraseColor(0);
            this.backgroundPaint.setColor(Theme.getColor("chat_serviceText"));
            Canvas canvas2 = this.drawCanvas;
            RectF rectF = this.rect;
            canvas2.drawRoundRect(rectF, rectF.width() / 2.0f, this.rect.height() / 2.0f, this.backgroundPaint);
            if (f2 != 1.0f) {
                float fMin = Math.min(AndroidUtilities.dp(7.0f), (AndroidUtilities.dp(7.0f) * f2) + fDp);
                this.rect.set(AndroidUtilities.dp(2.0f) + fMin, AndroidUtilities.dp(2.0f) + fMin, AndroidUtilities.dp(16.0f) - fMin, AndroidUtilities.dp(16.0f) - fMin);
                Canvas canvas3 = this.drawCanvas;
                RectF rectF2 = this.rect;
                canvas3.drawRoundRect(rectF2, rectF2.width() / 2.0f, this.rect.height() / 2.0f, this.eraserPaint);
            }
            if (this.progress > 0.5f) {
                float f4 = 1.0f - f;
                this.drawCanvas.drawLine(AndroidUtilities.dp(7.3f), AndroidUtilities.dp(13.0f), (int) (AndroidUtilities.dp(7.3f) - (AndroidUtilities.dp(2.5f) * f4)), (int) (AndroidUtilities.dp(13.0f) - (AndroidUtilities.dp(2.5f) * f4)), this.checkPaint);
                this.drawCanvas.drawLine(AndroidUtilities.dp(7.3f), AndroidUtilities.dp(13.0f), (int) (AndroidUtilities.dp(7.3f) + (AndroidUtilities.dp(6.0f) * f4)), (int) (AndroidUtilities.dp(13.0f) - (AndroidUtilities.dp(6.0f) * f4)), this.checkPaint);
            }
            canvas.drawBitmap(this.drawBitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            this.rect.set(0.0f, 0.0f, AndroidUtilities.dp(18.0f), AndroidUtilities.dp(18.0f));
            int[] iArr = this.colors;
            if (iArr[3] != 0) {
                while (i < 4) {
                    this.backgroundPaint.setColor(this.colors[i]);
                    canvas.drawArc(this.rect, (i * 90) - 90, 90.0f, true, this.backgroundPaint);
                    i++;
                }
            } else if (iArr[2] != 0) {
                while (i < 3) {
                    this.backgroundPaint.setColor(this.colors[i]);
                    canvas.drawArc(this.rect, (i * R.styleable.AppCompatTheme_windowNoTitle) - 90, 120.0f, true, this.backgroundPaint);
                    i++;
                }
            } else if (iArr[1] != 0) {
                while (i < 2) {
                    this.backgroundPaint.setColor(this.colors[i]);
                    canvas.drawArc(this.rect, (i * 180) - 90, 180.0f, true, this.backgroundPaint);
                    i++;
                }
            } else {
                this.backgroundPaint.setColor(iArr[0]);
                RectF rectF3 = this.rect;
                canvas.drawRoundRect(rectF3, rectF3.width() / 2.0f, this.rect.height() / 2.0f, this.backgroundPaint);
            }
        }
        canvas.restore();
    }

    private void setProgress(float value) {
        if (this.progress == value) {
            return;
        }
        this.progress = value;
        invalidate();
    }

    private void cancelCheckAnimator() {
        ObjectAnimator objectAnimator = this.checkAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void animateToCheckedState(boolean newCheckedState) {
        Property<WallpaperCheckBoxView, Float> property = this.PROGRESS_PROPERTY;
        float[] fArr = new float[1];
        fArr[0] = newCheckedState ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, property, fArr);
        this.checkAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.checkAnimator.start();
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
        if (animated) {
            animateToCheckedState(checked);
            return;
        }
        cancelCheckAnimator();
        this.progress = checked ? 1.0f : 0.0f;
        invalidate();
    }

    public boolean isChecked() {
        return this.isChecked;
    }
}
