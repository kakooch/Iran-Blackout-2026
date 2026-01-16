package com.google.android.gms.internal.vision;

/* renamed from: com.google.android.gms.internal.vision.x0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2205x0 implements E0 {
    private E0[] a;

    C2205x0(E0... e0Arr) {
        this.a = e0Arr;
    }

    @Override // com.google.android.gms.internal.vision.E0
    public final boolean a(Class cls) {
        for (E0 e0 : this.a) {
            if (e0.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.E0
    public final C0 b(Class cls) {
        for (E0 e0 : this.a) {
            if (e0.a(cls)) {
                return e0.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
