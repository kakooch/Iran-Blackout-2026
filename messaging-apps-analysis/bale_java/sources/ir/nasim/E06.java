package ir.nasim;

/* loaded from: classes4.dex */
public class E06 extends AbstractC10365bX5 {
    private long b;
    private long c;
    private long d;

    public static E06 s(byte[] bArr) {
        return (E06) AbstractC16720ll0.b(new E06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.i(2);
        this.d = c19084pl0.i(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.b);
        c19675ql0.g(2, this.c);
        c19675ql0.g(3, this.d);
    }

    public String toString() {
        return "response TransactionPoint{}";
    }
}
