package com.google.ads.interactivemedia.v3.internal;

import android.view.View;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class e {
    public static e f(f fVar, g gVar) {
        if (!c.c()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
        ih.b(fVar, "AdSessionConfiguration is null");
        ih.b(gVar, "AdSessionContext is null");
        return new i(fVar, gVar);
    }

    public abstract void a();

    public abstract void b(View view);

    public abstract void c();

    public abstract void d(View view, k kVar, String str);

    public abstract void e();
}
