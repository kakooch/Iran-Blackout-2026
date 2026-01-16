package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vz extends vo {
    private final int m;
    private final long n;
    private long o;
    private volatile boolean p;
    private boolean q;
    private final vs r;

    public vz(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, vs vsVar) {
        super(abxVar, acbVar, cyVar, i, obj, j, j2, j3, j4, j5);
        this.m = i2;
        this.n = j6;
        this.r = vsVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
        this.p = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        if (this.o == 0) {
            vq vqVarE = e();
            vqVarE.b(this.n);
            vs vsVar = this.r;
            long j = this.a;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.n;
            long j3 = this.b;
            vsVar.g(vqVarE, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.n);
        }
        try {
            acb acbVarC = this.d.c(this.o);
            adg adgVar = this.k;
            jv jvVar = new jv(adgVar, acbVarC.e, adgVar.c(acbVarC));
            do {
                try {
                    if (this.p) {
                        break;
                    }
                } finally {
                    this.o = jvVar.l() - this.d.e;
                }
            } while (this.r.h(jvVar));
            aeu.q(this.k);
            this.q = !this.p;
        } catch (Throwable th) {
            aeu.q(this.k);
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wc
    public final long i() {
        return this.l + this.m;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wc
    public final boolean j() {
        return this.q;
    }
}
