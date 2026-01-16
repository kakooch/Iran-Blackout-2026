package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;

/* renamed from: com.google.android.gms.measurement.internal.b3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2219b3 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ C2308t3 c;

    RunnableC2219b3(C2308t3 c2308t3, zzq zzqVar, Bundle bundle) {
        this.c = c2308t3;
        this.a = zzqVar;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.c;
        Gm8 gm8 = c2308t3.d;
        if (gm8 == null) {
            c2308t3.a.b().r().a("Failed to send default event parameters to service");
            return;
        }
        try {
            AbstractC3795Cj5.j(this.a);
            gm8.k1(this.b, this.a);
        } catch (RemoteException e) {
            this.c.a.b().r().b("Failed to send default event parameters to service", e);
        }
    }
}
