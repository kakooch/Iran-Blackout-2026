package ir.nasim;

/* renamed from: ir.nasim.mX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17179mX5 extends AbstractC10365bX5 {
    private int b;

    public static C17179mX5 s(byte[] bArr) {
        return (C17179mX5) AbstractC16720ll0.b(new C17179mX5(), bArr);
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
        return "response BuyWheelChance{}";
    }
}
