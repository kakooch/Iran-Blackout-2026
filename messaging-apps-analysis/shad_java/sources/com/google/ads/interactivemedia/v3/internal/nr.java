package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
abstract class nr {
    private final nl a = new nl();
    private kr b;
    private ka c;
    private nn d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private np j;
    private long k;
    private boolean l;
    private boolean m;

    protected void a(boolean z) {
        int i;
        if (z) {
            this.j = new np();
            this.f = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.h = i;
        this.e = -1L;
        this.g = 0L;
    }

    protected abstract long b(aee aeeVar);

    protected abstract boolean c(aee aeeVar, long j, np npVar) throws IOException;

    final void e(ka kaVar, kr krVar) {
        this.c = kaVar;
        this.b = krVar;
        a(true);
    }

    final void f(long j, long j2) {
        this.a.a();
        if (j == 0) {
            a(!this.l);
        } else if (this.h != 0) {
            long jH = h(j2);
            this.e = jH;
            this.d.a(jH);
            this.h = 2;
        }
    }

    protected final long g(long j) {
        return (j * 1000000) / this.i;
    }

    protected final long h(long j) {
        return (this.i * j) / 1000000;
    }

    protected void i(long j) {
        this.g = j;
    }

    final int j(jv jvVar, kl klVar) throws IOException {
        int i = this.h;
        if (i == 0) {
            while (this.a.e(jvVar)) {
                this.k = jvVar.l() - this.f;
                if (!c(this.a.c(), this.f, this.j)) {
                    cy cyVar = this.j.a;
                    this.i = cyVar.z;
                    if (!this.m) {
                        this.b.a(cyVar);
                        this.m = true;
                    }
                    nn nnVar = this.j.b;
                    if (nnVar != null) {
                        this.d = nnVar;
                    } else if (jvVar.m() == -1) {
                        this.d = new nq(null);
                    } else {
                        nm nmVarB = this.a.b();
                        this.d = new ng(this, this.f, jvVar.m(), nmVarB.e + nmVarB.f, nmVarB.c, (nmVarB.b & 4) != 0);
                    }
                    this.j = null;
                    this.h = 2;
                    this.a.d();
                    return 0;
                }
                this.f = jvVar.l();
            }
            this.h = 3;
            return -1;
        }
        if (i == 1) {
            jvVar.d((int) this.f);
            this.h = 2;
            return 0;
        }
        if (i != 2) {
            throw new IllegalStateException();
        }
        long jG = this.d.g(jvVar);
        if (jG >= 0) {
            klVar.a = jG;
            return 1;
        }
        if (jG < -1) {
            i(-(jG + 2));
        }
        if (!this.l) {
            ko koVarB = this.d.b();
            ary.s(koVarB);
            this.c.am(koVarB);
            this.l = true;
        }
        if (this.k <= 0 && !this.a.e(jvVar)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        aee aeeVarC = this.a.c();
        long jB = b(aeeVarC);
        if (jB >= 0) {
            long j = this.g;
            if (j + jB >= this.e) {
                long jG2 = g(j);
                this.b.d(aeeVarC, aeeVarC.e());
                this.b.b(jG2, 1, aeeVarC.e(), 0, null);
                this.e = -1L;
            }
        }
        this.g += jB;
        return 0;
    }
}
