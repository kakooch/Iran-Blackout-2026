package ir.nasim;

/* renamed from: ir.nasim.lX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16588lX5 extends AbstractC10365bX5 {
    private C7705Sw b;

    public static C16588lX5 s(byte[] bArr) {
        return (C16588lX5) AbstractC16720ll0.b(new C16588lX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C7705Sw) c19084pl0.z(1, new C7705Sw());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C7705Sw c7705Sw = this.b;
        if (c7705Sw != null) {
            c19675ql0.i(1, c7705Sw);
        }
    }

    public String toString() {
        return "response BuyVoucher{}";
    }
}
