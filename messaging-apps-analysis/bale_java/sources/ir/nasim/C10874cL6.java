package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.cL6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10874cL6 implements InterfaceC10258bL6 {
    private final InterfaceC10258bL6 a;

    public C10874cL6(InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(interfaceC10258bL6, "flow");
        this.a = interfaceC10258bL6;
    }

    @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.b(interfaceC4806Gq2, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC10040ay6
    public List e() {
        return this.a.e();
    }

    @Override // ir.nasim.InterfaceC10258bL6
    public Object getValue() {
        return this.a.getValue();
    }

    public final Object h(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        MG1 mg1 = MG1.a;
        if (AbstractC13042fc3.d(mg1.b().get(), Boolean.TRUE)) {
            mg1.a().set(this);
        }
        return this.a.getValue();
    }
}
