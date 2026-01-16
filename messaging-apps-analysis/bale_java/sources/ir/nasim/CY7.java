package ir.nasim;

import java.util.UUID;

/* loaded from: classes.dex */
public class CY7 extends AbstractC8181Uw2 {
    private final String b;
    private int c;

    CY7(InterfaceC14623iD0 interfaceC14623iD0) {
        super(interfaceC14623iD0);
        this.b = "virtual-" + interfaceC14623iD0.b() + "-" + UUID.randomUUID().toString();
    }

    @Override // ir.nasim.AbstractC8181Uw2, ir.nasim.InterfaceC14021hD0
    public int a() {
        return k(0);
    }

    @Override // ir.nasim.AbstractC8181Uw2, ir.nasim.InterfaceC14623iD0
    public String b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC8181Uw2, ir.nasim.InterfaceC14021hD0
    public int k(int i) {
        return AbstractC14447hv7.u(super.k(i) - this.c);
    }

    void l(int i) {
        this.c = i;
    }
}
