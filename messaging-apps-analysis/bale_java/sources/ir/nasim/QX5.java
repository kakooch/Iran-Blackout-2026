package ir.nasim;

/* loaded from: classes4.dex */
public class QX5 extends AbstractC10365bX5 {
    private EnumC7002Px b;

    public static QX5 s(byte[] bArr) {
        return (QX5) AbstractC16720ll0.b(new QX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.b = EnumC7002Px.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC7002Px enumC7002Px = this.b;
        if (enumC7002Px != null) {
            c19675ql0.f(1, enumC7002Px.j());
        }
    }

    public String toString() {
        return "response GetChannelEarnMoneyStatus{}";
    }
}
