package ir.nasim;

/* loaded from: classes4.dex */
public class NQ5 extends TP5 {
    private C17557nA a;

    public static NQ5 r(byte[] bArr) {
        return (NQ5) AbstractC16720ll0.b(new NQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 100;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
    }

    public String toString() {
        return "rpc DeleteChat{}";
    }
}
