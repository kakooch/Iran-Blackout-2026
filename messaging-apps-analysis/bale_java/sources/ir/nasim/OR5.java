package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class OR5 extends TP5 {
    private String a;
    private String b;
    private int c;
    private String d;
    private int e;
    private C5577Jy f;
    private C4392Ey g;

    public static OR5 r(byte[] bArr) {
        return (OR5) AbstractC16720ll0.b(new OR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.g(5);
        this.f = (C5577Jy) c19084pl0.z(6, new C5577Jy());
        this.g = (C4392Ey) c19084pl0.z(7, new C4392Ey());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_DESTINATION_CARD_INFO_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.b;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        c19675ql0.f(3, this.c);
        String str3 = this.d;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str3);
        c19675ql0.f(5, this.e);
        C5577Jy c5577Jy = this.f;
        if (c5577Jy != null) {
            c19675ql0.i(6, c5577Jy);
        }
        C4392Ey c4392Ey = this.g;
        if (c4392Ey != null) {
            c19675ql0.i(7, c4392Ey);
        }
    }

    public String toString() {
        return "rpc GetDestinationCardInfo{}";
    }
}
