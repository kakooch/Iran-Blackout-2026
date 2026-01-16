package ir.nasim;

/* renamed from: ir.nasim.Cz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3933Cz extends AbstractC17902nl0 {
    private C17557nA a;
    private long b;
    private Long c;
    private Long d;
    private LC e;

    public C3933Cz(C17557nA c17557nA, long j, Long l, Long l2, LC lc) {
        this.a = c17557nA;
        this.b = j;
        this.c = l;
        this.d = l2;
        this.e = lc;
    }

    public long i() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        this.b = c19084pl0.i(2);
        this.c = Long.valueOf(c19084pl0.y(3));
        this.d = Long.valueOf(c19084pl0.y(4));
        this.e = (LC) c19084pl0.z(5, new LC());
    }

    public Long q() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        c19675ql0.g(2, this.b);
        Long l = this.c;
        if (l != null) {
            c19675ql0.g(3, l.longValue());
        }
        Long l2 = this.d;
        if (l2 != null) {
            c19675ql0.g(4, l2.longValue());
        }
        LC lc = this.e;
        if (lc != null) {
            c19675ql0.i(5, lc);
        }
    }

    public String toString() {
        return "struct MessageOutReference{}";
    }

    public C3933Cz() {
    }
}
