package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.vR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22556vR5 extends TP5 {
    private EnumC9178Yv a;

    public static C22556vR5 r(byte[] bArr) {
        return (C22556vR5) AbstractC16720ll0.b(new C22556vR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC9178Yv.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_BAM_SERVICE_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC9178Yv enumC9178Yv = this.a;
        if (enumC9178Yv != null) {
            c19675ql0.f(1, enumC9178Yv.j());
        }
    }

    public String toString() {
        return "rpc GetBamServiceToken{}";
    }
}
