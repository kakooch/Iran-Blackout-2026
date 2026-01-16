package ir.nasim;

import java.util.Arrays;
import java.util.ListIterator;

/* renamed from: ir.nasim.w55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22949w55 extends AbstractC22903w1 implements InterfaceC19286q55 {
    private final Object[] a;
    private final Object[] b;
    private final int c;
    private final int d;

    public C22949w55(Object[] objArr, Object[] objArr2, int i, int i2) {
        this.a = objArr;
        this.b = objArr2;
        this.c = i;
        this.d = i2;
        if (!(size() > 32)) {
            AbstractC5214Ij5.a("Trie-based persistent vector should have at least 33 elements, got " + size());
        }
        XZ0.a(size() - AbstractC24298yN7.d(size()) <= AbstractC23053wG5.i(objArr2.length, 32));
    }

    private final Object[] C(Object[] objArr, int i, int i2, Object obj, C24826zG4 c24826zG4) {
        Object[] objArrCopyOf;
        int iA = AbstractC24298yN7.a(i2, i);
        if (i == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            }
            AbstractC9648aK.l(objArr, objArrCopyOf, iA + 1, iA, 31);
            c24826zG4.b(objArr[31]);
            objArrCopyOf[iA] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        AbstractC13042fc3.h(objArrCopyOf2, "copyOf(...)");
        int i3 = i - 5;
        Object obj2 = objArr[iA];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = C((Object[]) obj2, i3, i2, obj, c24826zG4);
        int i4 = iA + 1;
        while (i4 < 32 && objArrCopyOf2[i4] != null) {
            Object obj3 = objArr[i4];
            AbstractC13042fc3.g(obj3, str);
            Object[] objArr2 = objArrCopyOf2;
            objArr2[i4] = C((Object[]) obj3, i3, 0, c24826zG4.a(), c24826zG4);
            i4++;
            objArrCopyOf2 = objArr2;
            str = str;
        }
        return objArrCopyOf2;
    }

    private final C22949w55 E(Object[] objArr, int i, Object obj) {
        int size = size() - R();
        Object[] objArrCopyOf = Arrays.copyOf(this.b, 32);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        if (size < 32) {
            AbstractC9648aK.l(this.b, objArrCopyOf, i + 1, i, size);
            objArrCopyOf[i] = obj;
            return new C22949w55(objArr, objArrCopyOf, size() + 1, this.d);
        }
        Object[] objArr2 = this.b;
        Object obj2 = objArr2[31];
        AbstractC9648aK.l(objArr2, objArrCopyOf, i + 1, i, size - 1);
        objArrCopyOf[i] = obj;
        return N(objArr, objArrCopyOf, AbstractC24298yN7.c(obj2));
    }

    private final Object[] F(Object[] objArr, int i, int i2, C24826zG4 c24826zG4) {
        Object[] objArrF;
        int iA = AbstractC24298yN7.a(i2, i);
        if (i == 5) {
            c24826zG4.b(objArr[iA]);
            objArrF = null;
        } else {
            Object obj = objArr[iA];
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrF = F((Object[]) obj, i - 5, i2, c24826zG4);
        }
        if (objArrF == null && iA == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iA] = objArrF;
        return objArrCopyOf;
    }

    private final InterfaceC19286q55 L(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                AbstractC13042fc3.h(objArr, "copyOf(...)");
            }
            return new AE6(objArr);
        }
        C24826zG4 c24826zG4 = new C24826zG4(null);
        Object[] objArrF = F(objArr, i2, i - 1, c24826zG4);
        AbstractC13042fc3.f(objArrF);
        Object objA = c24826zG4.a();
        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) objA;
        if (objArrF[1] != null) {
            return new C22949w55(objArrF, objArr2, i, i2);
        }
        Object obj = objArrF[0];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new C22949w55((Object[]) obj, objArr2, i, i2 - 5);
    }

    private final C22949w55 N(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i = this.d;
        if (size <= (1 << i)) {
            return new C22949w55(O(objArr, i, objArr2), objArr3, size() + 1, this.d);
        }
        Object[] objArrC = AbstractC24298yN7.c(objArr);
        int i2 = this.d + 5;
        return new C22949w55(O(objArrC, i2, objArr2), objArr3, size() + 1, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object[] O(java.lang.Object[] r4, int r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r0 = r3.size()
            int r0 = r0 + (-1)
            int r0 = ir.nasim.AbstractC24298yN7.a(r0, r5)
            r1 = 32
            if (r4 == 0) goto L19
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = "copyOf(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r2)
            if (r4 != 0) goto L1b
        L19:
            java.lang.Object[] r4 = new java.lang.Object[r1]
        L1b:
            r1 = 5
            if (r5 != r1) goto L21
            r4[r0] = r6
            goto L2c
        L21:
            r2 = r4[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r5 = r5 - r1
            java.lang.Object[] r5 = r3.O(r2, r5, r6)
            r4[r0] = r5
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22949w55.O(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    private final Object[] P(Object[] objArr, int i, int i2, C24826zG4 c24826zG4) {
        Object[] objArrCopyOf;
        int iA = AbstractC24298yN7.a(i2, i);
        if (i == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            }
            AbstractC9648aK.l(objArr, objArrCopyOf, iA, iA + 1, 32);
            objArrCopyOf[31] = c24826zG4.a();
            c24826zG4.b(objArr[iA]);
            return objArrCopyOf;
        }
        int iA2 = objArr[31] == null ? AbstractC24298yN7.a(R() - 1, i) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        AbstractC13042fc3.h(objArrCopyOf2, "copyOf(...)");
        int i3 = i - 5;
        int i4 = iA + 1;
        if (i4 <= iA2) {
            while (true) {
                Object obj = objArrCopyOf2[iA2];
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrCopyOf2[iA2] = P((Object[]) obj, i3, 0, c24826zG4);
                if (iA2 == i4) {
                    break;
                }
                iA2--;
            }
        }
        Object obj2 = objArrCopyOf2[iA];
        AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = P((Object[]) obj2, i3, i2, c24826zG4);
        return objArrCopyOf2;
    }

    private final InterfaceC19286q55 Q(Object[] objArr, int i, int i2, int i3) {
        int size = size() - i;
        XZ0.a(i3 < size);
        if (size == 1) {
            return L(objArr, i, i2);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.b, 32);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        int i4 = size - 1;
        if (i3 < i4) {
            AbstractC9648aK.l(this.b, objArrCopyOf, i3, i3 + 1, size);
        }
        objArrCopyOf[i4] = null;
        return new C22949w55(objArr, objArrCopyOf, (i + size) - 1, i2);
    }

    private final int R() {
        return AbstractC24298yN7.d(size());
    }

    private final Object[] S(Object[] objArr, int i, int i2, Object obj) {
        int iA = AbstractC24298yN7.a(i2, i);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        if (i == 0) {
            objArrCopyOf[iA] = obj;
        } else {
            Object obj2 = objArrCopyOf[iA];
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf[iA] = S((Object[]) obj2, i - 5, i2, obj);
        }
        return objArrCopyOf;
    }

    private final Object[] f(int i) {
        if (R() <= i) {
            return this.b;
        }
        Object[] objArr = this.a;
        for (int i2 = this.d; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[AbstractC24298yN7.a(i, i2)];
            AbstractC13042fc3.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    @Override // ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 Q0(UA2 ua2) {
        C24129y55 c24129y55M = m();
        c24129y55M.o0(ua2);
        return c24129y55M.a();
    }

    @Override // java.util.Collection, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 add(Object obj) {
        int size = size() - R();
        if (size >= 32) {
            return N(this.a, this.b, AbstractC24298yN7.c(obj));
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.b, 32);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[size] = obj;
        return new C22949w55(this.a, objArrCopyOf, size() + 1, this.d);
    }

    @Override // ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 e0(int i) {
        MB3.a(i, size());
        int iR = R();
        return i >= iR ? Q(this.a, iR, this.d, i - iR) : Q(P(this.a, this.d, i, new C24826zG4(this.b[0])), iR, this.d, 0);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        MB3.a(i, size());
        return f(i)[i & 31];
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC19286q55
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C24129y55 m() {
        return new C24129y55(this, this.a, this.b, this.d);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator(int i) {
        MB3.b(i, size());
        return new A55(this.a, this.b, i, size(), (this.d / 5) + 1);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 set(int i, Object obj) {
        MB3.a(i, size());
        if (R() > i) {
            return new C22949w55(S(this.a, this.d, i, obj), this.b, size(), this.d);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.b, 32);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i & 31] = obj;
        return new C22949w55(this.a, objArrCopyOf, size(), this.d);
    }

    @Override // java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 add(int i, Object obj) {
        MB3.b(i, size());
        if (i == size()) {
            return add(obj);
        }
        int iR = R();
        if (i >= iR) {
            return E(this.a, i - iR, obj);
        }
        C24826zG4 c24826zG4 = new C24826zG4(null);
        return E(C(this.a, this.d, i, obj, c24826zG4), 0, c24826zG4.a());
    }
}
