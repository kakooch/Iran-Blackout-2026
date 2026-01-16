package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class AA extends AbstractC17902nl0 {
    private C22993wA a;
    private String b;
    private String c;
    private Integer d;
    private Long e;
    private Integer f;
    private Boolean g;
    private Boolean h;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C22993wA) c19084pl0.z(1, new C22993wA());
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.A(3);
        this.d = Integer.valueOf(c19084pl0.x(4));
        this.e = Long.valueOf(c19084pl0.y(5));
        this.f = Integer.valueOf(c19084pl0.x(6));
        this.g = Boolean.valueOf(c19084pl0.u(7));
        this.h = Boolean.valueOf(c19084pl0.u(8));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C22993wA c22993wA = this.a;
        if (c22993wA != null) {
            c19675ql0.i(1, c22993wA);
        }
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.c;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
        Integer num = this.d;
        if (num != null) {
            c19675ql0.f(4, num.intValue());
        }
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(5, l.longValue());
        }
        Integer num2 = this.f;
        if (num2 != null) {
            c19675ql0.f(6, num2.intValue());
        }
        Boolean bool = this.g;
        if (bool != null) {
            c19675ql0.a(7, bool.booleanValue());
        }
        Boolean bool2 = this.h;
        if (bool2 != null) {
            c19675ql0.a(8, bool2.booleanValue());
        }
    }

    public String toString() {
        return "struct PeerSearchResult{}";
    }
}
