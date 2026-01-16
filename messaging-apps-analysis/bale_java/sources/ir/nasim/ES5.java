package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class ES5 extends TP5 {
    private C4392Ey a;
    private String b;
    private Integer c;

    public static ES5 r(byte[] bArr) {
        return (ES5) AbstractC16720ll0.b(new ES5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
        this.b = c19084pl0.A(2);
        this.c = Integer.valueOf(c19084pl0.x(3));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        Integer num = this.c;
        if (num != null) {
            c19675ql0.f(3, num.intValue());
        }
    }

    public String toString() {
        return "rpc GetPaymentToken{}";
    }
}
