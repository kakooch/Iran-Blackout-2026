package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class VA extends AbstractC17902nl0 {
    private long a;
    private int b;
    private String c;
    private long d;
    private UA e;
    private String f;
    private String g;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.i(4);
        int iH = c19084pl0.h(5, 0);
        if (iH != 0) {
            this.e = UA.p(iH);
        }
        this.f = c19084pl0.A(6);
        this.g = c19084pl0.A(7);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        c19675ql0.g(4, this.d);
        UA ua = this.e;
        if (ua != null) {
            c19675ql0.f(5, ua.j());
        }
        String str2 = this.f;
        if (str2 != null) {
            c19675ql0.o(6, str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            c19675ql0.o(7, str3);
        }
    }

    public String toString() {
        return "struct PointDetailsInfo{}";
    }
}
