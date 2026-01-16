package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ad extends ac {
    public ad(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        c(webView);
    }
}
