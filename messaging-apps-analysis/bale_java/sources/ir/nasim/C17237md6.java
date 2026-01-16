package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.md6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17237md6 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;

    public C17237md6(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
    }

    public static C17237md6 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53) {
        return new C17237md6(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53);
    }

    public static C16646ld6 c(Context context, String str, int i) {
        return new C16646ld6(context, str, i);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C16646ld6 get() {
        return c((Context) this.a.get(), (String) this.b.get(), ((Integer) this.c.get()).intValue());
    }
}
