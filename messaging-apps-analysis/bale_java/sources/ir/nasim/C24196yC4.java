package ir.nasim;

/* renamed from: ir.nasim.yC4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24196yC4 extends TG1 implements InterfaceC4385Ex1 {
    private final XC6 b;

    public C24196yC4(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        this.b = xc6;
    }

    private final XC6 W0(XC6 xc6) {
        XC6 xc6O0 = xc6.O0(false);
        return !AbstractC7731Sy7.i(xc6) ? xc6O0 : new C24196yC4(xc6O0);
    }

    @Override // ir.nasim.TG1, ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC4385Ex1
    public AbstractC4099Dr3 M(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "replacement");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (!AbstractC7731Sy7.i(abstractC18174oC7N0) && !AbstractC7497Ry7.l(abstractC18174oC7N0)) {
            return abstractC18174oC7N0;
        }
        if (abstractC18174oC7N0 instanceof XC6) {
            return W0((XC6) abstractC18174oC7N0);
        }
        if (!(abstractC18174oC7N0 instanceof AbstractC6200Mp2)) {
            throw new IllegalStateException(AbstractC13042fc3.q("Incorrect type: ", abstractC18174oC7N0).toString());
        }
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        AbstractC6200Mp2 abstractC6200Mp2 = (AbstractC6200Mp2) abstractC18174oC7N0;
        return AbstractC8692Wy7.d(C4567Fr3.d(W0(abstractC6200Mp2.S0()), W0(abstractC6200Mp2.T0())), AbstractC8692Wy7.a(abstractC18174oC7N0));
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: R0 */
    public XC6 O0(boolean z) {
        return z ? T0().O0(true) : this;
    }

    @Override // ir.nasim.TG1
    protected XC6 T0() {
        return this.b;
    }

    @Override // ir.nasim.XC6
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public C24196yC4 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return new C24196yC4(T0().Q0(interfaceC4356Eu));
    }

    @Override // ir.nasim.TG1
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public C24196yC4 V0(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        return new C24196yC4(xc6);
    }

    @Override // ir.nasim.InterfaceC4385Ex1
    public boolean x() {
        return true;
    }
}
