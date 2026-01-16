package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class nw implements jy {
    public static final /* synthetic */ int a = 0;
    private final nx b = new nx();
    private final aee c = new aee(2786);
    private boolean d;

    static {
        int i = nv.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.b.b(kaVar, new pq(0, 1));
        kaVar.al();
        kaVar.am(new kn(-9223372036854775807L));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.d = false;
        this.b.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        if ((r4 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
    
        r8.j();
        r4 = r4 + 1;
     */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.ads.interactivemedia.v3.internal.jv r8) throws java.io.IOException {
        /*
            r7 = this;
            com.google.ads.interactivemedia.v3.internal.aee r0 = new com.google.ads.interactivemedia.v3.internal.aee
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.i()
            r8.g(r4, r2, r1)
            r0.h(r2)
            int r4 = r0.r()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L5f
            r8.j()
            r8.i(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.i()
            r6 = 6
            r8.g(r5, r2, r6)
            r0.h(r2)
            int r5 = r0.o()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L47
            r8.j()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L43
            return r2
        L43:
            r8.i(r4)
            goto L23
        L47:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L4d
            return r5
        L4d:
            byte[] r5 = r0.i()
            int r5 = com.google.ads.interactivemedia.v3.internal.gp.d(r5)
            r6 = -1
            if (r5 != r6) goto L59
            return r2
        L59:
            int r5 = r5 + (-6)
            r8.i(r5)
            goto L24
        L5f:
            r4 = 3
            r0.k(r4)
            int r4 = r0.A()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.i(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.nw.g(com.google.ads.interactivemedia.v3.internal.jv):boolean");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        int iA = jvVar.a(this.c.i(), 0, 2786);
        if (iA == -1) {
            return -1;
        }
        this.c.h(0);
        this.c.f(iA);
        if (!this.d) {
            this.b.c(0L, 4);
            this.d = true;
        }
        this.b.d(this.c);
        return 0;
    }
}
