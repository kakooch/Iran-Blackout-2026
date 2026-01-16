package ir.nasim;

/* loaded from: classes2.dex */
public final class B26 {
    public static final a b = new a(null);
    private static final int c = k(0);
    private static final int d = k(1);
    private static final int e = k(2);
    private static final int f = k(3);
    private static final int g = k(4);
    private static final int h = k(5);
    private static final int i = k(6);
    private static final int j = k(7);
    private static final int k = k(8);
    private final int a;

    public static final class a {
        private a() {
        }

        public final int a() {
            return B26.c;
        }

        public final int b() {
            return B26.k;
        }

        public final int c() {
            return B26.d;
        }

        public final int d() {
            return B26.i;
        }

        public final int e() {
            return B26.h;
        }

        public final int f() {
            return B26.f;
        }

        public final int g() {
            return B26.e;
        }

        public final int h() {
            return B26.g;
        }

        public final int i() {
            return B26.j;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ B26(int i2) {
        this.a = i2;
    }

    public static final /* synthetic */ B26 j(int i2) {
        return new B26(i2);
    }

    public static boolean l(int i2, Object obj) {
        return (obj instanceof B26) && i2 == ((B26) obj).p();
    }

    public static final boolean m(int i2, int i3) {
        return i2 == i3;
    }

    public static int n(int i2) {
        return Integer.hashCode(i2);
    }

    public static String o(int i2) {
        return m(i2, c) ? "Button" : m(i2, d) ? "Checkbox" : m(i2, e) ? "Switch" : m(i2, f) ? "RadioButton" : m(i2, g) ? "Tab" : m(i2, h) ? "Image" : m(i2, i) ? "DropdownList" : m(i2, j) ? "Picker" : m(i2, k) ? "Carousel" : "Unknown";
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
