package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2098w {
    private static final AbstractC2095t a = new C2096u();
    private static final AbstractC2095t b = a();

    private static AbstractC2095t a() {
        try {
            return (AbstractC2095t) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static AbstractC2095t b() {
        return a;
    }

    static AbstractC2095t c() {
        AbstractC2095t abstractC2095t = b;
        if (abstractC2095t != null) {
            return abstractC2095t;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
