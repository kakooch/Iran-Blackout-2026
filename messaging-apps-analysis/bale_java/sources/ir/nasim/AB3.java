package ir.nasim;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes8.dex */
public final class AB3 extends AbstractC19831r1 implements List, RandomAccess, Serializable, InterfaceC19688qm3 {
    private static final b d = new b(null);
    private static final AB3 e;
    private Object[] a;
    private int b;
    private boolean c;

    public static final class a extends AbstractC19831r1 implements List, RandomAccess, Serializable, InterfaceC19688qm3 {
        private Object[] a;
        private final int b;
        private int c;
        private final a d;
        private final AB3 e;

        /* renamed from: ir.nasim.AB3$a$a, reason: collision with other inner class name */
        private static final class C0255a implements ListIterator, InterfaceC17915nm3 {
            private final a a;
            private int b;
            private int c;
            private int d;

            public C0255a(a aVar, int i) {
                AbstractC13042fc3.i(aVar, "list");
                this.a = aVar;
                this.b = i;
                this.c = -1;
                this.d = ((AbstractList) aVar).modCount;
            }

            private final void b() {
                if (((AbstractList) this.a.e).modCount != this.d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                b();
                a aVar = this.a;
                int i = this.b;
                this.b = i + 1;
                aVar.add(i, obj);
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.b < this.a.c;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                b();
                if (this.b >= this.a.c) {
                    throw new NoSuchElementException();
                }
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return this.a.a[this.a.b + this.c];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.b;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                b();
                int i = this.b;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                return this.a.a[this.a.b + this.c];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                b();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
                }
                this.a.remove(i);
                this.b = this.c;
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                b();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
                }
                this.a.set(i, obj);
            }
        }

        public a(Object[] objArr, int i, int i2, a aVar, AB3 ab3) {
            AbstractC13042fc3.i(objArr, "backing");
            AbstractC13042fc3.i(ab3, "root");
            this.a = objArr;
            this.b = i;
            this.c = i2;
            this.d = aVar;
            this.e = ab3;
            ((AbstractList) this).modCount = ((AbstractList) ab3).modCount;
        }

        private final void O(int i, Collection collection, int i2) {
            W();
            a aVar = this.d;
            if (aVar != null) {
                aVar.O(i, collection, i2);
            } else {
                this.e.S(i, collection, i2);
            }
            this.a = this.e.a;
            this.c += i2;
        }

        private final void P(int i, Object obj) {
            W();
            a aVar = this.d;
            if (aVar != null) {
                aVar.P(i, obj);
            } else {
                this.e.V(i, obj);
            }
            this.a = this.e.a;
            this.c++;
        }

        private final void Q() {
            if (((AbstractList) this.e).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void R() {
            if (V()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean S(List list) {
            return BB3.h(this.a, this.b, this.c, list);
        }

        private final boolean V() {
            return this.e.c;
        }

        private final void W() {
            ((AbstractList) this).modCount++;
        }

        private final Object Y(int i) {
            W();
            a aVar = this.d;
            this.c--;
            return aVar != null ? aVar.Y(i) : this.e.f0(i);
        }

        private final void Z(int i, int i2) {
            if (i2 > 0) {
                W();
            }
            a aVar = this.d;
            if (aVar != null) {
                aVar.Z(i, i2);
            } else {
                this.e.g0(i, i2);
            }
            this.c -= i2;
        }

        private final int a0(int i, int i2, Collection collection, boolean z) {
            a aVar = this.d;
            int iA0 = aVar != null ? aVar.a0(i, i2, collection, z) : this.e.h0(i, i2, collection, z);
            if (iA0 > 0) {
                W();
            }
            this.c -= iA0;
            return iA0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            R();
            Q();
            P(this.b + this.c, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            R();
            Q();
            int size = collection.size();
            O(this.b + this.c, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            R();
            Q();
            Z(this.b, this.c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            Q();
            return obj == this || ((obj instanceof List) && S((List) obj));
        }

        @Override // ir.nasim.AbstractC19831r1
        public int f() {
            Q();
            return this.c;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            Q();
            AbstractC11442d1.Companion.b(i, this.c);
            return this.a[this.b + i];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            Q();
            return BB3.i(this.a, this.b, this.c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            Q();
            for (int i = 0; i < this.c; i++) {
                if (AbstractC13042fc3.d(this.a[this.b + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            Q();
            return this.c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator(0);
        }

        @Override // ir.nasim.AbstractC19831r1
        public Object j(int i) {
            R();
            Q();
            AbstractC11442d1.Companion.b(i, this.c);
            return Y(this.b + i);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            Q();
            for (int i = this.c - 1; i >= 0; i--) {
                if (AbstractC13042fc3.d(this.a[this.b + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            R();
            Q();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                remove(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            R();
            Q();
            return a0(this.b, this.c, collection, false) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            R();
            Q();
            return a0(this.b, this.c, collection, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            R();
            Q();
            AbstractC11442d1.Companion.b(i, this.c);
            Object[] objArr = this.a;
            int i2 = this.b;
            Object obj2 = objArr[i2 + i];
            objArr[i2 + i] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            AbstractC11442d1.Companion.d(i, i2, this.c);
            return new a(this.a, this.b + i, i2 - i, this, this.e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "array");
            Q();
            int length = objArr.length;
            int i = this.c;
            if (length >= i) {
                Object[] objArr2 = this.a;
                int i2 = this.b;
                AbstractC9648aK.l(objArr2, objArr, 0, i2, i + i2);
                return AbstractC9766aX0.f(this.c, objArr);
            }
            Object[] objArr3 = this.a;
            int i3 = this.b;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr3, i3, i + i3, objArr.getClass());
            AbstractC13042fc3.h(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            Q();
            return BB3.j(this.a, this.b, this.c, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            Q();
            AbstractC11442d1.Companion.c(i, this.c);
            return new C0255a(this, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            R();
            Q();
            AbstractC11442d1.Companion.c(i, this.c);
            P(this.b + i, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            R();
            Q();
            AbstractC11442d1.Companion.c(i, this.c);
            int size = collection.size();
            O(this.b + i, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            Q();
            Object[] objArr = this.a;
            int i = this.b;
            return AbstractC9648aK.s(objArr, i, this.c + i);
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    private static final class c implements ListIterator, InterfaceC17915nm3 {
        private final AB3 a;
        private int b;
        private int c;
        private int d;

        public c(AB3 ab3, int i) {
            AbstractC13042fc3.i(ab3, "list");
            this.a = ab3;
            this.b = i;
            this.c = -1;
            this.d = ((AbstractList) ab3).modCount;
        }

        private final void b() {
            if (((AbstractList) this.a).modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            b();
            AB3 ab3 = this.a;
            int i = this.b;
            this.b = i + 1;
            ab3.add(i, obj);
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            b();
            if (this.b >= this.a.b) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.b = i + 1;
            this.c = i;
            return this.a.a[this.c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            b();
            int i = this.b;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.b = i2;
            this.c = i2;
            return this.a.a[this.c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            int i = this.c;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.a.remove(i);
            this.b = this.c;
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            b();
            int i = this.c;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.a.set(i, obj);
        }
    }

    static {
        AB3 ab3 = new AB3(0);
        ab3.c = true;
        e = ab3;
    }

    public AB3(int i) {
        this.a = BB3.d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(int i, Collection collection, int i2) {
        d0();
        c0(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.a[i + i3] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(int i, Object obj) {
        d0();
        c0(i, 1);
        this.a[i] = obj;
    }

    private final void Y() {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean Z(List list) {
        return BB3.h(this.a, 0, this.b, list);
    }

    private final void a0(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.a;
        if (i > objArr.length) {
            this.a = BB3.e(this.a, AbstractC11442d1.Companion.e(objArr.length, i));
        }
    }

    private final void b0(int i) {
        a0(this.b + i);
    }

    private final void c0(int i, int i2) {
        b0(i2);
        Object[] objArr = this.a;
        AbstractC9648aK.l(objArr, objArr, i + i2, i, this.b);
        this.b += i2;
    }

    private final void d0() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f0(int i) {
        d0();
        Object[] objArr = this.a;
        Object obj = objArr[i];
        AbstractC9648aK.l(objArr, objArr, i, i + 1, this.b);
        BB3.f(this.a, this.b - 1);
        this.b--;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(int i, int i2) {
        if (i2 > 0) {
            d0();
        }
        Object[] objArr = this.a;
        AbstractC9648aK.l(objArr, objArr, i, i + i2, this.b);
        Object[] objArr2 = this.a;
        int i3 = this.b;
        BB3.g(objArr2, i3 - i2, i3);
        this.b -= i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h0(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.a[i5]) == z) {
                Object[] objArr = this.a;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.a;
        AbstractC9648aK.l(objArr2, objArr2, i + i4, i2 + i, this.b);
        Object[] objArr3 = this.a;
        int i7 = this.b;
        BB3.g(objArr3, i7 - i6, i7);
        if (i6 > 0) {
            d0();
        }
        this.b -= i6;
        return i6;
    }

    public final List W() {
        Y();
        this.c = true;
        return this.b > 0 ? this : e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        Y();
        V(this.b, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Y();
        int size = collection.size();
        S(this.b, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Y();
        g0(0, this.b);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && Z((List) obj));
    }

    @Override // ir.nasim.AbstractC19831r1
    public int f() {
        return this.b;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        AbstractC11442d1.Companion.b(i, this.b);
        return this.a[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return BB3.i(this.a, 0, this.b);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.b; i++) {
            if (AbstractC13042fc3.d(this.a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // ir.nasim.AbstractC19831r1
    public Object j(int i) {
        Y();
        AbstractC11442d1.Companion.b(i, this.b);
        return f0(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.b - 1; i >= 0; i--) {
            if (AbstractC13042fc3.d(this.a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        Y();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Y();
        return h0(0, this.b, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Y();
        return h0(0, this.b, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        Y();
        AbstractC11442d1.Companion.b(i, this.b);
        Object[] objArr = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i, int i2) {
        AbstractC11442d1.Companion.d(i, i2, this.b);
        return new a(this.a, i, i2 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        int length = objArr.length;
        int i = this.b;
        if (length >= i) {
            AbstractC9648aK.l(this.a, objArr, 0, 0, i);
            return AbstractC9766aX0.f(this.b, objArr);
        }
        Object[] objArrCopyOfRange = Arrays.copyOfRange(this.a, 0, i, objArr.getClass());
        AbstractC13042fc3.h(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return BB3.j(this.a, 0, this.b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        AbstractC11442d1.Companion.c(i, this.b);
        return new c(this, i);
    }

    public /* synthetic */ AB3(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        Y();
        AbstractC11442d1.Companion.c(i, this.b);
        V(i, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Y();
        AbstractC11442d1.Companion.c(i, this.b);
        int size = collection.size();
        S(i, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return AbstractC9648aK.s(this.a, 0, this.b);
    }
}
