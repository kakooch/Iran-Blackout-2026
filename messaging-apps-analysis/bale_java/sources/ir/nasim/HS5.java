package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class HS5 extends TP5 {
    public static HS5 r(byte[] bArr) {
        return (HS5) AbstractC16720ll0.b(new HS5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_PAYVAND_CARD_LIST_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetPayvandCardList{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
