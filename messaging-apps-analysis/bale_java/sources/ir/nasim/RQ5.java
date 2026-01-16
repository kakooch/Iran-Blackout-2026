package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.List;

/* loaded from: classes4.dex */
public class RQ5 extends TP5 {
    private List a;

    public static RQ5 r(byte[] bArr) {
        return (RQ5) AbstractC16720ll0.b(new RQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.o(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.DELETE_SAVED_BILLS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.l(1, this.a);
    }

    public String toString() {
        return "rpc DeleteSavedBills{}";
    }
}
