package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Oy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6777Oy extends AbstractC17902nl0 {
    private long a;
    private EnumC12175eA b;
    private String c;
    private EnumC6538Ny d;
    private C19784qw e;
    private C6044Ly f;
    private C5577Jy g;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC12175eA.p(iH);
        }
        this.c = c19084pl0.r(3);
        int iH2 = c19084pl0.h(4, 0);
        if (iH2 != 0) {
            this.d = EnumC6538Ny.p(iH2);
        }
        this.e = (C19784qw) c19084pl0.z(5, new C19784qw());
        this.f = (C6044Ly) c19084pl0.z(6, new C6044Ly());
        this.g = (C5577Jy) c19084pl0.z(7, new C5577Jy());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        EnumC12175eA enumC12175eA = this.b;
        if (enumC12175eA != null) {
            c19675ql0.f(2, enumC12175eA.j());
        }
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        EnumC6538Ny enumC6538Ny = this.d;
        if (enumC6538Ny != null) {
            c19675ql0.f(4, enumC6538Ny.j());
        }
        C19784qw c19784qw = this.e;
        if (c19784qw != null) {
            c19675ql0.i(5, c19784qw);
        }
        C6044Ly c6044Ly = this.f;
        if (c6044Ly != null) {
            c19675ql0.i(6, c6044Ly);
        }
        C5577Jy c5577Jy = this.g;
        if (c5577Jy != null) {
            c19675ql0.i(7, c5577Jy);
        }
    }

    public String toString() {
        return "struct InternetBundleOrder{}";
    }
}
