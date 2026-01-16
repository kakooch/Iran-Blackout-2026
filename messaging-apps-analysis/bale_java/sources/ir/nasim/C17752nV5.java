package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.nV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17752nV5 extends TP5 {
    private int a;

    public static C17752nV5 r(byte[] bArr) {
        return (C17752nV5) AbstractC16720ll0.b(new C17752nV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEND_MY_GIFT_PACKET_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
    }

    public String toString() {
        return "rpc SendMyGiftPacket{}";
    }
}
