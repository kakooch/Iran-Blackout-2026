package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class CU5 extends TP5 {
    private C4392Ey a;
    private Long b;
    private String c;
    private long d;

    public static CU5 r(byte[] bArr) {
        return (CU5) AbstractC16720ll0.b(new CU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(2, new C4392Ey());
        this.b = Long.valueOf(c19084pl0.y(3));
        this.c = c19084pl0.A(4);
        this.d = c19084pl0.i(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(2, c4392Ey);
        }
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(3, l.longValue());
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(4, str);
        }
        c19675ql0.g(5, this.d);
    }

    public String toString() {
        return "rpc PurchaseMessageWithCharge{}";
    }
}
