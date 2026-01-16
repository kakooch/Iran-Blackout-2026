package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asl<T> extends asc<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final asc<? super T> a;

    asl(asc<? super T> ascVar) {
        this.a = ascVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc
    public final <S extends T> asc<S> a() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asc, java.util.Comparator
    public final int compare(T t, T t2) {
        return this.a.compare(t2, t);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof asl) {
            return this.a.equals(((asl) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return -this.a.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 10);
        sb.append(strValueOf);
        sb.append(".reverse()");
        return sb.toString();
    }
}
