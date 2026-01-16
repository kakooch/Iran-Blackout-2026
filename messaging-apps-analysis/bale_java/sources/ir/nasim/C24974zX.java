package ir.nasim;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import ir.nasim.W10;

/* renamed from: ir.nasim.zX, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C24974zX extends WebViewClient {
    public C13914h20 a;
    public C13323g20 b;

    public C13323g20 a() {
        C13323g20 c13323g20 = this.b;
        if (c13323g20 != null) {
            return c13323g20;
        }
        AbstractC13042fc3.y("navigator");
        return null;
    }

    public C13914h20 b() {
        C13914h20 c13914h20 = this.a;
        if (c13914h20 != null) {
            return c13914h20;
        }
        AbstractC13042fc3.y("state");
        return null;
    }

    public void c(C13323g20 c13323g20) {
        AbstractC13042fc3.i(c13323g20, "<set-?>");
        this.b = c13323g20;
    }

    public void d(C13914h20 c13914h20) {
        AbstractC13042fc3.i(c13914h20, "<set-?>");
        this.a = c13914h20;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        a().e(webView != null ? webView.canGoBack() : false);
        a().f(webView != null ? webView.canGoForward() : false);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b().f(W10.a.a);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        b().f(new W10.c(0.0f));
        b().b().clear();
        b().h(null);
        b().g(null);
        b().e(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webResourceError != null) {
            b().b().add(new X10(webResourceRequest, webResourceError));
        }
    }
}
