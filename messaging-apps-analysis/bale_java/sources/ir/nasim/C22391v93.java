package ir.nasim;

/* renamed from: ir.nasim.v93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22391v93 {
    public static final a b = new a(null);
    private static final int c = d(1);
    private static final int d = d(2);
    private final int a;

    /* renamed from: ir.nasim.v93$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C22391v93.d;
        }

        public final int b() {
            return C22391v93.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C22391v93(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C22391v93 c(int i) {
        return new C22391v93(i);
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof C22391v93) && i == ((C22391v93) obj).i();
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }

    public static int g(int i) {
        return Integer.hashCode(i);
    }

    public static String h(int i) {
        return f(i, c) ? "Touch" : f(i, d) ? "Keyboard" : "Error";
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
