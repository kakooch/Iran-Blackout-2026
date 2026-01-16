package ir.nasim;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.eA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12183eA7 implements Collection, InterfaceC17915nm3 {
    private final int[] a;

    /* renamed from: ir.nasim.eA7$a */
    private static final class a implements Iterator, InterfaceC17915nm3 {
        private final int[] a;
        private int b;

        public a(int[] iArr) {
            AbstractC13042fc3.i(iArr, "array");
            this.a = iArr;
        }

        public int b() {
            int i = this.b;
            int[] iArr = this.a;
            if (i >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            this.b = i + 1;
            return C11540dA7.h(iArr[i]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return C11540dA7.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ C12183eA7(int[] iArr) {
        this.a = iArr;
    }

    public static int B(int[] iArr) {
        return iArr.length;
    }

    public static int C(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean E(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator F(int[] iArr) {
        return new a(iArr);
    }

    public static final void I(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    public static String L(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public static final /* synthetic */ C12183eA7 f(int[] iArr) {
        return new C12183eA7(iArr);
    }

    public static int[] h(int i) {
        return i(new int[i]);
    }

    public static int[] i(int[] iArr) {
        AbstractC13042fc3.i(iArr, "storage");
        return iArr;
    }

    public static boolean o(int[] iArr, int i) {
        return AbstractC10242bK.S(iArr, i);
    }

    public static boolean t(int[] iArr, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof C11540dA7) || !AbstractC10242bK.S(iArr, ((C11540dA7) obj).p())) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(int[] iArr, Object obj) {
        return (obj instanceof C12183eA7) && AbstractC13042fc3.d(iArr, ((C12183eA7) obj).N());
    }

    public static final int x(int[] iArr, int i) {
        return C11540dA7.h(iArr[i]);
    }

    @Override // java.util.Collection
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public int size() {
        return B(this.a);
    }

    public final /* synthetic */ int[] N() {
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
        if (obj instanceof C11540dA7) {
            return j(((C11540dA7) obj).p());
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

    public boolean j(int i) {
        return o(this.a, i);
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
