package com.google.ads.interactivemedia.v3.internal;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX WARN: Unexpected interfaces in signature: [j$.util.Iterator] */
/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class asq<E> extends asp<E> implements ListIterator<E> {
    private final int a;
    private int b;
    private final arn c;

    protected asq() {
    }

    protected asq(int i, int i2) {
        this();
        aqd.l(i2, i);
        this.a = i;
        this.b = i2;
    }

    protected Object a(int i) {
        return this.c.get(i);
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.b < this.a;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }

    asq(arn arnVar, int i) {
        this(arnVar.size(), i);
        this.c = arnVar;
    }
}
