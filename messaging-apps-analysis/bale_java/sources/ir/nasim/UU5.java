package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class UU5 extends TP5 {
    private C25238zy a;
    private C18766pD b;

    public static UU5 r(byte[] bArr) {
        return (UU5) AbstractC16720ll0.b(new UU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = (C18766pD) c19084pl0.z(2, new C18766pD());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.REMOVE_USER_ADMIN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        C18766pD c18766pD = this.b;
        if (c18766pD != null) {
            c19675ql0.i(2, c18766pD);
        }
    }

    public String toString() {
        return "rpc RemoveUserAdmin{}";
    }
}
