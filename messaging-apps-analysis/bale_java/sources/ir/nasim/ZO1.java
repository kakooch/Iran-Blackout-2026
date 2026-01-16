package ir.nasim;

/* loaded from: classes7.dex */
public abstract class ZO1 {
    public static int a(long j) {
        return (int) (j & 4294967295L);
    }

    public static boolean b(long j) {
        return (c(j) || d(j) || j >= 0) ? false : true;
    }

    public static boolean c(long j) {
        return (4611686018427387904L & j) != 0 && (j & Long.MIN_VALUE) == 0;
    }

    public static boolean d(long j) {
        return (2305843009213693952L & j) != 0 && (j & Long.MIN_VALUE) == 0;
    }

    public static boolean e(long j) {
        return (c(j) || d(j) || j <= 0) ? false : true;
    }
}
