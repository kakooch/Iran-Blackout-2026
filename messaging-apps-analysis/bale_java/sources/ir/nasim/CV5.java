package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class CV5 extends TP5 {
    private JA a;
    private List b;

    public static CV5 r(byte[] bArr) {
        return (CV5) AbstractC16720ll0.b(new CV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (JA) c19084pl0.z(1, new JA());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new FA());
        }
        this.b = c19084pl0.p(2, arrayList);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SPLIT_TRANSACTION_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        JA ja2 = this.a;
        if (ja2 != null) {
            c19675ql0.i(1, ja2);
        }
        c19675ql0.m(2, this.b);
    }

    public String toString() {
        return "rpc SplitTransaction{}";
    }
}
