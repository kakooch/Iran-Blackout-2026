package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.s0;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class m0 {
    private static final m0 f = new m0(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;

    private m0() {
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

    public static m0 c() {
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

    private m0 j(AbstractC2384h abstractC2384h) {
        int iJ;
        do {
            iJ = abstractC2384h.J();
            if (iJ == 0) {
                break;
            }
        } while (i(iJ, abstractC2384h));
        return this;
    }

    static m0 n(m0 m0Var, m0 m0Var2) {
        int i = m0Var.a + m0Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(m0Var.b, i);
        System.arraycopy(m0Var2.b, 0, iArrCopyOf, m0Var.a, m0Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(m0Var.c, i);
        System.arraycopy(m0Var2.c, 0, objArrCopyOf, m0Var.a, m0Var2.a);
        return new m0(i, iArrCopyOf, objArrCopyOf, true);
    }

    static m0 o() {
        return new m0();
    }

    private static boolean p(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private static boolean s(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static void u(int i, Object obj, s0 s0Var) {
        int iA = r0.a(i);
        int iB = r0.b(i);
        if (iB == 0) {
            s0Var.u(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            s0Var.s(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            s0Var.L(iA, (AbstractC2383g) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.e());
            }
            s0Var.c(iA, ((Integer) obj).intValue());
        } else if (s0Var.t() == s0.a.ASCENDING) {
            s0Var.x(iA);
            ((m0) obj).v(s0Var);
            s0Var.C(iA);
        } else {
            s0Var.C(iA);
            ((m0) obj).v(s0Var);
            s0Var.x(iA);
        }
    }

    void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int iV;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int iA = r0.a(i4);
            int iB = r0.b(i4);
            if (iB == 0) {
                iV = CodedOutputStream.V(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 1) {
                iV = CodedOutputStream.p(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 2) {
                iV = CodedOutputStream.h(iA, (AbstractC2383g) this.c[i3]);
            } else if (iB == 3) {
                iV = (CodedOutputStream.S(iA) * 2) + ((m0) this.c[i3]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.e());
                }
                iV = CodedOutputStream.n(iA, ((Integer) this.c[i3]).intValue());
            }
            i2 += iV;
        }
        this.d = i2;
        return i2;
    }

    public int e() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iH = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            iH += CodedOutputStream.H(r0.a(this.b[i2]), (AbstractC2383g) this.c[i2]);
        }
        this.d = iH;
        return iH;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        int i = this.a;
        return i == m0Var.a && s(this.b, m0Var.b, i) && p(this.c, m0Var.c, this.a);
    }

    public void h() {
        this.e = false;
    }

    public int hashCode() {
        int i = this.a;
        return ((((527 + i) * 31) + f(this.b, i)) * 31) + g(this.c, this.a);
    }

    boolean i(int i, AbstractC2384h abstractC2384h) throws InvalidProtocolBufferException.InvalidWireTypeException {
        a();
        int iA = r0.a(i);
        int iB = r0.b(i);
        if (iB == 0) {
            r(i, Long.valueOf(abstractC2384h.z()));
            return true;
        }
        if (iB == 1) {
            r(i, Long.valueOf(abstractC2384h.v()));
            return true;
        }
        if (iB == 2) {
            r(i, abstractC2384h.r());
            return true;
        }
        if (iB == 3) {
            m0 m0Var = new m0();
            m0Var.j(abstractC2384h);
            abstractC2384h.a(r0.c(iA, 4));
            r(i, m0Var);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw InvalidProtocolBufferException.e();
        }
        r(i, Integer.valueOf(abstractC2384h.u()));
        return true;
    }

    m0 k(m0 m0Var) {
        if (m0Var.equals(c())) {
            return this;
        }
        a();
        int i = this.a + m0Var.a;
        b(i);
        System.arraycopy(m0Var.b, 0, this.b, this.a, m0Var.a);
        System.arraycopy(m0Var.c, 0, this.c, this.a, m0Var.a);
        this.a = i;
        return this;
    }

    m0 l(int i, AbstractC2383g abstractC2383g) {
        a();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        r(r0.c(i, 2), abstractC2383g);
        return this;
    }

    m0 m(int i, int i2) {
        a();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        r(r0.c(i, 0), Long.valueOf(i2));
        return this;
    }

    final void q(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            Q.d(sb, i, String.valueOf(r0.a(this.b[i2])), this.c[i2]);
        }
    }

    void r(int i, Object obj) {
        a();
        b(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    void t(s0 s0Var) {
        if (s0Var.t() == s0.a.DESCENDING) {
            for (int i = this.a - 1; i >= 0; i--) {
                s0Var.b(r0.a(this.b[i]), this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            s0Var.b(r0.a(this.b[i2]), this.c[i2]);
        }
    }

    public void v(s0 s0Var) {
        if (this.a == 0) {
            return;
        }
        if (s0Var.t() == s0.a.ASCENDING) {
            for (int i = 0; i < this.a; i++) {
                u(this.b[i], this.c[i], s0Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            u(this.b[i2], this.c[i2], s0Var);
        }
    }

    private m0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
