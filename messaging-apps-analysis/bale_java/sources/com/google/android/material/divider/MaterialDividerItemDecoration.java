package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
public class MaterialDividerItemDecoration extends RecyclerView.o {
    private static final int i = AbstractC21175tE5.Widget_MaterialComponents_MaterialDivider;
    private Drawable a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private final Rect h;

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, AbstractC12181eA5.materialDividerStyle, i2);
    }

    private void l(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int i2 = paddingTop + this.e;
        int i3 = height - this.f;
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getLayoutManager().Q(childAt, this.h);
            int iRound = this.h.right + Math.round(childAt.getTranslationX());
            this.a.setBounds((iRound - this.a.getIntrinsicWidth()) - this.b, i2, iRound, i3);
            this.a.draw(canvas);
        }
        canvas.restore();
    }

    private void m(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        boolean z = AbstractC12990fW7.A(recyclerView) == 1;
        int i2 = paddingLeft + (z ? this.f : this.e);
        int i3 = width - (z ? this.e : this.f);
        int childCount = recyclerView.getChildCount();
        if (!this.g) {
            childCount--;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.h);
            int iRound = this.h.bottom + Math.round(childAt.getTranslationY());
            this.a.setBounds(i2, (iRound - this.a.getIntrinsicHeight()) - this.b, i3, iRound);
            this.a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.set(0, 0, 0, 0);
        if (this.d == 1) {
            rect.bottom = this.a.getIntrinsicHeight() + this.b;
        } else {
            rect.right = this.a.getIntrinsicWidth() + this.b;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.d == 1) {
            m(canvas, recyclerView);
        } else {
            l(canvas, recyclerView);
        }
    }

    public void n(int i2) {
        this.c = i2;
        Drawable drawableL = AbstractC21710u02.l(this.a);
        this.a = drawableL;
        AbstractC21710u02.h(drawableL, i2);
    }

    public void o(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i2 + ". It should be either HORIZONTAL or VERTICAL");
    }

    public MaterialDividerItemDecoration(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.h = new Rect();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, attributeSet, GE5.MaterialDivider, i2, i, new int[0]);
        this.c = AbstractC9751aV3.a(context, typedArrayH, GE5.MaterialDivider_dividerColor).getDefaultColor();
        this.b = typedArrayH.getDimensionPixelSize(GE5.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(AbstractC12799fB5.material_divider_thickness));
        this.e = typedArrayH.getDimensionPixelOffset(GE5.MaterialDivider_dividerInsetStart, 0);
        this.f = typedArrayH.getDimensionPixelOffset(GE5.MaterialDivider_dividerInsetEnd, 0);
        this.g = typedArrayH.getBoolean(GE5.MaterialDivider_lastItemDecorated, true);
        typedArrayH.recycle();
        this.a = new ShapeDrawable();
        n(this.c);
        o(i3);
    }
}
