package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class gi {
    private final eq a;
    private arn<tw> b = arn.i();
    private ars<tw, es> c = ars.a();
    private tw d;
    private tw e;
    private tw f;

    public gi(eq eqVar) {
        this.a = eqVar;
    }

    private final void j(es esVar) {
        arq<tw, es> arqVarC = ars.c();
        if (this.b.isEmpty()) {
            k(arqVarC, this.e, esVar);
            if (!apz.b(this.f, this.e)) {
                k(arqVarC, this.f, esVar);
            }
            if (!apz.b(this.d, this.e) && !apz.b(this.d, this.f)) {
                k(arqVarC, this.d, esVar);
            }
        } else {
            for (int i = 0; i < this.b.size(); i++) {
                k(arqVarC, this.b.get(i), esVar);
            }
            if (!this.b.contains(this.d)) {
                k(arqVarC, this.d, esVar);
            }
        }
        this.c = arqVarC.a();
    }

    private final void k(arq<tw, es> arqVar, tw twVar, es esVar) {
        if (twVar == null) {
            return;
        }
        if (esVar.i(twVar.a) != -1) {
            arqVar.b(twVar, esVar);
            return;
        }
        es esVar2 = this.c.get(twVar);
        if (esVar2 != null) {
            arqVar.b(twVar, esVar2);
        }
    }

    private static tw l(dx dxVar, arn<tw> arnVar, tw twVar, eq eqVar) {
        es esVarU = dxVar.u();
        int iL = dxVar.l();
        Object objJ = esVarU.u() ? null : esVarU.j(iL);
        int iG = (dxVar.q() || esVarU.u()) ? -1 : esVarU.z(iL, eqVar).g(bi.b(dxVar.o()) - eqVar.b());
        for (int i = 0; i < arnVar.size(); i++) {
            tw twVar2 = arnVar.get(i);
            if (m(twVar2, objJ, dxVar.q(), dxVar.r(), dxVar.s(), iG)) {
                return twVar2;
            }
        }
        if (arnVar.isEmpty() && twVar != null) {
            if (m(twVar, objJ, dxVar.q(), dxVar.r(), dxVar.s(), iG)) {
                return twVar;
            }
        }
        return null;
    }

    private static boolean m(tw twVar, Object obj, boolean z, int i, int i2, int i3) {
        if (!twVar.a.equals(obj)) {
            return false;
        }
        if (z) {
            if (twVar.b != i || twVar.c != i2) {
                return false;
            }
        } else if (twVar.b != -1 || twVar.e != i3) {
            return false;
        }
        return true;
    }

    public final tw a() {
        return this.d;
    }

    public final tw b() {
        return this.e;
    }

    public final tw c() {
        return this.f;
    }

    public final tw d() {
        if (this.b.isEmpty()) {
            return null;
        }
        return (tw) ary.a(this.b);
    }

    public final es e(tw twVar) {
        return this.c.get(twVar);
    }

    public final void f(dx dxVar) {
        this.d = l(dxVar, this.b, this.e, this.a);
    }

    public final void g(dx dxVar) {
        this.d = l(dxVar, this.b, this.e, this.a);
        j(dxVar.u());
    }

    public final void h(List<tw> list, tw twVar, dx dxVar) {
        this.b = arn.l(list);
        if (!list.isEmpty()) {
            this.e = list.get(0);
            ary.t(twVar);
            this.f = twVar;
        }
        if (this.d == null) {
            this.d = l(dxVar, this.b, this.e, this.a);
        }
        j(dxVar.u());
    }
}
