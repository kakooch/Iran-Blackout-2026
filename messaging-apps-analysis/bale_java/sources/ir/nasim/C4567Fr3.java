package ir.nasim;

import ir.nasim.InterfaceC8429Vx7;
import java.util.List;

/* renamed from: ir.nasim.Fr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4567Fr3 {
    public static final C4567Fr3 a = new C4567Fr3();
    private static final UA2 b = a.e;

    /* renamed from: ir.nasim.Fr3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "$noName_0");
            return null;
        }
    }

    /* renamed from: ir.nasim.Fr3$b */
    private static final class b {
        private final XC6 a;
        private final InterfaceC13882gy7 b;

        public b(XC6 xc6, InterfaceC13882gy7 interfaceC13882gy7) {
            this.a = xc6;
            this.b = interfaceC13882gy7;
        }

        public final XC6 a() {
            return this.a;
        }

        public final InterfaceC13882gy7 b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Fr3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC13882gy7 f;
        final /* synthetic */ List g;
        final /* synthetic */ InterfaceC4356Eu h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC13882gy7 interfaceC13882gy7, List list, InterfaceC4356Eu interfaceC4356Eu, boolean z) {
            super(1);
            this.f = interfaceC13882gy7;
            this.g = list;
            this.h = interfaceC4356Eu;
            this.i = z;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "refiner");
            b bVarF = C4567Fr3.this.f(this.f, abstractC5284Ir3, this.g);
            if (bVarF == null) {
                return null;
            }
            XC6 xc6A = bVarF.a();
            if (xc6A != null) {
                return xc6A;
            }
            InterfaceC4356Eu interfaceC4356Eu = this.h;
            InterfaceC13882gy7 interfaceC13882gy7B = bVarF.b();
            AbstractC13042fc3.f(interfaceC13882gy7B);
            return C4567Fr3.h(interfaceC4356Eu, interfaceC13882gy7B, this.g, this.i, abstractC5284Ir3);
        }
    }

    /* renamed from: ir.nasim.Fr3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC13882gy7 f;
        final /* synthetic */ List g;
        final /* synthetic */ InterfaceC4356Eu h;
        final /* synthetic */ boolean i;
        final /* synthetic */ W24 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC13882gy7 interfaceC13882gy7, List list, InterfaceC4356Eu interfaceC4356Eu, boolean z, W24 w24) {
            super(1);
            this.f = interfaceC13882gy7;
            this.g = list;
            this.h = interfaceC4356Eu;
            this.i = z;
            this.j = w24;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            b bVarF = C4567Fr3.this.f(this.f, abstractC5284Ir3, this.g);
            if (bVarF == null) {
                return null;
            }
            XC6 xc6A = bVarF.a();
            if (xc6A != null) {
                return xc6A;
            }
            InterfaceC4356Eu interfaceC4356Eu = this.h;
            InterfaceC13882gy7 interfaceC13882gy7B = bVarF.b();
            AbstractC13042fc3.f(interfaceC13882gy7B);
            return C4567Fr3.j(interfaceC4356Eu, interfaceC13882gy7B, this.g, this.i, this.j);
        }
    }

    private C4567Fr3() {
    }

    public static final XC6 b(InterfaceC7722Sx7 interfaceC7722Sx7, List list) {
        AbstractC13042fc3.i(interfaceC7722Sx7, "<this>");
        AbstractC13042fc3.i(list, "arguments");
        return new C7961Tx7(InterfaceC8429Vx7.a.a, false).h(C8195Ux7.e.a(null, interfaceC7722Sx7, list), InterfaceC4356Eu.W.b());
    }

    private final W24 c(InterfaceC13882gy7 interfaceC13882gy7, List list, AbstractC5284Ir3 abstractC5284Ir3) {
        MU0 mu0D = interfaceC13882gy7.t();
        if (mu0D instanceof InterfaceC22882vy7) {
            return mu0D.p().o();
        }
        if (mu0D instanceof InterfaceC21331tU0) {
            if (abstractC5284Ir3 == null) {
                abstractC5284Ir3 = PI1.k(PI1.l(mu0D));
            }
            return list.isEmpty() ? AbstractC6854Pg4.b((InterfaceC21331tU0) mu0D, abstractC5284Ir3) : AbstractC6854Pg4.a((InterfaceC21331tU0) mu0D, AbstractC15082iy7.c.b(interfaceC13882gy7, list), abstractC5284Ir3);
        }
        if (mu0D instanceof InterfaceC7722Sx7) {
            W24 w24I = AbstractC14230ha2.i(AbstractC13042fc3.q("Scope for abbreviation: ", ((InterfaceC7722Sx7) mu0D).getName()), true);
            AbstractC13042fc3.h(w24I, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
            return w24I;
        }
        if (interfaceC13882gy7 instanceof C7993Ub3) {
            return ((C7993Ub3) interfaceC13882gy7).f();
        }
        throw new IllegalStateException("Unsupported classifier: " + mu0D + " for constructor: " + interfaceC13882gy7);
    }

    public static final AbstractC18174oC7 d(XC6 xc6, XC6 xc62) {
        AbstractC13042fc3.i(xc6, "lowerBound");
        AbstractC13042fc3.i(xc62, "upperBound");
        return AbstractC13042fc3.d(xc6, xc62) ? xc6 : new C6699Op2(xc6, xc62);
    }

    public static final XC6 e(InterfaceC4356Eu interfaceC4356Eu, C7043Qa3 c7043Qa3, boolean z) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(c7043Qa3, "constructor");
        List listM = AbstractC10360bX0.m();
        W24 w24I = AbstractC14230ha2.i("Scope for integer literal type", true);
        AbstractC13042fc3.h(w24I, "createErrorScope(\"Scope for integer literal type\", true)");
        return j(interfaceC4356Eu, c7043Qa3, listM, z, w24I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b f(InterfaceC13882gy7 interfaceC13882gy7, AbstractC5284Ir3 abstractC5284Ir3, List list) {
        MU0 mu0D = interfaceC13882gy7.t();
        MU0 mu0E = mu0D == null ? null : abstractC5284Ir3.e(mu0D);
        if (mu0E == null) {
            return null;
        }
        if (mu0E instanceof InterfaceC7722Sx7) {
            return new b(b((InterfaceC7722Sx7) mu0E, list), null);
        }
        InterfaceC13882gy7 interfaceC13882gy7A = mu0E.j().a(abstractC5284Ir3);
        AbstractC13042fc3.h(interfaceC13882gy7A, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
        return new b(null, interfaceC13882gy7A);
    }

    public static final XC6 g(InterfaceC4356Eu interfaceC4356Eu, InterfaceC21331tU0 interfaceC21331tU0, List list) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(interfaceC21331tU0, "descriptor");
        AbstractC13042fc3.i(list, "arguments");
        InterfaceC13882gy7 interfaceC13882gy7J = interfaceC21331tU0.j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "descriptor.typeConstructor");
        return i(interfaceC4356Eu, interfaceC13882gy7J, list, false, null, 16, null);
    }

    public static final XC6 h(InterfaceC4356Eu interfaceC4356Eu, InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z, AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(list, "arguments");
        if (!interfaceC4356Eu.isEmpty() || !list.isEmpty() || z || interfaceC13882gy7.t() == null) {
            C4567Fr3 c4567Fr3 = a;
            return k(interfaceC4356Eu, interfaceC13882gy7, list, z, c4567Fr3.c(interfaceC13882gy7, list, abstractC5284Ir3), c4567Fr3.new c(interfaceC13882gy7, list, interfaceC4356Eu, z));
        }
        MU0 mu0D = interfaceC13882gy7.t();
        AbstractC13042fc3.f(mu0D);
        XC6 xc6P = mu0D.p();
        AbstractC13042fc3.h(xc6P, "constructor.declarationDescriptor!!.defaultType");
        return xc6P;
    }

    public static /* synthetic */ XC6 i(InterfaceC4356Eu interfaceC4356Eu, InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z, AbstractC5284Ir3 abstractC5284Ir3, int i, Object obj) {
        if ((i & 16) != 0) {
            abstractC5284Ir3 = null;
        }
        return h(interfaceC4356Eu, interfaceC13882gy7, list, z, abstractC5284Ir3);
    }

    public static final XC6 j(InterfaceC4356Eu interfaceC4356Eu, InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z, W24 w24) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(list, "arguments");
        AbstractC13042fc3.i(w24, "memberScope");
        YC6 yc6 = new YC6(interfaceC13882gy7, list, z, w24, a.new d(interfaceC13882gy7, list, interfaceC4356Eu, z, w24));
        return interfaceC4356Eu.isEmpty() ? yc6 : new C12609eu(yc6, interfaceC4356Eu);
    }

    public static final XC6 k(InterfaceC4356Eu interfaceC4356Eu, InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z, W24 w24, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        AbstractC13042fc3.i(list, "arguments");
        AbstractC13042fc3.i(w24, "memberScope");
        AbstractC13042fc3.i(ua2, "refinedTypeFactory");
        YC6 yc6 = new YC6(interfaceC13882gy7, list, z, w24, ua2);
        return interfaceC4356Eu.isEmpty() ? yc6 : new C12609eu(yc6, interfaceC4356Eu);
    }
}
