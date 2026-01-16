package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes4.dex */
public class UQ5 extends TP5 {
    private long a;
    private int b;
    private EnumC5091Hw c;
    private EnumC5559Jw d;

    public static UQ5 r(byte[] bArr) {
        return (UQ5) AbstractC16720ll0.b(new UQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC5091Hw.p(iH);
        }
        int iH2 = c19084pl0.h(4, 0);
        if (iH2 != 0) {
            this.d = EnumC5559Jw.p(iH2);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.DISCARD_CALL_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        EnumC5091Hw enumC5091Hw = this.c;
        if (enumC5091Hw != null) {
            c19675ql0.f(3, enumC5091Hw.j());
        }
        EnumC5559Jw enumC5559Jw = this.d;
        if (enumC5559Jw != null) {
            c19675ql0.f(4, enumC5559Jw.j());
        }
    }

    public String toString() {
        return "rpc DiscardCall{}";
    }
}
