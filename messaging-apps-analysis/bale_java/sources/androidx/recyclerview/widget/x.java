package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class x extends RecyclerView.m {
    boolean g = true;

    public abstract boolean B(RecyclerView.C c);

    public abstract boolean C(RecyclerView.C c, RecyclerView.C c2, int i, int i2, int i3, int i4);

    public abstract boolean D(RecyclerView.C c, int i, int i2, int i3, int i4);

    public abstract boolean E(RecyclerView.C c);

    public final void F(RecyclerView.C c) {
        N(c);
        h(c);
    }

    public final void G(RecyclerView.C c) {
        O(c);
    }

    public final void H(RecyclerView.C c, boolean z) {
        P(c, z);
        h(c);
    }

    public final void I(RecyclerView.C c, boolean z) {
        Q(c, z);
    }

    public final void J(RecyclerView.C c) {
        R(c);
        h(c);
    }

    public final void K(RecyclerView.C c) {
        S(c);
    }

    public final void L(RecyclerView.C c) {
        T(c);
        h(c);
    }

    public final void M(RecyclerView.C c) {
        U(c);
    }

    public void N(RecyclerView.C c) {
    }

    public void O(RecyclerView.C c) {
    }

    public void P(RecyclerView.C c, boolean z) {
    }

    public void Q(RecyclerView.C c, boolean z) {
    }

    public void R(RecyclerView.C c) {
    }

    public void S(RecyclerView.C c) {
    }

    public void T(RecyclerView.C c) {
    }

    public void U(RecyclerView.C c) {
    }

    public void V(boolean z) {
        this.g = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean a(RecyclerView.C c, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i;
        int i2;
        return (cVar == null || ((i = cVar.a) == (i2 = cVar2.a) && cVar.b == cVar2.b)) ? B(c) : D(c, i, cVar.b, i2, cVar2.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean b(RecyclerView.C c, RecyclerView.C c2, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (c2.y0()) {
            int i5 = cVar.a;
            i2 = cVar.b;
            i = i5;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        return C(c, c2, i3, i4, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean c(RecyclerView.C c, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = c.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (c.a0() || (i == left && i2 == top)) {
            return E(c);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return D(c, i, i2, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean d(RecyclerView.C c, RecyclerView.m.c cVar, RecyclerView.m.c cVar2) {
        int i = cVar.a;
        int i2 = cVar2.a;
        if (i != i2 || cVar.b != cVar2.b) {
            return D(c, i, cVar.b, i2, cVar2.b);
        }
        J(c);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean f(RecyclerView.C c) {
        return !this.g || c.X();
    }
}
