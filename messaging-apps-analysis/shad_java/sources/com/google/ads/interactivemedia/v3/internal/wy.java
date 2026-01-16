package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class wy implements wx {
    private final jt a;
    private final long b;

    public wy(jt jtVar, long j) {
        this.a = jtVar;
        this.b = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long a(long j, long j2) {
        return this.a.d(j + this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long b(long j) {
        return this.a.e[(int) j] - this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long c(long j, long j2) {
        return this.a.d[(int) j];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final xq d(long j) {
        return new xq(null, this.a.c[(int) j], r0.b[r9]);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long e() {
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long f(long j, long j2) {
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final int g(long j) {
        return this.a.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final int h(long j, long j2) {
        return this.a.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long i(long j, long j2) {
        return -9223372036854775807L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final boolean j() {
        return true;
    }
}
