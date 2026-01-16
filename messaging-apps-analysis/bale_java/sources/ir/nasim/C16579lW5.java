package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.lW5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16579lW5 extends TP5 {
    private C4392Ey a;

    public static C16579lW5 r(byte[] bArr) {
        return (C16579lW5) AbstractC16720ll0.b(new C16579lW5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
    }

    public String toString() {
        return "rpc VerifyPurchaseMessage{}";
    }
}
