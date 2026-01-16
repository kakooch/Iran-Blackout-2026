package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.ew7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12637ew7 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static final C12637ew7 g = new C12637ew7(0, 0, new Object[0]);
    private int a;
    private int b;
    private final C10537bm4 c;
    private Object[] d;

    /* renamed from: ir.nasim.ew7$a */
    public static final class a {
        private a() {
        }

        public final C12637ew7 a() {
            return C12637ew7.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ew7$b */
    public static final class b {
        private C12637ew7 a;
        private final int b;

        public b(C12637ew7 c12637ew7, int i) {
            this.a = c12637ew7;
            this.b = i;
        }

        public final C12637ew7 a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final void c(C12637ew7 c12637ew7) {
            this.a = c12637ew7;
        }
    }

    public C12637ew7(int i, int i2, Object[] objArr, C10537bm4 c10537bm4) {
        this.a = i;
        this.b = i2;
        this.c = c10537bm4;
        this.d = objArr;
    }

    private final C12637ew7 A(int i, AbstractC10724c55 abstractC10724c55) {
        abstractC10724c55.n(abstractC10724c55.size() - 1);
        abstractC10724c55.k(W(i));
        if (this.d.length == 2) {
            return null;
        }
        if (this.c != abstractC10724c55.i()) {
            return new C12637ew7(0, 0, AbstractC15064iw7.h(this.d, i), abstractC10724c55.i());
        }
        this.d = AbstractC15064iw7.h(this.d, i);
        return this;
    }

    private final C12637ew7 B(int i, Object obj, Object obj2, C10537bm4 c10537bm4) {
        int iN = n(i);
        if (this.c != c10537bm4) {
            return new C12637ew7(i | this.a, this.b, AbstractC15064iw7.g(this.d, iN, obj, obj2), c10537bm4);
        }
        this.d = AbstractC15064iw7.g(this.d, iN, obj, obj2);
        this.a = i | this.a;
        return this;
    }

    private final C12637ew7 C(int i, int i2, int i3, Object obj, Object obj2, int i4, C10537bm4 c10537bm4) {
        if (this.c != c10537bm4) {
            return new C12637ew7(this.a ^ i2, i2 | this.b, d(i, i2, i3, obj, obj2, i4, c10537bm4), c10537bm4);
        }
        this.d = d(i, i2, i3, obj, obj2, i4, c10537bm4);
        this.a ^= i2;
        this.b |= i2;
        return this;
    }

    private final C12637ew7 F(C12637ew7 c12637ew7, int i, int i2, VH1 vh1, AbstractC10724c55 abstractC10724c55) {
        if (r(i)) {
            C12637ew7 c12637ew7N = N(O(i));
            if (c12637ew7.r(i)) {
                return c12637ew7N.E(c12637ew7.N(c12637ew7.O(i)), i2 + 5, vh1, abstractC10724c55);
            }
            if (!c12637ew7.q(i)) {
                return c12637ew7N;
            }
            int iN = c12637ew7.n(i);
            Object objT = c12637ew7.t(iN);
            Object objW = c12637ew7.W(iN);
            int size = abstractC10724c55.size();
            C12637ew7 c12637ew7D = c12637ew7N.D(objT != null ? objT.hashCode() : 0, objT, objW, i2 + 5, abstractC10724c55);
            if (abstractC10724c55.size() != size) {
                return c12637ew7D;
            }
            vh1.c(vh1.a() + 1);
            return c12637ew7D;
        }
        if (!c12637ew7.r(i)) {
            int iN2 = n(i);
            Object objT2 = t(iN2);
            Object objW2 = W(iN2);
            int iN3 = c12637ew7.n(i);
            Object objT3 = c12637ew7.t(iN3);
            return u(objT2 != null ? objT2.hashCode() : 0, objT2, objW2, objT3 != null ? objT3.hashCode() : 0, objT3, c12637ew7.W(iN3), i2 + 5, abstractC10724c55.i());
        }
        C12637ew7 c12637ew7N2 = c12637ew7.N(c12637ew7.O(i));
        if (q(i)) {
            int iN4 = n(i);
            Object objT4 = t(iN4);
            int i3 = i2 + 5;
            if (!c12637ew7N2.k(objT4 != null ? objT4.hashCode() : 0, objT4, i3)) {
                return c12637ew7N2.D(objT4 != null ? objT4.hashCode() : 0, objT4, W(iN4), i3, abstractC10724c55);
            }
            vh1.c(vh1.a() + 1);
        }
        return c12637ew7N2;
    }

    private final C12637ew7 I(int i, int i2, AbstractC10724c55 abstractC10724c55) {
        abstractC10724c55.n(abstractC10724c55.size() - 1);
        abstractC10724c55.k(W(i));
        if (this.d.length == 2) {
            return null;
        }
        if (this.c != abstractC10724c55.i()) {
            return new C12637ew7(i2 ^ this.a, this.b, AbstractC15064iw7.h(this.d, i), abstractC10724c55.i());
        }
        this.d = AbstractC15064iw7.h(this.d, i);
        this.a ^= i2;
        return this;
    }

    private final C12637ew7 J(int i, int i2, C10537bm4 c10537bm4) {
        Object[] objArr = this.d;
        if (objArr.length == 1) {
            return null;
        }
        if (this.c != c10537bm4) {
            return new C12637ew7(this.a, i2 ^ this.b, AbstractC15064iw7.i(objArr, i), c10537bm4);
        }
        this.d = AbstractC15064iw7.i(objArr, i);
        this.b ^= i2;
        return this;
    }

    private final C12637ew7 K(C12637ew7 c12637ew7, C12637ew7 c12637ew72, int i, int i2, C10537bm4 c10537bm4) {
        return c12637ew72 == null ? J(i, i2, c10537bm4) : (this.c == c10537bm4 || c12637ew7 != c12637ew72) ? L(i, c12637ew72, c10537bm4) : this;
    }

    private final C12637ew7 L(int i, C12637ew7 c12637ew7, C10537bm4 c10537bm4) {
        Object[] objArr = this.d;
        if (objArr.length == 1 && c12637ew7.d.length == 2 && c12637ew7.b == 0) {
            c12637ew7.a = this.b;
            return c12637ew7;
        }
        if (this.c == c10537bm4) {
            objArr[i] = c12637ew7;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i] = c12637ew7;
        return new C12637ew7(this.a, this.b, objArrCopyOf, c10537bm4);
    }

    private final C12637ew7 M(int i, Object obj, AbstractC10724c55 abstractC10724c55) {
        if (this.c == abstractC10724c55.i()) {
            this.d[i + 1] = obj;
            return this;
        }
        abstractC10724c55.j(abstractC10724c55.g() + 1);
        Object[] objArr = this.d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i + 1] = obj;
        return new C12637ew7(this.a, this.b, objArrCopyOf, abstractC10724c55.i());
    }

    private final C12637ew7 R(int i, int i2) {
        Object[] objArr = this.d;
        if (objArr.length == 2) {
            return null;
        }
        return new C12637ew7(i2 ^ this.a, this.b, AbstractC15064iw7.h(objArr, i));
    }

    private final C12637ew7 S(int i, int i2) {
        Object[] objArr = this.d;
        if (objArr.length == 1) {
            return null;
        }
        return new C12637ew7(this.a, i2 ^ this.b, AbstractC15064iw7.i(objArr, i));
    }

    private final C12637ew7 T(C12637ew7 c12637ew7, C12637ew7 c12637ew72, int i, int i2) {
        return c12637ew72 == null ? S(i, i2) : c12637ew7 != c12637ew72 ? U(i, i2, c12637ew72) : this;
    }

    private final C12637ew7 U(int i, int i2, C12637ew7 c12637ew7) {
        Object[] objArr = c12637ew7.d;
        if (objArr.length != 2 || c12637ew7.b != 0) {
            Object[] objArr2 = this.d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[i] = c12637ew7;
            return new C12637ew7(this.a, this.b, objArrCopyOf);
        }
        if (this.d.length == 1) {
            c12637ew7.a = this.b;
            return c12637ew7;
        }
        return new C12637ew7(this.a ^ i2, i2 ^ this.b, AbstractC15064iw7.k(this.d, i, n(i2), objArr[0], objArr[1]));
    }

    private final C12637ew7 V(int i, Object obj) {
        Object[] objArr = this.d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i + 1] = obj;
        return new C12637ew7(this.a, this.b, objArrCopyOf);
    }

    private final Object W(int i) {
        return this.d[i + 1];
    }

    private final b b() {
        return new b(this, 1);
    }

    private final b c() {
        return new b(this, 0);
    }

    private final Object[] d(int i, int i2, int i3, Object obj, Object obj2, int i4, C10537bm4 c10537bm4) {
        Object objT = t(i);
        return AbstractC15064iw7.j(this.d, i, O(i2) + 1, u(objT != null ? objT.hashCode() : 0, objT, W(i), i3, obj, obj2, i4 + 5, c10537bm4));
    }

    private final int e() {
        if (this.b == 0) {
            return this.d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.a);
        int length = this.d.length;
        for (int i = iBitCount * 2; i < length; i++) {
            iBitCount += N(i).e();
        }
        return iBitCount;
    }

    private final boolean f(Object obj) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (!AbstractC13042fc3.d(obj, this.d[iO])) {
                if (iO != iT) {
                    iO += iV;
                }
            }
            return true;
        }
        return false;
    }

    private final Object g(Object obj) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV <= 0 || iO > iT) && (iV >= 0 || iT > iO)) {
            return null;
        }
        while (!AbstractC13042fc3.d(obj, t(iO))) {
            if (iO == iT) {
                return null;
            }
            iO += iV;
        }
        return W(iO);
    }

    private final b h(Object obj, Object obj2) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (!AbstractC13042fc3.d(obj, t(iO))) {
                if (iO != iT) {
                    iO += iV;
                }
            }
            if (obj2 == W(iO)) {
                return null;
            }
            Object[] objArr = this.d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iO + 1] = obj2;
            return new C12637ew7(0, 0, objArrCopyOf).c();
        }
        return new C12637ew7(0, 0, AbstractC15064iw7.g(this.d, 0, obj, obj2)).b();
    }

    private final C12637ew7 i(Object obj) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (!AbstractC13042fc3.d(obj, t(iO))) {
                if (iO != iT) {
                    iO += iV;
                }
            }
            return j(iO);
        }
        return this;
    }

    private final C12637ew7 j(int i) {
        Object[] objArr = this.d;
        if (objArr.length == 2) {
            return null;
        }
        return new C12637ew7(0, 0, AbstractC15064iw7.h(objArr, i));
    }

    private final boolean l(C12637ew7 c12637ew7) {
        if (this == c12637ew7) {
            return true;
        }
        if (this.b != c12637ew7.b || this.a != c12637ew7.a) {
            return false;
        }
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            if (this.d[i] != c12637ew7.d[i]) {
                return false;
            }
        }
        return true;
    }

    private final boolean r(int i) {
        return (i & this.b) != 0;
    }

    private final C12637ew7 s(int i, Object obj, Object obj2) {
        return new C12637ew7(i | this.a, this.b, AbstractC15064iw7.g(this.d, n(i), obj, obj2));
    }

    private final Object t(int i) {
        return this.d[i];
    }

    private final C12637ew7 u(int i, Object obj, Object obj2, int i2, Object obj3, Object obj4, int i3, C10537bm4 c10537bm4) {
        if (i3 > 30) {
            return new C12637ew7(0, 0, new Object[]{obj, obj2, obj3, obj4}, c10537bm4);
        }
        int iF = AbstractC15064iw7.f(i, i3);
        int iF2 = AbstractC15064iw7.f(i2, i3);
        if (iF != iF2) {
            return new C12637ew7((1 << iF) | (1 << iF2), 0, iF < iF2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, c10537bm4);
        }
        return new C12637ew7(0, 1 << iF, new Object[]{u(i, obj, obj2, i2, obj3, obj4, i3 + 5, c10537bm4)}, c10537bm4);
    }

    private final C12637ew7 v(int i, int i2, int i3, Object obj, Object obj2, int i4) {
        return new C12637ew7(this.a ^ i2, i2 | this.b, d(i, i2, i3, obj, obj2, i4, null));
    }

    private final C12637ew7 w(Object obj, Object obj2, AbstractC10724c55 abstractC10724c55) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (!AbstractC13042fc3.d(obj, t(iO))) {
                if (iO != iT) {
                    iO += iV;
                }
            }
            abstractC10724c55.k(W(iO));
            if (this.c == abstractC10724c55.i()) {
                this.d[iO + 1] = obj2;
                return this;
            }
            abstractC10724c55.j(abstractC10724c55.g() + 1);
            Object[] objArr = this.d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iO + 1] = obj2;
            return new C12637ew7(0, 0, objArrCopyOf, abstractC10724c55.i());
        }
        abstractC10724c55.n(abstractC10724c55.size() + 1);
        return new C12637ew7(0, 0, AbstractC15064iw7.g(this.d, 0, obj, obj2), abstractC10724c55.i());
    }

    private final C12637ew7 x(C12637ew7 c12637ew7, VH1 vh1, C10537bm4 c10537bm4) {
        XZ0.a(this.b == 0);
        XZ0.a(this.a == 0);
        XZ0.a(c12637ew7.b == 0);
        XZ0.a(c12637ew7.a == 0);
        Object[] objArr = this.d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + c12637ew7.d.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        int length = this.d.length;
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, c12637ew7.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (true) {
                if (f(c12637ew7.d[iO])) {
                    vh1.c(vh1.a() + 1);
                } else {
                    Object[] objArr2 = c12637ew7.d;
                    objArrCopyOf[length] = objArr2[iO];
                    objArrCopyOf[length + 1] = objArr2[iO + 1];
                    length += 2;
                }
                if (iO == iT) {
                    break;
                }
                iO += iV;
            }
        }
        if (length == this.d.length) {
            return this;
        }
        if (length == c12637ew7.d.length) {
            return c12637ew7;
        }
        if (length == objArrCopyOf.length) {
            return new C12637ew7(0, 0, objArrCopyOf, c10537bm4);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        AbstractC13042fc3.h(objArrCopyOf2, "copyOf(...)");
        return new C12637ew7(0, 0, objArrCopyOf2, c10537bm4);
    }

    private final C12637ew7 y(Object obj, AbstractC10724c55 abstractC10724c55) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (!AbstractC13042fc3.d(obj, t(iO))) {
                if (iO != iT) {
                    iO += iV;
                }
            }
            return A(iO, abstractC10724c55);
        }
        return this;
    }

    private final C12637ew7 z(Object obj, Object obj2, AbstractC10724c55 abstractC10724c55) {
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, this.d.length), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
            while (true) {
                if (!AbstractC13042fc3.d(obj, t(iO)) || !AbstractC13042fc3.d(obj2, W(iO))) {
                    if (iO == iT) {
                        break;
                    }
                    iO += iV;
                } else {
                    return A(iO, abstractC10724c55);
                }
            }
        }
        return this;
    }

    public final C12637ew7 D(int i, Object obj, Object obj2, int i2, AbstractC10724c55 abstractC10724c55) {
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            int iN = n(iF);
            if (AbstractC13042fc3.d(obj, t(iN))) {
                abstractC10724c55.k(W(iN));
                return W(iN) == obj2 ? this : M(iN, obj2, abstractC10724c55);
            }
            abstractC10724c55.n(abstractC10724c55.size() + 1);
            return C(iN, iF, i, obj, obj2, i2, abstractC10724c55.i());
        }
        if (!r(iF)) {
            abstractC10724c55.n(abstractC10724c55.size() + 1);
            return B(iF, obj, obj2, abstractC10724c55.i());
        }
        int iO = O(iF);
        C12637ew7 c12637ew7N = N(iO);
        C12637ew7 c12637ew7W = i2 == 30 ? c12637ew7N.w(obj, obj2, abstractC10724c55) : c12637ew7N.D(i, obj, obj2, i2 + 5, abstractC10724c55);
        return c12637ew7N == c12637ew7W ? this : L(iO, c12637ew7W, abstractC10724c55.i());
    }

    public final C12637ew7 E(C12637ew7 c12637ew7, int i, VH1 vh1, AbstractC10724c55 abstractC10724c55) {
        if (this == c12637ew7) {
            vh1.b(e());
            return this;
        }
        if (i > 30) {
            return x(c12637ew7, vh1, abstractC10724c55.i());
        }
        int i2 = this.b | c12637ew7.b;
        int i3 = this.a;
        int i4 = c12637ew7.a;
        int i5 = (i3 ^ i4) & (~i2);
        int i6 = i3 & i4;
        int i7 = i5;
        while (i6 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i6);
            if (AbstractC13042fc3.d(t(n(iLowestOneBit)), c12637ew7.t(c12637ew7.n(iLowestOneBit)))) {
                i7 |= iLowestOneBit;
            } else {
                i2 |= iLowestOneBit;
            }
            i6 ^= iLowestOneBit;
        }
        int i8 = 0;
        if (!((i2 & i7) == 0)) {
            AbstractC5214Ij5.b("Check failed.");
        }
        C12637ew7 c12637ew72 = (AbstractC13042fc3.d(this.c, abstractC10724c55.i()) && this.a == i7 && this.b == i2) ? this : new C12637ew7(i7, i2, new Object[(Integer.bitCount(i7) * 2) + Integer.bitCount(i2)]);
        int i9 = i2;
        int i10 = 0;
        while (i9 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i9);
            Object[] objArr = c12637ew72.d;
            objArr[(objArr.length - 1) - i10] = F(c12637ew7, iLowestOneBit2, i, vh1, abstractC10724c55);
            i10++;
            i9 ^= iLowestOneBit2;
        }
        while (i7 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i7);
            int i11 = i8 * 2;
            if (c12637ew7.q(iLowestOneBit3)) {
                int iN = c12637ew7.n(iLowestOneBit3);
                c12637ew72.d[i11] = c12637ew7.t(iN);
                c12637ew72.d[i11 + 1] = c12637ew7.W(iN);
                if (q(iLowestOneBit3)) {
                    vh1.c(vh1.a() + 1);
                }
            } else {
                int iN2 = n(iLowestOneBit3);
                c12637ew72.d[i11] = t(iN2);
                c12637ew72.d[i11 + 1] = W(iN2);
            }
            i8++;
            i7 ^= iLowestOneBit3;
        }
        return l(c12637ew72) ? this : c12637ew7.l(c12637ew72) ? c12637ew7 : c12637ew72;
    }

    public final C12637ew7 G(int i, Object obj, int i2, AbstractC10724c55 abstractC10724c55) {
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            int iN = n(iF);
            return AbstractC13042fc3.d(obj, t(iN)) ? I(iN, iF, abstractC10724c55) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        C12637ew7 c12637ew7N = N(iO);
        return K(c12637ew7N, i2 == 30 ? c12637ew7N.y(obj, abstractC10724c55) : c12637ew7N.G(i, obj, i2 + 5, abstractC10724c55), iO, iF, abstractC10724c55.i());
    }

    public final C12637ew7 H(int i, Object obj, Object obj2, int i2, AbstractC10724c55 abstractC10724c55) {
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            int iN = n(iF);
            return (AbstractC13042fc3.d(obj, t(iN)) && AbstractC13042fc3.d(obj2, W(iN))) ? I(iN, iF, abstractC10724c55) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        C12637ew7 c12637ew7N = N(iO);
        return K(c12637ew7N, i2 == 30 ? c12637ew7N.z(obj, obj2, abstractC10724c55) : c12637ew7N.H(i, obj, obj2, i2 + 5, abstractC10724c55), iO, iF, abstractC10724c55.i());
    }

    public final C12637ew7 N(int i) {
        Object obj = this.d[i];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (C12637ew7) obj;
    }

    public final int O(int i) {
        return (this.d.length - 1) - Integer.bitCount((i - 1) & this.b);
    }

    public final b P(int i, Object obj, Object obj2, int i2) {
        b bVarP;
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            int iN = n(iF);
            if (!AbstractC13042fc3.d(obj, t(iN))) {
                return v(iN, iF, i, obj, obj2, i2).b();
            }
            if (W(iN) == obj2) {
                return null;
            }
            return V(iN, obj2).c();
        }
        if (!r(iF)) {
            return s(iF, obj, obj2).b();
        }
        int iO = O(iF);
        C12637ew7 c12637ew7N = N(iO);
        if (i2 == 30) {
            bVarP = c12637ew7N.h(obj, obj2);
            if (bVarP == null) {
                return null;
            }
        } else {
            bVarP = c12637ew7N.P(i, obj, obj2, i2 + 5);
            if (bVarP == null) {
                return null;
            }
        }
        bVarP.c(U(iO, iF, bVarP.a()));
        return bVarP;
    }

    public final C12637ew7 Q(int i, Object obj, int i2) {
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            int iN = n(iF);
            return AbstractC13042fc3.d(obj, t(iN)) ? R(iN, iF) : this;
        }
        if (!r(iF)) {
            return this;
        }
        int iO = O(iF);
        C12637ew7 c12637ew7N = N(iO);
        return T(c12637ew7N, i2 == 30 ? c12637ew7N.i(obj) : c12637ew7N.Q(i, obj, i2 + 5), iO, iF);
    }

    public final boolean k(int i, Object obj, int i2) {
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            return AbstractC13042fc3.d(obj, t(n(iF)));
        }
        if (!r(iF)) {
            return false;
        }
        C12637ew7 c12637ew7N = N(O(iF));
        return i2 == 30 ? c12637ew7N.f(obj) : c12637ew7N.k(i, obj, i2 + 5);
    }

    public final int m() {
        return Integer.bitCount(this.a);
    }

    public final int n(int i) {
        return Integer.bitCount((i - 1) & this.a) * 2;
    }

    public final Object o(int i, Object obj, int i2) {
        int iF = 1 << AbstractC15064iw7.f(i, i2);
        if (q(iF)) {
            int iN = n(iF);
            if (AbstractC13042fc3.d(obj, t(iN))) {
                return W(iN);
            }
            return null;
        }
        if (!r(iF)) {
            return null;
        }
        C12637ew7 c12637ew7N = N(O(iF));
        return i2 == 30 ? c12637ew7N.g(obj) : c12637ew7N.o(i, obj, i2 + 5);
    }

    public final Object[] p() {
        return this.d;
    }

    public final boolean q(int i) {
        return (i & this.a) != 0;
    }

    public C12637ew7(int i, int i2, Object[] objArr) {
        this(i, i2, objArr, null);
    }
}
