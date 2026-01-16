package ir.nasim;

/* loaded from: classes4.dex */
public class TB extends AbstractC17902nl0 {
    private SB a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = SB.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        SB sb = this.a;
        if (sb != null) {
            c19675ql0.f(1, sb.j());
        }
    }

    public String toString() {
        return "struct SendTypeValue{}";
    }
}
