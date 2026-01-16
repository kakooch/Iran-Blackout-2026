package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class CT5 extends TP5 {
    private String a;
    private int b;
    private int c;

    public static CT5 r(byte[] bArr) {
        return (CT5) AbstractC16720ll0.b(new CT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.g(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.INVOICE_KIFPOOL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
        c19675ql0.f(3, this.c);
    }

    public String toString() {
        return "rpc InvoiceKifpool{}";
    }
}
