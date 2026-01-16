package ir.nasim;

/* renamed from: ir.nasim.dh5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11873dh5 {
    public static final a a = new a(null);
    private static final int b = f(0);
    private static final int c = f(1);
    private static final int d = f(2);
    private static final int e = f(3);
    private static final int f = f(4);

    /* renamed from: ir.nasim.dh5$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC11873dh5.f;
        }

        public final int b() {
            return AbstractC11873dh5.d;
        }

        public final int c() {
            return AbstractC11873dh5.e;
        }

        public final int d() {
            return AbstractC11873dh5.c;
        }

        public final int e() {
            return AbstractC11873dh5.b;
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
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }

    private static int f(int i) {
        return i;
    }
}
