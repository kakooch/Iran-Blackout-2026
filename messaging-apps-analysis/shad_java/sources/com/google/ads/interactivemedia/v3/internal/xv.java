package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xv extends xu {
    final List<xq> e;

    public xv(xq xqVar, long j, long j2, long j3, long j4, List<xx> list, long j5, List<xq> list2, long j6, long j7) {
        super(xqVar, j, j2, j3, j4, list, j5, j6, j7);
        this.e = list2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xu
    public final xq d(xt xtVar, long j) {
        return this.e.get((int) (j - this.a));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xu
    public final boolean g() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xu
    public final int h(long j) {
        return this.e.size();
    }
}
