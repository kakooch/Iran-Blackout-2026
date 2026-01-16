package ir.nasim;

/* renamed from: ir.nasim.Fa3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4414Fa3 {
    public static final a b = new a(null);
    private static final long c = c(0);
    private final long a;

    /* renamed from: ir.nasim.Fa3$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C4414Fa3.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C4414Fa3(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C4414Fa3 b(long j) {
        return new C4414Fa3(j);
    }

    public static boolean d(long j, Object obj) {
        return (obj instanceof C4414Fa3) && j == ((C4414Fa3) obj).j();
    }

    public static final boolean e(long j, long j2) {
        return j == j2;
    }

    public static final int f(long j) {
        return (int) (j & 4294967295L);
    }

    public static final int g(long j) {
        return (int) (j >> 32);
    }

    public static int h(long j) {
        return Long.hashCode(j);
    }

    public static String i(long j) {
        return ((int) (j >> 32)) + " x " + ((int) (j & 4294967295L));
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ long j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }

    public static long c(long j) {
        return j;
    }
}
