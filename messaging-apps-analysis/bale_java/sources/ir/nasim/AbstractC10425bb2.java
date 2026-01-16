package ir.nasim;

/* renamed from: ir.nasim.bb2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10425bb2 {
    private static final C14539i47 a = new C14539i47("REMOVED_TASK");
    private static final C14539i47 b = new C14539i47("CLOSED_EMPTY");

    public static final long c(long j) {
        return j / 1000000;
    }

    public static final long d(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
