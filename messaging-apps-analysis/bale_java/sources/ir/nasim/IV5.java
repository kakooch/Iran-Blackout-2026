package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class IV5 extends TP5 {
    private C24045xx a;

    public static IV5 r(byte[] bArr) {
        return (IV5) AbstractC16720ll0.b(new IV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C24045xx) c19084pl0.z(1, new C24045xx());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SUBMIT_DIALOG_AD_ORDER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C24045xx c24045xx = this.a;
        if (c24045xx != null) {
            c19675ql0.i(1, c24045xx);
        }
    }

    public String toString() {
        return "rpc SubmitDialogAdOrder{}";
    }
}
