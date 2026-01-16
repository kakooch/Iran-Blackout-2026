package ir.nasim;

/* renamed from: ir.nasim.ox3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C18615ox3 extends MG6 {
    private final InterfaceC7948Tw3 a;

    public C18615ox3(InterfaceC7948Tw3 interfaceC7948Tw3) {
        AbstractC13042fc3.i(interfaceC7948Tw3, "lazyListItem");
        this.a = interfaceC7948Tw3;
    }

    @Override // ir.nasim.MG6
    public int a() {
        return this.a.getIndex();
    }

    @Override // ir.nasim.MG6
    public int b() {
        return this.a.getOffset();
    }

    @Override // ir.nasim.MG6
    public int c() {
        return this.a.f();
    }
}
