package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class FU5 extends TP5 {
    private C6768Ox a;

    public static FU5 r(byte[] bArr) {
        return (FU5) AbstractC16720ll0.b(new FU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C6768Ox) c19084pl0.z(1, new C6768Ox());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.REGISTER_FOR_EARN_MONEY_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C6768Ox c6768Ox = this.a;
        if (c6768Ox != null) {
            c19675ql0.i(1, c6768Ox);
        }
    }

    public String toString() {
        return "rpc RegisterForEarnMoney{}";
    }
}
