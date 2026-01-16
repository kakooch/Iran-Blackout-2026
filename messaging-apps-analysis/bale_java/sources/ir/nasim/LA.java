package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class LA extends AbstractC17902nl0 {
    private int a;
    private long b;
    private String c;
    private MA d;
    private LA e;
    private String f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        int iH = c19084pl0.h(4, 0);
        if (iH != 0) {
            this.d = MA.p(iH);
        }
        this.e = (LA) c19084pl0.z(5, new LA());
        this.f = c19084pl0.A(6);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
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
        LA la = this.e;
        if (la != null) {
            c19675ql0.i(5, la);
        }
        String str2 = this.f;
        if (str2 != null) {
            c19675ql0.o(6, str2);
        }
    }

    public String toString() {
        return "struct PfmTransactionTag{}";
    }
}
