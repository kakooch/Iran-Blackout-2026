package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.sT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20707sT5 extends TP5 {
    public static C20707sT5 r(byte[] bArr) {
        return (C20707sT5) AbstractC16720ll0.b(new C20707sT5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_WALLET_CONTRACTS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetWalletContracts{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
