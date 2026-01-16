package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.vP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22532vP implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C22532vP(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C22532vP a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C22532vP(interfaceC7720Sx5);
    }

    public static C21268tP c(Context context) {
        return new C21268tP(context);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21268tP get() {
        return c((Context) this.a.get());
    }
}
