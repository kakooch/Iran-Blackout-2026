package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class hh {
    private final Handler a;
    private final hi b;

    public hh(Handler handler, hi hiVar) {
        this.a = hiVar == null ? null : handler;
        this.b = hiVar;
    }

    public final void a(final iu iuVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.gy
                private final hh a;
                private final iu b;

                {
                    this.a = this;
                    this.b = iuVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q(this.b);
                }
            });
        }
    }

    public final void b(final String str, final long j, final long j2) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, str, j, j2) { // from class: com.google.ads.interactivemedia.v3.internal.gz
                private final hh a;
                private final String b;
                private final long c;
                private final long d;

                {
                    this.a = this;
                    this.b = str;
                    this.c = j;
                    this.d = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p(this.b, this.c, this.d);
                }
            });
        }
    }

    public final void c(final cy cyVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, cyVar) { // from class: com.google.ads.interactivemedia.v3.internal.ha
                private final hh a;
                private final cy b;

                {
                    this.a = this;
                    this.b = cyVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.o(this.b);
                }
            });
        }
    }

    public final void d(final long j) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, j) { // from class: com.google.ads.interactivemedia.v3.internal.hb
                private final hh a;
                private final long b;

                {
                    this.a = this;
                    this.b = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(this.b);
                }
            });
        }
    }

    public final void e(final int i, final long j, final long j2) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, i, j, j2) { // from class: com.google.ads.interactivemedia.v3.internal.hc
                private final hh a;
                private final int b;
                private final long c;
                private final long d;

                {
                    this.a = this;
                    this.b = i;
                    this.c = j;
                    this.d = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m(this.b, this.c, this.d);
                }
            });
        }
    }

    public final void f(final iu iuVar) {
        iuVar.a();
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.hd
                private final hh a;
                private final iu b;

                {
                    this.a = this;
                    this.b = iuVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(this.b);
                }
            });
        }
    }

    public final void g(final int i) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, i) { // from class: com.google.ads.interactivemedia.v3.internal.he
                private final hh a;
                private final int b;

                {
                    this.a = this;
                    this.b = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(this.b);
                }
            });
        }
    }

    public final void h(final boolean z) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, z) { // from class: com.google.ads.interactivemedia.v3.internal.hf
                private final hh a;
                private final boolean b;

                {
                    this.a = this;
                    this.b = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(this.b);
                }
            });
        }
    }

    public final void i(final Exception exc) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, exc) { // from class: com.google.ads.interactivemedia.v3.internal.hg
                private final hh a;
                private final Exception b;

                {
                    this.a = this;
                    this.b = exc;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    aeu.a;
                }
            });
        }
    }

    final /* synthetic */ void j(boolean z) {
        hi hiVar = this.b;
        int i = aeu.a;
        hiVar.F(z);
    }

    final /* synthetic */ void k(int i) {
        hi hiVar = this.b;
        int i2 = aeu.a;
        hiVar.z(i);
    }

    final /* synthetic */ void l(iu iuVar) {
        iuVar.a();
        hi hiVar = this.b;
        int i = aeu.a;
        hiVar.E(iuVar);
    }

    final /* synthetic */ void m(int i, long j, long j2) {
        hi hiVar = this.b;
        int i2 = aeu.a;
        hiVar.D(i, j, j2);
    }

    final /* synthetic */ void n(long j) {
        hi hiVar = this.b;
        int i = aeu.a;
        hiVar.C(j);
    }

    final /* synthetic */ void o(cy cyVar) {
        hi hiVar = this.b;
        int i = aeu.a;
        hiVar.B(cyVar);
    }

    final /* synthetic */ void p(String str, long j, long j2) {
        hi hiVar = this.b;
        int i = aeu.a;
        hiVar.A(str, j, j2);
    }

    final /* synthetic */ void q(iu iuVar) {
        hi hiVar = this.b;
        int i = aeu.a;
        hiVar.y(iuVar);
    }
}
