package ir.nasim;

/* renamed from: ir.nasim.iA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14599iA7 implements Comparable {
    public static final a b = new a(null);
    private final long a;

    /* renamed from: ir.nasim.iA7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C14599iA7(long j) {
        this.a = j;
    }

    public static final /* synthetic */ C14599iA7 a(long j) {
        return new C14599iA7(j);
    }

    public static boolean i(long j, Object obj) {
        return (obj instanceof C14599iA7) && j == ((C14599iA7) obj).q();
    }

    public static final boolean j(long j, long j2) {
        return j == j2;
    }

    public static int o(long j) {
        return Long.hashCode(j);
    }

    public static String p(long j) {
        return YB7.d(j, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return YB7.b(q(), ((C14599iA7) obj).q());
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return o(this.a);
    }

    public final /* synthetic */ long q() {
        return this.a;
    }

    public String toString() {
        return p(this.a);
    }

    public static long h(long j) {
        return j;
    }
}
