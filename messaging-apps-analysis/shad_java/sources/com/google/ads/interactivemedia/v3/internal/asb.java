package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asb extends asc<Comparable> implements Serializable {
    static final asb a = new asb();
    private static final long serialVersionUID = 0;

    private asb() {
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc
    public final <S extends Comparable> asc<S> a() {
        return ask.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        aqd.j(comparable);
        aqd.j(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
