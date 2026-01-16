package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.wx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23455wx extends AbstractC17902nl0 {
    private C22993wA a;
    private int b;
    private long c;
    private int d;
    private long e;
    private long f;
    private AbstractC24063xz g;
    private EnumC4884Gz h;
    private Long i;
    private C24653yz j;
    private C7714Sx k;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.k(1, new C22993wA());
        this.b = c19084pl0.g(3);
        this.c = c19084pl0.i(4);
        this.d = c19084pl0.g(5);
        this.e = c19084pl0.i(6);
        this.f = c19084pl0.i(7);
        this.g = AbstractC24063xz.r(c19084pl0.d(8));
        int iH = c19084pl0.h(9, 0);
        if (iH != 0) {
            this.h = EnumC4884Gz.p(iH);
        }
        this.i = Long.valueOf(c19084pl0.y(10));
        this.j = (C24653yz) c19084pl0.z(11, new C24653yz());
        this.k = (C7714Sx) c19084pl0.z(14, new C7714Sx());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C22993wA c22993wA = this.a;
        if (c22993wA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c22993wA);
        c19675ql0.f(3, this.b);
        c19675ql0.g(4, this.c);
        c19675ql0.f(5, this.d);
        c19675ql0.g(6, this.e);
        c19675ql0.g(7, this.f);
        AbstractC24063xz abstractC24063xz = this.g;
        if (abstractC24063xz == null) {
            throw new IOException();
        }
        c19675ql0.b(8, abstractC24063xz.q());
        EnumC4884Gz enumC4884Gz = this.h;
        if (enumC4884Gz != null) {
            c19675ql0.f(9, enumC4884Gz.j());
        }
        Long l = this.i;
        if (l != null) {
            c19675ql0.g(10, l.longValue());
        }
        C24653yz c24653yz = this.j;
        if (c24653yz != null) {
            c19675ql0.i(11, c24653yz);
        }
        C7714Sx c7714Sx = this.k;
        if (c7714Sx != null) {
            c19675ql0.i(14, c7714Sx);
        }
    }

    public String toString() {
        return "struct Dialog{}";
    }
}
