package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.mz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17447mz extends AbstractC17902nl0 {
    private String a;
    private String b;
    private EnumC18038nz c;
    private EnumC18629oz d;
    private String e;
    private int f;
    private long g;
    private int h;
    private String i;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC18038nz.p(iH);
        }
        int iH2 = c19084pl0.h(4, 0);
        if (iH2 != 0) {
            this.d = EnumC18629oz.p(iH2);
        }
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.g(6);
        this.g = c19084pl0.i(7);
        this.h = c19084pl0.g(8);
        this.i = c19084pl0.r(9);
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
        EnumC18038nz enumC18038nz = this.c;
        if (enumC18038nz != null) {
            c19675ql0.f(3, enumC18038nz.j());
        }
        EnumC18629oz enumC18629oz = this.d;
        if (enumC18629oz != null) {
            c19675ql0.f(4, enumC18629oz.j());
        }
        String str3 = this.e;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str3);
        c19675ql0.f(6, this.f);
        c19675ql0.g(7, this.g);
        c19675ql0.f(8, this.h);
        String str4 = this.i;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(9, str4);
    }

    public String toString() {
        return "struct Loan{}";
    }
}
