package ir.nasim;

/* renamed from: ir.nasim.yZ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24405yZ6 {
    public static final a a = new a(null);
    private static final int b = d(0);
    private static final int c = d(1);
    private static final int d = d(2);

    /* renamed from: ir.nasim.yZ6$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC24405yZ6.b;
        }

        public final int b() {
            return AbstractC24405yZ6.c;
        }

        public final int c() {
            return AbstractC24405yZ6.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean e(int i, int i2) {
        return i == i2;
    }

    public static int f(int i) {
        return Integer.hashCode(i);
    }

    public static String g(int i) {
        return e(i, b) ? "Butt" : e(i, c) ? "Round" : e(i, d) ? "Square" : "Unknown";
    }

    public static int d(int i) {
        return i;
    }
}
