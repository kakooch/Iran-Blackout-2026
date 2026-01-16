package ir.nasim;

/* loaded from: classes4.dex */
public class CB extends AbstractC17902nl0 {
    private EnumC18739pA a;
    private EnumC18148oA b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC18739pA.p(iH);
        }
        int iH2 = c19084pl0.h(2, 0);
        if (iH2 != 0) {
            this.b = EnumC18148oA.p(iH2);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC18739pA enumC18739pA = this.a;
        if (enumC18739pA != null) {
            c19675ql0.f(1, enumC18739pA.j());
        }
        EnumC18148oA enumC18148oA = this.b;
        if (enumC18148oA != null) {
            c19675ql0.f(2, enumC18148oA.j());
        }
    }

    public String toString() {
        return "struct RewardPacket{}";
    }
}
