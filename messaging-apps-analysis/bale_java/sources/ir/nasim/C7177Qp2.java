package ir.nasim;

/* renamed from: ir.nasim.Qp2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7177Qp2 extends AbstractC6200Mp2 implements InterfaceC8438Vy7 {
    private final AbstractC6200Mp2 d;
    private final AbstractC4099Dr3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7177Qp2(AbstractC6200Mp2 abstractC6200Mp2, AbstractC4099Dr3 abstractC4099Dr3) {
        super(abstractC6200Mp2.S0(), abstractC6200Mp2.T0());
        AbstractC13042fc3.i(abstractC6200Mp2, "origin");
        AbstractC13042fc3.i(abstractC4099Dr3, "enhancement");
        this.d = abstractC6200Mp2;
        this.e = abstractC4099Dr3;
    }

    @Override // ir.nasim.AbstractC18174oC7
    public AbstractC18174oC7 O0(boolean z) {
        return AbstractC8692Wy7.d(getOrigin().O0(z), i0().N0().O0(z));
    }

    @Override // ir.nasim.AbstractC18174oC7
    public AbstractC18174oC7 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return AbstractC8692Wy7.d(getOrigin().Q0(interfaceC4356Eu), i0());
    }

    @Override // ir.nasim.AbstractC6200Mp2
    public XC6 R0() {
        return getOrigin().R0();
    }

    @Override // ir.nasim.AbstractC6200Mp2
    public String U0(FI1 fi1, II1 ii1) {
        AbstractC13042fc3.i(fi1, "renderer");
        AbstractC13042fc3.i(ii1, "options");
        return ii1.c() ? fi1.x(i0()) : getOrigin().U0(fi1, ii1);
    }

    @Override // ir.nasim.InterfaceC8438Vy7
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public AbstractC6200Mp2 getOrigin() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public C7177Qp2 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new C7177Qp2((AbstractC6200Mp2) abstractC5284Ir3.g(getOrigin()), abstractC5284Ir3.g(i0()));
    }

    @Override // ir.nasim.InterfaceC8438Vy7
    public AbstractC4099Dr3 i0() {
        return this.e;
    }
}
