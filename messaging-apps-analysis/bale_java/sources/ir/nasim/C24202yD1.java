package ir.nasim;

/* renamed from: ir.nasim.yD1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24202yD1 extends AbstractC19738qr3 {
    public static final a g;
    private static final C24202yD1 h;

    /* renamed from: ir.nasim.yD1$a */
    public static final class a {
        private a() {
        }

        public final C24202yD1 a() {
            return C24202yD1.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ED1 ed1 = null;
        g = new a(ed1);
        h = new C24202yD1(false, 1, ed1);
    }

    public C24202yD1(boolean z) {
        super(new C14671iI3("DefaultBuiltIns"));
        if (z) {
            f(false);
        }
    }

    public static final C24202yD1 N0() {
        return g.a();
    }

    public /* synthetic */ C24202yD1(boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z);
    }
}
