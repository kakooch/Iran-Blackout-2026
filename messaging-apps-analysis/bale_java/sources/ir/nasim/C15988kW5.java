package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.kW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15988kW5 extends TP5 {
    private C22993wA a;

    public static C15988kW5 r(byte[] bArr) {
        return (C15988kW5) AbstractC16720ll0.b(new C15988kW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.VERIFY_PEER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
    }

    public String toString() {
        return "rpc VerifyPeer{}";
    }
}
