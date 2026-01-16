package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;

/* loaded from: classes3.dex */
final class W2 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ C2308t3 b;

    W2(C2308t3 c2308t3, zzq zzqVar) {
        this.b = c2308t3;
        this.a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.b;
        Gm8 gm8 = c2308t3.d;
        if (gm8 == null) {
            c2308t3.a.b().r().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            AbstractC3795Cj5.j(this.a);
            gm8.P0(this.a);
        } catch (RemoteException e) {
            this.b.a.b().r().b("Failed to reset data on the service: remote exception", e);
        }
        this.b.E();
    }
}
