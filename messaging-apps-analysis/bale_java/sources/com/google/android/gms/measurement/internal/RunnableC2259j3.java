package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;

/* renamed from: com.google.android.gms.measurement.internal.j3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2259j3 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ boolean b;
    final /* synthetic */ zzac c;
    final /* synthetic */ zzac d;
    final /* synthetic */ C2308t3 e;

    RunnableC2259j3(C2308t3 c2308t3, boolean z, zzq zzqVar, boolean z2, zzac zzacVar, zzac zzacVar2) {
        this.e = c2308t3;
        this.a = zzqVar;
        this.b = z2;
        this.c = zzacVar;
        this.d = zzacVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.e;
        Gm8 gm8 = c2308t3.d;
        if (gm8 == null) {
            c2308t3.a.b().r().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        AbstractC3795Cj5.j(this.a);
        this.e.r(gm8, this.b ? null : this.c, this.a);
        this.e.E();
    }
}
