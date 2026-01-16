package ir.nasim;

/* renamed from: ir.nasim.uw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22260uw extends AbstractC24063xz {
    private AbstractC24063xz a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0.v(1) != null) {
            this.a = AbstractC24063xz.r(c19084pl0.d(1));
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 20;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC24063xz abstractC24063xz = this.a;
        if (abstractC24063xz != null) {
            c19675ql0.b(1, abstractC24063xz.q());
        }
    }

    public String toString() {
        return "struct BoughtPremiumMessage{}";
    }
}
