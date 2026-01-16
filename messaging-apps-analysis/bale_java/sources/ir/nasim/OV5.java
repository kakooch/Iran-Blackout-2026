package ir.nasim;

/* loaded from: classes4.dex */
public class OV5 extends TP5 {
    private int a;

    public static OV5 r(byte[] bArr) {
        return (OV5) AbstractC16720ll0.b(new OV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 82;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
    }

    public String toString() {
        return "rpc TerminateSession{}";
    }
}
