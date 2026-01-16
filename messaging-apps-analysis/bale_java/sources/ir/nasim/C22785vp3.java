package ir.nasim;

/* renamed from: ir.nasim.vp3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22785vp3 {
    public static final a b = new a(null);
    private static final int c = l(0);
    private static final int d = l(1);
    private static final int e = l(2);
    private static final int f = l(3);
    private static final int g = l(4);
    private static final int h = l(5);
    private static final int i = l(6);
    private static final int j = l(7);
    private static final int k = l(8);
    private static final int l = l(9);
    private final int a;

    /* renamed from: ir.nasim.vp3$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C22785vp3.e;
        }

        public final int b() {
            return C22785vp3.l;
        }

        public final int c() {
            return C22785vp3.i;
        }

        public final int d() {
            return C22785vp3.f;
        }

        public final int e() {
            return C22785vp3.k;
        }

        public final int f() {
            return C22785vp3.j;
        }

        public final int g() {
            return C22785vp3.g;
        }

        public final int h() {
            return C22785vp3.d;
        }

        public final int i() {
            return C22785vp3.c;
        }

        public final int j() {
            return C22785vp3.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C22785vp3(int i2) {
        this.a = i2;
    }

    public static final /* synthetic */ C22785vp3 k(int i2) {
        return new C22785vp3(i2);
    }

    public static boolean m(int i2, Object obj) {
        return (obj instanceof C22785vp3) && i2 == ((C22785vp3) obj).q();
    }

    public static final boolean n(int i2, int i3) {
        return i2 == i3;
    }

    public static int o(int i2) {
        return Integer.hashCode(i2);
    }

    public static String p(int i2) {
        return n(i2, c) ? "Unspecified" : n(i2, d) ? "Text" : n(i2, e) ? "Ascii" : n(i2, f) ? "Number" : n(i2, g) ? "Phone" : n(i2, h) ? "Uri" : n(i2, i) ? "Email" : n(i2, j) ? "Password" : n(i2, k) ? "NumberPassword" : n(i2, l) ? "Decimal" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m(this.a, obj);
    }

    public int hashCode() {
        return o(this.a);
    }

    public final /* synthetic */ int q() {
        return this.a;
    }

    public String toString() {
        return p(this.a);
    }

    private static int l(int i2) {
        return i2;
    }
}
