package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.h0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c0 {
    private static final c0 f = new c0(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;

    private c0() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i = this.a;
        int[] iArr = this.b;
        if (i == iArr.length) {
            int i2 = i + (i < 4 ? 8 : i >> 1);
            this.b = Arrays.copyOf(iArr, i2);
            this.c = Arrays.copyOf(this.c, i2);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static c0 e() {
        return f;
    }

    private static int h(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    private static int i(Object[] objArr, int i) {
        int iHashCode = 17;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode = (iHashCode * 31) + objArr[i2].hashCode();
        }
        return iHashCode;
    }

    static c0 k(c0 c0Var, c0 c0Var2) {
        int i = c0Var.a + c0Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(c0Var.b, i);
        System.arraycopy(c0Var2.b, 0, iArrCopyOf, c0Var.a, c0Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(c0Var.c, i);
        System.arraycopy(c0Var2.c, 0, objArrCopyOf, c0Var.a, c0Var2.a);
        return new c0(i, iArrCopyOf, objArrCopyOf, true);
    }

    static c0 l() {
        return new c0();
    }

    private static void p(int i, Object obj, h0 h0Var) {
        int iA = g0.a(i);
        int iB = g0.b(i);
        if (iB == 0) {
            h0Var.u(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            h0Var.s(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            h0Var.K(iA, (AbstractC1937f) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.d());
            }
            h0Var.c(iA, ((Integer) obj).intValue());
        } else if (h0Var.t() == h0.a.ASCENDING) {
            h0Var.x(iA);
            ((c0) obj).q(h0Var);
            h0Var.C(iA);
        } else {
            h0Var.C(iA);
            ((c0) obj).q(h0Var);
            h0Var.x(iA);
        }
    }

    void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        int i = this.a;
        return i == c0Var.a && c(this.b, c0Var.b, i) && d(this.c, c0Var.c, this.a);
    }

    public int f() {
        int iS;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int iA = g0.a(i4);
            int iB = g0.b(i4);
            if (iB == 0) {
                iS = CodedOutputStream.S(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 1) {
                iS = CodedOutputStream.n(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 2) {
                iS = CodedOutputStream.f(iA, (AbstractC1937f) this.c[i3]);
            } else if (iB == 3) {
                iS = (CodedOutputStream.P(iA) * 2) + ((c0) this.c[i3]).f();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.d());
                }
                iS = CodedOutputStream.l(iA, ((Integer) this.c[i3]).intValue());
            }
            i2 += iS;
        }
        this.d = i2;
        return i2;
    }

    public int g() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            iD += CodedOutputStream.D(g0.a(this.b[i2]), (AbstractC1937f) this.c[i2]);
        }
        this.d = iD;
        return iD;
    }

    public int hashCode() {
        int i = this.a;
        return ((((527 + i) * 31) + h(this.b, i)) * 31) + i(this.c, this.a);
    }

    public void j() {
        this.e = false;
    }

    final void m(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            J.c(sb, i, String.valueOf(g0.a(this.b[i2])), this.c[i2]);
        }
    }

    void n(int i, Object obj) {
        a();
        b();
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    void o(h0 h0Var) {
        if (h0Var.t() == h0.a.DESCENDING) {
            for (int i = this.a - 1; i >= 0; i--) {
                h0Var.b(g0.a(this.b[i]), this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            h0Var.b(g0.a(this.b[i2]), this.c[i2]);
        }
    }

    public void q(h0 h0Var) {
        if (this.a == 0) {
            return;
        }
        if (h0Var.t() == h0.a.ASCENDING) {
            for (int i = 0; i < this.a; i++) {
                p(this.b[i], this.c[i], h0Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            p(this.b[i2], this.c[i2], h0Var);
        }
    }

    private c0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
