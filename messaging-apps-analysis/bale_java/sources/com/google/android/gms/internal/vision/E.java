package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
abstract class E {
    private static final Class a = a("libcore.io.Memory");
    private static final boolean b;

    static {
        b = a("org.robolectric.Robolectric") != null;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean b() {
        return (a == null || b) ? false : true;
    }

    static Class c() {
        return a;
    }
}
