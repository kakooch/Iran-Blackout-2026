package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.yR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24332yR5 extends TP5 {
    private C25238zy a;
    private int b;

    public static C24332yR5 r(byte[] bArr) {
        return (C24332yR5) AbstractC16720ll0.b(new C24332yR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = c19084pl0.g(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        c19675ql0.f(2, this.b);
    }

    public String toString() {
        return "rpc GetCanSeeMessages{}";
    }
}
