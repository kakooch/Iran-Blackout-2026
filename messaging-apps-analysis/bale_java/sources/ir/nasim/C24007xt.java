package ir.nasim;

/* renamed from: ir.nasim.xt, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24007xt {
    public static final a b = new a(null);
    private static final String c = d("Enter");
    private static final String d = d("Exit");
    private final String a;

    /* renamed from: ir.nasim.xt$a */
    public static final class a {
        private a() {
        }

        public final String a() {
            return C24007xt.c;
        }

        public final String b() {
            return C24007xt.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C24007xt(String str) {
        this.a = str;
    }

    public static final /* synthetic */ C24007xt c(String str) {
        return new C24007xt(str);
    }

    public static boolean e(String str, Object obj) {
        return (obj instanceof C24007xt) && AbstractC13042fc3.d(str, ((C24007xt) obj).i());
    }

    public static final boolean f(String str, String str2) {
        return AbstractC13042fc3.d(str, str2);
    }

    public static int g(String str) {
        return str.hashCode();
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ String i() {
        return this.a;
    }

    public String toString() {
        return h(this.a);
    }

    private static String d(String str) {
        return str;
    }

    public static String h(String str) {
        return str;
    }
}
