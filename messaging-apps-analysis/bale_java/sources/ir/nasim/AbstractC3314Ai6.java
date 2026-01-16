package ir.nasim;

import ir.nasim.core.network.sslpinning.SecureWebView;

/* renamed from: ir.nasim.Ai6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC3314Ai6 {
    public static void a(SecureWebView secureWebView, AbstractC13778go1 abstractC13778go1) {
        secureWebView.ioDispatcher = abstractC13778go1;
    }

    public static void b(SecureWebView secureWebView, AbstractC13778go1 abstractC13778go1) {
        secureWebView.mainDispatcher = abstractC13778go1;
    }

    public static void c(SecureWebView secureWebView, InterfaceC7720Sx5 interfaceC7720Sx5) {
        secureWebView.okHttpClientProvider = interfaceC7720Sx5;
    }

    public static void d(SecureWebView secureWebView, InterfaceC20315ro1 interfaceC20315ro1) {
        secureWebView.scope = interfaceC20315ro1;
    }
}
