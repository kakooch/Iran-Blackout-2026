package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class US5 extends TP5 {
    public static US5 r(byte[] bArr) {
        return (US5) AbstractC16720ll0.b(new US5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_REFERRING_USER_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetReferringUser{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
