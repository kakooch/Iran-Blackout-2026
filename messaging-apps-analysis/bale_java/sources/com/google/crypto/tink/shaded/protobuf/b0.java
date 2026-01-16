package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.g0;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class b0 {
    private static final b0 f = new b0(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;

    private b0() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public static b0 c() {
        return f;
    }

    private static int f(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    private static int g(Object[] objArr, int i) {
        int iHashCode = 17;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode = (iHashCode * 31) + objArr[i2].hashCode();
        }
        return iHashCode;
    }

    static b0 j(b0 b0Var, b0 b0Var2) {
        int i = b0Var.a + b0Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(b0Var.b, i);
        System.arraycopy(b0Var2.b, 0, iArrCopyOf, b0Var.a, b0Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(b0Var.c, i);
        System.arraycopy(b0Var2.c, 0, objArrCopyOf, b0Var.a, b0Var2.a);
        return new b0(i, iArrCopyOf, objArrCopyOf, true);
    }

    static b0 k() {
        return new b0();
    }

    private static boolean l(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static void q(int i, Object obj, g0 g0Var) {
        int iA = f0.a(i);
        int iB = f0.b(i);
        if (iB == 0) {
            g0Var.u(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            g0Var.s(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            g0Var.M(iA, (AbstractC2345g) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.e());
            }
            g0Var.c(iA, ((Integer) obj).intValue());
        } else if (g0Var.t() == g0.a.ASCENDING) {
            g0Var.x(iA);
            ((b0) obj).r(g0Var);
            g0Var.C(iA);
        } else {
            g0Var.C(iA);
            ((b0) obj).r(g0Var);
            g0Var.x(iA);
        }
    }

    void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int iO;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int iA = f0.a(i4);
            int iB = f0.b(i4);
            if (iB == 0) {
                iO = CodedOutputStream.O(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 1) {
                iO = CodedOutputStream.n(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 2) {
                iO = CodedOutputStream.f(iA, (AbstractC2345g) this.c[i3]);
            } else if (iB == 3) {
                iO = (CodedOutputStream.L(iA) * 2) + ((b0) this.c[i3]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.e());
                }
                iO = CodedOutputStream.l(iA, ((Integer) this.c[i3]).intValue());
            }
            i2 += iO;
        }
        this.d = i2;
        return i2;
    }

    public int e() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            iA += CodedOutputStream.A(f0.a(this.b[i2]), (AbstractC2345g) this.c[i2]);
        }
        this.d = iA;
        return iA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        int i = this.a;
        return i == b0Var.a && o(this.b, b0Var.b, i) && l(this.c, b0Var.c, this.a);
    }

    public void h() {
        this.e = false;
    }

    public int hashCode() {
        int i = this.a;
        return ((((527 + i) * 31) + f(this.b, i)) * 31) + g(this.c, this.a);
    }

    b0 i(b0 b0Var) {
        if (b0Var.equals(c())) {
            return this;
        }
        a();
        int i = this.a + b0Var.a;
        b(i);
        System.arraycopy(b0Var.b, 0, this.b, this.a, b0Var.a);
        System.arraycopy(b0Var.c, 0, this.c, this.a, b0Var.a);
        this.a = i;
        return this;
    }

    final void m(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            J.d(sb, i, String.valueOf(f0.a(this.b[i2])), this.c[i2]);
        }
    }

    void n(int i, Object obj) {
        a();
        b(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    void p(g0 g0Var) {
        if (g0Var.t() == g0.a.DESCENDING) {
            for (int i = this.a - 1; i >= 0; i--) {
                g0Var.b(f0.a(this.b[i]), this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            g0Var.b(f0.a(this.b[i2]), this.c[i2]);
        }
    }

    public void r(g0 g0Var) {
        if (this.a == 0) {
            return;
        }
        if (g0Var.t() == g0.a.ASCENDING) {
            for (int i = 0; i < this.a; i++) {
                q(this.b[i], this.c[i], g0Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            q(this.b[i2], this.c[i2], g0Var);
        }
    }

    private b0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
