package ir.nasim;

/* loaded from: classes.dex */
public abstract class S73 {
    public static final a a = new a(null);
    private static final long b = b(Float.NaN, Float.NaN);

    public static final class a {
        private a() {
        }

        public final long a() {
            return S73.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static long b(float f, float f2) {
        return c((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static long d(WH1 wh1) {
        return b(wh1.getDensity(), wh1.t1());
    }

    public static final boolean e(long j, long j2) {
        return j == j2;
    }

    public static final float f(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float g(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static String h(long j) {
        return "InlineDensity(density=" + f(j) + ", fontScale=" + g(j) + ')';
    }

    private static long c(long j) {
        return j;
    }
}
