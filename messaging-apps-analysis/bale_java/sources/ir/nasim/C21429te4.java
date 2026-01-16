package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.te4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21429te4 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public C21429te4(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static C21429te4 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C21429te4(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static C20809se4 c(Context context, Object obj) {
        return new C20809se4(context, (C19175pu1) obj);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C20809se4 get() {
        return c((Context) this.a.get(), this.b.get());
    }
}
