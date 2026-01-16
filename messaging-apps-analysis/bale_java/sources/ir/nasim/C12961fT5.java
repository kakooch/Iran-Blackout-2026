package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.fT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12961fT5 extends TP5 {
    public static C12961fT5 r(byte[] bArr) {
        return (C12961fT5) AbstractC16720ll0.b(new C12961fT5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_USER_ACCOUNTS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetUserAccounts{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
