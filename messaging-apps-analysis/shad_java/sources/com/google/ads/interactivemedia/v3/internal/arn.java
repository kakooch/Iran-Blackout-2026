package com.google.ads.interactivemedia.v3.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class arn<E> extends arj<E> implements List<E>, RandomAccess {
    private static final asq<Object> a = new asq<>(asd.a, 0);

    arn() {
    }

    public static <E> arn<E> i() {
        return (arn<E>) asd.a;
    }

    public static <E> arn<E> j(E e) {
        return s(e);
    }

    public static <E> arn<E> k(E e, E e2, E e3, E e4, E e5) {
        return s(e, e2, e3, e4, e5);
    }

    public static <E> arn<E> l(Collection<? extends E> collection) {
        if (!(collection instanceof arj)) {
            return s(collection.toArray());
        }
        arn<E> arnVarE = ((arj) collection).e();
        return arnVarE.f() ? n(arnVarE.toArray()) : arnVarE;
    }

    public static <E> arn<E> m(E[] eArr) {
        return eArr.length == 0 ? (arn<E>) asd.a : s((Object[]) eArr.clone());
    }

    static <E> arn<E> n(Object[] objArr) {
        return o(objArr, objArr.length);
    }

    static <E> arn<E> o(Object[] objArr, int i) {
        return i == 0 ? (arn<E>) asd.a : new asd(objArr, i);
    }

    public static <E> ark<E> r() {
        return new ark<>();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private static <E> arn<E> s(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            asn.f(objArr[i], i);
        }
        return n(objArr);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    /* renamed from: a */
    public final asp<E> listIterator() {
        return iterator();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    public final arn<E> e() {
        return this;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (apz.b(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !apz.b(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    int g(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public arn<E> subList(int i, int i2) {
        aqd.h(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (arn<E>) asd.a : new arm(this, i, i3);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final asq<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final asq<E> listIterator(int i) {
        aqd.l(i, size());
        return isEmpty() ? (asq<E>) a : new asq<>(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    Object writeReplace() {
        return new arl(toArray());
    }
}
