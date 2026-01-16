package ir.eitaa.ui.Components.Paint.Views;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.Paint.Swatch;

/* loaded from: classes3.dex */
public class ColorPicker extends FrameLayout {
    private static final int[] COLORS = {-1431751, -2409774, -13610525, -11942419, -8337308, -205211, -223667, -16777216, -1};
    private static final float[] LOCATIONS = {0.0f, 0.14f, 0.24f, 0.39f, 0.49f, 0.62f, 0.73f, 0.85f, 1.0f};
    private Paint backgroundPaint;
    private boolean changingWeight;
    private ColorPickerDelegate delegate;
    private boolean dragging;
    private float draggingFactor;
    private Paint gradientPaint;
    private boolean interacting;
    private OvershootInterpolator interpolator;
    private float location;
    private RectF rectF;
    private ImageView settingsButton;
    private Drawable shadowDrawable;
    private Paint swatchPaint;
    private Paint swatchStrokePaint;
    private ImageView undoButton;
    private boolean wasChangingWeight;
    private float weight;

    public interface ColorPickerDelegate {
        void onBeganColorPicking();

        void onColorValueChanged();

        void onFinishedColorPicking();

        void onSettingsPressed();

        void onUndoPressed();
    }

    public ColorPicker(Context context) {
        super(context);
        this.interpolator = new OvershootInterpolator(1.02f);
        this.gradientPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        this.swatchPaint = new Paint(1);
        this.swatchStrokePaint = new Paint(1);
        this.rectF = new RectF();
        this.weight = 0.016773745f;
        setWillNotDraw(false);
        this.shadowDrawable = getResources().getDrawable(R.drawable.knob_shadow);
        this.backgroundPaint.setColor(-1);
        this.swatchStrokePaint.setStyle(Paint.Style.STROKE);
        this.swatchStrokePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        ImageView imageView = new ImageView(context);
        this.settingsButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.settingsButton.setImageResource(R.drawable.photo_paint_brush);
        addView(this.settingsButton, LayoutHelper.createFrame(46, 52.0f));
        this.settingsButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.Paint.Views.-$$Lambda$ColorPicker$zu_WOBXiUCnqHqEpEvkRc32bBRg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$ColorPicker(view);
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.undoButton = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.undoButton.setImageResource(R.drawable.photo_undo);
        addView(this.undoButton, LayoutHelper.createFrame(46, 52.0f));
        this.undoButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.Paint.Views.-$$Lambda$ColorPicker$4iCXeNaY2ABignosx1sM5RekluM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$ColorPicker(view);
            }
        });
        SharedPreferences sharedPreferences = context.getSharedPreferences("paint", 0);
        this.location = sharedPreferences.getFloat("last_color_location", 1.0f);
        setWeight(sharedPreferences.getFloat("last_color_weight", 0.016773745f));
        setLocation(this.location);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ColorPicker(View view) {
        ColorPickerDelegate colorPickerDelegate = this.delegate;
        if (colorPickerDelegate != null) {
            colorPickerDelegate.onSettingsPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ColorPicker(View view) {
        ColorPickerDelegate colorPickerDelegate = this.delegate;
        if (colorPickerDelegate != null) {
            colorPickerDelegate.onUndoPressed();
        }
    }

    public void setUndoEnabled(boolean enabled) {
        this.undoButton.setAlpha(enabled ? 1.0f : 0.3f);
        this.undoButton.setEnabled(enabled);
    }

    public void setDelegate(ColorPickerDelegate colorPickerDelegate) {
        this.delegate = colorPickerDelegate;
    }

    public View getSettingsButton() {
        return this.settingsButton;
    }

    public void setSettingsButtonImage(int resId) {
        this.settingsButton.setImageResource(resId);
    }

    public Swatch getSwatch() {
        return new Swatch(colorForLocation(this.location), this.location, this.weight);
    }

    public void setSwatch(Swatch swatch) {
        setLocation(swatch.colorLocation);
        setWeight(swatch.brushWeight);
    }

    public int colorForLocation(float location) {
        float[] fArr;
        int i;
        if (location <= 0.0f) {
            return COLORS[0];
        }
        int i2 = 1;
        if (location >= 1.0f) {
            int[] iArr = COLORS;
            return iArr[iArr.length - 1];
        }
        while (true) {
            fArr = LOCATIONS;
            i = -1;
            if (i2 >= fArr.length) {
                i2 = -1;
                break;
            }
            if (fArr[i2] >= location) {
                i = i2 - 1;
                break;
            }
            i2++;
        }
        float f = fArr[i];
        int[] iArr2 = COLORS;
        return interpolateColors(iArr2[i], iArr2[i2], (location - f) / (fArr[i2] - f));
    }

    private int interpolateColors(int leftColor, int rightColor, float factor) {
        float fMin = Math.min(Math.max(factor, 0.0f), 1.0f);
        int iRed = Color.red(leftColor);
        int iRed2 = Color.red(rightColor);
        int iGreen = Color.green(leftColor);
        int iGreen2 = Color.green(rightColor);
        return Color.argb(255, Math.min(255, (int) (iRed + ((iRed2 - iRed) * fMin))), Math.min(255, (int) (iGreen + ((iGreen2 - iGreen) * fMin))), Math.min(255, (int) (Color.blue(leftColor) + ((Color.blue(rightColor) - r6) * fMin))));
    }

    public void setLocation(float value) {
        this.location = value;
        int iColorForLocation = colorForLocation(value);
        this.swatchPaint.setColor(iColorForLocation);
        float[] fArr = new float[3];
        Color.colorToHSV(iColorForLocation, fArr);
        if (fArr[0] < 0.001d && fArr[1] < 0.001d && fArr[2] > 0.92f) {
            int i = (int) ((1.0f - (((fArr[2] - 0.92f) / 0.08f) * 0.22f)) * 255.0f);
            this.swatchStrokePaint.setColor(Color.rgb(i, i, i));
        } else {
            this.swatchStrokePaint.setColor(iColorForLocation);
        }
        invalidate();
    }

    public void setWeight(float value) {
        this.weight = value;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ColorPickerDelegate colorPickerDelegate;
        if (event.getPointerCount() > 1) {
            return false;
        }
        float x = event.getX() - this.rectF.left;
        float y = event.getY() - this.rectF.top;
        if (!this.interacting && y < (-AndroidUtilities.dp(10.0f))) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1 || actionMasked == 6) {
            if (this.interacting && (colorPickerDelegate = this.delegate) != null) {
                colorPickerDelegate.onFinishedColorPicking();
                SharedPreferences.Editor editorEdit = getContext().getSharedPreferences("paint", 0).edit();
                editorEdit.putFloat("last_color_location", this.location);
                editorEdit.putFloat("last_color_weight", this.weight);
                editorEdit.commit();
            }
            this.interacting = false;
            this.wasChangingWeight = this.changingWeight;
            this.changingWeight = false;
            setDragging(false, true);
        } else if (actionMasked == 0 || actionMasked == 2) {
            if (!this.interacting) {
                this.interacting = true;
                ColorPickerDelegate colorPickerDelegate2 = this.delegate;
                if (colorPickerDelegate2 != null) {
                    colorPickerDelegate2.onBeganColorPicking();
                }
            }
            setLocation(Math.max(0.0f, Math.min(1.0f, x / this.rectF.width())));
            setDragging(true, true);
            if (y < (-AndroidUtilities.dp(10.0f))) {
                this.changingWeight = true;
                setWeight(Math.max(0.0f, Math.min(1.0f, ((-y) - AndroidUtilities.dp(10.0f)) / AndroidUtilities.dp(190.0f))));
            }
            ColorPickerDelegate colorPickerDelegate3 = this.delegate;
            if (colorPickerDelegate3 != null) {
                colorPickerDelegate3.onColorValueChanged();
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        this.gradientPaint.setShader(new LinearGradient(AndroidUtilities.dp(56.0f), 0.0f, i - AndroidUtilities.dp(56.0f), 0.0f, COLORS, LOCATIONS, Shader.TileMode.REPEAT));
        this.rectF.set(AndroidUtilities.dp(56.0f), i2 - AndroidUtilities.dp(32.0f), i - AndroidUtilities.dp(56.0f), r9 + AndroidUtilities.dp(12.0f));
        ImageView imageView = this.settingsButton;
        imageView.layout(i - imageView.getMeasuredWidth(), i2 - AndroidUtilities.dp(52.0f), i, i2);
        this.undoButton.layout(0, i2 - AndroidUtilities.dp(52.0f), this.settingsButton.getMeasuredWidth(), i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.rectF, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), this.gradientPaint);
        RectF rectF = this.rectF;
        int iWidth = (int) (rectF.left + (rectF.width() * this.location));
        int iCenterY = (int) ((this.rectF.centerY() + (this.draggingFactor * (-AndroidUtilities.dp(70.0f)))) - (this.changingWeight ? this.weight * AndroidUtilities.dp(190.0f) : 0.0f));
        int iDp = (int) (AndroidUtilities.dp(24.0f) * (this.draggingFactor + 1.0f) * 0.5f);
        this.shadowDrawable.setBounds(iWidth - iDp, iCenterY - iDp, iWidth + iDp, iDp + iCenterY);
        this.shadowDrawable.draw(canvas);
        float fFloor = (((int) Math.floor(AndroidUtilities.dp(4.0f) + ((AndroidUtilities.dp(19.0f) - AndroidUtilities.dp(4.0f)) * this.weight))) * (this.draggingFactor + 1.0f)) / 2.0f;
        float f = iWidth;
        float f2 = iCenterY;
        canvas.drawCircle(f, f2, (AndroidUtilities.dp(22.0f) / 2) * (this.draggingFactor + 1.0f), this.backgroundPaint);
        canvas.drawCircle(f, f2, fFloor, this.swatchPaint);
        canvas.drawCircle(f, f2, fFloor - AndroidUtilities.dp(0.5f), this.swatchStrokePaint);
    }

    @Keep
    private void setDraggingFactor(float factor) {
        this.draggingFactor = factor;
        invalidate();
    }

    @Keep
    public float getDraggingFactor() {
        return this.draggingFactor;
    }

    private void setDragging(boolean value, boolean animated) {
        if (this.dragging == value) {
            return;
        }
        this.dragging = value;
        float f = value ? 1.0f : 0.0f;
        if (animated) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "draggingFactor", this.draggingFactor, f);
            objectAnimatorOfFloat.setInterpolator(this.interpolator);
            objectAnimatorOfFloat.setDuration(this.wasChangingWeight ? (int) (300 + (this.weight * 75.0f)) : 300);
            objectAnimatorOfFloat.start();
            return;
        }
        setDraggingFactor(f);
    }
}
