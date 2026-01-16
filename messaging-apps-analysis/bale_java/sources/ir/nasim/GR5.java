package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class GR5 extends TP5 {
    private String a;
    private long b;
    private EnumC6520Nw c;

    public static GR5 r(byte[] bArr) {
        return (GR5) AbstractC16720ll0.b(new GR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC6520Nw.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(2, this.b);
        EnumC6520Nw enumC6520Nw = this.c;
        if (enumC6520Nw != null) {
            c19675ql0.f(3, enumC6520Nw.j());
        }
    }

    public String toString() {
        return "rpc GetChargePaymentToken{}";
    }
}
