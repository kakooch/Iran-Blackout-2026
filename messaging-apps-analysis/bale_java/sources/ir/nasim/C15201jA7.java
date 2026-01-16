package ir.nasim;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.jA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15201jA7 implements Collection, InterfaceC17915nm3 {
    private final long[] a;

    /* renamed from: ir.nasim.jA7$a */
    private static final class a implements Iterator, InterfaceC17915nm3 {
        private final long[] a;
        private int b;

        public a(long[] jArr) {
            AbstractC13042fc3.i(jArr, "array");
            this.a = jArr;
        }

        public long b() {
            int i = this.b;
            long[] jArr = this.a;
            if (i >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            this.b = i + 1;
            return C14599iA7.h(jArr[i]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return C14599iA7.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ C15201jA7(long[] jArr) {
        this.a = jArr;
    }

    public static int B(long[] jArr) {
        return jArr.length;
    }

    public static int C(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean E(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator F(long[] jArr) {
        return new a(jArr);
    }

    public static final void I(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    public static String L(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public static final /* synthetic */ C15201jA7 f(long[] jArr) {
        return new C15201jA7(jArr);
    }

    public static long[] h(int i) {
        return i(new long[i]);
    }

    public static long[] i(long[] jArr) {
        AbstractC13042fc3.i(jArr, "storage");
        return jArr;
    }

    public static boolean o(long[] jArr, long j) {
        return AbstractC10242bK.T(jArr, j);
    }

    public static boolean t(long[] jArr, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof C14599iA7) || !AbstractC10242bK.T(jArr, ((C14599iA7) obj).q())) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(long[] jArr, Object obj) {
        return (obj instanceof C15201jA7) && AbstractC13042fc3.d(jArr, ((C15201jA7) obj).N());
    }

    public static final long x(long[] jArr, int i) {
        return C14599iA7.h(jArr[i]);
    }

    @Override // java.util.Collection
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public int size() {
        return B(this.a);
    }

    public final /* synthetic */ long[] N() {
        return this.a;
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C14599iA7) {
            return j(((C14599iA7) obj).q());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return t(this.a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return v(this.a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return C(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return E(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return F(this.a);
    }

    public boolean j(long j) {
        return o(this.a, j);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    public String toString() {
        return L(this.a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        return UW0.b(this, objArr);
    }
}
