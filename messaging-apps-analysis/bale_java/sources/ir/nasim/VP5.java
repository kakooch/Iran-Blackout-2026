package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class VP5 extends TP5 {
    private long a;
    private C19784qw b;

    public static VP5 r(byte[] bArr) {
        return (VP5) AbstractC16720ll0.b(new VP5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = (C19784qw) c19084pl0.z(2, new C19784qw());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.ACCEPT_CALL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        C19784qw c19784qw = this.b;
        if (c19784qw != null) {
            c19675ql0.i(2, c19784qw);
        }
    }

    public String toString() {
        return "rpc AcceptCall{}";
    }
}
