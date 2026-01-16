package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ou implements oh {
    private final aee a;
    private final ik b;
    private final String c;
    private kr d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public ou() {
        this(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.e = pqVar.c();
        this.d = kaVar.ak(pqVar.b(), 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.l = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void d(aee aeeVar) {
        ary.s(this.d);
        while (aeeVar.d() > 0) {
            int i = this.f;
            if (i == 0) {
                byte[] bArrI = aeeVar.i();
                int iG = aeeVar.g();
                int iE = aeeVar.e();
                while (true) {
                    if (iG >= iE) {
                        aeeVar.h(iE);
                        break;
                    }
                    byte b = bArrI[iG];
                    boolean z = (b & 255) == 255;
                    boolean z2 = this.i && (b & 224) == 224;
                    this.i = z;
                    if (z2) {
                        aeeVar.h(iG + 1);
                        this.i = false;
                        this.a.i()[1] = bArrI[iG];
                        this.g = 2;
                        this.f = 1;
                        break;
                    }
                    iG++;
                }
            } else if (i != 1) {
                int iMin = Math.min(aeeVar.d(), this.k - this.g);
                this.d.d(aeeVar, iMin);
                int i2 = this.g + iMin;
                this.g = i2;
                int i3 = this.k;
                if (i2 >= i3) {
                    this.d.b(this.l, 1, i3, 0, null);
                    this.l += this.j;
                    this.g = 0;
                    this.f = 0;
                }
            } else {
                int iMin2 = Math.min(aeeVar.d(), 4 - this.g);
                aeeVar.m(this.a.i(), this.g, iMin2);
                int i4 = this.g + iMin2;
                this.g = i4;
                if (i4 >= 4) {
                    this.a.h(0);
                    if (this.b.a(this.a.v())) {
                        this.k = this.b.c;
                        if (!this.h) {
                            this.j = (r0.g * 1000000) / r0.d;
                            cx cxVar = new cx();
                            cxVar.S(this.e);
                            cxVar.ae(this.b.b);
                            cxVar.W(4096);
                            cxVar.H(this.b.e);
                            cxVar.af(this.b.d);
                            cxVar.V(this.c);
                            this.d.a(cxVar.a());
                            this.h = true;
                        }
                        this.a.h(0);
                        this.d.d(this.a, 4);
                        this.f = 2;
                    } else {
                        this.g = 0;
                        this.f = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }

    public ou(String str) {
        this.f = 0;
        aee aeeVar = new aee(4);
        this.a = aeeVar;
        aeeVar.i()[0] = -1;
        this.b = new ik();
        this.c = str;
    }
}
