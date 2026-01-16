package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class CS5 extends TP5 {
    private C4392Ey a;
    private int b;
    private int c;

    public static CS5 r(byte[] bArr) {
        return (CS5) AbstractC16720ll0.b(new CS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
        this.b = c19084pl0.g(3);
        this.c = c19084pl0.g(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_PARTICIPANTS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
        c19675ql0.f(3, this.b);
        c19675ql0.f(4, this.c);
    }

    public String toString() {
        return "rpc GetParticipants{}";
    }
}
