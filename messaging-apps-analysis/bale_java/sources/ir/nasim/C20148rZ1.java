package ir.nasim;

/* renamed from: ir.nasim.rZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20148rZ1 {
    public static final a b = new a(null);
    private static final long c = d(0);
    private static final long d = d(9205357640488583168L);
    private final long a;

    /* renamed from: ir.nasim.rZ1$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C20148rZ1.d;
        }

        public final long b() {
            return C20148rZ1.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C20148rZ1(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C20148rZ1 c(long j) {
        return new C20148rZ1(j);
    }

    public static final long e(long j, float f, float f2) {
        return d((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    public static /* synthetic */ long f(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = j(j);
        }
        if ((i & 2) != 0) {
            f2 = i(j);
        }
        return e(j, f, f2);
    }

    public static boolean g(long j, Object obj) {
        return (obj instanceof C20148rZ1) && j == ((C20148rZ1) obj).m();
    }

    public static final boolean h(long j, long j2) {
        return j == j2;
    }

    public static final float i(long j) {
        return C17784nZ1.q(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    public static final float j(long j) {
        return C17784nZ1.q(Float.intBitsToFloat((int) (j >> 32)));
    }

    public static int k(long j) {
        return Long.hashCode(j);
    }

    public static String l(long j) {
        if (j == 9205357640488583168L) {
            return "DpSize.Unspecified";
        }
        return ((Object) C17784nZ1.u(j(j))) + " x " + ((Object) C17784nZ1.u(i(j)));
    }

    public boolean equals(Object obj) {
        return g(this.a, obj);
    }

    public int hashCode() {
        return k(this.a);
    }

    public final /* synthetic */ long m() {
        return this.a;
    }

    public String toString() {
        return l(this.a);
    }

    public static long d(long j) {
        return j;
    }
}
