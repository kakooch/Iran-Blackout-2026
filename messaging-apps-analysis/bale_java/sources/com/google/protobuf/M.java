package com.google.protobuf;

/* loaded from: classes3.dex */
abstract class M {
    private static final K a = c();
    private static final K b = new L();

    static K a() {
        return a;
    }

    static K b() {
        return b;
    }

    private static K c() {
        try {
            return (K) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
