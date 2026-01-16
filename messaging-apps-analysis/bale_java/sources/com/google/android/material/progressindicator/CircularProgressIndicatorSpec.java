package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
public final class CircularProgressIndicatorSpec extends a {
    public int g;
    public int h;
    public int i;

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.a
    void e() {
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, CircularProgressIndicator.p);
    }

    public CircularProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i, i2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, attributeSet, GE5.CircularProgressIndicator, i, i2, new int[0]);
        this.g = Math.max(AbstractC9751aV3.d(context, typedArrayH, GE5.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.a * 2);
        this.h = AbstractC9751aV3.d(context, typedArrayH, GE5.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.i = typedArrayH.getInt(GE5.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayH.recycle();
        e();
    }
}
