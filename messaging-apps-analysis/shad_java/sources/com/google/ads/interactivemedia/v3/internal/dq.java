package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class dq implements dm {
    public final ts a;
    public int d;
    public boolean e;
    public final List<tw> c = new ArrayList();
    public final Object b = new Object();

    public dq(ty tyVar, boolean z) {
        this.a = new ts(tyVar, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dm
    public final Object a() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dm
    public final es b() {
        return this.a.C();
    }

    public final void c(int i) {
        this.d = i;
        this.e = false;
        this.c.clear();
    }
}
