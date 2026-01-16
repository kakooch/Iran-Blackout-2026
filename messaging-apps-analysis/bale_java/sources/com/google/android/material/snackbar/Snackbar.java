package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.InterfaceC22153ul1;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
public class Snackbar extends BaseTransientBottomBar {
    private static final int[] A;
    private static final int[] z;
    private final AccessibilityManager x;
    private boolean y;

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static {
        int i = AbstractC12181eA5.snackbarButtonStyle;
        z = new int[]{i};
        A = new int[]{i, AbstractC12181eA5.snackbarTextViewStyle};
    }

    private Snackbar(Context context, ViewGroup viewGroup, View view, InterfaceC22153ul1 interfaceC22153ul1) {
        super(context, viewGroup, view, interfaceC22153ul1);
        this.x = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup e0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private SnackbarContentLayout f0() {
        return (SnackbarContentLayout) this.c.getChildAt(0);
    }

    private TextView g0() {
        return f0().getMessageView();
    }

    private static boolean h0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(A);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    public static Snackbar i0(View view, CharSequence charSequence, int i) {
        return j0(null, view, charSequence, i);
    }

    private static Snackbar j0(Context context, View view, CharSequence charSequence, int i) {
        ViewGroup viewGroupE0 = e0(view);
        if (viewGroupE0 == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupE0.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(h0(context) ? YC5.mtrl_layout_snackbar_include : YC5.design_layout_snackbar_include, viewGroupE0, false);
        Snackbar snackbar = new Snackbar(context, viewGroupE0, snackbarContentLayout, snackbarContentLayout);
        snackbar.m0(charSequence);
        snackbar.S(i);
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean H() {
        return super.H();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void W() {
        super.W();
    }

    public Snackbar k0(int i) {
        return l0(ColorStateList.valueOf(i));
    }

    public Snackbar l0(ColorStateList colorStateList) {
        this.c.setBackgroundTintList(colorStateList);
        return this;
    }

    public Snackbar m0(CharSequence charSequence) {
        g0().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void t() {
        super.t();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int x() {
        int iX = super.x();
        if (iX == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.x.getRecommendedTimeoutMillis(iX, (this.y ? 4 : 0) | 3);
        }
        if (this.y && this.x.isTouchExplorationEnabled()) {
            return -2;
        }
        return iX;
    }
}
