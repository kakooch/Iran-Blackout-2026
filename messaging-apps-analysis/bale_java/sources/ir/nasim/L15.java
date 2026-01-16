package ir.nasim;

/* loaded from: classes2.dex */
public final class L15 extends AbstractC13778go1 {
    public final IU1 c = new IU1();

    @Override // ir.nasim.AbstractC13778go1
    public boolean A0(InterfaceC11938do1 interfaceC11938do1) {
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        if (C12366eV1.c().F0().A0(interfaceC11938do1)) {
            return true;
        }
        return !this.c.b();
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        AbstractC13042fc3.i(runnable, "block");
        this.c.c(interfaceC11938do1, runnable);
    }
}
