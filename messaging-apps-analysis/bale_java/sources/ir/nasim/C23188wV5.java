package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.wV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23188wV5 extends TP5 {
    private C13993hA a;

    public static C23188wV5 r(byte[] bArr) {
        return (C23188wV5) AbstractC16720ll0.b(new C23188wV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C13993hA) c19084pl0.z(1, new C13993hA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SET_RECENT_ORDER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C13993hA c13993hA = this.a;
        if (c13993hA != null) {
            c19675ql0.i(1, c13993hA);
        }
    }

    public String toString() {
        return "rpc SetRecentOrder{}";
    }
}
