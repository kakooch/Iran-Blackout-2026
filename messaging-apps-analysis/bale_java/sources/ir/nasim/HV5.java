package ir.nasim;

/* loaded from: classes4.dex */
public class HV5 extends TP5 {
    private C17557nA a;
    private EnumC14020hD b;

    public static HV5 r(byte[] bArr) {
        return (HV5) AbstractC16720ll0.b(new HV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC14020hD.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 30;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        EnumC14020hD enumC14020hD = this.b;
        if (enumC14020hD != null) {
            c19675ql0.f(2, enumC14020hD.j());
        }
    }

    public String toString() {
        return "rpc StopTyping{}";
    }
}
