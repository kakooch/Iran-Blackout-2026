package ir.nasim;

/* renamed from: ir.nasim.jy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15665jy extends AbstractC18620oy {
    private BB a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = BB.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC18620oy
    public int s() {
        return 4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        BB bb = this.a;
        if (bb != null) {
            c19675ql0.f(1, bb.j());
        }
    }

    public String toString() {
        return "struct FilterRestriction{}";
    }
}
