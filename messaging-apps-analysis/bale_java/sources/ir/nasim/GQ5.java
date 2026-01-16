package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class GQ5 extends TP5 {
    private long a;
    private String b;
    private String c;
    private String d;
    private String e;

    public static GQ5 r(byte[] bArr) {
        return (GQ5) AbstractC16720ll0.b(new GQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.A(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.CRYPTO_TRANSFER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
        String str4 = this.e;
        if (str4 != null) {
            c19675ql0.o(5, str4);
        }
    }

    public String toString() {
        return "rpc CryptoTransfer{}";
    }
}
