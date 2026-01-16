package ir.nasim;

/* loaded from: classes4.dex */
public class WQ5 extends TP5 {
    private C12056dy a;

    public static WQ5 r(byte[] bArr) {
        return (WQ5) AbstractC16720ll0.b(new WQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C12056dy) c19084pl0.z(1, new C12056dy());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 31;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C12056dy c12056dy = this.a;
        if (c12056dy != null) {
            c19675ql0.i(1, c12056dy);
        }
    }

    public String toString() {
        return "rpc EditAvatar{}";
    }
}
