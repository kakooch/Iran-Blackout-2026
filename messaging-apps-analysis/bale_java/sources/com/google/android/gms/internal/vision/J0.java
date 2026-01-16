package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
abstract class J0 {
    private static final I0 a = c();
    private static final I0 b = new K0();

    static I0 a() {
        return a;
    }

    static I0 b() {
        return b;
    }

    private static I0 c() {
        try {
            return (I0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
