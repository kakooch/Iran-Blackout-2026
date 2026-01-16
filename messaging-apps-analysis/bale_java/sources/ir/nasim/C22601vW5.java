package ir.nasim;

/* renamed from: ir.nasim.vW5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22601vW5 {
    private final C18829pK a;
    private final C23787xW5 b;
    private final int c;

    C22601vW5(C18829pK c18829pK, C23787xW5 c23787xW5, InterfaceC21354tW5 interfaceC21354tW5, int i) {
        this.a = c18829pK;
        this.b = c23787xW5;
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public C18829pK b() {
        return this.a;
    }

    public InterfaceC21354tW5 c() {
        return null;
    }

    public C23787xW5 d() {
        return this.b;
    }

    /* renamed from: ir.nasim.vW5$a */
    public static final class a {
        private C18829pK a;
        private C23787xW5 b;
        private int c;

        public a() {
            this.a = C18829pK.c;
            this.b = null;
            this.c = 0;
        }

        public static a b(C22601vW5 c22601vW5) {
            return new a(c22601vW5);
        }

        public C22601vW5 a() {
            return new C22601vW5(this.a, this.b, null, this.c);
        }

        public a c(int i) {
            this.c = i;
            return this;
        }

        public a d(C18829pK c18829pK) {
            this.a = c18829pK;
            return this;
        }

        public a e(C23787xW5 c23787xW5) {
            this.b = c23787xW5;
            return this;
        }

        private a(C22601vW5 c22601vW5) {
            this.a = C18829pK.c;
            this.b = null;
            this.c = 0;
            this.a = c22601vW5.b();
            this.b = c22601vW5.d();
            c22601vW5.c();
            this.c = c22601vW5.a();
        }
    }
}
