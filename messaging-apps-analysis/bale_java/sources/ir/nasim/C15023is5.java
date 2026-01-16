package ir.nasim;

/* renamed from: ir.nasim.is5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C15023is5 implements InterfaceC14415hs5, InterfaceC9102Ym4 {
    private final InterfaceC11938do1 a;
    private final /* synthetic */ InterfaceC9102Ym4 b;

    public C15023is5(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11938do1 interfaceC11938do1) {
        this.a = interfaceC11938do1;
        this.b = interfaceC9102Ym4;
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC9102Ym4, ir.nasim.InterfaceC9664aL6
    public Object getValue() {
        return this.b.getValue();
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public UA2 o() {
        return this.b.o();
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public void setValue(Object obj) {
        this.b.setValue(obj);
    }

    @Override // ir.nasim.InterfaceC9102Ym4
    public Object x() {
        return this.b.x();
    }
}
