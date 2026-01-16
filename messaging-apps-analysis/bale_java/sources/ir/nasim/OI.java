package ir.nasim;

/* loaded from: classes.dex */
public abstract class OI {
    public static final a a = new a(null);
    private static final int b = b(5);
    private static final int c = b(4);
    private static final int d = b(0);

    public static final class a {
        private a() {
        }

        public final int a() {
            return OI.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final boolean c(int i, int i2) {
        return i == i2;
    }

    public static int d(int i) {
        return Integer.hashCode(i);
    }

    public static String e(int i) {
        return "ArcMode(value=" + i + ')';
    }

    public static int b(int i) {
        return i;
    }
}
