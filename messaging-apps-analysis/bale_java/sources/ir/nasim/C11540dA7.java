package ir.nasim;

/* renamed from: ir.nasim.dA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11540dA7 implements Comparable {
    public static final a b = new a(null);
    private final int a;

    /* renamed from: ir.nasim.dA7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C11540dA7(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C11540dA7 a(int i) {
        return new C11540dA7(i);
    }

    public static boolean i(int i, Object obj) {
        return (obj instanceof C11540dA7) && i == ((C11540dA7) obj).p();
    }

    public static int j(int i) {
        return Integer.hashCode(i);
    }

    public static String o(int i) {
        return String.valueOf(i & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return YB7.a(p(), ((C11540dA7) obj).p());
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ int p() {
        return this.a;
    }

    public String toString() {
        return o(this.a);
    }

    public static int h(int i) {
        return i;
    }
}
