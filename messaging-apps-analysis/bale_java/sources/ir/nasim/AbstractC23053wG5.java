package ir.nasim;

import ir.nasim.C16460lJ3;
import ir.nasim.C23231wa3;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.wG5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23053wG5 extends AbstractC22457vG5 {
    public static double c(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static float d(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int e(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long f(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static double g(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static float h(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int i(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long j(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static double k(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static float l(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static int m(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static int n(int i, InterfaceC10967cW0 interfaceC10967cW0) {
        AbstractC13042fc3.i(interfaceC10967cW0, "range");
        if (interfaceC10967cW0 instanceof InterfaceC10351bW0) {
            return ((Number) p(Integer.valueOf(i), (InterfaceC10351bW0) interfaceC10967cW0)).intValue();
        }
        if (!interfaceC10967cW0.isEmpty()) {
            return i < ((Number) interfaceC10967cW0.f()).intValue() ? ((Number) interfaceC10967cW0.f()).intValue() : i > ((Number) interfaceC10967cW0.j()).intValue() ? ((Number) interfaceC10967cW0.j()).intValue() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC10967cW0 + '.');
    }

    public static long o(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static Comparable p(Comparable comparable, InterfaceC10351bW0 interfaceC10351bW0) {
        AbstractC13042fc3.i(comparable, "<this>");
        AbstractC13042fc3.i(interfaceC10351bW0, "range");
        if (!interfaceC10351bW0.isEmpty()) {
            return (!interfaceC10351bW0.i(comparable, interfaceC10351bW0.f()) || interfaceC10351bW0.i(interfaceC10351bW0.f(), comparable)) ? (!interfaceC10351bW0.i(interfaceC10351bW0.j(), comparable) || interfaceC10351bW0.i(comparable, interfaceC10351bW0.j())) ? comparable : interfaceC10351bW0.j() : interfaceC10351bW0.f();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC10351bW0 + '.');
    }

    public static Comparable q(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        AbstractC13042fc3.i(comparable, "<this>");
        if (comparable2 == null || comparable3 == null) {
            if (comparable2 != null && comparable.compareTo(comparable2) < 0) {
                return comparable2;
            }
            if (comparable3 != null && comparable.compareTo(comparable3) > 0) {
                return comparable3;
            }
        } else {
            if (comparable2.compareTo(comparable3) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + comparable3 + " is less than minimum " + comparable2 + '.');
            }
            if (comparable.compareTo(comparable2) < 0) {
                return comparable2;
            }
            if (comparable.compareTo(comparable3) > 0) {
                return comparable3;
            }
        }
        return comparable;
    }

    public static C23231wa3 r(int i, int i2) {
        return C23231wa3.d.a(i, i2, -1);
    }

    public static /* synthetic */ boolean s(InterfaceC10967cW0 interfaceC10967cW0, float f) {
        AbstractC13042fc3.i(interfaceC10967cW0, "<this>");
        Integer numX = x(f);
        if (numX != null) {
            return interfaceC10967cW0.h(numX);
        }
        return false;
    }

    public static int t(C24411ya3 c24411ya3, AbstractC17026mG5 abstractC17026mG5) {
        AbstractC13042fc3.i(c24411ya3, "<this>");
        AbstractC13042fc3.i(abstractC17026mG5, "random");
        try {
            return AbstractC18208oG5.f(abstractC17026mG5, c24411ya3);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static C23231wa3 u(C23231wa3 c23231wa3) {
        AbstractC13042fc3.i(c23231wa3, "<this>");
        return C23231wa3.d.a(c23231wa3.t(), c23231wa3.o(), -c23231wa3.v());
    }

    public static C23231wa3 v(C23231wa3 c23231wa3, int i) {
        AbstractC13042fc3.i(c23231wa3, "<this>");
        AbstractC22457vG5.a(i > 0, Integer.valueOf(i));
        C23231wa3.a aVar = C23231wa3.d;
        int iO = c23231wa3.o();
        int iT = c23231wa3.t();
        if (c23231wa3.v() <= 0) {
            i = -i;
        }
        return aVar.a(iO, iT, i);
    }

    public static C16460lJ3 w(C16460lJ3 c16460lJ3, long j) {
        AbstractC13042fc3.i(c16460lJ3, "<this>");
        AbstractC22457vG5.a(j > 0, Long.valueOf(j));
        C16460lJ3.a aVar = C16460lJ3.d;
        long jO = c16460lJ3.o();
        long jT = c16460lJ3.t();
        if (c16460lJ3.v() <= 0) {
            j = -j;
        }
        return aVar.a(jO, jT, j);
    }

    public static final Integer x(float f) {
        if (-2.1474836E9f > f || f > 2.1474836E9f) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    public static C24411ya3 y(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? C24411ya3.e.a() : new C24411ya3(i, i2 - 1);
    }

    public static C17642nJ3 z(long j, long j2) {
        return j2 <= Long.MIN_VALUE ? C17642nJ3.e.a() : new C17642nJ3(j, j2 - 1);
    }
}
