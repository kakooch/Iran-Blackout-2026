package kotlin.collections;

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
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sets.kt */
/* loaded from: classes.dex */
public final class EmptySet implements Set, Serializable, j$.util.Set {
    public static final EmptySet INSTANCE = new EmptySet();

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
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

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return S1.v(a.D(this), true);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return Set.CC.$default$spliterator(this);
    }

    @Override // java.util.Collection, j$.util.Collection
    public /* synthetic */ Stream stream() {
        return S1.v(a.D(this), false);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return "[]";
    }

    private EmptySet() {
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return contains((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof java.util.Set) && ((java.util.Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
    public boolean containsAll(java.util.Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }
}
