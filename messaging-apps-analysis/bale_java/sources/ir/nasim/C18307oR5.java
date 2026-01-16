package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.oR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18307oR5 extends TP5 {
    private C25238zy a;

    public static C18307oR5 r(byte[] bArr) {
        return (C18307oR5) AbstractC16720ll0.b(new C18307oR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.FETCH_GROUP_ADMINS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
    }

    public String toString() {
        return "rpc FetchGroupAdmins{}";
    }
}
