package com.google.protobuf;

/* loaded from: classes3.dex */
abstract class r {
    static final Class a = c();

    public static C2394s a() {
        C2394s c2394sB = b("getEmptyRegistry");
        return c2394sB != null ? c2394sB : C2394s.d;
    }

    private static final C2394s b(String str) {
        Class cls = a;
        if (cls == null) {
            return null;
        }
        try {
            return (C2394s) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
