package ir.nasim;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public final class AA7 implements Collection, InterfaceC17915nm3 {
    private final short[] a;

    private static final class a implements Iterator, InterfaceC17915nm3 {
        private final short[] a;
        private int b;

        public a(short[] sArr) {
            AbstractC13042fc3.i(sArr, "array");
            this.a = sArr;
        }

        public short b() {
            int i = this.b;
            short[] sArr = this.a;
            if (i >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            this.b = i + 1;
            return C24771zA7.h(sArr[i]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return C24771zA7.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ AA7(short[] sArr) {
        this.a = sArr;
    }

    public static int B(short[] sArr) {
        return sArr.length;
    }

    public static int C(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean E(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator F(short[] sArr) {
        return new a(sArr);
    }

    public static final void I(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    public static String L(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public static final /* synthetic */ AA7 f(short[] sArr) {
        return new AA7(sArr);
    }

    public static short[] h(int i) {
        return i(new short[i]);
    }

    public static short[] i(short[] sArr) {
        AbstractC13042fc3.i(sArr, "storage");
        return sArr;
    }

    public static boolean o(short[] sArr, short s) {
        return AbstractC10242bK.V(sArr, s);
    }

    public static boolean t(short[] sArr, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof C24771zA7) || !AbstractC10242bK.V(sArr, ((C24771zA7) obj).p())) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(short[] sArr, Object obj) {
        return (obj instanceof AA7) && AbstractC13042fc3.d(sArr, ((AA7) obj).N());
    }

    public static final short x(short[] sArr, int i) {
        return C24771zA7.h(sArr[i]);
    }

    @Override // java.util.Collection
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public int size() {
        return B(this.a);
    }

    public final /* synthetic */ short[] N() {
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
        if (obj instanceof C24771zA7) {
            return j(((C24771zA7) obj).p());
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

    public boolean j(short s) {
        return o(this.a, s);
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
