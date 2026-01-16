package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class I extends O0 implements Rr8 {
    /* synthetic */ I(A a) {
        super(J.zza);
    }

    public final I A(int i, M m) {
        o();
        J.J((J) this.b, i, (N) m.m());
        return this;
    }

    public final I B(int i, N n) {
        o();
        J.J((J) this.b, i, n);
        return this;
    }

    public final I C(long j) {
        o();
        J.Q((J) this.b, j);
        return this;
    }

    public final I D(long j) {
        o();
        J.P((J) this.b, j);
        return this;
    }

    public final N E(int i) {
        return ((J) this.b).G(i);
    }

    public final String F() {
        return ((J) this.b).H();
    }

    public final List G() {
        return Collections.unmodifiableList(((J) this.b).I());
    }

    public final boolean H() {
        return ((J) this.b).U();
    }

    public final int r() {
        return ((J) this.b).B();
    }

    public final long s() {
        return ((J) this.b).C();
    }

    public final long t() {
        return ((J) this.b).D();
    }

    public final I u(Iterable iterable) {
        o();
        J.L((J) this.b, iterable);
        return this;
    }

    public final I v(M m) {
        o();
        J.K((J) this.b, (N) m.m());
        return this;
    }

    public final I w(N n) {
        o();
        J.K((J) this.b, n);
        return this;
    }

    public final I x() {
        o();
        ((J) this.b).zze = P0.m();
        return this;
    }

    public final I y(int i) {
        o();
        J.N((J) this.b, i);
        return this;
    }

    public final I z(String str) {
        o();
        J.O((J) this.b, str);
        return this;
    }
}
