package ir.nasim;

/* renamed from: ir.nasim.aD6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9592aD6 extends TG1 implements InterfaceC8438Vy7 {
    private final XC6 b;
    private final AbstractC4099Dr3 c;

    public C9592aD6(XC6 xc6, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(xc6, "delegate");
        AbstractC13042fc3.i(abstractC4099Dr3, "enhancement");
        this.b = xc6;
        this.c = abstractC4099Dr3;
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: R0 */
    public XC6 O0(boolean z) {
        return (XC6) AbstractC8692Wy7.d(getOrigin().O0(z), i0().N0().O0(z));
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: S0 */
    public XC6 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return (XC6) AbstractC8692Wy7.d(getOrigin().Q0(interfaceC4356Eu), i0());
    }

    @Override // ir.nasim.TG1
    protected XC6 T0() {
        return this.b;
    }

    @Override // ir.nasim.TG1
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public C9592aD6 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new C9592aD6((XC6) abstractC5284Ir3.g(T0()), abstractC5284Ir3.g(i0()));
    }

    @Override // ir.nasim.TG1
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public C9592aD6 V0(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        return new C9592aD6(xc6, i0());
    }

    @Override // ir.nasim.InterfaceC8438Vy7
    public AbstractC18174oC7 getOrigin() {
        return T0();
    }

    @Override // ir.nasim.InterfaceC8438Vy7
    public AbstractC4099Dr3 i0() {
        return this.c;
    }
}
