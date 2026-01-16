package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.aS5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C9726aS5 extends TP5 {
    private EnumC12175eA a;
    private long b;
    private String c;
    private Integer d;

    public static C9726aS5 r(byte[] bArr) {
        return (C9726aS5) AbstractC16720ll0.b(new C9726aS5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC12175eA.p(iH);
        }
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        this.d = Integer.valueOf(c19084pl0.x(4));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        EnumC12175eA enumC12175eA = this.a;
        if (enumC12175eA != null) {
            c19675ql0.f(1, enumC12175eA.j());
        }
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        Integer num = this.d;
        if (num != null) {
            c19675ql0.f(4, num.intValue());
        }
    }

    public String toString() {
        return "rpc GetInternetBundlePaymentToken{}";
    }
}
