package ir.nasim;

/* renamed from: ir.nasim.oG5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18208oG5 {
    public static final String a(Object obj, Object obj2) {
        AbstractC13042fc3.i(obj, "from");
        AbstractC13042fc3.i(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(double d, double d2) {
        if (d2 <= d) {
            throw new IllegalArgumentException(a(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    public static final void c(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void d(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(a(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final int e(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final int f(AbstractC17026mG5 abstractC17026mG5, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(abstractC17026mG5, "<this>");
        AbstractC13042fc3.i(c24411ya3, "range");
        if (!c24411ya3.isEmpty()) {
            return c24411ya3.t() < Integer.MAX_VALUE ? abstractC17026mG5.j(c24411ya3.o(), c24411ya3.t() + 1) : c24411ya3.o() > Integer.MIN_VALUE ? abstractC17026mG5.j(c24411ya3.o() - 1, c24411ya3.t()) + 1 : abstractC17026mG5.f();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + c24411ya3);
    }

    public static final int g(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
