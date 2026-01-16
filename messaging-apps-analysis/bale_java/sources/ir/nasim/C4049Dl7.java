package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Dl7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4049Dl7 {
    public static final a b = new a(null);
    private static final int c = h(1);
    private static final int d = h(2);
    private static final int e = h(3);
    private static final int f = h(4);
    private static final int g = h(5);
    private static final int h = h(RecyclerView.UNDEFINED_DURATION);
    private final int a;

    /* renamed from: ir.nasim.Dl7$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C4049Dl7.e;
        }

        public final int b() {
            return C4049Dl7.f;
        }

        public final int c() {
            return C4049Dl7.g;
        }

        public final int d() {
            return C4049Dl7.c;
        }

        public final int e() {
            return C4049Dl7.d;
        }

        public final int f() {
            return C4049Dl7.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C4049Dl7(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C4049Dl7 g(int i) {
        return new C4049Dl7(i);
    }

    public static boolean i(int i, Object obj) {
        return (obj instanceof C4049Dl7) && i == ((C4049Dl7) obj).m();
    }

    public static final boolean j(int i, int i2) {
        return i == i2;
    }

    public static int k(int i) {
        return Integer.hashCode(i);
    }

    public static String l(int i) {
        return j(i, c) ? "Ltr" : j(i, d) ? "Rtl" : j(i, e) ? "Content" : j(i, f) ? "ContentOrLtr" : j(i, g) ? "ContentOrRtl" : j(i, h) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return k(this.a);
    }

    public final /* synthetic */ int m() {
        return this.a;
    }

    public String toString() {
        return l(this.a);
    }

    public static int h(int i) {
        return i;
    }
}
