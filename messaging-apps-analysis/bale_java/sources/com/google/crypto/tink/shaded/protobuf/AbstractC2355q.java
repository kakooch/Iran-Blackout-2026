package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2355q {
    private static final AbstractC2353o a = new C2354p();
    private static final AbstractC2353o b = c();

    static AbstractC2353o a() {
        AbstractC2353o abstractC2353o = b;
        if (abstractC2353o != null) {
            return abstractC2353o;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static AbstractC2353o b() {
        return a;
    }

    private static AbstractC2353o c() {
        try {
            return (AbstractC2353o) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
