package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.AbstractC6732Ot;

/* loaded from: classes3.dex */
class a extends c {
    a() {
    }

    private static float e(float f) {
        return (float) (1.0d - Math.cos((f * 3.141592653589793d) / 2.0d));
    }

    private static float f(float f) {
        return (float) Math.sin((f * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.c
    void d(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float f2;
        float fE;
        RectF rectFA = c.a(tabLayout, view);
        RectF rectFA2 = c.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            f2 = e(f);
            fE = f(f);
        } else {
            f2 = f(f);
            fE = e(f);
        }
        drawable.setBounds(AbstractC6732Ot.c((int) rectFA.left, (int) rectFA2.left, f2), drawable.getBounds().top, AbstractC6732Ot.c((int) rectFA.right, (int) rectFA2.right, fE), drawable.getBounds().bottom);
    }
}
