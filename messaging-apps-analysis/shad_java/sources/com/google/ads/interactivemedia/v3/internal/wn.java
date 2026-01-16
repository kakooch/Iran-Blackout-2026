package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class wn extends es {
    private final long b;
    private final long c;
    private final long d;
    private final int e;
    private final long f;
    private final long g;
    private final long h;
    private final xj i;
    private final dg j;

    public wn(long j, long j2, long j3, int i, long j4, long j5, long j6, xj xjVar, dg dgVar) {
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = i;
        this.f = j4;
        this.g = j5;
        this.h = j6;
        this.i = xjVar;
        this.j = dgVar;
    }

    private static boolean a(xj xjVar) {
        return xjVar.d && xjVar.e != -9223372036854775807L && xjVar.b == -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[PHI: r1
      0x002b: PHI (r1v2 long) = (r1v1 long), (r1v5 long) binds: [B:6:0x001b, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.ads.interactivemedia.v3.internal.es
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.er f(int r26, com.google.ads.interactivemedia.v3.internal.er r27, long r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = 1
            r2 = r26
            com.google.ads.interactivemedia.v3.internal.ary.u(r2, r1)
            long r1 = r0.h
            com.google.ads.interactivemedia.v3.internal.xj r3 = r0.i
            boolean r3 = a(r3)
            r4 = -1
            if (r3 != 0) goto L17
        L13:
            r18 = r1
            goto L99
        L17:
            r5 = 0
            int r3 = (r28 > r5 ? 1 : (r28 == r5 ? 0 : -1))
            if (r3 <= 0) goto L2b
            long r1 = r1 + r28
            long r5 = r0.g
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 <= 0) goto L2b
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L13
        L2b:
            long r5 = r0.f
            long r5 = r5 + r1
            com.google.ads.interactivemedia.v3.internal.xj r3 = r0.i
            r7 = 0
            long r8 = r3.e(r7)
            r3 = 0
        L36:
            com.google.ads.interactivemedia.v3.internal.xj r10 = r0.i
            int r10 = r10.b()
            int r10 = r10 + r4
            if (r3 >= r10) goto L4d
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 < 0) goto L4d
            long r5 = r5 - r8
            int r3 = r3 + 1
            com.google.ads.interactivemedia.v3.internal.xj r8 = r0.i
            long r8 = r8.e(r3)
            goto L36
        L4d:
            com.google.ads.interactivemedia.v3.internal.xj r10 = r0.i
            com.google.ads.interactivemedia.v3.internal.xo r3 = r10.c(r3)
            java.util.List<com.google.ads.interactivemedia.v3.internal.xi> r10 = r3.c
            int r10 = r10.size()
            r11 = 0
        L5a:
            if (r11 >= r10) goto L6c
            java.util.List<com.google.ads.interactivemedia.v3.internal.xi> r12 = r3.c
            java.lang.Object r12 = r12.get(r11)
            com.google.ads.interactivemedia.v3.internal.xi r12 = (com.google.ads.interactivemedia.v3.internal.xi) r12
            int r12 = r12.b
            r13 = 2
            if (r12 == r13) goto L6d
            int r11 = r11 + 1
            goto L5a
        L6c:
            r11 = -1
        L6d:
            if (r11 != r4) goto L70
            goto L13
        L70:
            java.util.List<com.google.ads.interactivemedia.v3.internal.xi> r3 = r3.c
            java.lang.Object r3 = r3.get(r11)
            com.google.ads.interactivemedia.v3.internal.xi r3 = (com.google.ads.interactivemedia.v3.internal.xi) r3
            java.util.List<com.google.ads.interactivemedia.v3.internal.xt> r3 = r3.c
            java.lang.Object r3 = r3.get(r7)
            com.google.ads.interactivemedia.v3.internal.xt r3 = (com.google.ads.interactivemedia.v3.internal.xt) r3
            com.google.ads.interactivemedia.v3.internal.wx r3 = r3.l()
            if (r3 == 0) goto L13
            int r7 = r3.g(r8)
            if (r7 != 0) goto L8d
            goto L13
        L8d:
            long r7 = r3.a(r5, r8)
            long r7 = r3.b(r7)
            long r1 = r1 + r7
            long r1 = r1 - r5
            goto L13
        L99:
            java.lang.Object r6 = com.google.ads.interactivemedia.v3.internal.er.a
            com.google.ads.interactivemedia.v3.internal.dg r7 = r0.j
            com.google.ads.interactivemedia.v3.internal.xj r1 = r0.i
            r8 = r1
            long r9 = r0.b
            long r11 = r0.c
            long r13 = r0.d
            r15 = 1
            boolean r16 = a(r1)
            com.google.ads.interactivemedia.v3.internal.xj r1 = r0.i
            boolean r1 = r1.d
            r17 = r1
            long r1 = r0.g
            r20 = r1
            int r1 = r25.t()
            int r22 = r1 + (-1)
            long r1 = r0.f
            r23 = r1
            r5 = r27
            r5.b(r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r23)
            return r27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.wn.f(int, com.google.ads.interactivemedia.v3.internal.er, long):com.google.ads.interactivemedia.v3.internal.er");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final eq h(int i, eq eqVar, boolean z) {
        ary.u(i, t());
        return eqVar.l(z ? this.i.c(i).a : null, z ? Integer.valueOf(this.e + i) : null, this.i.e(i), bi.b(this.i.c(i).b - this.i.c(0).b) - this.f);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int i(Object obj) {
        int iIntValue;
        if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.e) >= 0 && iIntValue < t()) {
            return iIntValue;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final Object j(int i) {
        ary.u(i, t());
        return Integer.valueOf(this.e + i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int s() {
        return 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int t() {
        return this.i.b();
    }
}
