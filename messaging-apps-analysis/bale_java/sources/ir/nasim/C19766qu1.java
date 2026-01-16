package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.qu1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19766qu1 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;

    public C19766qu1(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
    }

    public static C19766qu1 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53) {
        return new C19766qu1(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53);
    }

    public static C19175pu1 c(Context context, QV0 qv0, QV0 qv02) {
        return new C19175pu1(context, qv0, qv02);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C19175pu1 get() {
        return c((Context) this.a.get(), (QV0) this.b.get(), (QV0) this.c.get());
    }
}
