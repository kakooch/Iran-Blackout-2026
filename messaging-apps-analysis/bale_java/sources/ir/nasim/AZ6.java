package ir.nasim;

/* loaded from: classes2.dex */
public abstract class AZ6 {
    public static final a a = new a(null);
    private static final int b = d(0);
    private static final int c = d(1);
    private static final int d = d(2);

    public static final class a {
        private a() {
        }

        public final int a() {
            return AZ6.d;
        }

        public final int b() {
            return AZ6.b;
        }

        public final int c() {
            return AZ6.c;
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
        return e(i, b) ? "Miter" : e(i, c) ? "Round" : e(i, d) ? "Bevel" : "Unknown";
    }

    public static int d(int i) {
        return i;
    }
}
