package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class anj {
    private final anh a;
    private final WebView b;
    private final Handler c;

    anj(Handler handler, WebView webView, anh anhVar) {
        this.c = handler;
        this.b = webView;
        this.a = anhVar;
        webView.setBackgroundColor(0);
        int i = Build.VERSION.SDK_INT;
        if (i > 19) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new ang(this));
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = webView.getSettings();
        if (i >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        if (i >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, true);
        }
    }

    public final WebView a() {
        return this.b;
    }

    public final void b(String str) {
        this.b.loadUrl(str);
    }

    public final void c(final amx amxVar) {
        this.c.post(new Runnable(this, amxVar) { // from class: com.google.ads.interactivemedia.v3.internal.anf
            private final anj a;
            private final amx b;

            {
                this.a = this;
                this.b = amxVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(this.b);
            }
        });
    }

    protected final void d(String str) {
        try {
            amx amxVarA = amx.a(str);
            String strValueOf = String.valueOf(amxVarA);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32 + String.valueOf(str).length());
            sb.append("Received Javascript msg: ");
            sb.append(strValueOf);
            sb.append("; URL: ");
            sb.append(str);
            yy.c(sb.toString());
            this.a.d(amxVarA);
        } catch (IllegalArgumentException unused) {
            String strValueOf2 = String.valueOf(str);
            yy.d(strValueOf2.length() != 0 ? "Invalid internal message. Please make sure the Google IMA SDK library is up to date. Message: ".concat(strValueOf2) : new String("Invalid internal message. Please make sure the Google IMA SDK library is up to date. Message: "));
        } catch (Exception e) {
            String strValueOf3 = String.valueOf(str);
            yy.e(strValueOf3.length() != 0 ? "Invalid internal message. Message could not be be parsed: ".concat(strValueOf3) : new String("Invalid internal message. Message could not be be parsed: "), e);
        }
    }

    public final void e() {
        this.b.destroy();
    }

    final /* synthetic */ void f(amx amxVar) {
        String strF = amxVar.f();
        String strValueOf = String.valueOf(amxVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(strF).length());
        sb.append("Sending Javascript msg: ");
        sb.append(strValueOf);
        sb.append("; URL: ");
        sb.append(strF);
        yy.c(sb.toString());
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                this.b.evaluateJavascript(strF, null);
                return;
            } catch (IllegalStateException unused) {
            }
        }
        this.b.loadUrl(strF);
    }
}
