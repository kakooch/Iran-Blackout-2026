package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xa {
    public final xt a;
    public final wx b;
    final vs c;
    private final long d;
    private final long e;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    xa(long r13, int r15, com.google.ads.interactivemedia.v3.internal.xt r16, boolean r17, java.util.List<com.google.ads.interactivemedia.v3.internal.cy> r18, com.google.ads.interactivemedia.v3.internal.kr r19) {
        /*
            r12 = this;
            r3 = r16
            r0 = r18
            com.google.ads.interactivemedia.v3.internal.cy r1 = r3.b
            java.lang.String r1 = r1.k
            boolean r2 = com.google.ads.interactivemedia.v3.internal.adz.c(r1)
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 != 0) goto L4b
            com.google.ads.interactivemedia.v3.internal.cy r2 = r3.b
            int r7 = com.google.ads.interactivemedia.v3.internal.aeu.a
            r8 = 30
            if (r7 >= r8) goto L1b
        L19:
            r2 = r6
            goto L47
        L1b:
            java.lang.String r7 = "com.google.ads.interactivemedia.v3.exoplayer2.source.MediaParserChunkExtractor"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch: java.lang.Exception -> L19
            r8 = 3
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch: java.lang.Exception -> L19
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L19
            r9[r4] = r10     // Catch: java.lang.Exception -> L19
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.cy> r10 = com.google.ads.interactivemedia.v3.internal.cy.class
            r9[r5] = r10     // Catch: java.lang.Exception -> L19
            java.lang.Class<java.util.List> r10 = java.util.List.class
            r11 = 2
            r9[r11] = r10     // Catch: java.lang.Exception -> L19
            java.lang.reflect.Constructor r7 = r7.getDeclaredConstructor(r9)     // Catch: java.lang.Exception -> L19
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Exception -> L19
            java.lang.Integer r9 = java.lang.Integer.valueOf(r15)     // Catch: java.lang.Exception -> L19
            r8[r4] = r9     // Catch: java.lang.Exception -> L19
            r8[r5] = r2     // Catch: java.lang.Exception -> L19
            r8[r11] = r0     // Catch: java.lang.Exception -> L19
            java.lang.Object r2 = r7.newInstance(r8)     // Catch: java.lang.Exception -> L19
            com.google.ads.interactivemedia.v3.internal.vs r2 = (com.google.ads.interactivemedia.v3.internal.vs) r2     // Catch: java.lang.Exception -> L19
        L47:
            if (r2 == 0) goto L4b
            r4 = r2
            goto L86
        L4b:
            boolean r2 = com.google.ads.interactivemedia.v3.internal.adz.c(r1)
            if (r2 == 0) goto L63
            java.lang.String r0 = "application/x-rawcc"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L61
            com.google.ads.interactivemedia.v3.internal.nu r0 = new com.google.ads.interactivemedia.v3.internal.nu
            com.google.ads.interactivemedia.v3.internal.cy r1 = r3.b
            r0.<init>(r1)
            goto L7d
        L61:
            r4 = r6
            goto L86
        L63:
            boolean r1 = com.google.ads.interactivemedia.v3.internal.adz.l(r1)
            if (r1 == 0) goto L6f
            com.google.ads.interactivemedia.v3.internal.lr r0 = new com.google.ads.interactivemedia.v3.internal.lr
            r0.<init>(r5)
            goto L7d
        L6f:
            r1 = r17
            if (r5 == r1) goto L74
            goto L75
        L74:
            r4 = 4
        L75:
            com.google.ads.interactivemedia.v3.internal.ms r1 = new com.google.ads.interactivemedia.v3.internal.ms
            r2 = r19
            r1.<init>(r4, r6, r0, r2)
            r0 = r1
        L7d:
            com.google.ads.interactivemedia.v3.internal.vs r1 = new com.google.ads.interactivemedia.v3.internal.vs
            com.google.ads.interactivemedia.v3.internal.cy r2 = r3.b
            r4 = r15
            r1.<init>(r0, r15, r2)
            r4 = r1
        L86:
            r5 = 0
            com.google.ads.interactivemedia.v3.internal.wx r7 = r16.l()
            r0 = r12
            r1 = r13
            r3 = r16
            r0.<init>(r1, r3, r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xa.<init>(long, int, com.google.ads.interactivemedia.v3.internal.xt, boolean, java.util.List, com.google.ads.interactivemedia.v3.internal.kr):void");
    }

    private xa(long j, xt xtVar, vs vsVar, long j2, wx wxVar) {
        this.d = j;
        this.a = xtVar;
        this.e = j2;
        this.c = vsVar;
        this.b = wxVar;
    }

    final xa a(long j, xt xtVar) throws st {
        long jA;
        wx wxVarL = this.a.l();
        wx wxVarL2 = xtVar.l();
        if (wxVarL == null) {
            return new xa(j, xtVar, this.c, this.e, null);
        }
        if (!wxVarL.j()) {
            return new xa(j, xtVar, this.c, this.e, wxVarL2);
        }
        int iG = wxVarL.g(j);
        if (iG == 0) {
            return new xa(j, xtVar, this.c, this.e, wxVarL2);
        }
        long jE = wxVarL.e();
        long jB = wxVarL.b(jE);
        long j2 = (iG + jE) - 1;
        long jB2 = wxVarL.b(j2) + wxVarL.c(j2, j);
        long jE2 = wxVarL2.e();
        long jB3 = wxVarL2.b(jE2);
        long j3 = this.e;
        if (jB2 == jB3) {
            jA = j3 + ((j2 + 1) - jE2);
        } else {
            if (jB2 < jB3) {
                throw new st();
            }
            jA = jB3 < jB ? j3 - (wxVarL2.a(jB, j) - jE) : j3 + (wxVarL.a(jB3, j) - jE2);
        }
        return new xa(j, xtVar, this.c, jA, wxVarL2);
    }

    final xa b(wx wxVar) {
        return new xa(this.d, this.a, this.c, this.e, wxVar);
    }

    public final long c() {
        return this.b.e() + this.e;
    }

    public final long d(long j) {
        return this.b.f(this.d, j) + this.e;
    }

    public final int e() {
        return this.b.g(this.d);
    }

    public final long f(long j) {
        return this.b.b(j - this.e);
    }

    public final long g(long j) {
        return f(j) + this.b.c(j - this.e, this.d);
    }

    public final long h(long j) {
        return this.b.a(j, this.d) + this.e;
    }

    public final xq i(long j) {
        return this.b.d(j - this.e);
    }

    public final long j(long j) {
        return (d(j) + this.b.h(this.d, j)) - 1;
    }

    public final boolean k(long j, long j2) {
        return g(j) <= j2;
    }
}
