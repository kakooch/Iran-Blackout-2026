package ir.nasim;

/* loaded from: classes2.dex */
public final class Z03 {
    public static final a b = new a(null);
    private static final int c = g(0);
    private static final int d = g(1);
    private static final int e = g(2);
    private static final int f = g(3);
    private static final int g = g(4);
    private final int a;

    public static final class a {
        private a() {
        }

        public final int a() {
            return Z03.d;
        }

        public final int b() {
            return Z03.c;
        }

        public final int c() {
            return Z03.f;
        }

        public final int d() {
            return Z03.g;
        }

        public final int e() {
            return Z03.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ Z03(int i) {
        this.a = i;
    }

    public static final /* synthetic */ Z03 f(int i) {
        return new Z03(i);
    }

    public static boolean h(int i, Object obj) {
        return (obj instanceof Z03) && i == ((Z03) obj).l();
    }

    public static final boolean i(int i, int i2) {
        return i == i2;
    }

    public static int j(int i) {
        return Integer.hashCode(i);
    }

    public static String k(int i) {
        return i(i, c) ? "Argb8888" : i(i, d) ? "Alpha8" : i(i, e) ? "Rgb565" : i(i, f) ? "F16" : i(i, g) ? "Gpu" : "Unknown";
    }

    public boolean equals(Object obj) {
        return h(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ int l() {
        return this.a;
    }

    public String toString() {
        return k(this.a);
    }

    public static int g(int i) {
        return i;
    }
}
