package org.acra.collections;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class BoundedLinkedList<E> extends LinkedList<E> implements Collection, List {
    private final int maxSize;

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

    @Override // java.util.LinkedList, java.util.Collection, java.lang.Iterable, java.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return S1.v(a.D(this), false);
    }

    public BoundedLinkedList(int i) {
        this.maxSize = i;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean add(E e) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        return super.add(e);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List, j$.util.List
    public void add(int i, E e) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        super.add(i, e);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(java.util.Collection<? extends E> collection) {
        int size = collection.size();
        if (size > this.maxSize) {
            collection = new ArrayList(collection).subList(size - this.maxSize, size);
        }
        int size2 = (size() + collection.size()) - this.maxSize;
        if (size2 > 0) {
            removeRange(0, size2);
        }
        return super.addAll(collection);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List, j$.util.List
    public boolean addAll(int i, java.util.Collection<? extends E> collection) {
        if (i == size()) {
            return super.addAll(i, collection);
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addFirst(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addLast(E e) {
        add(e);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override // java.util.LinkedList, java.util.Deque
    public boolean offerLast(E e) {
        return add(e);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void push(E e) {
        add(e);
    }
}
