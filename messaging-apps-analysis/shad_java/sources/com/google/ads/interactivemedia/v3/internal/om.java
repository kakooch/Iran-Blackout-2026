package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class om implements oh {
    private static final float[] a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final ps b;
    private final aee c;
    private final boolean[] d;
    private final ok e;
    private final ov f;
    private ol g;
    private long h;
    private String i;
    private kr j;
    private boolean k;
    private long l;

    public om() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        aec.d(this.d);
        this.e.a();
        ol olVar = this.g;
        if (olVar != null) {
            olVar.a();
        }
        ov ovVar = this.f;
        if (ovVar != null) {
            ovVar.a();
        }
        this.h = 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.i = pqVar.c();
        kr krVarAk = kaVar.ak(pqVar.b(), 2);
        this.j = krVarAk;
        this.g = new ol(krVarAk);
        ps psVar = this.b;
        if (psVar != null) {
            psVar.a(kaVar, pqVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.l = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0182  */
    @Override // com.google.ads.interactivemedia.v3.internal.oh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.ads.interactivemedia.v3.internal.aee r19) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.om.d(com.google.ads.interactivemedia.v3.internal.aee):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }

    om(ps psVar) {
        this.b = psVar;
        this.d = new boolean[4];
        this.e = new ok();
        this.f = new ov(178);
        this.c = new aee();
    }
}
