package ir.nasim;

/* renamed from: ir.nasim.i78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14570i78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public C14570i78(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static C14570i78 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C14570i78(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static UA2 c(ZV0 zv0, InterfaceC7188Qq4 interfaceC7188Qq4) {
        return (UA2) AbstractC4746Gj5.d(C12745f78.a.c(zv0, interfaceC7188Qq4));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UA2 get() {
        return c((ZV0) this.a.get(), (InterfaceC7188Qq4) this.b.get());
    }
}
