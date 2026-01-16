package com.google.android.gms.measurement.internal;

import android.os.Handler;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Ak8;

/* renamed from: com.google.android.gms.measurement.internal.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2275n {
    private static volatile Handler d;
    private final InterfaceC2223c2 a;
    private final Runnable b;
    private volatile long c;

    AbstractC2275n(InterfaceC2223c2 interfaceC2223c2) {
        AbstractC3795Cj5.j(interfaceC2223c2);
        this.a = interfaceC2223c2;
        this.b = new RunnableC2270m(this, interfaceC2223c2);
    }

    private final Handler f() {
        Handler handler;
        if (d != null) {
            return d;
        }
        synchronized (AbstractC2275n.class) {
            try {
                if (d == null) {
                    d = new Ak8(this.a.f().getMainLooper());
                }
                handler = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    final void b() {
        this.c = 0L;
        f().removeCallbacks(this.b);
    }

    public abstract void c();

    public final void d(long j) {
        b();
        if (j >= 0) {
            this.c = this.a.c().currentTimeMillis();
            if (f().postDelayed(this.b, j)) {
                return;
            }
            this.a.b().r().b("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean e() {
        return this.c != 0;
    }
}
