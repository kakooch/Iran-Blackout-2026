package ir.nasim;

/* renamed from: ir.nasim.wn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23365wn7 {
    public static final a a = new a(null);
    private static final int b = f(1);
    private static final int c = f(2);
    private static final int d = f(3);
    private static final int e = f(4);
    private static final int f = f(5);

    /* renamed from: ir.nasim.wn7$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC23365wn7.b;
        }

        public final int b() {
            return AbstractC23365wn7.c;
        }

        public final int c() {
            return AbstractC23365wn7.f;
        }

        public final int d() {
            return AbstractC23365wn7.e;
        }

        public final int e() {
            return AbstractC23365wn7.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean g(int i, int i2) {
        return i == i2;
    }

    public static int h(int i) {
        return Integer.hashCode(i);
    }

    public static String i(int i) {
        return g(i, b) ? "Clip" : g(i, c) ? "Ellipsis" : g(i, f) ? "MiddleEllipsis" : g(i, d) ? "Visible" : g(i, e) ? "StartEllipsis" : "Invalid";
    }

    public static int f(int i) {
        return i;
    }
}
