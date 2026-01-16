package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.eT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12352eT5 extends TP5 {
    private JA a;

    public static C12352eT5 r(byte[] bArr) {
        return (C12352eT5) AbstractC16720ll0.b(new C12352eT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (JA) c19084pl0.z(1, new JA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        JA ja2 = this.a;
        if (ja2 != null) {
            c19675ql0.i(1, ja2);
        }
    }

    public String toString() {
        return "rpc GetTransactionTags{}";
    }
}
