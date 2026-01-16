package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
final class DI5 implements InterfaceC10258bL6, LE0, LB2 {
    private final InterfaceC13730gj3 a;
    private final /* synthetic */ InterfaceC10258bL6 b;

    public DI5(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC13730gj3 interfaceC13730gj3) {
        this.a = interfaceC13730gj3;
        this.b = interfaceC10258bL6;
    }

    @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.b(interfaceC4806Gq2, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC10040ay6
    public List e() {
        return this.b.e();
    }

    @Override // ir.nasim.LB2
    public InterfaceC4557Fq2 g(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return AbstractC12281eL6.d(this, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.InterfaceC10258bL6
    public Object getValue() {
        return this.b.getValue();
    }
}
