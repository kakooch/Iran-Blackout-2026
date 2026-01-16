package com.google.protobuf;

import ir.nasim.EnumC3448Ax5;

/* loaded from: classes3.dex */
final class H implements f0 {
    private static final O b = new a();
    private final O a;

    class a implements O {
        a() {
        }

        @Override // com.google.protobuf.O
        public N a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.O
        public boolean b(Class cls) {
            return false;
        }
    }

    private static class b implements O {
        private O[] a;

        b(O... oArr) {
            this.a = oArr;
        }

        @Override // com.google.protobuf.O
        public N a(Class cls) {
            for (O o : this.a) {
                if (o.b(cls)) {
                    return o.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.O
        public boolean b(Class cls) {
            for (O o : this.a) {
                if (o.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public H() {
        this(b());
    }

    private static O b() {
        return new b(C2401z.c(), c());
    }

    private static O c() {
        try {
            return (O) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return b;
        }
    }

    private static boolean d(N n) {
        return n.c() == EnumC3448Ax5.PROTO2;
    }

    private static e0 e(Class cls, N n) {
        return GeneratedMessageLite.class.isAssignableFrom(cls) ? d(n) ? S.V(cls, n, W.b(), F.b(), g0.M(), AbstractC2397v.b(), M.b()) : S.V(cls, n, W.b(), F.b(), g0.M(), null, M.b()) : d(n) ? S.V(cls, n, W.a(), F.a(), g0.H(), AbstractC2397v.a(), M.a()) : S.V(cls, n, W.a(), F.a(), g0.I(), null, M.a());
    }

    @Override // com.google.protobuf.f0
    public e0 a(Class cls) {
        g0.J(cls);
        N nA = this.a.a(cls);
        return nA.a() ? GeneratedMessageLite.class.isAssignableFrom(cls) ? T.m(g0.M(), AbstractC2397v.b(), nA.b()) : T.m(g0.H(), AbstractC2397v.a(), nA.b()) : e(cls, nA);
    }

    private H(O o) {
        this.a = (O) B.b(o, "messageInfoFactory");
    }
}
