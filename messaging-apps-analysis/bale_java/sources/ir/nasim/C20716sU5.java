package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.sU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20716sU5 extends TP5 {
    private C16238kw a;

    public static C20716sU5 r(byte[] bArr) {
        return (C20716sU5) AbstractC16720ll0.b(new C20716sU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C16238kw) c19084pl0.z(1, new C16238kw());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.PAY_BILL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C16238kw c16238kw = this.a;
        if (c16238kw != null) {
            c19675ql0.i(1, c16238kw);
        }
    }

    public String toString() {
        return "rpc PayBill{}";
    }
}
