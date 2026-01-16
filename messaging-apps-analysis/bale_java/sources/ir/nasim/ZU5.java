package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class ZU5 extends TP5 {
    private JA a;

    public static ZU5 r(byte[] bArr) {
        return (ZU5) AbstractC16720ll0.b(new ZU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (JA) c19084pl0.z(1, new JA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.REVIVE_TRANSACTION_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        JA ja2 = this.a;
        if (ja2 != null) {
            c19675ql0.i(1, ja2);
        }
    }

    public String toString() {
        return "rpc ReviveTransaction{}";
    }
}
