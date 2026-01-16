package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
public final class LinearProgressIndicatorSpec extends a {
    public int g;
    public int h;
    boolean i;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.a
    void e() {
        if (this.g == 0) {
            if (this.b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, LinearProgressIndicator.p);
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, attributeSet, GE5.LinearProgressIndicator, AbstractC12181eA5.linearProgressIndicatorStyle, LinearProgressIndicator.p, new int[0]);
        this.g = typedArrayH.getInt(GE5.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.h = typedArrayH.getInt(GE5.LinearProgressIndicator_indicatorDirectionLinear, 0);
        typedArrayH.recycle();
        e();
        this.i = this.h == 1;
    }
}
