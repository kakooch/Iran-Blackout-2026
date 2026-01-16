package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import android.webkit.WebView;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aob {
    private final WebView a;
    private final ViewGroup b;

    public aob(WebView webView, ViewGroup viewGroup) {
        this.a = webView;
        this.b = viewGroup;
    }

    public final void a() {
        if (((ViewGroup) this.a.getParent()) == null) {
            this.b.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        }
        this.a.setVisibility(0);
        this.b.bringChildToFront(this.a);
    }

    public final void b() {
        this.a.setVisibility(4);
    }
}
