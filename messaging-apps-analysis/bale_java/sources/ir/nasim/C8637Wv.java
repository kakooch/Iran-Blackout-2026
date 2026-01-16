package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Wv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C8637Wv extends AbstractC25211zv {
    private String a;
    private String b;
    private C4626Fy c;
    private int d;
    private int e;
    private String f;
    private String g;
    private C16966mA h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = (C4626Fy) c19084pl0.z(3, new C4626Fy());
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.g(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.r(7);
        this.h = (C16966mA) c19084pl0.z(8, new C16966mA());
    }

    @Override // ir.nasim.AbstractC25211zv
    public int s() {
        return 7;
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
        C4626Fy c4626Fy = this.c;
        if (c4626Fy != null) {
            c19675ql0.i(3, c4626Fy);
        }
        c19675ql0.f(4, this.d);
        c19675ql0.f(5, this.e);
        String str3 = this.f;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str3);
        String str4 = this.g;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(7, str4);
        C16966mA c16966mA = this.h;
        if (c16966mA != null) {
            c19675ql0.i(8, c16966mA);
        }
    }

    public String toString() {
        return "struct BaleSponsoredMessageAd{}";
    }
}
