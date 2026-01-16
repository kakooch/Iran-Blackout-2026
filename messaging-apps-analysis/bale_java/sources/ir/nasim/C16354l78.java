package ir.nasim;

import okhttp3.OkHttpClient;

/* renamed from: ir.nasim.l78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16354l78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C16354l78(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C16354l78 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C16354l78(interfaceC7720Sx5);
    }

    public static OkHttpClient c(OkHttpClient okHttpClient) {
        return (OkHttpClient) AbstractC4746Gj5.d(C12745f78.a.f(okHttpClient));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public OkHttpClient get() {
        return c((OkHttpClient) this.a.get());
    }
}
