package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class KU5 extends TP5 {
    public static KU5 r(byte[] bArr) {
        return (KU5) AbstractC16720ll0.b(new KU5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.REMOVE_DEFAULT_CARD_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc RemoveDefaultCard{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
