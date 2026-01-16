package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.nT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17734nT5 extends TP5 {
    private int a;

    public static C17734nT5 r(byte[] bArr) {
        return (C17734nT5) AbstractC16720ll0.b(new C17734nT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_USER_VITRINE_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
    }

    public String toString() {
        return "rpc GetUserVitrine{}";
    }
}
