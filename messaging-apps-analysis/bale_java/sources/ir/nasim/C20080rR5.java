package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.rR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20080rR5 extends TP5 {
    private int a;
    private int b;

    public static C20080rR5 r(byte[] bArr) {
        return (C20080rR5) AbstractC16720ll0.b(new C20080rR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_ACQUIRED_VOUCHERS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
    }

    public String toString() {
        return "rpc GetAcquiredVouchers{}";
    }
}
