package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2351m {
    static final Class a = c();

    public static C2352n a() {
        C2352n c2352nB = b("getEmptyRegistry");
        return c2352nB != null ? c2352nB : C2352n.d;
    }

    private static final C2352n b(String str) {
        Class cls = a;
        if (cls == null) {
            return null;
        }
        try {
            return (C2352n) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class c() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
