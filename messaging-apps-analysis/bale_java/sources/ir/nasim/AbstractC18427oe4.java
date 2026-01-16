package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.oe4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18427oe4 {
    protected C9057Yh4 a;

    public AbstractC18427oe4(C8468Wc1 c8468Wc1) {
        C12736f7.n().i("D_network", 1);
        C12736f7.n().i("D_db", 1);
        C12736f7.n().i("FILE_PATH_db", 1);
        C12736f7.n().i("D_heavy", 4);
        C12736f7.n().i("D_update", 2);
        this.a = new C9057Yh4(this, c8468Wc1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(C11458d25 c11458d25, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5K0 = this.a.G().k0(c11458d25);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5K0.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(C11458d25 c11458d25, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5R0 = this.a.G().r0(c11458d25);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5R0.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(int i, String str, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5G1 = this.a.E().G1(i, str);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5G1.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(int i, String str, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5J1 = this.a.E().J1(i, str);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5J1.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(String str, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5H0 = this.a.A().h0(str);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5H0.m0(new C9255Zd4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(int i, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5Z1 = this.a.E().Z1(i);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5Z1.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Td4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC15419jZ0.a((List) obj);
            }
        }).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(int i, int i2, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5T2 = this.a.E().t2(i, i2);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5T2.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5K = this.a.Y().K();
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5K.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(InterfaceC15419jZ0 interfaceC15419jZ0, DA da) {
        interfaceC15419jZ0.a(C18732p92.t(da));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(int i, int i2, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5M0 = this.a.E().a3(i, i2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.le4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AbstractC18427oe4.M0(interfaceC15419jZ0, (DA) obj);
            }
        });
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5M0.E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(int i, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5D3 = this.a.E().d3(i);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5D3.m0(new C9255Zd4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(int i, int i2, String str, C24119y45 c24119y45, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5G3 = this.a.E().g3(i, i2, str, c24119y45.d());
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5G3.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(int i, C24119y45 c24119y45, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5O3 = this.a.E().o3(i, c24119y45.d());
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5O3.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(int i, int i2, C24119y45 c24119y45, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5R3 = this.a.E().r3(i, i2, c24119y45 == null ? null : c24119y45.d());
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5R3.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(int i, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5L3 = this.a.E().l3(i);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5L3.m0(new C9255Zd4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(C11458d25 c11458d25, int i, long j, EnumC19802qy enumC19802qy, String str, String str2, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5X2 = this.a.G().x2(c11458d25, i, j, enumC19802qy, str, str2);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5X2.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Wd4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC15419jZ0.a((C23490x06) obj);
            }
        }).E(new C12454ee4(interfaceC15419jZ0));
    }

    public void A() {
        Y().T().B();
        Y().G().S1();
    }

    public boolean A0(C11458d25 c11458d25) {
        return this.a.S().H5(c11458d25);
    }

    public void A1(C11458d25 c11458d25, String str, int i, int i2, int i3, C22694vg2 c22694vg2, String str2, String str3, Long l, Long l2, String str4, C7880To7 c7880To7) {
        this.a.G().v2(c11458d25, str, i, i2, i3, c22694vg2, str2, str3, l, l2, str4, c7880To7);
    }

    public InterfaceC14830iZ0 B(final int i, final String str) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Yd4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.G0(i, str, interfaceC15419jZ0);
            }
        };
    }

    public boolean B0() {
        return this.a.S().N5();
    }

    public InterfaceC14830iZ0 B1(final C11458d25 c11458d25, final int i, final long j, final EnumC19802qy enumC19802qy, final String str, final String str2) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.me4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.T0(c11458d25, i, j, enumC19802qy, str, str2, interfaceC15419jZ0);
            }
        };
    }

    public InterfaceC14830iZ0 C(final int i, final String str) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Vd4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.H0(i, str, interfaceC15419jZ0);
            }
        };
    }

    public C6517Nv5 C0(C11458d25 c11458d25) {
        return this.a.E().q2(c11458d25);
    }

    public C6517Nv5 C1(C11458d25 c11458d25, long j, long j2, String str) {
        return this.a.G().y2(c11458d25, j, j2, str);
    }

    public C6517Nv5 D(String str) {
        return this.a.W().Z(str);
    }

    public InterfaceC14830iZ0 D0(final int i, final int i2) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.ce4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.K0(i, i2, interfaceC15419jZ0);
            }
        };
    }

    public void D1(C11458d25 c11458d25, String str, C7880To7 c7880To7) {
        this.a.G().A2(c11458d25, str, null, true, c7880To7);
    }

    public C6517Nv5 E(String str) {
        return this.a.W().f0(str);
    }

    public void E1(int i) {
        this.a.c().putInt("key_exception_tab", i);
    }

    public C6517Nv5 F(int i, String str) {
        return this.a.W().b0(i, str);
    }

    public void F1(FileReference fileReference) {
        this.a.D().g0(fileReference);
    }

    public String G(long j) {
        return this.a.D().N(j);
    }

    public List H(int i, String str, Boolean bool) {
        return this.a.E().O1(i, str, bool.booleanValue());
    }

    public InterfaceC14830iZ0 I(final String str) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Xd4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.I0(str, interfaceC15419jZ0);
            }
        };
    }

    public C6517Nv5 J(String str) {
        return this.a.A().h0(str);
    }

    public void K(C11458d25 c11458d25, C11458d25 c11458d252, List list, String str) {
        this.a.G().y0(c11458d25, c11458d252, list, str);
    }

    public int L() {
        return this.a.S().d0();
    }

    public int M() {
        return this.a.S().e0();
    }

    public C6517Nv5 N() {
        return this.a.G().J0().h();
    }

    public QE O() {
        return this.a.v().D();
    }

    public C5246In1 P(C11458d25 c11458d25) {
        return this.a.G().B0(c11458d25);
    }

    public int Q() {
        return this.a.S().V0();
    }

    public void R() {
        this.a.A().n0();
    }

    public String S() {
        return this.a.S().Q1();
    }

    public int T() {
        return d0().getInt("key_exception_tab", -1);
    }

    public C22481vJ2 U() {
        return this.a.v().E();
    }

    public C6517Nv5 U0(int i) {
        return this.a.E().x2(i);
    }

    public C14733iO2 V(int i) {
        return (C14733iO2) X().n(i);
    }

    public C6517Nv5 V0(ArrayList arrayList) {
        return this.a.W().w0(arrayList, false);
    }

    public C19482qQ7 W(int i) {
        return this.a.U().A(i).a();
    }

    public C6517Nv5 W0(int i) {
        return this.a.W().x0(i);
    }

    public VL3 X() {
        if (this.a.E() == null) {
            return null;
        }
        return this.a.E().Y1();
    }

    public int X0() {
        return this.a.w().p();
    }

    public C9057Yh4 Y() {
        return this.a;
    }

    public C6517Nv5 Y0(int i, long j) {
        return this.a.E().N2(i, j);
    }

    public C6517Nv5 Z(C11458d25 c11458d25, Long l, Long l2) {
        return this.a.y().B1(c11458d25, l.longValue(), l2.longValue());
    }

    public void Z0() {
        this.a.a().g(new XE(false));
        this.a.b().e(false);
    }

    public C6517Nv5 a0(C11458d25 c11458d25, Long l, Long l2) {
        return this.a.y().F1(c11458d25, l.longValue(), l2.longValue());
    }

    public void a1() {
        this.a.a().g(new XE(true));
        this.a.b().e(true);
    }

    public String b0() {
        return this.a.S().u3();
    }

    public void b1(C11458d25 c11458d25, boolean z) {
        this.a.G().T0().q(c11458d25, z);
    }

    public InterfaceC14830iZ0 c0(final int i) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.fe4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.J0(i, interfaceC15419jZ0);
            }
        };
    }

    public void c1(ArrayList arrayList) {
        this.a.a().f(new C13531gO2(arrayList, false));
    }

    public InterfaceC3570Bk5 d0() {
        return this.a.c();
    }

    public void d1(ArrayList arrayList) {
        this.a.a().f(new C13531gO2(arrayList, true));
    }

    public C14375ho5 e0() {
        return this.a.N();
    }

    public void e1() {
        Y().a().f(new EI7());
    }

    public C6517Nv5 f0(long j, C11458d25 c11458d25, long j2, long j3, String str) {
        return this.a.y().S1(j, c11458d25, j2, j3, str);
    }

    public void f1() {
        if (this.a.A() != null) {
            this.a.A().p0();
        }
    }

    public C19482qQ7 g0(int i) {
        return this.a.U().B(i).a();
    }

    public boolean g1() {
        return this.a.w().r();
    }

    public C6517Nv5 h0(int i) {
        return k0().k(i);
    }

    public C6517Nv5 h1(String str, Integer num, EnumC22278uy enumC22278uy, C11458d25 c11458d25, Long l, Long l2) {
        return this.a.G().X1(str, num, enumC22278uy, c11458d25, l, l2);
    }

    public C21231tK7 i0(int i) {
        return (C21231tK7) k0().n(i);
    }

    public InterfaceC14830iZ0 i1() {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.ne4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.L0(interfaceC15419jZ0);
            }
        };
    }

    public C6517Nv5 j0(int i, int i2) {
        return i == i2 ? this.a.W().l0(i) : C6517Nv5.F(new Exception("WRONG_BOT_USER_ID"));
    }

    public void j1(long j, String str) {
        this.a.P().F(j, str);
    }

    public VL3 k0() {
        return this.a.W().o0();
    }

    public InterfaceC14830iZ0 k1(int i) {
        return this.a.A().r0(i);
    }

    public boolean l0() {
        return this.a.S().j5();
    }

    public C6517Nv5 l1(long j) {
        return this.a.O().B(j);
    }

    public boolean m0() {
        return this.a.S().l5();
    }

    public C6517Nv5 m1() {
        return this.a.R().K();
    }

    public boolean n0(boolean z) {
        return z ? l0() : p0();
    }

    public InterfaceC14830iZ0 n1(final int i, final int i2) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.ke4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.N0(i, i2, interfaceC15419jZ0);
            }
        };
    }

    public boolean o0(boolean z) {
        return z ? m0() : q0();
    }

    public InterfaceC14830iZ0 o1(final int i) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Ud4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.O0(i, interfaceC15419jZ0);
            }
        };
    }

    public boolean p0() {
        return this.a.S().o5();
    }

    public InterfaceC14830iZ0 p1(final int i, final int i2, final String str, final C24119y45 c24119y45) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.je4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.P0(i, i2, str, c24119y45, interfaceC15419jZ0);
            }
        };
    }

    public InterfaceC7857Tm2 q(FileReference fileReference, boolean z, InterfaceC8091Um2 interfaceC8091Um2) {
        C8325Vm2 c8325Vm2 = new C8325Vm2(fileReference, z, this.a.D(), interfaceC8091Um2, false, true, false);
        c8325Vm2.init();
        return c8325Vm2;
    }

    public boolean q0() {
        return this.a.S().q5();
    }

    public void q1(List list, InterfaceC7850Tl4 interfaceC7850Tl4) {
        this.a.D().T(list, interfaceC7850Tl4);
    }

    public C11603dH7 r(long j, InterfaceC12246eH7 interfaceC12246eH7) {
        return new C11603dH7(j, interfaceC12246eH7, this.a.D());
    }

    public boolean r0() {
        return true;
    }

    public C6517Nv5 r1(ir.nasim.core.modules.banking.m mVar, ir.nasim.core.modules.banking.l lVar, EnumC15044iu7 enumC15044iu7, Long l) {
        return this.a.y().s2(mVar, lVar, enumC15044iu7, l.longValue());
    }

    public void s(long j) {
        this.a.D().H(j);
    }

    public boolean s0() {
        return this.a.S().w5();
    }

    public InterfaceC14830iZ0 s1(final int i, final C24119y45 c24119y45) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.ge4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.Q0(i, c24119y45, interfaceC15419jZ0);
            }
        };
    }

    public void t(C11458d25 c11458d25, boolean z) {
        this.a.S().P(c11458d25, z);
        this.a.G().T0().p(c11458d25, z);
    }

    public boolean t0() {
        return this.a.S().x5();
    }

    public InterfaceC14830iZ0 t1(final int i, final int i2, final C24119y45 c24119y45) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.ie4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.R0(i, i2, c24119y45, interfaceC15419jZ0);
            }
        };
    }

    public void u(long j, boolean z) {
        this.a.G().h0(j, z);
    }

    public boolean u0() {
        return this.a.S().y5();
    }

    public C6517Nv5 u1(int i, int i2, String str) {
        return this.a.E().u3(i, i2, str);
    }

    public InterfaceC14830iZ0 v(final C11458d25 c11458d25) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.de4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.E0(c11458d25, interfaceC15419jZ0);
            }
        };
    }

    public boolean v0() {
        return this.a.S().z5();
    }

    public void v1(long j, long j2, InterfaceC8807Xk2 interfaceC8807Xk2) {
        this.a.D().U(j, j2, interfaceC8807Xk2);
    }

    public void w() {
        this.a.K().C();
    }

    public boolean w0(InterfaceC4314Ep2 interfaceC4314Ep2) {
        return this.a.S().B5(interfaceC4314Ep2);
    }

    public InterfaceC14830iZ0 w1(final int i) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.ae4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.S0(i, interfaceC15419jZ0);
            }
        };
    }

    public C6517Nv5 x(String str, String str2) {
        return this.a.R().G(str, str2);
    }

    public boolean x0() {
        return this.a.a0();
    }

    public void x1(C11458d25 c11458d25, C14419ht c14419ht) {
        this.a.G().o2(c11458d25, c14419ht, null, null);
    }

    public InterfaceC14830iZ0 y(final C11458d25 c11458d25) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.be4
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.F0(c11458d25, interfaceC15419jZ0);
            }
        };
    }

    public boolean y0() {
        return this.a.S().E5();
    }

    public void y1(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, C7880To7 c7880To7) {
        C19406qI3.a("FiSeCoFl", "sendAudio()", new Object[0]);
        this.a.G().p2(c11458d25, str, str2, str3, l, l2, c7880To7);
    }

    public void z(C11458d25 c11458d25, List list, List list2, boolean z) {
        this.a.G().u0(c11458d25, list, list2, z);
    }

    public boolean z0() {
        return this.a.w().k();
    }

    public void z1(C11458d25 c11458d25, long j, String str, String str2, String str3, Long l, C7880To7 c7880To7) {
        this.a.G().q2(c11458d25, j, str, str2, str3, l, c7880To7);
    }
}
