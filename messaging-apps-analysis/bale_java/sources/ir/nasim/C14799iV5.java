package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.iV5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14799iV5 extends TP5 {
    private int a;
    private String b;
    private String c;
    private C19811qz d;

    public static C14799iV5 r(byte[] bArr) {
        return (C14799iV5) AbstractC16720ll0.b(new C14799iV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = (C19811qz) c19084pl0.z(5, new C19811qz());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SEND_FEED_BACK_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        C19811qz c19811qz = this.d;
        if (c19811qz != null) {
            c19675ql0.i(5, c19811qz);
        }
    }

    public String toString() {
        return "rpc SendFeedBack{}";
    }
}
