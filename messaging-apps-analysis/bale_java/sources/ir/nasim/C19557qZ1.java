package ir.nasim;

/* renamed from: ir.nasim.qZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19557qZ1 {
    public static final a b = new a(null);
    private static final long c = b(0);
    private static final long d = b(9205357640488583168L);
    private final long a;

    /* renamed from: ir.nasim.qZ1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C19557qZ1(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C19557qZ1 a(long j) {
        return new C19557qZ1(j);
    }

    public static boolean c(long j, Object obj) {
        return (obj instanceof C19557qZ1) && j == ((C19557qZ1) obj).i();
    }

    public static final boolean d(long j, long j2) {
        return j == j2;
    }

    public static final float e(long j) {
        return C17784nZ1.q(Float.intBitsToFloat((int) (j >> 32)));
    }

    public static final float f(long j) {
        return C17784nZ1.q(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    public static int g(long j) {
        return Long.hashCode(j);
    }

    public static String h(long j) {
        if (j == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) C17784nZ1.u(e(j))) + ", " + ((Object) C17784nZ1.u(f(j))) + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ long i() {
        return this.a;
    }

    public String toString() {
        return h(this.a);
    }

    public static long b(long j) {
        return j;
    }
}
