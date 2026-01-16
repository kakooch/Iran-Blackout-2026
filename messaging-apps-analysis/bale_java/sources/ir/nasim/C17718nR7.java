package ir.nasim;

/* renamed from: ir.nasim.nR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17718nR7 {
    public static final a b = new a(null);
    private static final long c = c(0);
    private final long a;

    /* renamed from: ir.nasim.nR7$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C17718nR7.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C17718nR7(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C17718nR7 b(long j) {
        return new C17718nR7(j);
    }

    public static final long d(long j, float f, float f2) {
        return c((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    public static /* synthetic */ long e(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return d(j, f, f2);
    }

    public static boolean f(long j, Object obj) {
        return (obj instanceof C17718nR7) && j == ((C17718nR7) obj).o();
    }

    public static final boolean g(long j, long j2) {
        return j == j2;
    }

    public static final float h(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float i(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static int j(long j) {
        return Long.hashCode(j);
    }

    public static final long k(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return c((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long l(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return c((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long m(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return c((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static String n(long j) {
        return '(' + h(j) + ", " + i(j) + ") px/sec";
    }

    public boolean equals(Object obj) {
        return f(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ long o() {
        return this.a;
    }

    public String toString() {
        return n(this.a);
    }

    public static long c(long j) {
        return j;
    }
}
