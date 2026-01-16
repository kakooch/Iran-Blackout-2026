package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class FR5 extends TP5 {
    private EnumC11532dA a;
    private EnumC10768cA b;

    public static FR5 r(byte[] bArr) {
        return (FR5) AbstractC16720ll0.b(new FR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC11532dA.p(iH);
        }
        int iH2 = c19084pl0.h(2, 0);
        if (iH2 != 0) {
            this.b = EnumC10768cA.p(iH2);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CHARGE_AMOUNTS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC11532dA enumC11532dA = this.a;
        if (enumC11532dA != null) {
            c19675ql0.f(1, enumC11532dA.j());
        }
        EnumC10768cA enumC10768cA = this.b;
        if (enumC10768cA != null) {
            c19675ql0.f(2, enumC10768cA.j());
        }
    }

    public String toString() {
        return "rpc GetChargeAmounts{}";
    }
}
