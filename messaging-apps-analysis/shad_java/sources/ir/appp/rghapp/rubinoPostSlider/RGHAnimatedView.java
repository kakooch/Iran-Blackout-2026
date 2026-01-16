package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import org.rbmain.messenger.R;

/* loaded from: classes3.dex */
public class RGHAnimatedView extends View {
    long animationStartTime;
    Drawable currentlyDrawingDrawable;
    Rect currentlyDrawingDrawableBound;
    int filledColor;
    Drawable filledDrawable;
    RubinoLikeInterpolator interpolator;
    boolean isAnimating;
    public boolean isShowingFilledState;
    int outlineColor;
    Drawable outlineDrawable;
    float scale;

    public RGHAnimatedView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.scale = 1.0f;
        this.isAnimating = false;
        this.isShowingFilledState = false;
        Resources resources = context.getResources();
        this.filledDrawable = resources.getDrawable(i).mutate();
        this.outlineDrawable = resources.getDrawable(i2).mutate();
        this.filledColor = i3;
        this.outlineColor = i4;
        this.isShowingFilledState = false;
        init();
    }

    public RGHAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scale = 1.0f;
        this.isAnimating = false;
        this.isShowingFilledState = false;
        getValuesFromXML(context, attributeSet);
        init();
    }

    public void setFilledAndrOutlineColor(int i, int i2) {
        this.filledColor = i;
        this.outlineColor = i2;
        this.outlineDrawable.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        this.filledDrawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        updateCurrentDrawable();
    }

    private void init() {
        this.interpolator = new RubinoLikeInterpolator();
        this.filledDrawable.setColorFilter(this.filledColor, PorterDuff.Mode.SRC_ATOP);
        this.outlineDrawable.setColorFilter(this.outlineColor, PorterDuff.Mode.SRC_ATOP);
        this.currentlyDrawingDrawableBound = new Rect(0, 0, 0, 0);
        updateCurrentDrawable();
    }

    public void updateIcon(boolean z, boolean z2) {
        this.isShowingFilledState = z;
        updateCurrentDrawable();
        if (z2) {
            this.animationStartTime = System.currentTimeMillis();
            this.isAnimating = true;
            setAlpha(0.5f);
            updateAnimationStatus();
            return;
        }
        this.isAnimating = false;
        invalidate();
    }

    private void updateCurrentDrawable() {
        if (this.isShowingFilledState) {
            this.currentlyDrawingDrawable = this.filledDrawable;
        } else {
            this.currentlyDrawingDrawable = this.outlineDrawable;
        }
        updateDrawingRegion(getMeasuredHeight(), getMeasuredWidth());
    }

    private void updateAnimationStatus() {
        float fCurrentTimeMillis = (System.currentTimeMillis() - this.animationStartTime) / 500.0f;
        if (fCurrentTimeMillis > 1.0f) {
            this.isAnimating = false;
            fCurrentTimeMillis = 1.0f;
        }
        if (getAlpha() < 1.0f) {
            setAlpha(Math.min(0.5f + fCurrentTimeMillis, 1.0f));
        } else {
            setAlpha(1.0f);
        }
        this.scale = this.interpolator.getInterpolation(fCurrentTimeMillis);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        updateDrawingRegion(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i));
        super.onMeasure(i, i2);
    }

    private void updateDrawingRegion(float f, float f2) {
        int i;
        int i2;
        int i3;
        int i4;
        if (f == 0.0f || f2 == 0.0f) {
            return;
        }
        float f3 = f / f2;
        float intrinsicHeight = this.currentlyDrawingDrawable.getIntrinsicHeight() / this.currentlyDrawingDrawable.getIntrinsicWidth();
        float paddingRight = getPaddingRight();
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingBottom = getPaddingBottom();
        if (intrinsicHeight >= f3) {
            float f4 = f - (paddingTop + paddingBottom);
            float f5 = f4 * intrinsicHeight;
            float f6 = f2 / 2.0f;
            float f7 = f5 / 2.0f;
            float f8 = f6 - f7;
            float f9 = f7 + f6;
            float f10 = paddingLeft + paddingRight;
            float f11 = f2 - f5;
            if (f10 > f11) {
                float f12 = f5 - (f10 - f11);
                f4 = f12 * intrinsicHeight;
                float f13 = f12 / 2.0f;
                f8 = f6 - f13;
                f9 = f6 + f13;
            } else if (paddingLeft > f8) {
                float f14 = paddingLeft - f8;
                f8 += f14;
                f9 += f14;
            } else {
                float f15 = f2 - paddingRight;
                if (f15 < f9) {
                    float f16 = f9 - f15;
                    f9 -= f16;
                    f8 -= f16;
                }
            }
            i3 = (int) f8;
            i = (int) f9;
            float f17 = f / 2.0f;
            float f18 = f4 / 2.0f;
            i2 = (int) (f17 - f18);
            i4 = (int) (f17 + f18);
        } else {
            float f19 = f2 - (paddingLeft + paddingRight);
            float f20 = f19 * intrinsicHeight;
            float f21 = f / 2.0f;
            float f22 = f20 / 2.0f;
            float f23 = f21 - f22;
            float f24 = f22 + f21;
            float f25 = paddingTop + paddingBottom;
            float f26 = f - f20;
            if (f25 > f26) {
                float f27 = f20 - (f25 - f26);
                f19 = f27 / intrinsicHeight;
                float f28 = f27 / 2.0f;
                f23 = f21 - f28;
                f24 = f21 + f28;
            } else if (paddingTop > f23) {
                float f29 = paddingTop - f23;
                f23 += f29;
                f24 += f29;
            } else {
                float f30 = f - paddingBottom;
                if (f30 < f24) {
                    float f31 = f24 - f30;
                    f24 -= f31;
                    f23 -= f31;
                }
            }
            float f32 = f2 / 2.0f;
            float f33 = f19 / 2.0f;
            i = (int) (f32 + f33);
            i2 = (int) f23;
            i3 = (int) (f32 - f33);
            i4 = (int) f24;
        }
        Rect rect = this.currentlyDrawingDrawableBound;
        rect.left = i3;
        rect.right = i;
        rect.top = i2;
        rect.bottom = i4;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentlyDrawingDrawable == null) {
            return;
        }
        float f = this.scale;
        canvas.scale(f, f, getWidth() / 2, getHeight() / 2);
        this.currentlyDrawingDrawable.setBounds(this.currentlyDrawingDrawableBound);
        this.currentlyDrawingDrawable.draw(canvas);
        if (this.isAnimating) {
            updateAnimationStatus();
        }
    }

    private void getValuesFromXML(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RGHAnimatedView, 0, 0);
        this.filledDrawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.outlineDrawable = typedArrayObtainStyledAttributes.getDrawable(3);
        this.filledColor = typedArrayObtainStyledAttributes.getColor(1, -12303292);
        this.outlineColor = typedArrayObtainStyledAttributes.getColor(4, -3355444);
        this.isShowingFilledState = typedArrayObtainStyledAttributes.getBoolean(2, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}
