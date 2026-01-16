package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.tE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21176tE6 {
    private final C21850uE6 a;
    private final int[] b;
    private final int c;
    private final Object[] d;
    private final int e;
    private HashMap f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private final C5131Ia3 k;
    private int l;
    private int m;
    private int n;
    private boolean o;

    public C21176tE6(C21850uE6 c21850uE6) {
        this.a = c21850uE6;
        this.b = c21850uE6.I();
        int iL = c21850uE6.L();
        this.c = iL;
        this.d = c21850uE6.N();
        this.e = c21850uE6.O();
        this.i = iL;
        this.j = -1;
        this.k = new C5131Ia3();
    }

    private final Object M(int[] iArr, int i) {
        int i2 = i * 5;
        return (iArr[i2 + 1] & 1073741824) != 0 ? this.d[iArr[i2 + 4]] : InterfaceC22053ub1.a.a();
    }

    private final Object O(int[] iArr, int i) {
        if ((iArr[(i * 5) + 1] & 536870912) != 0) {
            return this.d[AbstractC23036wE6.s(iArr, i)];
        }
        return null;
    }

    private final Object b(int[] iArr, int i) {
        return (iArr[(i * 5) + 1] & 268435456) != 0 ? this.d[AbstractC23036wE6.n(iArr, i)] : InterfaceC22053ub1.a.a();
    }

    public final Object A(int i) {
        return B(this.h, i);
    }

    public final Object B(int i, int i2) {
        int iU = AbstractC23036wE6.u(this.b, i);
        int i3 = i + 1;
        int i4 = iU + i2;
        return i4 < (i3 < this.c ? this.b[(i3 * 5) + 4] : this.e) ? this.d[i4] : InterfaceC22053ub1.a.a();
    }

    public final int C(int i) {
        return this.b[i * 5];
    }

    public final Object D(int i) {
        return O(this.b, i);
    }

    public final int E(int i) {
        return AbstractC23036wE6.p(this.b, i);
    }

    public final boolean F(int i) {
        return (this.b[(i * 5) + 1] & 134217728) != 0;
    }

    public final boolean G(int i) {
        return (this.b[(i * 5) + 1] & 536870912) != 0;
    }

    public final boolean H() {
        return t() || this.h == this.i;
    }

    public final boolean I() {
        return (this.b[(this.h * 5) + 1] & 1073741824) != 0;
    }

    public final boolean J(int i) {
        return (this.b[(i * 5) + 1] & 1073741824) != 0;
    }

    public final Object K() {
        int i;
        if (this.l > 0 || (i = this.m) >= this.n) {
            this.o = false;
            return InterfaceC22053ub1.a.a();
        }
        this.o = true;
        Object[] objArr = this.d;
        this.m = i + 1;
        return objArr[i];
    }

    public final Object L(int i) {
        int[] iArr = this.b;
        if ((iArr[(i * 5) + 1] & 1073741824) != 0) {
            return M(iArr, i);
        }
        return null;
    }

    public final int N(int i) {
        return this.b[(i * 5) + 1] & 67108863;
    }

    public final int P(int i) {
        return this.b[(i * 5) + 2];
    }

    public final void Q(int i) {
        if (!(this.l == 0)) {
            AbstractC5138Ib1.s("Cannot reposition while in an empty region");
        }
        this.h = i;
        int i2 = this.c;
        int i3 = i < i2 ? this.b[(i * 5) + 2] : -1;
        this.j = i3;
        if (i3 < 0) {
            this.i = i2;
        } else {
            this.i = i3 + AbstractC23036wE6.p(this.b, i3);
        }
        this.m = 0;
        this.n = 0;
    }

    public final void R(int i) {
        int iP = AbstractC23036wE6.p(this.b, i) + i;
        int i2 = this.h;
        if (!(i2 >= i && i2 <= iP)) {
            AbstractC5138Ib1.s("Index " + i + " is not a parent of " + i2);
        }
        this.j = i;
        this.i = iP;
        this.m = 0;
        this.n = 0;
    }

    public final int S() {
        if (!(this.l == 0)) {
            AbstractC5138Ib1.s("Cannot skip while in an empty region");
        }
        int[] iArr = this.b;
        int i = this.h;
        int i2 = (iArr[(i * 5) + 1] & 1073741824) == 0 ? iArr[(i * 5) + 1] & 67108863 : 1;
        this.h = i + AbstractC23036wE6.p(iArr, i);
        return i2;
    }

    public final void T() {
        if (!(this.l == 0)) {
            AbstractC5138Ib1.s("Cannot skip the enclosing group while in an empty region");
        }
        this.h = this.i;
        this.m = 0;
        this.n = 0;
    }

    public final void U() {
        if (this.l <= 0) {
            int i = this.j;
            int i2 = this.h;
            if (!(this.b[(i2 * 5) + 2] == i)) {
                AbstractC5214Ij5.a("Invalid slot table detected");
            }
            HashMap map = this.f;
            if (map != null) {
            }
            C5131Ia3 c5131Ia3 = this.k;
            int i3 = this.m;
            int i4 = this.n;
            if (i3 == 0 && i4 == 0) {
                c5131Ia3.h(-1);
            } else {
                c5131Ia3.h(i3);
            }
            this.j = i2;
            this.i = AbstractC23036wE6.p(this.b, i2) + i2;
            int i5 = i2 + 1;
            this.h = i5;
            this.m = AbstractC23036wE6.u(this.b, i2);
            this.n = i2 >= this.c - 1 ? this.e : this.b[(i5 * 5) + 4];
        }
    }

    public final void V() {
        if (this.l <= 0) {
            if (!((this.b[(this.h * 5) + 1] & 1073741824) != 0)) {
                AbstractC5214Ij5.a("Expected a node group");
            }
            U();
        }
    }

    public final C6669Om a(int i) {
        ArrayList arrayListE = this.a.E();
        int iT = AbstractC23036wE6.t(arrayListE, i, this.c);
        if (iT >= 0) {
            return (C6669Om) arrayListE.get(iT);
        }
        C6669Om c6669Om = new C6669Om(i);
        arrayListE.add(-(iT + 1), c6669Om);
        return c6669Om;
    }

    public final void c() {
        this.l++;
    }

    public final void d() {
        this.g = true;
        this.a.v(this, this.f);
    }

    public final boolean e(int i) {
        return (this.b[(i * 5) + 1] & 67108864) != 0;
    }

    public final void f() {
        if (!(this.l > 0)) {
            AbstractC5214Ij5.a("Unbalanced begin/end empty");
        }
        this.l--;
    }

    public final void g() {
        if (this.l == 0) {
            if (!(this.h == this.i)) {
                AbstractC5138Ib1.s("endGroup() not called at the end of a group");
            }
            int[] iArr = this.b;
            int i = iArr[(this.j * 5) + 2];
            this.j = i;
            this.i = i < 0 ? this.c : AbstractC23036wE6.p(iArr, i) + i;
            int iG = this.k.g();
            if (iG < 0) {
                this.m = 0;
                this.n = 0;
            } else {
                this.m = iG;
                this.n = i >= this.c - 1 ? this.e : this.b[((i + 1) * 5) + 4];
            }
        }
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        if (this.l > 0) {
            return arrayList;
        }
        int iP = this.h;
        int i = 0;
        while (iP < this.i) {
            int[] iArr = this.b;
            int i2 = iP * 5;
            int i3 = iArr[i2];
            Object objO = O(iArr, iP);
            int i4 = 1;
            int i5 = this.b[i2 + 1];
            if ((1073741824 & i5) == 0) {
                i4 = i5 & 67108863;
            }
            arrayList.add(new C23961xo3(i3, objO, iP, i4, i));
            iP += AbstractC23036wE6.p(this.b, iP);
            i++;
        }
        return arrayList;
    }

    public final boolean i() {
        return this.g;
    }

    public final int j() {
        return this.i;
    }

    public final int k() {
        return this.h;
    }

    public final Object l() {
        int i = this.h;
        if (i < this.i) {
            return b(this.b, i);
        }
        return 0;
    }

    public final int m() {
        return this.i;
    }

    public final int n() {
        int i = this.h;
        if (i < this.i) {
            return this.b[i * 5];
        }
        return 0;
    }

    public final Object o() {
        int i = this.h;
        if (i < this.i) {
            return O(this.b, i);
        }
        return null;
    }

    public final int p() {
        return AbstractC23036wE6.p(this.b, this.h);
    }

    public final int q() {
        return this.m - AbstractC23036wE6.u(this.b, this.j);
    }

    public final boolean r() {
        return this.o;
    }

    public final boolean s() {
        int i = this.h;
        return i < this.i && (this.b[(i * 5) + 1] & 536870912) != 0;
    }

    public final boolean t() {
        return this.l > 0;
    }

    public String toString() {
        return "SlotReader(current=" + this.h + ", key=" + n() + ", parent=" + this.j + ", end=" + this.i + ')';
    }

    public final int u() {
        return this.j;
    }

    public final int v() {
        int i = this.j;
        if (i >= 0) {
            return this.b[(i * 5) + 1] & 67108863;
        }
        return 0;
    }

    public final int w() {
        return this.n - this.m;
    }

    public final int x() {
        return this.c;
    }

    public final C21850uE6 y() {
        return this.a;
    }

    public final Object z(int i) {
        return b(this.b, i);
    }
}
