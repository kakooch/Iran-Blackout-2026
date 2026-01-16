package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class EV5 extends TP5 {
    private C17557nA a;
    private long b;
    private boolean c;

    public static EV5 r(byte[] bArr) {
        return (EV5) AbstractC16720ll0.b(new EV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.b(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.START_CALL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        c19675ql0.g(2, this.b);
        c19675ql0.a(3, this.c);
    }

    public String toString() {
        return "rpc StartCall{}";
    }
}
