package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.fd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13055fd6 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;

    public C13055fd6(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
    }

    public static C13055fd6 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        return new C13055fd6(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54);
    }

    public static InterfaceC16628lb8 c(Context context, InterfaceC13031fb2 interfaceC13031fb2, AbstractC4684Gc6 abstractC4684Gc6, QV0 qv0) {
        return (InterfaceC16628lb8) AbstractC3561Bj5.c(AbstractC12446ed6.a(context, interfaceC13031fb2, abstractC4684Gc6, qv0), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC16628lb8 get() {
        return c((Context) this.a.get(), (InterfaceC13031fb2) this.b.get(), (AbstractC4684Gc6) this.c.get(), (QV0) this.d.get());
    }
}
