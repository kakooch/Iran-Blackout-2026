package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
abstract class Q {
    private static final O a = c();
    private static final O b = new P();

    static O a() {
        return a;
    }

    static O b() {
        return b;
    }

    private static O c() {
        try {
            return (O) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
