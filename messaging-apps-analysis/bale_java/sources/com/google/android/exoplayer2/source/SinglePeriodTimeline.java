package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import ir.nasim.AbstractC20011rK;

/* loaded from: classes2.dex */
public final class SinglePeriodTimeline extends J0 {
    private static final Object s = new Object();
    private static final C2018a0 t = new C2018a0.c().e("SinglePeriodTimeline").j(Uri.EMPTY).a();
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final long l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final Object p;
    private final C2018a0 q;
    private final C2018a0.g r;

    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, Object obj, C2018a0 c2018a0) {
        this(j, j, 0L, 0L, z, z2, z3, obj, c2018a0);
    }

    @Override // com.google.android.exoplayer2.J0
    public int g(Object obj) {
        return s.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.J0
    public J0.b l(int i, J0.b bVar, boolean z) {
        AbstractC20011rK.c(i, 0, 1);
        return bVar.v(null, z ? s : null, 0, this.i, -this.k);
    }

    @Override // com.google.android.exoplayer2.J0
    public int n() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.J0
    public Object r(int i) {
        AbstractC20011rK.c(i, 0, 1);
        return s;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[PHI: r1
      0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.J0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.J0.d t(int r25, com.google.android.exoplayer2.J0.d r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            ir.nasim.AbstractC20011rK.c(r3, r1, r2)
            long r1 = r0.l
            boolean r14 = r0.n
            if (r14 == 0) goto L2e
            boolean r3 = r0.o
            if (r3 != 0) goto L2e
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2e
            long r3 = r0.j
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = com.google.android.exoplayer2.J0.d.r
            com.google.android.exoplayer2.a0 r5 = r0.q
            java.lang.Object r6 = r0.p
            long r7 = r0.f
            long r9 = r0.g
            long r11 = r0.h
            boolean r13 = r0.m
            com.google.android.exoplayer2.a0$g r15 = r0.r
            long r1 = r0.j
            r18 = r1
            r21 = 0
            long r1 = r0.k
            r22 = r1
            r20 = 0
            r3 = r26
            com.google.android.exoplayer2.J0$d r1 = r3.j(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.t(int, com.google.android.exoplayer2.J0$d, long):com.google.android.exoplayer2.J0$d");
    }

    @Override // com.google.android.exoplayer2.J0
    public int u() {
        return 1;
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, Object obj, C2018a0 c2018a0) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, c2018a0, z3 ? c2018a0.d : null);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, C2018a0 c2018a0, C2018a0.g gVar) {
        this.f = j;
        this.g = j2;
        this.h = j3;
        this.i = j4;
        this.j = j5;
        this.k = j6;
        this.l = j7;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = obj;
        this.q = (C2018a0) AbstractC20011rK.e(c2018a0);
        this.r = gVar;
    }
}
