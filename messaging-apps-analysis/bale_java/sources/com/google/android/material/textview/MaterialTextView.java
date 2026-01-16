package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.GE5;
import ir.nasim.UU3;

/* loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    private void r(Resources.Theme theme, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, GE5.MaterialTextAppearance);
        int iU = u(getContext(), typedArrayObtainStyledAttributes, GE5.MaterialTextAppearance_android_lineHeight, GE5.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iU >= 0) {
            setLineHeight(iU);
        }
    }

    private static boolean s(Context context) {
        return UU3.b(context, AbstractC12181eA5.textAppearanceLineHeightEnabled, true);
    }

    private static int t(Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, GE5.MaterialTextView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(GE5.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int u(Context context, TypedArray typedArray, int... iArr) {
        int iD = -1;
        for (int i = 0; i < iArr.length && iD < 0; i++) {
            iD = AbstractC9751aV3.d(context, typedArray, iArr[i], -1);
        }
        return iD;
    }

    private static boolean v(Context context, Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, GE5.MaterialTextView, i, i2);
        int iU = u(context, typedArrayObtainStyledAttributes, GE5.MaterialTextView_android_lineHeight, GE5.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iU != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) throws Resources.NotFoundException {
        super.setTextAppearance(context, i);
        if (s(context)) {
            r(context.getTheme(), i);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        int iT;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        if (s(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (v(context2, theme, attributeSet, i, i2) || (iT = t(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            r(theme, iT);
        }
    }
}
