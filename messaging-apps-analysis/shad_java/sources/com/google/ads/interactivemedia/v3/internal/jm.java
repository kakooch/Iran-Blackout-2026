package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jm implements ko {
    private final jp a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public jm(jp jpVar, long j, long j2, long j3, long j4, long j5) {
        this.a = jpVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        kp kpVar = new kp(j, jo.a(this.a.a(j), 0L, this.c, this.d, this.e, this.f));
        return new km(kpVar, kpVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.b;
    }

    public final long d(long j) {
        return this.a.a(j);
    }
}
