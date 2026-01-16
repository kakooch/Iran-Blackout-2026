package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import ir.nasim.C19938rB7;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public abstract class Pg implements Callable {
    public static final Og d = new Og();
    public final C2552g0 a;
    public final Zj b;
    public boolean c;

    public Pg(C2552g0 c2552g0, Zj zj) {
        this.a = c2552g0;
        this.b = zj;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C2552g0 b() {
        return this.a;
    }

    public boolean c() throws InterruptedException {
        C2552g0 c2552g0 = this.a;
        synchronized (c2552g0) {
            try {
                if (c2552g0.d == null) {
                    c2552g0.e = new CountDownLatch(1);
                    Intent intentA = Aj.a(c2552g0.a);
                    try {
                        c2552g0.g.b(c2552g0.a);
                        c2552g0.a.bindService(intentA, c2552g0.i, 1);
                    } catch (Throwable unused) {
                    }
                }
            } finally {
            }
        }
        this.a.a(5000L);
        return true;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        a();
        return C19938rB7.a;
    }

    public final boolean d() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public void a() {
        IAppMetricaService iAppMetricaService;
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            int i = 0;
            do {
                C2552g0 c2552g0 = this.a;
                synchronized (c2552g0) {
                    iAppMetricaService = c2552g0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        Zj zj = this.b;
                        if (zj != null && !((C2999yh) zj).a()) {
                            return;
                        }
                        this.a.c();
                        return;
                    } catch (RemoteException unused) {
                    }
                }
                i++;
                if (!c() || P1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
