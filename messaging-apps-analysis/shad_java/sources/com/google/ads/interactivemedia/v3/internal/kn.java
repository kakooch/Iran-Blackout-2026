package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kn implements ko, lz {
    private final long a;
    private final km b;

    public kn(long j) {
        this(j, 0L);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public long d(long j) {
        return 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public long e() {
        return -1L;
    }

    public kn(long j, long j2) {
        this.a = j;
        kp kpVar = j2 == 0 ? kp.a : new kp(0L, j2);
        this.b = new km(kpVar, kpVar);
    }

    public kn() {
        this(-9223372036854775807L);
    }
}
