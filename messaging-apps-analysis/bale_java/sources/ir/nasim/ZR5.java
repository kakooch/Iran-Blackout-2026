package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class ZR5 extends TP5 {
    private EnumC12175eA a;
    private BC b;

    public static ZR5 r(byte[] bArr) {
        return (ZR5) AbstractC16720ll0.b(new ZR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC12175eA.p(iH);
        }
        int iH2 = c19084pl0.h(2, 0);
        if (iH2 != 0) {
            this.b = BC.p(iH2);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC12175eA enumC12175eA = this.a;
        if (enumC12175eA != null) {
            c19675ql0.f(1, enumC12175eA.j());
        }
        BC bc = this.b;
        if (bc != null) {
            c19675ql0.f(2, bc.j());
        }
    }

    public String toString() {
        return "rpc GetInternetBundleList{}";
    }
}
