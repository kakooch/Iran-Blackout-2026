package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ang extends WebViewClient {
    final /* synthetic */ anj a;

    ang(anj anjVar) {
        this.a = anjVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        yy.c(strValueOf.length() != 0 ? "Finished ".concat(strValueOf) : new String("Finished "));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String strValueOf = String.valueOf(str);
        yy.c(strValueOf.length() != 0 ? "Started ".concat(strValueOf) : new String("Started "));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Error: ");
        sb.append(i);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        yy.c(sb.toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("gmsg://")) {
            return false;
        }
        this.a.d(str);
        return true;
    }
}
