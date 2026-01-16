package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC19162ps8;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class h1 {
    private static final h1 f = new h1(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;

    private h1() {
        this(0, new int[8], new Object[8], true);
    }

    public static h1 a() {
        return f;
    }

    static h1 b(h1 h1Var, h1 h1Var2) {
        int i = h1Var.a + h1Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(h1Var.b, i);
        System.arraycopy(h1Var2.b, 0, iArrCopyOf, h1Var.a, h1Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(h1Var.c, i);
        System.arraycopy(h1Var2.c, 0, objArrCopyOf, h1Var.a, h1Var2.a);
        return new h1(i, iArrCopyOf, objArrCopyOf, true);
    }

    private static void d(int i, Object obj, q1 q1Var) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            q1Var.o(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            q1Var.G(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            q1Var.I(i2, (K) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                throw new RuntimeException(zzjk.d());
            }
            q1Var.u(i2, ((Integer) obj).intValue());
        } else if (q1Var.zza() == AbstractC19162ps8.a) {
            q1Var.zza(i2);
            ((h1) obj).h(q1Var);
            q1Var.l(i2);
        } else {
            q1Var.l(i2);
            ((h1) obj).h(q1Var);
            q1Var.zza(i2);
        }
    }

    static h1 g() {
        return new h1();
    }

    final void c(int i, Object obj) {
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

    final void e(q1 q1Var) {
        if (q1Var.zza() == AbstractC19162ps8.b) {
            for (int i = this.a - 1; i >= 0; i--) {
                q1Var.k(this.b[i] >>> 3, this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            q1Var.k(this.b[i2] >>> 3, this.c[i2]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        int i = this.a;
        if (i == h1Var.a) {
            int[] iArr = this.b;
            int[] iArr2 = h1Var.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = h1Var.c;
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

    final void f(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            G0.d(sb, i, String.valueOf(this.b[i2] >>> 3), this.c[i2]);
        }
    }

    public final void h(q1 q1Var) {
        if (this.a == 0) {
            return;
        }
        if (q1Var.zza() == AbstractC19162ps8.a) {
            for (int i = 0; i < this.a; i++) {
                d(this.b[i], this.c[i], q1Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            d(this.b[i2], this.c[i2], q1Var);
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

    public final void i() {
        this.e = false;
    }

    public final int j() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iY = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            iY += zzii.Y(this.b[i2] >>> 3, (K) this.c[i2]);
        }
        this.d = iY;
        return iY;
    }

    public final int k() {
        int iD0;
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
                iD0 = zzii.d0(i5, ((Long) this.c[i3]).longValue());
            } else if (i6 == 1) {
                iD0 = zzii.m0(i5, ((Long) this.c[i3]).longValue());
            } else if (i6 == 2) {
                iD0 = zzii.P(i5, (K) this.c[i3]);
            } else if (i6 == 3) {
                iD0 = (zzii.c0(i5) << 1) + ((h1) this.c[i3]).k();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzjk.d());
                }
                iD0 = zzii.t0(i5, ((Integer) this.c[i3]).intValue());
            }
            i2 += iD0;
        }
        this.d = i2;
        return i2;
    }

    private h1(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }
}
