package io.appmetrica.analytics.impl;

import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.re, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2828re implements K7 {
    public final Ee a;
    public final List<C2805qe> b;

    public C2828re(Ee ee, List<C2805qe> list) {
        this.a = ee;
        this.b = list;
    }

    @Override // io.appmetrica.analytics.impl.K7
    public final List<C2805qe> a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.K7
    public final Object b() {
        return this.a;
    }

    public final Ee c() {
        return this.a;
    }

    public final String toString() {
        return "PreloadInfoData{chosenPreloadInfo=" + this.a + ", candidates=" + this.b + '}';
    }
}
