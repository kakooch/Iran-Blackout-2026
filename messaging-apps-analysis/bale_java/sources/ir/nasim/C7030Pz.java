package ir.nasim;

/* renamed from: ir.nasim.Pz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7030Pz extends AbstractC17902nl0 {
    private long a;
    private C22993wA b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private int h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = (C22993wA) c19084pl0.z(2, new C22993wA());
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.i(6);
        this.g = c19084pl0.i(7);
        this.h = c19084pl0.g(8);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        C22993wA c22993wA = this.b;
        if (c22993wA != null) {
            c19675ql0.i(2, c22993wA);
        }
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
        c19675ql0.g(5, this.e);
        c19675ql0.g(6, this.f);
        c19675ql0.g(7, this.g);
        c19675ql0.f(8, this.h);
    }

    public String toString() {
        return "struct MoneyRequestPayment{}";
    }
}
