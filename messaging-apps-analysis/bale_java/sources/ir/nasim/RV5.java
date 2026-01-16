package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class RV5 extends TP5 {
    private String a;
    private String b;
    private String c;
    private Integer d;
    private long e;
    private String f;

    public static RV5 r(byte[] bArr) {
        return (RV5) AbstractC16720ll0.b(new RV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.A(2);
        this.c = c19084pl0.A(3);
        this.d = Integer.valueOf(c19084pl0.x(4));
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.A(6);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.TRANSFER_MONEY_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 != null) {
            c19675ql0.o(2, str2);
        }
        String str3 = this.c;
        if (str3 != null) {
            c19675ql0.o(3, str3);
        }
        Integer num = this.d;
        if (num != null) {
            c19675ql0.f(4, num.intValue());
        }
        c19675ql0.g(5, this.e);
        String str4 = this.f;
        if (str4 != null) {
            c19675ql0.o(6, str4);
        }
    }

    public String toString() {
        return "rpc TransferMoney{}";
    }
}
