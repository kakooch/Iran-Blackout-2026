package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class apu<T> extends aqa<T> {
    static final apu<Object> a = new apu<>();
    private static final long serialVersionUID = 0;

    private apu() {
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqa
    public final T a() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqa
    public final <V> aqa<V> b(apw<? super T, V> apwVar) {
        aqd.j(apwVar);
        return a;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
