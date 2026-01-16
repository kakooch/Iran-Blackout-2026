package ir.nasim;

/* renamed from: ir.nasim.Vz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C8445Vz5 extends AbstractC17902nl0 {
    private long a;
    private int b;
    private int c;
    private String d;
    private long e;
    private AbstractC17457n0 f;
    private C11458d25 g;
    private boolean h;
    private String i;

    public C8445Vz5(long j, int i, int i2, long j2, AbstractC17457n0 abstractC17457n0, C11458d25 c11458d25, boolean z, String str) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.e = j2;
        this.f = abstractC17457n0;
        this.h = z;
        this.i = str;
        this.g = c11458d25;
    }

    public static C8445Vz5 y(C9057Yh4 c9057Yh4, C16975mB c16975mB, boolean z) {
        C14733iO2 c14733iO2;
        AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(c16975mB.u());
        int iY = c16975mB.y();
        int iIntValue = c16975mB.s().intValue();
        return new C8445Vz5(c16975mB.r().longValue(), iIntValue, (iIntValue == 0 || c9057Yh4 == null || (c14733iO2 = (C14733iO2) c9057Yh4.E().Y1().n((long) iIntValue)) == null || c14733iO2.l() == 0) ? iY : c14733iO2.l(), c16975mB.q(), abstractC17457n0H, C18732p92.n(c16975mB.w()), z, c16975mB.z() != null ? c16975mB.z().q() : null);
    }

    public String C() {
        return this.d;
    }

    public String D() {
        return this.i;
    }

    public boolean E() {
        return this.h;
    }

    public void F(String str) {
        this.d = str;
    }

    public long h() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.g(3);
        this.e = c19084pl0.i(4);
        if (c19084pl0.v(5) != null) {
            this.f = AbstractC17457n0.n(c19084pl0.v(5));
        }
        this.h = c19084pl0.b(6);
        this.i = c19084pl0.A(7);
        if (c19084pl0.v(8) != null) {
            this.g = C11458d25.q(c19084pl0.v(8));
        }
    }

    public C8445Vz5 q(AbstractC17457n0 abstractC17457n0) {
        return new C8445Vz5(this.a, this.b, this.c, this.e, abstractC17457n0, this.g, this.h, this.i);
    }

    public AbstractC17457n0 r() {
        return this.f;
    }

    public long s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.f(3, this.c);
        c19675ql0.g(4, this.e);
        AbstractC17457n0 abstractC17457n0 = this.f;
        if (abstractC17457n0 != null) {
            c19675ql0.b(5, AbstractC17457n0.o(abstractC17457n0));
        }
        c19675ql0.a(6, this.h);
        String str = this.i;
        if (str != null) {
            c19675ql0.o(7, str);
        }
        C11458d25 c11458d25 = this.g;
        if (c11458d25 != null) {
            c19675ql0.b(8, c11458d25.toByteArray());
        }
    }

    public C11458d25 u() {
        return this.g;
    }

    public int w() {
        return this.b;
    }

    public int z() {
        return this.c;
    }

    protected C8445Vz5() {
    }
}
