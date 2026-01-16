package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kf implements ko {
    private final kh a;
    private final long b;

    public kf(kh khVar, long j) {
        this.a = khVar;
        this.b = j;
    }

    private final kp d(long j, long j2) {
        return new kp((j * 1000000) / this.a.e, this.b + j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        ary.s(this.a.k);
        kh khVar = this.a;
        kg kgVar = khVar.k;
        long[] jArr = kgVar.a;
        long[] jArr2 = kgVar.b;
        int iAn = aeu.an(jArr, khVar.b(j), false);
        kp kpVarD = d(iAn == -1 ? 0L : jArr[iAn], iAn != -1 ? jArr2[iAn] : 0L);
        if (kpVarD.b == j || iAn == jArr.length - 1) {
            return new km(kpVarD, kpVarD);
        }
        int i = iAn + 1;
        return new km(kpVarD, d(jArr[i], jArr2[i]));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.a.a();
    }
}
