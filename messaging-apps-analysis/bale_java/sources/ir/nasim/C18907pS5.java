package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.pS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18907pS5 extends TP5 {
    public static C18907pS5 r(byte[] bArr) {
        return (C18907pS5) AbstractC16720ll0.b(new C18907pS5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_MY_WALLETS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetMyWallets{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
