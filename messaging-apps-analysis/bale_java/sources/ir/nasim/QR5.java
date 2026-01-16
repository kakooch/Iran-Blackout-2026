package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class QR5 extends TP5 {
    public static QR5 r(byte[] bArr) {
        return (QR5) AbstractC16720ll0.b(new QR5(), bArr);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER;
    }

    public String toString() {
        return "rpc GetDialogAdOrderDetails{}";
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
    }
}
