package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.c1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2110c1 {
    private static final C2107b1 a;
    private static final C2107b1 b;

    static {
        C2107b1 c2107b1 = null;
        try {
            c2107b1 = (C2107b1) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = c2107b1;
        b = new C2107b1();
    }

    static C2107b1 a() {
        return a;
    }

    static C2107b1 b() {
        return b;
    }
}
