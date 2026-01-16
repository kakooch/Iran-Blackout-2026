package ir.nasim;

/* renamed from: ir.nasim.Tv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7943Tv7 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;

    public C7943Tv7(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
    }

    public static C7943Tv7 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        return new C7943Tv7(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55);
    }

    public static C7470Rv7 c(QV0 qv0, QV0 qv02, InterfaceC3733Cc6 interfaceC3733Cc6, WH7 wh7, Wa8 wa8) {
        return new C7470Rv7(qv0, qv02, interfaceC3733Cc6, wh7, wa8);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C7470Rv7 get() {
        return c((QV0) this.a.get(), (QV0) this.b.get(), (InterfaceC3733Cc6) this.c.get(), (WH7) this.d.get(), (Wa8) this.e.get());
    }
}
