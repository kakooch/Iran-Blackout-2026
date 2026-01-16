package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Vv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C8403Vv extends AbstractC25211zv {
    private String a;
    private C4626Fy b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private int h;
    private int i;
    private String j;
    private C16966mA k;
    private EnumC3663Bv l;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = (C4626Fy) c19084pl0.z(12, new C4626Fy());
        this.c = c19084pl0.r(2);
        this.d = c19084pl0.r(3);
        this.e = c19084pl0.r(4);
        this.f = c19084pl0.r(5);
        this.g = c19084pl0.i(6);
        this.h = c19084pl0.g(7);
        this.i = c19084pl0.g(8);
        this.j = c19084pl0.r(9);
        this.k = (C16966mA) c19084pl0.z(10, new C16966mA());
        int iH = c19084pl0.h(11, 0);
        if (iH != 0) {
            this.l = EnumC3663Bv.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC25211zv
    public int s() {
        return 5;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        C4626Fy c4626Fy = this.b;
        if (c4626Fy != null) {
            c19675ql0.i(12, c4626Fy);
        }
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        String str3 = this.d;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str3);
        String str4 = this.e;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str4);
        String str5 = this.f;
        if (str5 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str5);
        c19675ql0.g(6, this.g);
        c19675ql0.f(7, this.h);
        c19675ql0.f(8, this.i);
        String str6 = this.j;
        if (str6 == null) {
            throw new IOException();
        }
        c19675ql0.o(9, str6);
        C16966mA c16966mA = this.k;
        if (c16966mA != null) {
            c19675ql0.i(10, c16966mA);
        }
        EnumC3663Bv enumC3663Bv = this.l;
        if (enumC3663Bv != null) {
            c19675ql0.f(11, enumC3663Bv.j());
        }
    }

    public String toString() {
        return "struct BaleCustomAd{}";
    }
}
