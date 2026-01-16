package ir.nasim;

/* renamed from: ir.nasim.bm1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10534bm1 {
    private static final int a(int i, int i2, boolean z) {
        return f(i, i2, !z);
    }

    public static final int b(int i, int i2, int i3, boolean z) {
        return i2 >= i3 ? f(i2, i3, z) : g(i, i2, i3, z) ? e(i, i2, z) : h(i, i2, i3, z) ? d(i, i2, z) : a(i2, i3, z);
    }

    public static /* synthetic */ int c(int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z = true;
        }
        return b(i, i2, i3, z);
    }

    private static final int d(int i, int i2, boolean z) {
        return e(i, i2, !z);
    }

    private static final int e(int i, int i2, boolean z) {
        return z ? i : i - i2;
    }

    private static final int f(int i, int i2, boolean z) {
        if (z) {
            return 0;
        }
        return i2 - i;
    }

    private static final boolean g(int i, int i2, int i3, boolean z) {
        return h(i, i2, i3, !z);
    }

    private static final boolean h(int i, int i2, int i3, boolean z) {
        if (z) {
            if (i2 > i) {
                return false;
            }
        } else if (i3 - i2 <= i) {
            return false;
        }
        return true;
    }
}
