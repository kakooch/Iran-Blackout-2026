package ir.nasim;

/* renamed from: ir.nasim.zF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24818zF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C24818zF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C24818zF5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C24818zF5(interfaceC7720Sx5);
    }

    public static FF5 c(C24689z25 c24689z25) {
        return (FF5) AbstractC4746Gj5.d(C17017mF5.a.s(c24689z25));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FF5 get() {
        return c((C24689z25) this.a.get());
    }
}
