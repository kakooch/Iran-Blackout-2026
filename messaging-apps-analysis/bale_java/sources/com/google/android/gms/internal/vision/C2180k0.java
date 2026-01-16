package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.AbstractC2178j0;

/* renamed from: com.google.android.gms.internal.vision.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2180k0 implements E0 {
    private static final C2180k0 a = new C2180k0();

    private C2180k0() {
    }

    public static C2180k0 c() {
        return a;
    }

    @Override // com.google.android.gms.internal.vision.E0
    public final boolean a(Class cls) {
        return AbstractC2178j0.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.vision.E0
    public final C0 b(Class cls) {
        if (!AbstractC2178j0.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (C0) AbstractC2178j0.h(cls.asSubclass(AbstractC2178j0.class)).m(AbstractC2178j0.d.c, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
