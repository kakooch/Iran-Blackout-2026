package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
public class MaterialDivider extends View {
    private static final int f = AbstractC21175tE5.Widget_MaterialComponents_MaterialDivider;
    private final C10345bV3 a;
    private int b;
    private int c;
    private int d;
    private int e;

    public MaterialDivider(Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.c;
    }

    public int getDividerInsetEnd() {
        return this.e;
    }

    public int getDividerInsetStart() {
        return this.d;
    }

    public int getDividerThickness() {
        return this.b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z = AbstractC12990fW7.A(this) == 1;
        int i2 = z ? this.e : this.d;
        if (z) {
            width = getWidth();
            i = this.d;
        } else {
            width = getWidth();
            i = this.e;
        }
        this.a.setBounds(i2, 0, width - i, getBottom() - getTop());
        this.a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.b;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i) {
        if (this.c != i) {
            this.c = i;
            this.a.b0(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    public void setDividerColorResource(int i) {
        setDividerColor(AbstractC4043Dl1.c(getContext(), i));
    }

    public void setDividerInsetEnd(int i) {
        this.e = i;
    }

    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerInsetStart(int i) {
        this.d = i;
    }

    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerThickness(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(Context context, AttributeSet attributeSet, int i) {
        int i2 = f;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        this.a = new C10345bV3();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.MaterialDivider, i, i2, new int[0]);
        this.b = typedArrayH.getDimensionPixelSize(GE5.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(AbstractC12799fB5.material_divider_thickness));
        this.d = typedArrayH.getDimensionPixelOffset(GE5.MaterialDivider_dividerInsetStart, 0);
        this.e = typedArrayH.getDimensionPixelOffset(GE5.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(AbstractC9751aV3.a(context2, typedArrayH, GE5.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayH.recycle();
    }
}
