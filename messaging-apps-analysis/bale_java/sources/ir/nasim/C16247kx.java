package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.kx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16247kx extends AbstractC24063xz {
    private long a;
    private String b;
    private long c;
    private String d;
    private String e;
    private long f;
    private EnumC16838lx g;
    private C6035Lx h;

    public C16247kx(long j, String str, long j2, String str2, String str3, long j3, EnumC16838lx enumC16838lx, C6035Lx c6035Lx) {
        this.a = j;
        this.b = str;
        this.c = j2;
        this.d = str2;
        this.e = str3;
        this.f = j3;
        this.g = enumC16838lx;
        this.h = c6035Lx;
    }

    public long C() {
        return this.c;
    }

    public EnumC16838lx D() {
        return this.g;
    }

    public String E() {
        return this.d;
    }

    public long F() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        this.f = c19084pl0.i(6);
        int iH = c19084pl0.h(7, 0);
        if (iH != 0) {
            this.g = EnumC16838lx.p(iH);
        }
        this.h = (C6035Lx) c19084pl0.z(8, new C6035Lx());
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 23;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.g(3, this.c);
        String str2 = this.d;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str2);
        String str3 = this.e;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str3);
        c19675ql0.g(6, this.f);
        EnumC16838lx enumC16838lx = this.g;
        if (enumC16838lx != null) {
            c19675ql0.f(7, enumC16838lx.j());
        }
        C6035Lx c6035Lx = this.h;
        if (c6035Lx != null) {
            c19675ql0.i(8, c6035Lx);
        }
    }

    public String toString() {
        return "struct CrowdFundingMessage{}";
    }

    public String u() {
        return this.b;
    }

    public String w() {
        return this.e;
    }

    public long y() {
        return this.f;
    }

    public C6035Lx z() {
        return this.h;
    }

    public C16247kx() {
    }
}
