package ir.nasim;

import java.util.Formatter;

/* renamed from: ir.nasim.yJ1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C24256yJ1 {
    private final C3326Ak0 a;
    private final IW0[] b;

    C24256yJ1(C3326Ak0 c3326Ak0) {
        this.a = new C3326Ak0(c3326Ak0);
        this.b = new IW0[(c3326Ak0.e() - c3326Ak0.g()) + 1];
    }

    final C3326Ak0 a() {
        return this.a;
    }

    final IW0 b(int i) {
        return this.b[e(i)];
    }

    final IW0 c(int i) {
        IW0 iw0;
        IW0 iw02;
        IW0 iw0B = b(i);
        if (iw0B != null) {
            return iw0B;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iE = e(i) - i2;
            if (iE >= 0 && (iw02 = this.b[iE]) != null) {
                return iw02;
            }
            int iE2 = e(i) + i2;
            IW0[] iw0Arr = this.b;
            if (iE2 < iw0Arr.length && (iw0 = iw0Arr[iE2]) != null) {
                return iw0;
            }
        }
        return null;
    }

    final IW0[] d() {
        return this.b;
    }

    final int e(int i) {
        return i - this.a.g();
    }

    final void f(int i, IW0 iw0) {
        this.b[e(i)] = iw0;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (IW0 iw0 : this.b) {
                if (iw0 == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(iw0.c()), Integer.valueOf(iw0.e()));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
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
}
