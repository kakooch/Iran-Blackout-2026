package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class oc implements jy {
    public static final /* synthetic */ int a = 0;
    private final od b;
    private final aee c;
    private final aee d;
    private final aed e;
    private ka f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private boolean k;

    static {
        int i = ob.b;
    }

    public oc() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.f = kaVar;
        this.b.b(kaVar, new pq(0, 1));
        kaVar.al();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.j = false;
        this.b.a();
        this.g = j2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        r9.j();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        if ((r3 - r1) < 8192) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
    
        return false;
     */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.ads.interactivemedia.v3.internal.jv r9) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
        L2:
            com.google.ads.interactivemedia.v3.internal.aee r2 = r8.d
            byte[] r2 = r2.i()
            r3 = 10
            r9.g(r2, r0, r3)
            com.google.ads.interactivemedia.v3.internal.aee r2 = r8.d
            r2.h(r0)
            com.google.ads.interactivemedia.v3.internal.aee r2 = r8.d
            int r2 = r2.r()
            r3 = 4801587(0x494433, float:6.728456E-39)
            if (r2 == r3) goto L8a
            r9.j()
            r9.i(r1)
            long r2 = r8.h
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L2e
            long r2 = (long) r1
            r8.h = r2
        L2e:
            r3 = r1
        L2f:
            r2 = 0
            r4 = 0
        L31:
            com.google.ads.interactivemedia.v3.internal.aee r5 = r8.d
            byte[] r5 = r5.i()
            r6 = 2
            r9.g(r5, r0, r6)
            com.google.ads.interactivemedia.v3.internal.aee r5 = r8.d
            r5.h(r0)
            com.google.ads.interactivemedia.v3.internal.aee r5 = r8.d
            int r5 = r5.o()
            boolean r5 = com.google.ads.interactivemedia.v3.internal.od.f(r5)
            if (r5 != 0) goto L5c
            r9.j()
            int r3 = r3 + 1
            int r2 = r3 - r1
            r4 = 8192(0x2000, float:1.148E-41)
            if (r2 < r4) goto L58
            return r0
        L58:
            r9.i(r3)
            goto L2f
        L5c:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L67
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 > r7) goto L66
            goto L67
        L66:
            return r5
        L67:
            com.google.ads.interactivemedia.v3.internal.aee r5 = r8.d
            byte[] r5 = r5.i()
            r9.g(r5, r0, r6)
            com.google.ads.interactivemedia.v3.internal.aed r5 = r8.e
            r6 = 14
            r5.e(r6)
            com.google.ads.interactivemedia.v3.internal.aed r5 = r8.e
            r6 = 13
            int r5 = r5.i(r6)
            r6 = 6
            if (r5 > r6) goto L83
            return r0
        L83:
            int r6 = r5 + (-6)
            r9.i(r6)
            int r4 = r4 + r5
            goto L31
        L8a:
            com.google.ads.interactivemedia.v3.internal.aee r2 = r8.d
            r3 = 3
            r2.k(r3)
            com.google.ads.interactivemedia.v3.internal.aee r2 = r8.d
            int r2 = r2.A()
            int r3 = r2 + 10
            int r1 = r1 + r3
            r9.i(r2)
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.oc.g(com.google.ads.interactivemedia.v3.internal.jv):boolean");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        ary.s(this.f);
        int iA = jvVar.a(this.c.i(), 0, 2048);
        if (!this.k) {
            this.f.am(new kn(-9223372036854775807L));
            this.k = true;
        }
        if (iA == -1) {
            return -1;
        }
        this.c.h(0);
        this.c.f(iA);
        if (!this.j) {
            this.b.c(this.g, 4);
            this.j = true;
        }
        this.b.d(this.c);
        return 0;
    }

    public oc(byte[] bArr) {
        this.b = new od(true, null);
        this.c = new aee(2048);
        this.i = -1;
        this.h = -1L;
        aee aeeVar = new aee(10);
        this.d = aeeVar;
        this.e = new aed(aeeVar.i());
    }
}
