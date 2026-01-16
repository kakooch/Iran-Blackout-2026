package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.lR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16534lR5 extends TP5 {
    private OC a;

    public static C16534lR5 r(byte[] bArr) {
        return (C16534lR5) AbstractC16720ll0.b(new C16534lR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (OC) c19084pl0.z(1, new OC());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ENROLL_NEW_CARD_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        OC oc = this.a;
        if (oc != null) {
            c19675ql0.i(1, oc);
        }
    }

    public String toString() {
        return "rpc EnrollNewCard{}";
    }
}
