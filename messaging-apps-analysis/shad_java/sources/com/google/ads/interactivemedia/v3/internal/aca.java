package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aca {
    private Uri a;
    private long d;
    private String f;
    private int g;
    private final int b = 1;
    private Map<String, String> c = Collections.emptyMap();
    private long e = -1;

    public final acb a() {
        ary.w(this.a, "The uri must be set.");
        return new acb(this.a, 1, null, this.c, this.d, this.e, this.f, this.g, null);
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void c(Map<String, String> map) {
        this.c = map;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final void e(long j) {
        this.e = j;
    }

    public final void f(long j) {
        this.d = j;
    }

    public final void g(Uri uri) {
        this.a = uri;
    }
}
