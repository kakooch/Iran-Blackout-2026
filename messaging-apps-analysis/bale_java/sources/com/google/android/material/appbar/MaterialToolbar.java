package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC5288Ir7;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.C10345bV3;
import ir.nasim.GE5;

/* loaded from: classes3.dex */
public class MaterialToolbar extends Toolbar {
    private static final int S0 = AbstractC21175tE5.Widget_MaterialComponents_Toolbar;
    private static final ImageView.ScaleType[] T0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Integer N0;
    private boolean O0;
    private boolean P0;
    private ImageView.ScaleType Q0;
    private Boolean R0;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    private Pair P(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void Q(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            C10345bV3 c10345bV3 = new C10345bV3();
            c10345bV3.b0(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            c10345bV3.Q(context);
            c10345bV3.a0(AbstractC12990fW7.v(this));
            AbstractC12990fW7.t0(this, c10345bV3);
        }
    }

    private void R(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    private void S() {
        if (this.O0 || this.P0) {
            TextView textViewE = AbstractC5288Ir7.e(this);
            TextView textViewC = AbstractC5288Ir7.c(this);
            if (textViewE == null && textViewC == null) {
                return;
            }
            Pair pairP = P(textViewE, textViewC);
            if (this.O0 && textViewE != null) {
                R(textViewE, pairP);
            }
            if (!this.P0 || textViewC == null) {
                return;
            }
            R(textViewC, pairP);
        }
    }

    private Drawable T(Drawable drawable) {
        if (drawable == null || this.N0 == null) {
            return drawable;
        }
        Drawable drawableL = AbstractC21710u02.l(drawable.mutate());
        AbstractC21710u02.h(drawableL, this.N0.intValue());
        return drawableL;
    }

    private void U() {
        ImageView imageViewB = AbstractC5288Ir7.b(this);
        if (imageViewB != null) {
            Boolean bool = this.R0;
            if (bool != null) {
                imageViewB.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.Q0;
            if (scaleType != null) {
                imageViewB.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.Q0;
    }

    public Integer getNavigationIconTint() {
        return this.N0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC10961cV3.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        S();
        U();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC10961cV3.d(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.R0;
        if (bool == null || bool.booleanValue() != z) {
            this.R0 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.Q0 != scaleType) {
            this.Q0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(T(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.N0 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.P0 != z) {
            this.P0 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.O0 != z) {
            this.O0 = z;
            requestLayout();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        int i2 = S0;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.MaterialToolbar, i, i2, new int[0]);
        if (typedArrayH.hasValue(GE5.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayH.getColor(GE5.MaterialToolbar_navigationIconTint, -1));
        }
        this.O0 = typedArrayH.getBoolean(GE5.MaterialToolbar_titleCentered, false);
        this.P0 = typedArrayH.getBoolean(GE5.MaterialToolbar_subtitleCentered, false);
        int i3 = typedArrayH.getInt(GE5.MaterialToolbar_logoScaleType, -1);
        if (i3 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = T0;
            if (i3 < scaleTypeArr.length) {
                this.Q0 = scaleTypeArr[i3];
            }
        }
        if (typedArrayH.hasValue(GE5.MaterialToolbar_logoAdjustViewBounds)) {
            this.R0 = Boolean.valueOf(typedArrayH.getBoolean(GE5.MaterialToolbar_logoAdjustViewBounds, false));
        }
        typedArrayH.recycle();
        Q(context2);
    }
}
