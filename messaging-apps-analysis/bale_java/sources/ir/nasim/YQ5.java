package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class YQ5 extends TP5 {
    private String a;
    private C5793Kw b;

    public static YQ5 r(byte[] bArr) {
        return (YQ5) AbstractC16720ll0.b(new YQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C5793Kw) c19084pl0.z(2, new C5793Kw());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.EDIT_CARD_EXPIRATION_DATE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C5793Kw c5793Kw = this.b;
        if (c5793Kw != null) {
            c19675ql0.i(2, c5793Kw);
        }
    }

    public String toString() {
        return "rpc EditCardExpirationDate{}";
    }
}
