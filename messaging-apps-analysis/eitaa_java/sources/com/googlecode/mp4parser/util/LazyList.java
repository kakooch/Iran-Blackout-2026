package com.googlecode.mp4parser.util;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class LazyList<E> extends AbstractList<E> implements List {
    private static final Logger LOG = Logger.getLogger(LazyList.class);
    Iterator<E> elementSource;
    java.util.List<E> underlying;

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return S1.v(a.D(this), true);
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.List, j$.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return S1.v(a.D(this), false);
    }

    public LazyList(java.util.List<E> list, Iterator<E> it) {
        this.underlying = list;
        this.elementSource = it;
    }

    private void blowup() {
        LOG.logDebug("blowup running");
        while (this.elementSource.hasNext()) {
            this.underlying.add(this.elementSource.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List, j$.util.List
    public E get(int i) {
        if (this.underlying.size() > i) {
            return this.underlying.get(i);
        }
        if (this.elementSource.hasNext()) {
            this.underlying.add(this.elementSource.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public Iterator<E> iterator() {
        return new AnonymousClass1();
    }

    /* renamed from: com.googlecode.mp4parser.util.LazyList$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<E>, j$.util.Iterator {
        int pos = 0;

        AnonymousClass1() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.pos < LazyList.this.underlying.size() || LazyList.this.elementSource.hasNext();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public E next() {
            if (this.pos < LazyList.this.underlying.size()) {
                java.util.List<E> list = LazyList.this.underlying;
                int i = this.pos;
                this.pos = i + 1;
                return list.get(i);
            }
            LazyList lazyList = LazyList.this;
            lazyList.underlying.add(lazyList.elementSource.next());
            return (E) next();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int size() {
        LOG.logDebug("potentially expensive size() call");
        blowup();
        return this.underlying.size();
    }
}
