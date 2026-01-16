package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class arj<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] a = new Object[0];

    arj() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract asp<E> listIterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    Object[] b() {
        return null;
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    int d() {
        throw new UnsupportedOperationException();
    }

    public arn<E> e() {
        throw null;
    }

    abstract boolean f();

    int g(Object[] objArr) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(a);
    }

    Object writeReplace() {
        return new arl(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        aqd.j(tArr);
        int size = size();
        int length = tArr.length;
        if (length < size) {
            Object[] objArrB = b();
            if (objArrB != null) {
                return (T[]) Arrays.copyOfRange(objArrB, c(), d(), tArr.getClass());
            }
            tArr = (T[]) asn.e(tArr, size);
        } else if (length > size) {
            tArr[size] = null;
        }
        g(tArr);
        return tArr;
    }
}
