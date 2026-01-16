package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.an4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9927an4 implements InterfaceC9336Zm4 {
    private final InterfaceC9336Zm4 a;
    private final InterfaceC14603iB2 b;

    public C9927an4(InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC9336Zm4, "flow");
        this.a = interfaceC9336Zm4;
        this.b = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC8327Vm4, ir.nasim.InterfaceC4806Gq2
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.a(obj, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.b(interfaceC4806Gq2, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public boolean c(Object obj) {
        return this.a.c(obj);
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public InterfaceC10258bL6 d() {
        return this.a.d();
    }

    @Override // ir.nasim.InterfaceC10040ay6
    public List e() {
        return this.a.e();
    }

    @Override // ir.nasim.InterfaceC9336Zm4
    public boolean f(Object obj, Object obj2) {
        return this.a.f(obj, obj2);
    }

    @Override // ir.nasim.InterfaceC9336Zm4, ir.nasim.InterfaceC10258bL6
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

    public final void i(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        Object value = this.a.getValue();
        this.a.setValue(obj2);
        InterfaceC14603iB2 interfaceC14603iB2 = this.b;
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(obj2, value);
        }
    }

    @Override // ir.nasim.InterfaceC8327Vm4
    public void k() {
        this.a.k();
    }

    @Override // ir.nasim.InterfaceC9336Zm4
    public void setValue(Object obj) {
        this.a.setValue(obj);
    }
}
