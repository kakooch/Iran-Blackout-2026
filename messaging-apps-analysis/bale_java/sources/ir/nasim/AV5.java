package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class AV5 extends TP5 {
    private String a;
    private String b;
    private EnumC24781zC c;
    private String d;

    public static AV5 r(byte[] bArr) {
        return (AV5) AbstractC16720ll0.b(new AV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC24781zC.p(iH);
        }
        this.d = c19084pl0.A(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER;
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
        EnumC24781zC enumC24781zC = this.c;
        if (enumC24781zC != null) {
            c19675ql0.f(3, enumC24781zC.j());
        }
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
    }

    public String toString() {
        return "rpc SignUp{}";
    }
}
