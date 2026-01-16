package kotlin.collections;

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
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Collections.kt */
/* loaded from: classes.dex */
public final class EmptyList implements List, Serializable, RandomAccess, j$.util.List {
    public static final EmptyList INSTANCE = new EmptyList();

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return false;
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public int hashCode() {
        return 1;
    }

    public int indexOf(Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean isEmpty() {
        return true;
    }

    public int lastIndexOf(Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return S1.v(a.D(this), true);
    }

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, j$.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return "[]";
    }

    private EmptyList() {
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    @Override // java.util.List, j$.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return indexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, j$.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return lastIndexOf((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean equals(Object obj) {
        return (obj instanceof java.util.List) && ((java.util.List) obj).isEmpty();
    }

    @Override // java.util.List, java.util.Collection, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    public boolean containsAll(java.util.Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty();
    }

    @Override // java.util.List, j$.util.List
    public Void get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable, j$.util.List, java.util.AbstractCollection, j$.util.Collection, java.util.Set, j$.lang.Iterable
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List, j$.util.List
    public ListIterator listIterator(int i) {
        if (i != 0) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List, j$.util.List
    public java.util.List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
    }
}
