package ir.nasim;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class Z33 extends AbstractCollection implements Serializable {
    private static final Object[] a = new Object[0];

    static abstract class a extends b {
        Object[] a;
        int b;
        boolean c;

        a(int i) {
            MW0.b(i, "initialCapacity");
            this.a = new Object[i];
            this.b = 0;
        }

        private void e(int i) {
            Object[] objArr = this.a;
            if (objArr.length < i) {
                this.a = Arrays.copyOf(objArr, b.c(objArr.length, i));
                this.c = false;
            } else if (this.c) {
                this.a = (Object[]) objArr.clone();
                this.c = false;
            }
        }

        @Override // ir.nasim.Z33.b
        public b b(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                e(this.b + collection.size());
                if (collection instanceof Z33) {
                    this.b = ((Z33) collection).j(this.a, this.b);
                    return this;
                }
            }
            super.b(iterable);
            return this;
        }

        public a d(Object obj) {
            AbstractC4029Dj5.j(obj);
            e(this.b + 1);
            Object[] objArr = this.a;
            int i = this.b;
            this.b = i + 1;
            objArr[i] = obj;
            return this;
        }
    }

    public static abstract class b {
        b() {
        }

        static int c(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public abstract b a(Object obj);

        public b b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    Z33() {
    }

    int C() {
        throw new UnsupportedOperationException();
    }

    abstract boolean D();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public abstract AbstractC12710f43 f();

    abstract int j(Object[] objArr, int i);

    Object[] r() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(a);
    }

    int w() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        AbstractC4029Dj5.j(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrR = r();
            if (objArrR != null) {
                return AbstractC6343Ne5.a(objArrR, C(), w(), objArr);
            }
            objArr = AbstractC16434lG4.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        j(objArr, 0);
        return objArr;
    }
}
