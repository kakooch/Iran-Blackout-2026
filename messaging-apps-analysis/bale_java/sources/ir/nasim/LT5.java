package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class LT5 extends TP5 {
    public static LT5 r(byte[] bArr) {
        return (LT5) AbstractC16720ll0.b(new LT5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.LOAD_BLOCKED_USERS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc LoadBlockedUsers{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
