package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;
import ir.nasim.Qh8;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
final class X2 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ zzq b;
    final /* synthetic */ C2308t3 c;

    X2(C2308t3 c2308t3, AtomicReference atomicReference, zzq zzqVar) {
        this.c = c2308t3;
        this.a = atomicReference;
        this.b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.a) {
            try {
                try {
                } catch (RemoteException e) {
                    this.c.a.b().r().b("Failed to get app instance id", e);
                    atomicReference = this.a;
                }
                if (!this.c.a.F().q().i(Qh8.ANALYTICS_STORAGE)) {
                    this.c.a.b().x().a("Analytics storage consent denied; will not get app instance id");
                    this.c.a.I().C(null);
                    this.c.a.F().g.b(null);
                    this.a.set(null);
                    return;
                }
                C2308t3 c2308t3 = this.c;
                Gm8 gm8 = c2308t3.d;
                if (gm8 == null) {
                    c2308t3.a.b().r().a("Failed to get app instance id");
                    return;
                }
                AbstractC3795Cj5.j(this.b);
                this.a.set(gm8.u1(this.b));
                String str = (String) this.a.get();
                if (str != null) {
                    this.c.a.I().C(str);
                    this.c.a.F().g.b(str);
                }
                this.c.E();
                atomicReference = this.a;
                atomicReference.notify();
            } finally {
                this.a.notify();
            }
        }
    }
}
