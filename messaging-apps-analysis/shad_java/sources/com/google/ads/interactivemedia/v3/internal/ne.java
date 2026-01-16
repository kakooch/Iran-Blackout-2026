package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ne {
    public final nb a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public ne(nb nbVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        int length = iArr.length;
        int length2 = jArr2.length;
        ary.o(length == length2);
        int length3 = jArr.length;
        ary.o(length3 == length2);
        int length4 = iArr2.length;
        ary.o(length4 == length2);
        this.a = nbVar;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = length3;
        if (length4 > 0) {
            int i2 = length4 - 1;
            iArr2[i2] = iArr2[i2] | 536870912;
        }
    }

    public final int a(long j) {
        for (int iAn = aeu.an(this.f, j, false); iAn >= 0; iAn--) {
            if ((this.g[iAn] & 1) != 0) {
                return iAn;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int iAk = aeu.ak(this.f, j, true); iAk < this.f.length; iAk++) {
            if ((this.g[iAk] & 1) != 0) {
                return iAk;
            }
        }
        return -1;
    }
}
