package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.GE5;
import ir.nasim.O98;
import ir.nasim.QA5;

/* loaded from: classes3.dex */
public class BottomNavigationView extends NavigationBarView {

    class a implements AbstractC10402bY7.e {
        a() {
        }

        @Override // ir.nasim.AbstractC10402bY7.e
        public O98 a(View view, O98 o98, AbstractC10402bY7.f fVar) {
            fVar.d += o98.j();
            boolean z = AbstractC12990fW7.A(view) == 1;
            int iK = o98.k();
            int iL = o98.l();
            fVar.a += z ? iL : iK;
            int i = fVar.c;
            if (!z) {
                iK = iL;
            }
            fVar.c = i + iK;
            fVar.a(view);
            return o98;
        }
    }

    public interface b extends NavigationBarView.b {
    }

    public interface c extends NavigationBarView.c {
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private void f(Context context) {
        View view = new View(context);
        view.setBackgroundColor(AbstractC4043Dl1.c(context, QA5.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(AbstractC12799fB5.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private void g() {
        AbstractC10402bY7.c(this, new a());
    }

    private int h(int i) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    private boolean i() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected NavigationBarMenuView d(Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, h(i2));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.n() != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().i(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(b bVar) {
        setOnItemReselectedListener(bVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(c cVar) {
        setOnItemSelectedListener(cVar);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, AbstractC21175tE5.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Context context2 = getContext();
        C cI = AbstractC5729Ko7.i(context2, attributeSet, GE5.BottomNavigationView, i, i2, new int[0]);
        setItemHorizontalTranslationEnabled(cI.a(GE5.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if (cI.s(GE5.BottomNavigationView_android_minHeight)) {
            setMinimumHeight(cI.f(GE5.BottomNavigationView_android_minHeight, 0));
        }
        cI.w();
        if (i()) {
            f(context2);
        }
        g();
    }
}
