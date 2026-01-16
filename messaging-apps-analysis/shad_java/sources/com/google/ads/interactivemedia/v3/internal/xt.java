package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class xt {
    private final xq a;
    public final cy b;
    public final String c;
    public final long d;
    public final List<xm> e;

    /* synthetic */ xt(cy cyVar, String str, xz xzVar, List list) {
        this.b = cyVar;
        this.c = str;
        this.e = Collections.unmodifiableList(list);
        this.a = xzVar.i(this);
        this.d = aeu.N(xzVar.j, 1000000L, xzVar.i);
    }

    public abstract xq k();

    public abstract wx l();

    public abstract String m();

    public final xq n() {
        return this.a;
    }
}
