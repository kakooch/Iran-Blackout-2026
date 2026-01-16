package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C12054dx6;
import ir.nasim.GE5;
import ir.nasim.InterfaceC4873Gx6;

/* loaded from: classes3.dex */
public class ShapeableImageView extends AppCompatImageView implements InterfaceC4873Gx6 {
    private static final int v = AbstractC21175tE5.Widget_MaterialComponents_ShapeableImageView;
    private final C12054dx6 d;
    private final RectF e;
    private final RectF f;
    private final Paint g;
    private final Paint h;
    private final Path i;
    private ColorStateList j;
    private C10345bV3 k;
    private C11411cx6 l;
    private float m;
    private Path n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;

    class a extends ViewOutlineProvider {
        private final Rect a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.l == null) {
                return;
            }
            if (ShapeableImageView.this.k == null) {
                ShapeableImageView.this.k = new C10345bV3(ShapeableImageView.this.l);
            }
            ShapeableImageView.this.e.round(this.a);
            ShapeableImageView.this.k.setBounds(this.a);
            ShapeableImageView.this.k.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void g(Canvas canvas) {
        if (this.j == null) {
            return;
        }
        this.g.setStrokeWidth(this.m);
        int colorForState = this.j.getColorForState(getDrawableState(), this.j.getDefaultColor());
        if (this.m <= 0.0f || colorForState == 0) {
            return;
        }
        this.g.setColor(colorForState);
        canvas.drawPath(this.i, this.g);
    }

    private boolean h() {
        return (this.s == Integer.MIN_VALUE && this.t == Integer.MIN_VALUE) ? false : true;
    }

    private boolean i() {
        return getLayoutDirection() == 1;
    }

    private void j(int i, int i2) {
        this.e.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
        this.d.d(this.l, 1.0f, this.e, this.i);
        this.n.rewind();
        this.n.addPath(this.i);
        this.f.set(0.0f, 0.0f, i, i2);
        this.n.addRect(this.f, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.r;
    }

    public final int getContentPaddingEnd() {
        int i = this.t;
        return i != Integer.MIN_VALUE ? i : i() ? this.o : this.q;
    }

    public int getContentPaddingLeft() {
        int i;
        int i2;
        if (h()) {
            if (i() && (i2 = this.t) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!i() && (i = this.s) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.o;
    }

    public int getContentPaddingRight() {
        int i;
        int i2;
        if (h()) {
            if (i() && (i2 = this.s) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!i() && (i = this.t) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.q;
    }

    public final int getContentPaddingStart() {
        int i = this.s;
        return i != Integer.MIN_VALUE ? i : i() ? this.q : this.o;
    }

    public int getContentPaddingTop() {
        return this.p;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public C11411cx6 getShapeAppearanceModel() {
        return this.l;
    }

    public ColorStateList getStrokeColor() {
        return this.j;
    }

    public float getStrokeWidth() {
        return this.m;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.n, this.h);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.u && isLayoutDirectionResolved()) {
            this.u = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        j(i, i2);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.s = RecyclerView.UNDEFINED_DURATION;
        this.t = RecyclerView.UNDEFINED_DURATION;
        super.setPadding((super.getPaddingLeft() - this.o) + i, (super.getPaddingTop() - this.p) + i2, (super.getPaddingRight() - this.q) + i3, (super.getPaddingBottom() - this.r) + i4);
        this.o = i;
        this.p = i2;
        this.q = i3;
        this.r = i4;
    }

    public void setContentPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i, (super.getPaddingTop() - this.p) + i2, (super.getPaddingEnd() - getContentPaddingEnd()) + i3, (super.getPaddingBottom() - this.r) + i4);
        this.o = i() ? i3 : i;
        this.p = i2;
        if (!i()) {
            i = i3;
        }
        this.q = i;
        this.r = i4;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i + getContentPaddingLeft(), i2 + getContentPaddingTop(), i3 + getContentPaddingRight(), i4 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i + getContentPaddingStart(), i2 + getContentPaddingTop(), i3 + getContentPaddingEnd(), i4 + getContentPaddingBottom());
    }

    @Override // ir.nasim.InterfaceC4873Gx6
    public void setShapeAppearanceModel(C11411cx6 c11411cx6) {
        this.l = c11411cx6;
        C10345bV3 c10345bV3 = this.k;
        if (c10345bV3 != null) {
            c10345bV3.setShapeAppearanceModel(c11411cx6);
        }
        j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(AbstractC9594aE.a(getContext(), i));
    }

    public void setStrokeWidth(float f) {
        if (this.m != f) {
            this.m = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, AttributeSet attributeSet, int i) {
        int i2 = v;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        this.d = C12054dx6.k();
        this.i = new Path();
        this.u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.e = new RectF();
        this.f = new RectF();
        this.n = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, GE5.ShapeableImageView, i, i2);
        this.j = AbstractC9751aV3.a(context2, typedArrayObtainStyledAttributes, GE5.ShapeableImageView_strokeColor);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPadding, 0);
        this.o = dimensionPixelSize;
        this.p = dimensionPixelSize;
        this.q = dimensionPixelSize;
        this.r = dimensionPixelSize;
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPaddingStart, RecyclerView.UNDEFINED_DURATION);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ShapeableImageView_contentPaddingEnd, RecyclerView.UNDEFINED_DURATION);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.l = C11411cx6.e(context2, attributeSet, i, i2).m();
        setOutlineProvider(new a());
    }
}
