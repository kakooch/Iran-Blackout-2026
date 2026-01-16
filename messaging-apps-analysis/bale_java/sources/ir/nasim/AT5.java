package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class AT5 extends TP5 {
    private EnumC18602ow a;
    private C17420mw b;

    public static AT5 r(byte[] bArr) {
        return (AT5) AbstractC16720ll0.b(new AT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC18602ow.p(iH);
        }
        this.b = (C17420mw) c19084pl0.z(2, new C17420mw());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.INQUIRY_BILL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC18602ow enumC18602ow = this.a;
        if (enumC18602ow != null) {
            c19675ql0.f(1, enumC18602ow.j());
        }
        C17420mw c17420mw = this.b;
        if (c17420mw != null) {
            c19675ql0.i(2, c17420mw);
        }
    }

    public String toString() {
        return "rpc InquiryBill{}";
    }
}
