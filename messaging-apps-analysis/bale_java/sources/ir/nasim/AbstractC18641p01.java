package ir.nasim;

/* renamed from: ir.nasim.p01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC18641p01 extends AbstractC18050o01 {
    public static long g(long j, long... jArr) {
        AbstractC13042fc3.i(jArr, "other");
        for (long j2 : jArr) {
            j = Math.max(j, j2);
        }
        return j;
    }

    public static Comparable h(Comparable comparable, Comparable comparable2) {
        AbstractC13042fc3.i(comparable, "a");
        AbstractC13042fc3.i(comparable2, "b");
        return comparable.compareTo(comparable2) >= 0 ? comparable : comparable2;
    }
}
