package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;
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

    static m0 a(m0 m0Var, m0 m0Var2) {
        int i = m0Var.a + m0Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(m0Var.b, i);
        System.arraycopy(m0Var2.b, 0, iArrCopyOf, m0Var.a, m0Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(m0Var.c, i);
        System.arraycopy(m0Var2.c, 0, objArrCopyOf, m0Var.a, m0Var2.a);
        return new m0(i, iArrCopyOf, objArrCopyOf, true);
    }

    private static void f(int i, Object obj, v0 v0Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            v0Var.M(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            v0Var.j(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            v0Var.H(i2, (AbstractC2081f) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                throw new RuntimeException(zzco.c());
            }
            v0Var.r(i2, ((Integer) obj).intValue());
        } else if (v0Var.K() == AbstractC2101z.c.l) {
            v0Var.O(i2);
            ((m0) obj).g(v0Var);
            v0Var.G(i2);
        } else {
            v0Var.G(i2);
            ((m0) obj).g(v0Var);
            v0Var.O(i2);
        }
    }

    public static m0 h() {
        return f;
    }

    static m0 i() {
        return new m0();
    }

    final void b(v0 v0Var) {
        if (v0Var.K() == AbstractC2101z.c.m) {
            for (int i = this.a - 1; i >= 0; i--) {
                v0Var.k(this.b[i] >>> 3, this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            v0Var.k(this.b[i2] >>> 3, this.c[i2]);
        }
    }

    final void c(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            U.c(sb, i, String.valueOf(this.b[i2] >>> 3), this.c[i2]);
        }
    }

    public final int d() {
        int iX;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iX = zzbn.X(i5, ((Long) this.c[i3]).longValue());
            } else if (i6 == 1) {
                iX = zzbn.e0(i5, ((Long) this.c[i3]).longValue());
            } else if (i6 == 2) {
                iX = zzbn.K(i5, (AbstractC2081f) this.c[i3]);
            } else if (i6 == 3) {
                iX = (zzbn.v0(i5) << 1) + ((m0) this.c[i3]).d();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzco.c());
                }
                iX = zzbn.n0(i5, ((Integer) this.c[i3]).intValue());
            }
            i2 += iX;
        }
        this.d = i2;
        return i2;
    }

    final void e(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.b = Arrays.copyOf(iArr, i3);
            this.c = Arrays.copyOf(this.c, i3);
        }
        int[] iArr2 = this.b;
        int i4 = this.a;
        iArr2[i4] = i;
        this.c[i4] = obj;
        this.a = i4 + 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        int i = this.a;
        if (i == m0Var.a) {
            int[] iArr = this.b;
            int[] iArr2 = m0Var.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = m0Var.c;
                    int i3 = this.a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final void g(v0 v0Var) {
        if (this.a == 0) {
            return;
        }
        if (v0Var.K() == AbstractC2101z.c.l) {
            for (int i = 0; i < this.a; i++) {
                f(this.b[i], this.c[i], v0Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            f(this.b[i2], this.c[i2], v0Var);
        }
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int j() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iU = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            iU += zzbn.U(this.b[i2] >>> 3, (AbstractC2081f) this.c[i2]);
        }
        this.d = iU;
        return iU;
    }

    public final void k() {
        this.e = false;
    }

    private m0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
