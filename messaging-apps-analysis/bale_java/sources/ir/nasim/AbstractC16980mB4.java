package ir.nasim;

/* renamed from: ir.nasim.mB4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16980mB4 extends AbstractC10899cO4 {
    @Override // ir.nasim.AbstractC10899cO4
    public void b(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02) {
        AbstractC13042fc3.i(interfaceC15194jA0, "first");
        AbstractC13042fc3.i(interfaceC15194jA02, "second");
        e(interfaceC15194jA0, interfaceC15194jA02);
    }

    @Override // ir.nasim.AbstractC10899cO4
    public void c(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02) {
        AbstractC13042fc3.i(interfaceC15194jA0, "fromSuper");
        AbstractC13042fc3.i(interfaceC15194jA02, "fromCurrent");
        e(interfaceC15194jA0, interfaceC15194jA02);
    }

    protected abstract void e(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02);
}
