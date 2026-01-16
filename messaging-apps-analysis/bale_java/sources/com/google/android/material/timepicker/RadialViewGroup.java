package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.C10345bV3;
import ir.nasim.GE5;
import ir.nasim.JM5;
import ir.nasim.WB5;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
class RadialViewGroup extends ConstraintLayout {
    private C10345bV3 A;
    private final Runnable y;
    private int z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialViewGroup.this.h0();
        }
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Drawable d0() {
        C10345bV3 c10345bV3 = new C10345bV3();
        this.A = c10345bV3;
        c10345bV3.Z(new JM5(0.5f));
        this.A.b0(ColorStateList.valueOf(-1));
        return this.A;
    }

    private static boolean g0(View view) {
        return "skip".equals(view.getTag());
    }

    private void i0() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.y);
            handler.post(this.y);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(AbstractC12990fW7.k());
        }
        i0();
    }

    public int e0() {
        return this.z;
    }

    public void f0(int i) {
        this.z = i;
        h0();
    }

    protected void h0() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (g0(getChildAt(i2))) {
                i++;
            }
        }
        c cVar = new c();
        cVar.p(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != WB5.circle_center && !g0(childAt)) {
                cVar.u(childAt.getId(), WB5.circle_center, this.z, f);
                f += 360.0f / (childCount - i);
            }
        }
        cVar.i(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        h0();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        i0();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.A.b0(ColorStateList.valueOf(i));
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(YC5.material_radial_view_group, this);
        AbstractC12990fW7.t0(this, d0());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.RadialViewGroup, i, 0);
        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.RadialViewGroup_materialCircleRadius, 0);
        this.y = new a();
        typedArrayObtainStyledAttributes.recycle();
    }
}
