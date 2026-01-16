package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.kS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15952kS5 extends TP5 {
    private C4392Ey a;
    private Long b;
    private String c;

    public static C15952kS5 r(byte[] bArr) {
        return (C15952kS5) AbstractC16720ll0.b(new C15952kS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
        this.b = Long.valueOf(c19084pl0.y(2));
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(2, l.longValue());
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "rpc GetMoneyRequestPaymentTokenByCard{}";
    }
}
