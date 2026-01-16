package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class og implements oh {
    private final List<pn> a;
    private final kr[] b;
    private boolean c;
    private int d;
    private int e;
    private long f;

    public og(List<pn> list) {
        this.a = list;
        this.b = new kr[list.size()];
    }

    private final boolean f(aee aeeVar, int i) {
        if (aeeVar.d() == 0) {
            return false;
        }
        if (aeeVar.n() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.c = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        for (int i = 0; i < this.b.length; i++) {
            pn pnVar = this.a.get(i);
            pqVar.a();
            kr krVarAk = kaVar.ak(pqVar.b(), 3);
            cx cxVar = new cx();
            cxVar.S(pqVar.c());
            cxVar.ae("application/dvbsubs");
            cxVar.T(Collections.singletonList(pnVar.b));
            cxVar.V(pnVar.a);
            krVarAk.a(cxVar.a());
            this.b[i] = krVarAk;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        this.f = j;
        this.e = 0;
        this.d = 2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void d(aee aeeVar) {
        if (this.c) {
            if (this.d != 2 || f(aeeVar, 32)) {
                if (this.d != 1 || f(aeeVar, 0)) {
                    int iG = aeeVar.g();
                    int iD = aeeVar.d();
                    for (kr krVar : this.b) {
                        aeeVar.h(iG);
                        krVar.d(aeeVar, iD);
                    }
                    this.e += iD;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
        if (this.c) {
            for (kr krVar : this.b) {
                krVar.b(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }
}
