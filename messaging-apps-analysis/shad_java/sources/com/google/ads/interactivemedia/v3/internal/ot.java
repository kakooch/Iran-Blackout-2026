package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ot implements oh {
    private final String a;
    private final aee b;
    private final aed c;
    private kr d;
    private String e;
    private cy f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;

    public ot(String str) {
        this.a = str;
        aee aeeVar = new aee(1024);
        this.b = aeeVar;
        this.c = new aed(aeeVar.i());
    }

    private final int f(aed aedVar) throws dt {
        int iC = aedVar.c();
        gm gmVarB = gn.b(aedVar, true);
        this.u = gmVarB.c;
        this.r = gmVarB.a;
        this.t = gmVarB.b;
        return iC - aedVar.c();
    }

    private static long g(aed aedVar) {
        return aedVar.i((aedVar.i(2) + 1) * 8);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.g = 0;
        this.l = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.d = kaVar.ak(pqVar.b(), 1);
        this.e = pqVar.c();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.k = j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void d(aee aeeVar) throws dt {
        int i;
        int i2;
        int i3;
        boolean zH;
        ary.s(this.d);
        while (aeeVar.d() > 0) {
            int i4 = this.g;
            if (i4 != 0) {
                if (i4 == 1) {
                    int iN = aeeVar.n();
                    if ((iN & 224) == 224) {
                        this.j = iN;
                        this.g = 2;
                    } else if (iN != 86) {
                        this.g = 0;
                    }
                } else if (i4 != 2) {
                    int iMin = Math.min(aeeVar.d(), this.i - this.h);
                    aeeVar.m(this.c.a, this.h, iMin);
                    int i5 = this.h + iMin;
                    this.h = i5;
                    if (i5 == this.i) {
                        this.c.e(0);
                        aed aedVar = this.c;
                        if (aedVar.h()) {
                            if (this.l) {
                            }
                            this.g = 0;
                        } else {
                            this.l = true;
                            int i6 = aedVar.i(1);
                            if (i6 == 1) {
                                i3 = aedVar.i(1);
                                i2 = 1;
                            } else {
                                i2 = i6;
                                i3 = 0;
                            }
                            this.m = i3;
                            if (i3 != 0) {
                                throw new dt();
                            }
                            if (i2 == 1) {
                                g(aedVar);
                            }
                            if (!aedVar.h()) {
                                throw new dt();
                            }
                            this.n = aedVar.i(6);
                            int i7 = aedVar.i(4);
                            int i8 = aedVar.i(3);
                            if (i7 != 0 || i8 != 0) {
                                throw new dt();
                            }
                            if (i2 == 0) {
                                int iD = aedVar.d();
                                int iF = f(aedVar);
                                aedVar.e(iD);
                                byte[] bArr = new byte[(iF + 7) / 8];
                                aedVar.m(bArr, iF);
                                cx cxVar = new cx();
                                cxVar.S(this.e);
                                cxVar.ae(MediaController.AUIDO_MIME_TYPE);
                                cxVar.I(this.u);
                                cxVar.H(this.t);
                                cxVar.af(this.r);
                                cxVar.T(Collections.singletonList(bArr));
                                cxVar.V(this.a);
                                cy cyVarA = cxVar.a();
                                if (!cyVarA.equals(this.f)) {
                                    this.f = cyVarA;
                                    this.s = 1024000000 / cyVarA.z;
                                    this.d.a(cyVarA);
                                }
                            } else {
                                aedVar.g(((int) g(aedVar)) - f(aedVar));
                            }
                            int i9 = aedVar.i(3);
                            this.o = i9;
                            if (i9 == 0) {
                                aedVar.g(8);
                            } else if (i9 == 1) {
                                aedVar.g(9);
                            } else if (i9 == 3 || i9 == 4 || i9 == 5) {
                                aedVar.g(6);
                            } else {
                                if (i9 != 6 && i9 != 7) {
                                    throw new IllegalStateException();
                                }
                                aedVar.g(1);
                            }
                            boolean zH2 = aedVar.h();
                            this.p = zH2;
                            this.q = 0L;
                            if (zH2) {
                                if (i2 != 1) {
                                    do {
                                        zH = aedVar.h();
                                        this.q = (this.q << 8) + aedVar.i(8);
                                    } while (zH);
                                } else {
                                    this.q = g(aedVar);
                                }
                            }
                            if (aedVar.h()) {
                                aedVar.g(8);
                            }
                        }
                        if (this.m != 0) {
                            throw new dt();
                        }
                        if (this.n != 0) {
                            throw new dt();
                        }
                        if (this.o != 0) {
                            throw new dt();
                        }
                        int i10 = 0;
                        while (true) {
                            int i11 = aedVar.i(8);
                            i = i10 + i11;
                            if (i11 != 255) {
                                break;
                            } else {
                                i10 = i;
                            }
                        }
                        int iD2 = aedVar.d();
                        if ((iD2 & 7) == 0) {
                            this.b.h(iD2 >> 3);
                        } else {
                            aedVar.m(this.b.i(), i * 8);
                            this.b.h(0);
                        }
                        this.d.d(this.b, i);
                        this.d.b(this.k, 1, i, 0, null);
                        this.k += this.s;
                        if (this.p) {
                            aedVar.g((int) this.q);
                        }
                        this.g = 0;
                    } else {
                        continue;
                    }
                } else {
                    int iN2 = ((this.j & (-225)) << 8) | aeeVar.n();
                    this.i = iN2;
                    if (iN2 > this.b.i().length) {
                        this.b.a(this.i);
                        this.c.a(this.b.i());
                    }
                    this.h = 0;
                    this.g = 3;
                }
            } else if (aeeVar.n() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }
}
