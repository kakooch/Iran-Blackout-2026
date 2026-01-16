package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class AU5 extends TP5 {
    private String a;
    private byte[] b;
    private C19811qz c;

    public AU5(String str, byte[] bArr, C19811qz c19811qz) {
        this.a = str;
        this.b = bArr;
        this.c = c19811qz;
    }

    public static AU5 r(byte[] bArr) {
        return (AU5) AbstractC16720ll0.b(new AU5(), bArr);
    }

    public String getMethod() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.d(2);
        this.c = (C19811qz) c19084pl0.z(3, new C19811qz());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.PROTO_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        byte[] bArr = this.b;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        C19811qz c19811qz = this.c;
        if (c19811qz != null) {
            c19675ql0.i(3, c19811qz);
        }
    }

    public String toString() {
        return "rpc Proto{}";
    }

    public AU5() {
    }
}
