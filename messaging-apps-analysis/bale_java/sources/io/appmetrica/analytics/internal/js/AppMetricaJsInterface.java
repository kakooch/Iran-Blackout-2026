package io.appmetrica.analytics.internal.js;

import android.webkit.JavascriptInterface;
import io.appmetrica.analytics.impl.C2601i1;

/* loaded from: classes3.dex */
public class AppMetricaJsInterface {
    private final C2601i1 a;

    public AppMetricaJsInterface(C2601i1 c2601i1) {
        this.a = c2601i1;
    }

    @JavascriptInterface
    public void reportEvent(String str, String str2) {
        this.a.d(str, str2);
    }
}
