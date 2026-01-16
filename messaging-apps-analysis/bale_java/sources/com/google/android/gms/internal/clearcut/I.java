package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.AbstractC2101z;

/* loaded from: classes3.dex */
final class I implements g0 {
    private static final T b = new J();
    private final T a;

    public I() {
        this(new K(C2100y.c(), c()));
    }

    private static boolean b(S s) {
        return s.a() == AbstractC2101z.c.i;
    }

    private static T c() {
        try {
            return (T) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return b;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.g0
    public final InterfaceC2082f0 a(Class cls) {
        h0.I(cls);
        S sB = this.a.b(cls);
        if (sB.b()) {
            return AbstractC2101z.class.isAssignableFrom(cls) ? W.j(h0.B(), AbstractC2098w.b(), sB.c()) : W.j(h0.z(), AbstractC2098w.c(), sB.c());
        }
        if (!AbstractC2101z.class.isAssignableFrom(cls)) {
            boolean zB = b(sB);
            X xA = Z.a();
            D dC = D.c();
            return zB ? V.s(cls, sB, xA, dC, h0.z(), AbstractC2098w.c(), Q.a()) : V.s(cls, sB, xA, dC, h0.A(), null, Q.a());
        }
        boolean zB2 = b(sB);
        X xB = Z.b();
        D d = D.d();
        l0 l0VarB = h0.B();
        return zB2 ? V.s(cls, sB, xB, d, l0VarB, AbstractC2098w.b(), Q.b()) : V.s(cls, sB, xB, d, l0VarB, null, Q.b());
    }

    private I(T t) {
        this.a = (T) B.e(t, "messageInfoFactory");
    }
}
