package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.hA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13993hA extends AbstractC17902nl0 {
    private String a;
    private EnumC11532dA b;
    private EnumC16375lA c;
    private int d;
    private long e;
    private String f;
    private long g;
    private C5577Jy h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC11532dA.p(iH);
        }
        int iH2 = c19084pl0.h(3, 0);
        if (iH2 != 0) {
            this.c = EnumC16375lA.p(iH2);
        }
        this.d = c19084pl0.g(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.r(6);
        this.g = c19084pl0.i(7);
        this.h = (C5577Jy) c19084pl0.z(8, new C5577Jy());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        EnumC11532dA enumC11532dA = this.b;
        if (enumC11532dA != null) {
            c19675ql0.f(2, enumC11532dA.j());
        }
        EnumC16375lA enumC16375lA = this.c;
        if (enumC16375lA != null) {
            c19675ql0.f(3, enumC16375lA.j());
        }
        c19675ql0.f(4, this.d);
        c19675ql0.g(5, this.e);
        String str2 = this.f;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str2);
        c19675ql0.g(7, this.g);
        C5577Jy c5577Jy = this.h;
        if (c5577Jy != null) {
            c19675ql0.i(8, c5577Jy);
        }
    }

    public String toString() {
        return "struct Order{}";
    }
}
