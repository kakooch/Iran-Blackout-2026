package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ju implements ko {
    private final long a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final long f;

    public ju(long j, long j2, int i, int i2) {
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = e(j, j2, i);
        }
    }

    private static long e(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return this.d != -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        long j2 = this.d;
        if (j2 == -1) {
            kp kpVar = new kp(0L, this.b);
            return new km(kpVar, kpVar);
        }
        int i = this.e;
        long j3 = this.c;
        long jI = this.b + aeu.I((((i * j) / 8000000) / j3) * j3, 0L, j2 - j3);
        long jY = y(jI);
        kp kpVar2 = new kp(jY, jI);
        if (jY < j) {
            long j4 = jI + this.c;
            if (j4 < this.a) {
                return new km(kpVar2, new kp(y(j4), j4));
            }
        }
        return new km(kpVar2, kpVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.f;
    }

    public final long y(long j) {
        return e(j, this.b, this.e);
    }
}
