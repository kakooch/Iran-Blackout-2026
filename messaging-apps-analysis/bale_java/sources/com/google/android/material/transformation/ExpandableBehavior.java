package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.InterfaceC14881ie2;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private int a;

    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;
        final /* synthetic */ int b;
        final /* synthetic */ InterfaceC14881ie2 c;

        a(View view, int i, InterfaceC14881ie2 interfaceC14881ie2) {
            this.a = view;
            this.b = i;
            this.c = interfaceC14881ie2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                InterfaceC14881ie2 interfaceC14881ie2 = this.c;
                expandableBehavior.H((View) interfaceC14881ie2, this.a, interfaceC14881ie2.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    private boolean F(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i = this.a;
        return i == 0 || i == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected InterfaceC14881ie2 G(CoordinatorLayout coordinatorLayout, View view) {
        List listU = coordinatorLayout.u(view);
        int size = listU.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) listU.get(i);
            if (e(coordinatorLayout, view, view2)) {
                return (InterfaceC14881ie2) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        InterfaceC14881ie2 interfaceC14881ie2 = (InterfaceC14881ie2) view2;
        if (!F(interfaceC14881ie2.a())) {
            return false;
        }
        this.a = interfaceC14881ie2.a() ? 1 : 2;
        return H((View) interfaceC14881ie2, view, interfaceC14881ie2.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        InterfaceC14881ie2 interfaceC14881ie2G;
        if (AbstractC12990fW7.T(view) || (interfaceC14881ie2G = G(coordinatorLayout, view)) == null || !F(interfaceC14881ie2G.a())) {
            return false;
        }
        int i2 = interfaceC14881ie2G.a() ? 1 : 2;
        this.a = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i2, interfaceC14881ie2G));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}
