package ir.nasim;

/* loaded from: classes4.dex */
public class I06 extends AbstractC10365bX5 {
    private int b;

    public static I06 s(byte[] bArr) {
        return (I06) AbstractC16720ll0.b(new I06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.b);
    }

    public String toString() {
        return "response UpgradeKifpool{}";
    }
}
