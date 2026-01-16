package ir.nasim;

/* renamed from: ir.nasim.wa8, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23236wa8 {
    public static final a a = new a(null);
    private static final int b;
    private static final int c;
    private static final int d;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;

    /* renamed from: ir.nasim.wa8$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return AbstractC23236wa8.b;
        }

        public final int b() {
            return AbstractC23236wa8.d;
        }

        public final int c() {
            return AbstractC23236wa8.c;
        }

        public final int d() {
            return AbstractC23236wa8.e;
        }

        public final int e() {
            return AbstractC23236wa8.i;
        }

        public final int f() {
            return AbstractC23236wa8.l;
        }

        public final int g() {
            return AbstractC23236wa8.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        int iH = h(8);
        b = iH;
        int iH2 = h(4);
        c = iH2;
        int iH3 = h(2);
        d = iH3;
        int iH4 = h(1);
        e = iH4;
        f = l(iH, iH4);
        g = l(iH2, iH3);
        int iH5 = h(16);
        h = iH5;
        int iH6 = h(32);
        i = iH6;
        int iL = l(iH, iH3);
        j = iL;
        int iL2 = l(iH2, iH4);
        k = iL2;
        l = l(iL, iL2);
        m = l(iH5, iH6);
    }

    public static final boolean i(int i2, int i3) {
        return i2 == i3;
    }

    public static final boolean j(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static int k(int i2) {
        return Integer.hashCode(i2);
    }

    public static final int l(int i2, int i3) {
        return h(i2 | i3);
    }

    public static String m(int i2) {
        return "WindowInsetsSides(" + n(i2) + ')';
    }

    private static final String n(int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = f;
        if ((i2 & i3) == i3) {
            o(sb, "Start");
        }
        int i4 = j;
        if ((i2 & i4) == i4) {
            o(sb, "Left");
        }
        int i5 = h;
        if ((i2 & i5) == i5) {
            o(sb, "Top");
        }
        int i6 = g;
        if ((i2 & i6) == i6) {
            o(sb, "End");
        }
        int i7 = k;
        if ((i2 & i7) == i7) {
            o(sb, "Right");
        }
        int i8 = i;
        if ((i2 & i8) == i8) {
            o(sb, "Bottom");
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    private static final void o(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    private static int h(int i2) {
        return i2;
    }
}
