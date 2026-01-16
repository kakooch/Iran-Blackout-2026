package com.fasterxml.jackson.databind.util;

import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.u;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class ArrayIterator<T> implements Iterator<T>, Iterable<T>, Iterable, j$.util.Iterator {
    private final T[] _a;
    private int _index = 0;

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return this;
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return u.o(iterator(), 0);
    }

    public ArrayIterator(T[] tArr) {
        this._a = tArr;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this._index < this._a.length;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public T next() {
        int i = this._index;
        T[] tArr = this._a;
        if (i >= tArr.length) {
            throw new NoSuchElementException();
        }
        this._index = i + 1;
        return tArr[i];
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
