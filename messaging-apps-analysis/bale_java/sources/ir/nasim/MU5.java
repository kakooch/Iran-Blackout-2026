package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.List;

/* loaded from: classes4.dex */
public class MU5 extends TP5 {
    private List a;

    public static MU5 r(byte[] bArr) {
        return (MU5) AbstractC16720ll0.b(new MU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.q(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.REMOVE_DESTINATION_CARDS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.n(1, this.a);
    }

    public String toString() {
        return "rpc RemoveDestinationCards{}";
    }
}
