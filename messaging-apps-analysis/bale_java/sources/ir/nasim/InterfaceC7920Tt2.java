package ir.nasim;

/* renamed from: ir.nasim.Tt2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC7920Tt2 extends InterfaceC20721sV1 {

    /* renamed from: ir.nasim.Tt2$a */
    public static final class a {
        public static final C0674a b = new C0674a(null);
        public static final a c = new a("VERTICAL");
        public static final a d = new a("HORIZONTAL");
        private final String a;

        /* renamed from: ir.nasim.Tt2$a$a, reason: collision with other inner class name */
        public static final class C0674a {
            private C0674a() {
            }

            public /* synthetic */ C0674a(ED1 ed1) {
                this();
            }
        }

        private a(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Tt2$b */
    public static final class b {
        public static final a b = new a(null);
        public static final b c = new b("FLAT");
        public static final b d = new b("HALF_OPENED");
        private final String a;

        /* renamed from: ir.nasim.Tt2$b$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        private b(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    a a();

    boolean b();
}
