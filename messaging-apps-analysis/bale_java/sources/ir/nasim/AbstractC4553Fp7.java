package ir.nasim;

/* renamed from: ir.nasim.Fp7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4553Fp7 {
    public static final a a = new a(null);
    private static final int b = e(0);
    private static final int c = e(1);
    private static final int d = e(2);
    private static final int e = e(3);

    /* renamed from: ir.nasim.Fp7$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC4553Fp7.b;
        }

        public final int b() {
            return AbstractC4553Fp7.e;
        }

        public final int c() {
            return AbstractC4553Fp7.d;
        }

        public final int d() {
            return AbstractC4553Fp7.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }

    public static int g(int i) {
        return Integer.hashCode(i);
    }

    public static String h(int i) {
        return f(i, b) ? "Clamp" : f(i, c) ? "Repeated" : f(i, d) ? "Mirror" : f(i, e) ? "Decal" : "Unknown";
    }

    public static int e(int i) {
        return i;
    }
}
