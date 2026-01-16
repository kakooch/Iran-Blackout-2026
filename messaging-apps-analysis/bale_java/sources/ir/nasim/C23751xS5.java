package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.xS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23751xS5 extends TP5 {
    private long a;
    private C4392Ey b;
    private String c;

    public static C23751xS5 r(byte[] bArr) {
        return (C23751xS5) AbstractC16720ll0.b(new C23751xS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = (C4392Ey) c19084pl0.z(2, new C4392Ey());
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        C4392Ey c4392Ey = this.b;
        if (c4392Ey != null) {
            c19675ql0.i(2, c4392Ey);
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "rpc GetPSProxyPaymentToken{}";
    }
}
