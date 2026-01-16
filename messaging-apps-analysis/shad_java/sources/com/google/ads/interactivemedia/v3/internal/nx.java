package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class nx implements oh {
    private final aed a;
    private final aee b;
    private final String c;
    private String d;
    private kr e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private cy j;
    private int k;
    private long l;

    public nx() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.d = pqVar.c();
        this.e = kaVar.ak(pqVar.b(), 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.l = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void d(aee aeeVar) {
        ary.s(this.e);
        while (aeeVar.d() > 0) {
            int i = this.f;
            if (i == 0) {
                while (true) {
                    if (aeeVar.d() <= 0) {
                        break;
                    }
                    if (this.h) {
                        int iN = aeeVar.n();
                        if (iN == 119) {
                            this.h = false;
                            this.f = 1;
                            this.b.i()[0] = 11;
                            this.b.i()[1] = 119;
                            this.g = 2;
                            break;
                        }
                        this.h = iN == 11;
                    } else {
                        this.h = aeeVar.n() == 11;
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(aeeVar.d(), this.k - this.g);
                this.e.d(aeeVar, iMin);
                int i2 = this.g + iMin;
                this.g = i2;
                int i3 = this.k;
                if (i2 == i3) {
                    this.e.b(this.l, 1, i3, 0, null);
                    this.l += this.i;
                    this.f = 0;
                }
            } else {
                byte[] bArrI = this.b.i();
                int iMin2 = Math.min(aeeVar.d(), 128 - this.g);
                aeeVar.m(bArrI, this.g, iMin2);
                int i4 = this.g + iMin2;
                this.g = i4;
                if (i4 == 128) {
                    this.a.e(0);
                    go goVarC = gp.c(this.a);
                    cy cyVar = this.j;
                    if (cyVar == null || goVarC.c != cyVar.y || goVarC.b != cyVar.z || !aeu.c(goVarC.a, cyVar.l)) {
                        cx cxVar = new cx();
                        cxVar.S(this.d);
                        cxVar.ae(goVarC.a);
                        cxVar.H(goVarC.c);
                        cxVar.af(goVarC.b);
                        cxVar.V(this.c);
                        cy cyVarA = cxVar.a();
                        this.j = cyVarA;
                        this.e.a(cyVarA);
                    }
                    this.k = goVarC.d;
                    this.i = (goVarC.e * 1000000) / this.j.z;
                    this.b.h(0);
                    this.e.d(this.b, 128);
                    this.f = 2;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }

    public nx(String str) {
        aed aedVar = new aed(new byte[128]);
        this.a = aedVar;
        this.b = new aee(aedVar.a);
        this.f = 0;
        this.c = str;
    }
}
