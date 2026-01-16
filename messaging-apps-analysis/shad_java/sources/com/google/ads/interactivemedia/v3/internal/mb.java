package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mb implements lz {
    private final long a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;

    private mb(long j, int i, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    public static mb f(long j, long j2, ik ikVar, aee aeeVar) {
        int iB;
        int i = ikVar.g;
        int i2 = ikVar.d;
        int iV = aeeVar.v();
        if ((iV & 1) != 1 || (iB = aeeVar.B()) == 0) {
            return null;
        }
        long jN = aeu.N(iB, i * 1000000, i2);
        if ((iV & 6) != 6) {
            return new mb(j2, ikVar.c, jN, -1L, null);
        }
        long jT = aeeVar.t();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = aeeVar.n();
        }
        if (j != -1) {
            long j3 = j2 + jT;
            if (j != j3) {
                StringBuilder sb = new StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j);
                sb.append(", ");
                sb.append(j3);
                Log.w("XingSeeker", sb.toString());
            }
        }
        return new mb(j2, ikVar.c, jN, jT, jArr);
    }

    private final long g(int i) {
        return (this.c * i) / 100;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return this.f != null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        if (!a()) {
            kp kpVar = new kp(0L, this.a + this.b);
            return new km(kpVar, kpVar);
        }
        long jI = aeu.I(j, 0L, this.c);
        double d = jI;
        Double.isNaN(d);
        double d2 = this.c;
        Double.isNaN(d2);
        double d3 = (d * 100.0d) / d2;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i = (int) d3;
                double d5 = ((long[]) ary.s(this.f))[i];
                double d6 = i == 99 ? 256.0d : r3[i + 1];
                double d7 = i;
                Double.isNaN(d7);
                Double.isNaN(d5);
                Double.isNaN(d5);
                d4 = d5 + ((d3 - d7) * (d6 - d5));
            }
        }
        double d8 = this.d;
        Double.isNaN(d8);
        kp kpVar2 = new kp(jI, this.a + aeu.I(Math.round((d4 / 256.0d) * d8), this.b, this.d - 1));
        return new km(kpVar2, kpVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public final long d(long j) {
        double d;
        long j2 = j - this.a;
        if (!a() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) ary.s(this.f);
        double d2 = j2;
        Double.isNaN(d2);
        double d3 = this.d;
        Double.isNaN(d3);
        double d4 = (d2 * 256.0d) / d3;
        int iAn = aeu.an(jArr, (long) d4, true);
        long jG = g(iAn);
        long j3 = jArr[iAn];
        int i = iAn + 1;
        long jG2 = g(i);
        long j4 = iAn == 99 ? 256L : jArr[i];
        if (j3 == j4) {
            d = 0.0d;
        } else {
            double d5 = j3;
            Double.isNaN(d5);
            double d6 = j4 - j3;
            Double.isNaN(d6);
            d = (d4 - d5) / d6;
        }
        double d7 = jG2 - jG;
        Double.isNaN(d7);
        return jG + Math.round(d * d7);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public final long e() {
        return this.e;
    }
}
