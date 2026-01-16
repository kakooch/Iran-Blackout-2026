package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class SR5 extends TP5 {
    private String a;
    private long b;
    private C17557nA c;
    private C21001sy d;

    public static SR5 r(byte[] bArr) {
        return (SR5) AbstractC16720ll0.b(new SR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        this.c = (C17557nA) c19084pl0.z(3, new C17557nA());
        this.d = (C21001sy) c19084pl0.z(4, new C21001sy());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(2, this.b);
        C17557nA c17557nA = this.c;
        if (c17557nA != null) {
            c19675ql0.i(3, c17557nA);
        }
        C21001sy c21001sy = this.d;
        if (c21001sy != null) {
            c19675ql0.i(4, c21001sy);
        }
    }

    public String toString() {
        return "rpc GetGiftPacketPaymentToken{}";
    }
}
