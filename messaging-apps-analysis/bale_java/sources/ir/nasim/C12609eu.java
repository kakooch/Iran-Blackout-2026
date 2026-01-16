package ir.nasim;

/* renamed from: ir.nasim.eu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C12609eu extends UG1 {
    private final InterfaceC4356Eu c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12609eu(XC6 xc6, InterfaceC4356Eu interfaceC4356Eu) {
        super(xc6);
        AbstractC13042fc3.i(xc6, "delegate");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        this.c = interfaceC4356Eu;
    }

    @Override // ir.nasim.TG1
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public C12609eu V0(XC6 xc6) {
        AbstractC13042fc3.i(xc6, "delegate");
        return new C12609eu(xc6, getAnnotations());
    }

    @Override // ir.nasim.TG1, ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.c;
    }
}
