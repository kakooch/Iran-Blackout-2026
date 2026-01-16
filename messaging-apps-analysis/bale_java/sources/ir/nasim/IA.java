package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class IA extends AbstractC17902nl0 {
    private long a;
    private long b;
    private String c;
    private MA d;
    private long e;
    private String f;
    private List g;
    private String h;
    private String i;
    private Long j;
    private KA k;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = MA.p(iH);
        }
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.A(6);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(7); i++) {
            arrayList.add(new LA());
        }
        this.g = c19084pl0.p(7, arrayList);
        this.h = c19084pl0.r(8);
        this.i = c19084pl0.A(9);
        this.j = Long.valueOf(c19084pl0.y(10));
        int iH2 = c19084pl0.h(11, 0);
        if (iH2 != 0) {
            this.k = KA.p(iH2);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        MA ma = this.d;
        if (ma != null) {
            c19675ql0.f(4, ma.j());
        }
        c19675ql0.g(5, this.e);
        String str2 = this.f;
        if (str2 != null) {
            c19675ql0.o(6, str2);
        }
        c19675ql0.m(7, this.g);
        String str3 = this.h;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(8, str3);
        String str4 = this.i;
        if (str4 != null) {
            c19675ql0.o(9, str4);
        }
        Long l = this.j;
        if (l != null) {
            c19675ql0.g(10, l.longValue());
        }
        KA ka = this.k;
        if (ka != null) {
            c19675ql0.f(11, ka.j());
        }
    }

    public String toString() {
        return "struct PfmTransaction{}";
    }
}
