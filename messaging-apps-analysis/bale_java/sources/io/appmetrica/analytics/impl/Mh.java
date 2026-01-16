package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Mh implements InterfaceC2738nj {
    public final C2552g0 a;
    public final C2666kj b;
    public final ICommonExecutor c;

    public Mh(C2552g0 c2552g0, C2666kj c2666kj) {
        this(c2552g0, c2666kj, C2747o4.g().d().b());
    }

    public final void a(Ng ng) {
        Pg c2520eg;
        ICommonExecutor iCommonExecutor = this.c;
        if (ng.b) {
            C2666kj c2666kj = this.b;
            c2520eg = new C2485d6(c2666kj.a, c2666kj.b, c2666kj.c, ng);
        } else {
            C2666kj c2666kj2 = this.b;
            c2520eg = new C2520eg(c2666kj2.b, c2666kj2.c, ng);
        }
        iCommonExecutor.submit(c2520eg);
    }

    public final void b(Ng ng) {
        C2666kj c2666kj = this.b;
        C2485d6 c2485d6 = new C2485d6(c2666kj.a, c2666kj.b, c2666kj.c, ng);
        if (this.a.a()) {
            try {
                this.c.submit(c2485d6).get(4L, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c2485d6.c) {
            return;
        }
        try {
            c2485d6.a();
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2738nj
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.c;
        C2666kj c2666kj = this.b;
        iCommonExecutor.submit(new Jm(c2666kj.b, c2666kj.c, i, bundle));
    }

    public Mh(C2552g0 c2552g0, C2666kj c2666kj, ICommonExecutor iCommonExecutor) {
        this.c = iCommonExecutor;
        this.b = c2666kj;
        this.a = c2552g0;
    }

    public final void b(Oe oe) {
        ICommonExecutor iCommonExecutor = this.c;
        C2666kj c2666kj = this.b;
        iCommonExecutor.submit(new Sh(c2666kj.b, c2666kj.c, oe));
    }

    public final void a(Oe oe) {
        ICommonExecutor iCommonExecutor = this.c;
        C2666kj c2666kj = this.b;
        iCommonExecutor.submit(new Id(c2666kj.b, c2666kj.c, oe));
    }
}
