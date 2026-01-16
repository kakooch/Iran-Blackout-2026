package ir.nasim;

/* renamed from: ir.nasim.Sv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7696Sv extends AbstractC17902nl0 {
    private EnumC18020nx a;
    private long b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC18020nx.p(iH);
        }
        this.b = c19084pl0.i(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC18020nx enumC18020nx = this.a;
        if (enumC18020nx != null) {
            c19675ql0.f(1, enumC18020nx.j());
        }
        c19675ql0.g(2, this.b);
    }

    public String toString() {
        return "struct Balance{}";
    }
}
