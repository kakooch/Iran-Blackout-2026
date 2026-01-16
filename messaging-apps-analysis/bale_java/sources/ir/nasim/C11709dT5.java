package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.dT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11709dT5 extends TP5 {
    private C4392Ey a;

    public static C11709dT5 r(byte[] bArr) {
        return (C11709dT5) AbstractC16720ll0.b(new C11709dT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
    }

    public String toString() {
        return "rpc GetTotalPaidAmount{}";
    }
}
