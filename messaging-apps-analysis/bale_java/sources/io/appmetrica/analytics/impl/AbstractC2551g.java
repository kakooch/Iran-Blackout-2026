package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2551g {
    public final C2484d5 a;
    public final Rj b;
    public final Vj c;
    public final Qj d;
    public final La e;
    public final SystemTimeProvider f;

    public AbstractC2551g(C2484d5 c2484d5, Rj rj, Vj vj, Qj qj, La la, SystemTimeProvider systemTimeProvider) {
        this.a = c2484d5;
        this.b = rj;
        this.c = vj;
        this.d = qj;
        this.e = la;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Ej a(Object obj) {
        return a((Fj) obj);
    }

    public final Ej b() {
        if (this.c.h()) {
            return new Ej(this.a, this.c, a(), this.f);
        }
        return null;
    }

    public final Ej a(Fj fj) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C2484d5 c2484d5 = this.a;
        Vj vj = this.c;
        long jA = this.b.a();
        Vj vj2 = this.c;
        vj2.a(Vj.f, Long.valueOf(jA));
        vj2.a(Vj.d, Long.valueOf(fj.a));
        vj2.a(Vj.h, Long.valueOf(fj.a));
        vj2.a(Vj.g, 0L);
        vj2.a(Vj.i, Boolean.TRUE);
        vj2.b();
        this.a.f.a(jA, this.d.a, TimeUnit.MILLISECONDS.toSeconds(fj.b));
        return new Ej(c2484d5, vj, a(), new SystemTimeProvider());
    }

    public final Hj a() {
        Gj gj = new Gj(this.d);
        gj.g = this.c.i();
        gj.f = this.c.c.a(Vj.g);
        gj.d = this.c.c.a(Vj.h);
        gj.c = this.c.c.a(Vj.f);
        gj.h = this.c.c.a(Vj.d);
        gj.a = this.c.c.a(Vj.e);
        return new Hj(gj);
    }
}
