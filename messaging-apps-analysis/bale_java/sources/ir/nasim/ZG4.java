package ir.nasim;

/* loaded from: classes2.dex */
public final class ZG4 {
    public static final a b = new a(null);
    private static final long c = e(0);
    private static final long d = e(9187343241974906880L);
    private static final long e = e(9205357640488583168L);
    private final long a;

    public static final class a {
        private a() {
        }

        public final long a() {
            return ZG4.d;
        }

        public final long b() {
            return ZG4.e;
        }

        public final long c() {
            return ZG4.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ ZG4(long j) {
        this.a = j;
    }

    public static final /* synthetic */ ZG4 d(long j) {
        return new ZG4(j);
    }

    public static final long f(long j, float f, float f2) {
        return e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    public static /* synthetic */ long g(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return f(j, f, f2);
    }

    public static final long h(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) / f;
        return e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static boolean i(long j, Object obj) {
        return (obj instanceof ZG4) && j == ((ZG4) obj).t();
    }

    public static final boolean j(long j, long j2) {
        return j == j2;
    }

    public static final float k(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2));
    }

    public static final float l(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2);
    }

    public static final float m(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float n(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static int o(long j) {
        return Long.hashCode(j);
    }

    public static final long p(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long q(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static final long r(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    public static String s(long j) {
        if ((9223372034707292159L & j) == 9205357640488583168L) {
            return "Offset.Unspecified";
        }
        return "Offset(" + AbstractC12832fF2.a(Float.intBitsToFloat((int) (j >> 32)), 1) + ", " + AbstractC12832fF2.a(Float.intBitsToFloat((int) (j & 4294967295L)), 1) + ')';
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return o(this.a);
    }

    public final /* synthetic */ long t() {
        return this.a;
    }

    public String toString() {
        return s(this.a);
    }

    public static long e(long j) {
        return j;
    }
}
