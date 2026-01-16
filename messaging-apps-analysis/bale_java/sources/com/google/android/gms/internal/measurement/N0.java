package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class N0 implements InterfaceC2116e1 {
    private static final N0 a = new N0();

    private N0() {
    }

    public static N0 c() {
        return a;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2116e1
    public final boolean a(Class cls) {
        return P0.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2116e1
    public final InterfaceC2113d1 b(Class cls) {
        if (!P0.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC2113d1) P0.y(cls.asSubclass(P0.class)).z(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }
}
