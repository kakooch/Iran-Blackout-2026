package ir.nasim;

/* renamed from: ir.nasim.Qr3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7196Qr3 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public C7196Qr3(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static C7196Qr3 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C7196Qr3(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static C6952Pr3 c(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C6952Pr3(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C6952Pr3 get() {
        return c(this.a, this.b);
    }
}
