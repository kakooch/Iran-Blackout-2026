package ir.nasim;

/* loaded from: classes4.dex */
public class PX5 extends AbstractC10365bX5 {
    private double b;
    private double c;
    private long d;
    private long e;

    public static PX5 s(byte[] bArr) {
        return (PX5) AbstractC16720ll0.b(new PX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.f(1);
        this.c = c19084pl0.f(2);
        this.d = c19084pl0.i(3);
        this.e = c19084pl0.i(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.e(1, this.b);
        c19675ql0.e(2, this.c);
        c19675ql0.g(3, this.d);
        c19675ql0.g(4, this.e);
    }

    public String toString() {
        return "response GetChannelEarnMoneyInfo{}";
    }
}
