package ir.nasim;

/* renamed from: ir.nasim.cB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10777cB extends AbstractC7944Tw {
    private EnumC8412Vw a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC8412Vw.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC7944Tw
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC8412Vw enumC8412Vw = this.a;
        if (enumC8412Vw != null) {
            c19675ql0.f(1, enumC8412Vw.j());
        }
    }

    public String toString() {
        return "struct PredefinedColor{}";
    }
}
