package ir.nasim;

import ir.nasim.InterfaceC19286q55;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: ir.nasim.y55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24129y55 extends AbstractC19831r1 implements InterfaceC19286q55.a {
    private InterfaceC19286q55 a;
    private Object[] b;
    private Object[] c;
    private int d;
    private C10537bm4 e = new C10537bm4();
    private Object[] f;
    private Object[] g;
    private int h;

    /* renamed from: ir.nasim.y55$a */
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

    public C24129y55(InterfaceC19286q55 interfaceC19286q55, Object[] objArr, Object[] objArr2, int i) {
        this.a = interfaceC19286q55;
        this.b = objArr;
        this.c = objArr2;
        this.d = i;
        this.f = this.b;
        this.g = this.c;
        this.h = this.a.size();
    }

    private final Object[] C(int i) {
        if (s0() <= i) {
            return this.g;
        }
        Object[] objArr = this.f;
        AbstractC13042fc3.f(objArr);
        for (int i2 = this.d; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[AbstractC24298yN7.a(i, i2)];
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
        if (this.f == null) {
            throw new IllegalStateException("root is null".toString());
        }
        int i4 = i >> 5;
        Object[] objArrU0 = u0(i4, i2, objArr, i3, objArr2);
        int iS0 = i3 - (((s0() >> 5) - 1) - i4);
        if (iS0 < i3) {
            objArr2 = objArr[iS0];
            AbstractC13042fc3.f(objArr2);
        }
        v0(collection, i, objArrU0, 32, objArr, iS0, objArr2);
    }

    private final Object[] Q(Object[] objArr, int i, int i2, Object obj, C24826zG4 c24826zG4) {
        Object obj2;
        int iA = AbstractC24298yN7.a(i2, i);
        if (i == 0) {
            c24826zG4.b(objArr[31]);
            Object[] objArrL = AbstractC9648aK.l(objArr, W(objArr), iA + 1, iA, 31);
            objArrL[iA] = obj;
            return objArrL;
        }
        Object[] objArrW = W(objArr);
        int i3 = i - 5;
        Object obj3 = objArrW[iA];
        AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrW[iA] = Q((Object[]) obj3, i3, i2, obj, c24826zG4);
        while (true) {
            iA++;
            if (iA >= 32 || (obj2 = objArrW[iA]) == null) {
                break;
            }
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrW[iA] = Q((Object[]) obj2, i3, 0, c24826zG4.a(), c24826zG4);
        }
        return objArrW;
    }

    private final void R(Object[] objArr, int i, Object obj) {
        int iW0 = w0();
        Object[] objArrW = W(this.g);
        if (iW0 < 32) {
            AbstractC9648aK.l(this.g, objArrW, i + 1, i, iW0);
            objArrW[i] = obj;
            this.f = objArr;
            this.g = objArrW;
            this.h = size() + 1;
            return;
        }
        Object[] objArr2 = this.g;
        Object obj2 = objArr2[31];
        AbstractC9648aK.l(objArr2, objArrW, i + 1, i, 31);
        objArrW[i] = obj;
        h0(objArr, objArrW, a0(obj2));
    }

    private final boolean S(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.e;
    }

    private final ListIterator V(int i) {
        Object[] objArr = this.f;
        if (objArr == null) {
            throw new IllegalStateException("Invalid root".toString());
        }
        int iS0 = s0() >> 5;
        MB3.b(i, iS0);
        int i2 = this.d;
        return i2 == 0 ? new C19955rD6(objArr, i) : new C12046dw7(objArr, i, iS0, i2 / 5);
    }

    private final Object[] W(Object[] objArr) {
        return objArr == null ? Z() : S(objArr) ? objArr : AbstractC9648aK.q(objArr, Z(), 0, 0, AbstractC23053wG5.i(objArr.length, 32), 6, null);
    }

    private final Object[] Y(Object[] objArr, int i) {
        return S(objArr) ? AbstractC9648aK.l(objArr, objArr, i, 0, 32 - i) : AbstractC9648aK.l(objArr, Z(), i, 0, 32 - i);
    }

    private final Object[] Z() {
        Object[] objArr = new Object[33];
        objArr[32] = this.e;
        return objArr;
    }

    private final Object[] a0(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.e;
        return objArr;
    }

    private final Object[] b0(Object[] objArr, int i, int i2) {
        if (!(i2 >= 0)) {
            AbstractC5214Ij5.a("shift should be positive");
        }
        if (i2 == 0) {
            return objArr;
        }
        int iA = AbstractC24298yN7.a(i, i2);
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

    private final Object[] c0(Object[] objArr, int i, int i2, C24826zG4 c24826zG4) {
        Object[] objArrC0;
        int iA = AbstractC24298yN7.a(i2 - 1, i);
        if (i == 5) {
            c24826zG4.b(objArr[iA]);
            objArrC0 = null;
        } else {
            Object obj = objArr[iA];
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrC0 = c0((Object[]) obj, i - 5, i2, c24826zG4);
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
            this.f = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.g = objArr;
            this.h = i;
            this.d = i2;
            return;
        }
        C24826zG4 c24826zG4 = new C24826zG4(null);
        AbstractC13042fc3.f(objArr);
        Object[] objArrC0 = c0(objArr, i2, i, c24826zG4);
        AbstractC13042fc3.f(objArrC0);
        Object objA = c24826zG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.g = (Object[]) objA;
        this.h = i;
        if (objArrC0[1] == null) {
            this.f = (Object[]) objArrC0[0];
            this.d = i2 - 5;
        } else {
            this.f = objArrC0;
            this.d = i2;
        }
    }

    private final Object[] f0(Object[] objArr, int i, int i2, Iterator it) {
        if (!it.hasNext()) {
            AbstractC5214Ij5.a("invalid buffersIterator");
        }
        if (!(i2 >= 0)) {
            AbstractC5214Ij5.a("negative shift");
        }
        if (i2 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrW = W(objArr);
        int iA = AbstractC24298yN7.a(i, i2);
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
        int i3 = this.d;
        Object[] objArrF0 = i2 < (1 << i3) ? f0(objArr, i, i3, itA) : W(objArr);
        while (itA.hasNext()) {
            this.d += 5;
            objArrF0 = a0(objArrF0);
            int i4 = this.d;
            f0(objArrF0, 1 << i4, i4, itA);
        }
        return objArrF0;
    }

    private final void h0(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i = this.d;
        if (size > (1 << i)) {
            this.f = i0(a0(objArr), objArr2, this.d + 5);
            this.g = objArr3;
            this.d += 5;
            this.h = size() + 1;
            return;
        }
        if (objArr == null) {
            this.f = objArr2;
            this.g = objArr3;
            this.h = size() + 1;
        } else {
            this.f = i0(objArr, objArr2, i);
            this.g = objArr3;
            this.h = size() + 1;
        }
    }

    private final Object[] i0(Object[] objArr, Object[] objArr2, int i) {
        int iA = AbstractC24298yN7.a(size() - 1, i);
        Object[] objArrW = W(objArr);
        if (i == 5) {
            objArrW[iA] = objArr2;
        } else {
            objArrW[iA] = i0((Object[]) objArrW[iA], objArr2, i - 5);
        }
        return objArrW;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int j0(UA2 ua2, Object[] objArr, int i, int i2, C24826zG4 c24826zG4, List list, List list2) {
        if (S(objArr)) {
            list.add(objArr);
        }
        Object objA = c24826zG4.a();
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
        c24826zG4.b(objArrZ);
        if (objArr2 != c24826zG4.a()) {
            list2.add(objArr2);
        }
        return i2;
    }

    private final int k0(UA2 ua2, Object[] objArr, int i, C24826zG4 c24826zG4) {
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
        c24826zG4.b(objArrW);
        return i2;
    }

    private final boolean l0(UA2 ua2) {
        Object[] objArrF0;
        int iW0 = w0();
        C24826zG4 c24826zG4 = new C24826zG4(null);
        if (this.f == null) {
            return n0(ua2, iW0, c24826zG4) != iW0;
        }
        ListIterator listIteratorV = V(0);
        int iK0 = 32;
        while (iK0 == 32 && listIteratorV.hasNext()) {
            iK0 = k0(ua2, (Object[]) listIteratorV.next(), 32, c24826zG4);
        }
        if (iK0 == 32) {
            XZ0.a(!listIteratorV.hasNext());
            int iN0 = n0(ua2, iW0, c24826zG4);
            if (iN0 == 0) {
                d0(this.f, size(), this.d);
            }
            return iN0 != iW0;
        }
        int iPreviousIndex = listIteratorV.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iJ0 = iK0;
        while (listIteratorV.hasNext()) {
            iJ0 = j0(ua2, (Object[]) listIteratorV.next(), 32, iJ0, c24826zG4, arrayList2, arrayList);
            iPreviousIndex = iPreviousIndex;
        }
        int i = iPreviousIndex;
        int iJ02 = j0(ua2, this.g, iW0, iJ0, c24826zG4, arrayList2, arrayList);
        Object objA = c24826zG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) objA;
        AbstractC9648aK.v(objArr, null, iJ02, 32);
        if (arrayList.isEmpty()) {
            objArrF0 = this.f;
            AbstractC13042fc3.f(objArrF0);
        } else {
            objArrF0 = f0(this.f, i, this.d, arrayList.iterator());
        }
        int size = i + (arrayList.size() << 5);
        this.f = r0(objArrF0, size);
        this.g = objArr;
        this.h = size + iJ02;
        return true;
    }

    private final int n0(UA2 ua2, int i, C24826zG4 c24826zG4) {
        int iK0 = k0(ua2, this.g, i, c24826zG4);
        if (iK0 == i) {
            XZ0.a(c24826zG4.a() == this.g);
            return i;
        }
        Object objA = c24826zG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) objA;
        AbstractC9648aK.v(objArr, null, iK0, i);
        this.g = objArr;
        this.h = size() - (i - iK0);
        return iK0;
    }

    private final Object[] p0(Object[] objArr, int i, int i2, C24826zG4 c24826zG4) {
        int iA = AbstractC24298yN7.a(i2, i);
        if (i == 0) {
            Object obj = objArr[iA];
            Object[] objArrL = AbstractC9648aK.l(objArr, W(objArr), iA, iA + 1, 32);
            objArrL[31] = c24826zG4.a();
            c24826zG4.b(obj);
            return objArrL;
        }
        int iA2 = objArr[31] == null ? AbstractC24298yN7.a(s0() - 1, i) : 31;
        Object[] objArrW = W(objArr);
        int i3 = i - 5;
        int i4 = iA + 1;
        if (i4 <= iA2) {
            while (true) {
                Object obj2 = objArrW[iA2];
                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrW[iA2] = p0((Object[]) obj2, i3, 0, c24826zG4);
                if (iA2 == i4) {
                    break;
                }
                iA2--;
            }
        }
        Object obj3 = objArrW[iA];
        AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrW[iA] = p0((Object[]) obj3, i3, i2, c24826zG4);
        return objArrW;
    }

    private final Object q0(Object[] objArr, int i, int i2, int i3) {
        int size = size() - i;
        XZ0.a(i3 < size);
        if (size == 1) {
            Object obj = this.g[0];
            d0(objArr, i, i2);
            return obj;
        }
        Object[] objArr2 = this.g;
        Object obj2 = objArr2[i3];
        Object[] objArrL = AbstractC9648aK.l(objArr2, W(objArr2), i3, i3 + 1, size);
        objArrL[size - 1] = null;
        this.f = objArr;
        this.g = objArrL;
        this.h = (i + size) - 1;
        this.d = i2;
        return obj2;
    }

    private final Object[] r0(Object[] objArr, int i) {
        if (!((i & 31) == 0)) {
            AbstractC5214Ij5.a("invalid size");
        }
        if (i == 0) {
            this.d = 0;
            return null;
        }
        int i2 = i - 1;
        while (true) {
            int i3 = this.d;
            if ((i2 >> i3) != 0) {
                return b0(objArr, i2, i3);
            }
            this.d = i3 - 5;
            Object[] objArr2 = objArr[0];
            AbstractC13042fc3.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
    }

    private final int s0() {
        if (size() <= 32) {
            return 0;
        }
        return AbstractC24298yN7.d(size());
    }

    private final Object[] t0(Object[] objArr, int i, int i2, Object obj, C24826zG4 c24826zG4) {
        int iA = AbstractC24298yN7.a(i2, i);
        Object[] objArrW = W(objArr);
        if (i != 0) {
            Object obj2 = objArrW[iA];
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrW[iA] = t0((Object[]) obj2, i - 5, i2, obj, c24826zG4);
            return objArrW;
        }
        if (objArrW != objArr) {
            ((AbstractList) this).modCount++;
        }
        c24826zG4.b(objArrW[iA]);
        objArrW[iA] = obj;
        return objArrW;
    }

    private final Object[] u0(int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.f == null) {
            throw new IllegalStateException("root is null".toString());
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

    private final void v0(Collection collection, int i, Object[] objArr, int i2, Object[][] objArr2, int i3, Object[] objArr3) {
        Object[] objArrZ;
        if (!(i3 >= 1)) {
            AbstractC5214Ij5.a("requires at least one nullBuffer");
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

    private final int w0() {
        return x0(size());
    }

    private final int x0(int i) {
        return i <= 32 ? i : i - AbstractC24298yN7.d(i);
    }

    public final int F() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] L() {
        return this.f;
    }

    public final int N() {
        return this.d;
    }

    public final Object[] O() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC19286q55.a
    public InterfaceC19286q55 a() {
        InterfaceC19286q55 c22949w55;
        if (this.f == this.b && this.g == this.c) {
            c22949w55 = this.a;
        } else {
            this.e = new C10537bm4();
            Object[] objArr = this.f;
            this.b = objArr;
            Object[] objArr2 = this.g;
            this.c = objArr2;
            if (objArr != null) {
                Object[] objArr3 = this.f;
                AbstractC13042fc3.f(objArr3);
                c22949w55 = new C22949w55(objArr3, this.g, size(), this.d);
            } else if (objArr2.length == 0) {
                c22949w55 = AbstractC24298yN7.b();
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(this.g, size());
                AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
                c22949w55 = new AE6(objArrCopyOf);
            }
        }
        this.a = c22949w55;
        return c22949w55;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iW0 = w0();
        if (iW0 < 32) {
            Object[] objArrW = W(this.g);
            objArrW[iW0] = obj;
            this.g = objArrW;
            this.h = size() + 1;
        } else {
            h0(this.f, this.g, a0(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iW0 = w0();
        Iterator it = collection.iterator();
        if (32 - iW0 >= collection.size()) {
            this.g = E(W(this.g), iW0, it);
            this.h = size() + collection.size();
        } else {
            int size = ((collection.size() + iW0) - 1) / 32;
            Object[][] objArr = new Object[size][];
            objArr[0] = E(W(this.g), iW0, it);
            for (int i = 1; i < size; i++) {
                objArr[i] = E(Z(), 0, it);
            }
            this.f = g0(this.f, s0(), objArr);
            this.g = E(Z(), 0, it);
            this.h = size() + collection.size();
        }
        return true;
    }

    @Override // ir.nasim.AbstractC19831r1
    public int f() {
        return this.h;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        MB3.a(i, size());
        return C(i)[i & 31];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    @Override // ir.nasim.AbstractC19831r1
    public Object j(int i) {
        MB3.a(i, size());
        ((AbstractList) this).modCount++;
        int iS0 = s0();
        if (i >= iS0) {
            return q0(this.f, iS0, this.d, i - iS0);
        }
        C24826zG4 c24826zG4 = new C24826zG4(this.g[0]);
        Object[] objArr = this.f;
        AbstractC13042fc3.f(objArr);
        q0(p0(objArr, this.d, i, c24826zG4), iS0, this.d, 0);
        return c24826zG4.a();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    public final boolean o0(UA2 ua2) {
        boolean zL0 = l0(ua2);
        if (zL0) {
            ((AbstractList) this).modCount++;
        }
        return zL0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        return o0(new a(collection));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        MB3.a(i, size());
        if (s0() > i) {
            C24826zG4 c24826zG4 = new C24826zG4(null);
            Object[] objArr = this.f;
            AbstractC13042fc3.f(objArr);
            this.f = t0(objArr, this.d, i, obj, c24826zG4);
            return c24826zG4.a();
        }
        Object[] objArrW = W(this.g);
        if (objArrW != this.g) {
            ((AbstractList) this).modCount++;
        }
        int i2 = i & 31;
        Object obj2 = objArrW[i2];
        objArrW[i2] = obj;
        this.g = objArrW;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        MB3.b(i, size());
        return new C55(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        MB3.b(i, size());
        if (i == size()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iS0 = s0();
        if (i >= iS0) {
            R(this.f, i - iS0, obj);
            return;
        }
        C24826zG4 c24826zG4 = new C24826zG4(null);
        Object[] objArr = this.f;
        AbstractC13042fc3.f(objArr);
        R(Q(objArr, this.d, i, obj, c24826zG4), 0, c24826zG4.a());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        Object[] objArrL;
        MB3.b(i, size());
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
            XZ0.a(i >= s0());
            int i3 = i & 31;
            int size2 = ((i + collection.size()) - 1) & 31;
            Object[] objArr = this.g;
            Object[] objArrL2 = AbstractC9648aK.l(objArr, W(objArr), size2 + 1, i3, w0());
            E(objArrL2, i3, collection.iterator());
            this.g = objArrL2;
            this.h = size() + collection.size();
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iW0 = w0();
        int iX0 = x0(size() + collection.size());
        if (i >= s0()) {
            objArrL = Z();
            v0(collection, i, this.g, iW0, objArr2, size, objArrL);
        } else if (iX0 <= iW0) {
            int i4 = iW0 - iX0;
            objArrL = AbstractC9648aK.l(this.g, Z(), 0, i4, iW0);
            int i5 = 32 - i4;
            Object[] objArrY = Y(this.g, i5);
            int i6 = size - 1;
            objArr2[i6] = objArrY;
            P(collection, i, i5, objArr2, i6, objArrY);
        } else {
            int i7 = iX0 - iW0;
            objArrL = Y(this.g, i7);
            P(collection, i, i7, objArr2, size, objArrL);
        }
        this.f = g0(this.f, i2, objArr2);
        this.g = objArrL;
        this.h = size() + collection.size();
        return true;
    }
}
