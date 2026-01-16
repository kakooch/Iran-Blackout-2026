package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationBarView;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.GE5;
import ir.nasim.O98;

/* loaded from: classes3.dex */
public class NavigationRailView extends NavigationBarView {
    private final int f;
    private View g;
    private Boolean h;
    private Boolean i;

    class a implements AbstractC10402bY7.e {
        a() {
        }

        @Override // ir.nasim.AbstractC10402bY7.e
        public O98 a(View view, O98 o98, AbstractC10402bY7.f fVar) {
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.p(navigationRailView.h)) {
                fVar.b += o98.f(O98.m.i()).b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.p(navigationRailView2.i)) {
                fVar.d += o98.f(O98.m.i()).d;
            }
            boolean z = AbstractC12990fW7.A(view) == 1;
            int iK = o98.k();
            int iL = o98.l();
            int i = fVar.a;
            if (z) {
                iK = iL;
            }
            fVar.a = i + iK;
            fVar.a(view);
            return o98;
        }
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private void k() {
        AbstractC10402bY7.c(this, new a());
    }

    private boolean m() {
        View view = this.g;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int n(int i) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(Boolean bool) {
        return bool != null ? bool.booleanValue() : AbstractC12990fW7.x(this);
    }

    public View getHeaderView() {
        return this.g;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void i(int i) {
        j(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false));
    }

    public void j(View view) {
        o();
        this.g = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f;
        addView(view, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView d(Context context) {
        return new NavigationRailMenuView(context);
    }

    public void o() {
        View view = this.g;
        if (view != null) {
            removeView(view);
            this.g = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i5 = 0;
        if (m()) {
            int bottom = this.g.getBottom() + this.f;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i5 = bottom - top;
            }
        } else if (navigationRailMenuView.n()) {
            i5 = this.f;
        }
        if (i5 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i5, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i5);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iN = n(i);
        super.onMeasure(iN, i2);
        if (m()) {
            measureChild(getNavigationRailMenuView(), iN, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.g.getMeasuredHeight()) - this.f, RecyclerView.UNDEFINED_DURATION));
        }
    }

    public void setItemMinimumHeight(int i) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.navigationRailStyle);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, AbstractC21175tE5.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.h = null;
        this.i = null;
        this.f = getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_navigation_rail_margin);
        C cI = AbstractC5729Ko7.i(getContext(), attributeSet, GE5.NavigationRailView, i, i2, new int[0]);
        int iN = cI.n(GE5.NavigationRailView_headerLayout, 0);
        if (iN != 0) {
            i(iN);
        }
        setMenuGravity(cI.k(GE5.NavigationRailView_menuGravity, 49));
        if (cI.s(GE5.NavigationRailView_itemMinHeight)) {
            setItemMinimumHeight(cI.f(GE5.NavigationRailView_itemMinHeight, -1));
        }
        if (cI.s(GE5.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.h = Boolean.valueOf(cI.a(GE5.NavigationRailView_paddingTopSystemWindowInsets, false));
        }
        if (cI.s(GE5.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.i = Boolean.valueOf(cI.a(GE5.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }
        cI.w();
        k();
    }
}
