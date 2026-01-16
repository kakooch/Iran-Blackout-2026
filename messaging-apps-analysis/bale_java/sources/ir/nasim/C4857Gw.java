package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Gw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4857Gw extends AbstractC17902nl0 {
    private long a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private long f;
    private long g;
    private int h;
    private C22993wA i;
    private int j;
    private EnumC5091Hw k;
    private boolean l;
    private Long m;
    private Long n;

    public C4857Gw(long j, String str, String str2, String str3, boolean z, long j2, long j3, int i, C22993wA c22993wA, int i2, EnumC5091Hw enumC5091Hw, boolean z2, Long l, Long l2) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = j2;
        this.g = j3;
        this.h = i;
        this.i = c22993wA;
        this.j = i2;
        this.k = enumC5091Hw;
        this.l = z2;
        this.m = l;
        this.n = l2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.b(5);
        this.f = c19084pl0.i(6);
        this.g = c19084pl0.i(7);
        this.h = c19084pl0.g(8);
        this.i = (C22993wA) c19084pl0.z(9, new C22993wA());
        this.j = c19084pl0.g(10);
        int iH = c19084pl0.h(11, 0);
        if (iH != 0) {
            this.k = EnumC5091Hw.p(iH);
        }
        this.l = c19084pl0.b(12);
        this.m = Long.valueOf(c19084pl0.y(13));
        this.n = Long.valueOf(c19084pl0.y(14));
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
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
        c19675ql0.a(5, this.e);
        c19675ql0.g(6, this.f);
        c19675ql0.g(7, this.g);
        c19675ql0.f(8, this.h);
        C22993wA c22993wA = this.i;
        if (c22993wA != null) {
            c19675ql0.i(9, c22993wA);
        }
        c19675ql0.f(10, this.j);
        EnumC5091Hw enumC5091Hw = this.k;
        if (enumC5091Hw != null) {
            c19675ql0.f(11, enumC5091Hw.j());
        }
        c19675ql0.a(12, this.l);
        Long l = this.m;
        if (l != null) {
            c19675ql0.g(13, l.longValue());
        }
        Long l2 = this.n;
        if (l2 != null) {
            c19675ql0.g(14, l2.longValue());
        }
    }

    public String toString() {
        return "struct Call{}";
    }

    public C4857Gw() {
    }
}
