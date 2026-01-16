package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class nh implements nn {
    private final kh a;
    private final kg b;
    private long c = -1;
    private long d = -1;

    public nh(kh khVar, kg kgVar) {
        this.a = khVar;
        this.b = kgVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nn
    public final void a(long j) {
        long[] jArr = this.b.a;
        this.d = jArr[aeu.an(jArr, j, true)];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nn
    public final ko b() {
        ary.q(this.c != -1);
        return new kf(this.a, this.c);
    }

    public final void c(long j) {
        this.c = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nn
    public final long g(jv jvVar) {
        long j = this.d;
        if (j < 0) {
            return -1L;
        }
        this.d = -1L;
        return -(j + 2);
    }
}
