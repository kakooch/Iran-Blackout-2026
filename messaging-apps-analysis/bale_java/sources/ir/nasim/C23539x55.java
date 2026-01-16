package ir.nasim;

import ir.nasim.InterfaceC19877r55;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: ir.nasim.x55, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23539x55 extends AbstractC19831r1 implements InterfaceC19877r55.a {
    private int a;
    private InterfaceC19877r55 b;
    private C9917am4 c;
    private Object[] d;
    private Object[] e;
    private int f;

    /* renamed from: ir.nasim.x55$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Collection e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Collection collection) {
            super(1);
            this.e = collection;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(this.e.contains(obj));
        }
    }

    public C23539x55(InterfaceC19877r55 interfaceC19877r55, Object[] objArr, Object[] objArr2, int i) {
        AbstractC13042fc3.i(interfaceC19877r55, "vector");
        AbstractC13042fc3.i(objArr2, "vectorTail");
        this.a = i;
        this.b = interfaceC19877r55;
        this.c = new C9917am4();
        this.d = objArr;
        this.e = objArr2;
        this.f = interfaceC19877r55.size();
    }

    private final int A0(int i) {
        return i <= 32 ? i : i - AbstractC23708xN7.c(i);
    }

    private final Object[] C(int i) {
        if (s0() <= i) {
            return this.e;
        }
        Object[] objArr = this.d;
        AbstractC13042fc3.f(objArr);
        for (int i2 = this.a; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[AbstractC23708xN7.a(i, i2)];
            AbstractC13042fc3.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] E(Object[] objArr, int i, Iterator it) {
        while (i < 32 && it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    private final void P(Collection collection, int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.d == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i4 = i >> 5;
        Object[] objArrW0 = w0(i4, i2, objArr, i3, objArr2);
        int iS0 = i3 - (((s0() >> 5) - 1) - i4);
        if (iS0 < i3) {
            objArr2 = objArr[iS0];
            AbstractC13042fc3.f(objArr2);
        }
        x0(collection, i, objArrW0, 32, objArr, iS0, objArr2);
    }

    private final Object[] Q(Object[] objArr, int i, int i2, Object obj, C24232yG4 c24232yG4) {
        Object obj2;
        int iA = AbstractC23708xN7.a(i2, i);
        if (i == 0) {
            c24232yG4.b(objArr[31]);
            Object[] objArrL = AbstractC9648aK.l(objArr, W(objArr), iA + 1, iA, 31);
            objArrL[iA] = obj;
            return objArrL;
        }
        Object[] objArrW = W(objArr);
        int i3 = i - 5;
        Object obj3 = objArrW[iA];
        AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrW[iA] = Q((Object[]) obj3, i3, i2, obj, c24232yG4);
        while (true) {
            iA++;
            if (iA >= 32 || (obj2 = objArrW[iA]) == null) {
                break;
            }
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrW[iA] = Q((Object[]) obj2, i3, 0, c24232yG4.a(), c24232yG4);
        }
        return objArrW;
    }

    private final void R(Object[] objArr, int i, Object obj) {
        int iY0 = y0();
        Object[] objArrW = W(this.e);
        if (iY0 < 32) {
            AbstractC9648aK.l(this.e, objArrW, i + 1, i, iY0);
            objArrW[i] = obj;
            u0(objArr);
            v0(objArrW);
            this.f = size() + 1;
            return;
        }
        Object[] objArr2 = this.e;
        Object obj2 = objArr2[31];
        AbstractC9648aK.l(objArr2, objArrW, i + 1, i, 31);
        objArrW[i] = obj;
        h0(objArr, objArrW, a0(obj2));
    }

    private final boolean S(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.c;
    }

    private final ListIterator V(int i) {
        if (this.d == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int iS0 = s0() >> 5;
        LB3.b(i, iS0);
        int i2 = this.a;
        if (i2 == 0) {
            Object[] objArr = this.d;
            AbstractC13042fc3.f(objArr);
            return new C19364qD6(objArr, i);
        }
        Object[] objArr2 = this.d;
        AbstractC13042fc3.f(objArr2);
        return new C11403cw7(objArr2, i, iS0, i2 / 5);
    }

    private final Object[] W(Object[] objArr) {
        return objArr == null ? Z() : S(objArr) ? objArr : AbstractC9648aK.q(objArr, Z(), 0, 0, AbstractC23053wG5.i(objArr.length, 32), 6, null);
    }

    private final Object[] Y(Object[] objArr, int i) {
        return S(objArr) ? AbstractC9648aK.l(objArr, objArr, i, 0, 32 - i) : AbstractC9648aK.l(objArr, Z(), i, 0, 32 - i);
    }

    private final Object[] Z() {
        Object[] objArr = new Object[33];
        objArr[32] = this.c;
        return objArr;
    }

    private final Object[] a0(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.c;
        return objArr;
    }

    private final Object[] b0(Object[] objArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i2 == 0) {
            return objArr;
        }
        int iA = AbstractC23708xN7.a(i, i2);
        Object obj = objArr[iA];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object objB0 = b0((Object[]) obj, i, i2 - 5);
        if (iA < 31) {
            int i3 = iA + 1;
            if (objArr[i3] != null) {
                if (S(objArr)) {
                    AbstractC9648aK.v(objArr, null, i3, 32);
                }
                objArr = AbstractC9648aK.l(objArr, Z(), 0, 0, i3);
            }
        }
        if (objB0 == objArr[iA]) {
            return objArr;
        }
        Object[] objArrW = W(objArr);
        objArrW[iA] = objB0;
        return objArrW;
    }

    private final Object[] c0(Object[] objArr, int i, int i2, C24232yG4 c24232yG4) {
        Object[] objArrC0;
        int iA = AbstractC23708xN7.a(i2 - 1, i);
        if (i == 5) {
            c24232yG4.b(objArr[iA]);
            objArrC0 = null;
        } else {
            Object obj = objArr[iA];
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrC0 = c0((Object[]) obj, i - 5, i2, c24232yG4);
        }
        if (objArrC0 == null && iA == 0) {
            return null;
        }
        Object[] objArrW = W(objArr);
        objArrW[iA] = objArrC0;
        return objArrW;
    }

    private final void d0(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            u0(null);
            if (objArr == null) {
                objArr = new Object[0];
            }
            v0(objArr);
            this.f = i;
            this.a = i2;
            return;
        }
        C24232yG4 c24232yG4 = new C24232yG4(null);
        AbstractC13042fc3.f(objArr);
        Object[] objArrC0 = c0(objArr, i2, i, c24232yG4);
        AbstractC13042fc3.f(objArrC0);
        Object objA = c24232yG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        v0((Object[]) objA);
        this.f = i;
        if (objArrC0[1] == null) {
            u0((Object[]) objArrC0[0]);
            this.a = i2 - 5;
        } else {
            u0(objArrC0);
            this.a = i2;
        }
    }

    private final Object[] f0(Object[] objArr, int i, int i2, Iterator it) {
        if (!it.hasNext()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i2 < 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i2 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrW = W(objArr);
        int iA = AbstractC23708xN7.a(i, i2);
        int i3 = i2 - 5;
        objArrW[iA] = f0((Object[]) objArrW[iA], i, i3, it);
        while (true) {
            iA++;
            if (iA >= 32 || !it.hasNext()) {
                break;
            }
            objArrW[iA] = f0((Object[]) objArrW[iA], 0, i3, it);
        }
        return objArrW;
    }

    private final Object[] g0(Object[] objArr, int i, Object[][] objArr2) {
        Iterator itA = DJ.a(objArr2);
        int i2 = i >> 5;
        int i3 = this.a;
        Object[] objArrF0 = i2 < (1 << i3) ? f0(objArr, i, i3, itA) : W(objArr);
        while (itA.hasNext()) {
            this.a += 5;
            objArrF0 = a0(objArrF0);
            int i4 = this.a;
            f0(objArrF0, 1 << i4, i4, itA);
        }
        return objArrF0;
    }

    private final void h0(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i = this.a;
        if (size > (1 << i)) {
            u0(i0(a0(objArr), objArr2, this.a + 5));
            v0(objArr3);
            this.a += 5;
            this.f = size() + 1;
            return;
        }
        if (objArr == null) {
            u0(objArr2);
            v0(objArr3);
            this.f = size() + 1;
        } else {
            u0(i0(objArr, objArr2, i));
            v0(objArr3);
            this.f = size() + 1;
        }
    }

    private final Object[] i0(Object[] objArr, Object[] objArr2, int i) {
        int iA = AbstractC23708xN7.a(size() - 1, i);
        Object[] objArrW = W(objArr);
        if (i == 5) {
            objArrW[iA] = objArr2;
        } else {
            objArrW[iA] = i0((Object[]) objArrW[iA], objArr2, i - 5);
        }
        return objArrW;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int j0(UA2 ua2, Object[] objArr, int i, int i2, C24232yG4 c24232yG4, List list, List list2) {
        if (S(objArr)) {
            list.add(objArr);
        }
        Object objA = c24232yG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) objA;
        Object[] objArrZ = objArr2;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (!((Boolean) ua2.invoke(obj)).booleanValue()) {
                if (i2 == 32) {
                    objArrZ = list.isEmpty() ^ true ? (Object[]) list.remove(list.size() - 1) : Z();
                    i2 = 0;
                }
                objArrZ[i2] = obj;
                i2++;
            }
        }
        c24232yG4.b(objArrZ);
        if (objArr2 != c24232yG4.a()) {
            list2.add(objArr2);
        }
        return i2;
    }

    private final int k0(UA2 ua2, Object[] objArr, int i, C24232yG4 c24232yG4) {
        Object[] objArrW = objArr;
        int i2 = i;
        boolean z = false;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (((Boolean) ua2.invoke(obj)).booleanValue()) {
                if (!z) {
                    objArrW = W(objArr);
                    z = true;
                    i2 = i3;
                }
            } else if (z) {
                objArrW[i2] = obj;
                i2++;
            }
        }
        c24232yG4.b(objArrW);
        return i2;
    }

    private final boolean l0(UA2 ua2) {
        Object[] objArrF0;
        int iY0 = y0();
        C24232yG4 c24232yG4 = new C24232yG4(null);
        if (this.d == null) {
            return n0(ua2, iY0, c24232yG4) != iY0;
        }
        ListIterator listIteratorV = V(0);
        int iK0 = 32;
        while (iK0 == 32 && listIteratorV.hasNext()) {
            iK0 = k0(ua2, (Object[]) listIteratorV.next(), 32, c24232yG4);
        }
        if (iK0 == 32) {
            WZ0.a(!listIteratorV.hasNext());
            int iN0 = n0(ua2, iY0, c24232yG4);
            if (iN0 == 0) {
                d0(this.d, size(), this.a);
            }
            return iN0 != iY0;
        }
        int iPreviousIndex = listIteratorV.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iJ0 = iK0;
        while (listIteratorV.hasNext()) {
            iJ0 = j0(ua2, (Object[]) listIteratorV.next(), 32, iJ0, c24232yG4, arrayList2, arrayList);
            iPreviousIndex = iPreviousIndex;
        }
        int i = iPreviousIndex;
        int iJ02 = j0(ua2, this.e, iY0, iJ0, c24232yG4, arrayList2, arrayList);
        Object objA = c24232yG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) objA;
        AbstractC9648aK.v(objArr, null, iJ02, 32);
        if (arrayList.isEmpty()) {
            objArrF0 = this.d;
            AbstractC13042fc3.f(objArrF0);
        } else {
            objArrF0 = f0(this.d, i, this.a, arrayList.iterator());
        }
        int size = i + (arrayList.size() << 5);
        u0(r0(objArrF0, size));
        v0(objArr);
        this.f = size + iJ02;
        return true;
    }

    private final int n0(UA2 ua2, int i, C24232yG4 c24232yG4) {
        int iK0 = k0(ua2, this.e, i, c24232yG4);
        if (iK0 == i) {
            WZ0.a(c24232yG4.a() == this.e);
            return i;
        }
        Object objA = c24232yG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) objA;
        AbstractC9648aK.v(objArr, null, iK0, i);
        v0(objArr);
        this.f = size() - (i - iK0);
        return iK0;
    }

    private final Object[] p0(Object[] objArr, int i, int i2, C24232yG4 c24232yG4) {
        int iA = AbstractC23708xN7.a(i2, i);
        if (i == 0) {
            Object obj = objArr[iA];
            Object[] objArrL = AbstractC9648aK.l(objArr, W(objArr), iA, iA + 1, 32);
            objArrL[31] = c24232yG4.a();
            c24232yG4.b(obj);
            return objArrL;
        }
        int iA2 = objArr[31] == null ? AbstractC23708xN7.a(s0() - 1, i) : 31;
        Object[] objArrW = W(objArr);
        int i3 = i - 5;
        int i4 = iA + 1;
        if (i4 <= iA2) {
            while (true) {
                Object obj2 = objArrW[iA2];
                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrW[iA2] = p0((Object[]) obj2, i3, 0, c24232yG4);
                if (iA2 == i4) {
                    break;
                }
                iA2--;
            }
        }
        Object obj3 = objArrW[iA];
        AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrW[iA] = p0((Object[]) obj3, i3, i2, c24232yG4);
        return objArrW;
    }

    private final Object q0(Object[] objArr, int i, int i2, int i3) {
        int size = size() - i;
        WZ0.a(i3 < size);
        if (size == 1) {
            Object obj = this.e[0];
            d0(objArr, i, i2);
            return obj;
        }
        Object[] objArr2 = this.e;
        Object obj2 = objArr2[i3];
        Object[] objArrL = AbstractC9648aK.l(objArr2, W(objArr2), i3, i3 + 1, size);
        objArrL[size - 1] = null;
        u0(objArr);
        v0(objArrL);
        this.f = (i + size) - 1;
        this.a = i2;
        return obj2;
    }

    private final Object[] r0(Object[] objArr, int i) {
        if ((i & 31) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i == 0) {
            this.a = 0;
            return null;
        }
        int i2 = i - 1;
        while (true) {
            int i3 = this.a;
            if ((i2 >> i3) != 0) {
                return b0(objArr, i2, i3);
            }
            this.a = i3 - 5;
            Object[] objArr2 = objArr[0];
            AbstractC13042fc3.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
    }

    private final int s0() {
        if (size() <= 32) {
            return 0;
        }
        return AbstractC23708xN7.c(size());
    }

    private final Object[] t0(Object[] objArr, int i, int i2, Object obj, C24232yG4 c24232yG4) {
        int iA = AbstractC23708xN7.a(i2, i);
        Object[] objArrW = W(objArr);
        if (i != 0) {
            Object obj2 = objArrW[iA];
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrW[iA] = t0((Object[]) obj2, i - 5, i2, obj, c24232yG4);
            return objArrW;
        }
        if (objArrW != objArr) {
            ((AbstractList) this).modCount++;
        }
        c24232yG4.b(objArrW[iA]);
        objArrW[iA] = obj;
        return objArrW;
    }

    private final void u0(Object[] objArr) {
        if (objArr != this.d) {
            this.b = null;
            this.d = objArr;
        }
    }

    private final void v0(Object[] objArr) {
        if (objArr != this.e) {
            this.b = null;
            this.e = objArr;
        }
    }

    private final Object[] w0(int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.d == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ListIterator listIteratorV = V(s0() >> 5);
        while (listIteratorV.previousIndex() != i) {
            Object[] objArr3 = (Object[]) listIteratorV.previous();
            AbstractC9648aK.l(objArr3, objArr2, 0, 32 - i2, 32);
            objArr2 = Y(objArr3, i2);
            i3--;
            objArr[i3] = objArr2;
        }
        return (Object[]) listIteratorV.previous();
    }

    private final void x0(Collection collection, int i, Object[] objArr, int i2, Object[][] objArr2, int i3, Object[] objArr3) {
        Object[] objArrZ;
        if (i3 < 1) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Object[] objArrW = W(objArr);
        objArr2[0] = objArrW;
        int i4 = i & 31;
        int size = ((i + collection.size()) - 1) & 31;
        int i5 = (i2 - i4) + size;
        if (i5 < 32) {
            AbstractC9648aK.l(objArrW, objArr3, size + 1, i4, i2);
        } else {
            int i6 = i5 - 31;
            if (i3 == 1) {
                objArrZ = objArrW;
            } else {
                objArrZ = Z();
                i3--;
                objArr2[i3] = objArrZ;
            }
            int i7 = i2 - i6;
            AbstractC9648aK.l(objArrW, objArr3, 0, i7, i2);
            AbstractC9648aK.l(objArrW, objArrZ, size + 1, i4, i7);
            objArr3 = objArrZ;
        }
        Iterator it = collection.iterator();
        E(objArrW, i4, it);
        for (int i8 = 1; i8 < i3; i8++) {
            objArr2[i8] = E(Z(), 0, it);
        }
        E(objArr3, 0, it);
    }

    private final int y0() {
        return A0(size());
    }

    public final int F() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] L() {
        return this.d;
    }

    public final int N() {
        return this.a;
    }

    public final Object[] O() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC19877r55.a
    public InterfaceC19877r55 a() {
        InterfaceC19877r55 c22353v55 = this.b;
        if (c22353v55 == null) {
            Object[] objArr = this.d;
            Object[] objArr2 = this.e;
            this.c = new C9917am4();
            if (objArr != null) {
                c22353v55 = new C22353v55(objArr, objArr2, size(), this.a);
            } else if (objArr2.length == 0) {
                c22353v55 = AbstractC23708xN7.b();
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, size());
                AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
                c22353v55 = new BE6(objArrCopyOf);
            }
            this.b = c22353v55;
        }
        return c22353v55;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iY0 = y0();
        if (iY0 < 32) {
            Object[] objArrW = W(this.e);
            objArrW[iY0] = obj;
            v0(objArrW);
            this.f = size() + 1;
        } else {
            h0(this.d, this.e, a0(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iY0 = y0();
        Iterator it = collection.iterator();
        if (32 - iY0 >= collection.size()) {
            v0(E(W(this.e), iY0, it));
            this.f = size() + collection.size();
        } else {
            int size = ((collection.size() + iY0) - 1) / 32;
            Object[][] objArr = new Object[size][];
            objArr[0] = E(W(this.e), iY0, it);
            for (int i = 1; i < size; i++) {
                objArr[i] = E(Z(), 0, it);
            }
            u0(g0(this.d, s0(), objArr));
            v0(E(Z(), 0, it));
            this.f = size() + collection.size();
        }
        return true;
    }

    @Override // ir.nasim.AbstractC19831r1
    public int f() {
        return this.f;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        LB3.a(i, size());
        return C(i)[i & 31];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    @Override // ir.nasim.AbstractC19831r1
    public Object j(int i) {
        LB3.a(i, size());
        ((AbstractList) this).modCount++;
        int iS0 = s0();
        if (i >= iS0) {
            return q0(this.d, iS0, this.a, i - iS0);
        }
        C24232yG4 c24232yG4 = new C24232yG4(this.e[0]);
        Object[] objArr = this.d;
        AbstractC13042fc3.f(objArr);
        q0(p0(objArr, this.a, i, c24232yG4), iS0, this.a, 0);
        return c24232yG4.a();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    public final boolean o0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "predicate");
        boolean zL0 = l0(ua2);
        if (zL0) {
            ((AbstractList) this).modCount++;
        }
        return zL0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        return o0(new a(collection));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        LB3.a(i, size());
        if (s0() > i) {
            C24232yG4 c24232yG4 = new C24232yG4(null);
            Object[] objArr = this.d;
            AbstractC13042fc3.f(objArr);
            u0(t0(objArr, this.a, i, obj, c24232yG4));
            return c24232yG4.a();
        }
        Object[] objArrW = W(this.e);
        if (objArrW != this.e) {
            ((AbstractList) this).modCount++;
        }
        int i2 = i & 31;
        Object obj2 = objArrW[i2];
        objArrW[i2] = obj;
        v0(objArrW);
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        LB3.b(i, size());
        return new B55(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        LB3.b(i, size());
        if (i == size()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iS0 = s0();
        if (i >= iS0) {
            R(this.d, i - iS0, obj);
            return;
        }
        C24232yG4 c24232yG4 = new C24232yG4(null);
        Object[] objArr = this.d;
        AbstractC13042fc3.f(objArr);
        R(Q(objArr, this.a, i, obj, c24232yG4), 0, c24232yG4.a());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        Object[] objArrL;
        AbstractC13042fc3.i(collection, "elements");
        LB3.b(i, size());
        if (i == size()) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i2 = (i >> 5) << 5;
        int size = (((size() - i2) + collection.size()) - 1) / 32;
        if (size == 0) {
            WZ0.a(i >= s0());
            int i3 = i & 31;
            int size2 = ((i + collection.size()) - 1) & 31;
            Object[] objArr = this.e;
            Object[] objArrL2 = AbstractC9648aK.l(objArr, W(objArr), size2 + 1, i3, y0());
            E(objArrL2, i3, collection.iterator());
            v0(objArrL2);
            this.f = size() + collection.size();
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iY0 = y0();
        int iA0 = A0(size() + collection.size());
        if (i >= s0()) {
            objArrL = Z();
            x0(collection, i, this.e, iY0, objArr2, size, objArrL);
        } else if (iA0 <= iY0) {
            int i4 = iY0 - iA0;
            objArrL = AbstractC9648aK.l(this.e, Z(), 0, i4, iY0);
            int i5 = 32 - i4;
            Object[] objArrY = Y(this.e, i5);
            int i6 = size - 1;
            objArr2[i6] = objArrY;
            P(collection, i, i5, objArr2, i6, objArrY);
        } else {
            int i7 = iA0 - iY0;
            objArrL = Y(this.e, i7);
            P(collection, i, i7, objArr2, size, objArrL);
        }
        u0(g0(this.d, i2, objArr2));
        v0(objArrL);
        this.f = size() + collection.size();
        return true;
    }
}
