package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.sR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20689sR5 extends TP5 {
    private C25238zy a;
    private EnumC4599Fv b;
    private EnumC3897Cv c;
    private long d;

    public static C20689sR5 r(byte[] bArr) {
        return (C20689sR5) AbstractC16720ll0.b(new C20689sR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC4599Fv.p(iH);
        }
        int iH2 = c19084pl0.h(3, 0);
        if (iH2 != 0) {
            this.c = EnumC3897Cv.p(iH2);
        }
        this.d = c19084pl0.i(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_AD_PROVIDER_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        EnumC4599Fv enumC4599Fv = this.b;
        if (enumC4599Fv != null) {
            c19675ql0.f(2, enumC4599Fv.j());
        }
        EnumC3897Cv enumC3897Cv = this.c;
        if (enumC3897Cv != null) {
            c19675ql0.f(3, enumC3897Cv.j());
        }
        c19675ql0.g(4, this.d);
    }

    public String toString() {
        return "rpc GetAdProvider{}";
    }
}
