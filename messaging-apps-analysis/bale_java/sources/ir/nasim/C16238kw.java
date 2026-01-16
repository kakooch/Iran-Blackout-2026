package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.kw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16238kw extends AbstractC17902nl0 {
    private EnumC18602ow a;
    private C17420mw b;
    private long c;
    private String d;
    private String e;
    private EnumC18011nw f;
    private long g;
    private Long h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC18602ow.p(iH);
        }
        this.b = (C17420mw) c19084pl0.z(2, new C17420mw());
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.r(5);
        int iH2 = c19084pl0.h(6, 0);
        if (iH2 != 0) {
            this.f = EnumC18011nw.p(iH2);
        }
        this.g = c19084pl0.i(7);
        this.h = Long.valueOf(c19084pl0.y(8));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        EnumC18602ow enumC18602ow = this.a;
        if (enumC18602ow != null) {
            c19675ql0.f(1, enumC18602ow.j());
        }
        C17420mw c17420mw = this.b;
        if (c17420mw != null) {
            c19675ql0.i(2, c17420mw);
        }
        c19675ql0.g(3, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
        EnumC18011nw enumC18011nw = this.f;
        if (enumC18011nw != null) {
            c19675ql0.f(6, enumC18011nw.j());
        }
        c19675ql0.g(7, this.g);
        Long l = this.h;
        if (l != null) {
            c19675ql0.g(8, l.longValue());
        }
    }

    public String toString() {
        return "struct Bill{}";
    }
}
