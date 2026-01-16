package ir.nasim;

/* renamed from: ir.nasim.mB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16975mB extends AbstractC17902nl0 {
    private Long a;
    private Integer b;
    private int c;
    private long d;
    private AbstractC24063xz e;
    private C17557nA f;
    private LC g;

    public C16975mB(Long l, Integer num, int i, long j, AbstractC24063xz abstractC24063xz, C17557nA c17557nA, LC lc) {
        this.a = l;
        this.b = num;
        this.c = i;
        this.d = j;
        this.e = abstractC24063xz;
        this.f = c17557nA;
        this.g = lc;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Long.valueOf(c19084pl0.y(1));
        this.b = Integer.valueOf(c19084pl0.x(2));
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.i(4);
        if (c19084pl0.v(5) != null) {
            this.e = AbstractC24063xz.r(c19084pl0.d(5));
        }
        this.f = (C17557nA) c19084pl0.z(6, new C17557nA());
        this.g = (LC) c19084pl0.z(8, new LC());
    }

    public long q() {
        return this.d;
    }

    public Long r() {
        return this.a;
    }

    public Integer s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Long l = this.a;
        if (l != null) {
            c19675ql0.g(1, l.longValue());
        }
        Integer num = this.b;
        if (num != null) {
            c19675ql0.f(2, num.intValue());
        }
        c19675ql0.f(3, this.c);
        c19675ql0.g(4, this.d);
        AbstractC24063xz abstractC24063xz = this.e;
        if (abstractC24063xz != null) {
            c19675ql0.b(5, abstractC24063xz.q());
        }
        C17557nA c17557nA = this.f;
        if (c17557nA != null) {
            c19675ql0.i(6, c17557nA);
        }
        LC lc = this.g;
        if (lc != null) {
            c19675ql0.i(8, lc);
        }
    }

    public String toString() {
        return "struct QuotedMessage{}";
    }

    public AbstractC24063xz u() {
        return this.e;
    }

    public C17557nA w() {
        return this.f;
    }

    public int y() {
        return this.c;
    }

    public LC z() {
        return this.g;
    }

    public C16975mB() {
    }
}
