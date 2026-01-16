package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class d {
    private boolean a;

    final boolean a() {
        return this.a;
    }

    final void b(Context context) {
        ih.b(context, "Application Context cannot be null");
        if (this.a) {
            return;
        }
        this.a = true;
        w.a().b(context);
        r.a().b(context);
        ah.a(context);
        t.a().c(context);
    }
}
