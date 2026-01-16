package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aai extends aak {
    private final long d;
    private final long e;
    private final long f;
    private final float g;
    private final adk h;
    private float i;
    private int j;
    private int k;
    private long l;
    private wc m;
    private final aag n;

    /* synthetic */ aai(vh vhVar, int[] iArr, aag aagVar, long j, long j2, long j3, float f, adk adkVar) {
        super(vhVar, iArr);
        this.n = aagVar;
        this.d = 10000000L;
        this.e = 25000000L;
        this.f = 25000000L;
        this.g = 0.75f;
        this.h = adkVar;
        this.i = 1.0f;
        this.k = 0;
        this.l = -9223372036854775807L;
    }

    static /* synthetic */ long[][][] j(long[][] jArr) {
        int i;
        int length = jArr.length;
        double[][] dArr = new double[length][];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            dArr[i2] = new double[jArr[i2].length];
            int i3 = 0;
            while (true) {
                long[] jArr2 = jArr[i2];
                if (i3 < jArr2.length) {
                    double[] dArr2 = dArr[i2];
                    long j = jArr2[i3];
                    dArr2[i3] = j == -1 ? 0.0d : Math.log(j);
                    i3++;
                }
            }
        }
        double[][] dArr3 = new double[length][];
        for (int i4 = 0; i4 < length; i4++) {
            double[] dArr4 = dArr[i4];
            int length2 = dArr4.length - 1;
            dArr3[i4] = new double[length2];
            if (length2 != 0) {
                double d = dArr4[length2] - dArr4[0];
                int i5 = 0;
                while (true) {
                    double[] dArr5 = dArr[i4];
                    if (i5 < dArr5.length - 1) {
                        int i6 = i5 + 1;
                        dArr3[i4][i5] = d == 0.0d ? 1.0d : (((dArr5[i5] + dArr5[i6]) * 0.5d) - dArr5[0]) / d;
                        i5 = i6;
                    }
                }
            }
        }
        int length3 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            length3 += dArr3[i7].length;
        }
        int i8 = length3 + 3;
        int i9 = 2;
        long[][][] jArr3 = (long[][][]) Array.newInstance((Class<?>) long.class, length, i8, 2);
        int[] iArr = new int[length];
        w(jArr3, 1, jArr, iArr);
        while (true) {
            i = i8 - 1;
            if (i9 >= i) {
                break;
            }
            double d2 = Double.MAX_VALUE;
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = iArr[i11];
                if (i12 + 1 != dArr[i11].length) {
                    double d3 = dArr3[i11][i12];
                    if (d3 < d2) {
                        i10 = i11;
                        d2 = d3;
                    }
                }
            }
            iArr[i10] = iArr[i10] + 1;
            w(jArr3, i9, jArr, iArr);
            i9++;
        }
        for (long[][] jArr4 : jArr3) {
            long[] jArr5 = jArr4[i];
            long[] jArr6 = jArr4[i8 - 2];
            long j2 = jArr6[0];
            jArr5[0] = j2 + j2;
            long j3 = jArr6[1];
            jArr5[1] = j3 + j3;
        }
        return jArr3;
    }

    private final int v(long j) {
        long jA = this.n.a();
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !t(i2, j)) {
                if (Math.round(m(i2).h * this.i) <= jA) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private static void w(long[][][] jArr, int i, long[][] jArr2, int[] iArr) {
        long j = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= jArr.length) {
                break;
            }
            long[] jArr3 = jArr[i2][i];
            long j2 = jArr2[i2][iArr[i2]];
            jArr3[1] = j2;
            j += j2;
            i2++;
        }
        for (long[][] jArr4 : jArr) {
            jArr4[i][0] = j;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int a() {
        return this.j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int b() {
        return this.k;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final Object c() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    @Override // com.google.ads.interactivemedia.v3.internal.aba
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(long r8, long r10, java.util.List<? extends com.google.ads.interactivemedia.v3.internal.wc> r12) {
        /*
            r7 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            int r2 = r7.k
            if (r2 != 0) goto L12
            r8 = 1
            r7.k = r8
            int r8 = r7.v(r0)
            r7.j = r8
            return
        L12:
            int r3 = r7.j
            boolean r4 = r12.isEmpty()
            r5 = -1
            if (r4 == 0) goto L1d
            r4 = -1
            goto L29
        L1d:
            java.lang.Object r4 = com.google.ads.interactivemedia.v3.internal.ary.a(r12)
            com.google.ads.interactivemedia.v3.internal.wc r4 = (com.google.ads.interactivemedia.v3.internal.wc) r4
            com.google.ads.interactivemedia.v3.internal.cy r4 = r4.f
            int r4 = r7.o(r4)
        L29:
            if (r4 == r5) goto L34
            java.lang.Object r12 = com.google.ads.interactivemedia.v3.internal.ary.a(r12)
            com.google.ads.interactivemedia.v3.internal.wc r12 = (com.google.ads.interactivemedia.v3.internal.wc) r12
            int r2 = r12.g
            r3 = r4
        L34:
            int r12 = r7.v(r0)
            boolean r0 = r7.t(r3, r0)
            if (r0 != 0) goto L72
            com.google.ads.interactivemedia.v3.internal.cy r0 = r7.m(r3)
            com.google.ads.interactivemedia.v3.internal.cy r1 = r7.m(r12)
            int r1 = r1.h
            int r0 = r0.h
            if (r1 <= r0) goto L69
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L62
            long r4 = r7.d
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 > 0) goto L62
            float r10 = (float) r10
            r11 = 1061158912(0x3f400000, float:0.75)
            float r10 = r10 * r11
            long r10 = (long) r10
            goto L64
        L62:
            long r10 = r7.d
        L64:
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L69
            goto L71
        L69:
            if (r1 >= r0) goto L72
            long r10 = r7.e
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 < 0) goto L72
        L71:
            r12 = r3
        L72:
            if (r12 != r3) goto L75
            goto L76
        L75:
            r2 = 3
        L76:
            r7.k = r2
            r7.j = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aai.d(long, long, java.util.List):void");
    }

    public final void e(long[][] jArr) {
        this.n.b(jArr);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aak, com.google.ads.interactivemedia.v3.internal.aba
    public final void f() {
        this.l = -9223372036854775807L;
        this.m = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aak, com.google.ads.interactivemedia.v3.internal.aba
    public final void g() {
        this.m = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aak, com.google.ads.interactivemedia.v3.internal.aba
    public final void h(float f) {
        this.i = f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aak, com.google.ads.interactivemedia.v3.internal.aba
    public final int i(long j, List<? extends wc> list) {
        int i;
        int i2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.l;
        if (j2 != -9223372036854775807L && jElapsedRealtime - j2 < 1000 && (list.isEmpty() || ((wc) ary.a(list)).equals(this.m))) {
            return list.size();
        }
        this.l = jElapsedRealtime;
        this.m = list.isEmpty() ? null : (wc) ary.a(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jP = aeu.P(list.get(size - 1).i - j, this.i);
        long j3 = this.f;
        if (jP < j3) {
            return size;
        }
        cy cyVarM = m(v(jElapsedRealtime));
        for (int i3 = 0; i3 < size; i3++) {
            wc wcVar = list.get(i3);
            cy cyVar = wcVar.f;
            if (aeu.P(wcVar.i - j, this.i) >= j3 && cyVar.h < cyVarM.h && (i = cyVar.r) != -1 && i < 720 && (i2 = cyVar.q) != -1 && i2 < 1280 && i < cyVarM.r) {
                return i3;
            }
        }
        return size;
    }
}
