package ir.nasim;

/* renamed from: ir.nasim.un7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22179un7 {
    public static final a c;
    private static final C22179un7 d;
    private static final C22179un7 e;
    private final int a;
    private final boolean b;

    /* renamed from: ir.nasim.un7$a */
    public static final class a {
        private a() {
        }

        public final C22179un7 a() {
            return C22179un7.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ED1 ed1 = null;
        c = new a(ed1);
        b.a aVar = b.b;
        d = new C22179un7(aVar.a(), false, ed1);
        e = new C22179un7(aVar.b(), true, ed1);
    }

    public /* synthetic */ C22179un7(int i, boolean z, ED1 ed1) {
        this(i, z);
    }

    public final int b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22179un7)) {
            return false;
        }
        C22179un7 c22179un7 = (C22179un7) obj;
        return b.g(this.a, c22179un7.a) && this.b == c22179un7.b;
    }

    public int hashCode() {
        return (b.h(this.a) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return AbstractC13042fc3.d(this, d) ? "TextMotion.Static" : AbstractC13042fc3.d(this, e) ? "TextMotion.Animated" : "Invalid";
    }

    private C22179un7(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    /* renamed from: ir.nasim.un7$b */
    public static final class b {
        public static final a b = new a(null);
        private static final int c = e(1);
        private static final int d = e(2);
        private static final int e = e(3);
        private final int a;

        /* renamed from: ir.nasim.un7$b$a */
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
                return b.e;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ b(int i) {
            this.a = i;
        }

        public static final /* synthetic */ b d(int i) {
            return new b(i);
        }

        public static boolean f(int i, Object obj) {
            return (obj instanceof b) && i == ((b) obj).j();
        }

        public static final boolean g(int i, int i2) {
            return i == i2;
        }

        public static int h(int i) {
            return Integer.hashCode(i);
        }

        public static String i(int i) {
            return g(i, c) ? "Linearity.Linear" : g(i, d) ? "Linearity.FontHinting" : g(i, e) ? "Linearity.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return f(this.a, obj);
        }

        public int hashCode() {
            return h(this.a);
        }

        public final /* synthetic */ int j() {
            return this.a;
        }

        public String toString() {
            return i(this.a);
        }

        private static int e(int i) {
            return i;
        }
    }
}
