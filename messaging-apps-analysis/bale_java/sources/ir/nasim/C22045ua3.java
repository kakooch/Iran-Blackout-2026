package ir.nasim;

/* renamed from: ir.nasim.ua3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22045ua3 {
    public static final a b = new a(null);
    private static final long c = f(0);
    private static final long d = f(9223372034707292159L);
    private final long a;

    /* renamed from: ir.nasim.ua3$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C22045ua3.d;
        }

        public final long b() {
            return C22045ua3.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C22045ua3(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C22045ua3 c(long j) {
        return new C22045ua3(j);
    }

    public static final int d(long j) {
        return k(j);
    }

    public static final int e(long j) {
        return l(j);
    }

    public static final long g(long j, int i, int i2) {
        return f((i << 32) | (i2 & 4294967295L));
    }

    public static /* synthetic */ long h(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (4294967295L & j);
        }
        return g(j, i, i2);
    }

    public static boolean i(long j, Object obj) {
        return (obj instanceof C22045ua3) && j == ((C22045ua3) obj).r();
    }

    public static final boolean j(long j, long j2) {
        return j == j2;
    }

    public static final int k(long j) {
        return (int) (j >> 32);
    }

    public static final int l(long j) {
        return (int) (j & 4294967295L);
    }

    public static int m(long j) {
        return Long.hashCode(j);
    }

    public static final long n(long j, long j2) {
        return f(((((int) (j >> 32)) - ((int) (j2 >> 32))) << 32) | ((((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L))) & 4294967295L));
    }

    public static final long o(long j, long j2) {
        return f(((((int) (j >> 32)) + ((int) (j2 >> 32))) << 32) | ((((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L))) & 4294967295L));
    }

    public static String p(long j) {
        return '(' + k(j) + ", " + l(j) + ')';
    }

    public static final long q(long j) {
        return f(((-((int) (j & 4294967295L))) & 4294967295L) | ((-((int) (j >> 32))) << 32));
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return m(this.a);
    }

    public final /* synthetic */ long r() {
        return this.a;
    }

    public String toString() {
        return p(this.a);
    }

    public static long f(long j) {
        return j;
    }
}
