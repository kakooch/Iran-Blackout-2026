package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.io.IOException;

/* renamed from: ir.nasim.yT5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24350yT5 extends TP5 {
    private String a;
    private String b;
    private String c;
    private String d;
    private EnumC17438my e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private String m;
    private String n;
    private String o;

    public static C24350yT5 r(byte[] bArr) {
        return (C24350yT5) AbstractC16720ll0.b(new C24350yT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        int iH = c19084pl0.h(5, 0);
        if (iH != 0) {
            this.e = EnumC17438my.p(iH);
        }
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = c19084pl0.r(8);
        this.i = c19084pl0.r(9);
        this.j = c19084pl0.r(10);
        this.k = c19084pl0.g(11);
        this.l = c19084pl0.g(12);
        this.m = c19084pl0.r(13);
        this.n = c19084pl0.r(14);
        this.o = c19084pl0.r(15);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return SetRpcStruct$ComposedRpc.INIT_P12_FIELD_NUMBER;
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
        String str3 = this.c;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str3);
        String str4 = this.d;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str4);
        EnumC17438my enumC17438my = this.e;
        if (enumC17438my != null) {
            c19675ql0.f(5, enumC17438my.j());
        }
        String str5 = this.f;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str5);
        String str6 = this.g;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str6);
        String str7 = this.h;
        if (str7 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str7);
        String str8 = this.i;
        if (str8 == null) {
            throw new IOException();
        }
        c19675ql0.o(9, str8);
        String str9 = this.j;
        if (str9 == null) {
            throw new IOException();
        }
        c19675ql0.o(10, str9);
        c19675ql0.f(11, this.k);
        c19675ql0.f(12, this.l);
        String str10 = this.m;
        if (str10 == null) {
            throw new IOException();
        }
        c19675ql0.o(13, str10);
        String str11 = this.n;
        if (str11 == null) {
            throw new IOException();
        }
        c19675ql0.o(14, str11);
        String str12 = this.o;
        if (str12 == null) {
            throw new IOException();
        }
        c19675ql0.o(15, str12);
    }

    public String toString() {
        return "rpc InitP12{}";
    }
}
