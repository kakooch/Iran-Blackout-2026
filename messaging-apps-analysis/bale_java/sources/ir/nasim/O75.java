package ir.nasim;

/* loaded from: classes5.dex */
public class O75 extends AbstractC17902nl0 {
    private long a;
    private long b;

    public O75(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
    }

    public long q() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
    }

    public O75() {
    }
}
