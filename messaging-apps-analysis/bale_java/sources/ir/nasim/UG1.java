package ir.nasim;

/* loaded from: classes8.dex */
public abstract class UG1 extends TG1 {
    private final XC6 b;

    public UG1(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        this.b = xc6;
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: R0 */
    public XC6 O0(boolean z) {
        return z == L0() ? this : T0().O0(z).Q0(getAnnotations());
    }

    @Override // ir.nasim.TG1
    protected XC6 T0() {
        return this.b;
    }

    @Override // ir.nasim.XC6
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public UG1 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return interfaceC4356Eu != getAnnotations() ? new C12609eu(this, interfaceC4356Eu) : this;
    }
}
