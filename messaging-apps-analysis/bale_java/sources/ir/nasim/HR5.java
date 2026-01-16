package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class HR5 extends TP5 {
    private String a;
    private String b;
    private int c;
    private String d;
    private Integer e;

    public static HR5 r(byte[] bArr) {
        return (HR5) AbstractC16720ll0.b(new HR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        this.e = Integer.valueOf(c19084pl0.x(5));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CHARGE_TOPUP_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        c19675ql0.f(3, this.c);
        String str3 = this.d;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str3);
        Integer num = this.e;
        if (num != null) {
            c19675ql0.f(5, num.intValue());
        }
    }

    public String toString() {
        return "rpc GetChargeTopupPaymentToken{}";
    }
}
