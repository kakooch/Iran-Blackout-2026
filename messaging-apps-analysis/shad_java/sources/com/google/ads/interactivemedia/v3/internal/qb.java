package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qb implements ko {
    private final py a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;

    public qb(py pyVar, int i, long j, long j2) {
        this.a = pyVar;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / pyVar.d;
        this.d = j3;
        this.e = d(j3);
    }

    private final long d(long j) {
        return aeu.N(j * this.b, 1000000L, this.a.c);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        long jI = aeu.I((this.a.c * j) / (this.b * 1000000), 0L, this.d - 1);
        long j2 = this.c;
        int i = this.a.d;
        long jD = d(jI);
        kp kpVar = new kp(jD, j2 + (i * jI));
        if (jD >= j || jI == this.d - 1) {
            return new km(kpVar, kpVar);
        }
        long j3 = jI + 1;
        return new km(kpVar, new kp(d(j3), this.c + (j3 * this.a.d)));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.e;
    }
}
