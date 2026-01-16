package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import java.io.IOException;

/* loaded from: classes3.dex */
final class Q1 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ Z1 b;

    Q1(Z1 z1, zzq zzqVar) {
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
        y3.S(zzqVar);
    }
}
