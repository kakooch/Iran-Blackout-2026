package ir.nasim;

/* renamed from: ir.nasim.nf5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17847nf5 {
    public static final a c = new a(null);
    private static final C17847nf5 d = new C17847nf5();
    private final boolean a;
    private final int b;

    /* renamed from: ir.nasim.nf5$a */
    public static final class a {
        private a() {
        }

        public final C17847nf5 a() {
            return C17847nf5.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C17847nf5(int i, ED1 ed1) {
        this(i);
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.a;
    }

    public final C17847nf5 d(C17847nf5 c17847nf5) {
        return c17847nf5 == null ? this : c17847nf5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17847nf5)) {
            return false;
        }
        C17847nf5 c17847nf5 = (C17847nf5) obj;
        return this.a == c17847nf5.a && C24136y62.g(this.b, c17847nf5.b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + C24136y62.h(this.b);
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.a + ", emojiSupportMatch=" + ((Object) C24136y62.i(this.b)) + ')';
    }

    public /* synthetic */ C17847nf5(int i, boolean z, ED1 ed1) {
        this(i, z);
    }

    public C17847nf5(boolean z) {
        this.a = z;
        this.b = C24136y62.b.b();
    }

    private C17847nf5(int i, boolean z) {
        this.a = z;
        this.b = i;
    }

    private C17847nf5(int i) {
        this.a = false;
        this.b = i;
    }

    public C17847nf5() {
        this(C24136y62.b.b(), false, null);
    }
}
