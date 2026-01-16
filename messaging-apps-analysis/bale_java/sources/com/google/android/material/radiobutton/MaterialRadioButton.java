package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC17222mc1;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int g = AbstractC21175tE5.Widget_MaterialComponents_CompoundButton_RadioButton;
    private static final int[][] h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private ColorStateList e;
    private boolean f;

    public MaterialRadioButton(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int iD = WU3.d(this, AbstractC12181eA5.colorControlActivated);
            int iD2 = WU3.d(this, AbstractC12181eA5.colorOnSurface);
            int iD3 = WU3.d(this, AbstractC12181eA5.colorSurface);
            int[][] iArr = h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = WU3.h(iD3, iD, 1.0f);
            iArr2[1] = WU3.h(iD3, iD2, 0.54f);
            iArr2[2] = WU3.h(iD3, iD2, 0.38f);
            iArr2[3] = WU3.h(iD3, iD2, 0.38f);
            this.e = new ColorStateList(iArr, iArr2);
        }
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f && AbstractC17222mc1.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        if (z) {
            AbstractC17222mc1.c(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC17222mc1.c(this, null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i) {
        int i2 = g;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.MaterialRadioButton, i, i2, new int[0]);
        if (typedArrayH.hasValue(GE5.MaterialRadioButton_buttonTint)) {
            AbstractC17222mc1.c(this, AbstractC9751aV3.a(context2, typedArrayH, GE5.MaterialRadioButton_buttonTint));
        }
        this.f = typedArrayH.getBoolean(GE5.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayH.recycle();
    }
}
