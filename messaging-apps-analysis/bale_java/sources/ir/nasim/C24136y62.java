package ir.nasim;

/* renamed from: ir.nasim.y62, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24136y62 {
    public static final a b = new a(null);
    private static final int c = e(0);
    private static final int d = e(1);
    private static final int e = e(2);
    private final int a;

    /* renamed from: ir.nasim.y62$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C24136y62.e;
        }

        public final int b() {
            return C24136y62.c;
        }

        public final int c() {
            return C24136y62.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C24136y62(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C24136y62 d(int i) {
        return new C24136y62(i);
    }

    public static boolean f(int i, Object obj) {
        return (obj instanceof C24136y62) && i == ((C24136y62) obj).j();
    }

    public static final boolean g(int i, int i2) {
        return i == i2;
    }

    public static int h(int i) {
        return Integer.hashCode(i);
    }

    public static String i(int i) {
        if (i == c) {
            return "EmojiSupportMatch.Default";
        }
        if (i == d) {
            return "EmojiSupportMatch.None";
        }
        if (i == e) {
            return "EmojiSupportMatch.All";
        }
        return "Invalid(value=" + i + ')';
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
