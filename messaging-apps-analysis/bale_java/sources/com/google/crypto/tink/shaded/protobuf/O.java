package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
abstract class O {
    private static final M a = c();
    private static final M b = new N();

    static M a() {
        return a;
    }

    static M b() {
        return b;
    }

    private static M c() {
        try {
            return (M) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
