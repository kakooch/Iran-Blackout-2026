package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class od implements oh {
    private static final byte[] a = {73, 68, 51};
    private final boolean b;
    private final aed c = new aed(new byte[7]);
    private final aee d = new aee(Arrays.copyOf(a, 10));
    private final String e;
    private String f;
    private kr g;
    private kr h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private long r;
    private int s;
    private long t;
    private kr u;
    private long v;

    public od(boolean z, String str) {
        i();
        this.n = -1;
        this.o = -1;
        this.r = -9223372036854775807L;
        this.b = z;
        this.e = str;
    }

    public static boolean f(int i) {
        return (i & 65526) == 65520;
    }

    private final void g() {
        this.m = false;
        i();
    }

    private final boolean h(aee aeeVar, byte[] bArr, int i) {
        int iMin = Math.min(aeeVar.d(), i - this.j);
        aeeVar.m(bArr, this.j, iMin);
        int i2 = this.j + iMin;
        this.j = i2;
        return i2 == i;
    }

    private final void i() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    private final void j(kr krVar, long j, int i, int i2) {
        this.i = 4;
        this.j = i;
        this.u = krVar;
        this.v = j;
        this.s = i2;
    }

    private final void k() {
        this.i = 3;
        this.j = 0;
    }

    private static final boolean l(byte b) {
        return f((b & 255) | 65280);
    }

    private static final boolean m(aee aeeVar, byte[] bArr, int i) {
        if (aeeVar.d() < i) {
            return false;
        }
        aeeVar.m(bArr, 0, i);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        g();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.f = pqVar.c();
        kr krVarAk = kaVar.ak(pqVar.b(), 1);
        this.g = krVarAk;
        this.u = krVarAk;
        if (!this.b) {
            this.h = new jx();
            return;
        }
        pqVar.a();
        kr krVarAk2 = kaVar.ak(pqVar.b(), 4);
        this.h = krVarAk2;
        cx cxVar = new cx();
        cxVar.S(pqVar.c());
        cxVar.ae("application/id3");
        krVarAk2.a(cxVar.a());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.t = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0251, code lost:
    
        r16.p = (r11 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0259, code lost:
    
        if (1 == ((r11 & 1) ^ 1)) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x025b, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x025d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x025e, code lost:
    
        r16.l = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0262, code lost:
    
        if (r16.m != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0264, code lost:
    
        r16.i = 1;
        r16.j = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x026a, code lost:
    
        k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x026d, code lost:
    
        r17.h(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0251 A[EDGE_INSN: B:141:0x0251->B:91:0x0251 BREAK  A[LOOP:1: B:45:0x019d->B:118:0x02ba], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0207  */
    @Override // com.google.ads.interactivemedia.v3.internal.oh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.ads.interactivemedia.v3.internal.aee r17) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.od.d(com.google.ads.interactivemedia.v3.internal.aee):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }
}
