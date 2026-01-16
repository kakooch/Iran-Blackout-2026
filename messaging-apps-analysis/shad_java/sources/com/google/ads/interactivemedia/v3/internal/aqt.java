package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqt extends aqv {
    aqt() {
    }

    static final aqv f(int i) {
        return i < 0 ? aqv.b : i > 0 ? aqv.c : aqv.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqv
    public final <T> aqv a(T t, T t2, Comparator<T> comparator) {
        return f(comparator.compare(t, t2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqv
    public final aqv b(int i, int i2) {
        return f(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqv
    public final aqv c(boolean z, boolean z2) {
        return f(aqd.o(z2, z));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqv
    public final aqv d(boolean z, boolean z2) {
        return f(aqd.o(z, z2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqv
    public final int e() {
        return 0;
    }
}
