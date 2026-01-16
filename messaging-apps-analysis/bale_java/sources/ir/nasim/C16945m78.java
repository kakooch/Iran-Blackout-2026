package ir.nasim;

import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* renamed from: ir.nasim.m78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16945m78 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C16945m78(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C16945m78 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C16945m78(interfaceC7720Sx5);
    }

    public static WebSocket.Factory c(OkHttpClient okHttpClient) {
        return (WebSocket.Factory) AbstractC4746Gj5.d(C12745f78.a.g(okHttpClient));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WebSocket.Factory get() {
        return c((OkHttpClient) this.a.get());
    }
}
