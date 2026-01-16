package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.xx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24045xx extends AbstractC17902nl0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private long g;
    private int h;
    private long i;
    private long j;
    private String k;
    private long l;
    private long m;
    private long n;
    private long o;
    private EnumC3897Cv p;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.i(6);
        this.g = c19084pl0.i(7);
        this.h = c19084pl0.g(8);
        this.i = c19084pl0.i(9);
        this.j = c19084pl0.i(10);
        this.k = c19084pl0.r(11);
        this.l = c19084pl0.i(12);
        this.m = c19084pl0.i(13);
        this.n = c19084pl0.i(14);
        this.o = c19084pl0.i(15);
        int iH = c19084pl0.h(16, 0);
        if (iH != 0) {
            this.p = EnumC3897Cv.p(iH);
        }
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
        String str5 = this.e;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str5);
        c19675ql0.g(6, this.f);
        c19675ql0.g(7, this.g);
        c19675ql0.f(8, this.h);
        c19675ql0.g(9, this.i);
        c19675ql0.g(10, this.j);
        String str6 = this.k;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(11, str6);
        c19675ql0.g(12, this.l);
        c19675ql0.g(13, this.m);
        c19675ql0.g(14, this.n);
        c19675ql0.g(15, this.o);
        EnumC3897Cv enumC3897Cv = this.p;
        if (enumC3897Cv != null) {
            c19675ql0.f(16, enumC3897Cv.j());
        }
    }

    public String toString() {
        return "struct DialogAdOrder{}";
    }
}
