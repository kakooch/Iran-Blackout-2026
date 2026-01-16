package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class K0 {
    private static final I0 a = new J0();
    private static final I0 b;

    static {
        I0 i0 = null;
        try {
            i0 = (I0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = i0;
    }

    static I0 a() {
        I0 i0 = b;
        if (i0 != null) {
            return i0;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static I0 b() {
        return a;
    }
}
