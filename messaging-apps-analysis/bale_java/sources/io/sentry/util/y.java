package io.sentry.util;

import io.sentry.V3;

/* loaded from: classes3.dex */
public abstract class y {
    public static V3 a(V3 v3) {
        if (v3.c() != null) {
            return v3;
        }
        return new V3(v3.e(), v3.d(), b(null, v3.d(), v3.e()), v3.b(), v3.a());
    }

    public static Double b(Double d, Double d2, Boolean bool) {
        if (d != null) {
            return d;
        }
        double d3 = z.a().d();
        return (d2 == null || bool == null) ? Double.valueOf(d3) : bool.booleanValue() ? Double.valueOf(d3 * d2.doubleValue()) : Double.valueOf(d2.doubleValue() + (d3 * (1.0d - d2.doubleValue())));
    }

    public static boolean c(Double d) {
        return e(d, true);
    }

    public static boolean d(Double d) {
        return e(d, true);
    }

    private static boolean e(Double d, boolean z) {
        return d == null ? z : !d.isNaN() && d.doubleValue() >= 0.0d && d.doubleValue() <= 1.0d;
    }

    public static boolean f(Double d) {
        return e(d, true);
    }

    public static boolean g(Double d) {
        return h(d, true);
    }

    public static boolean h(Double d, boolean z) {
        return e(d, z);
    }
}
