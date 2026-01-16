package ir.nasim;

/* renamed from: ir.nasim.hp3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14383hp3 {
    public static final a b = new a(null);
    private static final int c = g(-1);
    private static final int d = g(0);
    private static final int e = g(1);
    private static final int f = g(2);
    private static final int g = g(3);
    private final int a;

    /* renamed from: ir.nasim.hp3$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C14383hp3.e;
        }

        public final int b() {
            return C14383hp3.d;
        }

        public final int c() {
            return C14383hp3.g;
        }

        public final int d() {
            return C14383hp3.c;
        }

        public final int e() {
            return C14383hp3.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C14383hp3(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C14383hp3 f(int i) {
        return new C14383hp3(i);
    }

    public static boolean h(int i, Object obj) {
        return (obj instanceof C14383hp3) && i == ((C14383hp3) obj).l();
    }

    public static final boolean i(int i, int i2) {
        return i == i2;
    }

    public static int j(int i) {
        return Integer.hashCode(i);
    }

    public static String k(int i) {
        return i(i, c) ? "Unspecified" : i(i, d) ? "None" : i(i, e) ? "Characters" : i(i, f) ? "Words" : i(i, g) ? "Sentences" : "Invalid";
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

    private static int g(int i) {
        return i;
    }
}
