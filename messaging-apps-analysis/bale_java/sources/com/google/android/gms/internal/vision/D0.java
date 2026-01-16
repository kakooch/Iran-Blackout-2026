package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
abstract class D0 {
    private static final B0 a = c();
    private static final B0 b = new A0();

    static B0 a() {
        return a;
    }

    static B0 b() {
        return b;
    }

    private static B0 c() {
        try {
            return (B0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
