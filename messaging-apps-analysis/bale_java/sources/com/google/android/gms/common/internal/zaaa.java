package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import ir.nasim.AbstractC20013rK1;
import ir.nasim.AbstractC21166tD5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.GB5;
import ir.nasim.PA5;

/* loaded from: classes3.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int b(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        throw new IllegalStateException("Unknown color scheme: " + i);
    }

    public final void a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = GB5.common_google_signin_btn_icon_dark;
        int i5 = GB5.common_google_signin_btn_icon_light;
        int iB = b(i2, i4, i5, i5);
        int i6 = GB5.common_google_signin_btn_text_dark;
        int i7 = GB5.common_google_signin_btn_text_light;
        int iB2 = b(i2, i6, i7, i7);
        if (i == 0 || i == 1) {
            iB = iB2;
        } else if (i != 2) {
            throw new IllegalStateException("Unknown button size: " + i);
        }
        Drawable drawableL = AbstractC21710u02.l(resources.getDrawable(iB));
        AbstractC21710u02.i(drawableL, resources.getColorStateList(PA5.common_google_signin_btn_tint));
        AbstractC21710u02.j(drawableL, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawableL);
        int i8 = PA5.common_google_signin_btn_text_dark;
        int i9 = PA5.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) AbstractC3795Cj5.j(resources.getColorStateList(b(i2, i8, i9, i9))));
        if (i == 0) {
            setText(resources.getString(AbstractC21166tD5.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(AbstractC21166tD5.common_signin_button_text_long));
        } else {
            if (i != 2) {
                throw new IllegalStateException("Unknown button size: " + i);
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (AbstractC20013rK1.c(getContext())) {
            setGravity(19);
        }
    }
}
