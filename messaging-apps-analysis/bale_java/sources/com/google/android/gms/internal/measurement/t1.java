package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class t1 {
    private static final t1 f = new t1(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;
    private int d = -1;
    private boolean e;

    private t1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static t1 c() {
        return f;
    }

    static t1 e(t1 t1Var, t1 t1Var2) {
        int i = t1Var.a + t1Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(t1Var.b, i);
        System.arraycopy(t1Var2.b, 0, iArrCopyOf, t1Var.a, t1Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(t1Var.c, i);
        System.arraycopy(t1Var2.c, 0, objArrCopyOf, t1Var.a, t1Var2.a);
        return new t1(i, iArrCopyOf, objArrCopyOf, true);
    }

    static t1 f() {
        return new t1(0, new int[8], new Object[8], true);
    }

    private final void l(int i) {
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

    public final int a() {
        int iA;
        int iB;
        int iA2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA3 = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.c[i2]).longValue();
                    iA2 = E0.a(i4 << 3) + 8;
                } else if (i5 == 2) {
                    A0 a0 = (A0) this.c[i2];
                    int iA4 = E0.a(i4 << 3);
                    int iR = a0.r();
                    iA3 += iA4 + E0.a(iR) + iR;
                } else if (i5 == 3) {
                    int iC = E0.C(i4);
                    iA = iC + iC;
                    iB = ((t1) this.c[i2]).a();
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException(zzkp.a());
                    }
                    ((Integer) this.c[i2]).intValue();
                    iA2 = E0.a(i4 << 3) + 4;
                }
                iA3 += iA2;
            } else {
                long jLongValue = ((Long) this.c[i2]).longValue();
                iA = E0.a(i4 << 3);
                iB = E0.b(jLongValue);
            }
            iA2 = iA + iB;
            iA3 += iA2;
        }
        this.d = iA3;
        return iA3;
    }

    public final int b() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            A0 a0 = (A0) this.c[i2];
            int iA2 = E0.a(8);
            int iR = a0.r();
            iA += iA2 + iA2 + E0.a(16) + E0.a(i3 >>> 3) + E0.a(24) + E0.a(iR) + iR;
        }
        this.d = iA;
        return iA;
    }

    final t1 d(t1 t1Var) {
        if (t1Var.equals(f)) {
            return this;
        }
        g();
        int i = this.a + t1Var.a;
        l(i);
        System.arraycopy(t1Var.b, 0, this.b, this.a, t1Var.a);
        System.arraycopy(t1Var.c, 0, this.c, this.a, t1Var.a);
        this.a = i;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        int i = this.a;
        if (i == t1Var.a) {
            int[] iArr = this.b;
            int[] iArr2 = t1Var.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = t1Var.c;
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

    final void g() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        this.e = false;
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

    final void i(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            AbstractC2119f1.b(sb, i, String.valueOf(this.b[i2] >>> 3), this.c[i2]);
        }
    }

    final void j(int i, Object obj) {
        g();
        l(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void k(F1 f1) {
        if (this.a != 0) {
            for (int i = 0; i < this.a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    f1.j(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    f1.H(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    f1.k(i3, (A0) obj);
                } else if (i4 == 3) {
                    f1.q(i3);
                    ((t1) obj).k(f1);
                    f1.t(i3);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(zzkp.a());
                    }
                    f1.w(i3, ((Integer) obj).intValue());
                }
            }
        }
    }
}
