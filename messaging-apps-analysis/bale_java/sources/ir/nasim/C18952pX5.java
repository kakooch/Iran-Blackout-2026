package ir.nasim;

/* renamed from: ir.nasim.pX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18952pX5 extends AbstractC10365bX5 {
    private long b;

    public static C18952pX5 s(byte[] bArr) {
        return (C18952pX5) AbstractC16720ll0.b(new C18952pX5(), bArr);
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
        return "response CashOutKifpool{}";
    }
}
