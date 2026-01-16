package ir.nasim;

/* renamed from: ir.nasim.Ge5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4701Ge5 {
    public static final a a = new a(null);
    private static final int b = h(1);
    private static final int c = h(2);
    private static final int d = h(3);
    private static final int e = h(4);
    private static final int f = h(5);
    private static final int g = h(6);
    private static final int h = h(7);

    /* renamed from: ir.nasim.Ge5$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC4701Ge5.b;
        }

        public final int b() {
            return AbstractC4701Ge5.d;
        }

        public final int c() {
            return AbstractC4701Ge5.e;
        }

        public final int d() {
            return AbstractC4701Ge5.g;
        }

        public final int e() {
            return AbstractC4701Ge5.h;
        }

        public final int f() {
            return AbstractC4701Ge5.f;
        }

        public final int g() {
            return AbstractC4701Ge5.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean i(int i, int i2) {
        return i == i2;
    }

    public static int j(int i) {
        return Integer.hashCode(i);
    }

    public static String k(int i) {
        return i(i, b) ? "AboveBaseline" : i(i, c) ? "Top" : i(i, d) ? "Bottom" : i(i, e) ? "Center" : i(i, f) ? "TextTop" : i(i, g) ? "TextBottom" : i(i, h) ? "TextCenter" : "Invalid";
    }

    public static int h(int i) {
        return i;
    }
}
