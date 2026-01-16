package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Bx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3681Bx extends AbstractC17902nl0 {
    private C22993wA a;
    private int b;
    private long c;
    private C7714Sx d;
    private Long e;
    private Boolean f;

    public C3681Bx(C22993wA c22993wA, int i, long j, C7714Sx c7714Sx, Long l, Boolean bool) {
        this.a = c22993wA;
        this.b = i;
        this.c = j;
        this.d = c7714Sx;
        this.e = l;
        this.f = bool;
    }

    public long h() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.k(1, new C22993wA());
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(4);
        this.d = (C7714Sx) c19084pl0.z(5, new C7714Sx());
        this.e = Long.valueOf(c19084pl0.y(6));
        this.f = Boolean.valueOf(c19084pl0.u(7));
    }

    public int q() {
        return this.b;
    }

    public C7714Sx r() {
        return this.d;
    }

    public Long s() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C22993wA c22993wA = this.a;
        if (c22993wA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c22993wA);
        c19675ql0.f(2, this.b);
        c19675ql0.g(4, this.c);
        C7714Sx c7714Sx = this.d;
        if (c7714Sx != null) {
            c19675ql0.i(5, c7714Sx);
        }
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
        Boolean bool = this.f;
        if (bool != null) {
            c19675ql0.a(7, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct DialogShort{}";
    }

    public C22993wA u() {
        return this.a;
    }

    public Boolean w() {
        return this.f;
    }

    public C3681Bx() {
    }
}
