package ir.nasim;

import ir.nasim.C3419Au3;

/* renamed from: ir.nasim.Fu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4594Fu3 {
    private final C3419Au3 a;
    private boolean b;
    private boolean c;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private GJ3 q;
    private C3419Au3.e d = C3419Au3.e.e;
    private final C10354bW3 p = new C10354bW3(this);

    public C4594Fu3(C3419Au3 c3419Au3) {
        this.a = c3419Au3;
    }

    public final XA4 A() {
        return this.a.t0().o();
    }

    public final int B() {
        return this.p.P0();
    }

    public final void C() {
        this.p.X1();
        GJ3 gj3 = this.q;
        if (gj3 != null) {
            gj3.V1();
        }
    }

    public final void D() {
        this.p.o2(true);
        GJ3 gj3 = this.q;
        if (gj3 != null) {
            gj3.j2(true);
        }
    }

    public final void E() {
        this.p.a2();
    }

    public final void F() {
        this.f = true;
        this.g = true;
    }

    public final void G() {
        this.e = true;
    }

    public final void H() {
        this.p.b2();
    }

    public final void I() {
        C3419Au3.e eVarG0 = this.a.g0();
        if (eVarG0 == C3419Au3.e.c || eVarG0 == C3419Au3.e.d) {
            if (this.p.J1()) {
                O(true);
            } else {
                N(true);
            }
        }
        if (eVarG0 == C3419Au3.e.d) {
            GJ3 gj3 = this.q;
            if (gj3 == null || !gj3.D1()) {
                S(true);
            } else {
                T(true);
            }
        }
    }

    public final void J(long j) {
        GJ3 gj3 = this.q;
        if (gj3 != null) {
            gj3.f2(j);
        }
    }

    public final void K() {
        AbstractC14349hm abstractC14349hmT;
        this.p.t().p();
        GJ3 gj3 = this.q;
        if (gj3 == null || (abstractC14349hmT = gj3.t()) == null) {
            return;
        }
        abstractC14349hmT.p();
    }

    public final void L(int i) {
        int i2 = this.l;
        this.l = i;
        if ((i2 == 0) != (i == 0)) {
            C3419Au3 c3419Au3A0 = this.a.A0();
            C4594Fu3 c4594Fu3E0 = c3419Au3A0 != null ? c3419Au3A0.e0() : null;
            if (c4594Fu3E0 != null) {
                if (i == 0) {
                    c4594Fu3E0.L(c4594Fu3E0.l - 1);
                } else {
                    c4594Fu3E0.L(c4594Fu3E0.l + 1);
                }
            }
        }
    }

    public final void M(int i) {
        int i2 = this.o;
        this.o = i;
        if ((i2 == 0) != (i == 0)) {
            C3419Au3 c3419Au3A0 = this.a.A0();
            C4594Fu3 c4594Fu3E0 = c3419Au3A0 != null ? c3419Au3A0.e0() : null;
            if (c4594Fu3E0 != null) {
                if (i == 0) {
                    c4594Fu3E0.M(c4594Fu3E0.o - 1);
                } else {
                    c4594Fu3E0.M(c4594Fu3E0.o + 1);
                }
            }
        }
    }

    public final void N(boolean z) {
        if (this.k != z) {
            this.k = z;
            if (z && !this.j) {
                L(this.l + 1);
            } else {
                if (z || this.j) {
                    return;
                }
                L(this.l - 1);
            }
        }
    }

    public final void O(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (z && !this.k) {
                L(this.l + 1);
            } else {
                if (z || this.k) {
                    return;
                }
                L(this.l - 1);
            }
        }
    }

    public final void P(boolean z) {
        this.b = z;
    }

    public final void Q(boolean z) {
        this.c = z;
    }

    public final void R(C3419Au3.e eVar) {
        this.d = eVar;
    }

    public final void S(boolean z) {
        if (this.n != z) {
            this.n = z;
            if (z && !this.m) {
                M(this.o + 1);
            } else {
                if (z || this.m) {
                    return;
                }
                M(this.o - 1);
            }
        }
    }

    public final void T(boolean z) {
        if (this.m != z) {
            this.m = z;
            if (z && !this.n) {
                M(this.o + 1);
            } else {
                if (z || this.n) {
                    return;
                }
                M(this.o - 1);
            }
        }
    }

    public final void U(boolean z) {
        this.f = z;
    }

    public final void V(boolean z) {
        this.g = z;
    }

    public final void W(boolean z) {
        this.e = z;
    }

    public final void X(int i) {
        this.h = i;
    }

    public final void Y(int i) {
        this.i = i;
    }

    public final void Z() {
        C3419Au3 c3419Au3A0;
        if (this.p.u2() && (c3419Au3A0 = this.a.A0()) != null) {
            C3419Au3.F1(c3419Au3A0, false, false, false, 7, null);
        }
        GJ3 gj3 = this.q;
        if (gj3 == null || !gj3.s2()) {
            return;
        }
        if (AbstractC4843Gu3.a(this.a)) {
            C3419Au3 c3419Au3A02 = this.a.A0();
            if (c3419Au3A02 != null) {
                C3419Au3.F1(c3419Au3A02, false, false, false, 7, null);
                return;
            }
            return;
        }
        C3419Au3 c3419Au3A03 = this.a.A0();
        if (c3419Au3A03 != null) {
            C3419Au3.B1(c3419Au3A03, false, false, false, 7, null);
        }
    }

    public final void a() {
        this.q = null;
    }

    public final void b() {
        if (this.q == null) {
            this.q = new GJ3(this);
        }
    }

    public final InterfaceC14957im c() {
        return this.p;
    }

    public final int d() {
        return this.l;
    }

    public final int e() {
        return this.o;
    }

    public final boolean f() {
        return this.k;
    }

    public final boolean g() {
        return this.j;
    }

    public final boolean h() {
        return this.b;
    }

    public final boolean i() {
        return this.c;
    }

    public final int j() {
        return this.p.A0();
    }

    public final C17833ne1 k() {
        return this.p.D1();
    }

    public final C17833ne1 l() {
        GJ3 gj3 = this.q;
        if (gj3 != null) {
            return gj3.s1();
        }
        return null;
    }

    public final C3419Au3 m() {
        return this.a;
    }

    public final boolean n() {
        return this.p.K1();
    }

    public final C3419Au3.e o() {
        return this.d;
    }

    public final InterfaceC14957im p() {
        return this.q;
    }

    public final boolean q() {
        return this.n;
    }

    public final boolean r() {
        return this.m;
    }

    public final boolean s() {
        return this.f;
    }

    public final boolean t() {
        return this.g;
    }

    public final boolean u() {
        return this.e;
    }

    public final GJ3 v() {
        return this.q;
    }

    public final C10354bW3 w() {
        return this.p;
    }

    public final boolean x() {
        return this.p.R1();
    }

    public final int y() {
        return this.h;
    }

    public final int z() {
        return this.i;
    }
}
