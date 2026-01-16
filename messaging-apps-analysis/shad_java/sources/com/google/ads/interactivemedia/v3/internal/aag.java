package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aag {
    private final abq a;
    private final float b = 0.7f;
    private final long c;
    private long[][] d;

    aag(abq abqVar, float f, long j) {
        this.a = abqVar;
        this.c = j;
    }

    public final long a() {
        long[][] jArr;
        long jMax = Math.max(0L, ((long) (this.a.a() * 0.7f)) - this.c);
        if (this.d == null) {
            return jMax;
        }
        int i = 1;
        while (true) {
            jArr = this.d;
            if (i >= jArr.length - 1 || jArr[i][0] >= jMax) {
                break;
            }
            i++;
        }
        long[] jArr2 = jArr[i - 1];
        long[] jArr3 = jArr[i];
        long j = jArr2[0];
        long j2 = jArr3[0];
        return jArr2[1] + ((long) (((jMax - j) / (j2 - j)) * (jArr3[1] - r4)));
    }

    final void b(long[][] jArr) {
        ary.o(jArr.length >= 2);
        this.d = jArr;
    }
}
