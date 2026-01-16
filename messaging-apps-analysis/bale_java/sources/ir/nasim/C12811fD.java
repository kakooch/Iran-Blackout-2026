package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.fD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12811fD extends AbstractC17902nl0 {
    private long a;
    private String b;
    private String c;
    private long d;
    private String e;
    private String f;
    private int g;
    private String h;
    private int i;
    private String j;
    private Integer k;

    public C12811fD(long j, String str, String str2, long j2, String str3, String str4, int i, String str5, int i2, String str6, Integer num) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = j2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = str5;
        this.i = i2;
        this.j = str6;
        this.k = num;
    }

    public long C() {
        return this.d;
    }

    public String D() {
        return this.b;
    }

    public String E() {
        return this.j;
    }

    public String F() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.g(7);
        this.h = c19084pl0.r(8);
        this.i = c19084pl0.g(9);
        this.j = c19084pl0.r(10);
        this.k = Integer.valueOf(c19084pl0.x(11));
    }

    public int q() {
        return this.i;
    }

    public int r() {
        return this.g;
    }

    public String s() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
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
        c19675ql0.g(4, this.d);
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
        c19675ql0.f(7, this.g);
        String str5 = this.h;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str5);
        c19675ql0.f(9, this.i);
        String str6 = this.j;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(10, str6);
        Integer num = this.k;
        if (num != null) {
            c19675ql0.f(11, num.intValue());
        }
    }

    public String toString() {
        return "struct Transaction{}";
    }

    public Integer u() {
        return this.k;
    }

    public long w() {
        return this.a;
    }

    public String y() {
        return this.e;
    }

    public String z() {
        return this.c;
    }

    public C12811fD() {
    }
}
