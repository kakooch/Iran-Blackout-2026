package ir.nasim;

/* renamed from: ir.nasim.h0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13893h0 extends TG1 {
    private final XC6 b;
    private final XC6 c;

    public C13893h0(XC6 xc6, XC6 xc62) {
        AbstractC13042fc3.i(xc6, "delegate");
        AbstractC13042fc3.i(xc62, "abbreviation");
        this.b = xc6;
        this.c = xc62;
    }

    public final XC6 G() {
        return T0();
    }

    @Override // ir.nasim.TG1
    protected XC6 T0() {
        return this.b;
    }

    public final XC6 W0() {
        return this.c;
    }

    @Override // ir.nasim.XC6
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public C13893h0 O0(boolean z) {
        return new C13893h0(T0().O0(z), this.c.O0(z));
    }

    @Override // ir.nasim.TG1
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C13893h0 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new C13893h0((XC6) abstractC5284Ir3.g(T0()), (XC6) abstractC5284Ir3.g(this.c));
    }

    @Override // ir.nasim.XC6
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public C13893h0 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return new C13893h0(T0().Q0(interfaceC4356Eu), this.c);
    }

    @Override // ir.nasim.TG1
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public C13893h0 V0(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        return new C13893h0(xc6, this.c);
    }
}
