package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.nS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17725nS5 extends TP5 {
    private String a;
    private SA b;

    public static C17725nS5 r(byte[] bArr) {
        return (C17725nS5) AbstractC16720ll0.b(new C17725nS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = SA.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_MY_KIFPOOLS_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        SA sa = this.b;
        if (sa != null) {
            c19675ql0.f(2, sa.j());
        }
    }

    public String toString() {
        return "rpc GetMyKifpools{}";
    }
}
