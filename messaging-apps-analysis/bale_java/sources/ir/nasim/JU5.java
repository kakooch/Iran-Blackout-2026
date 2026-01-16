package ir.nasim;

/* loaded from: classes4.dex */
public class JU5 extends TP5 {
    private int a;
    private long b;

    public static JU5 r(byte[] bArr) {
        return (JU5) AbstractC16720ll0.b(new JU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 89;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
    }

    public String toString() {
        return "rpc RemoveContact{}";
    }
}
