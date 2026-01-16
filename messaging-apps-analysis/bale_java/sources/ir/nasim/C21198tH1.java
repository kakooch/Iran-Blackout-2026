package ir.nasim;

/* renamed from: ir.nasim.tH1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21198tH1 extends AbstractC17902nl0 {
    private C11458d25 a;

    public C21198tH1(C11458d25 c11458d25) {
        this.a = c11458d25;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = C11458d25.q(c19084pl0.d(1));
    }

    public C11458d25 q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.i(1, this.a);
    }

    public C21198tH1() {
    }
}
