package com.google.protobuf;

/* loaded from: classes3.dex */
abstract class W {
    private static final U a = c();
    private static final U b = new V();

    static U a() {
        return a;
    }

    static U b() {
        return b;
    }

    private static U c() {
        try {
            return (U) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
