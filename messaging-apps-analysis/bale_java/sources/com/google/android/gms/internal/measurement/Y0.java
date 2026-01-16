package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class Y0 implements InterfaceC2116e1 {
    private final InterfaceC2116e1[] a;

    Y0(InterfaceC2116e1... interfaceC2116e1Arr) {
        this.a = interfaceC2116e1Arr;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2116e1
    public final boolean a(Class cls) {
        InterfaceC2116e1[] interfaceC2116e1Arr = this.a;
        for (int i = 0; i < 2; i++) {
            if (interfaceC2116e1Arr[i].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2116e1
    public final InterfaceC2113d1 b(Class cls) {
        InterfaceC2116e1[] interfaceC2116e1Arr = this.a;
        for (int i = 0; i < 2; i++) {
            InterfaceC2116e1 interfaceC2116e1 = interfaceC2116e1Arr[i];
            if (interfaceC2116e1.a(cls)) {
                return interfaceC2116e1.b(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
