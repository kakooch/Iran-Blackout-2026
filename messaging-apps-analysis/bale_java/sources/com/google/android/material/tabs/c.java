package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC6732Ot;

/* loaded from: classes3.dex */
class c {
    c() {
    }

    static RectF a(TabLayout tabLayout, View view) {
        return view == null ? new RectF() : (tabLayout.A() || !(view instanceof TabLayout.TabView)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.TabView) view, 24);
    }

    static RectF b(TabLayout.TabView tabView, int i) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int iD = (int) AbstractC10402bY7.d(tabView.getContext(), i);
        if (contentWidth < iD) {
            contentWidth = iD;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i2 = contentWidth / 2;
        return new RectF(left - i2, top - (contentHeight / 2), i2 + left, top + (left / 2));
    }

    void c(TabLayout tabLayout, View view, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }

    void d(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(AbstractC6732Ot.c((int) rectFA.left, (int) rectFA2.left, f), drawable.getBounds().top, AbstractC6732Ot.c((int) rectFA.right, (int) rectFA2.right, f), drawable.getBounds().bottom);
    }
}
