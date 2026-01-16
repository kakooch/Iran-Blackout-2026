package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class RR5 extends TP5 {
    private String a;
    private long b;
    private long c;

    public static RR5 r(byte[] bArr) {
        return (RR5) AbstractC16720ll0.b(new RR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "rpc GetDialogAdOrderPaymentToken{}";
    }
}
