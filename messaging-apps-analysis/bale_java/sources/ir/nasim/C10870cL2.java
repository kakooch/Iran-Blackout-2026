package ir.nasim;

/* renamed from: ir.nasim.cL2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C10870cL2 {
    private final long a;

    private /* synthetic */ C10870cL2(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C10870cL2 a(long j) {
        return new C10870cL2(j);
    }

    public static boolean c(long j, Object obj) {
        return (obj instanceof C10870cL2) && j == ((C10870cL2) obj).g();
    }

    public static final int d(long j) {
        return (int) j;
    }

    public static int e(long j) {
        return Long.hashCode(j);
    }

    public static String f(long j) {
        return "GridItemSpan(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ long g() {
        return this.a;
    }

    public int hashCode() {
        return e(this.a);
    }

    public String toString() {
        return f(this.a);
    }

    public static long b(long j) {
        return j;
    }
}
