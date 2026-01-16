package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class asc<T> implements Comparator<T> {
    protected asc() {
    }

    public static <C extends Comparable> asc<C> b() {
        return asb.a;
    }

    public static <T> asc<T> c(Comparator<T> comparator) {
        return comparator instanceof asc ? (asc) comparator : new aqs(comparator);
    }

    public <S extends T> asc<S> a() {
        return new asl(this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);
}
