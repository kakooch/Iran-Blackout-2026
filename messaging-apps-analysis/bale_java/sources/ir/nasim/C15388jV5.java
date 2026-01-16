package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.jV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15388jV5 extends TP5 {
    private C17557nA a;
    private long b;
    private C21001sy c;
    private String d;

    public C15388jV5(C17557nA c17557nA, long j, C21001sy c21001sy, String str) {
        this.a = c17557nA;
        this.b = j;
        this.c = c21001sy;
        this.d = str;
    }

    public static C15388jV5 r(byte[] bArr) {
        return (C15388jV5) AbstractC16720ll0.b(new C15388jV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        this.b = c19084pl0.i(2);
        this.c = (C21001sy) c19084pl0.z(3, new C21001sy());
        this.d = c19084pl0.r(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEND_GIFT_PACKET_WITH_WALLET_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        c19675ql0.g(2, this.b);
        C21001sy c21001sy = this.c;
        if (c21001sy != null) {
            c19675ql0.i(3, c21001sy);
        }
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
    }

    public String toString() {
        return "rpc SendGiftPacketWithWallet{}";
    }

    public C15388jV5() {
    }
}
