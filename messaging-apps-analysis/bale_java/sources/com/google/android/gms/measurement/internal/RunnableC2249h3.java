package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;

/* renamed from: com.google.android.gms.measurement.internal.h3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2249h3 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ C2308t3 b;

    RunnableC2249h3(C2308t3 c2308t3, zzq zzqVar) {
        this.b = c2308t3;
        this.a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.b;
        Gm8 gm8 = c2308t3.d;
        if (gm8 == null) {
            c2308t3.a.b().r().a("Failed to send consent settings to service");
            return;
        }
        try {
            AbstractC3795Cj5.j(this.a);
            gm8.G0(this.a);
            this.b.E();
        } catch (RemoteException e) {
            this.b.a.b().r().b("Failed to send consent settings to the service", e);
        }
    }
}
