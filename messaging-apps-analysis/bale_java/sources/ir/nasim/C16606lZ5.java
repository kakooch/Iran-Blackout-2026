package ir.nasim;

/* renamed from: ir.nasim.lZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16606lZ5 extends AbstractC10365bX5 {
    private long b;
    private int c;

    public static C16606lZ5 s(byte[] bArr) {
        return (C16606lZ5) AbstractC16720ll0.b(new C16606lZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.g(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.b);
        c19675ql0.f(2, this.c);
    }

    public String toString() {
        return "response GetTotalPaidAmount{}";
    }
}
