package ir.nasim;

/* renamed from: ir.nasim.lu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16812lu2 {
    public static final a a = new a(null);
    private static final int b = d(0);
    private static final int c = d(1);
    private static final int d = d(2);

    /* renamed from: ir.nasim.lu2$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC16812lu2.d;
        }

        public final int b() {
            return AbstractC16812lu2.b;
        }

        public final int c() {
            return AbstractC16812lu2.c;
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
        if (e(i, b)) {
            return "Blocking";
        }
        if (e(i, c)) {
            return "Optional";
        }
        if (e(i, d)) {
            return "Async";
        }
        return "Invalid(value=" + i + ')';
    }

    private static int d(int i) {
        return i;
    }
}
