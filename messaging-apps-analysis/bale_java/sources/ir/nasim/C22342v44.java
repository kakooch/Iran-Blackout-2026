package ir.nasim;

/* renamed from: ir.nasim.v44, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22342v44 {
    public static final a b = new a(null);
    private static final int c = c(0);
    private final int a;

    /* renamed from: ir.nasim.v44$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C22342v44.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C22342v44(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C22342v44 b(int i) {
        return new C22342v44(i);
    }

    public static int d(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return c((z ? 1 : 0) | (z2 ? 2 : 0) | (z3 ? 4 : 0) | (z4 ? 8 : 0) | (z5 ? 16 : 0));
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof C22342v44) && i == ((C22342v44) obj).l();
    }

    public static final boolean f(int i) {
        return (i & 1) == 1;
    }

    public static final boolean g(int i) {
        return (i & 4) == 4;
    }

    public static final boolean h(int i) {
        return (i & 2) == 2;
    }

    public static final boolean i(int i) {
        return (i & 8) == 8;
    }

    public static int j(int i) {
        return Integer.hashCode(i);
    }

    public static String k(int i) {
        return "MenuItemsAvailability(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ int l() {
        return this.a;
    }

    public String toString() {
        return k(this.a);
    }

    private static int c(int i) {
        return i;
    }
}
