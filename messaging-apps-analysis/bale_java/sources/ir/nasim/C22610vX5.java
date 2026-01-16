package ir.nasim;

/* renamed from: ir.nasim.vX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22610vX5 extends AbstractC10365bX5 {
    private long b;

    public static C22610vX5 s(byte[] bArr) {
        return (C22610vX5) AbstractC16720ll0.b(new C22610vX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.b);
    }

    public String toString() {
        return "response CreateSavedBill{}";
    }
}
