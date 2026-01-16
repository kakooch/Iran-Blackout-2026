package ir.nasim;

import java.util.Formatter;

/* renamed from: ir.nasim.xJ1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23666xJ1 {
    private final C10143b90 a;
    private final C24256yJ1[] b;
    private C3326Ak0 c;
    private final int d;

    C23666xJ1(C10143b90 c10143b90, C3326Ak0 c3326Ak0) {
        this.a = c10143b90;
        int iA = c10143b90.a();
        this.d = iA;
        this.c = c3326Ak0;
        this.b = new C24256yJ1[iA + 2];
    }

    private void a(C24256yJ1 c24256yJ1) {
        if (c24256yJ1 != null) {
            ((C24850zJ1) c24256yJ1).g(this.a);
        }
    }

    private static boolean b(IW0 iw0, IW0 iw02) {
        if (iw02 == null || !iw02.g() || iw02.a() != iw0.a()) {
            return false;
        }
        iw0.i(iw02.c());
        return true;
    }

    private static int c(int i, int i2, IW0 iw0) {
        if (iw0 == null || iw0.g()) {
            return i2;
        }
        if (!iw0.h(i)) {
            return i2 + 1;
        }
        iw0.i(i);
        return 0;
    }

    private int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            IW0[] iw0ArrD = this.b[i].d();
            for (int i2 = 0; i2 < iw0ArrD.length; i2++) {
                IW0 iw0 = iw0ArrD[i2];
                if (iw0 != null && !iw0.g()) {
                    e(i, i2, iw0ArrD);
                }
            }
        }
        return iF;
    }

    private void e(int i, int i2, IW0[] iw0Arr) {
        IW0 iw0 = iw0Arr[i2];
        IW0[] iw0ArrD = this.b[i - 1].d();
        C24256yJ1 c24256yJ1 = this.b[i + 1];
        IW0[] iw0ArrD2 = c24256yJ1 != null ? c24256yJ1.d() : iw0ArrD;
        IW0[] iw0Arr2 = new IW0[14];
        iw0Arr2[2] = iw0ArrD[i2];
        iw0Arr2[3] = iw0ArrD2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            iw0Arr2[0] = iw0Arr[i3];
            iw0Arr2[4] = iw0ArrD[i3];
            iw0Arr2[5] = iw0ArrD2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            iw0Arr2[8] = iw0Arr[i4];
            iw0Arr2[10] = iw0ArrD[i4];
            iw0Arr2[11] = iw0ArrD2[i4];
        }
        if (i2 < iw0Arr.length - 1) {
            int i5 = i2 + 1;
            iw0Arr2[1] = iw0Arr[i5];
            iw0Arr2[6] = iw0ArrD[i5];
            iw0Arr2[7] = iw0ArrD2[i5];
        }
        if (i2 < iw0Arr.length - 2) {
            int i6 = i2 + 2;
            iw0Arr2[9] = iw0Arr[i6];
            iw0Arr2[12] = iw0ArrD[i6];
            iw0Arr2[13] = iw0ArrD2[i6];
        }
        for (int i7 = 0; i7 < 14 && !b(iw0, iw0Arr2[i7]); i7++) {
        }
    }

    private int f() {
        g();
        return h() + i();
    }

    private void g() {
        C24256yJ1[] c24256yJ1Arr = this.b;
        C24256yJ1 c24256yJ1 = c24256yJ1Arr[0];
        if (c24256yJ1 == null || c24256yJ1Arr[this.d + 1] == null) {
            return;
        }
        IW0[] iw0ArrD = c24256yJ1.d();
        IW0[] iw0ArrD2 = this.b[this.d + 1].d();
        for (int i = 0; i < iw0ArrD.length; i++) {
            IW0 iw0 = iw0ArrD[i];
            if (iw0 != null && iw0ArrD2[i] != null && iw0.c() == iw0ArrD2[i].c()) {
                for (int i2 = 1; i2 <= this.d; i2++) {
                    IW0 iw02 = this.b[i2].d()[i];
                    if (iw02 != null) {
                        iw02.i(iw0ArrD[i].c());
                        if (!iw02.g()) {
                            this.b[i2].d()[i] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        C24256yJ1 c24256yJ1 = this.b[0];
        if (c24256yJ1 == null) {
            return 0;
        }
        IW0[] iw0ArrD = c24256yJ1.d();
        int i = 0;
        for (int i2 = 0; i2 < iw0ArrD.length; i2++) {
            IW0 iw0 = iw0ArrD[i2];
            if (iw0 != null) {
                int iC = iw0.c();
                int iC2 = 0;
                for (int i3 = 1; i3 < this.d + 1 && iC2 < 2; i3++) {
                    IW0 iw02 = this.b[i3].d()[i2];
                    if (iw02 != null) {
                        iC2 = c(iC, iC2, iw02);
                        if (!iw02.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    private int i() {
        C24256yJ1[] c24256yJ1Arr = this.b;
        int i = this.d;
        if (c24256yJ1Arr[i + 1] == null) {
            return 0;
        }
        IW0[] iw0ArrD = c24256yJ1Arr[i + 1].d();
        int i2 = 0;
        for (int i3 = 0; i3 < iw0ArrD.length; i3++) {
            IW0 iw0 = iw0ArrD[i3];
            if (iw0 != null) {
                int iC = iw0.c();
                int iC2 = 0;
                for (int i4 = this.d + 1; i4 > 0 && iC2 < 2; i4--) {
                    IW0 iw02 = this.b[i4].d()[i3];
                    if (iw02 != null) {
                        iC2 = c(iC, iC2, iw02);
                        if (!iw02.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    int j() {
        return this.d;
    }

    int k() {
        return this.a.b();
    }

    int l() {
        return this.a.c();
    }

    C3326Ak0 m() {
        return this.c;
    }

    C24256yJ1 n(int i) {
        return this.b[i];
    }

    C24256yJ1[] o() {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i) {
                break;
            }
            i = iD;
        }
        return this.b;
    }

    void p(C3326Ak0 c3326Ak0) {
        this.c = c3326Ak0;
    }

    void q(int i, C24256yJ1 c24256yJ1) {
        this.b[i] = c24256yJ1;
    }

    public String toString() {
        C24256yJ1[] c24256yJ1Arr = this.b;
        C24256yJ1 c24256yJ1 = c24256yJ1Arr[0];
        if (c24256yJ1 == null) {
            c24256yJ1 = c24256yJ1Arr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c24256yJ1.d().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    C24256yJ1 c24256yJ12 = this.b[i2];
                    if (c24256yJ12 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        IW0 iw0 = c24256yJ12.d()[i];
                        if (iw0 == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(iw0.c()), Integer.valueOf(iw0.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
