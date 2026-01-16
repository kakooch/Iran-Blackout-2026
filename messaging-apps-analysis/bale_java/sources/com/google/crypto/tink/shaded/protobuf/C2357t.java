package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2357t implements H {
    private static final C2357t a = new C2357t();

    private C2357t() {
    }

    public static C2357t c() {
        return a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public G a(Class cls) {
        if (!AbstractC2358u.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (G) AbstractC2358u.s(cls.asSubclass(AbstractC2358u.class)).g();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.H
    public boolean b(Class cls) {
        return AbstractC2358u.class.isAssignableFrom(cls);
    }
}
