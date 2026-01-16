package ir.nasim;

/* loaded from: classes2.dex */
public final class S33 {
    public static final a b = new a(null);
    private static final int c = k(-1);
    private static final int d = k(1);
    private static final int e = k(0);
    private static final int f = k(2);
    private static final int g = k(3);
    private static final int h = k(4);
    private static final int i = k(5);
    private static final int j = k(6);
    private static final int k = k(7);
    private final int a;

    public static final class a {
        private a() {
        }

        public final int a() {
            return S33.d;
        }

        public final int b() {
            return S33.k;
        }

        public final int c() {
            return S33.f;
        }

        public final int d() {
            return S33.j;
        }

        public final int e() {
            return S33.e;
        }

        public final int f() {
            return S33.i;
        }

        public final int g() {
            return S33.g;
        }

        public final int h() {
            return S33.h;
        }

        public final int i() {
            return S33.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ S33(int i2) {
        this.a = i2;
    }

    public static final /* synthetic */ S33 j(int i2) {
        return new S33(i2);
    }

    public static boolean l(int i2, Object obj) {
        return (obj instanceof S33) && i2 == ((S33) obj).p();
    }

    public static final boolean m(int i2, int i3) {
        return i2 == i3;
    }

    public static int n(int i2) {
        return Integer.hashCode(i2);
    }

    public static String o(int i2) {
        return m(i2, c) ? "Unspecified" : m(i2, e) ? "None" : m(i2, d) ? "Default" : m(i2, f) ? "Go" : m(i2, g) ? "Search" : m(i2, h) ? "Send" : m(i2, i) ? "Previous" : m(i2, j) ? "Next" : m(i2, k) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return l(this.a, obj);
    }

    public int hashCode() {
        return n(this.a);
    }

    public final /* synthetic */ int p() {
        return this.a;
    }

    public String toString() {
        return o(this.a);
    }

    private static int k(int i2) {
        return i2;
    }
}
