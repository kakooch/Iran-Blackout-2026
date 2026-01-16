package ir.nasim;

/* renamed from: ir.nasim.Dz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4171Dz3 {
    public static final a b = new a(null);
    private static final int c;
    private static final int d;
    private static final int e;
    private static final int f;
    private final int a;

    /* renamed from: ir.nasim.Dz3$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C4171Dz3.c;
        }

        public final int b() {
            return C4171Dz3.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        b.a aVar = b.a;
        int iC = aVar.c();
        c.a aVar2 = c.a;
        int iC2 = aVar2.c();
        d.a aVar3 = d.a;
        c = d(AbstractC4405Ez3.e(iC, iC2, aVar3.a()));
        d = d(AbstractC4405Ez3.e(aVar.a(), aVar2.b(), aVar3.b()));
        e = d(AbstractC4405Ez3.e(aVar.b(), aVar2.d(), aVar3.a()));
        f = d(0);
    }

    private /* synthetic */ C4171Dz3(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C4171Dz3 c(int i) {
        return new C4171Dz3(i);
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof C4171Dz3) && i == ((C4171Dz3) obj).l();
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }

    public static final int g(int i) {
        return b.d(AbstractC4405Ez3.f(i));
    }

    public static final int h(int i) {
        return c.e(AbstractC4405Ez3.g(i));
    }

    public static final int i(int i) {
        return d.c(AbstractC4405Ez3.h(i));
    }

    public static int j(int i) {
        return Integer.hashCode(i);
    }

    public static String k(int i) {
        return "LineBreak(strategy=" + ((Object) b.f(g(i))) + ", strictness=" + ((Object) c.g(h(i))) + ", wordBreak=" + ((Object) d.e(i(i))) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
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

    /* renamed from: ir.nasim.Dz3$b */
    public static final class b {
        public static final a a = new a(null);
        private static final int b = d(1);
        private static final int c = d(2);
        private static final int d = d(3);
        private static final int e = d(0);

        /* renamed from: ir.nasim.Dz3$b$a */
        public static final class a {
            private a() {
            }

            public final int a() {
                return b.d;
            }

            public final int b() {
                return b.c;
            }

            public final int c() {
                return b.b;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public static final boolean e(int i, int i2) {
            return i == i2;
        }

        public static String f(int i) {
            return e(i, b) ? "Strategy.Simple" : e(i, c) ? "Strategy.HighQuality" : e(i, d) ? "Strategy.Balanced" : e(i, e) ? "Strategy.Unspecified" : "Invalid";
        }

        public static int d(int i) {
            return i;
        }
    }

    /* renamed from: ir.nasim.Dz3$c */
    public static final class c {
        public static final a a = new a(null);
        private static final int b = e(1);
        private static final int c = e(2);
        private static final int d = e(3);
        private static final int e = e(4);
        private static final int f = e(0);

        /* renamed from: ir.nasim.Dz3$c$a */
        public static final class a {
            private a() {
            }

            public final int a() {
                return c.b;
            }

            public final int b() {
                return c.c;
            }

            public final int c() {
                return c.d;
            }

            public final int d() {
                return c.e;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public static final boolean f(int i, int i2) {
            return i == i2;
        }

        public static String g(int i) {
            return f(i, b) ? "Strictness.None" : f(i, c) ? "Strictness.Loose" : f(i, d) ? "Strictness.Normal" : f(i, e) ? "Strictness.Strict" : f(i, f) ? "Strictness.Unspecified" : "Invalid";
        }

        public static int e(int i) {
            return i;
        }
    }

    /* renamed from: ir.nasim.Dz3$d */
    public static final class d {
        public static final a a = new a(null);
        private static final int b = c(1);
        private static final int c = c(2);
        private static final int d = c(0);

        /* renamed from: ir.nasim.Dz3$d$a */
        public static final class a {
            private a() {
            }

            public final int a() {
                return d.b;
            }

            public final int b() {
                return d.c;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public static final boolean d(int i, int i2) {
            return i == i2;
        }

        public static String e(int i) {
            return d(i, b) ? "WordBreak.None" : d(i, c) ? "WordBreak.Phrase" : d(i, d) ? "WordBreak.Unspecified" : "Invalid";
        }

        public static int c(int i) {
            return i;
        }
    }

    public static int d(int i) {
        return i;
    }
}
