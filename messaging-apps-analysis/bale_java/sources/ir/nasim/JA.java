package ir.nasim;

/* loaded from: classes4.dex */
public class JA extends AbstractC17902nl0 {
    private long a;
    private long b;
    private long c;
    private MA d;

    public JA(long j, long j2, long j3, MA ma) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = ma;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = MA.p(iH);
        }
    }

    public long q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        MA ma = this.d;
        if (ma != null) {
            c19675ql0.f(4, ma.j());
        }
    }

    public String toString() {
        return "struct PfmTransactionId{}";
    }

    public JA() {
    }
}
