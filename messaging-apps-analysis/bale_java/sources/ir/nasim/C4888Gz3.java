package ir.nasim;

/* renamed from: ir.nasim.Gz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4888Gz3 {
    public static final b d;
    private static final C4888Gz3 e;
    private final float a;
    private final int b;
    private final int c;

    /* renamed from: ir.nasim.Gz3$a */
    public static final class a {
        public static final C0396a b = new C0396a(null);
        private static final float c = d(0.0f);
        private static final float d = d(0.5f);
        private static final float e = d(-1.0f);
        private static final float f = d(1.0f);
        private final float a;

        /* renamed from: ir.nasim.Gz3$a$a, reason: collision with other inner class name */
        public static final class C0396a {
            private C0396a() {
            }

            public final float a() {
                return a.d;
            }

            public final float b() {
                return a.e;
            }

            public /* synthetic */ C0396a(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ a(float f2) {
            this.a = f2;
        }

        public static final /* synthetic */ a c(float f2) {
            return new a(f2);
        }

        public static float d(float f2) {
            if (!((0.0f <= f2 && f2 <= 1.0f) || f2 == -1.0f)) {
                N73.c("topRatio should be in [0..1] range or -1");
            }
            return f2;
        }

        public static boolean e(float f2, Object obj) {
            return (obj instanceof a) && Float.compare(f2, ((a) obj).i()) == 0;
        }

        public static final boolean f(float f2, float f3) {
            return Float.compare(f2, f3) == 0;
        }

        public static int g(float f2) {
            return Float.hashCode(f2);
        }

        public static String h(float f2) {
            if (f2 == c) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f2 == d) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f2 == e) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f2 == f) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f2 + ')';
        }

        public boolean equals(Object obj) {
            return e(this.a, obj);
        }

        public int hashCode() {
            return g(this.a);
        }

        public final /* synthetic */ float i() {
            return this.a;
        }

        public String toString() {
            return h(this.a);
        }
    }

    /* renamed from: ir.nasim.Gz3$b */
    public static final class b {
        private b() {
        }

        public final C4888Gz3 a() {
            return C4888Gz3.e;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static {
        ED1 ed1 = null;
        d = new b(ed1);
        e = new C4888Gz3(a.b.b(), d.b.a(), c.b.a(), ed1);
    }

    public /* synthetic */ C4888Gz3(float f, int i, int i2, ED1 ed1) {
        this(f, i, i2);
    }

    public final float b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4888Gz3)) {
            return false;
        }
        C4888Gz3 c4888Gz3 = (C4888Gz3) obj;
        return a.f(this.a, c4888Gz3.a) && d.f(this.b, c4888Gz3.b) && c.f(this.c, c4888Gz3.c);
    }

    public int hashCode() {
        return (((a.g(this.a) * 31) + d.g(this.b)) * 31) + c.g(this.c);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) a.h(this.a)) + ", trim=" + ((Object) d.j(this.b)) + ",mode=" + ((Object) c.h(this.c)) + ')';
    }

    public /* synthetic */ C4888Gz3(float f, int i, ED1 ed1) {
        this(f, i);
    }

    private C4888Gz3(float f, int i, int i2) {
        this.a = f;
        this.b = i;
        this.c = i2;
    }

    private C4888Gz3(float f, int i) {
        this(f, i, c.b.a(), null);
    }

    /* renamed from: ir.nasim.Gz3$c */
    public static final class c {
        public static final a b = new a(null);
        private static final int c = d(0);
        private static final int d = d(1);
        private final int a;

        /* renamed from: ir.nasim.Gz3$c$a */
        public static final class a {
            private a() {
            }

            public final int a() {
                return c.c;
            }

            public final int b() {
                return c.d;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ c(int i) {
            this.a = i;
        }

        public static final /* synthetic */ c c(int i) {
            return new c(i);
        }

        public static boolean e(int i, Object obj) {
            return (obj instanceof c) && i == ((c) obj).i();
        }

        public static final boolean f(int i, int i2) {
            return i == i2;
        }

        public static int g(int i) {
            return Integer.hashCode(i);
        }

        public static String h(int i) {
            return "Mode(value=" + i + ')';
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

    /* renamed from: ir.nasim.Gz3$d */
    public static final class d {
        public static final a b = new a(null);
        private static final int c = d(1);
        private static final int d = d(16);
        private static final int e = d(17);
        private static final int f = d(0);
        private final int a;

        /* renamed from: ir.nasim.Gz3$d$a */
        public static final class a {
            private a() {
            }

            public final int a() {
                return d.e;
            }

            public final int b() {
                return d.f;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ d(int i) {
            this.a = i;
        }

        public static final /* synthetic */ d c(int i) {
            return new d(i);
        }

        public static boolean e(int i, Object obj) {
            return (obj instanceof d) && i == ((d) obj).k();
        }

        public static final boolean f(int i, int i2) {
            return i == i2;
        }

        public static int g(int i) {
            return Integer.hashCode(i);
        }

        public static final boolean h(int i) {
            return (i & 1) > 0;
        }

        public static final boolean i(int i) {
            return (i & 16) > 0;
        }

        public static String j(int i) {
            return i == c ? "LineHeightStyle.Trim.FirstLineTop" : i == d ? "LineHeightStyle.Trim.LastLineBottom" : i == e ? "LineHeightStyle.Trim.Both" : i == f ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return e(this.a, obj);
        }

        public int hashCode() {
            return g(this.a);
        }

        public final /* synthetic */ int k() {
            return this.a;
        }

        public String toString() {
            return j(this.a);
        }

        private static int d(int i) {
            return i;
        }
    }
}
