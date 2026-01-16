package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.pU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18925pU5 extends TP5 {
    private C4392Ey a;
    private String b;
    private Integer c;
    private EnumC22278uy d;

    public static C18925pU5 r(byte[] bArr) {
        return (C18925pU5) AbstractC16720ll0.b(new C18925pU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4392Ey) c19084pl0.z(1, new C4392Ey());
        this.b = c19084pl0.r(2);
        this.c = Integer.valueOf(c19084pl0.x(3));
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = EnumC22278uy.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.OPEN_GIFT_PACKET_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C4392Ey c4392Ey = this.a;
        if (c4392Ey != null) {
            c19675ql0.i(1, c4392Ey);
        }
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        Integer num = this.c;
        if (num != null) {
            c19675ql0.f(3, num.intValue());
        }
        EnumC22278uy enumC22278uy = this.d;
        if (enumC22278uy != null) {
            c19675ql0.f(4, enumC22278uy.j());
        }
    }

    public String toString() {
        return "rpc OpenGiftPacket{}";
    }
}
