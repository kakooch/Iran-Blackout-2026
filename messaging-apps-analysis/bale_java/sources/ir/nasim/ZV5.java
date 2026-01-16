package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class ZV5 extends TP5 {
    private String a;
    private int b;
    private C8421Vx c;

    public static ZV5 r(byte[] bArr) {
        return (ZV5) AbstractC16720ll0.b(new ZV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
        this.c = (C8421Vx) c19084pl0.z(3, new C8421Vx());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.UPDATE_CLICK_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
        C8421Vx c8421Vx = this.c;
        if (c8421Vx != null) {
            c19675ql0.i(3, c8421Vx);
        }
    }

    public String toString() {
        return "rpc UpdateClick{}";
    }
}
