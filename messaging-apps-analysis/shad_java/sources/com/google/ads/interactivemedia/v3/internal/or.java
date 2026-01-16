package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class or implements oh {
    private final pf a;
    private String b;
    private kr c;
    private oq d;
    private boolean e;
    private long l;
    private long m;
    private final boolean[] f = new boolean[3];
    private final ov g = new ov(32);
    private final ov h = new ov(33);
    private final ov i = new ov(34);
    private final ov j = new ov(39);
    private final ov k = new ov(40);
    private final aee n = new aee();

    public or(pf pfVar) {
        this.a = pfVar;
    }

    private final void f(byte[] bArr, int i, int i2) {
        this.d.c(bArr, i, i2);
        if (!this.e) {
            this.g.d(bArr, i, i2);
            this.h.d(bArr, i, i2);
            this.i.d(bArr, i, i2);
        }
        this.j.d(bArr, i, i2);
        this.k.d(bArr, i, i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.l = 0L;
        aec.d(this.f);
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        oq oqVar = this.d;
        if (oqVar != null) {
            oqVar.a();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.b = pqVar.c();
        kr krVarAk = kaVar.ak(pqVar.b(), 2);
        this.c = krVarAk;
        this.d = new oq(krVarAk);
        this.a.a(kaVar, pqVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.m = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x02cf  */
    @Override // com.google.ads.interactivemedia.v3.internal.oh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.ads.interactivemedia.v3.internal.aee r30) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.or.d(com.google.ads.interactivemedia.v3.internal.aee):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }
}
