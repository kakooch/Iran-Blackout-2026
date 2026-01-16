package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ae implements Runnable {
    final /* synthetic */ af a;
    private final WebView b;

    ae(af afVar) {
        this.a = afVar;
        this.b = afVar.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.destroy();
    }
}
