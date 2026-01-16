package org.rbmain.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import ir.medu.shad.R;
import java.lang.reflect.InvocationTargetException;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AnimatedFloat;
import org.rbmain.ui.Components.AnimatedTextView;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.MotionBackgroundDrawable;
import org.rbmain.ui.Components.SeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.SpeedIconDrawable;

/* loaded from: classes4.dex */
public class ActionBarMenuSlider extends FrameLayout {
    private boolean backgroundDark;
    private Paint backgroundPaint;
    private Bitmap blurBitmap;
    private AnimatedFloat blurBitmapAlpha;
    private Matrix blurBitmapMatrix;
    private BitmapShader blurBitmapShader;
    private boolean blurIsInChat;
    private Paint blurPaint;
    private Paint brightenBlurPaint;
    private Paint darkenBlurPaint;
    private boolean dragging;
    private boolean drawBlur;
    private boolean drawShadow;
    private Paint fillPaint;
    private float fromValue;
    private float fromX;
    private int[] location;
    private Utilities.Callback2<Float, Boolean> onValueChange;
    private Runnable prepareBlur;
    private boolean preparingBlur;
    private int pseudoBlurColor1;
    private int pseudoBlurColor2;
    private LinearGradient pseudoBlurGradient;
    private Matrix pseudoBlurMatrix;
    private Paint pseudoBlurPaint;
    private int pseudoBlurWidth;
    protected Theme.ResourcesProvider resourcesProvider;
    private float roundRadiusDp;
    private Paint shadowPaint;
    private long tapStart;
    private AnimatedTextView.AnimatedTextDrawable textDrawable;
    private float value;
    private ValueAnimator valueAnimator;
    private ColorFilter whiteColorFilter;

    protected int getColorValue(float f) {
        return -1;
    }

    protected String getStringValue(float f) {
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ActionBarMenuSlider(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.value = 0.5f;
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.blurBitmapAlpha = new AnimatedFloat(1.0f, this, 0L, 320L, cubicBezierInterpolator);
        this.location = new int[2];
        this.roundRadiusDp = 0.0f;
        this.shadowPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        this.blurPaint = new Paint(1);
        this.brightenBlurPaint = new Paint(1);
        this.darkenBlurPaint = new Paint(1);
        this.pseudoBlurPaint = new Paint(1);
        this.fillPaint = new Paint(1);
        this.blurIsInChat = true;
        this.preparingBlur = false;
        this.prepareBlur = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarMenuSlider$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
                this.f$0.lambda$new$2();
            }
        };
        this.resourcesProvider = resourcesProvider;
        setWillNotDraw(false);
        AnimatedTextView.AnimatedTextDrawable animatedTextDrawable = new AnimatedTextView.AnimatedTextDrawable(false, z, z) { // from class: org.rbmain.ui.ActionBar.ActionBarMenuSlider.1
            @Override // android.graphics.drawable.Drawable
            public void invalidateSelf() {
                ActionBarMenuSlider.this.invalidate();
            }
        };
        this.textDrawable = animatedTextDrawable;
        animatedTextDrawable.setCallback(this);
        this.textDrawable.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.textDrawable.setAnimationProperties(0.3f, 0L, 165L, cubicBezierInterpolator);
        this.textDrawable.setTextSize(AndroidUtilities.dpf2(14.0f));
        this.textDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.textDrawable.getPaint().setStrokeWidth(AndroidUtilities.dpf2(0.3f));
        this.textDrawable.setGravity(LocaleController.isRTL ? 5 : 3);
        this.shadowPaint.setColor(0);
        this.shadowPaint.setShadowLayer(AndroidUtilities.dpf2(1.33f), 0.0f, AndroidUtilities.dpf2(0.33f), 1056964608);
        ColorMatrix colorMatrix = new ColorMatrix();
        AndroidUtilities.adjustSaturationColorMatrix(colorMatrix, -0.4f);
        AndroidUtilities.adjustBrightnessColorMatrix(colorMatrix, 0.1f);
        this.pseudoBlurPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        this.backgroundPaint.setColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground, resourcesProvider));
        z = AndroidUtilities.computePerceivedBrightness(this.backgroundPaint.getColor()) <= 0.721f;
        this.backgroundDark = z;
        this.textDrawable.setTextColor(z ? -1 : -16777216);
        this.darkenBlurPaint.setColor(Theme.multAlpha(-16777216, 0.025f));
        this.brightenBlurPaint.setColor(Theme.multAlpha(-1, 0.35f));
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float f, boolean z) {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.valueAnimator = null;
        }
        final float fClamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (!z) {
            this.value = fClamp;
            invalidate();
        } else {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.value, fClamp);
            this.valueAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ActionBar.ActionBarMenuSlider$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$setValue$0(valueAnimator2);
                }
            });
            this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarMenuSlider.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ActionBarMenuSlider.this.valueAnimator = null;
                    ActionBarMenuSlider.this.value = fClamp;
                    ActionBarMenuSlider.this.invalidate();
                }
            });
            this.valueAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
            this.valueAnimator.setDuration(220L);
            this.valueAnimator.start();
        }
        String stringValue = getStringValue(fClamp);
        if (stringValue != null && !TextUtils.equals(this.textDrawable.getText(), stringValue)) {
            this.textDrawable.cancelAnimation();
            this.textDrawable.setText(stringValue, true);
        }
        this.fillPaint.setColor(getColorValue(fClamp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValue$0(ValueAnimator valueAnimator) {
        this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundPaint.setColor(i);
        boolean z = AndroidUtilities.computePerceivedBrightness(this.backgroundPaint.getColor()) <= 0.721f;
        this.backgroundDark = z;
        this.textDrawable.setTextColor(z ? -1 : -16777216);
    }

    public void setTextColor(int i) {
        this.textDrawable.setTextColor(i);
    }

    private void updateValue(float f, boolean z) {
        setValue(f, false);
        Utilities.Callback2<Float, Boolean> callback2 = this.onValueChange;
        if (callback2 != null) {
            callback2.run(Float.valueOf(this.value), Boolean.valueOf(z));
        }
    }

    public void setOnValueChange(Utilities.Callback2<Float, Boolean> callback2) {
        this.onValueChange = callback2;
    }

    public void setDrawShadow(boolean z) {
        this.drawShadow = z;
        int iDp = z ? AndroidUtilities.dp(8.0f) : 0;
        setPadding(iDp, iDp, iDp, iDp);
        invalidate();
    }

    public void setDrawBlur(boolean z) {
        this.drawBlur = z;
        invalidate();
    }

    public void setRoundRadiusDp(float f) {
        this.roundRadiusDp = f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.preparingBlur = true;
        AndroidUtilities.makeGlobalBlurBitmap(new Utilities.Callback16() { // from class: org.rbmain.ui.ActionBar.ActionBarMenuSlider$$ExternalSyntheticLambda2
            @Override // org.rbmain.messenger.Utilities.Callback16
            public final void run(Object obj) {
                this.f$0.lambda$new$1((Bitmap) obj);
            }
        }, 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Bitmap bitmap) {
        this.preparingBlur = false;
        this.blurBitmap = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.blurBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = this.blurBitmapMatrix;
        if (matrix == null) {
            this.blurBitmapMatrix = new Matrix();
        } else {
            matrix.reset();
        }
        this.blurBitmapMatrix.postScale(8.0f, 8.0f);
        Matrix matrix2 = this.blurBitmapMatrix;
        int[] iArr = this.location;
        matrix2.postTranslate(-iArr[0], -iArr[1]);
        this.blurBitmapShader.setLocalMatrix(this.blurBitmapMatrix);
        this.blurPaint.setShader(this.blurBitmapShader);
        ColorMatrix colorMatrix = new ColorMatrix();
        AndroidUtilities.adjustSaturationColorMatrix(colorMatrix, -0.2f);
        this.blurPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.drawShadow) {
            i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i) + getPaddingRight() + getPaddingLeft(), 1073741824);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(44.0f) + getPaddingTop() + getPaddingBottom(), 1073741824));
        boolean z = SharedConfig.getDevicePerformanceClass() >= 2 && LiteMode.isEnabled(256);
        if (this.drawBlur && this.blurBitmap == null && !this.preparingBlur && z) {
            this.prepareBlur.run();
        }
    }

    public void invalidateBlur(boolean z) {
        this.blurIsInChat = z;
        this.blurPaint.setShader(null);
        this.blurBitmapShader = null;
        Bitmap bitmap = this.blurBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.blurBitmap = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws InterruptedException {
        super.onLayout(z, i, i2, i3, i4);
        getLocationOnScreen(this.location);
        Matrix matrix = this.blurBitmapMatrix;
        if (matrix != null) {
            matrix.reset();
            this.blurBitmapMatrix.postScale(8.0f, 8.0f);
            Matrix matrix2 = this.blurBitmapMatrix;
            int[] iArr = this.location;
            matrix2.postTranslate(-iArr[0], -iArr[1]);
            BitmapShader bitmapShader = this.blurBitmapShader;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.blurBitmapMatrix);
                invalidate();
            }
        }
        updatePseudoBlurColors();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = AndroidUtilities.rectTmp;
        rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.drawShadow) {
            canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.shadowPaint);
        }
        if (this.drawBlur) {
            float f = this.blurBitmapAlpha.set(this.blurBitmap != null ? 1.0f : 0.0f);
            if (f < 1.0f) {
                if (this.pseudoBlurMatrix == null || this.pseudoBlurWidth != ((int) rectF.width())) {
                    Matrix matrix = this.pseudoBlurMatrix;
                    if (matrix == null) {
                        this.pseudoBlurMatrix = new Matrix();
                    } else {
                        matrix.reset();
                    }
                    Matrix matrix2 = this.pseudoBlurMatrix;
                    int iWidth = (int) rectF.width();
                    this.pseudoBlurWidth = iWidth;
                    matrix2.postScale(iWidth, 1.0f);
                    this.pseudoBlurGradient.setLocalMatrix(this.pseudoBlurMatrix);
                }
                this.pseudoBlurPaint.setAlpha((int) ((1.0f - f) * 255.0f));
                canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.pseudoBlurPaint);
            }
            if (this.blurBitmap != null && this.value < 1.0f && f > 0.0f) {
                this.blurPaint.setAlpha((int) (f * 255.0f));
                canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.blurPaint);
            }
            canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.brightenBlurPaint);
            canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.darkenBlurPaint);
            this.fillPaint.setColor(-1);
        } else {
            canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.backgroundPaint);
        }
        if (!this.backgroundDark) {
            drawText(canvas, false);
        }
        if (this.value < 1.0f) {
            canvas.save();
            canvas.clipRect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (((getWidth() - getPaddingLeft()) - getPaddingRight()) * this.value), getHeight() - getPaddingBottom());
        }
        canvas.drawRoundRect(rectF, AndroidUtilities.dp(this.roundRadiusDp), AndroidUtilities.dp(this.roundRadiusDp), this.fillPaint);
        if (!this.backgroundDark) {
            drawText(canvas, true);
        }
        if (this.value < 1.0f) {
            canvas.restore();
        }
        if (this.backgroundDark) {
            drawText(canvas, false);
        }
    }

    private void drawText(Canvas canvas, boolean z) {
        ColorFilter porterDuffColorFilter;
        AnimatedTextView.AnimatedTextDrawable animatedTextDrawable = this.textDrawable;
        if (z) {
            porterDuffColorFilter = this.whiteColorFilter;
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
                this.whiteColorFilter = porterDuffColorFilter;
            }
        } else {
            porterDuffColorFilter = null;
        }
        animatedTextDrawable.setColorFilter(porterDuffColorFilter);
        this.textDrawable.setBounds(getPaddingLeft() + AndroidUtilities.dp(20.0f), getMeasuredHeight() / 2, (getMeasuredWidth() - getPaddingRight()) - AndroidUtilities.dp(20.0f), getMeasuredHeight() / 2);
        this.textDrawable.draw(canvas);
    }

    private Pair<Integer, Integer> getBitmapGradientColors(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int[] iArr = this.location;
        float f = iArr[0] / AndroidUtilities.displaySize.x;
        int width = (int) (f * bitmap.getWidth());
        int measuredWidth = (int) (((iArr[0] + getMeasuredWidth()) / AndroidUtilities.displaySize.x) * bitmap.getWidth());
        int currentActionBarHeight = (int) ((((this.location[1] - AndroidUtilities.statusBarHeight) - ActionBar.getCurrentActionBarHeight()) / AndroidUtilities.displaySize.y) * bitmap.getHeight());
        if (width < 0 || width >= bitmap.getWidth() || measuredWidth < 0 || measuredWidth >= bitmap.getWidth() || currentActionBarHeight < 0 || currentActionBarHeight >= bitmap.getHeight()) {
            return null;
        }
        return new Pair<>(Integer.valueOf(bitmap.getPixel(width, currentActionBarHeight)), Integer.valueOf(bitmap.getPixel(measuredWidth, currentActionBarHeight)));
    }

    private void updatePseudoBlurColors() throws InterruptedException {
        int color;
        int iIntValue;
        if (this.blurIsInChat) {
            Drawable cachedWallpaper = Theme.getCachedWallpaper();
            if (cachedWallpaper instanceof ColorDrawable) {
                color = ((ColorDrawable) cachedWallpaper).getColor();
            } else {
                Bitmap bitmap = null;
                if (cachedWallpaper instanceof MotionBackgroundDrawable) {
                    bitmap = ((MotionBackgroundDrawable) cachedWallpaper).getBitmap();
                } else if (cachedWallpaper instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) cachedWallpaper).getBitmap();
                }
                Pair<Integer, Integer> bitmapGradientColors = getBitmapGradientColors(bitmap);
                if (bitmapGradientColors != null) {
                    int iIntValue2 = ((Integer) bitmapGradientColors.first).intValue();
                    iIntValue = ((Integer) bitmapGradientColors.second).intValue();
                    color = iIntValue2;
                    if (this.pseudoBlurGradient == null && this.pseudoBlurColor1 == color && this.pseudoBlurColor2 == iIntValue) {
                        return;
                    }
                    this.pseudoBlurColor1 = color;
                    this.pseudoBlurColor2 = iIntValue;
                    LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{color, iIntValue}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                    this.pseudoBlurGradient = linearGradient;
                    this.pseudoBlurPaint.setShader(linearGradient);
                }
                color = Theme.multAlpha(Theme.getColor(Theme.key_windowBackgroundWhite, this.resourcesProvider), 0.25f);
            }
        } else {
            color = Theme.getColor(Theme.key_windowBackgroundWhite, this.resourcesProvider);
            if (!Theme.isCurrentThemeDark()) {
                color = Theme.blendOver(color, Theme.multAlpha(-16777216, 0.18f));
            }
        }
        iIntValue = color;
        if (this.pseudoBlurGradient == null) {
        }
        this.pseudoBlurColor1 = color;
        this.pseudoBlurColor2 = iIntValue;
        LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{color, iIntValue}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.pseudoBlurGradient = linearGradient2;
        this.pseudoBlurPaint.setShader(linearGradient2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - getPaddingLeft();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.dragging = true;
            this.fromX = x;
            this.fromValue = this.value;
            this.tapStart = System.currentTimeMillis();
        } else if (action == 2 || action == 1) {
            if (action == 1) {
                this.dragging = false;
                if (System.currentTimeMillis() - this.tapStart < ViewConfiguration.getTapTimeout()) {
                    float paddingLeft = (x - getPaddingLeft()) / ((getWidth() - getPaddingLeft()) - getPaddingRight());
                    Utilities.Callback2<Float, Boolean> callback2 = this.onValueChange;
                    if (callback2 != null) {
                        callback2.run(Float.valueOf(paddingLeft), Boolean.TRUE);
                    }
                    return true;
                }
            }
            updateValue(this.fromValue + ((x - this.fromX) / Math.max(1, (getWidth() - getPaddingLeft()) - getPaddingRight())), !this.dragging);
        }
        return true;
    }

    public static class SpeedSlider extends ActionBarMenuSlider {
        private final SeekBarAccessibilityDelegate seekBarAccessibilityDelegate;

        public float getSpeed(float f) {
            return (f * 2.3f) + 0.2f;
        }

        public SpeedSlider(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setImportantForAccessibility(1);
            FloatSeekBarAccessibilityDelegate floatSeekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate(false) { // from class: org.rbmain.ui.ActionBar.ActionBarMenuSlider.SpeedSlider.1
                @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
                protected float getDelta() {
                    return 0.2f;
                }

                @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
                protected float getMaxValue() {
                    return 2.5f;
                }

                @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
                protected float getMinValue() {
                    return 0.2f;
                }

                @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
                public float getProgress() {
                    return SpeedSlider.this.getSpeed();
                }

                @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
                public void setProgress(float f) {
                    SpeedSlider.this.setSpeed(f, true);
                }

                @Override // org.rbmain.ui.Components.SeekBarAccessibilityDelegate
                public CharSequence getContentDescription(View view) {
                    return SpeedIconDrawable.formatNumber(SpeedSlider.this.getSpeed()) + "x  " + LocaleController.getString("AccDescrSpeedSlider", R.string.AccDescrSpeedSlider);
                }
            };
            this.seekBarAccessibilityDelegate = floatSeekBarAccessibilityDelegate;
            setAccessibilityDelegate(floatSeekBarAccessibilityDelegate);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            this.seekBarAccessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(this, accessibilityNodeInfo);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return super.performAccessibilityAction(i, bundle) || this.seekBarAccessibilityDelegate.performAccessibilityActionInternal(this, i, bundle);
        }

        public float getSpeed() {
            return getSpeed(getValue());
        }

        public void setSpeed(float f, boolean z) {
            setValue((f - 0.2f) / 2.3f, z);
        }

        @Override // org.rbmain.ui.ActionBar.ActionBarMenuSlider
        protected String getStringValue(float f) {
            return SpeedIconDrawable.formatNumber((f * 2.3f) + 0.2f) + "x";
        }

        @Override // org.rbmain.ui.ActionBar.ActionBarMenuSlider
        protected int getColorValue(float f) {
            return ColorUtils.blendARGB(Theme.getColor(Theme.key_color_lightblue, this.resourcesProvider), Theme.getColor(Theme.key_color_blue, this.resourcesProvider), MathUtils.clamp((((f * 2.3f) + 0.2f) - 1.0f) / 1.0f, 0.0f, 1.0f));
        }
    }
}
