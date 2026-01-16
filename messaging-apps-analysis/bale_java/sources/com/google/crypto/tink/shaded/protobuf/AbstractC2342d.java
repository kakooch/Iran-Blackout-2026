package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2342d {
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
