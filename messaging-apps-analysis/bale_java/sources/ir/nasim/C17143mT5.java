package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.mT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17143mT5 extends TP5 {
    private OA a;

    public static C17143mT5 r(byte[] bArr) {
        return (C17143mT5) AbstractC16720ll0.b(new C17143mT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = OA.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_USER_TAGS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        OA oa = this.a;
        if (oa != null) {
            c19675ql0.f(1, oa.j());
        }
    }

    public String toString() {
        return "rpc GetUserTags{}";
    }
}
