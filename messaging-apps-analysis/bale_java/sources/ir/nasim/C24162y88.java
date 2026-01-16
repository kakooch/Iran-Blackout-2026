package ir.nasim;

import android.webkit.WebView;
import ir.nasim.features.bank.mybank.webview.WebViewInterface;
import java.io.Serializable;

/* renamed from: ir.nasim.y88, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24162y88 implements Serializable {
    private WebView a;
    private WebViewInterface b;

    public C24162y88(WebView webView, WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(webViewInterface, "wvInterface");
        this.a = webView;
        this.b = webViewInterface;
    }

    public final WebView a() {
        return this.a;
    }

    public final WebViewInterface b() {
        return this.b;
    }
}
