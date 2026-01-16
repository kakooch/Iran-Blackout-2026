package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class j1 {
    private static final i1 a;
    private static final i1 b;

    static {
        i1 i1Var = null;
        try {
            i1Var = (i1) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = i1Var;
        b = new i1();
    }

    static i1 a() {
        return a;
    }

    static i1 b() {
        return b;
    }
}
