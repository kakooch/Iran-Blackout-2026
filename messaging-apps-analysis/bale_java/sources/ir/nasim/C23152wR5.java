package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.wR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23152wR5 extends TP5 {
    private int a;
    private int b;

    public static C23152wR5 r(byte[] bArr) {
        return (C23152wR5) AbstractC16720ll0.b(new C23152wR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_BILL_HISTORY_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
    }

    public String toString() {
        return "rpc GetBillHistory{}";
    }
}
