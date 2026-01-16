package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Xh8;
import java.io.IOException;

/* loaded from: classes3.dex */
final class R1 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ Z1 b;

    R1(Z1 z1, zzq zzqVar) {
        this.b = z1;
        this.a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.b.a.e();
        Y3 y3 = this.b.a;
        zzq zzqVar = this.a;
        y3.a().h();
        y3.g();
        AbstractC3795Cj5.f(zzqVar.a);
        Xh8 xh8B = Xh8.b(zzqVar.v);
        Xh8 xh8V = y3.V(zzqVar.a);
        y3.b().v().c("Setting consent, package, consent", zzqVar.a, xh8B);
        y3.A(zzqVar.a, xh8B);
        if (xh8B.k(xh8V)) {
            y3.v(zzqVar);
        }
    }
}
