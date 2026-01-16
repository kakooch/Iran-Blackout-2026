package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Jl0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5461Jl0 {
    private int a;

    public final void o(int i) {
        this.a = i | this.a;
    }

    public void p() {
        this.a = 0;
    }

    public final void q(int i) {
        this.a = (~i) & this.a;
    }

    protected final boolean r(int i) {
        return (this.a & i) == i;
    }

    public final boolean s() {
        return r(268435456);
    }

    public final boolean t() {
        return r(RecyclerView.UNDEFINED_DURATION);
    }

    public final boolean u() {
        return r(4);
    }

    public final boolean v() {
        return r(134217728);
    }

    public final boolean w() {
        return r(1);
    }

    public final void x(int i) {
        this.a = i;
    }
}
