package androidx.collection;

import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
abstract class MapCollections<K, V> {
    MapCollections<K, V>.EntrySet mEntrySet;
    MapCollections<K, V>.KeySet mKeySet;
    MapCollections<K, V>.ValuesCollection mValues;

    protected abstract void colClear();

    protected abstract Object colGetEntry(int i, int i2);

    protected abstract Map<K, V> colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(Object obj);

    protected abstract int colIndexOfValue(Object obj);

    protected abstract void colPut(K k, V v);

    protected abstract void colRemoveAt(int i);

    protected abstract V colSetValue(int i, V v);

    MapCollections() {
    }

    final class ArrayIterator<T> implements Iterator<T>, j$.util.Iterator {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        ArrayIterator(int i) {
            this.mOffset = i;
            this.mSize = MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return t;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (!this.mCanRemove) {
                throw new IllegalStateException();
            }
            int i = this.mIndex - 1;
            this.mIndex = i;
            this.mSize--;
            this.mCanRemove = false;
            MapCollections.this.colRemoveAt(i);
        }
    }

    final class MapIterator implements java.util.Iterator<Map.Entry<K, V>>, Map.Entry<K, V>, Map.Entry, j$.util.Iterator {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex = -1;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        MapIterator() {
            this.mEnd = MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            if (!this.mEntryValid) {
                throw new IllegalStateException();
            }
            MapCollections.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) MapCollections.this.colGetEntry(this.mIndex, 0);
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V getValue() {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) MapCollections.this.colGetEntry(this.mIndex, 1);
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V setValue(V v) {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) MapCollections.this.colSetValue(this.mIndex, v);
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ContainerHelpers.equal(entry.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) && ContainerHelpers.equal(entry.getValue(), MapCollections.this.colGetEntry(this.mIndex, 1));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public int hashCode() {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objColGetEntry = MapCollections.this.colGetEntry(this.mIndex, 0);
            Object objColGetEntry2 = MapCollections.this.colGetEntry(this.mIndex, 1);
            return (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 != null ? objColGetEntry2.hashCode() : 0);
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class EntrySet implements Set<Map.Entry<K, V>>, j$.util.Set {
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

        EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean addAll(java.util.Collection<? extends Map.Entry<K, V>> collection) {
            int iColGetSize = MapCollections.this.colGetSize();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            return iColGetSize != MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iColIndexOfKey = MapCollections.this.colIndexOfKey(entry.getKey());
            if (iColIndexOfKey < 0) {
                return false;
            }
            return ContainerHelpers.equal(MapCollections.this.colGetEntry(iColIndexOfKey, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
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
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iColGetSize = MapCollections.this.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                Object objColGetEntry = MapCollections.this.colGetEntry(iColGetSize, 0);
                Object objColGetEntry2 = MapCollections.this.colGetEntry(iColGetSize, 1);
                iHashCode += (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 == null ? 0 : objColGetEntry2.hashCode());
            }
            return iHashCode;
        }
    }

    final class KeySet implements java.util.Set<K>, j$.util.Set {
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

        KeySet() {
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean addAll(java.util.Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean contains(Object obj) {
            return MapCollections.this.colIndexOfKey(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable, j$.util.Set, j$.util.Collection, j$.lang.Iterable
        public java.util.Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean remove(Object obj) {
            int iColIndexOfKey = MapCollections.this.colIndexOfKey(obj);
            if (iColIndexOfKey < 0) {
                return false;
            }
            MapCollections.this.colRemoveAt(iColIndexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection, j$.util.Set, j$.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iColGetSize = MapCollections.this.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                Object objColGetEntry = MapCollections.this.colGetEntry(iColGetSize, 0);
                iHashCode += objColGetEntry == null ? 0 : objColGetEntry.hashCode();
            }
            return iHashCode;
        }
    }

    final class ValuesCollection implements java.util.Collection<V>, Collection {
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

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return Collection.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return S1.v(a.D(this), false);
        }

        ValuesCollection() {
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(java.util.Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public void clear() {
            MapCollections.this.colClear();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean contains(Object obj) {
            return MapCollections.this.colIndexOfValue(obj) >= 0;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean isEmpty() {
            return MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public java.util.Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean remove(Object obj) {
            int iColIndexOfValue = MapCollections.this.colIndexOfValue(obj);
            if (iColIndexOfValue < 0) {
                return false;
            }
            MapCollections.this.colRemoveAt(iColIndexOfValue);
            return true;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean removeAll(java.util.Collection<?> collection) {
            int iColGetSize = MapCollections.this.colGetSize();
            int i = 0;
            boolean z = false;
            while (i < iColGetSize) {
                if (collection.contains(MapCollections.this.colGetEntry(i, 1))) {
                    MapCollections.this.colRemoveAt(i);
                    i--;
                    iColGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean retainAll(java.util.Collection<?> collection) {
            int iColGetSize = MapCollections.this.colGetSize();
            int i = 0;
            boolean z = false;
            while (i < iColGetSize) {
                if (!collection.contains(MapCollections.this.colGetEntry(i, 1))) {
                    MapCollections.this.colRemoveAt(i);
                    i--;
                    iColGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public int size() {
            return MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean removeAllHelper(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(java.util.Map<K, V> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] toArrayHelper(int i) {
        int iColGetSize = colGetSize();
        Object[] objArr = new Object[iColGetSize];
        for (int i2 = 0; i2 < iColGetSize; i2++) {
            objArr[i2] = colGetEntry(i2, i);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i) {
        int iColGetSize = colGetSize();
        if (tArr.length < iColGetSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iColGetSize));
        }
        for (int i2 = 0; i2 < iColGetSize; i2++) {
            tArr[i2] = colGetEntry(i2, i);
        }
        if (tArr.length > iColGetSize) {
            tArr[iColGetSize] = null;
        }
        return tArr;
    }

    public static <T> boolean equalsSetHelper(java.util.Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof java.util.Set) {
            java.util.Set set2 = (java.util.Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public java.util.Set<Map.Entry<K, V>> getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new EntrySet();
        }
        return this.mEntrySet;
    }

    public java.util.Set<K> getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new KeySet();
        }
        return this.mKeySet;
    }

    public java.util.Collection<V> getValues() {
        if (this.mValues == null) {
            this.mValues = new ValuesCollection();
        }
        return this.mValues;
    }
}
