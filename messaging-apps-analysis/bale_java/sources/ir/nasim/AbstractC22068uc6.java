package ir.nasim;

/* renamed from: ir.nasim.uc6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22068uc6 {
    public static final long[] a = {-9187201950435737345L, -1};
    private static final C7386Rm4 b = new C7386Rm4(0);

    public static final int a(int i) {
        if (i == 7) {
            return 6;
        }
        return i - (i / 8);
    }

    public static final C7386Rm4 b() {
        return new C7386Rm4(0, 1, null);
    }

    public static final int c(int i) {
        if (i == 0) {
            return 6;
        }
        return (i * 2) + 1;
    }

    public static final int d(int i) {
        if (i > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    public static final int e(int i) {
        if (i == 7) {
            return 8;
        }
        return i + ((i - 1) / 7);
    }
}
