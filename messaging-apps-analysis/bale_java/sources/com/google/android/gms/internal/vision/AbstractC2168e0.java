package com.google.android.gms.internal.vision;

/* renamed from: com.google.android.gms.internal.vision.e0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2168e0 {
    private static final AbstractC2166d0 a = new C2164c0();
    private static final AbstractC2166d0 b = c();

    static AbstractC2166d0 a() {
        return a;
    }

    static AbstractC2166d0 b() {
        AbstractC2166d0 abstractC2166d0 = b;
        if (abstractC2166d0 != null) {
            return abstractC2166d0;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static AbstractC2166d0 c() {
        try {
            return (AbstractC2166d0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
