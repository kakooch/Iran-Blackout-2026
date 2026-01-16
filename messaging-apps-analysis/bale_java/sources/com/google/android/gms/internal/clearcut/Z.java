package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
abstract class Z {
    private static final X a = c();
    private static final X b = new Y();

    static X a() {
        return a;
    }

    static X b() {
        return b;
    }

    private static X c() {
        try {
            return (X) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
