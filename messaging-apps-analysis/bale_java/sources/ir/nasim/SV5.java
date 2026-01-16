package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* loaded from: classes4.dex */
public class SV5 extends TP5 {
    private String a;
    private long b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private OC k;
    private C4392Ey l;
    private C5577Jy m;
    private OC n;
    private OC o;

    public static SV5 r(byte[] bArr) {
        return (SV5) AbstractC16720ll0.b(new SV5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = c19084pl0.r(8);
        this.i = c19084pl0.g(9);
        this.j = c19084pl0.r(10);
        this.k = (OC) c19084pl0.z(11, new OC());
        this.l = (C4392Ey) c19084pl0.z(12, new C4392Ey());
        this.m = (C5577Jy) c19084pl0.z(13, new C5577Jy());
        this.n = (OC) c19084pl0.z(14, new OC());
        this.o = (OC) c19084pl0.z(15, new OC());
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.TRANSFER_MONEY_BY_CARD_FIELD_NUMBER;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.g(2, this.b);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        c19675ql0.f(4, this.d);
        String str3 = this.e;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str3);
        String str4 = this.f;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str4);
        String str5 = this.g;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str5);
        String str6 = this.h;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str6);
        c19675ql0.f(9, this.i);
        String str7 = this.j;
        if (str7 == null) {
            throw new IOException();
        }
        c19675ql0.o(10, str7);
        OC oc = this.k;
        if (oc != null) {
            c19675ql0.i(11, oc);
        }
        C4392Ey c4392Ey = this.l;
        if (c4392Ey != null) {
            c19675ql0.i(12, c4392Ey);
        }
        C5577Jy c5577Jy = this.m;
        if (c5577Jy != null) {
            c19675ql0.i(13, c5577Jy);
        }
        OC oc2 = this.n;
        if (oc2 != null) {
            c19675ql0.i(14, oc2);
        }
        OC oc3 = this.o;
        if (oc3 != null) {
            c19675ql0.i(15, oc3);
        }
    }

    public String toString() {
        return "rpc TransferMoneyByCard{}";
    }
}
