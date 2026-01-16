package ir.nasim;

/* renamed from: ir.nasim.od0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18413od0 {
    public static final a b = new a(null);
    private static final float c = c(0.5f);
    private static final float d = c(-0.5f);
    private static final float e = c(0.0f);
    private final float a;

    /* renamed from: ir.nasim.od0$a */
    public static final class a {
        private a() {
        }

        public final float a() {
            return C18413od0.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C18413od0(float f) {
        this.a = f;
    }

    public static final /* synthetic */ C18413od0 b(float f) {
        return new C18413od0(f);
    }

    public static boolean d(float f, Object obj) {
        return (obj instanceof C18413od0) && Float.compare(f, ((C18413od0) obj).h()) == 0;
    }

    public static final boolean e(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    public static int f(float f) {
        return Float.hashCode(f);
    }

    public static String g(float f) {
        return "BaselineShift(multiplier=" + f + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public final /* synthetic */ float h() {
        return this.a;
    }

    public int hashCode() {
        return f(this.a);
    }

    public String toString() {
        return g(this.a);
    }

    public static float c(float f) {
        return f;
    }
}
