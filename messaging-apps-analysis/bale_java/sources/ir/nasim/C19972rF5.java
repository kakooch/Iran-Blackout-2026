package ir.nasim;

/* renamed from: ir.nasim.rF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19972rF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public C19972rF5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static C19972rF5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C19972rF5(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static C7239Qw1 b(C8668Wy3 c8668Wy3, CO co) {
        return (C7239Qw1) AbstractC4746Gj5.d(C17017mF5.a.j(c8668Wy3, co));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C7239Qw1 get() {
        return b((C8668Wy3) this.a.get(), (CO) this.b.get());
    }
}
