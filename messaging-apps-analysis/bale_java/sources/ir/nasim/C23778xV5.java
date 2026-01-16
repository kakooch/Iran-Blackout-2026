package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.xV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23778xV5 extends TP5 {
    private C25238zy a;
    private BB b;
    private String c;

    public static C23778xV5 r(byte[] bArr) {
        return (C23778xV5) AbstractC16720ll0.b(new C23778xV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = BB.p(iH);
        }
        this.c = c19084pl0.A(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SET_RESTRICTION_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        BB bb = this.b;
        if (bb != null) {
            c19675ql0.f(2, bb.j());
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "rpc SetRestriction{}";
    }
}
