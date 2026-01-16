package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class Z0 implements p1 {
    private static final InterfaceC2116e1 b = new X0();
    private final InterfaceC2116e1 a;

    public Z0() {
        InterfaceC2116e1 interfaceC2116e1;
        N0 n0C = N0.c();
        try {
            interfaceC2116e1 = (InterfaceC2116e1) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            interfaceC2116e1 = b;
        }
        Y0 y0 = new Y0(n0C, interfaceC2116e1);
        R0.f(y0, "messageInfoFactory");
        this.a = y0;
    }

    private static boolean b(InterfaceC2113d1 interfaceC2113d1) {
        return interfaceC2113d1.e() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.p1
    public final o1 a(Class cls) {
        q1.g(cls);
        InterfaceC2113d1 interfaceC2113d1B = this.a.b(cls);
        return interfaceC2113d1B.c() ? P0.class.isAssignableFrom(cls) ? h1.b(q1.b(), K0.b(), interfaceC2113d1B.zza()) : h1.b(q1.b0(), K0.a(), interfaceC2113d1B.zza()) : P0.class.isAssignableFrom(cls) ? b(interfaceC2113d1B) ? g1.L(cls, interfaceC2113d1B, j1.b(), V0.d(), q1.b(), K0.b(), AbstractC2110c1.b()) : g1.L(cls, interfaceC2113d1B, j1.b(), V0.d(), q1.b(), null, AbstractC2110c1.b()) : b(interfaceC2113d1B) ? g1.L(cls, interfaceC2113d1B, j1.a(), V0.c(), q1.b0(), K0.a(), AbstractC2110c1.a()) : g1.L(cls, interfaceC2113d1B, j1.a(), V0.c(), q1.a(), null, AbstractC2110c1.a());
    }
}
