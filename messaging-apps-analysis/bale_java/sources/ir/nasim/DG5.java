package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public final class DG5 extends AbstractC5117Hy7 {
    public static final DG5 c = new DG5();
    private static final C6637Oi3 d;
    private static final C6637Oi3 e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC7349Ri3.valuesCustom().length];
            iArr[EnumC7349Ri3.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[EnumC7349Ri3.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[EnumC7349Ri3.INFLEXIBLE.ordinal()] = 3;
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC21331tU0 e;
        final /* synthetic */ DG5 f;
        final /* synthetic */ XC6 g;
        final /* synthetic */ C6637Oi3 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC21331tU0 interfaceC21331tU0, DG5 dg5, XC6 xc6, C6637Oi3 c6637Oi3) {
            super(1);
            this.e = interfaceC21331tU0;
            this.f = dg5;
            this.g = xc6;
            this.h = c6637Oi3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            InterfaceC21331tU0 interfaceC21331tU0A;
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            InterfaceC21331tU0 interfaceC21331tU0 = this.e;
            if (!(interfaceC21331tU0 instanceof InterfaceC21331tU0)) {
                interfaceC21331tU0 = null;
            }
            C24948zU0 c24948zU0H = interfaceC21331tU0 == null ? null : PI1.h(interfaceC21331tU0);
            if (c24948zU0H == null || (interfaceC21331tU0A = abstractC5284Ir3.a(c24948zU0H)) == null || AbstractC13042fc3.d(interfaceC21331tU0A, this.e)) {
                return null;
            }
            return (XC6) this.f.k(this.g, interfaceC21331tU0A, this.h).e();
        }
    }

    static {
        EnumC7263Qy7 enumC7263Qy7 = EnumC7263Qy7.COMMON;
        d = AbstractC8790Xi3.f(enumC7263Qy7, false, null, 3, null).g(EnumC7349Ri3.FLEXIBLE_LOWER_BOUND);
        e = AbstractC8790Xi3.f(enumC7263Qy7, false, null, 3, null).g(EnumC7349Ri3.FLEXIBLE_UPPER_BOUND);
    }

    private DG5() {
    }

    public static /* synthetic */ InterfaceC3932Cy7 j(DG5 dg5, InterfaceC22882vy7 interfaceC22882vy7, C6637Oi3 c6637Oi3, AbstractC4099Dr3 abstractC4099Dr3, int i, Object obj) {
        if ((i & 4) != 0) {
            abstractC4099Dr3 = AbstractC8790Xi3.c(interfaceC22882vy7, null, null, 3, null);
        }
        return dg5.i(interfaceC22882vy7, c6637Oi3, abstractC4099Dr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XV4 k(XC6 xc6, InterfaceC21331tU0 interfaceC21331tU0, C6637Oi3 c6637Oi3) {
        if (xc6.K0().getParameters().isEmpty()) {
            return AbstractC4616Fw7.a(xc6, Boolean.FALSE);
        }
        if (AbstractC19738qr3.b0(xc6)) {
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) xc6.J0().get(0);
            KQ7 kq7C = interfaceC3932Cy7.c();
            AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
            AbstractC13042fc3.h(type, "componentTypeProjection.type");
            List listE = AbstractC9766aX0.e(new C4400Ey7(kq7C, l(type)));
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            return AbstractC4616Fw7.a(C4567Fr3.i(xc6.getAnnotations(), xc6.K0(), listE, xc6.L0(), null, 16, null), Boolean.FALSE);
        }
        if (AbstractC4816Gr3.a(xc6)) {
            XC6 xc6J = AbstractC14230ha2.j(AbstractC13042fc3.q("Raw error type: ", xc6.K0()));
            AbstractC13042fc3.h(xc6J, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return AbstractC4616Fw7.a(xc6J, Boolean.FALSE);
        }
        W24 w24H = interfaceC21331tU0.H(this);
        AbstractC13042fc3.h(w24H, "declaration.getMemberScope(RawSubstitution)");
        C4567Fr3 c4567Fr32 = C4567Fr3.a;
        InterfaceC4356Eu annotations = xc6.getAnnotations();
        InterfaceC13882gy7 interfaceC13882gy7J = interfaceC21331tU0.j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "declaration.typeConstructor");
        List parameters = interfaceC21331tU0.j().getParameters();
        AbstractC13042fc3.h(parameters, "declaration.typeConstructor.parameters");
        List<InterfaceC22882vy7> list = parameters;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (InterfaceC22882vy7 interfaceC22882vy7 : list) {
            AbstractC13042fc3.h(interfaceC22882vy7, "parameter");
            arrayList.add(j(this, interfaceC22882vy7, c6637Oi3, null, 4, null));
        }
        return AbstractC4616Fw7.a(C4567Fr3.k(annotations, interfaceC13882gy7J, arrayList, xc6.L0(), w24H, new b(interfaceC21331tU0, this, xc6, c6637Oi3)), Boolean.TRUE);
    }

    private final AbstractC4099Dr3 l(AbstractC4099Dr3 abstractC4099Dr3) {
        MU0 mu0T = abstractC4099Dr3.K0().t();
        if (mu0T instanceof InterfaceC22882vy7) {
            return l(AbstractC8790Xi3.c((InterfaceC22882vy7) mu0T, null, null, 3, null));
        }
        if (!(mu0T instanceof InterfaceC21331tU0)) {
            throw new IllegalStateException(AbstractC13042fc3.q("Unexpected declaration kind: ", mu0T).toString());
        }
        MU0 mu0T2 = AbstractC7411Rp2.d(abstractC4099Dr3).K0().t();
        if (mu0T2 instanceof InterfaceC21331tU0) {
            XV4 xv4K = k(AbstractC7411Rp2.c(abstractC4099Dr3), (InterfaceC21331tU0) mu0T, d);
            XC6 xc6 = (XC6) xv4K.a();
            boolean zBooleanValue = ((Boolean) xv4K.b()).booleanValue();
            XV4 xv4K2 = k(AbstractC7411Rp2.d(abstractC4099Dr3), (InterfaceC21331tU0) mu0T2, e);
            XC6 xc62 = (XC6) xv4K2.a();
            return (zBooleanValue || ((Boolean) xv4K2.b()).booleanValue()) ? new FG5(xc6, xc62) : C4567Fr3.d(xc6, xc62);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + mu0T2 + "\" while for lower it's \"" + mu0T + '\"').toString());
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean f() {
        return false;
    }

    public final InterfaceC3932Cy7 i(InterfaceC22882vy7 interfaceC22882vy7, C6637Oi3 c6637Oi3, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(interfaceC22882vy7, "parameter");
        AbstractC13042fc3.i(c6637Oi3, "attr");
        AbstractC13042fc3.i(abstractC4099Dr3, "erasedUpperBound");
        int i = a.a[c6637Oi3.c().ordinal()];
        if (i == 1) {
            return new C4400Ey7(KQ7.INVARIANT, abstractC4099Dr3);
        }
        if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!interfaceC22882vy7.m().a()) {
            return new C4400Ey7(KQ7.INVARIANT, PI1.g(interfaceC22882vy7).H());
        }
        List parameters = abstractC4099Dr3.K0().getParameters();
        AbstractC13042fc3.h(parameters, "erasedUpperBound.constructor.parameters");
        return parameters.isEmpty() ^ true ? new C4400Ey7(KQ7.OUT_VARIANCE, abstractC4099Dr3) : AbstractC8790Xi3.d(interfaceC22882vy7, c6637Oi3);
    }

    @Override // ir.nasim.AbstractC5117Hy7
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C4400Ey7 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "key");
        return new C4400Ey7(l(abstractC4099Dr3));
    }
}
