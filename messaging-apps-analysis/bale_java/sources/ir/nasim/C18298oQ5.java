package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.oQ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18298oQ5 extends TP5 {
    private String a;
    private String b;
    private long c;
    private EnumC12175eA d;
    private Long e;
    private Integer f;

    public static C18298oQ5 r(byte[] bArr) {
        return (C18298oQ5) AbstractC16720ll0.b(new C18298oQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.i(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = EnumC12175eA.p(iH);
        }
        this.e = Long.valueOf(c19084pl0.y(5));
        this.f = Integer.valueOf(c19084pl0.x(6));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.BUY_INTERNET_BUNDLE_FIELD_NUMBER;
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
        EnumC12175eA enumC12175eA = this.d;
        if (enumC12175eA != null) {
            c19675ql0.f(4, enumC12175eA.j());
        }
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(5, l.longValue());
        }
        Integer num = this.f;
        if (num != null) {
            c19675ql0.f(6, num.intValue());
        }
    }

    public String toString() {
        return "rpc BuyInternetBundle{}";
    }
}
