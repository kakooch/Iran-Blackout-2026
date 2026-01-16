package ir.nasim;

/* renamed from: ir.nasim.vS0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C22560vS0 extends AbstractC12750f83 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final C11458d25 e;
    private final J44 f;

    /* renamed from: ir.nasim.vS0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22560vS0(C11458d25 c11458d25, J44 j44) {
        this.e = c11458d25;
        this.f = j44;
    }

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        int i = this.d;
        if (i >= this.c.length()) {
            return null;
        }
        C20644sM5 c20644sM5 = new C20644sM5("(?m)^- \\[([ xX])](?=.)");
        String str = this.c;
        AbstractC13042fc3.h(str, "input");
        OU3 ou3B = c20644sM5.b(str, i);
        if (ou3B == null) {
            return null;
        }
        if (ou3B.c().o() != i) {
            ou3B = null;
        }
        if (ou3B == null) {
            return null;
        }
        MU3 mu3 = ou3B.d().get(1);
        boolean zD = AbstractC20153rZ6.D(mu3 != null ? mu3.a() : null, "x", true);
        this.d = ou3B.c().t() + 1;
        C11458d25 c11458d25 = this.e;
        J44 j44 = this.f;
        String str2 = this.c;
        AbstractC13042fc3.h(str2, "input");
        return new C23156wS0(zD, i, c11458d25, j44, str2);
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '-';
    }
}
