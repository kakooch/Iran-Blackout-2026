package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Nk7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6399Nk7 {
    public static final a b = new a(null);
    private static final int c = i(1);
    private static final int d = i(2);
    private static final int e = i(3);
    private static final int f = i(4);
    private static final int g = i(5);
    private static final int h = i(6);
    private static final int i = i(RecyclerView.UNDEFINED_DURATION);
    private final int a;

    /* renamed from: ir.nasim.Nk7$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C6399Nk7.e;
        }

        public final int b() {
            return C6399Nk7.h;
        }

        public final int c() {
            return C6399Nk7.f;
        }

        public final int d() {
            return C6399Nk7.c;
        }

        public final int e() {
            return C6399Nk7.d;
        }

        public final int f() {
            return C6399Nk7.g;
        }

        public final int g() {
            return C6399Nk7.i;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C6399Nk7(int i2) {
        this.a = i2;
    }

    public static final /* synthetic */ C6399Nk7 h(int i2) {
        return new C6399Nk7(i2);
    }

    public static boolean j(int i2, Object obj) {
        return (obj instanceof C6399Nk7) && i2 == ((C6399Nk7) obj).n();
    }

    public static final boolean k(int i2, int i3) {
        return i2 == i3;
    }

    public static int l(int i2) {
        return Integer.hashCode(i2);
    }

    public static String m(int i2) {
        return k(i2, c) ? "Left" : k(i2, d) ? "Right" : k(i2, e) ? "Center" : k(i2, f) ? "Justify" : k(i2, g) ? "Start" : k(i2, h) ? "End" : k(i2, i) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return j(this.a, obj);
    }

    public int hashCode() {
        return l(this.a);
    }

    public final /* synthetic */ int n() {
        return this.a;
    }

    public String toString() {
        return m(this.a);
    }

    public static int i(int i2) {
        return i2;
    }
}
