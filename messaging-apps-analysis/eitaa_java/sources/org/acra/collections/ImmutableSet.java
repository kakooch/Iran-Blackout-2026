package org.acra.collections;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class ImmutableSet<E> implements Set<E>, Serializable, j$.util.Set {
    private static final ImmutableSet<Object> EMPTY = new ImmutableSet<>();
    private final Set<E> mSet;

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

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return S1.v(a.D(this), false);
    }

    public static <T> ImmutableSet<T> empty() {
        return (ImmutableSet<T>) EMPTY;
    }

    private ImmutableSet() {
        this.mSet = Collections.emptySet();
    }

    public ImmutableSet(java.util.Collection<E> collection) {
        this.mSet = new LinkedHashSet(collection);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean addAll(java.util.Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean contains(Object obj) {
        return this.mSet.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean containsAll(java.util.Collection<?> collection) {
        return this.mSet.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean isEmpty() {
        return this.mSet.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public Iterator<E> iterator() {
        return new UnmodifiableIteratorWrapper(this.mSet.iterator());
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public int size() {
        return this.mSet.size();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public Object[] toArray() {
        return this.mSet.toArray();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.mSet.toArray(tArr);
    }

    public static final class Builder<E> {
        private final java.util.Set<E> mSet = new LinkedHashSet();

        public void add(E e) {
            this.mSet.add(e);
        }

        public ImmutableSet<E> build() {
            return new ImmutableSet<>(this.mSet);
        }
    }
}
