package ir.nasim;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import ir.nasim.W10;

/* renamed from: ir.nasim.yX, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C24380yX extends WebChromeClient {
    public C13914h20 a;

    public C13914h20 a() {
        C13914h20 c13914h20 = this.a;
        if (c13914h20 != null) {
            return c13914h20;
        }
        AbstractC13042fc3.y("state");
        return null;
    }

    public void b(C13914h20 c13914h20) {
        AbstractC13042fc3.i(c13914h20, "<set-?>");
        this.a = c13914h20;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (a().c() instanceof W10.a) {
            return;
        }
        a().f(new W10.c(i / 100.0f));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        a().g(bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        a().h(str);
    }
}
