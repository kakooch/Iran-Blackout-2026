package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vf extends es {
    private static final Object b = new Object();
    private final long c;
    private final long d;
    private final long e = -9223372036854775807L;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final Object m;
    private final dg n;

    static {
        db dbVar = new db();
        dbVar.e("com.google.ads.interactivemedia.v3.exoplayer2.source.SinglePeriodTimeline");
        dbVar.h(Uri.EMPTY);
        dbVar.a();
    }

    public vf(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2, boolean z3, Object obj, dg dgVar) {
        this.c = j;
        this.d = j2;
        this.f = j3;
        this.g = j4;
        this.h = j5;
        this.i = j6;
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = obj;
        ary.t(dgVar);
        this.n = dgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[PHI: r1
      0x0029: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v5 long) binds: [B:3:0x0011, B:5:0x0017, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.ads.interactivemedia.v3.internal.es
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.er f(int r24, com.google.ads.interactivemedia.v3.internal.er r25, long r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = 1
            r2 = r24
            com.google.ads.interactivemedia.v3.internal.ary.u(r2, r1)
            long r1 = r0.i
            boolean r14 = r0.k
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r14 == 0) goto L29
            r5 = 0
            int r7 = (r26 > r5 ? 1 : (r26 == r5 ? 0 : -1))
            if (r7 == 0) goto L29
            long r5 = r0.g
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L22
        L1f:
            r16 = r3
            goto L2b
        L22:
            long r1 = r1 + r26
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L29
            goto L1f
        L29:
            r16 = r1
        L2b:
            java.lang.Object r4 = com.google.ads.interactivemedia.v3.internal.er.a
            com.google.ads.interactivemedia.v3.internal.dg r5 = r0.n
            java.lang.Object r6 = r0.m
            long r7 = r0.c
            long r9 = r0.d
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            boolean r13 = r0.j
            boolean r15 = r0.l
            long r1 = r0.g
            r18 = r1
            r20 = 0
            long r1 = r0.h
            r21 = r1
            r3 = r25
            r3.b(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21)
            return r25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.vf.f(int, com.google.ads.interactivemedia.v3.internal.er, long):com.google.ads.interactivemedia.v3.internal.er");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final eq h(int i, eq eqVar, boolean z) {
        ary.u(i, 1);
        return eqVar.l(null, z ? b : null, this.f, -this.h);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int i(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final Object j(int i) {
        ary.u(i, 1);
        return b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int s() {
        return 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int t() {
        return 1;
    }
}
