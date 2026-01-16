package ir.nasim;

/* renamed from: ir.nasim.g78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13381g78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C13381g78(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static InterfaceC3503Bd1 a(C17625nH4 c17625nH4) {
        return (InterfaceC3503Bd1) AbstractC4746Gj5.d(C12745f78.a.a(c17625nH4));
    }

    public static C13381g78 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C13381g78(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC3503Bd1 get() {
        return a((C17625nH4) this.a.get());
    }
}
