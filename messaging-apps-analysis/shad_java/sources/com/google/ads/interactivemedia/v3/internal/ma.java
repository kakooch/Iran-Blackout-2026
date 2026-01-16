package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ma implements lz {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;

    private ma(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    public static ma f(long j, long j2, ik ikVar, aee aeeVar) {
        int iN;
        aeeVar.k(10);
        int iV = aeeVar.v();
        if (iV <= 0) {
            return null;
        }
        int i = ikVar.d;
        long jN = aeu.N(iV, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int iO = aeeVar.o();
        int iO2 = aeeVar.o();
        int iO3 = aeeVar.o();
        aeeVar.k(2);
        long j3 = j2 + ikVar.c;
        long[] jArr = new long[iO];
        long[] jArr2 = new long[iO];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iO) {
            int i3 = iO2;
            long j5 = j3;
            jArr[i2] = (i2 * jN) / iO;
            jArr2[i2] = Math.max(j4, j5);
            if (iO3 == 1) {
                iN = aeeVar.n();
            } else if (iO3 == 2) {
                iN = aeeVar.o();
            } else if (iO3 == 3) {
                iN = aeeVar.r();
            } else {
                if (iO3 != 4) {
                    return null;
                }
                iN = aeeVar.B();
            }
            j4 += iN * i3;
            i2++;
            j3 = j5;
            iO2 = i3;
        }
        if (j != -1 && j != j4) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(j4);
            Log.w("VbriSeeker", sb.toString());
        }
        return new ma(jArr, jArr2, jN, j4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        int iAn = aeu.an(this.a, j, true);
        kp kpVar = new kp(this.a[iAn], this.b[iAn]);
        if (kpVar.b < j) {
            long[] jArr = this.a;
            if (iAn != jArr.length - 1) {
                int i = iAn + 1;
                return new km(kpVar, new kp(jArr[i], this.b[i]));
            }
        }
        return new km(kpVar, kpVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public final long d(long j) {
        return this.a[aeu.an(this.b, j, true)];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.lz
    public final long e() {
        return this.d;
    }
}
