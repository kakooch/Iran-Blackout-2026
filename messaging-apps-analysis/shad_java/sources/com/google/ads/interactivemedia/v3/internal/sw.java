package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sw implements tv, tu {
    public final tv a;
    final long b;
    private tu c;
    private sv[] d = new sv[0];
    private long e = 0;

    public sw(tv tvVar, long j) {
        this.a = tvVar;
        this.b = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void a(tu tuVar, long j) {
        this.c = tuVar;
        this.a.a(this, j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void b() throws IOException {
        this.a.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final vj c() {
        return this.a.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    @Override // com.google.ads.interactivemedia.v3.internal.tv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(com.google.ads.interactivemedia.v3.internal.aba[] r14, boolean[] r15, com.google.ads.interactivemedia.v3.internal.vb[] r16, boolean[] r17, long r18) {
        /*
            r13 = this;
            r0 = r13
            r1 = r16
            int r2 = r1.length
            com.google.ads.interactivemedia.v3.internal.sv[] r3 = new com.google.ads.interactivemedia.v3.internal.sv[r2]
            r0.d = r3
            com.google.ads.interactivemedia.v3.internal.vb[] r2 = new com.google.ads.interactivemedia.v3.internal.vb[r2]
            r3 = 0
            r4 = 0
        Lc:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L21
            com.google.ads.interactivemedia.v3.internal.sv[] r5 = r0.d
            r6 = r1[r4]
            com.google.ads.interactivemedia.v3.internal.sv r6 = (com.google.ads.interactivemedia.v3.internal.sv) r6
            r5[r4] = r6
            if (r6 == 0) goto L1c
            com.google.ads.interactivemedia.v3.internal.vb r11 = r6.a
        L1c:
            r2[r4] = r11
            int r4 = r4 + 1
            goto Lc
        L21:
            com.google.ads.interactivemedia.v3.internal.tv r4 = r0.a
            r5 = r14
            r6 = r15
            r7 = r2
            r8 = r17
            r9 = r18
            long r4 = r4.d(r5, r6, r7, r8, r9)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.e = r6
            r6 = 1
            int r7 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r7 == 0) goto L4e
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 < 0) goto L4d
            long r7 = r0.b
            r9 = -9223372036854775808
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 == 0) goto L4e
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 > 0) goto L4d
            goto L4e
        L4d:
            r6 = 0
        L4e:
            com.google.ads.interactivemedia.v3.internal.ary.q(r6)
        L51:
            int r6 = r1.length
            if (r3 >= r6) goto L77
            r6 = r2[r3]
            if (r6 != 0) goto L5d
            com.google.ads.interactivemedia.v3.internal.sv[] r6 = r0.d
            r6[r3] = r11
            goto L6e
        L5d:
            com.google.ads.interactivemedia.v3.internal.sv[] r7 = r0.d
            r8 = r7[r3]
            if (r8 == 0) goto L67
            com.google.ads.interactivemedia.v3.internal.vb r8 = r8.a
            if (r8 == r6) goto L6e
        L67:
            com.google.ads.interactivemedia.v3.internal.sv r8 = new com.google.ads.interactivemedia.v3.internal.sv
            r8.<init>(r13, r6)
            r7[r3] = r8
        L6e:
            com.google.ads.interactivemedia.v3.internal.sv[] r6 = r0.d
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L51
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.sw.d(com.google.ads.interactivemedia.v3.internal.aba[], boolean[], com.google.ads.interactivemedia.v3.internal.vb[], boolean[], long):long");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void e(long j, boolean z) {
        this.a.e(j, false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        this.a.f(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long g() {
        if (p()) {
            long j = this.e;
            this.e = -9223372036854775807L;
            long jG = g();
            return jG != -9223372036854775807L ? jG : j;
        }
        long jG2 = this.a.g();
        if (jG2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        ary.q(jG2 >= 0);
        long j2 = this.b;
        ary.q(j2 == Long.MIN_VALUE || jG2 <= j2);
        return jG2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        long jH = this.a.h();
        if (jH != Long.MIN_VALUE) {
            long j = this.b;
            if (j == Long.MIN_VALUE || jH < j) {
                return jH;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    @Override // com.google.ads.interactivemedia.v3.internal.tv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long i(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.e = r0
            com.google.ads.interactivemedia.v3.internal.sv[] r0 = r7.d
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.a()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.ads.interactivemedia.v3.internal.tv r0 = r7.a
            long r0 = r0.i(r8)
            r3 = 1
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L35
            r8 = 0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L36
            long r8 = r7.b
            r4 = -9223372036854775808
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L35
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 > 0) goto L36
        L35:
            r2 = 1
        L36:
            com.google.ads.interactivemedia.v3.internal.ary.q(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.sw.i(long):long");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long j(long j, eg egVar) {
        if (j == 0) {
            return 0L;
        }
        long jI = aeu.I(egVar.c, 0L, j);
        long j2 = egVar.d;
        long j3 = this.b;
        long jI2 = aeu.I(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (jI != egVar.c || jI2 != egVar.d) {
            egVar = new eg(jI, jI2);
        }
        return this.a.j(j, egVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tu
    public final void k(tv tvVar) {
        tu tuVar = this.c;
        ary.t(tuVar);
        tuVar.k(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        long jL = this.a.l();
        if (jL != Long.MIN_VALUE) {
            long j = this.b;
            if (j == Long.MIN_VALUE || jL < j) {
                return jL;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vc
    public final /* bridge */ /* synthetic */ void m(vd vdVar) {
        tu tuVar = this.c;
        ary.t(tuVar);
        tuVar.m(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        return this.a.n(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        return this.a.o();
    }

    final boolean p() {
        return this.e != -9223372036854775807L;
    }
}
