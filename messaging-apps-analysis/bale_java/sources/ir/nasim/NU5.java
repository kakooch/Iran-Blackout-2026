package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class NU5 extends TP5 {
    private C12056dy a;

    public static NU5 r(byte[] bArr) {
        return (NU5) AbstractC16720ll0.b(new NU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C12056dy) c19084pl0.z(1, new C12056dy());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.REMOVE_GIF_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C12056dy c12056dy = this.a;
        if (c12056dy != null) {
            c19675ql0.i(1, c12056dy);
        }
    }

    public String toString() {
        return "rpc RemoveGif{}";
    }
}
