package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.zS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24935zS5 extends TP5 {
    private EnumC18739pA a;

    public static C24935zS5 r(byte[] bArr) {
        return (C24935zS5) AbstractC16720ll0.b(new C24935zS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC18739pA.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_PACKET_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC18739pA enumC18739pA = this.a;
        if (enumC18739pA != null) {
            c19675ql0.f(1, enumC18739pA.j());
        }
    }

    public String toString() {
        return "rpc GetPacket{}";
    }
}
