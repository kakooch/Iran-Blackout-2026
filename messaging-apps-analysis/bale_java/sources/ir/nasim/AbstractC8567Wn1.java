package ir.nasim;

/* renamed from: ir.nasim.Wn1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8567Wn1 {
    public static final a a = new a(null);
    private static final long b = b(0);

    /* renamed from: ir.nasim.Wn1$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return AbstractC8567Wn1.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean c(long j, long j2) {
        return j == j2;
    }

    public static int d(long j) {
        return Long.hashCode(j);
    }

    public static String e(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            return "CornerRadius.circular(" + AbstractC12832fF2.a(Float.intBitsToFloat(i), 1) + ')';
        }
        return "CornerRadius.elliptical(" + AbstractC12832fF2.a(Float.intBitsToFloat(i), 1) + ", " + AbstractC12832fF2.a(Float.intBitsToFloat(i2), 1) + ')';
    }

    public static long b(long j) {
        return j;
    }
}
