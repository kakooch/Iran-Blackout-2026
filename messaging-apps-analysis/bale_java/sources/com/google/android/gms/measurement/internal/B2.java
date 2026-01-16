package com.google.android.gms.measurement.internal;

import ir.nasim.Wt8;
import ir.nasim.Xh8;

/* loaded from: classes3.dex */
final class B2 implements Runnable {
    final /* synthetic */ Xh8 a;
    final /* synthetic */ long b;
    final /* synthetic */ int c;
    final /* synthetic */ long d;
    final /* synthetic */ boolean e;
    final /* synthetic */ Xh8 f;
    final /* synthetic */ G2 g;

    B2(G2 g2, Xh8 xh8, long j, int i, long j2, boolean z, Xh8 xh82) {
        this.g = g2;
        this.a = xh8;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = z;
        this.f = xh82;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.g.J(this.a);
        this.g.z(this.b, false);
        G2.c0(this.g, this.a, this.c, this.d, true, this.e);
        Wt8.b();
        if (this.g.a.z().B(null, S0.o0)) {
            G2.b0(this.g, this.a, this.f);
        }
    }
}
