package ir.nasim;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public final class BJ extends AbstractC19831r1 {
    public static final a d = new a(null);
    private static final Object[] e = new Object[0];
    private int a;
    private Object[] b;
    private int c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public BJ(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = e;
        } else {
            if (i <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i);
            }
            objArr = new Object[i];
        }
        this.b = objArr;
    }

    private final void C(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = size() + collection.size();
    }

    private final void E(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.b;
        AbstractC9648aK.l(objArr2, objArr, 0, this.a, objArr2.length);
        Object[] objArr3 = this.b;
        int length = objArr3.length;
        int i2 = this.a;
        AbstractC9648aK.l(objArr3, objArr, length - i2, 0, i2);
        this.a = 0;
        this.b = objArr;
    }

    private final int F(int i) {
        return i == 0 ? AbstractC10242bK.l0(this.b) : i - 1;
    }

    private final void L(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.b = new Object[AbstractC23053wG5.e(i, 10)];
        } else {
            E(AbstractC11442d1.Companion.e(objArr.length, i));
        }
    }

    private final int O(int i) {
        if (i == AbstractC10242bK.l0(this.b)) {
            return 0;
        }
        return i + 1;
    }

    private final int Q(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    private final void R(int i, int i2) {
        if (i < i2) {
            AbstractC9648aK.v(this.b, null, i, i2);
            return;
        }
        Object[] objArr = this.b;
        AbstractC9648aK.v(objArr, null, i, objArr.length);
        AbstractC9648aK.v(this.b, null, 0, i2);
    }

    private final int S(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    private final void V() {
        ((AbstractList) this).modCount++;
    }

    private final void Z(int i, int i2) {
        int iS = S(this.a + (i - 1));
        int iS2 = S(this.a + (i2 - 1));
        while (i > 0) {
            int i3 = iS + 1;
            int iMin = Math.min(i, Math.min(i3, iS2 + 1));
            Object[] objArr = this.b;
            int i4 = iS2 - iMin;
            int i5 = iS - iMin;
            AbstractC9648aK.l(objArr, objArr, i4 + 1, i5 + 1, i3);
            iS = Q(i5);
            iS2 = Q(i4);
            i -= iMin;
        }
    }

    private final void a0(int i, int i2) {
        int iS = S(this.a + i2);
        int iS2 = S(this.a + i);
        int size = size();
        while (true) {
            size -= i2;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.b;
            i2 = Math.min(size, Math.min(objArr.length - iS, objArr.length - iS2));
            Object[] objArr2 = this.b;
            int i3 = iS + i2;
            AbstractC9648aK.l(objArr2, objArr2, iS2, iS, i3);
            iS = S(i3);
            iS2 = S(iS2 + i2);
        }
    }

    public final Object N() {
        if (isEmpty()) {
            return null;
        }
        return this.b[this.a];
    }

    public final Object P() {
        if (isEmpty()) {
            return null;
        }
        return this.b[S(this.a + AbstractC10360bX0.o(this))];
    }

    public final Object W() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final Object Y() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        V();
        L(size() + collection.size());
        C(S(this.a + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        V();
        L(size() + 1);
        int iF = F(this.a);
        this.a = iF;
        this.b[iF] = obj;
        this.c = size() + 1;
    }

    public final void addLast(Object obj) {
        V();
        L(size() + 1);
        this.b[S(this.a + size())] = obj;
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            V();
            R(this.a, S(this.a + size()));
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // ir.nasim.AbstractC19831r1
    public int f() {
        return this.c;
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[this.a];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        AbstractC11442d1.Companion.b(i, size());
        return this.b[S(this.a + i)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int iS = S(this.a + size());
        int length = this.a;
        if (length < iS) {
            while (length < iS) {
                if (AbstractC13042fc3.d(obj, this.b[length])) {
                    i = this.a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iS) {
            return -1;
        }
        int length2 = this.b.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iS; i2++) {
                    if (AbstractC13042fc3.d(obj, this.b[i2])) {
                        length = i2 + this.b.length;
                        i = this.a;
                    }
                }
                return -1;
            }
            if (AbstractC13042fc3.d(obj, this.b[length])) {
                i = this.a;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // ir.nasim.AbstractC19831r1
    public Object j(int i) {
        AbstractC11442d1.Companion.b(i, size());
        if (i == AbstractC10360bX0.o(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        V();
        int iS = S(this.a + i);
        Object obj = this.b[iS];
        if (i < (size() >> 1)) {
            int i2 = this.a;
            if (iS >= i2) {
                Object[] objArr = this.b;
                AbstractC9648aK.l(objArr, objArr, i2 + 1, i2, iS);
            } else {
                Object[] objArr2 = this.b;
                AbstractC9648aK.l(objArr2, objArr2, 1, 0, iS);
                Object[] objArr3 = this.b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.a;
                AbstractC9648aK.l(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.b;
            int i4 = this.a;
            objArr4[i4] = null;
            this.a = O(i4);
        } else {
            int iS2 = S(this.a + AbstractC10360bX0.o(this));
            if (iS <= iS2) {
                Object[] objArr5 = this.b;
                AbstractC9648aK.l(objArr5, objArr5, iS, iS + 1, iS2 + 1);
            } else {
                Object[] objArr6 = this.b;
                AbstractC9648aK.l(objArr6, objArr6, iS, iS + 1, objArr6.length);
                Object[] objArr7 = this.b;
                objArr7[objArr7.length - 1] = objArr7[0];
                AbstractC9648aK.l(objArr7, objArr7, 0, 1, iS2 + 1);
            }
            this.b[iS2] = null;
        }
        this.c = size() - 1;
        return obj;
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[S(this.a + AbstractC10360bX0.o(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iL0;
        int i;
        int iS = S(this.a + size());
        int i2 = this.a;
        if (i2 < iS) {
            iL0 = iS - 1;
            if (i2 <= iL0) {
                while (!AbstractC13042fc3.d(obj, this.b[iL0])) {
                    if (iL0 != i2) {
                        iL0--;
                    }
                }
                i = this.a;
                return iL0 - i;
            }
            return -1;
        }
        if (i2 > iS) {
            int i3 = iS - 1;
            while (true) {
                if (-1 >= i3) {
                    iL0 = AbstractC10242bK.l0(this.b);
                    int i4 = this.a;
                    if (i4 <= iL0) {
                        while (!AbstractC13042fc3.d(obj, this.b[iL0])) {
                            if (iL0 != i4) {
                                iL0--;
                            }
                        }
                        i = this.a;
                    }
                } else {
                    if (AbstractC13042fc3.d(obj, this.b[i3])) {
                        iL0 = i3 + this.b.length;
                        i = this.a;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int iS;
        AbstractC13042fc3.i(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iS2 = S(this.a + size());
            int i = this.a;
            if (i < iS2) {
                iS = i;
                while (i < iS2) {
                    Object obj = this.b[i];
                    if (!collection.contains(obj)) {
                        this.b[iS] = obj;
                        iS++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                AbstractC9648aK.v(this.b, null, iS, iS2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (!collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iS = S(i2);
                for (int i3 = 0; i3 < iS2; i3++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (!collection.contains(obj3)) {
                        this.b[iS] = obj3;
                        iS = O(iS);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                V();
                this.c = Q(iS - this.a);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        V();
        Object[] objArr = this.b;
        int i = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.a = O(i);
        this.c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        V();
        int iS = S(this.a + AbstractC10360bX0.o(this));
        Object[] objArr = this.b;
        Object obj = objArr[iS];
        objArr[iS] = null;
        this.c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        AbstractC11442d1.Companion.d(i, i2, size());
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == size()) {
            clear();
            return;
        }
        if (i3 == 1) {
            remove(i);
            return;
        }
        V();
        if (i < size() - i2) {
            Z(i, i2);
            int iS = S(this.a + i3);
            R(this.a, iS);
            this.a = iS;
        } else {
            a0(i, i2);
            int iS2 = S(this.a + size());
            R(Q(iS2 - i3), iS2);
        }
        this.c = size() - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int iS;
        AbstractC13042fc3.i(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iS2 = S(this.a + size());
            int i = this.a;
            if (i < iS2) {
                iS = i;
                while (i < iS2) {
                    Object obj = this.b[i];
                    if (collection.contains(obj)) {
                        this.b[iS] = obj;
                        iS++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                AbstractC9648aK.v(this.b, null, iS, iS2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iS = S(i2);
                for (int i3 = 0; i3 < iS2; i3++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.b[iS] = obj3;
                        iS = O(iS);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                V();
                this.c = Q(iS - this.a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        AbstractC11442d1.Companion.b(i, size());
        int iS = S(this.a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iS];
        objArr[iS] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        AbstractC13042fc3.i(objArr, "array");
        if (objArr.length < size()) {
            objArr = YJ.a(objArr, size());
        }
        int iS = S(this.a + size());
        int i = this.a;
        if (i < iS) {
            AbstractC9648aK.q(this.b, objArr, 0, i, iS, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.b;
            AbstractC9648aK.l(objArr2, objArr, 0, this.a, objArr2.length);
            Object[] objArr3 = this.b;
            AbstractC9648aK.l(objArr3, objArr, objArr3.length - this.a, 0, iS);
        }
        return AbstractC9766aX0.f(size(), objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        AbstractC11442d1.Companion.c(i, size());
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        V();
        L(size() + 1);
        int iS = S(this.a + i);
        if (i < ((size() + 1) >> 1)) {
            int iF = F(iS);
            int iF2 = F(this.a);
            int i2 = this.a;
            if (iF >= i2) {
                Object[] objArr = this.b;
                objArr[iF2] = objArr[i2];
                AbstractC9648aK.l(objArr, objArr, i2, i2 + 1, iF + 1);
            } else {
                Object[] objArr2 = this.b;
                AbstractC9648aK.l(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                Object[] objArr3 = this.b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC9648aK.l(objArr3, objArr3, 0, 1, iF + 1);
            }
            this.b[iF] = obj;
            this.a = iF2;
        } else {
            int iS2 = S(this.a + size());
            if (iS < iS2) {
                Object[] objArr4 = this.b;
                AbstractC9648aK.l(objArr4, objArr4, iS + 1, iS, iS2);
            } else {
                Object[] objArr5 = this.b;
                AbstractC9648aK.l(objArr5, objArr5, 1, 0, iS2);
                Object[] objArr6 = this.b;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC9648aK.l(objArr6, objArr6, iS + 1, iS, objArr6.length - 1);
            }
            this.b[iS] = obj;
        }
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        AbstractC11442d1.Companion.c(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        V();
        L(size() + collection.size());
        int iS = S(this.a + size());
        int iS2 = S(this.a + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.a;
            int length = i2 - size;
            if (iS2 < i2) {
                Object[] objArr = this.b;
                AbstractC9648aK.l(objArr, objArr, length, i2, objArr.length);
                if (size >= iS2) {
                    Object[] objArr2 = this.b;
                    AbstractC9648aK.l(objArr2, objArr2, objArr2.length - size, 0, iS2);
                } else {
                    Object[] objArr3 = this.b;
                    AbstractC9648aK.l(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.b;
                    AbstractC9648aK.l(objArr4, objArr4, 0, size, iS2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.b;
                AbstractC9648aK.l(objArr5, objArr5, length, i2, iS2);
            } else {
                Object[] objArr6 = this.b;
                length += objArr6.length;
                int i3 = iS2 - i2;
                int length2 = objArr6.length - length;
                if (length2 >= i3) {
                    AbstractC9648aK.l(objArr6, objArr6, length, i2, iS2);
                } else {
                    AbstractC9648aK.l(objArr6, objArr6, length, i2, i2 + length2);
                    Object[] objArr7 = this.b;
                    AbstractC9648aK.l(objArr7, objArr7, 0, this.a + length2, iS2);
                }
            }
            this.a = length;
            C(Q(iS2 - size), collection);
        } else {
            int i4 = iS2 + size;
            if (iS2 < iS) {
                int i5 = size + iS;
                Object[] objArr8 = this.b;
                if (i5 <= objArr8.length) {
                    AbstractC9648aK.l(objArr8, objArr8, i4, iS2, iS);
                } else if (i4 >= objArr8.length) {
                    AbstractC9648aK.l(objArr8, objArr8, i4 - objArr8.length, iS2, iS);
                } else {
                    int length3 = iS - (i5 - objArr8.length);
                    AbstractC9648aK.l(objArr8, objArr8, 0, length3, iS);
                    Object[] objArr9 = this.b;
                    AbstractC9648aK.l(objArr9, objArr9, i4, iS2, length3);
                }
            } else {
                Object[] objArr10 = this.b;
                AbstractC9648aK.l(objArr10, objArr10, size, 0, iS);
                Object[] objArr11 = this.b;
                if (i4 >= objArr11.length) {
                    AbstractC9648aK.l(objArr11, objArr11, i4 - objArr11.length, iS2, objArr11.length);
                } else {
                    AbstractC9648aK.l(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.b;
                    AbstractC9648aK.l(objArr12, objArr12, i4, iS2, objArr12.length - size);
                }
            }
            C(iS2, collection);
        }
        return true;
    }

    public BJ() {
        this.b = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
