package com.google.protobuf;

/* renamed from: com.google.protobuf.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2397v {
    private static final AbstractC2395t a = new C2396u();
    private static final AbstractC2395t b = c();

    static AbstractC2395t a() {
        AbstractC2395t abstractC2395t = b;
        if (abstractC2395t != null) {
            return abstractC2395t;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static AbstractC2395t b() {
        return a;
    }

    private static AbstractC2395t c() {
        try {
            return (AbstractC2395t) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
