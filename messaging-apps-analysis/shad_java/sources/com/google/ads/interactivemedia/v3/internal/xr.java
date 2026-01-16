package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xr extends xt implements wx {
    final xu a;

    public xr(cy cyVar, String str, xu xuVar, List<xm> list) {
        super(cyVar, str, xuVar, list);
        this.a = xuVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long a(long j, long j2) {
        return this.a.a(j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long b(long j) {
        return this.a.c(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long c(long j, long j2) {
        return this.a.b(j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final xq d(long j) {
        return this.a.d(this, j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long e() {
        return this.a.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long f(long j, long j2) {
        return this.a.e(j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final int g(long j) {
        return this.a.h(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final int h(long j, long j2) {
        return this.a.f(j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final long i(long j, long j2) {
        xu xuVar = this.a;
        if (xuVar.c != null) {
            return -9223372036854775807L;
        }
        long jE = xuVar.e(j, j2) + xuVar.f(j, j2);
        return (xuVar.c(jE) + xuVar.b(jE, j)) - xuVar.d;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wx
    public final boolean j() {
        return this.a.g();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xt
    public final xq k() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xt
    public final wx l() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xt
    public final String m() {
        return null;
    }
}
