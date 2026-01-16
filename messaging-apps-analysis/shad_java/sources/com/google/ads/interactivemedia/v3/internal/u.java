package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class u implements Runnable {
    final /* synthetic */ WebView a;
    final /* synthetic */ String b;

    u(WebView webView, String str) {
        this.a = webView;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.loadUrl(this.b);
    }
}
