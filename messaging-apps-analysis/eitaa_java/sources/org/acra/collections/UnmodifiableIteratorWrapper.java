package org.acra.collections;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* loaded from: classes.dex */
class UnmodifiableIteratorWrapper<E> implements Iterator<E>, j$.util.Iterator {
    private final Iterator<E> mIterator;

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    UnmodifiableIteratorWrapper(java.util.Iterator<E> it) {
        this.mIterator = it;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.mIterator.hasNext();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public E next() {
        return this.mIterator.next();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
