package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class WV5 extends TP5 {
    private C18766pD a;

    public static WV5 r(byte[] bArr) {
        return (WV5) AbstractC16720ll0.b(new WV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C18766pD) c19084pl0.z(1, new C18766pD());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.UNBLOCK_USER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C18766pD c18766pD = this.a;
        if (c18766pD != null) {
            c19675ql0.i(1, c18766pD);
        }
    }

    public String toString() {
        return "rpc UnblockUser{}";
    }
}
