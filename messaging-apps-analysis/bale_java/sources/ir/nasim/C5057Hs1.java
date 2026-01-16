package ir.nasim;

/* renamed from: ir.nasim.Hs1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5057Hs1 implements RR {
    public static final C5057Hs1 a = new C5057Hs1();
    private static final String b = "create_password_router";

    /* renamed from: ir.nasim.Hs1$a */
    public static final class a implements RR {
        public static final a a = new a();
        private static final String b = "create_password_screen";

        private a() {
        }

        @Override // ir.nasim.RR
        public String a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -803726602;
        }

        public String toString() {
            return "Creator";
        }
    }

    /* renamed from: ir.nasim.Hs1$b */
    public static final class b implements RR {
        public static final b a = new b();
        private static final String b = "create_password_intro_screen";

        private b() {
        }

        @Override // ir.nasim.RR
        public String a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1260465078;
        }

        public String toString() {
            return "Intro";
        }
    }

    private C5057Hs1() {
    }

    @Override // ir.nasim.RR
    public String a() {
        return b;
    }
}
