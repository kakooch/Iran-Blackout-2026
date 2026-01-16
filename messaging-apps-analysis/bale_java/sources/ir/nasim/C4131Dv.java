package ir.nasim;

/* renamed from: ir.nasim.Dv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4131Dv extends AbstractC17902nl0 {
    private long a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
    }

    public String toString() {
        return "struct Advertisement{}";
    }
}
