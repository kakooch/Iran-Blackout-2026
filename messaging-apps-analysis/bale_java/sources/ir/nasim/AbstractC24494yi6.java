package ir.nasim;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import ir.nasim.core.network.sslpinning.SecureWebView;
import java.util.HashSet;

/* renamed from: ir.nasim.yi6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24494yi6 extends WebViewClient {
    private final HashSet a = new HashSet();

    private final String a(String str) {
        Uri uri = Uri.parse(str);
        AbstractC13042fc3.h(uri, "parse(this)");
        String string = uri.buildUpon().clearQuery().fragment(null).build().toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        if (str != null && this.a.contains(a(str))) {
            SecureWebView secureWebView = webView instanceof SecureWebView ? (SecureWebView) webView : null;
            if (secureWebView != null) {
                secureWebView.v(str);
            }
        }
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String strA;
        if (str != null && (strA = a(str)) != null) {
            this.a.add(strA);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String strA;
        if (str != null && (strA = a(str)) != null) {
            this.a.add(strA);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String string;
        String strA;
        if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (string = url.toString()) != null && (strA = a(string)) != null) {
            this.a.add(strA);
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
