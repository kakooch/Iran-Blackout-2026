package ir.nasim;

import okhttp3.OkHttpClient;

/* renamed from: ir.nasim.oH4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18216oH4 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C18216oH4(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C18216oH4 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C18216oH4(interfaceC7720Sx5);
    }

    public static C17625nH4 c(OkHttpClient okHttpClient) {
        return new C17625nH4(okHttpClient);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C17625nH4 get() {
        return c((OkHttpClient) this.a.get());
    }
}
