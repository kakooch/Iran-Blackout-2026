package ir.nasim;

/* renamed from: ir.nasim.Au2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3418Au2 {
    public static final a b = new a(null);
    private static final int c = d(0);
    private static final int d = d(1);
    private final int a;

    /* renamed from: ir.nasim.Au2$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C3418Au2.d;
        }

        public final int b() {
            return C3418Au2.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C3418Au2(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C3418Au2 c(int i) {
        return new C3418Au2(i);
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof C3418Au2) && i == ((C3418Au2) obj).i();
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }

    public static int g(int i) {
        return Integer.hashCode(i);
    }

    public static String h(int i) {
        return f(i, c) ? "Normal" : f(i, d) ? "Italic" : "Invalid";
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

    public static int d(int i) {
        return i;
    }
}
