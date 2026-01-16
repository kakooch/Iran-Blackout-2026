package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqs<T> extends asc<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> a;

    aqs(Comparator<T> comparator) {
        aqd.j(comparator);
        this.a = comparator;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc, java.util.Comparator
    public final int compare(T t, T t2) {
        return this.a.compare(t, t2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aqs) {
            return this.a.equals(((aqs) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
