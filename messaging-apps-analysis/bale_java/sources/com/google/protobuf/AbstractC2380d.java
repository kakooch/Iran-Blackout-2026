package com.google.protobuf;

/* renamed from: com.google.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2380d {
    private static boolean a;
    private static final Class b = a("libcore.io.Memory");
    private static final boolean c;

    static {
        c = (a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class b() {
        return b;
    }

    static boolean c() {
        return a || !(b == null || c);
    }
}
