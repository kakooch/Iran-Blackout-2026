package ir.nasim;

/* loaded from: classes3.dex */
public final class W84 {
    private static final W84 b = new a().a();
    private final V84 a;

    public static final class a {
        private V84 a = null;

        a() {
        }

        public W84 a() {
            return new W84(this.a);
        }

        public a b(V84 v84) {
            this.a = v84;
            return this;
        }
    }

    W84(V84 v84) {
        this.a = v84;
    }

    public static a b() {
        return new a();
    }

    public V84 a() {
        return this.a;
    }

    public byte[] c() {
        return AbstractC16844lx5.a(this);
    }
}
