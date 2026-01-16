package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class GA extends AbstractC17902nl0 {
    private MA a;
    private LA b;
    private String c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = MA.p(iH);
        }
        this.b = (LA) c19084pl0.z(2, new LA());
        this.c = c19084pl0.r(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        MA ma = this.a;
        if (ma != null) {
            c19675ql0.f(1, ma.j());
        }
        LA la = this.b;
        if (la != null) {
            c19675ql0.i(2, la);
        }
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
    }

    public String toString() {
        return "struct PfmTotalAmount{}";
    }
}
