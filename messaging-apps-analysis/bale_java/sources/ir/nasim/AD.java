package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class AD extends AbstractC17902nl0 {
    private BD a;
    private String b;
    private String c;
    private String d;
    private Long e;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = BD.p(iH);
        }
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.A(3);
        this.d = c19084pl0.A(4);
        this.e = Long.valueOf(c19084pl0.y(5));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        BD bd = this.a;
        if (bd != null) {
            c19675ql0.f(1, bd.j());
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
        String str3 = this.d;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(5, l.longValue());
        }
    }

    public String toString() {
        return "struct WheelPrize{}";
    }
}
