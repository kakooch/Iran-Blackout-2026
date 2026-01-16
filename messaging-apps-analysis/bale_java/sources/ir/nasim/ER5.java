package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class ER5 extends TP5 {
    private C17557nA a;

    public static ER5 r(byte[] bArr) {
        return (ER5) AbstractC16720ll0.b(new ER5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
    }

    public String toString() {
        return "rpc GetChannelEarnMoneyStatus{}";
    }
}
