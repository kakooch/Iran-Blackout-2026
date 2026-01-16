package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kk implements ko {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final boolean d;

    public kk(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        ary.o(length == length2);
        boolean z = length2 > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.a = jArr;
            this.b = jArr2;
        } else {
            int i = length2 + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.c = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        if (!this.d) {
            kp kpVar = kp.a;
            return new km(kpVar, kpVar);
        }
        int iAn = aeu.an(this.b, j, true);
        kp kpVar2 = new kp(this.b[iAn], this.a[iAn]);
        if (kpVar2.b != j) {
            long[] jArr = this.b;
            if (iAn != jArr.length - 1) {
                int i = iAn + 1;
                return new km(kpVar2, new kp(jArr[i], this.a[i]));
            }
        }
        return new km(kpVar2, kpVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.c;
    }
}
