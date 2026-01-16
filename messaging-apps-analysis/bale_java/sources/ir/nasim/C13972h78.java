package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;

/* renamed from: ir.nasim.h78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13972h78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C13972h78(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static ConnectivityManager a(Context context) {
        return (ConnectivityManager) AbstractC4746Gj5.d(C12745f78.a.b(context));
    }

    public static C13972h78 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C13972h78(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ConnectivityManager get() {
        return a((Context) this.a.get());
    }
}
