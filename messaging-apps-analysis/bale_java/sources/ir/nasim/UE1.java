package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class UE1 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;

    public UE1(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
    }

    public static UE1 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        return new UE1(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55);
    }

    public static TE1 c(Executor executor, XV xv, InterfaceC16628lb8 interfaceC16628lb8, InterfaceC13031fb2 interfaceC13031fb2, InterfaceC17505n47 interfaceC17505n47) {
        return new TE1(executor, xv, interfaceC16628lb8, interfaceC13031fb2, interfaceC17505n47);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TE1 get() {
        return c((Executor) this.a.get(), (XV) this.b.get(), (InterfaceC16628lb8) this.c.get(), (InterfaceC13031fb2) this.d.get(), (InterfaceC17505n47) this.e.get());
    }
}
