package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
public abstract class TG1 extends XC6 {
    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return T0().J0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public InterfaceC13882gy7 K0() {
        return T0().K0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return T0().L0();
    }

    protected abstract XC6 T0();

    @Override // ir.nasim.AbstractC18174oC7
    public XC6 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return V0((XC6) abstractC5284Ir3.g(T0()));
    }

    public abstract TG1 V0(XC6 xc6);

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return T0().getAnnotations();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        return T0().o();
    }
}
