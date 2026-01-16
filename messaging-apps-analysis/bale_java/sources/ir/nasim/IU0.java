package ir.nasim;

import ir.nasim.AbstractC12095e2;
import ir.nasim.AbstractC5284Ir3;
import ir.nasim.KU0;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public class IU0 extends AbstractC12095e2 implements KU0 {
    public static final a i = new a(null);
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final AbstractC5284Ir3 h;

    public static final class a {

        /* renamed from: ir.nasim.IU0$a$a, reason: collision with other inner class name */
        public static final class C0418a extends AbstractC12095e2.b.a {
            final /* synthetic */ KU0 a;
            final /* synthetic */ C5585Jy7 b;

            C0418a(KU0 ku0, C5585Jy7 c5585Jy7) {
                this.a = ku0;
                this.b = c5585Jy7;
            }

            @Override // ir.nasim.AbstractC12095e2.b
            public ZC6 a(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3) {
                AbstractC13042fc3.i(abstractC12095e2, "context");
                AbstractC13042fc3.i(interfaceC5050Hr3, "type");
                KU0 ku0 = this.a;
                AbstractC4099Dr3 abstractC4099Dr3N = this.b.n((AbstractC4099Dr3) ku0.C(interfaceC5050Hr3), KQ7.INVARIANT);
                AbstractC13042fc3.h(abstractC4099Dr3N, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
                ZC6 zc6E = ku0.e(abstractC4099Dr3N);
                AbstractC13042fc3.f(zc6E);
                return zc6E;
            }
        }

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AbstractC12095e2.b.a a(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "<this>");
            AbstractC13042fc3.i(zc6, "type");
            if (zc6 instanceof XC6) {
                return new C0418a(ku0, AbstractC15082iy7.c.a((AbstractC4099Dr3) zc6).c());
            }
            throw new IllegalArgumentException(JU0.b(zc6).toString());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ IU0(boolean z, boolean z2, boolean z3, AbstractC5284Ir3 abstractC5284Ir3, int i2, ED1 ed1) {
        this(z, (i2 & 2) != 0 ? true : z2, (i2 & 4) != 0 ? true : z3, (i2 & 8) != 0 ? AbstractC5284Ir3.a.a : abstractC5284Ir3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean A(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.B(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean B(ZC6 zc6) {
        return KU0.a.Q(this, zc6);
    }

    @Override // ir.nasim.AbstractC12095e2
    public boolean C0() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public InterfaceC5050Hr3 D(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.s(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.AbstractC12095e2
    public InterfaceC5050Hr3 D0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        AbstractC13042fc3.i(interfaceC5050Hr3, "type");
        if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
            return InterfaceC14434hu4.b.a().h(((AbstractC4099Dr3) interfaceC5050Hr3).N0());
        }
        throw new IllegalArgumentException(JU0.b(interfaceC5050Hr3).toString());
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean E(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.C(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.AbstractC12095e2
    public InterfaceC5050Hr3 E0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        AbstractC13042fc3.i(interfaceC5050Hr3, "type");
        if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
            return this.h.g((AbstractC4099Dr3) interfaceC5050Hr3);
        }
        throw new IllegalArgumentException(JU0.b(interfaceC5050Hr3).toString());
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean F(ZC6 zc6) {
        return KU0.a.O(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean G(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.K(this, interfaceC14475hy7);
    }

    public boolean G0(InterfaceC13882gy7 interfaceC13882gy7, InterfaceC13882gy7 interfaceC13882gy72) {
        AbstractC13042fc3.i(interfaceC13882gy7, "a");
        AbstractC13042fc3.i(interfaceC13882gy72, "b");
        return interfaceC13882gy7 instanceof C7043Qa3 ? ((C7043Qa3) interfaceC13882gy7).j(interfaceC13882gy72) : interfaceC13882gy72 instanceof C7043Qa3 ? ((C7043Qa3) interfaceC13882gy72).j(interfaceC13882gy7) : AbstractC13042fc3.d(interfaceC13882gy7, interfaceC13882gy72);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC19385qG0 H(ZC6 zc6) {
        return KU0.a.d(this, zc6);
    }

    @Override // ir.nasim.AbstractC12095e2
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public AbstractC12095e2.b.a F0(ZC6 zc6) {
        AbstractC13042fc3.i(zc6, "type");
        return i.a(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean I(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.D(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.KU0
    public InterfaceC5050Hr3 J(ZC6 zc6, ZC6 zc62) {
        return KU0.a.k(this, zc6, zc62);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC5050Hr3 K(List list) {
        return KU0.a.z(this, list);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC9438Zx7 L(InterfaceC5050Hr3 interfaceC5050Hr3, int i2) {
        return KU0.a.m(this, interfaceC5050Hr3, i2);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public Collection M(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.c0(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public C10027ax2 N(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.n(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public EnumC4809Gq5 O(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.p(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean P(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.L(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public EnumC8204Uy7 Q(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return KU0.a.v(this, interfaceC9438Zx7);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public EnumC4809Gq5 S(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.q(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC5050Hr3 T(InterfaceC19385qG0 interfaceC19385qG0) {
        return KU0.a.U(this, interfaceC19385qG0);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean U(ZC6 zc6) {
        return KU0.a.J(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean V(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.G(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC9204Yx7 X(ZC6 zc6) {
        return KU0.a.c(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean Y(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.A(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean Z(ZC6 zc6) {
        return KU0.a.M(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 a(InterfaceC6933Pp2 interfaceC6933Pp2) {
        return KU0.a.f0(this, interfaceC6933Pp2);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC5050Hr3 a0(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return KU0.a.t(this, interfaceC9438Zx7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 b(InterfaceC6933Pp2 interfaceC6933Pp2) {
        return KU0.a.S(this, interfaceC6933Pp2);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 b0(ZC6 zc6, EnumC15839kG0 enumC15839kG0) {
        return KU0.a.j(this, zc6, enumC15839kG0);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 c(ZC6 zc6, boolean z) {
        return KU0.a.i0(this, zc6, z);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public boolean c0(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.F(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC14475hy7 d(ZC6 zc6) {
        return KU0.a.e0(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6785Oy7
    public boolean d0(ZC6 zc6, ZC6 zc62) {
        return KU0.a.y(this, zc6, zc62);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 e(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.h(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC21056t22 e0(InterfaceC6933Pp2 interfaceC6933Pp2) {
        KU0.a.f(this, interfaceC6933Pp2);
        return null;
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean f0(InterfaceC19385qG0 interfaceC19385qG0) {
        return KU0.a.N(this, interfaceC19385qG0);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public int g0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.b(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean h(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.H(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean h0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.E(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC24062xy7 i(InterfaceC14475hy7 interfaceC14475hy7, int i2) {
        return KU0.a.o(this, interfaceC14475hy7, i2);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public InterfaceC24062xy7 j(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.u(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public boolean k(InterfaceC5050Hr3 interfaceC5050Hr3, C9424Zw2 c9424Zw2) {
        return KU0.a.x(this, interfaceC5050Hr3, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean l(InterfaceC14475hy7 interfaceC14475hy7, InterfaceC14475hy7 interfaceC14475hy72) {
        AbstractC13042fc3.i(interfaceC14475hy7, "c1");
        AbstractC13042fc3.i(interfaceC14475hy72, "c2");
        if (!(interfaceC14475hy7 instanceof InterfaceC13882gy7)) {
            throw new IllegalArgumentException(JU0.b(interfaceC14475hy7).toString());
        }
        if (interfaceC14475hy72 instanceof InterfaceC13882gy7) {
            return G0((InterfaceC13882gy7) interfaceC14475hy7, (InterfaceC13882gy7) interfaceC14475hy72);
        }
        throw new IllegalArgumentException(JU0.b(interfaceC14475hy72).toString());
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 m(EG1 eg1) {
        return KU0.a.Y(this, eg1);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC9438Zx7 n(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.i(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean o(InterfaceC9438Zx7 interfaceC9438Zx7) {
        return KU0.a.P(this, interfaceC9438Zx7);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public InterfaceC5050Hr3 p(InterfaceC24062xy7 interfaceC24062xy7) {
        return KU0.a.r(this, interfaceC24062xy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC5050Hr3 q(InterfaceC5050Hr3 interfaceC5050Hr3, boolean z) {
        return KU0.a.h0(this, interfaceC5050Hr3, z);
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public boolean r(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.R(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public int s(InterfaceC14475hy7 interfaceC14475hy7) {
        return KU0.a.Z(this, interfaceC14475hy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public EnumC8204Uy7 t(InterfaceC24062xy7 interfaceC24062xy7) {
        return KU0.a.w(this, interfaceC24062xy7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public Collection u(ZC6 zc6) {
        return KU0.a.a0(this, zc6);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC6933Pp2 v(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.g(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.AbstractC12095e2
    public boolean v0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        AbstractC13042fc3.i(interfaceC5050Hr3, "<this>");
        if (!(interfaceC5050Hr3 instanceof AbstractC18174oC7) || !this.g) {
            return false;
        }
        ((AbstractC18174oC7) interfaceC5050Hr3).K0();
        return false;
    }

    @Override // ir.nasim.InterfaceC5819Ky7
    public InterfaceC5050Hr3 x(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.W(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC5050Hr3 y(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return KU0.a.V(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public EG1 z(ZC6 zc6) {
        return KU0.a.e(this, zc6);
    }

    @Override // ir.nasim.AbstractC12095e2
    public boolean z0() {
        return this.e;
    }

    public IU0(boolean z, boolean z2, boolean z3, AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = abstractC5284Ir3;
    }
}
