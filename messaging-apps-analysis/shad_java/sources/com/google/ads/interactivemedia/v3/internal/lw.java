package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class lw implements lz {
    private final long[] a;
    private final long[] b;
    private final long c;

    private lw(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? bi.b(jArr2[jArr2.length - 1]) : j;
    }

    public static lw f(long j, sf sfVar, long j2) {
        int length = sfVar.d.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += sfVar.b + sfVar.d[i3];
            j3 += sfVar.c + sfVar.e[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new lw(jArr, jArr2, j2);
    }

    private static Pair<Long, Long> g(long j, long[] jArr, long[] jArr2) {
        double d;
        int iAn = aeu.an(jArr, j, true);
        long j2 = jArr[iAn];
        long j3 = jArr2[iAn];
        int i = iAn + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        long j5 = jArr2[i];
        if (j4 == j2) {
            d = 0.0d;
        } else {
            double d2 = j;
            double d3 = j2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = j4 - j2;
            Double.isNaN(d4);
            d = (d2 - d3) / d4;
        }
        Long lValueOf = Long.valueOf(j);
        double d5 = j5 - j3;
        Double.isNaN(d5);
        return Pair.create(lValueOf, Long.valueOf(((long) (d * d5)) + j3));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        Pair<Long, Long> pairG = g(bi.a(aeu.I(j, 0L, this.c)), this.b, this.a);
        long jLongValue = ((Long) pairG.first).longValue();
        kp kpVar = new kp(bi.b(jLongValue), ((Long) pairG.second).longValue());
        return new km(kpVar, kpVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public final long d(long j) {
        return bi.b(((Long) g(j, this.a, this.b).second).longValue());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public final long e() {
        return -1L;
    }
}
