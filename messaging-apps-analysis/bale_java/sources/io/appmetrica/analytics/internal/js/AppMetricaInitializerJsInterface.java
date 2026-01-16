package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C2601i1;

/* loaded from: classes3.dex */
public class AppMetricaInitializerJsInterface {
    private final C2601i1 a;

    public AppMetricaInitializerJsInterface(C2601i1 c2601i1) {
        this.a = c2601i1;
    }

    @JavascriptInterface
    public void init(String str) {
        this.a.c(str);
    }
}
