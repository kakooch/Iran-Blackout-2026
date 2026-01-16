package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;
import ir.nasim.InterfaceC19683ql8;
import ir.nasim.Qh8;

/* loaded from: classes3.dex */
final class Y2 implements Runnable {
    final /* synthetic */ zzq a;
    final /* synthetic */ InterfaceC19683ql8 b;
    final /* synthetic */ C2308t3 c;

    Y2(C2308t3 c2308t3, zzq zzqVar, InterfaceC19683ql8 interfaceC19683ql8) {
        this.c = c2308t3;
        this.a = zzqVar;
        this.b = interfaceC19683ql8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        H1 h1;
        String strU1 = null;
        try {
            try {
                if (this.c.a.F().q().i(Qh8.ANALYTICS_STORAGE)) {
                    C2308t3 c2308t3 = this.c;
                    Gm8 gm8 = c2308t3.d;
                    if (gm8 == null) {
                        c2308t3.a.b().r().a("Failed to get app instance id");
                        h1 = this.c.a;
                    } else {
                        AbstractC3795Cj5.j(this.a);
                        strU1 = gm8.u1(this.a);
                        if (strU1 != null) {
                            this.c.a.I().C(strU1);
                            this.c.a.F().g.b(strU1);
                        }
                        this.c.E();
                        h1 = this.c.a;
                    }
                } else {
                    this.c.a.b().x().a("Analytics storage consent denied; will not get app instance id");
                    this.c.a.I().C(null);
                    this.c.a.F().g.b(null);
                    h1 = this.c.a;
                }
            } catch (RemoteException e) {
                this.c.a.b().r().b("Failed to get app instance id", e);
                h1 = this.c.a;
            }
            h1.N().J(this.b, strU1);
        } catch (Throwable th) {
            this.c.a.N().J(this.b, null);
            throw th;
        }
    }
}
