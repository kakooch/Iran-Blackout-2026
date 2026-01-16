package ir.nasim;

/* renamed from: ir.nasim.Kw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5793Kw extends AbstractC17902nl0 {
    private int a;
    private int b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
    }

    public String toString() {
        return "struct CardExpirationDate{}";
    }
}
