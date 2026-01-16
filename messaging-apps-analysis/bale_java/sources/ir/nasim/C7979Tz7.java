package ir.nasim;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Tz7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7979Tz7 implements Collection, InterfaceC17915nm3 {
    private final byte[] a;

    /* renamed from: ir.nasim.Tz7$a */
    private static final class a implements Iterator, InterfaceC17915nm3 {
        private final byte[] a;
        private int b;

        public a(byte[] bArr) {
            AbstractC13042fc3.i(bArr, "array");
            this.a = bArr;
        }

        public byte b() {
            int i = this.b;
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            this.b = i + 1;
            return C7743Sz7.h(bArr[i]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return C7743Sz7.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ C7979Tz7(byte[] bArr) {
        this.a = bArr;
    }

    public static int B(byte[] bArr) {
        return bArr.length;
    }

    public static int C(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean E(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator F(byte[] bArr) {
        return new a(bArr);
    }

    public static final void I(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    public static String L(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public static final /* synthetic */ C7979Tz7 f(byte[] bArr) {
        return new C7979Tz7(bArr);
    }

    public static byte[] h(int i) {
        return i(new byte[i]);
    }

    public static byte[] i(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "storage");
        return bArr;
    }

    public static boolean o(byte[] bArr, byte b) {
        return AbstractC10242bK.Q(bArr, b);
    }

    public static boolean t(byte[] bArr, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof C7743Sz7) || !AbstractC10242bK.Q(bArr, ((C7743Sz7) obj).p())) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(byte[] bArr, Object obj) {
        return (obj instanceof C7979Tz7) && AbstractC13042fc3.d(bArr, ((C7979Tz7) obj).N());
    }

    public static final byte x(byte[] bArr, int i) {
        return C7743Sz7.h(bArr[i]);
    }

    @Override // java.util.Collection
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public int size() {
        return B(this.a);
    }

    public final /* synthetic */ byte[] N() {
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
        if (obj instanceof C7743Sz7) {
            return j(((C7743Sz7) obj).p());
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

    public boolean j(byte b) {
        return o(this.a, b);
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
