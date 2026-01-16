package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class WS5 extends TP5 {
    private C4392Ey a;
    private long b;
    private String c;

    public static WS5 r(byte[] bArr) {
        return (WS5) AbstractC16720ll0.b(new WS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "rpc GetSadadPSPPaymentToken{}";
    }
}
