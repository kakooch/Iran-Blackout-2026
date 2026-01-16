package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
final class a {
    private final Rect a;
    private final ColorStateList b;
    private final ColorStateList c;
    private final ColorStateList d;
    private final int e;
    private final C11411cx6 f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, C11411cx6 c11411cx6, Rect rect) {
        AbstractC4980Hj5.d(rect.left);
        AbstractC4980Hj5.d(rect.top);
        AbstractC4980Hj5.d(rect.right);
        AbstractC4980Hj5.d(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f = c11411cx6;
    }

    static a a(Context context, int i) throws Resources.NotFoundException {
        AbstractC4980Hj5.b(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, GE5.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(GE5.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(GE5.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(GE5.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(GE5.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.MaterialCalendarItem_itemStrokeWidth, 0);
        C11411cx6 c11411cx6M = C11411cx6.b(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, c11411cx6M, rect);
    }

    void b(TextView textView) {
        C10345bV3 c10345bV3 = new C10345bV3();
        C10345bV3 c10345bV32 = new C10345bV3();
        c10345bV3.setShapeAppearanceModel(this.f);
        c10345bV32.setShapeAppearanceModel(this.f);
        c10345bV3.b0(this.c);
        c10345bV3.k0(this.e, this.d);
        textView.setTextColor(this.b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.b.withAlpha(30), c10345bV3, c10345bV32);
        Rect rect = this.a;
        AbstractC12990fW7.t0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
