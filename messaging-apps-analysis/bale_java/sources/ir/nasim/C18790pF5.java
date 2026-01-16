package ir.nasim;

/* renamed from: ir.nasim.pF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18790pF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C18790pF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static InterfaceC24893zO a(C7239Qw1 c7239Qw1) {
        return (InterfaceC24893zO) AbstractC4746Gj5.d(C17017mF5.a.h(c7239Qw1));
    }

    public static C18790pF5 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C18790pF5(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC24893zO get() {
        return a((C7239Qw1) this.a.get());
    }
}
