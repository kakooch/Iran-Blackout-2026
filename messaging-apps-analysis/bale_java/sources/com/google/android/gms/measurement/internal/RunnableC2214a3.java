package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.Gm8;

/* renamed from: com.google.android.gms.measurement.internal.a3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2214a3 implements Runnable {
    final /* synthetic */ M2 a;
    final /* synthetic */ C2308t3 b;

    RunnableC2214a3(C2308t3 c2308t3, M2 m2) {
        this.b = c2308t3;
        this.a = m2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2308t3 c2308t3 = this.b;
        Gm8 gm8 = c2308t3.d;
        if (gm8 == null) {
            c2308t3.a.b().r().a("Failed to send current screen to service");
            return;
        }
        try {
            M2 m2 = this.a;
            if (m2 == null) {
                gm8.v0(0L, null, null, c2308t3.a.f().getPackageName());
            } else {
                gm8.v0(m2.c, m2.a, m2.b, c2308t3.a.f().getPackageName());
            }
            this.b.E();
        } catch (RemoteException e) {
            this.b.a.b().r().b("Failed to send current screen to the service", e);
        }
    }
}
