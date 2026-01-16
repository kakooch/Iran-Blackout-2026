package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Op2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6699Op2 extends AbstractC6200Mp2 implements InterfaceC4385Ex1 {
    public static final a e = new a(null);
    public static boolean f;
    private boolean d;

    /* renamed from: ir.nasim.Op2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6699Op2(XC6 xc6, XC6 xc62) {
        super(xc6, xc62);
        AbstractC13042fc3.i(xc6, "lowerBound");
        AbstractC13042fc3.i(xc62, "upperBound");
    }

    private final void W0() {
        if (!f || this.d) {
            return;
        }
        this.d = true;
        AbstractC7411Rp2.b(S0());
        AbstractC7411Rp2.b(T0());
        AbstractC13042fc3.d(S0(), T0());
        InterfaceC4333Er3.a.b(S0(), T0());
    }

    @Override // ir.nasim.InterfaceC4385Ex1
    public AbstractC4099Dr3 M(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC18174oC7 abstractC18174oC7D;
        AbstractC13042fc3.i(abstractC4099Dr3, "replacement");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
            abstractC18174oC7D = abstractC18174oC7N0;
        } else {
            if (!(abstractC18174oC7N0 instanceof XC6)) {
                throw new NoWhenBranchMatchedException();
            }
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            XC6 xc6 = (XC6) abstractC18174oC7N0;
            abstractC18174oC7D = C4567Fr3.d(xc6, xc6.O0(true));
        }
        return AbstractC8692Wy7.b(abstractC18174oC7D, abstractC18174oC7N0);
    }

    @Override // ir.nasim.AbstractC18174oC7
    public AbstractC18174oC7 O0(boolean z) {
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        return C4567Fr3.d(S0().O0(z), T0().O0(z));
    }

    @Override // ir.nasim.AbstractC18174oC7
    public AbstractC18174oC7 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        return C4567Fr3.d(S0().Q0(interfaceC4356Eu), T0().Q0(interfaceC4356Eu));
    }

    @Override // ir.nasim.AbstractC6200Mp2
    public XC6 R0() {
        W0();
        return S0();
    }

    @Override // ir.nasim.AbstractC6200Mp2
    public String U0(FI1 fi1, II1 ii1) {
        AbstractC13042fc3.i(fi1, "renderer");
        AbstractC13042fc3.i(ii1, "options");
        if (!ii1.j()) {
            return fi1.u(fi1.x(S0()), fi1.x(T0()), AbstractC7731Sy7.e(this));
        }
        return '(' + fi1.x(S0()) + ".." + fi1.x(T0()) + ')';
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public AbstractC6200Mp2 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new C6699Op2((XC6) abstractC5284Ir3.g(S0()), (XC6) abstractC5284Ir3.g(T0()));
    }

    @Override // ir.nasim.InterfaceC4385Ex1
    public boolean x() {
        return (S0().K0().t() instanceof InterfaceC22882vy7) && AbstractC13042fc3.d(S0().K0(), T0().K0());
    }
}
