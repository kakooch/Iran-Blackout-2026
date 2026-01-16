package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC17222mc1;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int h = AbstractC21175tE5.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] i = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    private ColorStateList e;
    private boolean f;
    private boolean g;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int[][] iArr = i;
            int[] iArr2 = new int[iArr.length];
            int iD = WU3.d(this, AbstractC12181eA5.colorControlActivated);
            int iD2 = WU3.d(this, AbstractC12181eA5.colorSurface);
            int iD3 = WU3.d(this, AbstractC12181eA5.colorOnSurface);
            iArr2[0] = WU3.h(iD2, iD, 1.0f);
            iArr2[1] = WU3.h(iD2, iD3, 0.54f);
            iArr2[2] = WU3.h(iD2, iD3, 0.38f);
            iArr2[3] = WU3.h(iD2, iD3, 0.38f);
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.g || !TextUtils.isEmpty(getText()) || (drawableA = AbstractC17222mc1.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (AbstractC10402bY7.j(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            AbstractC21710u02.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.g = z;
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        if (z) {
            AbstractC17222mc1.c(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC17222mc1.c(this, null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i2) {
        int i3 = h;
        super(AbstractC17750nV3.c(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.MaterialCheckBox, i2, i3, new int[0]);
        if (typedArrayH.hasValue(GE5.MaterialCheckBox_buttonTint)) {
            AbstractC17222mc1.c(this, AbstractC9751aV3.a(context2, typedArrayH, GE5.MaterialCheckBox_buttonTint));
        }
        this.f = typedArrayH.getBoolean(GE5.MaterialCheckBox_useMaterialThemeColors, false);
        this.g = typedArrayH.getBoolean(GE5.MaterialCheckBox_centerIfNoTextEnabled, true);
        typedArrayH.recycle();
    }
}
