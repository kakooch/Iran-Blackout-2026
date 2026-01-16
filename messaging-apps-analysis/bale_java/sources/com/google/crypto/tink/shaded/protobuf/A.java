package com.google.crypto.tink.shaded.protobuf;

import ir.nasim.EnumC25235zx5;

/* loaded from: classes3.dex */
final class A implements W {
    private static final H b = new a();
    private final H a;

    class a implements H {
        a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.H
        public G a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.H
        public boolean b(Class cls) {
            return false;
        }
    }

    private static class b implements H {
        private H[] a;

        b(H... hArr) {
            this.a = hArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.H
        public G a(Class cls) {
            for (H h : this.a) {
                if (h.b(cls)) {
                    return h.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.H
        public boolean b(Class cls) {
            for (H h : this.a) {
                if (h.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public A() {
        this(b());
    }

    private static H b() {
        return new b(C2357t.c(), c());
    }

    private static H c() {
        try {
            return (H) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return b;
        }
    }

    private static boolean d(G g) {
        return g.c() == EnumC25235zx5.PROTO2;
    }

    private static V e(Class cls, G g) {
        return AbstractC2358u.class.isAssignableFrom(cls) ? d(g) ? K.T(cls, g, O.b(), AbstractC2362y.b(), X.L(), AbstractC2355q.b(), F.b()) : K.T(cls, g, O.b(), AbstractC2362y.b(), X.L(), null, F.b()) : d(g) ? K.T(cls, g, O.a(), AbstractC2362y.a(), X.G(), AbstractC2355q.a(), F.a()) : K.T(cls, g, O.a(), AbstractC2362y.a(), X.H(), null, F.a());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.W
    public V a(Class cls) {
        X.I(cls);
        G gA = this.a.a(cls);
        return gA.a() ? AbstractC2358u.class.isAssignableFrom(cls) ? L.m(X.L(), AbstractC2355q.b(), gA.b()) : L.m(X.G(), AbstractC2355q.a(), gA.b()) : e(cls, gA);
    }

    private A(H h) {
        this.a = (H) AbstractC2360w.b(h, "messageInfoFactory");
    }
}
