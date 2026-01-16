package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Uv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C8169Uv extends AbstractC25211zv {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private C16966mA h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.g(7);
        this.g = c19084pl0.g(8);
        this.h = (C16966mA) c19084pl0.z(9, new C16966mA());
    }

    @Override // ir.nasim.AbstractC25211zv
    public int s() {
        return 6;
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
        c19675ql0.f(7, this.f);
        c19675ql0.f(8, this.g);
        C16966mA c16966mA = this.h;
        if (c16966mA != null) {
            c19675ql0.i(9, c16966mA);
        }
    }

    public String toString() {
        return "struct BaleChannelAd{}";
    }
}
