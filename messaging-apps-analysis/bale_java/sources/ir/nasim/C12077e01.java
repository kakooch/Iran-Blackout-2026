package ir.nasim;

/* renamed from: ir.nasim.e01, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12077e01 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C12077e01(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C12077e01 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C12077e01(interfaceC7720Sx5);
    }

    public static C11434d01 c(AbstractC13778go1 abstractC13778go1) {
        return new C11434d01(abstractC13778go1);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C11434d01 get() {
        return c((AbstractC13778go1) this.a.get());
    }
}
