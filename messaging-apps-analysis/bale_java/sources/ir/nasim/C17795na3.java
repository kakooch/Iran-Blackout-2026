package ir.nasim;

/* renamed from: ir.nasim.na3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17795na3 {
    public final long a;

    private /* synthetic */ C17795na3(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C17795na3 a(long j) {
        return new C17795na3(j);
    }

    public static long b(int i, int i2) {
        return c((i2 & 4294967295L) | (i << 32));
    }

    public static boolean d(long j, Object obj) {
        return (obj instanceof C17795na3) && j == ((C17795na3) obj).i();
    }

    public static final int e(long j) {
        return (int) (j >> 32);
    }

    public static final int f(long j) {
        return (int) (j & 4294967295L);
    }

    public static int g(long j) {
        return Long.hashCode(j);
    }

    public static String h(long j) {
        return '(' + e(j) + ", " + f(j) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ long i() {
        return this.a;
    }

    public String toString() {
        return h(this.a);
    }

    public static long c(long j) {
        return j;
    }
}
