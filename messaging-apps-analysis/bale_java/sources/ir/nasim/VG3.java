package ir.nasim;

/* loaded from: classes5.dex */
public final class VG3 extends C9625aH3 {
    private static final a m = new a(null);
    public static final int n = 8;
    private int i;
    private boolean j;
    private String k;
    private long l;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public VG3(byte[] bArr) {
        super(bArr);
        this.k = "";
        this.l = -1L;
    }

    public final long C() {
        return this.l;
    }

    public final int D() {
        return this.i;
    }

    public final boolean E() {
        return this.j;
    }

    @Override // ir.nasim.C9625aH3, ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        super.parse(c19084pl0);
        this.i = c19084pl0.g(100);
        this.j = c19084pl0.b(101);
        this.k = c19084pl0.r(102);
        this.l = c19084pl0.i(103);
    }

    @Override // ir.nasim.C9625aH3, ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        super.serialize(c19675ql0);
        c19675ql0.f(100, this.i);
        c19675ql0.a(101, this.j);
        c19675ql0.o(102, this.k);
        c19675ql0.g(103, this.l);
    }
}
