package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.wb1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C23239wb1 {
    public static final a m = new a(null);
    public static final int n = 8;
    private final C4670Gb1 a;
    private OI0 b;
    private boolean c;
    private int f;
    private int g;
    private int l;
    private final C5131Ia3 d = new C5131Ia3();
    private boolean e = true;
    private ArrayList h = DJ6.c(null, 1, null);
    private int i = -1;
    private int j = -1;
    private int k = -1;

    /* renamed from: ir.nasim.wb1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C23239wb1(C4670Gb1 c4670Gb1, OI0 oi0) {
        this.a = c4670Gb1;
        this.b = oi0;
    }

    private final void B() {
        C();
    }

    private final void C() {
        int i = this.g;
        if (i > 0) {
            this.b.I(i);
            this.g = 0;
        }
        if (DJ6.f(this.h)) {
            this.b.k(DJ6.k(this.h));
            DJ6.a(this.h);
        }
    }

    private final void D() {
        J(this, false, 1, null);
        L();
    }

    private final void E(boolean z) {
        I(z);
    }

    static /* synthetic */ void F(C23239wb1 c23239wb1, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c23239wb1.E(z);
    }

    private final void G(int i, int i2, int i3) {
        B();
        this.b.v(i, i2, i3);
    }

    private final void H() {
        int i = this.l;
        if (i > 0) {
            int i2 = this.i;
            if (i2 >= 0) {
                K(i2, i);
                this.i = -1;
            } else {
                G(this.k, this.j, i);
                this.j = -1;
                this.k = -1;
            }
            this.l = 0;
        }
    }

    private final void I(boolean z) {
        int iU = z ? r().u() : r().k();
        int i = iU - this.f;
        if (!(i >= 0)) {
            AbstractC5138Ib1.s("Tried to seek backward");
        }
        if (i > 0) {
            this.b.e(i);
            this.f = iU;
        }
    }

    static /* synthetic */ void J(C23239wb1 c23239wb1, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c23239wb1.I(z);
    }

    private final void K(int i, int i2) {
        B();
        this.b.y(i, i2);
    }

    private final void l(C6669Om c6669Om) {
        F(this, false, 1, null);
        this.b.p(c6669Om);
        this.c = true;
    }

    private final void m() {
        if (this.c || !this.e) {
            return;
        }
        F(this, false, 1, null);
        this.b.q();
        this.c = true;
    }

    private final C21176tE6 r() {
        return this.a.J0();
    }

    public final void A() {
        H();
        if (DJ6.f(this.h)) {
            DJ6.i(this.h);
        } else {
            this.g++;
        }
    }

    public final void L() {
        C21176tE6 c21176tE6R;
        int iU;
        if (r().x() <= 0 || this.d.f(-2) == (iU = (c21176tE6R = r()).u())) {
            return;
        }
        m();
        if (iU > 0) {
            C6669Om c6669OmA = c21176tE6R.a(iU);
            this.d.h(iU);
            l(c6669OmA);
        }
    }

    public final void M() {
        C();
        if (this.c) {
            V();
            k();
        }
    }

    public final void N(ZM5 zm5) {
        this.b.w(zm5);
    }

    public final void O() {
        D();
        this.b.x();
        this.f += r().p();
    }

    public final void P(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                AbstractC5138Ib1.s("Invalid remove index " + i);
            }
            if (this.i == i) {
                this.l += i2;
                return;
            }
            H();
            this.i = i;
            this.l = i2;
        }
    }

    public final void Q() {
        this.b.z();
    }

    public final void R() {
        this.c = false;
        this.d.a();
        this.f = 0;
    }

    public final void S(OI0 oi0) {
        this.b = oi0;
    }

    public final void T(boolean z) {
        this.e = z;
    }

    public final void U(SA2 sa2) {
        this.b.A(sa2);
    }

    public final void V() {
        this.b.B();
    }

    public final void W(PJ5 pj5) {
        this.b.C(pj5);
    }

    public final void X(int i) {
        if (i > 0) {
            D();
            this.b.D(i);
        }
    }

    public final void Y(Object obj, C6669Om c6669Om, int i) {
        this.b.E(obj, c6669Om, i);
    }

    public final void Z(Object obj) {
        F(this, false, 1, null);
        this.b.F(obj);
    }

    public final void a(C6669Om c6669Om, Object obj) {
        this.b.f(c6669Om, obj);
    }

    public final void a0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        B();
        this.b.G(obj, interfaceC14603iB2);
    }

    public final void b(List list, C3478Ba3 c3478Ba3) {
        this.b.g(list, c3478Ba3);
    }

    public final void b0(Object obj, int i) {
        E(true);
        this.b.H(obj, i);
    }

    public final void c(AbstractC20278rk4 abstractC20278rk4, AbstractC7050Qb1 abstractC7050Qb1, C20869sk4 c20869sk4, C20869sk4 c20869sk42) {
        this.b.h(abstractC20278rk4, abstractC7050Qb1, c20869sk4, c20869sk42);
    }

    public final void c0(Object obj) {
        B();
        this.b.J(obj);
    }

    public final void d() {
        F(this, false, 1, null);
        this.b.i();
    }

    public final void e(C3478Ba3 c3478Ba3, C6669Om c6669Om) {
        C();
        this.b.j(c3478Ba3, c6669Om);
    }

    public final void f(UA2 ua2, InterfaceC6806Pb1 interfaceC6806Pb1) {
        this.b.l(ua2, interfaceC6806Pb1);
    }

    public final void g() {
        int iU = r().u();
        if (!(this.d.f(-1) <= iU)) {
            AbstractC5138Ib1.s("Missed recording an endGroup");
        }
        if (this.d.f(-1) == iU) {
            F(this, false, 1, null);
            this.d.g();
            this.b.m();
        }
    }

    public final void h() {
        this.b.n();
        this.f = 0;
    }

    public final void i() {
        H();
    }

    public final void j(PJ5 pj5) {
        this.b.o(pj5);
    }

    public final void k() {
        if (this.c) {
            F(this, false, 1, null);
            F(this, false, 1, null);
            this.b.m();
            this.c = false;
        }
    }

    public final void n() {
        C();
        if (this.d.b == 0) {
            return;
        }
        AbstractC5138Ib1.s("Missed recording an endGroup()");
    }

    public final OI0 o() {
        return this.b;
    }

    public final boolean p() {
        return this.e;
    }

    public final boolean q() {
        return r().u() - this.f < 0;
    }

    public final void s(OI0 oi0, C3478Ba3 c3478Ba3) {
        this.b.r(oi0, c3478Ba3);
    }

    public final void t(C6669Om c6669Om, C21850uE6 c21850uE6) {
        C();
        D();
        H();
        this.b.s(c6669Om, c21850uE6);
    }

    public final void u(C6669Om c6669Om, C21850uE6 c21850uE6, C21604tp2 c21604tp2) {
        C();
        D();
        H();
        this.b.t(c6669Om, c21850uE6, c21604tp2);
    }

    public final void v(int i) {
        D();
        this.b.u(i);
    }

    public final void w(Object obj) {
        H();
        DJ6.j(this.h, obj);
    }

    public final void x(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.l;
            if (i4 > 0 && this.j == i - i4 && this.k == i2 - i4) {
                this.l = i4 + i3;
                return;
            }
            H();
            this.j = i;
            this.k = i2;
            this.l = i3;
        }
    }

    public final void y(int i) {
        this.f += i - r().k();
    }

    public final void z(int i) {
        this.f = i;
    }
}
