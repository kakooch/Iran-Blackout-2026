package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;
import ir.nasim.UU3;

/* loaded from: classes3.dex */
final class b {
    final a a;
    final a b;
    final a c;
    final a d;
    final a e;
    final a f;
    final a g;
    final Paint h;

    b(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(UU3.d(context, AbstractC12181eA5.materialCalendarStyle, e.class.getCanonicalName()), GE5.MaterialCalendar);
        this.a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_dayStyle, 0));
        this.g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_dayInvalidStyle, 0));
        this.b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_daySelectedStyle, 0));
        this.c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.MaterialCalendar_rangeFillColor);
        this.d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_yearStyle, 0));
        this.e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_yearSelectedStyle, 0));
        this.f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
