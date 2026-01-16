package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.GE5;
import ir.nasim.I52;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int R0 = AbstractC21175tE5.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] S0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private final I52 N0;
    private ColorStateList O0;
    private ColorStateList P0;
    private boolean Q0;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() throws Resources.NotFoundException {
        if (this.O0 == null) {
            int iD = WU3.d(this, AbstractC12181eA5.colorSurface);
            int iD2 = WU3.d(this, AbstractC12181eA5.colorControlActivated);
            float dimension = getResources().getDimension(AbstractC12799fB5.mtrl_switch_thumb_elevation);
            if (this.N0.e()) {
                dimension += AbstractC10402bY7.i(this);
            }
            int iC = this.N0.c(iD, dimension);
            int[][] iArr = S0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = WU3.h(iD, iD2, 1.0f);
            iArr2[1] = iC;
            iArr2[2] = WU3.h(iD, iD2, 0.38f);
            iArr2[3] = iC;
            this.O0 = new ColorStateList(iArr, iArr2);
        }
        return this.O0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.P0 == null) {
            int[][] iArr = S0;
            int[] iArr2 = new int[iArr.length];
            int iD = WU3.d(this, AbstractC12181eA5.colorSurface);
            int iD2 = WU3.d(this, AbstractC12181eA5.colorControlActivated);
            int iD3 = WU3.d(this, AbstractC12181eA5.colorOnSurface);
            iArr2[0] = WU3.h(iD, iD2, 0.54f);
            iArr2[1] = WU3.h(iD, iD3, 0.32f);
            iArr2[2] = WU3.h(iD, iD2, 0.12f);
            iArr2[3] = WU3.h(iD, iD3, 0.12f);
            this.P0 = new ColorStateList(iArr, iArr2);
        }
        return this.P0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Q0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.Q0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.Q0 = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(Context context, AttributeSet attributeSet, int i) {
        int i2 = R0;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        this.N0 = new I52(context2);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.SwitchMaterial, i, i2, new int[0]);
        this.Q0 = typedArrayH.getBoolean(GE5.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayH.recycle();
    }
}
