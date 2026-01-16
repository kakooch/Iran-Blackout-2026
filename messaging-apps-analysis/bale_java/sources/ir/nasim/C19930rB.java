package ir.nasim;

/* renamed from: ir.nasim.rB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19930rB extends AbstractC17902nl0 {
    private EnumC20539sB a;
    private long b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC20539sB.p(iH);
        }
        this.b = c19084pl0.i(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC20539sB enumC20539sB = this.a;
        if (enumC20539sB != null) {
            c19675ql0.f(1, enumC20539sB.j());
        }
        c19675ql0.g(2, this.b);
    }

    public String toString() {
        return "struct ReactionEntity{}";
    }
}
