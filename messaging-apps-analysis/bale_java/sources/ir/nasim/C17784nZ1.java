package ir.nasim;

/* renamed from: ir.nasim.nZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17784nZ1 implements Comparable {
    public static final a b = new a(null);
    private static final float c = q(0.0f);
    private static final float d = q(Float.POSITIVE_INFINITY);
    private static final float e = q(Float.NaN);
    private final float a;

    /* renamed from: ir.nasim.nZ1$a */
    public static final class a {
        private a() {
        }

        public final float a() {
            return C17784nZ1.c;
        }

        public final float b() {
            return C17784nZ1.d;
        }

        public final float c() {
            return C17784nZ1.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C17784nZ1(float f) {
        this.a = f;
    }

    public static final /* synthetic */ C17784nZ1 j(float f) {
        return new C17784nZ1(f);
    }

    public static int p(float f, float f2) {
        return Float.compare(f, f2);
    }

    public static boolean r(float f, Object obj) {
        return (obj instanceof C17784nZ1) && Float.compare(f, ((C17784nZ1) obj).v()) == 0;
    }

    public static final boolean s(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    public static int t(float f) {
        return Float.hashCode(f);
    }

    public static String u(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return o(((C17784nZ1) obj).v());
    }

    public boolean equals(Object obj) {
        return r(this.a, obj);
    }

    public int hashCode() {
        return t(this.a);
    }

    public int o(float f) {
        return p(this.a, f);
    }

    public String toString() {
        return u(this.a);
    }

    public final /* synthetic */ float v() {
        return this.a;
    }

    public static float q(float f) {
        return f;
    }
}
