package ir.nasim;

import ir.nasim.Z33;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: ir.nasim.i43, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14535i43 extends Z33 implements Set {
    private transient AbstractC12710f43 b;

    /* renamed from: ir.nasim.i43$a */
    public static class a extends Z33.a {
        Object[] d;
        private int e;

        a(int i) {
            super(i);
            this.d = new Object[AbstractC14535i43.N(i)];
        }

        private void h(Object obj) {
            Objects.requireNonNull(this.d);
            int length = this.d.length - 1;
            int iHashCode = obj.hashCode();
            int iB = BU2.b(iHashCode);
            while (true) {
                int i = iB & length;
                Object[] objArr = this.d;
                Object obj2 = objArr[i];
                if (obj2 == null) {
                    objArr[i] = obj;
                    this.e += iHashCode;
                    super.d(obj);
                    return;
                } else if (obj2.equals(obj)) {
                    return;
                } else {
                    iB = i + 1;
                }
            }
        }

        @Override // ir.nasim.Z33.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            AbstractC4029Dj5.j(obj);
            if (this.d != null && AbstractC14535i43.N(this.b) <= this.d.length) {
                h(obj);
                return this;
            }
            this.d = null;
            super.d(obj);
            return this;
        }

        public a g(Iterable iterable) {
            AbstractC4029Dj5.j(iterable);
            if (this.d != null) {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            } else {
                super.b(iterable);
            }
            return this;
        }

        public AbstractC14535i43 i() {
            AbstractC14535i43 abstractC14535i43O;
            int i = this.b;
            if (i == 0) {
                return AbstractC14535i43.W();
            }
            if (i == 1) {
                Object obj = this.a[0];
                Objects.requireNonNull(obj);
                return AbstractC14535i43.Y(obj);
            }
            if (this.d == null || AbstractC14535i43.N(i) != this.d.length) {
                abstractC14535i43O = AbstractC14535i43.O(this.b, this.a);
                this.b = abstractC14535i43O.size();
            } else {
                Object[] objArrCopyOf = AbstractC14535i43.d0(this.b, this.a.length) ? Arrays.copyOf(this.a, this.b) : this.a;
                abstractC14535i43O = new FM5(objArrCopyOf, this.e, this.d, r5.length - 1, this.b);
            }
            this.c = true;
            this.d = null;
            return abstractC14535i43O;
        }
    }

    AbstractC14535i43() {
    }

    public static a L(int i) {
        MW0.b(i, "expectedSize");
        return new a(i);
    }

    static int N(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            AbstractC4029Dj5.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AbstractC14535i43 O(int i, Object... objArr) {
        if (i == 0) {
            return W();
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return Y(obj);
        }
        int iN = N(i);
        Object[] objArr2 = new Object[iN];
        int i2 = iN - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object objA = AbstractC16434lG4.a(objArr[i5], i5);
            int iHashCode = objA.hashCode();
            int iB = BU2.b(iHashCode);
            while (true) {
                int i6 = iB & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = objA;
                    objArr2[i6] = objA;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new HD6(obj3);
        }
        if (N(i4) < iN / 2) {
            return O(i4, objArr);
        }
        if (d0(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new FM5(objArr, i3, objArr2, i2, i4);
    }

    public static AbstractC14535i43 P(Collection collection) {
        if ((collection instanceof AbstractC14535i43) && !(collection instanceof SortedSet)) {
            AbstractC14535i43 abstractC14535i43 = (AbstractC14535i43) collection;
            if (!abstractC14535i43.D()) {
                return abstractC14535i43;
            }
        }
        Object[] array = collection.toArray();
        return O(array.length, array);
    }

    public static AbstractC14535i43 Q(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? O(objArr.length, (Object[]) objArr.clone()) : Y(objArr[0]) : W();
    }

    public static AbstractC14535i43 W() {
        return FM5.i;
    }

    public static AbstractC14535i43 Y(Object obj) {
        return new HD6(obj);
    }

    public static AbstractC14535i43 Z(Object obj, Object obj2) {
        return O(2, obj, obj2);
    }

    public static AbstractC14535i43 a0(Object obj, Object obj2, Object obj3) {
        return O(3, obj, obj2, obj3);
    }

    public static AbstractC14535i43 b0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return O(5, obj, obj2, obj3, obj4, obj5);
    }

    public static AbstractC14535i43 c0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        AbstractC4029Dj5.e(objArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return O(length, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d0(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    AbstractC12710f43 R() {
        return AbstractC12710f43.E(toArray());
    }

    boolean S() {
        return false;
    }

    /* renamed from: V */
    public abstract DB7 iterator();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC14535i43) && S() && ((AbstractC14535i43) obj).S() && hashCode() != obj.hashCode()) {
            return false;
        }
        return AbstractC3895Cu6.a(this, obj);
    }

    @Override // ir.nasim.Z33
    public AbstractC12710f43 f() {
        AbstractC12710f43 abstractC12710f43 = this.b;
        if (abstractC12710f43 != null) {
            return abstractC12710f43;
        }
        AbstractC12710f43 abstractC12710f43R = R();
        this.b = abstractC12710f43R;
        return abstractC12710f43R;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return AbstractC3895Cu6.d(this);
    }
}
