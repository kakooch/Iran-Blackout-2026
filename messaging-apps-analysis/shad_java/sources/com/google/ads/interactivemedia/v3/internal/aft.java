package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.view.Surface;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aft {
    private final Handler a;
    private final afu b;

    public aft(Handler handler, afu afuVar) {
        this.a = afuVar == null ? null : handler;
        this.b = afuVar;
    }

    public final void a(final iu iuVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.afl
                private final aft a;
                private final iu b;

                {
                    this.a = this;
                    this.b = iuVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p(this.b);
                }
            });
        }
    }

    public final void b(final String str, final long j, final long j2) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, str, j, j2) { // from class: com.google.ads.interactivemedia.v3.internal.afm
                private final aft a;
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
                    this.a.o(this.b, this.c, this.d);
                }
            });
        }
    }

    public final void c(final cy cyVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, cyVar) { // from class: com.google.ads.interactivemedia.v3.internal.afn
                private final aft a;
                private final cy b;

                {
                    this.a = this;
                    this.b = cyVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(this.b);
                }
            });
        }
    }

    public final void d(final int i, final long j) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, i, j) { // from class: com.google.ads.interactivemedia.v3.internal.afo
                private final aft a;
                private final int b;
                private final long c;

                {
                    this.a = this;
                    this.b = i;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m(this.b, this.c);
                }
            });
        }
    }

    public final void e(final long j, final int i) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, j, i) { // from class: com.google.ads.interactivemedia.v3.internal.afp
                private final aft a;
                private final long b;
                private final int c;

                {
                    this.a = this;
                    this.b = j;
                    this.c = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(this.b, this.c);
                }
            });
        }
    }

    public final void f(final int i, final int i2, final int i3, final float f) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, i, i2, i3, f) { // from class: com.google.ads.interactivemedia.v3.internal.afq
                private final aft a;
                private final int b;
                private final int c;
                private final int d;
                private final float e;

                {
                    this.a = this;
                    this.b = i;
                    this.c = i2;
                    this.d = i3;
                    this.e = f;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(this.b, this.c, this.d, this.e);
                }
            });
        }
    }

    public final void g(final Surface surface) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, surface) { // from class: com.google.ads.interactivemedia.v3.internal.afr
                private final aft a;
                private final Surface b;

                {
                    this.a = this;
                    this.b = surface;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(this.b);
                }
            });
        }
    }

    public final void h(final iu iuVar) {
        iuVar.a();
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable(this, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.afs
                private final aft a;
                private final iu b;

                {
                    this.a = this;
                    this.b = iuVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(this.b);
                }
            });
        }
    }

    final /* synthetic */ void i(iu iuVar) {
        iuVar.a();
        afu afuVar = this.b;
        int i = aeu.a;
        afuVar.w(iuVar);
    }

    final /* synthetic */ void j(Surface surface) {
        afu afuVar = this.b;
        int i = aeu.a;
        afuVar.f(surface);
    }

    final /* synthetic */ void k(int i, int i2, int i3, float f) {
        afu afuVar = this.b;
        int i4 = aeu.a;
        afuVar.e(i, i2, i3, f);
    }

    final /* synthetic */ void l(long j, int i) {
        afu afuVar = this.b;
        int i2 = aeu.a;
        afuVar.x(j, i);
    }

    final /* synthetic */ void m(int i, long j) {
        afu afuVar = this.b;
        int i2 = aeu.a;
        afuVar.d(i, j);
    }

    final /* synthetic */ void n(cy cyVar) {
        afu afuVar = this.b;
        int i = aeu.a;
        afuVar.c(cyVar);
    }

    final /* synthetic */ void o(String str, long j, long j2) {
        afu afuVar = this.b;
        int i = aeu.a;
        afuVar.b(str, j, j2);
    }

    final /* synthetic */ void p(iu iuVar) {
        afu afuVar = this.b;
        int i = aeu.a;
        afuVar.a(iuVar);
    }
}
