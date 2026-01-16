package ir.nasim;

/* renamed from: ir.nasim.Qq5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7189Qq5 {
    public static final void a(C16143km4 c16143km4, int i) {
        if (c16143km4.b == 0 || !(c16143km4.e(0) == i || c16143km4.e(c16143km4.b - 1) == i)) {
            int i2 = c16143km4.b;
            c16143km4.j(i);
            while (i2 > 0) {
                int i3 = ((i2 + 1) >>> 1) - 1;
                int iE = c16143km4.e(i3);
                if (i <= iE) {
                    break;
                }
                c16143km4.n(i2, iE);
                i2 = i3;
            }
            c16143km4.n(i2, i);
        }
    }

    public static /* synthetic */ C16143km4 c(C16143km4 c16143km4, int i, ED1 ed1) {
        int i2 = 1;
        if ((i & 1) != 0) {
            c16143km4 = new C16143km4(0, i2, null);
        }
        return b(c16143km4);
    }

    public static final boolean d(C16143km4 c16143km4) {
        return c16143km4.b != 0;
    }

    public static final int e(C16143km4 c16143km4) {
        return c16143km4.d();
    }

    public static final int f(C16143km4 c16143km4) {
        int iE;
        int i = c16143km4.b;
        int iE2 = c16143km4.e(0);
        while (c16143km4.b != 0 && c16143km4.e(0) == iE2) {
            c16143km4.n(0, c16143km4.h());
            c16143km4.m(c16143km4.b - 1);
            int i2 = c16143km4.b;
            int i3 = i2 >>> 1;
            int i4 = 0;
            while (i4 < i3) {
                int iE3 = c16143km4.e(i4);
                int i5 = (i4 + 1) * 2;
                int i6 = i5 - 1;
                int iE4 = c16143km4.e(i6);
                if (i5 >= i2 || (iE = c16143km4.e(i5)) <= iE4) {
                    if (iE4 > iE3) {
                        c16143km4.n(i4, iE4);
                        c16143km4.n(i6, iE3);
                        i4 = i6;
                    }
                } else if (iE > iE3) {
                    c16143km4.n(i4, iE);
                    c16143km4.n(i5, iE3);
                    i4 = i5;
                }
            }
        }
        return iE2;
    }

    public static C16143km4 b(C16143km4 c16143km4) {
        return c16143km4;
    }
}
