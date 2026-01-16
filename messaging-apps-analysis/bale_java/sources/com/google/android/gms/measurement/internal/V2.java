package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;

/* loaded from: classes3.dex */
final class V2 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ boolean b;
    final /* synthetic */ zzkw c;
    final /* synthetic */ C2308t3 d;

    V2(C2308t3 c2308t3, zzq zzqVar, boolean z, zzkw zzkwVar) {
        this.d = c2308t3;
        this.a = zzqVar;
        this.b = z;
        this.c = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.d;
        Gm8 gm8 = c2308t3.d;
        if (gm8 == null) {
            c2308t3.a.b().r().a("Discarding data. Failed to set user property");
            return;
        }
        AbstractC3795Cj5.j(this.a);
        this.d.r(gm8, this.b ? null : this.c, this.a);
        this.d.E();
    }
}
