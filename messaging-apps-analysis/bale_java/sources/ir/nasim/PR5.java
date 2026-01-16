package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class PR5 extends TP5 {
    public static PR5 r(byte[] bArr) {
        return (PR5) AbstractC16720ll0.b(new PR5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_DESTINATION_CARDS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetDestinationCards{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
