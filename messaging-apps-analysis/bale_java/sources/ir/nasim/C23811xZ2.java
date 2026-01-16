package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.xZ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23811xZ2 {
    public static final a b = new a(null);
    private static final int c = e(1);
    private static final int d = e(2);
    private static final int e = e(RecyclerView.UNDEFINED_DURATION);
    private final int a;

    /* renamed from: ir.nasim.xZ2$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C23811xZ2.d;
        }

        public final int b() {
            return C23811xZ2.c;
        }

        public final int c() {
            return C23811xZ2.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C23811xZ2(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C23811xZ2 d(int i) {
        return new C23811xZ2(i);
    }

    public static boolean f(int i, Object obj) {
        return (obj instanceof C23811xZ2) && i == ((C23811xZ2) obj).j();
    }

    public static final boolean g(int i, int i2) {
        return i == i2;
    }

    public static int h(int i) {
        return Integer.hashCode(i);
    }

    public static String i(int i) {
        return g(i, c) ? "Hyphens.None" : g(i, d) ? "Hyphens.Auto" : g(i, e) ? "Hyphens.Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ int j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }

    private static int e(int i) {
        return i;
    }
}
