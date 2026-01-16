package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class Xa8 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;

    public Xa8(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
    }

    public static Xa8 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        return new Xa8(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54);
    }

    public static Wa8 c(Executor executor, InterfaceC13031fb2 interfaceC13031fb2, InterfaceC16628lb8 interfaceC16628lb8, InterfaceC17505n47 interfaceC17505n47) {
        return new Wa8(executor, interfaceC13031fb2, interfaceC16628lb8, interfaceC17505n47);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Wa8 get() {
        return c((Executor) this.a.get(), (InterfaceC13031fb2) this.b.get(), (InterfaceC16628lb8) this.c.get(), (InterfaceC17505n47) this.d.get());
    }
}
