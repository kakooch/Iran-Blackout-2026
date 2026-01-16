package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Mp2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6200Mp2 extends AbstractC18174oC7 implements InterfaceC6933Pp2 {
    private final XC6 b;
    private final XC6 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC6200Mp2(XC6 xc6, XC6 xc62) {
        super(null);
        AbstractC13042fc3.i(xc6, "lowerBound");
        AbstractC13042fc3.i(xc62, "upperBound");
        this.b = xc6;
        this.c = xc62;
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return R0().J0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public InterfaceC13882gy7 K0() {
        return R0().K0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return R0().L0();
    }

    public abstract XC6 R0();

    public final XC6 S0() {
        return this.b;
    }

    public final XC6 T0() {
        return this.c;
    }

    public abstract String U0(FI1 fi1, II1 ii1);

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return R0().getAnnotations();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        return R0().o();
    }

    public String toString() {
        return FI1.j.x(this);
    }
}
