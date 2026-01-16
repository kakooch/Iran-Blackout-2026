package ir.nasim;

/* renamed from: ir.nasim.ho7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14377ho7 {
    public static final a b = new a(null);
    private static final long c = e(0);
    private static final long d = e(4294967296L);
    private static final long e = e(8589934592L);
    private final long a;

    /* renamed from: ir.nasim.ho7$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C14377ho7.e;
        }

        public final long b() {
            return C14377ho7.d;
        }

        public final long c() {
            return C14377ho7.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C14377ho7(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C14377ho7 d(long j) {
        return new C14377ho7(j);
    }

    public static boolean f(long j, Object obj) {
        return (obj instanceof C14377ho7) && j == ((C14377ho7) obj).j();
    }

    public static final boolean g(long j, long j2) {
        return j == j2;
    }

    public static int h(long j) {
        return Long.hashCode(j);
    }

    public static String i(long j) {
        return g(j, c) ? "Unspecified" : g(j, d) ? "Sp" : g(j, e) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ long j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }

    public static long e(long j) {
        return j;
    }
}
