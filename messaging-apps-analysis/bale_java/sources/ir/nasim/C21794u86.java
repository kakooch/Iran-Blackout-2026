package ir.nasim;

/* renamed from: ir.nasim.u86, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21794u86 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;

    public C21794u86(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
    }

    public static C21794u86 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        return new C21794u86(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55);
    }

    public static C21120t86 c(QV0 qv0, QV0 qv02, Object obj, Object obj2, InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C21120t86(qv0, qv02, (AbstractC13649gb2) obj, (C16646ld6) obj2, interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21120t86 get() {
        return c((QV0) this.a.get(), (QV0) this.b.get(), this.c.get(), this.d.get(), this.e);
    }
}
