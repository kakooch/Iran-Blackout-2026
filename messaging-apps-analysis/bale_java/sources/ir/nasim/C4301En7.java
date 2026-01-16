package ir.nasim;

/* renamed from: ir.nasim.En7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4301En7 {
    public static final a b = new a(null);
    private static final long c = AbstractC4535Fn7.a(0);
    private final long a;

    /* renamed from: ir.nasim.En7$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C4301En7.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C4301En7(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C4301En7 b(long j) {
        return new C4301En7(j);
    }

    public static final boolean d(long j, long j2) {
        return (l(j) <= l(j2)) & (k(j2) <= k(j));
    }

    public static final boolean e(long j, int i) {
        return i < k(j) && l(j) <= i;
    }

    public static boolean f(long j, Object obj) {
        return (obj instanceof C4301En7) && j == ((C4301En7) obj).r();
    }

    public static final boolean g(long j, long j2) {
        return j == j2;
    }

    public static final boolean h(long j) {
        return n(j) == i(j);
    }

    public static final int i(long j) {
        return (int) (j & 4294967295L);
    }

    public static final int j(long j) {
        return k(j) - l(j);
    }

    public static final int k(long j) {
        return Math.max(n(j), i(j));
    }

    public static final int l(long j) {
        return Math.min(n(j), i(j));
    }

    public static final boolean m(long j) {
        return n(j) > i(j);
    }

    public static final int n(long j) {
        return (int) (j >> 32);
    }

    public static int o(long j) {
        return Long.hashCode(j);
    }

    public static final boolean p(long j, long j2) {
        return (l(j) < k(j2)) & (l(j2) < k(j));
    }

    public static String q(long j) {
        return "TextRange(" + n(j) + ", " + i(j) + ')';
    }

    public boolean equals(Object obj) {
        return f(this.a, obj);
    }

    public int hashCode() {
        return o(this.a);
    }

    public final /* synthetic */ long r() {
        return this.a;
    }

    public String toString() {
        return q(this.a);
    }

    public static long c(long j) {
        return j;
    }
}
