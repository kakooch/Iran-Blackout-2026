package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.bQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10302bQ5 extends TP5 {
    private JA a;
    private String b;

    public static C10302bQ5 r(byte[] bArr) {
        return (C10302bQ5) AbstractC16720ll0.b(new C10302bQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (JA) c19084pl0.z(1, new JA());
        this.b = c19084pl0.r(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ADD_DETAIL_TO_TRANSACTION_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        JA ja2 = this.a;
        if (ja2 != null) {
            c19675ql0.i(1, ja2);
        }
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
    }

    public String toString() {
        return "rpc AddDetailToTransaction{}";
    }
}
