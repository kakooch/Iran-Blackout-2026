package ir.nasim;

import android.net.ConnectivityManager;

/* renamed from: ir.nasim.j78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15172j78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C15172j78(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C15172j78 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C15172j78(interfaceC7720Sx5);
    }

    public static InterfaceC7188Qq4 c(ConnectivityManager connectivityManager) {
        return (InterfaceC7188Qq4) AbstractC4746Gj5.d(C12745f78.a.d(connectivityManager));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC7188Qq4 get() {
        return c((ConnectivityManager) this.a.get());
    }
}
