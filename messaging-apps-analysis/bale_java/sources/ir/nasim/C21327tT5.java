package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.tT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21327tT5 extends TP5 {
    private String a;
    private Integer b;

    public static C21327tT5 r(byte[] bArr) {
        return (C21327tT5) AbstractC16720ll0.b(new C21327tT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = Integer.valueOf(c19084pl0.x(2));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_WALLET_INVOICE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        Integer num = this.b;
        if (num != null) {
            c19675ql0.f(2, num.intValue());
        }
    }

    public String toString() {
        return "rpc GetWalletInvoice{}";
    }
}
