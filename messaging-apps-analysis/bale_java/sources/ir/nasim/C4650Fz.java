package ir.nasim;

/* renamed from: ir.nasim.Fz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4650Fz extends AbstractC17902nl0 {
    private C22993wA a;
    private long b;
    private long c;
    private AbstractC24063xz d;
    private int e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        if (c19084pl0.v(5) != null) {
            this.d = AbstractC24063xz.r(c19084pl0.d(5));
        }
        this.e = c19084pl0.g(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        AbstractC24063xz abstractC24063xz = this.d;
        if (abstractC24063xz != null) {
            c19675ql0.b(5, abstractC24063xz.q());
        }
        c19675ql0.f(4, this.e);
    }

    public String toString() {
        return "struct MessageSearchResult{}";
    }
}
