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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class ImmutableList<E> implements List<E>, Serializable, j$.util.List {
    private final List<E> mList;

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

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return S1.v(a.D(this), false);
    }

    @SafeVarargs
    public ImmutableList(E... eArr) {
        this(Arrays.asList(eArr));
    }

    public ImmutableList(java.util.Collection<E> collection) {
        this.mList = new ArrayList(collection);
    }

    @Override // java.util.List, j$.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i, java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean contains(Object obj) {
        return this.mList.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(java.util.Collection<?> collection) {
        return this.mList.containsAll(collection);
    }

    @Override // java.util.List, j$.util.List
    public E get(int i) {
        return this.mList.get(i);
    }

    @Override // java.util.List, j$.util.List
    public int indexOf(Object obj) {
        return this.mList.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean isEmpty() {
        return this.mList.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, java.util.AbstractCollection, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public Iterator<E> iterator() {
        return new UnmodifiableIteratorWrapper(this.mList.iterator());
    }

    @Override // java.util.List, j$.util.List
    public int lastIndexOf(Object obj) {
        return this.mList.lastIndexOf(obj);
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<E> listIterator() {
        return new UnmodifiableListIteratorWrapper(this.mList.listIterator());
    }

    @Override // java.util.List, j$.util.List
    public ListIterator<E> listIterator(int i) {
        return new UnmodifiableListIteratorWrapper(this.mList.listIterator(i));
    }

    @Override // java.util.List, j$.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int size() {
        return this.mList.size();
    }

    @Override // java.util.List, j$.util.List
    public java.util.List<E> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray() {
        return this.mList.toArray();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.mList.toArray(tArr);
    }
}
