package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes3.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private a a;
    private int b;
    private int c;

    public ViewOffsetBehavior() {
        this.b = 0;
        this.c = 0;
    }

    public int E() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    protected void F(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.M(view, i);
    }

    public boolean G(int i) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.f(i);
        }
        this.b = i;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        F(coordinatorLayout, view, i);
        if (this.a == null) {
            this.a = new a(view);
        }
        this.a.d();
        this.a.a();
        int i2 = this.b;
        if (i2 != 0) {
            this.a.f(i2);
            this.b = 0;
        }
        int i3 = this.c;
        if (i3 == 0) {
            return true;
        }
        this.a.e(i3);
        this.c = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }
}
