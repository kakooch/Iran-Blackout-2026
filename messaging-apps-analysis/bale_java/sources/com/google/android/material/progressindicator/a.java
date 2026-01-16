package com.google.android.material.progressindicator;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
public abstract class a {
    public int a;
    public int b;
    public int[] c = new int[0];
    public int d;
    public int e;
    public int f;

    protected a(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_progress_track_thickness);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, attributeSet, GE5.BaseProgressIndicator, i, i2, new int[0]);
        this.a = AbstractC9751aV3.d(context, typedArrayH, GE5.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(AbstractC9751aV3.d(context, typedArrayH, GE5.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.e = typedArrayH.getInt(GE5.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f = typedArrayH.getInt(GE5.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(context, typedArrayH);
        d(context, typedArrayH);
        typedArrayH.recycle();
    }

    private void c(Context context, TypedArray typedArray) throws Resources.NotFoundException {
        if (!typedArray.hasValue(GE5.BaseProgressIndicator_indicatorColor)) {
            this.c = new int[]{WU3.b(context, AbstractC12181eA5.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(GE5.BaseProgressIndicator_indicatorColor).type != 1) {
            this.c = new int[]{typedArray.getColor(GE5.BaseProgressIndicator_indicatorColor, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(GE5.BaseProgressIndicator_indicatorColor, -1));
        this.c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(Context context, TypedArray typedArray) {
        if (typedArray.hasValue(GE5.BaseProgressIndicator_trackColor)) {
            this.d = typedArray.getColor(GE5.BaseProgressIndicator_trackColor, -1);
            return;
        }
        this.d = this.c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.d = WU3.a(this.d, (int) (f * 255.0f));
    }

    public boolean a() {
        return this.f != 0;
    }

    public boolean b() {
        return this.e != 0;
    }

    abstract void e();
}
