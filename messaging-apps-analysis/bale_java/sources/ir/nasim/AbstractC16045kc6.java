package ir.nasim;

/* renamed from: ir.nasim.kc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16045kc6 {
    public static final a a = new a(null);
    private static final long b = a((Float.floatToRawIntBits(Float.NaN) << 32) | (Float.floatToRawIntBits(Float.NaN) & 4294967295L));

    /* renamed from: ir.nasim.kc6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final float b(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float c(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static long a(long j) {
        return j;
    }
}
