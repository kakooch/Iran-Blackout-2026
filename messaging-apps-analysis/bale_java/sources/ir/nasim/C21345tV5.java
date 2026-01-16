package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.tV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21345tV5 extends TP5 {
    private C25238zy a;
    private DA b;

    public static C21345tV5 r(byte[] bArr) {
        return (C21345tV5) AbstractC16720ll0.b(new C21345tV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = (DA) c19084pl0.z(2, new DA());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SET_GROUP_DEFAULT_PERMISSIONS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        DA da = this.b;
        if (da != null) {
            c19675ql0.i(2, da);
        }
    }

    public String toString() {
        return "rpc SetGroupDefaultPermissions{}";
    }
}
