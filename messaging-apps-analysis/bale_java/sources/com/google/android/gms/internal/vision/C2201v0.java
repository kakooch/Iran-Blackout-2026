package com.google.android.gms.internal.vision;

import ir.nasim.Br8;

/* renamed from: com.google.android.gms.internal.vision.v0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2201v0 implements R0 {
    private static final E0 b = new C2199u0();
    private final E0 a;

    public C2201v0() {
        this(new C2205x0(C2180k0.c(), b()));
    }

    private static E0 b() {
        try {
            return (E0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return b;
        }
    }

    private static boolean c(C0 c0) {
        return c0.zza() == Br8.a;
    }

    @Override // com.google.android.gms.internal.vision.R0
    public final P0 a(Class cls) {
        Q0.p(cls);
        C0 c0B = this.a.b(cls);
        return c0B.c() ? AbstractC2178j0.class.isAssignableFrom(cls) ? H0.g(Q0.B(), AbstractC2168e0.a(), c0B.e()) : H0.g(Q0.f(), AbstractC2168e0.b(), c0B.e()) : AbstractC2178j0.class.isAssignableFrom(cls) ? c(c0B) ? F0.o(cls, c0B, J0.b(), AbstractC2190p0.c(), Q0.B(), AbstractC2168e0.a(), D0.b()) : F0.o(cls, c0B, J0.b(), AbstractC2190p0.c(), Q0.B(), null, D0.b()) : c(c0B) ? F0.o(cls, c0B, J0.a(), AbstractC2190p0.a(), Q0.f(), AbstractC2168e0.b(), D0.a()) : F0.o(cls, c0B, J0.a(), AbstractC2190p0.a(), Q0.v(), null, D0.a());
    }

    private C2201v0(E0 e0) {
        this.a = (E0) AbstractC2184m0.f(e0, "messageInfoFactory");
    }
}
