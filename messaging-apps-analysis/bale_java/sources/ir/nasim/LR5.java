package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class LR5 extends TP5 {
    private String a;
    private long b;
    private String c;

    public static LR5 r(byte[] bArr) {
        return (LR5) AbstractC16720ll0.b(new LR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_CRYPTO_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(2, this.b);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
    }

    public String toString() {
        return "rpc GetCryptoChargePaymentToken{}";
    }
}
