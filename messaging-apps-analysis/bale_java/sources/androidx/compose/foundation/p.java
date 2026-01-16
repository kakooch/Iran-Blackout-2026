package androidx.compose.foundation;

import ir.nasim.ED1;

/* loaded from: classes.dex */
public final class p {
    public static final a b = new a(null);
    private static final int c = d(0);
    private static final int d = d(1);
    private final int a;

    public static final class a {
        private a() {
        }

        public final int a() {
            return p.c;
        }

        public final int b() {
            return p.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ p(int i) {
        this.a = i;
    }

    public static final /* synthetic */ p c(int i) {
        return new p(i);
    }

    private static int d(int i) {
        return i;
    }

    public static boolean e(int i, Object obj) {
        return (obj instanceof p) && i == ((p) obj).i();
    }

    public static final boolean f(int i, int i2) {
        return i == i2;
    }

    public static int g(int i) {
        return Integer.hashCode(i);
    }

    public static String h(int i) {
        if (f(i, c)) {
            return "Immediately";
        }
        if (f(i, d)) {
            return "WhileFocused";
        }
        throw new IllegalStateException(("invalid value: " + i).toString());
    }

    public boolean equals(Object obj) {
        return e(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ int i() {
        return this.a;
    }

    public String toString() {
        return h(this.a);
    }
}
