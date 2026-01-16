package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class DC extends AbstractC17902nl0 {
    private long a;
    private long b;
    private long c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private EnumC5091Hw k;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.g(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = c19084pl0.r(8);
        this.i = c19084pl0.r(9);
        this.j = c19084pl0.r(10);
        int iH = c19084pl0.h(11, 0);
        if (iH != 0) {
            this.k = EnumC5091Hw.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.f(4, this.d);
        c19675ql0.f(5, this.e);
        String str = this.f;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str);
        String str2 = this.g;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str2);
        String str3 = this.h;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str3);
        String str4 = this.i;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(9, str4);
        String str5 = this.j;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(10, str5);
        EnumC5091Hw enumC5091Hw = this.k;
        if (enumC5091Hw != null) {
            c19675ql0.f(11, enumC5091Hw.j());
        }
    }

    public String toString() {
        return "struct SipCall{}";
    }
}
