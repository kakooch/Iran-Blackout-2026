package ir.nasim;

/* loaded from: classes2.dex */
public abstract class UV1 {
    public static final int a(long j, long j2) {
        boolean zE = e(j);
        if (zE != e(j2)) {
            return zE ? -1 : 1;
        }
        int iSignum = (int) Math.signum(c(j) - c(j2));
        return (Math.min(c(j), c(j2)) >= 0.0f && d(j) != d(j2)) ? d(j) ? -1 : 1 : iSignum;
    }

    public static final float c(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final boolean d(long j) {
        return (j & 2) != 0;
    }

    public static final boolean e(long j) {
        return (j & 1) != 0;
    }

    public static long b(long j) {
        return j;
    }
}
