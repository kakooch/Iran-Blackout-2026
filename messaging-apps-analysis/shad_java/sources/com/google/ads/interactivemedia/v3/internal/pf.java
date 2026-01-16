package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class pf {
    private final List<cy> a;
    private final kr[] b;

    public pf(List<cy> list) {
        this.a = list;
        this.b = new kr[list.size()];
    }

    public final void a(ka kaVar, pq pqVar) {
        for (int i = 0; i < this.b.length; i++) {
            pqVar.a();
            kr krVarAk = kaVar.ak(pqVar.b(), 3);
            cy cyVar = this.a.get(i);
            String str = cyVar.l;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            String strValueOf = String.valueOf(str);
            ary.p(z, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            String strC = cyVar.a;
            if (strC == null) {
                strC = pqVar.c();
            }
            cx cxVar = new cx();
            cxVar.S(strC);
            cxVar.ae(str);
            cxVar.ag(cyVar.d);
            cxVar.V(cyVar.c);
            cxVar.F(cyVar.D);
            cxVar.T(cyVar.n);
            krVarAk.a(cxVar.a());
            this.b[i] = krVarAk;
        }
    }

    public final void b(long j, aee aeeVar) {
        asn.o(j, aeeVar, this.b);
    }
}
