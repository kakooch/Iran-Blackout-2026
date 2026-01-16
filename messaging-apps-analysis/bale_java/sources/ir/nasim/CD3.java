package ir.nasim;

/* loaded from: classes2.dex */
public final class CD3 {
    public static final a b = new a(null);
    private static final int c = d(0);
    private static final int d = d(1);
    private final int a;

    public static final class a {
        private a() {
        }

        public final int a() {
            return CD3.d;
        }

        public final int b() {
            return CD3.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ CD3(int i) {
        this.a = i;
    }

    public static final /* synthetic */ CD3 c(int i) {
        return new CD3(i);
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof CD3) && i == ((CD3) obj).i();
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }

    public static int g(int i) {
        return Integer.hashCode(i);
    }

    public static String h(int i) {
        return f(i, c) ? "Polite" : f(i, d) ? "Assertive" : "Unknown";
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ int i() {
        return this.a;
    }

    public String toString() {
        return h(this.a);
    }

    private static int d(int i) {
        return i;
    }
}
