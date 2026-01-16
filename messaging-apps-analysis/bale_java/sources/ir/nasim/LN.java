package ir.nasim;

/* loaded from: classes3.dex */
public final class LN implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;

    public LN(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
    }

    public static IN a(InterfaceC7720Sx5 interfaceC7720Sx5, IN in, AbstractC24902zP abstractC24902zP) {
        return (IN) AbstractC4746Gj5.d(KN.a.b(interfaceC7720Sx5, in, abstractC24902zP));
    }

    public static LN b(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53) {
        return new LN(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public IN get() {
        return a(this.a, (IN) this.b.get(), (AbstractC24902zP) this.c.get());
    }
}
