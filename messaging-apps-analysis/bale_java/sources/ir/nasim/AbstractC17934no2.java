package ir.nasim;

/* renamed from: ir.nasim.no2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17934no2 {
    public static final a a = new a(null);
    private static final int b = c(0);
    private static final int c = c(1);
    private static final int d = c(2);
    private static final int e = c(3);

    /* renamed from: ir.nasim.no2$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC17934no2.c;
        }

        public final int b() {
            return AbstractC17934no2.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean d(int i, int i2) {
        return i == i2;
    }

    public static int e(int i) {
        return Integer.hashCode(i);
    }

    public static String f(int i) {
        return d(i, b) ? "None" : d(i, c) ? "Low" : d(i, d) ? "Medium" : d(i, e) ? "High" : "Unknown";
    }

    public static int c(int i) {
        return i;
    }
}
