package com.google.android.gms.measurement.internal;

import ir.nasim.Wt8;
import ir.nasim.Xh8;

/* loaded from: classes3.dex */
final class C2 implements Runnable {
    final /* synthetic */ Xh8 a;
    final /* synthetic */ int b;
    final /* synthetic */ long c;
    final /* synthetic */ boolean d;
    final /* synthetic */ Xh8 e;
    final /* synthetic */ G2 f;

    C2(G2 g2, Xh8 xh8, int i, long j, boolean z, Xh8 xh82) {
        this.f = g2;
        this.a = xh8;
        this.b = i;
        this.c = j;
        this.d = z;
        this.e = xh82;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.J(this.a);
        G2.c0(this.f, this.a, this.b, this.c, false, this.d);
        Wt8.b();
        if (this.f.a.z().B(null, S0.o0)) {
            G2.b0(this.f, this.a, this.e);
        }
    }
}
