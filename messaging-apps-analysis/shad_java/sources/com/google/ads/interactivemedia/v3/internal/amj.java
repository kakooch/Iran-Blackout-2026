package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amj extends WebViewClient {
    final /* synthetic */ amk a;

    amj(amk amkVar) {
        this.a = amkVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.a.b.o(str);
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((CompanionAdSlot.ClickListener) it.next()).onCompanionAdClick();
        }
        return true;
    }
}
