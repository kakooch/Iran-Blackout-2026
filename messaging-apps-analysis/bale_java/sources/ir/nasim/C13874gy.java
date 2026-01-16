package ir.nasim;

/* renamed from: ir.nasim.gy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13874gy extends AbstractC18620oy {
    private EnumC3690By a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC3690By.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC18620oy
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC3690By enumC3690By = this.a;
        if (enumC3690By != null) {
            c19675ql0.f(1, enumC3690By.j());
        }
    }

    public String toString() {
        return "struct FilterGroupType{}";
    }
}
