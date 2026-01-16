package j$.util.concurrent;

import j$.C0066h;
import j$.C0084q;
import j$.C0087s;
import j$.C0206w;
import j$.M;
import j$.R0;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.z;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import j$.x0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, Serializable, ConcurrentMap {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS = 65535;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    static final int RESERVED = -3;
    private static int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 16;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient c[] counterCells;
    private transient e entrySet;
    private transient i keySet;
    private volatile transient l[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient l[] table;
    private volatile transient int transferIndex;
    private transient u values;

    static class a<K, V> extends p<K, V> {
        final ConcurrentHashMap i;
        l j;

        a(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3);
            this.i = concurrentHashMap;
            a();
        }

        public final boolean hasMoreElements() {
            return this.b != null;
        }

        public final boolean hasNext() {
            return this.b != null;
        }

        public final void remove() {
            l lVar = this.j;
            if (lVar == null) {
                throw new IllegalStateException();
            }
            this.j = null;
            this.i.replaceNode(lVar.b, null, null);
        }
    }

    static abstract class b<K, V, E> implements Collection<E>, Serializable, j$.util.Collection {
        final ConcurrentHashMap a;

        b(ConcurrentHashMap concurrentHashMap) {
            this.a = concurrentHashMap;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final void clear() {
            this.a.clear();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean containsAll(Collection collection) {
            if (collection == this) {
                return true;
            }
            for (E e : collection) {
                if (e == null || !contains(e)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public abstract Iterator iterator();

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return S1.v(j$.time.a.D(this), true);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return R0.l0(S1.v(j$.time.a.D(this), true));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean removeAll(Collection collection) {
            collection.getClass();
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection
        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection.CC.$default$removeIf(this, x0.c(predicate));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean retainAll(java.util.Collection collection) {
            collection.getClass();
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final int size() {
            return this.a.size();
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return S1.v(j$.time.a.D(this), false);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return R0.l0(S1.v(j$.time.a.D(this), false));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final Object[] toArray() {
            long jMappingCount = this.a.mappingCount();
            if (jMappingCount > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i = (int) jMappingCount;
            Object[] objArrCopyOf = new Object[i];
            int i2 = 0;
            Iterator it = iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (i2 == i) {
                    int i3 = ConcurrentHashMap.MAX_ARRAY_SIZE;
                    if (i >= ConcurrentHashMap.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    if (i < 1073741819) {
                        i3 = (i >>> 1) + 1 + i;
                    }
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    i = i3;
                }
                objArrCopyOf[i2] = next;
                i2++;
            }
            return i2 == i ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i2);
        }

        @Override // j$.util.Collection
        public Object[] toArray(z zVar) {
            return toArray((Object[]) zVar.apply(0));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final Object[] toArray(Object[] objArr) {
            long jMappingCount = this.a.mappingCount();
            if (jMappingCount > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i = (int) jMappingCount;
            Object[] objArrCopyOf = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            int length = objArrCopyOf.length;
            int i2 = 0;
            Iterator it = iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (i2 == length) {
                    int i3 = ConcurrentHashMap.MAX_ARRAY_SIZE;
                    if (length >= ConcurrentHashMap.MAX_ARRAY_SIZE) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    if (length < 1073741819) {
                        i3 = (length >>> 1) + 1 + length;
                    }
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    length = i3;
                }
                objArrCopyOf[i2] = next;
                i2++;
            }
            if (objArr != objArrCopyOf || i2 >= length) {
                return i2 == length ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i2);
            }
            objArrCopyOf[i2] = null;
            return objArrCopyOf;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }
    }

    static final class c {
        volatile long value;

        c(long j) {
            this.value = j;
        }
    }

    static final class d<K, V> extends a<K, V> implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        d(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C0206w.b(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            l lVar = this.b;
            if (lVar == null) {
                throw new NoSuchElementException();
            }
            Object obj = lVar.b;
            Object obj2 = lVar.c;
            this.j = lVar;
            a();
            return new k(obj, obj2, this.i);
        }
    }

    static final class e<K, V> extends b<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable, j$.util.Set {
        e(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            return this.a.putVal(entry.getKey(), entry.getValue(), false) == null;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(java.util.Collection collection) {
            java.util.Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = this.a.get(key)) == null || (value = entry.getValue()) == null || (value != obj2 && !value.equals(obj2))) ? false : true;
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.a.table;
            if (lVarArr == null) {
                return;
            }
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(new k(lVarA.b, lVarA.c, this.a));
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C0206w.b(consumer));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final int hashCode() {
            l[] lVarArr = this.a.table;
            int iHashCode = 0;
            if (lVarArr != null) {
                p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
                while (true) {
                    l lVarA = pVar.a();
                    if (lVarA == null) {
                        break;
                    }
                    iHashCode += lVarA.hashCode();
                }
            }
            return iHashCode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            l[] lVarArr = concurrentHashMap.table;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new d(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.a.remove(key, value);
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            long jSumCount = concurrentHashMap.sumCount();
            l[] lVarArr = concurrentHashMap.table;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new f(lVarArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L, concurrentHashMap);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0066h.a(spliterator());
        }
    }

    static final class f<K, V> extends p<K, V> implements Spliterator<Map.Entry<K, V>> {
        final ConcurrentHashMap i;
        long j;

        f(l[] lVarArr, int i, int i2, int i3, long j, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3);
            this.i = concurrentHashMap;
            this.j = j;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l lVarA = a();
            if (lVarA == null) {
                return false;
            }
            consumer.accept(new k(lVarA.b, lVarA.c, this.i));
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.j;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l lVarA = a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(new k(lVarA.b, lVarA.c, this.i));
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.f;
            int i2 = this.g;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            l[] lVarArr = this.a;
            int i4 = this.h;
            this.g = i3;
            long j = this.j >>> 1;
            this.j = j;
            return new f(lVarArr, i4, i3, i2, j, this.i);
        }
    }

    static final class g<K, V> extends l<K, V> {
        final l[] e;

        g(l[] lVarArr) {
            super(-1, null, null, null);
            this.e = lVarArr;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.l
        l a(int i, Object obj) {
            int length;
            l lVarTabAt;
            Object obj2;
            l[] lVarArr = this.e;
            loop0: while (lVarArr != null && (length = lVarArr.length) != 0 && (lVarTabAt = ConcurrentHashMap.tabAt(lVarArr, (length - 1) & i)) != null) {
                do {
                    int i2 = lVarTabAt.a;
                    if (i2 == i && ((obj2 = lVarTabAt.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return lVarTabAt;
                    }
                    if (i2 >= 0) {
                        lVarTabAt = lVarTabAt.d;
                    } else {
                        if (!(lVarTabAt instanceof g)) {
                            return lVarTabAt.a(i, obj);
                        }
                        lVarArr = ((g) lVarTabAt).e;
                    }
                } while (lVarTabAt != null);
            }
            return null;
        }
    }

    static final class h<K, V> extends a<K, V> implements java.util.Iterator<K>, Enumeration<K>, j$.util.Iterator {
        h(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C0206w.b(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public final Object next() {
            l lVar = this.b;
            if (lVar == null) {
                throw new NoSuchElementException();
            }
            Object obj = lVar.b;
            this.j = lVar;
            a();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    public static class i<K, V> extends b<K, V, K> implements Set<K>, Serializable, j$.util.Set {
        i(ConcurrentHashMap concurrentHashMap, Object obj) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.a.table;
            if (lVarArr == null) {
                return;
            }
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.b);
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C0206w.b(consumer));
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public int hashCode() {
            Object it = iterator();
            int iHashCode = 0;
            while (((a) it).hasNext()) {
                iHashCode += ((h) it).next().hashCode();
            }
            return iHashCode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            l[] lVarArr = concurrentHashMap.table;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new h(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            long jSumCount = concurrentHashMap.sumCount();
            l[] lVarArr = concurrentHashMap.table;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new j(lVarArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0066h.a(spliterator());
        }
    }

    static final class j<K, V> extends p<K, V> implements Spliterator<K> {
        long i;

        j(l[] lVarArr, int i, int i2, int i3, long j) {
            super(lVarArr, i, i2, i3);
            this.i = j;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l lVarA = a();
            if (lVarA == null) {
                return false;
            }
            consumer.accept(lVarA.b);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.i;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l lVarA = a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.b);
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.f;
            int i2 = this.g;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            l[] lVarArr = this.a;
            int i4 = this.h;
            this.g = i3;
            long j = this.i >>> 1;
            this.i = j;
            return new j(lVarArr, i4, i3, i2, j);
        }
    }

    static final class k<K, V> implements Map.Entry<K, V>, Map.Entry {
        final Object a;
        Object b;
        final ConcurrentHashMap c;

        k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
            this.a = obj;
            this.b = obj2;
            this.c = concurrentHashMap;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.a) || key.equals(obj2)) && (value == (obj3 = this.b) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public Object setValue(Object obj) {
            obj.getClass();
            Object obj2 = this.b;
            this.b = obj;
            this.c.put(this.a, obj);
            return obj2;
        }

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    static class l<K, V> implements Map.Entry<K, V>, Map.Entry {
        final int a;
        final Object b;
        volatile Object c;
        volatile l d;

        l(int i, Object obj, Object obj2, l lVar) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = lVar;
        }

        l a(int i, Object obj) {
            Object obj2;
            l<K, V> lVar = this;
            do {
                if (lVar.a == i && ((obj2 = lVar.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return lVar;
                }
                lVar = lVar.d;
            } while (lVar != null);
            return null;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.b) || key.equals(obj2)) && (value == (obj3 = this.c) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.b + "=" + this.c;
        }
    }

    static final class m<K, V> extends l<K, V> {
        m() {
            super(-3, null, null, null);
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.l
        l a(int i, Object obj) {
            return null;
        }
    }

    static class n<K, V> extends ReentrantLock implements Serializable {
        n(float f) {
        }
    }

    static final class o<K, V> {
        int a;
        int b;
        l[] c;
        o d;

        o() {
        }
    }

    static class p<K, V> {
        l[] a;
        l b = null;
        o c;
        o d;
        int e;
        int f;
        int g;
        final int h;

        p(l[] lVarArr, int i, int i2, int i3) {
            this.a = lVarArr;
            this.h = i;
            this.e = i2;
            this.f = i2;
            this.g = i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0097 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x005f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final j$.util.concurrent.ConcurrentHashMap.l a() {
            /*
                r6 = this;
                j$.util.concurrent.ConcurrentHashMap$l r0 = r6.b
                r1 = 0
                if (r0 == 0) goto L7
                j$.util.concurrent.ConcurrentHashMap$l r0 = r0.d
            L7:
                if (r0 == 0) goto Lc
                r6.b = r0
                return r0
            Lc:
                int r0 = r6.f
                int r2 = r6.g
                if (r0 >= r2) goto La8
                j$.util.concurrent.ConcurrentHashMap$l[] r0 = r6.a
                if (r0 == 0) goto La8
                int r2 = r0.length
                int r3 = r6.e
                if (r2 <= r3) goto La8
                if (r3 >= 0) goto L1f
                goto La8
            L1f:
                j$.util.concurrent.ConcurrentHashMap$l r4 = j$.util.concurrent.ConcurrentHashMap.tabAt(r0, r3)
                if (r4 == 0) goto L5a
                int r5 = r4.a
                if (r5 >= 0) goto L5a
                boolean r5 = r4 instanceof j$.util.concurrent.ConcurrentHashMap.g
                if (r5 == 0) goto L4f
                j$.util.concurrent.ConcurrentHashMap$g r4 = (j$.util.concurrent.ConcurrentHashMap.g) r4
                j$.util.concurrent.ConcurrentHashMap$l[] r4 = r4.e
                r6.a = r4
                j$.util.concurrent.ConcurrentHashMap$o r4 = r6.d
                if (r4 == 0) goto L3c
                j$.util.concurrent.ConcurrentHashMap$o r5 = r4.d
                r6.d = r5
                goto L41
            L3c:
                j$.util.concurrent.ConcurrentHashMap$o r4 = new j$.util.concurrent.ConcurrentHashMap$o
                r4.<init>()
            L41:
                r4.c = r0
                r4.a = r2
                r4.b = r3
                j$.util.concurrent.ConcurrentHashMap$o r0 = r6.c
                r4.d = r0
                r6.c = r4
                r0 = r1
                goto L7
            L4f:
                boolean r0 = r4 instanceof j$.util.concurrent.ConcurrentHashMap.q
                if (r0 == 0) goto L58
                j$.util.concurrent.ConcurrentHashMap$q r4 = (j$.util.concurrent.ConcurrentHashMap.q) r4
                j$.util.concurrent.ConcurrentHashMap$r r0 = r4.h
                goto L5b
            L58:
                r0 = r1
                goto L5b
            L5a:
                r0 = r4
            L5b:
                j$.util.concurrent.ConcurrentHashMap$o r4 = r6.c
                if (r4 == 0) goto L97
            L5f:
                j$.util.concurrent.ConcurrentHashMap$o r3 = r6.c
                if (r3 == 0) goto L82
                int r4 = r6.e
                int r5 = r3.a
                int r4 = r4 + r5
                r6.e = r4
                if (r4 < r2) goto L82
                int r2 = r3.b
                r6.e = r2
                j$.util.concurrent.ConcurrentHashMap$l[] r2 = r3.c
                r6.a = r2
                r3.c = r1
                j$.util.concurrent.ConcurrentHashMap$o r2 = r3.d
                j$.util.concurrent.ConcurrentHashMap$o r4 = r6.d
                r3.d = r4
                r6.c = r2
                r6.d = r3
                r2 = r5
                goto L5f
            L82:
                if (r3 != 0) goto L7
                int r3 = r6.e
                int r4 = r6.h
                int r3 = r3 + r4
                r6.e = r3
                if (r3 < r2) goto L7
                int r2 = r6.f
                int r2 = r2 + 1
                r6.f = r2
                r6.e = r2
                goto L7
            L97:
                int r4 = r6.h
                int r3 = r3 + r4
                r6.e = r3
                if (r3 < r2) goto L7
                int r2 = r6.f
                int r2 = r2 + 1
                r6.f = r2
                r6.e = r2
                goto L7
            La8:
                r6.b = r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.p.a():j$.util.concurrent.ConcurrentHashMap$l");
        }
    }

    static final class q<K, V> extends l<K, V> {
        private static final Unsafe e;
        private static final long f;
        r g;
        volatile r h;
        volatile Thread i;
        volatile int lockState;

        static {
            try {
                Unsafe unsafeC = j$.util.concurrent.b.c();
                e = unsafeC;
                f = unsafeC.objectFieldOffset(q.class.getDeclaredField("lockState"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        q(r rVar) {
            int iCompareComparables;
            int iJ;
            super(-2, null, null, null);
            this.h = rVar;
            r rVar2 = null;
            while (rVar != null) {
                r rVar3 = (r) rVar.d;
                rVar.g = null;
                rVar.f = null;
                if (rVar2 == null) {
                    rVar.e = null;
                    rVar.i = false;
                } else {
                    Object obj = rVar.b;
                    int i = rVar.a;
                    r rVar4 = rVar2;
                    Class clsComparableClassFor = null;
                    while (true) {
                        Object obj2 = rVar4.b;
                        int i2 = rVar4.a;
                        iJ = i2 > i ? -1 : i2 < i ? 1 : ((clsComparableClassFor == null && (clsComparableClassFor = ConcurrentHashMap.comparableClassFor(obj)) == null) || (iCompareComparables = ConcurrentHashMap.compareComparables(clsComparableClassFor, obj, obj2)) == 0) ? j(obj, obj2) : iCompareComparables;
                        r rVar5 = iJ <= 0 ? rVar4.f : rVar4.g;
                        if (rVar5 == null) {
                            break;
                        } else {
                            rVar4 = rVar5;
                        }
                    }
                    rVar.e = rVar4;
                    if (iJ <= 0) {
                        rVar4.f = rVar;
                    } else {
                        rVar4.g = rVar;
                    }
                    rVar = c(rVar2, rVar);
                }
                rVar2 = rVar;
                rVar = rVar3;
            }
            this.g = rVar2;
        }

        static r b(r rVar, r rVar2) {
            while (rVar2 != null && rVar2 != rVar) {
                r rVar3 = rVar2.e;
                if (rVar3 == null) {
                    rVar2.i = false;
                    return rVar2;
                }
                if (rVar2.i) {
                    rVar2.i = false;
                    return rVar;
                }
                r rVar4 = rVar3.f;
                r rVar5 = null;
                if (rVar4 == rVar2) {
                    rVar4 = rVar3.g;
                    if (rVar4 != null && rVar4.i) {
                        rVar4.i = false;
                        rVar3.i = true;
                        rVar = h(rVar, rVar3);
                        rVar3 = rVar2.e;
                        rVar4 = rVar3 == null ? null : rVar3.g;
                    }
                    if (rVar4 == null) {
                        rVar2 = rVar3;
                    } else {
                        r rVar6 = rVar4.f;
                        r rVar7 = rVar4.g;
                        if ((rVar7 == null || !rVar7.i) && (rVar6 == null || !rVar6.i)) {
                            rVar4.i = true;
                            rVar2 = rVar3;
                        } else {
                            if (rVar7 == null || !rVar7.i) {
                                if (rVar6 != null) {
                                    rVar6.i = false;
                                }
                                rVar4.i = true;
                                rVar = i(rVar, rVar4);
                                rVar3 = rVar2.e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.g;
                                }
                            } else {
                                rVar5 = rVar4;
                            }
                            if (rVar5 != null) {
                                rVar5.i = rVar3 == null ? false : rVar3.i;
                                r rVar8 = rVar5.g;
                                if (rVar8 != null) {
                                    rVar8.i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.i = false;
                                rVar = h(rVar, rVar3);
                            }
                            rVar2 = rVar;
                            rVar = rVar2;
                        }
                    }
                } else {
                    if (rVar4 != null && rVar4.i) {
                        rVar4.i = false;
                        rVar3.i = true;
                        rVar = i(rVar, rVar3);
                        rVar3 = rVar2.e;
                        rVar4 = rVar3 == null ? null : rVar3.f;
                    }
                    if (rVar4 == null) {
                        rVar2 = rVar3;
                    } else {
                        r rVar9 = rVar4.f;
                        r rVar10 = rVar4.g;
                        if ((rVar9 == null || !rVar9.i) && (rVar10 == null || !rVar10.i)) {
                            rVar4.i = true;
                            rVar2 = rVar3;
                        } else {
                            if (rVar9 == null || !rVar9.i) {
                                if (rVar10 != null) {
                                    rVar10.i = false;
                                }
                                rVar4.i = true;
                                rVar = h(rVar, rVar4);
                                rVar3 = rVar2.e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f;
                                }
                            } else {
                                rVar5 = rVar4;
                            }
                            if (rVar5 != null) {
                                rVar5.i = rVar3 == null ? false : rVar3.i;
                                r rVar11 = rVar5.f;
                                if (rVar11 != null) {
                                    rVar11.i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.i = false;
                                rVar = i(rVar, rVar3);
                            }
                            rVar2 = rVar;
                            rVar = rVar2;
                        }
                    }
                }
            }
            return rVar;
        }

        static r c(r rVar, r rVar2) {
            r rVar3;
            rVar2.i = true;
            while (true) {
                r rVar4 = rVar2.e;
                if (rVar4 == null) {
                    rVar2.i = false;
                    return rVar2;
                }
                if (!rVar4.i || (rVar3 = rVar4.e) == null) {
                    break;
                }
                r rVar5 = rVar3.f;
                if (rVar4 == rVar5) {
                    rVar5 = rVar3.g;
                    if (rVar5 == null || !rVar5.i) {
                        if (rVar2 == rVar4.g) {
                            rVar = h(rVar, rVar4);
                            r rVar6 = rVar4.e;
                            rVar3 = rVar6 == null ? null : rVar6.e;
                            rVar4 = rVar6;
                            rVar2 = rVar4;
                        }
                        if (rVar4 != null) {
                            rVar4.i = false;
                            if (rVar3 != null) {
                                rVar3.i = true;
                                rVar = i(rVar, rVar3);
                            }
                        }
                    } else {
                        rVar5.i = false;
                        rVar4.i = false;
                        rVar3.i = true;
                        rVar2 = rVar3;
                    }
                } else if (rVar5 == null || !rVar5.i) {
                    if (rVar2 == rVar4.f) {
                        rVar = i(rVar, rVar4);
                        r rVar7 = rVar4.e;
                        rVar3 = rVar7 == null ? null : rVar7.e;
                        rVar4 = rVar7;
                        rVar2 = rVar4;
                    }
                    if (rVar4 != null) {
                        rVar4.i = false;
                        if (rVar3 != null) {
                            rVar3.i = true;
                            rVar = h(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.i = false;
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar2 = rVar3;
                }
            }
            return rVar;
        }

        private final void d() {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & (-3)) == 0) {
                    if (e.compareAndSwapInt(this, f, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (e.compareAndSwapInt(this, f, i, i | 2)) {
                        z = true;
                        this.i = Thread.currentThread();
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.i = null;
            }
        }

        private final void e() {
            if (e.compareAndSwapInt(this, f, 0, 1)) {
                return;
            }
            d();
        }

        static r h(r rVar, r rVar2) {
            r rVar3 = rVar2.g;
            if (rVar3 != null) {
                r rVar4 = rVar3.f;
                rVar2.g = rVar4;
                if (rVar4 != null) {
                    rVar4.e = rVar2;
                }
                r rVar5 = rVar2.e;
                rVar3.e = rVar5;
                if (rVar5 == null) {
                    rVar3.i = false;
                    rVar = rVar3;
                } else if (rVar5.f == rVar2) {
                    rVar5.f = rVar3;
                } else {
                    rVar5.g = rVar3;
                }
                rVar3.f = rVar2;
                rVar2.e = rVar3;
            }
            return rVar;
        }

        static r i(r rVar, r rVar2) {
            r rVar3 = rVar2.f;
            if (rVar3 != null) {
                r rVar4 = rVar3.g;
                rVar2.f = rVar4;
                if (rVar4 != null) {
                    rVar4.e = rVar2;
                }
                r rVar5 = rVar2.e;
                rVar3.e = rVar5;
                if (rVar5 == null) {
                    rVar3.i = false;
                    rVar = rVar3;
                } else if (rVar5.g == rVar2) {
                    rVar5.g = rVar3;
                } else {
                    rVar5.f = rVar3;
                }
                rVar3.g = rVar2;
                rVar2.e = rVar3;
            }
            return rVar;
        }

        static int j(Object obj, Object obj2) {
            int iCompareTo;
            return (obj == null || obj2 == null || (iCompareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : iCompareTo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
        
            return r0;
         */
        @Override // j$.util.concurrent.ConcurrentHashMap.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final j$.util.concurrent.ConcurrentHashMap.l a(int r12, java.lang.Object r13) {
            /*
                r11 = this;
                j$.util.concurrent.ConcurrentHashMap$r r0 = r11.h
            L2:
                r1 = 0
                if (r0 == 0) goto L5a
                int r6 = r11.lockState
                r2 = r6 & 3
                if (r2 == 0) goto L1f
                int r1 = r0.a
                if (r1 != r12) goto L1c
                java.lang.Object r1 = r0.b
                if (r1 == r13) goto L1b
                if (r1 == 0) goto L1c
                boolean r1 = r13.equals(r1)
                if (r1 == 0) goto L1c
            L1b:
                return r0
            L1c:
                j$.util.concurrent.ConcurrentHashMap$l r0 = r0.d
                goto L2
            L1f:
                sun.misc.Unsafe r8 = j$.util.concurrent.ConcurrentHashMap.q.e
                long r9 = j$.util.concurrent.ConcurrentHashMap.q.f
                int r7 = r6 + 4
                r2 = r8
                r3 = r11
                r4 = r9
                boolean r2 = r2.compareAndSwapInt(r3, r4, r6, r7)
                if (r2 == 0) goto L2
                r0 = 6
                r2 = -4
                j$.util.concurrent.ConcurrentHashMap$r r3 = r11.g     // Catch: java.lang.Throwable -> L47
                if (r3 != 0) goto L35
                goto L39
            L35:
                j$.util.concurrent.ConcurrentHashMap$r r1 = r3.b(r12, r13, r1)     // Catch: java.lang.Throwable -> L47
            L39:
                int r12 = j$.util.concurrent.b.a(r8, r11, r9, r2)
                if (r12 != r0) goto L46
                java.lang.Thread r12 = r11.i
                if (r12 == 0) goto L46
                java.util.concurrent.locks.LockSupport.unpark(r12)
            L46:
                return r1
            L47:
                r12 = move-exception
                sun.misc.Unsafe r13 = j$.util.concurrent.ConcurrentHashMap.q.e
                long r3 = j$.util.concurrent.ConcurrentHashMap.q.f
                int r13 = j$.util.concurrent.b.a(r13, r11, r3, r2)
                if (r13 != r0) goto L59
                java.lang.Thread r13 = r11.i
                if (r13 == 0) goto L59
                java.util.concurrent.locks.LockSupport.unpark(r13)
            L59:
                throw r12
            L5a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.a(int, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$l");
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        
            return r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
        
            return r10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final j$.util.concurrent.ConcurrentHashMap.r f(int r16, java.lang.Object r17, java.lang.Object r18) {
            /*
                r15 = this;
                r1 = r15
                r0 = r16
                r4 = r17
                j$.util.concurrent.ConcurrentHashMap$r r2 = r1.g
                r8 = 0
                r9 = 0
                r10 = r2
                r2 = r8
                r3 = 0
            Lc:
                if (r10 != 0) goto L22
                j$.util.concurrent.ConcurrentHashMap$r r9 = new j$.util.concurrent.ConcurrentHashMap$r
                r6 = 0
                r7 = 0
                r2 = r9
                r3 = r16
                r4 = r17
                r5 = r18
                r2.<init>(r3, r4, r5, r6, r7)
                r1.g = r9
                r1.h = r9
                goto La3
            L22:
                int r5 = r10.a
                r11 = 1
                if (r5 <= r0) goto L2a
                r5 = -1
                r12 = -1
                goto L69
            L2a:
                if (r5 >= r0) goto L2e
                r12 = 1
                goto L69
            L2e:
                java.lang.Object r5 = r10.b
                if (r5 == r4) goto Lab
                if (r5 == 0) goto L3c
                boolean r6 = r4.equals(r5)
                if (r6 == 0) goto L3c
                goto Lab
            L3c:
                if (r2 != 0) goto L44
                java.lang.Class r2 = j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r17)
                if (r2 == 0) goto L4a
            L44:
                int r6 = j$.util.concurrent.ConcurrentHashMap.compareComparables(r2, r4, r5)
                if (r6 != 0) goto L68
            L4a:
                if (r3 != 0) goto L62
                j$.util.concurrent.ConcurrentHashMap$r r3 = r10.f
                if (r3 == 0) goto L56
                j$.util.concurrent.ConcurrentHashMap$r r3 = r3.b(r0, r4, r2)
                if (r3 != 0) goto L60
            L56:
                j$.util.concurrent.ConcurrentHashMap$r r3 = r10.g
                if (r3 == 0) goto L61
                j$.util.concurrent.ConcurrentHashMap$r r3 = r3.b(r0, r4, r2)
                if (r3 == 0) goto L61
            L60:
                return r3
            L61:
                r3 = 1
            L62:
                int r5 = j(r4, r5)
                r12 = r5
                goto L69
            L68:
                r12 = r6
            L69:
                if (r12 > 0) goto L6e
                j$.util.concurrent.ConcurrentHashMap$r r5 = r10.f
                goto L70
            L6e:
                j$.util.concurrent.ConcurrentHashMap$r r5 = r10.g
            L70:
                if (r5 != 0) goto La8
                j$.util.concurrent.ConcurrentHashMap$r r13 = r1.h
                j$.util.concurrent.ConcurrentHashMap$r r14 = new j$.util.concurrent.ConcurrentHashMap$r
                r2 = r14
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r13
                r7 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                r1.h = r14
                if (r13 == 0) goto L88
                r13.h = r14
            L88:
                if (r12 > 0) goto L8d
                r10.f = r14
                goto L8f
            L8d:
                r10.g = r14
            L8f:
                boolean r0 = r10.i
                if (r0 != 0) goto L96
                r14.i = r11
                goto La3
            L96:
                r15.e()
                j$.util.concurrent.ConcurrentHashMap$r r0 = r1.g     // Catch: java.lang.Throwable -> La4
                j$.util.concurrent.ConcurrentHashMap$r r0 = c(r0, r14)     // Catch: java.lang.Throwable -> La4
                r1.g = r0     // Catch: java.lang.Throwable -> La4
                r1.lockState = r9
            La3:
                return r8
            La4:
                r0 = move-exception
                r1.lockState = r9
                throw r0
            La8:
                r10 = r5
                goto Lc
            Lab:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.f(int, java.lang.Object, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$r");
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x008b A[PHI: r0
          0x008b: PHI (r0v4 j$.util.concurrent.ConcurrentHashMap$r) = (r0v3 j$.util.concurrent.ConcurrentHashMap$r), (r0v12 j$.util.concurrent.ConcurrentHashMap$r) binds: [B:53:0x0087, B:49:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final boolean g(j$.util.concurrent.ConcurrentHashMap.r r11) {
            /*
                Method dump skipped, instructions count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.q.g(j$.util.concurrent.ConcurrentHashMap$r):boolean");
        }
    }

    static final class r<K, V> extends l<K, V> {
        r e;
        r f;
        r g;
        r h;
        boolean i;

        r(int i, Object obj, Object obj2, l lVar, r rVar) {
            super(i, obj, obj2, lVar);
            this.e = rVar;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.l
        l a(int i, Object obj) {
            return b(i, obj, null);
        }

        final r b(int i, Object obj, Class cls) {
            int iCompareComparables;
            if (obj == null) {
                return null;
            }
            r<K, V> rVar = this;
            do {
                r<K, V> rVar2 = rVar.f;
                r<K, V> rVar3 = rVar.g;
                int i2 = rVar.a;
                if (i2 <= i) {
                    if (i2 >= i) {
                        Object obj2 = rVar.b;
                        if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                            return rVar;
                        }
                        if (rVar2 != null) {
                            if (rVar3 != null) {
                                if ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (iCompareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) {
                                    r rVarB = rVar3.b(i, obj, cls);
                                    if (rVarB != null) {
                                        return rVarB;
                                    }
                                } else if (iCompareComparables < 0) {
                                }
                            }
                            rVar = rVar2;
                        }
                    }
                    rVar = rVar3;
                } else {
                    rVar = rVar2;
                }
            } while (rVar != null);
            return null;
        }
    }

    static final class s<K, V> extends a<K, V> implements java.util.Iterator<V>, Enumeration<V>, j$.util.Iterator {
        s(l[] lVarArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(lVarArr, i, i2, i3, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C0206w.b(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public final Object next() {
            l lVar = this.b;
            if (lVar == null) {
                throw new NoSuchElementException();
            }
            Object obj = lVar.c;
            this.j = lVar;
            a();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    static final class t<K, V> extends p<K, V> implements Spliterator<V> {
        long i;

        t(l[] lVarArr, int i, int i2, int i3, long j) {
            super(lVarArr, i, i2, i3);
            this.i = j;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            l lVarA = a();
            if (lVarA == null) {
                return false;
            }
            consumer.accept(lVarA.c);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4352;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.i;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                l lVarA = a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.c);
                }
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.f;
            int i2 = this.g;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            l[] lVarArr = this.a;
            int i4 = this.h;
            this.g = i3;
            long j = this.i >>> 1;
            this.i = j;
            return new t(lVarArr, i4, i3, i2, j);
        }
    }

    static final class u<K, V> extends b<K, V, V> implements java.util.Collection<V>, Serializable, j$.util.Collection {
        u(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            l[] lVarArr = this.a.table;
            if (lVarArr == null) {
                return;
            }
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    return;
                } else {
                    consumer.accept(lVarA.c);
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(C0206w.b(consumer));
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.b, java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            l[] lVarArr = concurrentHashMap.table;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new s(lVarArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection, java.util.Set, j$.util.Set
        public final boolean remove(Object obj) {
            a aVar;
            if (obj == null) {
                return false;
            }
            Object it = iterator();
            do {
                aVar = (a) it;
                if (!aVar.hasNext()) {
                    return false;
                }
            } while (!obj.equals(((s) it).next()));
            aVar.remove();
            return true;
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.a;
            long jSumCount = concurrentHashMap.sumCount();
            l[] lVarArr = concurrentHashMap.table;
            int length = lVarArr == null ? 0 : lVarArr.length;
            return new t(lVarArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0066h.a(spliterator());
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            Unsafe unsafeC = j$.util.concurrent.b.c();
            U = unsafeC;
            SIZECTL = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            BASECOUNT = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            CELLSBUSY = unsafeC.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            CELLVALUE = unsafeC.objectFieldOffset(c.class.getDeclaredField("value"));
            ABASE = unsafeC.arrayBaseOffset(l[].class);
            int iArrayIndexScale = unsafeC.arrayIndexScale(l[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i2 >= 536870912 ? MAXIMUM_CAPACITY : tableSizeFor(i2 + (i2 >>> 1) + 1);
    }

    public ConcurrentHashMap(int i2, float f2) {
        this(i2, f2, 1);
    }

    public ConcurrentHashMap(int i2, float f2, int i3) {
        if (f2 <= 0.0f || i2 < 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        double d2 = (i2 < i3 ? i3 : i2) / f2;
        Double.isNaN(d2);
        long j2 = (long) (d2 + 1.0d);
        this.sizeCtl = j2 >= 1073741824 ? MAXIMUM_CAPACITY : tableSizeFor((int) j2);
    }

    public ConcurrentHashMap(java.util.Map map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addCount(long r12, int r14) {
        /*
            r11 = this;
            j$.util.concurrent.ConcurrentHashMap$c[] r0 = r11.counterCells
            if (r0 != 0) goto L14
            sun.misc.Unsafe r1 = j$.util.concurrent.ConcurrentHashMap.U
            long r3 = j$.util.concurrent.ConcurrentHashMap.BASECOUNT
            long r5 = r11.baseCount
            long r9 = r5 + r12
            r2 = r11
            r7 = r9
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 != 0) goto L3b
        L14:
            r1 = 1
            if (r0 == 0) goto L96
            int r2 = r0.length
            int r2 = r2 - r1
            if (r2 < 0) goto L96
            int r3 = j$.util.concurrent.ThreadLocalRandom.b()
            r2 = r2 & r3
            r4 = r0[r2]
            if (r4 == 0) goto L96
            sun.misc.Unsafe r3 = j$.util.concurrent.ConcurrentHashMap.U
            long r5 = j$.util.concurrent.ConcurrentHashMap.CELLVALUE
            long r7 = r4.value
            long r9 = r7 + r12
            boolean r0 = r3.compareAndSwapLong(r4, r5, r7, r9)
            if (r0 != 0) goto L34
            r1 = r0
            goto L96
        L34:
            if (r14 > r1) goto L37
            return
        L37:
            long r9 = r11.sumCount()
        L3b:
            if (r14 < 0) goto L95
        L3d:
            int r4 = r11.sizeCtl
            long r12 = (long) r4
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L95
            j$.util.concurrent.ConcurrentHashMap$l[] r12 = r11.table
            if (r12 == 0) goto L95
            int r13 = r12.length
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r14) goto L95
            int r13 = resizeStamp(r13)
            if (r4 >= 0) goto L7c
            int r14 = j$.util.concurrent.ConcurrentHashMap.RESIZE_STAMP_SHIFT
            int r14 = r4 >>> r14
            if (r14 != r13) goto L95
            int r14 = r13 + 1
            if (r4 == r14) goto L95
            int r14 = j$.util.concurrent.ConcurrentHashMap.MAX_RESIZERS
            int r13 = r13 + r14
            if (r4 == r13) goto L95
            j$.util.concurrent.ConcurrentHashMap$l[] r13 = r11.nextTable
            if (r13 == 0) goto L95
            int r14 = r11.transferIndex
            if (r14 > 0) goto L6b
            goto L95
        L6b:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.U
            long r2 = j$.util.concurrent.ConcurrentHashMap.SIZECTL
            int r5 = r4 + 1
            r1 = r11
            boolean r14 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r14 == 0) goto L90
            r11.transfer(r12, r13)
            goto L90
        L7c:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.U
            long r2 = j$.util.concurrent.ConcurrentHashMap.SIZECTL
            int r14 = j$.util.concurrent.ConcurrentHashMap.RESIZE_STAMP_SHIFT
            int r13 = r13 << r14
            int r5 = r13 + 2
            r1 = r11
            boolean r13 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r13 == 0) goto L90
            r13 = 0
            r11.transfer(r12, r13)
        L90:
            long r9 = r11.sumCount()
            goto L3d
        L95:
            return
        L96:
            r11.fullAddCount(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    static final boolean casTabAt(l[] lVarArr, int i2, l lVar, l lVar2) {
        return U.compareAndSwapObject(lVarArr, ABASE + (i2 << ASHIFT), lVar, lVar2);
    }

    static Class comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int compareComparables(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        if (r24.counterCells != r7) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009d, code lost:
    
        r1 = new j$.util.concurrent.ConcurrentHashMap.c[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        if (r2 >= r8) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        r24.counterCells = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void fullAddCount(long r25, boolean r27) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.fullAddCount(long, boolean):void");
    }

    private final l[] initTable() {
        while (true) {
            l[] lVarArr = this.table;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else if (U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                try {
                    l[] lVarArr2 = this.table;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i3 = i2 > 0 ? i2 : 16;
                        l[] lVarArr3 = new l[i3];
                        this.table = lVarArr3;
                        i2 = i3 - (i3 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    this.sizeCtl = i2;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i2;
                    throw th;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j2;
        int iTableSizeFor;
        boolean z;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j3 = 0;
        long j4 = 0;
        l lVar = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j2 = 1;
            if (object == null || object2 == null) {
                break;
            }
            j4++;
            lVar = new l(spread(object.hashCode()), object, object2, lVar);
        }
        if (j4 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j4 >= 536870912) {
            iTableSizeFor = MAXIMUM_CAPACITY;
        } else {
            int i2 = (int) j4;
            iTableSizeFor = tableSizeFor(i2 + (i2 >>> 1) + 1);
        }
        l[] lVarArr = new l[iTableSizeFor];
        int i3 = iTableSizeFor - 1;
        while (lVar != null) {
            l lVar2 = lVar.d;
            int i4 = lVar.a;
            int i5 = i4 & i3;
            l lVarTabAt = tabAt(lVarArr, i5);
            if (lVarTabAt == null) {
                z = true;
            } else {
                Object obj2 = lVar.b;
                if (lVarTabAt.a >= 0) {
                    int i6 = 0;
                    for (l lVar3 = lVarTabAt; lVar3 != null; lVar3 = lVar3.d) {
                        if (lVar3.a == i4 && ((obj = lVar3.b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        }
                        i6++;
                    }
                    z = true;
                    if (z && i6 >= 8) {
                        j3++;
                        lVar.d = lVarTabAt;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            long j5 = j3;
                            r rVar3 = new r(lVar4.a, lVar4.b, lVar4.c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.d = rVar3;
                            }
                            lVar4 = lVar4.d;
                            rVar2 = rVar3;
                            j3 = j5;
                        }
                        setTabAt(lVarArr, i5, new q(rVar));
                    }
                } else if (((q) lVarTabAt).f(i4, obj2, lVar.c) == null) {
                    j3 += j2;
                }
                z = false;
            }
            if (z) {
                j3++;
                lVar.d = lVarTabAt;
                setTabAt(lVarArr, i5, lVar);
            }
            j2 = 1;
            lVar = lVar2;
        }
        this.table = lVarArr;
        this.sizeCtl = iTableSizeFor - (iTableSizeFor >>> 2);
        this.baseCount = j3;
    }

    static final int resizeStamp(int i2) {
        return Integer.numberOfLeadingZeros(i2) | (1 << (RESIZE_STAMP_BITS - 1));
    }

    static final void setTabAt(l[] lVarArr, int i2, l lVar) {
        U.putObjectVolatile(lVarArr, (i2 << ASHIFT) + ABASE, lVar);
    }

    static final int spread(int i2) {
        return (i2 ^ (i2 >>> 16)) & Integer.MAX_VALUE;
    }

    static final l tabAt(l[] lVarArr, int i2) {
        return (l) U.getObjectVolatile(lVarArr, (i2 << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i2) {
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        if (i8 < 0) {
            return 1;
        }
        return i8 >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : 1 + i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r12v12, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r4v0, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r5v17, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    /* JADX WARN: Type inference failed for: r5v22, types: [j$.util.concurrent.ConcurrentHashMap$l] */
    private final void transfer(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        int i2;
        int i3;
        g gVar;
        ConcurrentHashMap<K, V> concurrentHashMap;
        int i4;
        int i5;
        r lVar;
        int i6;
        ConcurrentHashMap<K, V> concurrentHashMap2 = this;
        l[] lVarArr4 = lVarArr;
        int length = lVarArr4.length;
        int i7 = NCPU;
        int i8 = i7 > 1 ? (length >>> 3) / i7 : length;
        int i9 = i8 < 16 ? 16 : i8;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr5 = new l[length << 1];
                concurrentHashMap2.nextTable = lVarArr5;
                concurrentHashMap2.transferIndex = length;
                lVarArr3 = lVarArr5;
            } catch (Throwable unused) {
                concurrentHashMap2.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar2 = new g(lVarArr3);
        int i10 = 0;
        int i11 = 0;
        boolean zCasTabAt = true;
        boolean z = false;
        while (true) {
            if (zCasTabAt) {
                int i12 = i11 - 1;
                if (i12 >= i10 || z) {
                    i10 = i10;
                    i11 = i12;
                    zCasTabAt = false;
                } else {
                    int i13 = concurrentHashMap2.transferIndex;
                    if (i13 <= 0) {
                        i11 = -1;
                    } else {
                        Unsafe unsafe = U;
                        long j2 = TRANSFERINDEX;
                        int i14 = i13 > i9 ? i13 - i9 : 0;
                        int i15 = i10;
                        if (unsafe.compareAndSwapInt(this, j2, i13, i14)) {
                            i11 = i13 - 1;
                            i10 = i14;
                        } else {
                            i10 = i15;
                            i11 = i12;
                        }
                    }
                    zCasTabAt = false;
                }
            } else {
                int i16 = i10;
                r lVar2 = null;
                if (i11 < 0 || i11 >= length || (i5 = i11 + length) >= length2) {
                    i2 = i9;
                    i3 = length2;
                    gVar = gVar2;
                    concurrentHashMap = this;
                    if (z) {
                        concurrentHashMap.nextTable = null;
                        concurrentHashMap.table = lVarArr3;
                        concurrentHashMap.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    Unsafe unsafe2 = U;
                    long j3 = SIZECTL;
                    int i17 = concurrentHashMap.sizeCtl;
                    i4 = i11;
                    if (!unsafe2.compareAndSwapInt(this, j3, i17, i17 - 1)) {
                        i11 = i4;
                    } else {
                        if (i17 - 2 != (resizeStamp(length) << RESIZE_STAMP_SHIFT)) {
                            return;
                        }
                        i11 = length;
                        zCasTabAt = true;
                        z = true;
                    }
                    gVar2 = gVar;
                    concurrentHashMap2 = concurrentHashMap;
                    i10 = i16;
                    i9 = i2;
                    length2 = i3;
                } else {
                    ?? TabAt = tabAt(lVarArr4, i11);
                    if (TabAt == 0) {
                        zCasTabAt = casTabAt(lVarArr4, i11, null, gVar2);
                        concurrentHashMap = concurrentHashMap2;
                        i2 = i9;
                        i3 = length2;
                        gVar = gVar2;
                    } else {
                        int i18 = TabAt.a;
                        if (i18 == -1) {
                            concurrentHashMap = concurrentHashMap2;
                            i2 = i9;
                            i3 = length2;
                            gVar = gVar2;
                            zCasTabAt = true;
                        } else {
                            synchronized (TabAt) {
                                if (tabAt(lVarArr4, i11) == TabAt) {
                                    if (i18 >= 0) {
                                        int i19 = i18 & length;
                                        r rVar = TabAt;
                                        for (r rVar2 = TabAt.d; rVar2 != null; rVar2 = rVar2.d) {
                                            int i20 = rVar2.a & length;
                                            if (i20 != i19) {
                                                rVar = rVar2;
                                                i19 = i20;
                                            }
                                        }
                                        if (i19 == 0) {
                                            lVar = null;
                                            lVar2 = rVar;
                                        } else {
                                            lVar = rVar;
                                        }
                                        l lVar3 = TabAt;
                                        while (lVar3 != rVar) {
                                            int i21 = lVar3.a;
                                            Object obj = lVar3.b;
                                            int i22 = i9;
                                            Object obj2 = lVar3.c;
                                            if ((i21 & length) == 0) {
                                                i6 = length2;
                                                lVar2 = new l(i21, obj, obj2, lVar2);
                                            } else {
                                                i6 = length2;
                                                lVar = new l(i21, obj, obj2, lVar);
                                            }
                                            lVar3 = lVar3.d;
                                            i9 = i22;
                                            length2 = i6;
                                        }
                                        i2 = i9;
                                        i3 = length2;
                                        setTabAt(lVarArr3, i11, lVar2);
                                        setTabAt(lVarArr3, i5, lVar);
                                        setTabAt(lVarArr4, i11, gVar2);
                                        gVar = gVar2;
                                    } else {
                                        i2 = i9;
                                        i3 = length2;
                                        if (TabAt instanceof q) {
                                            q qVar = (q) TabAt;
                                            r rVar3 = null;
                                            r rVar4 = null;
                                            l lVar4 = qVar.h;
                                            int i23 = 0;
                                            int i24 = 0;
                                            r rVar5 = null;
                                            while (lVar4 != null) {
                                                q qVar2 = qVar;
                                                int i25 = lVar4.a;
                                                g gVar3 = gVar2;
                                                r rVar6 = new r(i25, lVar4.b, lVar4.c, null, null);
                                                if ((i25 & length) == 0) {
                                                    rVar6.h = rVar4;
                                                    if (rVar4 == null) {
                                                        lVar2 = rVar6;
                                                    } else {
                                                        rVar4.d = rVar6;
                                                    }
                                                    i23++;
                                                    rVar4 = rVar6;
                                                } else {
                                                    rVar6.h = rVar3;
                                                    if (rVar3 == null) {
                                                        rVar5 = rVar6;
                                                    } else {
                                                        rVar3.d = rVar6;
                                                    }
                                                    i24++;
                                                    rVar3 = rVar6;
                                                }
                                                lVar4 = lVar4.d;
                                                qVar = qVar2;
                                                gVar2 = gVar3;
                                            }
                                            q qVar3 = qVar;
                                            g gVar4 = gVar2;
                                            l lVarUntreeify = i23 <= 6 ? untreeify(lVar2) : i24 != 0 ? new q(lVar2) : qVar3;
                                            l lVarUntreeify2 = i24 <= 6 ? untreeify(rVar5) : i23 != 0 ? new q(rVar5) : qVar3;
                                            setTabAt(lVarArr3, i11, lVarUntreeify);
                                            setTabAt(lVarArr3, i5, lVarUntreeify2);
                                            lVarArr4 = lVarArr;
                                            gVar = gVar4;
                                            setTabAt(lVarArr4, i11, gVar);
                                        }
                                    }
                                    zCasTabAt = true;
                                } else {
                                    i2 = i9;
                                    i3 = length2;
                                }
                                gVar = gVar2;
                            }
                            concurrentHashMap = this;
                            i4 = i11;
                            i11 = i4;
                        }
                    }
                    gVar2 = gVar;
                    concurrentHashMap2 = concurrentHashMap;
                    i10 = i16;
                    i9 = i2;
                    length2 = i3;
                }
            }
        }
    }

    private final void treeifyBin(l[] lVarArr, int i2) {
        if (lVarArr != null) {
            int length = lVarArr.length;
            if (length < 64) {
                tryPresize(length << 1);
                return;
            }
            l lVarTabAt = tabAt(lVarArr, i2);
            if (lVarTabAt == null || lVarTabAt.a < 0) {
                return;
            }
            synchronized (lVarTabAt) {
                if (tabAt(lVarArr, i2) == lVarTabAt) {
                    r rVar = null;
                    l lVar = lVarTabAt;
                    r rVar2 = null;
                    while (lVar != null) {
                        r rVar3 = new r(lVar.a, lVar.b, lVar.c, null, null);
                        rVar3.h = rVar2;
                        if (rVar2 == null) {
                            rVar = rVar3;
                        } else {
                            rVar2.d = rVar3;
                        }
                        lVar = lVar.d;
                        rVar2 = rVar3;
                    }
                    setTabAt(lVarArr, i2, new q(rVar));
                }
            }
        }
    }

    private final void tryPresize(int i2) {
        int length;
        l[] lVarArr;
        int iTableSizeFor = i2 >= 536870912 ? MAXIMUM_CAPACITY : tableSizeFor(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.sizeCtl;
            if (i3 < 0) {
                return;
            }
            l[] lVarArr2 = this.table;
            if (lVarArr2 == null || (length = lVarArr2.length) == 0) {
                int i4 = i3 > iTableSizeFor ? i3 : iTableSizeFor;
                if (U.compareAndSwapInt(this, SIZECTL, i3, -1)) {
                    try {
                        if (this.table == lVarArr2) {
                            this.table = new l[i4];
                            i3 = i4 - (i4 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i3;
                    }
                } else {
                    continue;
                }
            } else {
                if (iTableSizeFor <= i3 || length >= MAXIMUM_CAPACITY) {
                    return;
                }
                if (lVarArr2 == this.table) {
                    int iResizeStamp = resizeStamp(length);
                    if (i3 < 0) {
                        if ((i3 >>> RESIZE_STAMP_SHIFT) != iResizeStamp || i3 == iResizeStamp + 1 || i3 == iResizeStamp + MAX_RESIZERS || (lVarArr = this.nextTable) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (U.compareAndSwapInt(this, SIZECTL, i3, i3 + 1)) {
                            transfer(lVarArr2, lVarArr);
                        }
                    } else if (U.compareAndSwapInt(this, SIZECTL, i3, (iResizeStamp << RESIZE_STAMP_SHIFT) + 2)) {
                        transfer(lVarArr2, null);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    static l untreeify(l lVar) {
        l lVar2 = null;
        l lVar3 = null;
        while (lVar != null) {
            l lVar4 = new l(lVar.a, lVar.b, lVar.c, null);
            if (lVar3 == null) {
                lVar2 = lVar4;
            } else {
                lVar3.d = lVar4;
            }
            lVar = lVar.d;
            lVar3 = lVar4;
        }
        return lVar2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i2 = 1;
        int i3 = 0;
        while (i2 < 16) {
            i3++;
            i2 <<= 1;
        }
        int i4 = 32 - i3;
        int i5 = i2 - 1;
        n[] nVarArr = new n[16];
        for (int i6 = 0; i6 < 16; i6++) {
            nVarArr[i6] = new n(LOAD_FACTOR);
        }
        objectOutputStream.putFields().put("segments", nVarArr);
        objectOutputStream.putFields().put("segmentShift", i4);
        objectOutputStream.putFields().put("segmentMask", i5);
        objectOutputStream.writeFields();
        l[] lVarArr = this.table;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                objectOutputStream.writeObject(lVarA.b);
                objectOutputStream.writeObject(lVarA.c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void clear() {
        l lVarTabAt;
        l[] lVarArrHelpTransfer = this.table;
        long j2 = 0;
        loop0: while (true) {
            int i2 = 0;
            while (lVarArrHelpTransfer != null && i2 < lVarArrHelpTransfer.length) {
                lVarTabAt = tabAt(lVarArrHelpTransfer, i2);
                if (lVarTabAt == null) {
                    i2++;
                } else {
                    int i3 = lVarTabAt.a;
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (lVarTabAt) {
                        if (tabAt(lVarArrHelpTransfer, i2) == lVarTabAt) {
                            for (l lVar = i3 >= 0 ? lVarTabAt : lVarTabAt instanceof q ? ((q) lVarTabAt).h : null; lVar != null; lVar = lVar.d) {
                                j2--;
                            }
                            setTabAt(lVarArrHelpTransfer, i2, null);
                            i2++;
                        }
                    }
                }
            }
            lVarArrHelpTransfer = helpTransfer(lVarArrHelpTransfer, lVarTabAt);
        }
        if (j2 != 0) {
            addCount(j2, -1);
        }
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object compute(Object obj, BiFunction biFunction) {
        int i2;
        l lVar;
        Object objApply;
        int i3;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        l[] lVarArrInitTable = this.table;
        int i4 = 0;
        Object obj3 = null;
        int i5 = 0;
        while (true) {
            if (lVarArrInitTable != null) {
                int length = lVarArrInitTable.length;
                if (length != 0) {
                    int i6 = (length - 1) & iSpread;
                    l lVarTabAt = tabAt(lVarArrInitTable, i6);
                    int i7 = 1;
                    if (lVarTabAt == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (casTabAt(lVarArrInitTable, i6, null, mVar)) {
                                try {
                                    Object objApply2 = biFunction.apply(obj, null);
                                    if (objApply2 != null) {
                                        lVar = new l(iSpread, obj, objApply2, null);
                                        i2 = 1;
                                    } else {
                                        i2 = i4;
                                        lVar = null;
                                    }
                                    setTabAt(lVarArrInitTable, i6, lVar);
                                    i4 = i2;
                                    obj3 = objApply2;
                                    i5 = 1;
                                } catch (Throwable th) {
                                    setTabAt(lVarArrInitTable, i6, null);
                                    throw th;
                                }
                            }
                        }
                        if (i5 != 0) {
                            break;
                        }
                    } else {
                        int i8 = lVarTabAt.a;
                        if (i8 == -1) {
                            lVarArrInitTable = helpTransfer(lVarArrInitTable, lVarTabAt);
                        } else {
                            synchronized (lVarTabAt) {
                                if (tabAt(lVarArrInitTable, i6) == lVarTabAt) {
                                    if (i8 >= 0) {
                                        l lVar2 = null;
                                        l lVar3 = lVarTabAt;
                                        i3 = 1;
                                        while (true) {
                                            if (lVar3.a == iSpread && ((obj2 = lVar3.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                break;
                                            }
                                            l lVar4 = lVar3.d;
                                            if (lVar4 == null) {
                                                objApply = biFunction.apply(obj, null);
                                                if (objApply != null) {
                                                    lVar3.d = new l(iSpread, obj, objApply, null);
                                                } else {
                                                    i5 = i3;
                                                    obj3 = objApply;
                                                }
                                            } else {
                                                i3++;
                                                lVar2 = lVar3;
                                                lVar3 = lVar4;
                                            }
                                        }
                                        Object objApply3 = biFunction.apply(obj, lVar3.c);
                                        if (objApply3 != null) {
                                            lVar3.c = objApply3;
                                            i5 = i3;
                                            obj3 = objApply3;
                                        } else {
                                            l lVar5 = lVar3.d;
                                            if (lVar2 != null) {
                                                lVar2.d = lVar5;
                                            } else {
                                                setTabAt(lVarArrInitTable, i6, lVar5);
                                            }
                                            objApply = objApply3;
                                            i7 = i3;
                                            i5 = i7;
                                            obj3 = objApply;
                                            i4 = -1;
                                        }
                                    } else if (lVarTabAt instanceof q) {
                                        q qVar = (q) lVarTabAt;
                                        r rVar = qVar.g;
                                        r rVarB = rVar != null ? rVar.b(iSpread, obj, null) : null;
                                        objApply = biFunction.apply(obj, rVarB == null ? null : rVarB.c);
                                        if (objApply != null) {
                                            if (rVarB != null) {
                                                rVarB.c = objApply;
                                            } else {
                                                qVar.f(iSpread, obj, objApply);
                                                i3 = 1;
                                                i5 = i3;
                                                obj3 = objApply;
                                                i4 = 1;
                                            }
                                        } else if (rVarB != null) {
                                            if (qVar.g(rVarB)) {
                                                setTabAt(lVarArrInitTable, i6, untreeify(qVar.h));
                                            }
                                            i5 = i7;
                                            obj3 = objApply;
                                            i4 = -1;
                                        }
                                        obj3 = objApply;
                                        i5 = 1;
                                    }
                                }
                            }
                            if (i5 != 0) {
                                if (i5 >= 8) {
                                    treeifyBin(lVarArrInitTable, i6);
                                }
                            }
                        }
                    }
                }
            }
            lVarArrInitTable = initTable();
        }
        if (i4 != 0) {
            addCount(i4, i5);
        }
        return obj3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, C0087s.a(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object computeIfAbsent(Object obj, Function function) {
        r rVarB;
        Object obj2;
        if (obj == null || function == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        l[] lVarArrInitTable = this.table;
        Object objApply = null;
        int i2 = 0;
        while (true) {
            if (lVarArrInitTable != null) {
                int length = lVarArrInitTable.length;
                if (length != 0) {
                    int i3 = (length - 1) & iSpread;
                    l lVarTabAt = tabAt(lVarArrInitTable, i3);
                    boolean z = true;
                    if (lVarTabAt == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            if (casTabAt(lVarArrInitTable, i3, null, mVar)) {
                                try {
                                    Object objApply2 = function.apply(obj);
                                    setTabAt(lVarArrInitTable, i3, objApply2 != null ? new l(iSpread, obj, objApply2, null) : null);
                                    objApply = objApply2;
                                    i2 = 1;
                                } catch (Throwable th) {
                                    setTabAt(lVarArrInitTable, i3, null);
                                    throw th;
                                }
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i4 = lVarTabAt.a;
                        if (i4 == -1) {
                            lVarArrInitTable = helpTransfer(lVarArrInitTable, lVarTabAt);
                        } else {
                            synchronized (lVarTabAt) {
                                if (tabAt(lVarArrInitTable, i3) == lVarTabAt) {
                                    if (i4 >= 0) {
                                        l lVar = lVarTabAt;
                                        i2 = 1;
                                        while (true) {
                                            if (lVar.a == iSpread && ((obj2 = lVar.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                break;
                                            }
                                            l lVar2 = lVar.d;
                                            if (lVar2 == null) {
                                                Object objApply3 = function.apply(obj);
                                                if (objApply3 != null) {
                                                    lVar.d = new l(iSpread, obj, objApply3, null);
                                                    objApply = objApply3;
                                                } else {
                                                    objApply = objApply3;
                                                }
                                            } else {
                                                i2++;
                                                lVar = lVar2;
                                            }
                                        }
                                        objApply = lVar.c;
                                    } else if (lVarTabAt instanceof q) {
                                        q qVar = (q) lVarTabAt;
                                        r rVar = qVar.g;
                                        if (rVar == null || (rVarB = rVar.b(iSpread, obj, null)) == null) {
                                            objApply = function.apply(obj);
                                            if (objApply != null) {
                                                qVar.f(iSpread, obj, objApply);
                                                i2 = 2;
                                            }
                                        } else {
                                            objApply = rVarB.c;
                                        }
                                        i2 = 2;
                                    }
                                }
                                z = false;
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    treeifyBin(lVarArrInitTable, i3);
                                }
                                if (!z) {
                                    return objApply;
                                }
                            }
                        }
                    }
                }
            }
            lVarArrInitTable = initTable();
        }
        if (objApply != null) {
            addCount(1L, i2);
        }
        return objApply;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, M.a(function));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        r rVarB;
        l lVarUntreeify;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        l[] lVarArrInitTable = this.table;
        int i2 = 0;
        Object objApply = null;
        int i3 = 0;
        while (true) {
            if (lVarArrInitTable != null) {
                int length = lVarArrInitTable.length;
                if (length != 0) {
                    int i4 = (length - 1) & iSpread;
                    l lVarTabAt = tabAt(lVarArrInitTable, i4);
                    if (lVarTabAt == null) {
                        break;
                    }
                    int i5 = lVarTabAt.a;
                    if (i5 == -1) {
                        lVarArrInitTable = helpTransfer(lVarArrInitTable, lVarTabAt);
                    } else {
                        synchronized (lVarTabAt) {
                            if (tabAt(lVarArrInitTable, i4) == lVarTabAt) {
                                if (i5 >= 0) {
                                    i3 = 1;
                                    l lVar = null;
                                    l lVar2 = lVarTabAt;
                                    while (true) {
                                        if (lVar2.a == iSpread && ((obj2 = lVar2.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                            break;
                                        }
                                        l lVar3 = lVar2.d;
                                        if (lVar3 == null) {
                                            break;
                                        }
                                        i3++;
                                        lVar = lVar2;
                                        lVar2 = lVar3;
                                    }
                                    objApply = biFunction.apply(obj, lVar2.c);
                                    if (objApply != null) {
                                        lVar2.c = objApply;
                                    } else {
                                        lVarUntreeify = lVar2.d;
                                        if (lVar != null) {
                                            lVar.d = lVarUntreeify;
                                        } else {
                                            setTabAt(lVarArrInitTable, i4, lVarUntreeify);
                                        }
                                        i2 = -1;
                                    }
                                } else if (lVarTabAt instanceof q) {
                                    i3 = 2;
                                    q qVar = (q) lVarTabAt;
                                    r rVar = qVar.g;
                                    if (rVar != null && (rVarB = rVar.b(iSpread, obj, null)) != null) {
                                        objApply = biFunction.apply(obj, rVarB.c);
                                        if (objApply != null) {
                                            rVarB.c = objApply;
                                        } else {
                                            if (qVar.g(rVarB)) {
                                                lVarUntreeify = untreeify(qVar.h);
                                                setTabAt(lVarArrInitTable, i4, lVarUntreeify);
                                            }
                                            i2 = -1;
                                        }
                                    }
                                }
                            }
                        }
                        if (i3 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArrInitTable = initTable();
        }
        if (i2 != 0) {
            addCount(i2, i3);
        }
        return objApply;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, C0087s.a(biFunction));
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.table;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                Object obj2 = lVarA.c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Enumeration elements() {
        l[] lVarArr = this.table;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new s(lVarArr, length, 0, length, this);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set entrySet() {
        e eVar = this.entrySet;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.entrySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean equals(Object obj) {
        V value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        l[] lVarArr = this.table;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
            Object obj3 = lVarA.c;
            Object obj4 = map.get(lVarA.b);
            if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                break;
            }
        }
        return false;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.table;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            } else {
                biConsumer.accept(lVarA.b, lVarA.c);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(C0084q.b(biConsumer));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object get(Object obj) {
        int length;
        l lVarTabAt;
        Object obj2;
        int iSpread = spread(obj.hashCode());
        l[] lVarArr = this.table;
        if (lVarArr != null && (length = lVarArr.length) > 0 && (lVarTabAt = tabAt(lVarArr, (length - 1) & iSpread)) != null) {
            int i2 = lVarTabAt.a;
            if (i2 == iSpread) {
                Object obj3 = lVarTabAt.b;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    return lVarTabAt.c;
                }
            } else if (i2 < 0) {
                l lVarA = lVarTabAt.a(iSpread, obj);
                if (lVarA != null) {
                    return lVarA.c;
                }
                return null;
            }
            while (true) {
                lVarTabAt = lVarTabAt.d;
                if (lVarTabAt == null) {
                    break;
                }
                if (lVarTabAt.a == iSpread && ((obj2 = lVarTabAt.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    break;
                }
            }
            return lVarTabAt.c;
        }
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map, java.util.HashMap
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public int hashCode() {
        l[] lVarArr = this.table;
        int iHashCode = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                iHashCode += lVarA.c.hashCode() ^ lVarA.b.hashCode();
            }
        }
        return iHashCode;
    }

    final l[] helpTransfer(l[] lVarArr, l lVar) {
        l[] lVarArr2;
        int i2;
        if (lVarArr == null || !(lVar instanceof g) || (lVarArr2 = ((g) lVar).e) == null) {
            return this.table;
        }
        int iResizeStamp = resizeStamp(lVarArr.length);
        while (true) {
            if (lVarArr2 != this.nextTable || this.table != lVarArr || (i2 = this.sizeCtl) >= 0 || (i2 >>> RESIZE_STAMP_SHIFT) != iResizeStamp || i2 == iResizeStamp + 1 || i2 == MAX_RESIZERS + iResizeStamp || this.transferIndex <= 0) {
                break;
            }
            if (U.compareAndSwapInt(this, SIZECTL, i2, i2 + 1)) {
                transfer(lVarArr, lVarArr2);
                break;
            }
        }
        return lVarArr2;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Set keySet() {
        i iVar = this.keySet;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this, null);
        this.keySet = iVar2;
        return iVar2;
    }

    public Enumeration keys() {
        l[] lVarArr = this.table;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, 0, length, this);
    }

    public long mappingCount() {
        long jSumCount = sumCount();
        if (jSumCount < 0) {
            return 0L;
        }
        return jSumCount;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i2;
        Object obj3;
        Object obj4 = obj2;
        if (obj == null || obj4 == null || biFunction == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        l[] lVarArrInitTable = this.table;
        int i3 = 0;
        Object obj5 = null;
        int i4 = 0;
        while (true) {
            if (lVarArrInitTable != null) {
                int length = lVarArrInitTable.length;
                if (length != 0) {
                    int i5 = (length - 1) & iSpread;
                    l lVarTabAt = tabAt(lVarArrInitTable, i5);
                    i2 = 1;
                    if (lVarTabAt != null) {
                        int i6 = lVarTabAt.a;
                        if (i6 == -1) {
                            lVarArrInitTable = helpTransfer(lVarArrInitTable, lVarTabAt);
                        } else {
                            synchronized (lVarTabAt) {
                                if (tabAt(lVarArrInitTable, i5) == lVarTabAt) {
                                    if (i6 >= 0) {
                                        l lVar = null;
                                        l lVar2 = lVarTabAt;
                                        int i7 = 1;
                                        while (true) {
                                            if (lVar2.a == iSpread && ((obj3 = lVar2.b) == obj || (obj3 != null && obj.equals(obj3)))) {
                                                break;
                                            }
                                            l lVar3 = lVar2.d;
                                            if (lVar3 == null) {
                                                lVar2.d = new l(iSpread, obj, obj4, null);
                                                i3 = i7;
                                                i4 = 1;
                                                obj5 = obj4;
                                                break;
                                            }
                                            i7++;
                                            lVar = lVar2;
                                            lVar2 = lVar3;
                                        }
                                        Object objApply = biFunction.apply(lVar2.c, obj4);
                                        if (objApply != null) {
                                            lVar2.c = objApply;
                                            i3 = i7;
                                            obj5 = objApply;
                                        } else {
                                            l lVar4 = lVar2.d;
                                            if (lVar != null) {
                                                lVar.d = lVar4;
                                            } else {
                                                setTabAt(lVarArrInitTable, i5, lVar4);
                                            }
                                            i3 = i7;
                                            obj5 = objApply;
                                            i4 = -1;
                                        }
                                    } else if (lVarTabAt instanceof q) {
                                        i3 = 2;
                                        q qVar = (q) lVarTabAt;
                                        r rVar = qVar.g;
                                        r rVarB = rVar == null ? null : rVar.b(iSpread, obj, null);
                                        Object objApply2 = rVarB == null ? obj4 : biFunction.apply(rVarB.c, obj4);
                                        if (objApply2 != null) {
                                            if (rVarB != null) {
                                                rVarB.c = objApply2;
                                            } else {
                                                qVar.f(iSpread, obj, objApply2);
                                                obj5 = objApply2;
                                                i4 = 1;
                                            }
                                        } else if (rVarB != null) {
                                            if (qVar.g(rVarB)) {
                                                setTabAt(lVarArrInitTable, i5, untreeify(qVar.h));
                                            }
                                            obj5 = objApply2;
                                            i4 = -1;
                                        }
                                        obj5 = objApply2;
                                    }
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    treeifyBin(lVarArrInitTable, i5);
                                }
                                i2 = i4;
                                obj4 = obj5;
                            }
                        }
                    } else if (casTabAt(lVarArrInitTable, i5, null, new l(iSpread, obj, obj4, null))) {
                        break;
                    }
                }
            }
            lVarArrInitTable = initTable();
        }
        if (i2 != 0) {
            addCount(i2, i3);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, C0087s.a(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object put(Object obj, Object obj2) {
        return putVal(obj, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public void putAll(java.util.Map map) {
        tryPresize(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object putIfAbsent(Object obj, Object obj2) {
        return putVal(obj, obj2, true);
    }

    final Object putVal(Object obj, Object obj2, boolean z) {
        Object obj3;
        l lVarF;
        Object obj4;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        int i2 = 0;
        l[] lVarArrInitTable = this.table;
        while (true) {
            if (lVarArrInitTable != null) {
                int length = lVarArrInitTable.length;
                if (length != 0) {
                    int i3 = (length - 1) & iSpread;
                    l lVarTabAt = tabAt(lVarArrInitTable, i3);
                    if (lVarTabAt != null) {
                        int i4 = lVarTabAt.a;
                        if (i4 == -1) {
                            lVarArrInitTable = helpTransfer(lVarArrInitTable, lVarTabAt);
                        } else {
                            synchronized (lVarTabAt) {
                                if (tabAt(lVarArrInitTable, i3) == lVarTabAt) {
                                    if (i4 >= 0) {
                                        i2 = 1;
                                        lVarF = lVarTabAt;
                                        while (true) {
                                            if (lVarF.a == iSpread && ((obj4 = lVarF.b) == obj || (obj4 != null && obj.equals(obj4)))) {
                                                break;
                                            }
                                            l lVar = lVarF.d;
                                            if (lVar == null) {
                                                lVarF.d = new l(iSpread, obj, obj2, null);
                                                break;
                                            }
                                            i2++;
                                            lVarF = lVar;
                                        }
                                        obj3 = lVarF.c;
                                        if (!z) {
                                            lVarF.c = obj2;
                                        }
                                    } else if (lVarTabAt instanceof q) {
                                        i2 = 2;
                                        lVarF = ((q) lVarTabAt).f(iSpread, obj, obj2);
                                        if (lVarF != null) {
                                            obj3 = lVarF.c;
                                            if (!z) {
                                                lVarF.c = obj2;
                                            }
                                        }
                                    }
                                }
                                obj3 = null;
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    treeifyBin(lVarArrInitTable, i3);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (casTabAt(lVarArrInitTable, i3, null, new l(iSpread, obj, obj2, null))) {
                        break;
                    }
                }
            }
            lVarArrInitTable = initTable();
        }
        addCount(1L, i2);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public Object remove(Object obj) {
        return replaceNode(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object replace(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw null;
        }
        return replaceNode(obj, obj2, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return replaceNode(obj, obj3, obj2) != null;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.table;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            }
            Object obj = lVarA.c;
            Object obj2 = lVarA.b;
            do {
                Object objApply = biFunction.apply(obj2, obj);
                objApply.getClass();
                if (replaceNode(obj2, objApply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(C0087s.a(biFunction));
    }

    final Object replaceNode(Object obj, Object obj2, Object obj3) {
        int length;
        int i2;
        l lVarTabAt;
        boolean z;
        Object obj4;
        r rVarB;
        l lVarUntreeify;
        Object obj5;
        int iSpread = spread(obj.hashCode());
        l[] lVarArrHelpTransfer = this.table;
        while (true) {
            if (lVarArrHelpTransfer == null || (length = lVarArrHelpTransfer.length) == 0 || (lVarTabAt = tabAt(lVarArrHelpTransfer, (i2 = (length - 1) & iSpread))) == null) {
                break;
            }
            int i3 = lVarTabAt.a;
            if (i3 == -1) {
                lVarArrHelpTransfer = helpTransfer(lVarArrHelpTransfer, lVarTabAt);
            } else {
                boolean z2 = false;
                synchronized (lVarTabAt) {
                    z = true;
                    if (tabAt(lVarArrHelpTransfer, i2) == lVarTabAt) {
                        if (i3 >= 0) {
                            l lVar = null;
                            l lVar2 = lVarTabAt;
                            while (true) {
                                if (lVar2.a == iSpread && ((obj5 = lVar2.b) == obj || (obj5 != null && obj.equals(obj5)))) {
                                    break;
                                }
                                l lVar3 = lVar2.d;
                                if (lVar3 == null) {
                                    break;
                                }
                                lVar = lVar2;
                                lVar2 = lVar3;
                            }
                            obj4 = lVar2.c;
                            if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                if (obj2 != null) {
                                    lVar2.c = obj2;
                                } else if (lVar != null) {
                                    lVar.d = lVar2.d;
                                } else {
                                    lVarUntreeify = lVar2.d;
                                    setTabAt(lVarArrHelpTransfer, i2, lVarUntreeify);
                                }
                            }
                            z2 = true;
                        } else if (lVarTabAt instanceof q) {
                            q qVar = (q) lVarTabAt;
                            r rVar = qVar.g;
                            if (rVar != null && (rVarB = rVar.b(iSpread, obj, null)) != null) {
                                obj4 = rVarB.c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        rVarB.c = obj2;
                                    } else if (qVar.g(rVarB)) {
                                        lVarUntreeify = untreeify(qVar.h);
                                        setTabAt(lVarArrHelpTransfer, i2, lVarUntreeify);
                                    }
                                }
                            }
                            z2 = true;
                        }
                    }
                    obj4 = null;
                    z = z2;
                }
                if (z) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            addCount(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public int size() {
        long jSumCount = sumCount();
        if (jSumCount < 0) {
            return 0;
        }
        if (jSumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jSumCount;
    }

    final long sumCount() {
        c[] cVarArr = this.counterCells;
        long j2 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.value;
                }
            }
        }
        return j2;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        l[] lVarArr = this.table;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        l lVarA = pVar.a();
        if (lVarA != null) {
            while (true) {
                Object obj = lVarA.b;
                Object obj2 = lVarA.c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map, j$.util.Map
    public java.util.Collection values() {
        u uVar = this.values;
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this);
        this.values = uVar2;
        return uVar2;
    }
}
