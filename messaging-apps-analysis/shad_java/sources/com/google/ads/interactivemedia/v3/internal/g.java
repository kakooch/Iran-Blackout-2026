package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class g {
    private final n a;
    private final WebView b;
    private final List<ek> c = new ArrayList();
    private final Map<String, ek> d = new HashMap();
    private final String e;
    private final String f;
    private final h g;

    private g(n nVar, WebView webView, String str, String str2, h hVar) {
        this.a = nVar;
        this.b = webView;
        this.g = hVar;
        this.f = str;
        this.e = str2;
    }

    public static g a(n nVar, WebView webView, String str, String str2) {
        ih.b(nVar, "Partner is null");
        ih.b(webView, "WebView is null");
        if (str2 == null || str2.length() <= 256) {
            return new g(nVar, webView, str, str2, h.JAVASCRIPT);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }

    public final n b() {
        return this.a;
    }

    public final List<ek> c() {
        return Collections.unmodifiableList(this.c);
    }

    public final Map<String, ek> d() {
        return Collections.unmodifiableMap(this.d);
    }

    public final WebView e() {
        return this.b;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.e;
    }

    public final h h() {
        return this.g;
    }
}
