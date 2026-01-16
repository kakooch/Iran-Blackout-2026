package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class t {
    private static final t a = new t();
    private Context b;

    private t() {
    }

    public static t a() {
        return a;
    }

    public final Context b() {
        return this.b;
    }

    public final void c(Context context) {
        this.b = context != null ? context.getApplicationContext() : null;
    }
}
