package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.gT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13579gT5 extends TP5 {
    private long a;

    public static C13579gT5 r(byte[] bArr) {
        return (C13579gT5) AbstractC16720ll0.b(new C13579gT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_USER_BANK_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
    }

    public String toString() {
        return "rpc GetUserBank{}";
    }
}
