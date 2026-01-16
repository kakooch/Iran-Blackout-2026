package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amk extends WebChromeClient {
    final /* synthetic */ Context a;
    final /* synthetic */ ane b;
    final /* synthetic */ List c;

    amk(Context context, ane aneVar, List list) {
        this.a = context;
        this.b = aneVar;
        this.c = list;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        webViewTransport.setWebView(new WebView(this.a));
        webViewTransport.getWebView().setWebViewClient(new amj(this));
        message.sendToTarget();
        return true;
    }
}
