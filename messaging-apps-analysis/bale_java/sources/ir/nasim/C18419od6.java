package ir.nasim;

/* renamed from: ir.nasim.od6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C18419od6 extends K0 implements InterfaceC23369wo1 {
    public final InterfaceC20295rm1 d;

    public C18419od6(InterfaceC11938do1 interfaceC11938do1, InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC11938do1, true, true);
        this.d = interfaceC20295rm1;
    }

    @Override // ir.nasim.C22725vj3
    protected final boolean B0() {
        return true;
    }

    @Override // ir.nasim.C22725vj3
    protected void Q(Object obj) {
        UU1.c(AbstractC14251hc3.c(this.d), E01.a(obj, this.d), null, 2, null);
    }

    @Override // ir.nasim.K0
    protected void d1(Object obj) {
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        interfaceC20295rm1.resumeWith(E01.a(obj, interfaceC20295rm1));
    }

    @Override // ir.nasim.InterfaceC23369wo1
    public final InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }
}
