package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.core.network.sslpinning.SecureWebView;
import ir.nasim.features.bank.mybank.webview.WebViewInterface;

/* renamed from: ir.nasim.x88, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23572x88 extends AbstractC21707u0 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static boolean g;
    private final C9057Yh4 b;
    private N88 c;
    private final InterfaceC9173Yu3 d;

    /* renamed from: ir.nasim.x88$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.x88$c */
    public static final class c extends WebChromeClient {
        c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String strMessage;
            if (consoleMessage == null || (strMessage = consoleMessage.message()) == null) {
                return true;
            }
            Log.d("WEBVIEW", strMessage);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23572x88(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.w88
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C23572x88.H(this.a);
            }
        });
        g = true;
    }

    private final C24162y88 B(String str, Context context, FragmentActivity fragmentActivity, C14486i0 c14486i0, J44 j44, InterfaceC22386v88 interfaceC22386v88, SA2 sa2, UA2 ua2) {
        SecureWebView secureWebView = new SecureWebView(context, null, 0, 0, 14, null);
        WebViewInterface webViewInterface = new WebViewInterface(secureWebView, context, fragmentActivity, c14486i0, j44, interfaceC22386v88, ua2);
        WebSettings settings = secureWebView.getSettings();
        AbstractC13042fc3.h(settings, "getSettings(...)");
        settings.setJavaScriptEnabled(true);
        boolean zX = AbstractC20762sZ6.X(str, "https://tooshle", false, 2, null);
        if (zX) {
            settings.setUserAgentString("bale/webView");
        }
        InterfaceC22972w78 p76 = (zX && C8386Vt0.a.T9()) ? new P76(context, C()) : new NH4(context);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setMixedContentMode(0);
        secureWebView.addJavascriptInterface(webViewInterface, "BaleAndroid");
        secureWebView.setWebViewClient(new b(sa2, p76, secureWebView, context));
        secureWebView.setWebChromeClient(new c());
        secureWebView.loadUrl(str);
        return new C24162y88(secureWebView, webViewInterface);
    }

    private final String C() {
        return (String) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H(C23572x88 c23572x88) {
        AbstractC13042fc3.i(c23572x88, "this$0");
        return c23572x88.b.S().v4();
    }

    public final C24162y88 D(String str, Context context, FragmentActivity fragmentActivity, C14486i0 c14486i0, J44 j44, InterfaceC22386v88 interfaceC22386v88, SA2 sa2, UA2 ua2) {
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(fragmentActivity, "parent");
        AbstractC13042fc3.i(sa2, "onPageFinished");
        F(str);
        return B(str, context, fragmentActivity, c14486i0, j44, interfaceC22386v88, sa2, ua2);
    }

    public final void F(String str) {
        AbstractC13042fc3.i(str, "url");
        N88 n88 = this.c;
        if (n88 != null) {
            n88.j(str);
        }
    }

    public final void G() {
        this.c = new N88(this.b);
    }

    /* renamed from: ir.nasim.x88$b */
    public static final class b extends AbstractC24494yi6 {
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC22972w78 c;
        final /* synthetic */ SecureWebView d;
        final /* synthetic */ Context e;

        b(SA2 sa2, InterfaceC22972w78 interfaceC22972w78, SecureWebView secureWebView, Context context) {
            this.b = sa2;
            this.c = interfaceC22972w78;
            this.d = secureWebView;
            this.e = context;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.b.invoke();
        }

        @Override // ir.nasim.AbstractC24494yi6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (!AbstractC13042fc3.d(this.d.getUrl(), str2)) {
                super.onReceivedError(webView, i, str, str2);
            } else {
                if (C4100Dr4.a(this.e)) {
                    return;
                }
                C5495Jo7.a.J2();
                this.d.loadUrl("file:///android_asset/offline_my_bank/offline.html");
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse webResourceResponseA = this.c.a(webResourceRequest);
            return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            AbstractC13042fc3.i(webView, "view");
            AbstractC13042fc3.i(webResourceRequest, "request");
            AbstractC13042fc3.i(webResourceError, "error");
            onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }
}
