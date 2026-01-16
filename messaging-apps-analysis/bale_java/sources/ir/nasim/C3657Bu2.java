package ir.nasim;

/* renamed from: ir.nasim.Bu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3657Bu2 {
    public static final a b = new a(null);
    private static final int c = f(0);
    private static final int d = f(1);
    private static final int e = f(2);
    private static final int f = f(65535);
    private final int a;

    /* renamed from: ir.nasim.Bu2$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C3657Bu2.f;
        }

        public final int b() {
            return C3657Bu2.c;
        }

        public final int c() {
            return C3657Bu2.e;
        }

        public final int d() {
            return C3657Bu2.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C3657Bu2(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C3657Bu2 e(int i) {
        return new C3657Bu2(i);
    }

    public static boolean g(int i, Object obj) {
        return (obj instanceof C3657Bu2) && i == ((C3657Bu2) obj).m();
    }

    public static final boolean h(int i, int i2) {
        return i == i2;
    }

    public static int i(int i) {
        return Integer.hashCode(i);
    }

    public static final boolean j(int i) {
        return (i & 2) != 0;
    }

    public static final boolean k(int i) {
        return (i & 1) != 0;
    }

    public static String l(int i) {
        return h(i, c) ? "None" : h(i, d) ? "Weight" : h(i, e) ? "Style" : h(i, f) ? "All" : "Invalid";
    }

    public boolean equals(Object obj) {
        return g(this.a, obj);
    }

    public int hashCode() {
        return i(this.a);
    }

    public final /* synthetic */ int m() {
        return this.a;
    }

    public String toString() {
        return l(this.a);
    }

    public static int f(int i) {
        return i;
    }
}
