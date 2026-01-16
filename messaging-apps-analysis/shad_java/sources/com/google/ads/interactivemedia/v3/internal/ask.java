package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ask extends asc<Comparable> implements Serializable {
    static final ask a = new ask();
    private static final long serialVersionUID = 0;

    private ask() {
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc
    public final <S extends Comparable> asc<S> a() {
        return asb.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        aqd.j(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
