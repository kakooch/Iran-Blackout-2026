package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Ox, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6768Ox extends AbstractC17902nl0 {
    private int a;
    private int b;
    private long c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = c19084pl0.r(8);
        this.i = c19084pl0.r(9);
        this.j = c19084pl0.r(10);
        this.k = c19084pl0.r(11);
        this.l = c19084pl0.r(12);
        this.m = c19084pl0.g(13);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
        String str = this.e;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str);
        String str2 = this.f;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str2);
        String str3 = this.g;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str3);
        String str4 = this.h;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str4);
        String str5 = this.i;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(9, str5);
        String str6 = this.j;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(10, str6);
        String str7 = this.k;
        if (str7 == null) {
            throw new IOException();
        }
        c19675ql0.o(11, str7);
        String str8 = this.l;
        if (str8 == null) {
            throw new IOException();
        }
        c19675ql0.o(12, str8);
        c19675ql0.f(13, this.m);
    }

    public String toString() {
        return "struct EarnMoneyRequest{}";
    }
}
