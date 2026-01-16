package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.CheckableImageButton;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21710u02;
import java.util.Arrays;

/* loaded from: classes3.dex */
abstract class f {
    static void a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = AbstractC21710u02.l(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                AbstractC21710u02.i(drawable, colorStateList);
            } else {
                AbstractC21710u02.i(drawable, ColorStateList.valueOf(colorStateList.getColorForState(b(textInputLayout, checkableImageButton), colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                AbstractC21710u02.j(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static int[] b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton) {
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    static void c(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(b(textInputLayout, checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = AbstractC21710u02.l(drawable).mutate();
        AbstractC21710u02.i(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    private static void d(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zO = AbstractC12990fW7.O(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zO || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zO);
        checkableImageButton.setPressable(zO);
        checkableImageButton.setLongClickable(z);
        AbstractC12990fW7.A0(checkableImageButton, z2 ? 1 : 2);
    }

    static void e(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        d(checkableImageButton, onLongClickListener);
    }

    static void f(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        d(checkableImageButton, onLongClickListener);
    }
}
