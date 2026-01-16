package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.O98;
import ir.nasim.YK2;
import java.util.List;

/* loaded from: classes3.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect d;
    final Rect e;
    private int f;
    private int g;

    public HeaderScrollingViewBehavior() {
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    private static int N(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void F(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewH = H(coordinatorLayout.u(view));
        if (viewH == null) {
            super.F(coordinatorLayout, view, i);
            this.f = 0;
            return;
        }
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
        Rect rect = this.d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, viewH.getBottom() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((coordinatorLayout.getHeight() + viewH.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        O98 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && AbstractC12990fW7.x(coordinatorLayout) && !AbstractC12990fW7.x(view)) {
            rect.left += lastWindowInsets.k();
            rect.right -= lastWindowInsets.l();
        }
        Rect rect2 = this.e;
        YK2.a(N(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int I = I(viewH);
        view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
        this.f = rect2.top - viewH.getBottom();
    }

    abstract View H(List list);

    final int I(View view) {
        if (this.g == 0) {
            return 0;
        }
        float fJ = J(view);
        int i = this.g;
        return AbstractC22000uV3.b((int) (fJ * i), 0, i);
    }

    float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.g;
    }

    int L(View view) {
        return view.getMeasuredHeight();
    }

    final int M() {
        return this.f;
    }

    public final void O(int i) {
        this.g = i;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewH;
        O98 lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewH = H(coordinatorLayout.u(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (AbstractC12990fW7.x(viewH) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.m() + lastWindowInsets.j();
        }
        int iL = size + L(viewH);
        int measuredHeight = viewH.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iL -= measuredHeight;
        }
        coordinatorLayout.N(view, i, i2, View.MeasureSpec.makeMeasureSpec(iL, i5 == -1 ? 1073741824 : RecyclerView.UNDEFINED_DURATION), i4);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }
}
