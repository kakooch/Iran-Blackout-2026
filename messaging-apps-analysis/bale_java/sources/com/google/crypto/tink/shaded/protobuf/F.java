package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
abstract class F {
    private static final D a = c();
    private static final D b = new E();

    static D a() {
        return a;
    }

    static D b() {
        return b;
    }

    private static D c() {
        try {
            return (D) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
