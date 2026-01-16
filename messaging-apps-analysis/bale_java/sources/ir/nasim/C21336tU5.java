package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.tU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21336tU5 extends TP5 {
    private String a;
    private String b;
    private long c;
    private EnumC18020nx d;
    private String e;

    public static C21336tU5 r(byte[] bArr) {
        return (C21336tU5) AbstractC16720ll0.b(new C21336tU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.i(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = EnumC18020nx.p(iH);
        }
        this.e = c19084pl0.A(5);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.PAY_BY_WALLET_FIELD_NUMBER;
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
        c19675ql0.g(3, this.c);
        EnumC18020nx enumC18020nx = this.d;
        if (enumC18020nx != null) {
            c19675ql0.f(4, enumC18020nx.j());
        }
        String str3 = this.e;
        if (str3 != null) {
            c19675ql0.o(5, str3);
        }
    }

    public String toString() {
        return "rpc PayByWallet{}";
    }
}
