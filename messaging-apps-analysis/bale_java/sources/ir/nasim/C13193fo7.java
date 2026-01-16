package ir.nasim;

import ir.nasim.C14377ho7;

/* renamed from: ir.nasim.fo7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13193fo7 {
    public static final a b = new a(null);
    private static final C14377ho7[] c;
    private static final long d;
    private final long a;

    /* renamed from: ir.nasim.fo7$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C13193fo7.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        C14377ho7.a aVar = C14377ho7.b;
        c = new C14377ho7[]{C14377ho7.d(aVar.c()), C14377ho7.d(aVar.b()), C14377ho7.d(aVar.a())};
        d = AbstractC13784go7.i(0L, Float.NaN);
    }

    private /* synthetic */ C13193fo7(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C13193fo7 b(long j) {
        return new C13193fo7(j);
    }

    public static boolean d(long j, Object obj) {
        return (obj instanceof C13193fo7) && j == ((C13193fo7) obj).k();
    }

    public static final boolean e(long j, long j2) {
        return j == j2;
    }

    public static final long f(long j) {
        return j & 1095216660480L;
    }

    public static final long g(long j) {
        return c[(int) (f(j) >>> 32)].j();
    }

    public static final float h(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static int i(long j) {
        return Long.hashCode(j);
    }

    public static String j(long j) {
        long jG = g(j);
        C14377ho7.a aVar = C14377ho7.b;
        if (C14377ho7.g(jG, aVar.c())) {
            return "Unspecified";
        }
        if (C14377ho7.g(jG, aVar.b())) {
            return h(j) + ".sp";
        }
        if (!C14377ho7.g(jG, aVar.a())) {
            return "Invalid";
        }
        return h(j) + ".em";
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return i(this.a);
    }

    public final /* synthetic */ long k() {
        return this.a;
    }

    public String toString() {
        return j(this.a);
    }

    public static long c(long j) {
        return j;
    }
}
