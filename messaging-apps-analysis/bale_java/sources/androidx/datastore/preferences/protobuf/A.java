package androidx.datastore.preferences.protobuf;

import ir.nasim.EnumC3687Bx5;

/* loaded from: classes2.dex */
final class A implements W {
    private static final H b = new a();
    private final H a;

    static class a implements H {
        a() {
        }

        @Override // androidx.datastore.preferences.protobuf.H
        public G a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.H
        public boolean b(Class cls) {
            return false;
        }
    }

    private static class b implements H {
        private H[] a;

        b(H... hArr) {
            this.a = hArr;
        }

        @Override // androidx.datastore.preferences.protobuf.H
        public G a(Class cls) {
            for (H h : this.a) {
                if (h.b(cls)) {
                    return h.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.H
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
        return new b(C1949s.c(), c());
    }

    private static H c() {
        try {
            return (H) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return b;
        }
    }

    private static boolean d(G g) {
        return g.c() == EnumC3687Bx5.PROTO2;
    }

    private static V e(Class cls, G g) {
        return AbstractC1950t.class.isAssignableFrom(cls) ? d(g) ? K.M(cls, g, O.b(), AbstractC1955y.b(), X.L(), AbstractC1947p.b(), F.b()) : K.M(cls, g, O.b(), AbstractC1955y.b(), X.L(), null, F.b()) : d(g) ? K.M(cls, g, O.a(), AbstractC1955y.a(), X.G(), AbstractC1947p.a(), F.a()) : K.M(cls, g, O.a(), AbstractC1955y.a(), X.H(), null, F.a());
    }

    @Override // androidx.datastore.preferences.protobuf.W
    public V a(Class cls) {
        X.I(cls);
        G gA = this.a.a(cls);
        return gA.a() ? AbstractC1950t.class.isAssignableFrom(cls) ? L.l(X.L(), AbstractC1947p.b(), gA.b()) : L.l(X.G(), AbstractC1947p.a(), gA.b()) : e(cls, gA);
    }

    private A(H h) {
        this.a = (H) AbstractC1952v.b(h, "messageInfoFactory");
    }
}
