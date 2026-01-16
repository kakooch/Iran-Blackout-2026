package ir.nasim;

/* renamed from: ir.nasim.cK6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10865cK6 {
    public static long a(int i, int i2) {
        return b(i * i2);
    }

    public static /* synthetic */ long c(int i, int i2, int i3, ED1 ed1) {
        if ((i3 & 2) != 0) {
            i2 = AbstractC12881fK6.a.a();
        }
        return a(i, i2);
    }

    public static final boolean d(long j, long j2) {
        return j == j2;
    }

    public static int e(long j) {
        return Long.hashCode(j);
    }

    private static long b(long j) {
        return j;
    }
}
