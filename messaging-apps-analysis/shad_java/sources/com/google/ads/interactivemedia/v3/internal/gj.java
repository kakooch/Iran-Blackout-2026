package com.google.ads.interactivemedia.v3.internal;

import android.view.Surface;
import java.io.IOException;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gj implements dw, hi, afu, uh, abp, jf, afk, gu {
    private final adt<gl> a = new adt<>();
    private final adk b;
    private final eq c;
    private final er d;
    private final gi e;
    private dx f;
    private boolean g;

    public gj(adk adkVar) {
        this.b = adkVar;
        eq eqVar = new eq();
        this.c = eqVar;
        this.d = new er();
        this.e = new gi(eqVar);
    }

    private final gk P(tw twVar) {
        ary.t(this.f);
        es esVarE = twVar == null ? null : this.e.e(twVar);
        if (twVar != null && esVarE != null) {
            return O(esVarE, esVarE.g(twVar.a, this.c).c, twVar);
        }
        int iM = this.f.m();
        es esVarU = this.f.u();
        if (iM >= esVarU.s()) {
            esVarU = es.a;
        }
        return O(esVarU, iM, null);
    }

    private final gk Q() {
        return P(this.e.a());
    }

    private final gk R() {
        return P(this.e.b());
    }

    private final gk S() {
        return P(this.e.c());
    }

    private final gk T(int i, tw twVar) {
        ary.t(this.f);
        if (twVar != null) {
            return this.e.e(twVar) != null ? P(twVar) : O(es.a, i, twVar);
        }
        es esVarU = this.f.u();
        if (i >= esVarU.s()) {
            esVarU = es.a;
        }
        return O(esVarU, i, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void A(final String str, long j, final long j2) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, str, j2) { // from class: com.google.ads.interactivemedia.v3.internal.fx
            private final gk a;
            private final String b;
            private final long c;

            {
                this.a = gkVarS;
                this.b = str;
                this.c = j2;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.b();
                glVar.l();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void B(final cy cyVar) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, cyVar) { // from class: com.google.ads.interactivemedia.v3.internal.gd
            private final gk a;
            private final cy b;

            {
                this.a = gkVarS;
                this.b = cyVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.e();
                glVar.m();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void C(final long j) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, j) { // from class: com.google.ads.interactivemedia.v3.internal.ge
            private final gk a;
            private final long b;

            {
                this.a = gkVarS;
                this.b = j;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).f();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void D(final int i, final long j, final long j2) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, i, j, j2) { // from class: com.google.ads.interactivemedia.v3.internal.gf
            private final gk a;
            private final int b;
            private final long c;
            private final long d;

            {
                this.a = gkVarS;
                this.b = i;
                this.c = j;
                this.d = j2;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).h();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void E(final iu iuVar) {
        final gk gkVarR = R();
        this.a.e(new adr(gkVarR, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.gg
            private final gk a;
            private final iu b;

            {
                this.a = gkVarR;
                this.b = iuVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.c();
                glVar.j();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void F(final boolean z) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, z) { // from class: com.google.ads.interactivemedia.v3.internal.ew
            private final gk a;
            private final boolean b;

            {
                this.a = gkVarS;
                this.b = z;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).F();
            }
        });
    }

    public final void G(gl glVar) {
        ary.t(glVar);
        this.a.a(glVar);
    }

    public final void H(gl glVar) {
        this.a.b(glVar);
    }

    public final void I(dx dxVar) {
        boolean z = true;
        if (this.f != null && !this.e.b.isEmpty()) {
            z = false;
        }
        ary.q(z);
        this.f = dxVar;
    }

    public final void J(List<tw> list, tw twVar) {
        gi giVar = this.e;
        dx dxVar = this.f;
        ary.t(dxVar);
        giVar.h(list, twVar, dxVar);
    }

    public final void K() {
        if (this.g) {
            return;
        }
        final gk gkVarQ = Q();
        this.g = true;
        this.a.e(new adr(gkVarQ) { // from class: com.google.ads.interactivemedia.v3.internal.ev
            private final gk a;

            {
                this.a = gkVarQ;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).E();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afk
    public final void L() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afk
    public final void M(final int i, final int i2) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, i, i2) { // from class: com.google.ads.interactivemedia.v3.internal.ff
            private final gk a;
            private final int b;
            private final int c;

            {
                this.a = gkVarS;
                this.b = i;
                this.c = i2;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).H();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abp
    public final void N(final int i, final long j, final long j2) {
        final gk gkVarP = P(this.e.d());
        this.a.e(new adr(gkVarP, i, j, j2) { // from class: com.google.ads.interactivemedia.v3.internal.gc
            private final gk a;
            private final int b;
            private final long c;
            private final long d;

            {
                this.a = gkVarP;
                this.b = i;
                this.c = j;
                this.d = j2;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).i();
            }
        });
    }

    protected final gk O(es esVar, int i, tw twVar) {
        tw twVar2 = true == esVar.u() ? null : twVar;
        long jA = this.b.a();
        boolean z = esVar.equals(this.f.u()) && i == this.f.m();
        long jA2 = 0;
        if (twVar2 == null || !twVar2.b()) {
            if (z) {
                jA2 = this.f.t();
            } else if (!esVar.u()) {
                jA2 = esVar.v(i, this.d).a();
            }
        } else if (z && this.f.r() == twVar2.b && this.f.s() == twVar2.c) {
            jA2 = this.f.o();
        }
        return new gk(jA, esVar, i, twVar2, jA2, this.f.u(), this.f.m(), this.e.a(), this.f.o(), this.f.p());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void U(int i, tw twVar, final to toVar, final tt ttVar) {
        final gk gkVarT = T(i, twVar);
        this.a.e(new adr(gkVarT, toVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.fg
            private final gk a;
            private final to b;
            private final tt c;

            {
                this.a = gkVarT;
                this.b = toVar;
                this.c = ttVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).u();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void V(int i, tw twVar, final to toVar, final tt ttVar) {
        final gk gkVarT = T(i, twVar);
        this.a.e(new adr(gkVarT, toVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.fh
            private final gk a;
            private final to b;
            private final tt c;

            {
                this.a = gkVarT;
                this.b = toVar;
                this.c = ttVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).s();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void W(int i, tw twVar, final to toVar, final tt ttVar) {
        final gk gkVarT = T(i, twVar);
        this.a.e(new adr(gkVarT, toVar, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.fi
            private final gk a;
            private final to b;
            private final tt c;

            {
                this.a = gkVarT;
                this.b = toVar;
                this.c = ttVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).r();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void X(int i, tw twVar, final to toVar, final tt ttVar, final IOException iOException, final boolean z) {
        final gk gkVarT = T(i, twVar);
        this.a.e(new adr(gkVarT, toVar, ttVar, iOException, z) { // from class: com.google.ads.interactivemedia.v3.internal.fj
            private final gk a;
            private final to b;
            private final tt c;
            private final IOException d;
            private final boolean e;

            {
                this.a = gkVarT;
                this.b = toVar;
                this.c = ttVar;
                this.d = iOException;
                this.e = z;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).t();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void Y(int i, tw twVar, final tt ttVar) {
        final gk gkVarT = T(i, twVar);
        this.a.e(new adr(gkVarT, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.fk
            private final gk a;
            private final tt b;

            {
                this.a = gkVarT;
                this.b = ttVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).K();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void Z(int i, tw twVar, final tt ttVar) {
        final gk gkVarT = T(i, twVar);
        this.a.e(new adr(gkVarT, ttVar) { // from class: com.google.ads.interactivemedia.v3.internal.fl
            private final gk a;
            private final tt b;

            {
                this.a = gkVarT;
                this.b = ttVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).n();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void a(final iu iuVar) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.ex
            private final gk a;
            private final iu b;

            {
                this.a = gkVarS;
                this.b = iuVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.N();
                glVar.k();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void b(final String str, long j, final long j2) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, str, j2) { // from class: com.google.ads.interactivemedia.v3.internal.ey
            private final gk a;
            private final String b;
            private final long c;

            {
                this.a = gkVarS;
                this.b = str;
                this.c = j2;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.L();
                glVar.l();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void c(final cy cyVar) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, cyVar) { // from class: com.google.ads.interactivemedia.v3.internal.ez
            private final gk a;
            private final cy b;

            {
                this.a = gkVarS;
                this.b = cyVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.P();
                glVar.m();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void d(final int i, final long j) {
        final gk gkVarR = R();
        this.a.e(new adr(gkVarR, i, j) { // from class: com.google.ads.interactivemedia.v3.internal.fa
            private final gk a;
            private final int b;
            private final long c;

            {
                this.a = gkVarR;
                this.b = i;
                this.c = j;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).o();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void e(final int i, final int i2, final int i3, final float f) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, i, i2, i3, f) { // from class: com.google.ads.interactivemedia.v3.internal.fe
            private final gk a;
            private final int b;
            private final int c;
            private final int d;
            private final float e;

            {
                this.a = gkVarS;
                this.b = i;
                this.c = i2;
                this.d = i3;
                this.e = f;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).Q();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void f(final Surface surface) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, surface) { // from class: com.google.ads.interactivemedia.v3.internal.fc
            private final gk a;
            private final Surface b;

            {
                this.a = gkVarS;
                this.b = surface;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).C();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void g(es esVar, final int i) {
        gi giVar = this.e;
        dx dxVar = this.f;
        ary.t(dxVar);
        giVar.g(dxVar);
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, i) { // from class: com.google.ads.interactivemedia.v3.internal.fm
            private final gk a;
            private final int b;

            {
                this.a = gkVarQ;
                this.b = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).I();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void h(final dg dgVar, final int i) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, dgVar, i) { // from class: com.google.ads.interactivemedia.v3.internal.fn
            private final gk a;
            private final dg b;
            private final int c;

            {
                this.a = gkVarQ;
                this.b = dgVar;
                this.c = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).v();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void i(final vj vjVar, final abb abbVar) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, vjVar, abbVar) { // from class: com.google.ads.interactivemedia.v3.internal.fp
            private final gk a;
            private final vj b;
            private final abb c;

            {
                this.a = gkVarQ;
                this.b = vjVar;
                this.c = abbVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).J();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void j(final List<qz> list) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, list) { // from class: com.google.ads.interactivemedia.v3.internal.fq
            private final gk a;
            private final List b;

            {
                this.a = gkVarQ;
                this.b = list;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).G();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void k(final boolean z) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, z) { // from class: com.google.ads.interactivemedia.v3.internal.fr
            private final gk a;
            private final boolean b;

            {
                this.a = gkVarQ;
                this.b = z;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).p();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void l(final boolean z, final int i) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, z, i) { // from class: com.google.ads.interactivemedia.v3.internal.fs
            private final gk a;
            private final boolean b;
            private final int c;

            {
                this.a = gkVarQ;
                this.b = z;
                this.c = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).A(this.c);
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void m(final int i) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, i) { // from class: com.google.ads.interactivemedia.v3.internal.ft
            private final gk a;
            private final int b;

            {
                this.a = gkVarQ;
                this.b = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).y();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void n(final boolean z, final int i) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, z, i) { // from class: com.google.ads.interactivemedia.v3.internal.fu
            private final gk a;
            private final boolean b;
            private final int c;

            {
                this.a = gkVarQ;
                this.b = z;
                this.c = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).w();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void o(final int i) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, i) { // from class: com.google.ads.interactivemedia.v3.internal.fv
            private final gk a;
            private final int b;

            {
                this.a = gkVarQ;
                this.b = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).z();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void p(final boolean z) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, z) { // from class: com.google.ads.interactivemedia.v3.internal.fw
            private final gk a;
            private final boolean b;

            {
                this.a = gkVarQ;
                this.b = z;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).q();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void q(final bn bnVar) {
        tw twVar = bnVar.h;
        final gk gkVarP = twVar != null ? P(twVar) : Q();
        this.a.e(new adr(gkVarP, bnVar) { // from class: com.google.ads.interactivemedia.v3.internal.fy
            private final gk a;
            private final bn b;

            {
                this.a = gkVarP;
                this.b = bnVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).a(this.a, this.b);
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void r(final int i) {
        if (i == 1) {
            this.g = false;
            i = 1;
        }
        gi giVar = this.e;
        dx dxVar = this.f;
        ary.t(dxVar);
        giVar.f(dxVar);
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, i) { // from class: com.google.ads.interactivemedia.v3.internal.fz
            private final gk a;
            private final int b;

            {
                this.a = gkVarQ;
                this.b = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).B(this.b);
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void s(final dv dvVar) {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ, dvVar) { // from class: com.google.ads.interactivemedia.v3.internal.ga
            private final gk a;
            private final dv b;

            {
                this.a = gkVarQ;
                this.b = dvVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).x();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void t() {
        final gk gkVarQ = Q();
        this.a.e(new adr(gkVarQ) { // from class: com.google.ads.interactivemedia.v3.internal.gb
            private final gk a;

            {
                this.a = gkVarQ;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).D();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void u() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dw
    public final void v() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void w(final iu iuVar) {
        final gk gkVarR = R();
        this.a.e(new adr(gkVarR, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.fb
            private final gk a;
            private final iu b;

            {
                this.a = gkVarR;
                this.b = iuVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.M();
                glVar.j();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.afu
    public final void x(final long j, final int i) {
        final gk gkVarR = R();
        this.a.e(new adr(gkVarR, j, i) { // from class: com.google.ads.interactivemedia.v3.internal.fd
            private final gk a;
            private final long b;
            private final int c;

            {
                this.a = gkVarR;
                this.b = j;
                this.c = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).O();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void y(final iu iuVar) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, iuVar) { // from class: com.google.ads.interactivemedia.v3.internal.fo
            private final gk a;
            private final iu b;

            {
                this.a = gkVarS;
                this.b = iuVar;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                gl glVar = (gl) obj;
                glVar.d();
                glVar.k();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hi
    public final void z(final int i) {
        final gk gkVarS = S();
        this.a.e(new adr(gkVarS, i) { // from class: com.google.ads.interactivemedia.v3.internal.gh
            private final gk a;
            private final int b;

            {
                this.a = gkVarS;
                this.b = i;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.adr
            public final void a(Object obj) {
                ((gl) obj).g();
            }
        });
    }
}
