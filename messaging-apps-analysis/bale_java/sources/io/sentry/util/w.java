package io.sentry.util;

/* loaded from: classes3.dex */
public abstract class w {
    static boolean a;
    static boolean b;

    static {
        try {
            a = "The Android Project".equals(System.getProperty("java.vendor"));
        } catch (Throwable unused) {
            a = false;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                b = Double.valueOf(property).doubleValue() >= 9.0d;
            } else {
                b = false;
            }
        } catch (Throwable unused2) {
            b = false;
        }
    }

    public static boolean a() {
        return a;
    }

    public static boolean b() {
        return b;
    }

    public static boolean c() {
        return !a;
    }
}
