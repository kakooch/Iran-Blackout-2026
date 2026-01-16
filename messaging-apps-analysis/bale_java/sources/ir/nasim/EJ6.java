package ir.nasim;

/* loaded from: classes8.dex */
final class EJ6 implements InterfaceC20295rm1, InterfaceC23369wo1 {
    private final InterfaceC20295rm1 a;
    private final InterfaceC11938do1 b;

    public EJ6(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC11938do1 interfaceC11938do1) {
        this.a = interfaceC20295rm1;
        this.b = interfaceC11938do1;
    }

    @Override // ir.nasim.InterfaceC23369wo1
    public InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.a;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        this.a.resumeWith(obj);
    }
}
