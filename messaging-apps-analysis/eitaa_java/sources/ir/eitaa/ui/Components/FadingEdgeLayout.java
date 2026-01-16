package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class FadingEdgeLayout extends FrameLayout {
    private static final int[] FADE_COLORS = {0, -16777216};
    private static final int[] FADE_COLORS_REVERSE = {-16777216, 0};
    private boolean fadeBottom;
    private boolean fadeLeft;
    private boolean fadeRight;
    private boolean fadeTop;
    private int gradientDirtyFlags;
    private Paint gradientPaintBottom;
    private Paint gradientPaintLeft;
    private Paint gradientPaintRight;
    private Paint gradientPaintTop;
    private android.graphics.Rect gradientRectBottom;
    private android.graphics.Rect gradientRectLeft;
    private android.graphics.Rect gradientRectRight;
    private android.graphics.Rect gradientRectTop;
    private int gradientSizeBottom;
    private int gradientSizeLeft;
    private int gradientSizeRight;
    private int gradientSizeTop;

    public FadingEdgeLayout(Context context) {
        super(context);
        init(null, 0);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        int iApplyDimension = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        if (attrs == null) {
            this.gradientSizeRight = iApplyDimension;
            this.gradientSizeLeft = iApplyDimension;
            this.gradientSizeBottom = iApplyDimension;
            this.gradientSizeTop = iApplyDimension;
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Paint paint = new Paint(1);
        this.gradientPaintTop = paint;
        paint.setXfermode(porterDuffXfermode);
        Paint paint2 = new Paint(1);
        this.gradientPaintBottom = paint2;
        paint2.setXfermode(porterDuffXfermode);
        Paint paint3 = new Paint(1);
        this.gradientPaintLeft = paint3;
        paint3.setXfermode(porterDuffXfermode);
        Paint paint4 = new Paint(1);
        this.gradientPaintRight = paint4;
        paint4.setXfermode(porterDuffXfermode);
        this.gradientRectTop = new android.graphics.Rect();
        this.gradientRectLeft = new android.graphics.Rect();
        this.gradientRectBottom = new android.graphics.Rect();
        this.gradientRectRight = new android.graphics.Rect();
    }

    public void setFadeSizes(int top, int left, int bottom, int right) {
        if (this.gradientSizeTop != top) {
            this.gradientSizeTop = top;
            this.gradientDirtyFlags |= 1;
        }
        if (this.gradientSizeLeft != left) {
            this.gradientSizeLeft = left;
            this.gradientDirtyFlags |= 4;
        }
        if (this.gradientSizeBottom != bottom) {
            this.gradientSizeBottom = bottom;
            this.gradientDirtyFlags |= 2;
        }
        if (this.gradientSizeRight != right) {
            this.gradientSizeRight = right;
            this.gradientDirtyFlags |= 8;
        }
        if (this.gradientDirtyFlags != 0) {
            invalidate();
        }
    }

    public void setFadeEdges(boolean fadeTop, boolean fadeLeft, boolean fadeBottom, boolean fadeRight) {
        if (this.fadeTop != fadeTop) {
            this.fadeTop = fadeTop;
            this.gradientDirtyFlags |= 1;
        }
        if (this.fadeLeft != fadeLeft) {
            this.fadeLeft = fadeLeft;
            this.gradientDirtyFlags |= 4;
        }
        if (this.fadeBottom != fadeBottom) {
            this.fadeBottom = fadeBottom;
            this.gradientDirtyFlags |= 2;
        }
        if (this.fadeRight != fadeRight) {
            this.fadeRight = fadeRight;
            this.gradientDirtyFlags |= 8;
        }
        if (this.gradientDirtyFlags != 0) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        if (getPaddingLeft() != left) {
            this.gradientDirtyFlags |= 4;
        }
        if (getPaddingTop() != top) {
            this.gradientDirtyFlags |= 1;
        }
        if (getPaddingRight() != right) {
            this.gradientDirtyFlags |= 8;
        }
        if (getPaddingBottom() != bottom) {
            this.gradientDirtyFlags |= 2;
        }
        super.setPadding(left, top, right, bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            int i = this.gradientDirtyFlags | 4;
            this.gradientDirtyFlags = i;
            this.gradientDirtyFlags = i | 8;
        }
        if (h != oldh) {
            int i2 = this.gradientDirtyFlags | 1;
            this.gradientDirtyFlags = i2;
            this.gradientDirtyFlags = i2 | 2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        boolean z = this.fadeTop || this.fadeBottom || this.fadeLeft || this.fadeRight;
        if (getVisibility() == 8 || width == 0 || height == 0 || !z) {
            super.dispatchDraw(canvas);
            return;
        }
        int i = this.gradientDirtyFlags;
        if ((i & 1) == 1) {
            this.gradientDirtyFlags = i & (-2);
            initTopGradient();
        }
        int i2 = this.gradientDirtyFlags;
        if ((i2 & 4) == 4) {
            this.gradientDirtyFlags = i2 & (-5);
            initLeftGradient();
        }
        int i3 = this.gradientDirtyFlags;
        if ((i3 & 2) == 2) {
            this.gradientDirtyFlags = i3 & (-3);
            initBottomGradient();
        }
        int i4 = this.gradientDirtyFlags;
        if ((i4 & 8) == 8) {
            this.gradientDirtyFlags = i4 & (-9);
            initRightGradient();
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        if (this.fadeTop && this.gradientSizeTop > 0) {
            canvas.drawRect(this.gradientRectTop, this.gradientPaintTop);
        }
        if (this.fadeBottom && this.gradientSizeBottom > 0) {
            canvas.drawRect(this.gradientRectBottom, this.gradientPaintBottom);
        }
        if (this.fadeLeft && this.gradientSizeLeft > 0) {
            canvas.drawRect(this.gradientRectLeft, this.gradientPaintLeft);
        }
        if (this.fadeRight && this.gradientSizeRight > 0) {
            canvas.drawRect(this.gradientRectRight, this.gradientPaintRight);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    private void initTopGradient() {
        int iMin = Math.min(this.gradientSizeTop, (getHeight() - getPaddingTop()) - getPaddingBottom());
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = iMin + paddingTop;
        this.gradientRectTop.set(paddingLeft, paddingTop, getWidth() - getPaddingRight(), i);
        float f = paddingLeft;
        this.gradientPaintTop.setShader(new LinearGradient(f, paddingTop, f, i, FADE_COLORS, (float[]) null, Shader.TileMode.CLAMP));
    }

    private void initLeftGradient() {
        int iMin = Math.min(this.gradientSizeLeft, (getWidth() - getPaddingLeft()) - getPaddingRight());
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = iMin + paddingLeft;
        this.gradientRectLeft.set(paddingLeft, paddingTop, i, getHeight() - getPaddingBottom());
        float f = paddingTop;
        this.gradientPaintLeft.setShader(new LinearGradient(paddingLeft, f, i, f, FADE_COLORS, (float[]) null, Shader.TileMode.CLAMP));
    }

    private void initBottomGradient() {
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int iMin = Math.min(this.gradientSizeBottom, height);
        int paddingLeft = getPaddingLeft();
        int paddingTop = (getPaddingTop() + height) - iMin;
        int i = iMin + paddingTop;
        this.gradientRectBottom.set(paddingLeft, paddingTop, getWidth() - getPaddingRight(), i);
        float f = paddingLeft;
        this.gradientPaintBottom.setShader(new LinearGradient(f, paddingTop, f, i, FADE_COLORS_REVERSE, (float[]) null, Shader.TileMode.CLAMP));
    }

    private void initRightGradient() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int iMin = Math.min(this.gradientSizeRight, width);
        int paddingLeft = (getPaddingLeft() + width) - iMin;
        int paddingTop = getPaddingTop();
        int i = iMin + paddingLeft;
        this.gradientRectRight.set(paddingLeft, paddingTop, i, getHeight() - getPaddingBottom());
        float f = paddingTop;
        this.gradientPaintRight.setShader(new LinearGradient(paddingLeft, f, i, f, FADE_COLORS_REVERSE, (float[]) null, Shader.TileMode.CLAMP));
    }
}
