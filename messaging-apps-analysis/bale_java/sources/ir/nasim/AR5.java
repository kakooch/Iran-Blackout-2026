package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class AR5 extends TP5 {
    private Integer a;
    private Long b;
    private String c;

    public static AR5 r(byte[] bArr) {
        return (AR5) AbstractC16720ll0.b(new AR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Integer.valueOf(c19084pl0.x(1));
        this.b = Long.valueOf(c19084pl0.y(2));
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Integer num = this.a;
        if (num != null) {
            c19675ql0.f(1, num.intValue());
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
        return "rpc GetCardTransferToken{}";
    }
}
