package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class FQ5 extends TP5 {
    private String a;
    private EnumC18602ow b;
    private C17420mw c;

    public static FQ5 r(byte[] bArr) {
        return (FQ5) AbstractC16720ll0.b(new FQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC18602ow.p(iH);
        }
        this.c = (C17420mw) c19084pl0.z(3, new C17420mw());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.CREATE_SAVED_BILL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        EnumC18602ow enumC18602ow = this.b;
        if (enumC18602ow != null) {
            c19675ql0.f(2, enumC18602ow.j());
        }
        C17420mw c17420mw = this.c;
        if (c17420mw != null) {
            c19675ql0.i(3, c17420mw);
        }
    }

    public String toString() {
        return "rpc CreateSavedBill{}";
    }
}
