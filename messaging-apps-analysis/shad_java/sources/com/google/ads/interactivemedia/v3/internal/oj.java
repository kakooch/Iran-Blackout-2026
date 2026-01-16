package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class oj implements oh {
    private static final double[] c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String a;
    private kr b;
    private final ps d;
    private final aee e;
    private final ov f;
    private final boolean[] g;
    private final oi h;
    private long i;
    private boolean j;
    private boolean k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private boolean q;

    public oj() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        aec.d(this.g);
        this.h.a();
        ov ovVar = this.f;
        if (ovVar != null) {
            ovVar.a();
        }
        this.i = 0L;
        this.j = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.a = pqVar.c();
        this.b = kaVar.ak(pqVar.b(), 2);
        ps psVar = this.d;
        if (psVar != null) {
            psVar.a(kaVar, pqVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.m = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    @Override // com.google.ads.interactivemedia.v3.internal.oh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.ads.interactivemedia.v3.internal.aee r21) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.oj.d(com.google.ads.interactivemedia.v3.internal.aee):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }

    oj(ps psVar) {
        aee aeeVar;
        this.d = psVar;
        this.g = new boolean[4];
        this.h = new oi();
        if (psVar != null) {
            this.f = new ov(178);
            aeeVar = new aee();
        } else {
            aeeVar = null;
            this.f = null;
        }
        this.e = aeeVar;
    }
}
