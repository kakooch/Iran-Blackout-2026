package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.hR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14152hR5 extends TP5 {
    private String a;

    public static C14152hR5 r(byte[] bArr) {
        return (C14152hR5) AbstractC16720ll0.b(new C14152hR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
    }

    public String toString() {
        return "rpc EditNickName{}";
    }
}
