package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class SS5 extends TP5 {
    public static SS5 r(byte[] bArr) {
        return (SS5) AbstractC16720ll0.b(new SS5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_REFERRAL_CONTACTS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetReferralContacts{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
