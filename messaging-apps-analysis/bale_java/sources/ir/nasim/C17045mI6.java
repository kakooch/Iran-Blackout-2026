package ir.nasim;

/* renamed from: ir.nasim.mI6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17045mI6 {
    public static final C17045mI6 a = new C17045mI6();
    private static final int b = C22078ud6.a(2.0f);
    private static int c = -1;
    private static int d = -1;
    public static final int e = 8;

    private C17045mI6() {
    }

    public static final int b() {
        if (d == -1) {
            d = C22078ud6.a(96.0f);
        }
        return d;
    }

    public static final int c() {
        if (c == -1) {
            int iC = C22078ud6.c();
            int iB = b();
            int i = iC / iB;
            c = i;
            int i2 = b;
            if ((i * iB) + ((i + 1) * i2) > iC) {
                c = i - 1;
            }
            int i3 = c;
            int i4 = (i3 * iB) + ((i3 + 1) * i2);
            if (i4 < iC) {
                d(iB + ((iC - i4) / i3));
            }
        }
        return c;
    }

    private static final void d(int i) {
        d = i;
    }

    public final int a() {
        return b;
    }
}
