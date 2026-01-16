package ir.nasim;

/* loaded from: classes3.dex */
public final class ON implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;

    public ON(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
    }

    public static InterfaceC10670c01 a(boolean z, AbstractC24902zP abstractC24902zP, ZV0 zv0, InterfaceC7720Sx5 interfaceC7720Sx5) {
        return (InterfaceC10670c01) AbstractC4746Gj5.d(KN.a.e(z, abstractC24902zP, zv0, interfaceC7720Sx5));
    }

    public static ON b(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        return new ON(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC10670c01 get() {
        return a(((Boolean) this.a.get()).booleanValue(), (AbstractC24902zP) this.b.get(), (ZV0) this.c.get(), this.d);
    }
}
