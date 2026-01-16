package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ug {
    public final int a;
    public final tw b;
    private final CopyOnWriteArrayList<uf> c;
    private final long d;

    public ug() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    private ug(CopyOnWriteArrayList<uf> copyOnWriteArrayList, int i, tw twVar, long j) {
        this.c = copyOnWriteArrayList;
        this.a = i;
        this.b = twVar;
        this.d = j;
    }

    private final long t(long j) {
        long jA = bi.a(j);
        if (jA == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d + jA;
    }

    public final ug a(int i, tw twVar, long j) {
        return new ug(this.c, i, twVar, j);
    }

    public final void b(Handler handler, uh uhVar) {
        ary.t(handler);
        ary.t(uhVar);
        this.c.add(new uf(handler, uhVar));
    }

    public final void c(uh uhVar) {
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            if (next.b == uhVar) {
                this.c.remove(next);
            }
        }
    }

    public final void d(to toVar, int i) {
        e(toVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void e(to toVar, int i, int i2, cy cyVar, int i3, Object obj, long j, long j2) {
        f(toVar, new tt(i, i2, cyVar, i3, obj, t(j), t(j2)));
    }

    public final void f(final to toVar, final tt ttVar) {
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            final uh uhVar = next.b;
            aeu.ar(next.a, new Runnable(this, uhVar, toVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.tz
                private final ug a;
                private final uh b;
                private final to c;
                private final tt d;

                {
                    this.a = this;
                    this.b = uhVar;
                    this.c = toVar;
                    this.d = ttVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ug ugVar = this.a;
                    this.b.U(ugVar.a, ugVar.b, this.c, this.d);
                }
            });
        }
    }

    public final void g(to toVar, int i) {
        h(toVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void h(to toVar, int i, int i2, cy cyVar, int i3, Object obj, long j, long j2) {
        i(toVar, new tt(i, i2, cyVar, i3, obj, t(j), t(j2)));
    }

    public final void i(final to toVar, final tt ttVar) {
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            final uh uhVar = next.b;
            aeu.ar(next.a, new Runnable(this, uhVar, toVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.ua
                private final ug a;
                private final uh b;
                private final to c;
                private final tt d;

                {
                    this.a = this;
                    this.b = uhVar;
                    this.c = toVar;
                    this.d = ttVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ug ugVar = this.a;
                    this.b.V(ugVar.a, ugVar.b, this.c, this.d);
                }
            });
        }
    }

    public final void j(to toVar, int i) {
        k(toVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void k(to toVar, int i, int i2, cy cyVar, int i3, Object obj, long j, long j2) {
        l(toVar, new tt(i, i2, cyVar, i3, obj, t(j), t(j2)));
    }

    public final void l(final to toVar, final tt ttVar) {
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            final uh uhVar = next.b;
            aeu.ar(next.a, new Runnable(this, uhVar, toVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.ub
                private final ug a;
                private final uh b;
                private final to c;
                private final tt d;

                {
                    this.a = this;
                    this.b = uhVar;
                    this.c = toVar;
                    this.d = ttVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ug ugVar = this.a;
                    this.b.W(ugVar.a, ugVar.b, this.c, this.d);
                }
            });
        }
    }

    public final void m(to toVar, int i, IOException iOException, boolean z) {
        n(toVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
    }

    public final void n(to toVar, int i, int i2, cy cyVar, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
        o(toVar, new tt(i, i2, cyVar, i3, obj, t(j), t(j2)), iOException, z);
    }

    public final void o(final to toVar, final tt ttVar, final IOException iOException, final boolean z) {
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            final uh uhVar = next.b;
            aeu.ar(next.a, new Runnable(this, uhVar, toVar, ttVar, iOException, z) { // from class: com.google.ads.interactivemedia.v3.internal.uc
                private final ug a;
                private final uh b;
                private final to c;
                private final tt d;
                private final IOException e;
                private final boolean f;

                {
                    this.a = this;
                    this.b = uhVar;
                    this.c = toVar;
                    this.d = ttVar;
                    this.e = iOException;
                    this.f = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ug ugVar = this.a;
                    this.b.X(ugVar.a, ugVar.b, this.c, this.d, this.e, this.f);
                }
            });
        }
    }

    public final void p(int i, long j, long j2) {
        q(new tt(1, i, null, 3, null, t(j), t(j2)));
    }

    public final void q(final tt ttVar) {
        final tw twVar = this.b;
        ary.t(twVar);
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            final uh uhVar = next.b;
            aeu.ar(next.a, new Runnable(this, uhVar, twVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.ud
                private final ug a;
                private final uh b;
                private final tw c;
                private final tt d;

                {
                    this.a = this;
                    this.b = uhVar;
                    this.c = twVar;
                    this.d = ttVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ug ugVar = this.a;
                    this.b.Y(ugVar.a, this.c, this.d);
                }
            });
        }
    }

    public final void r(int i, cy cyVar, int i2, Object obj, long j) {
        s(new tt(1, i, cyVar, i2, obj, t(j), -9223372036854775807L));
    }

    public final void s(final tt ttVar) {
        Iterator<uf> it = this.c.iterator();
        while (it.hasNext()) {
            uf next = it.next();
            final uh uhVar = next.b;
            aeu.ar(next.a, new Runnable(this, uhVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.ue
                private final ug a;
                private final uh b;
                private final tt c;

                {
                    this.a = this;
                    this.b = uhVar;
                    this.c = ttVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ug ugVar = this.a;
                    this.b.Z(ugVar.a, ugVar.b, this.c);
                }
            });
        }
    }
}
