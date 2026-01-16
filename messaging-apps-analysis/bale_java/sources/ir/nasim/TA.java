package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class TA extends AbstractC17902nl0 {
    private long a;
    private long b;
    private long c;
    private long d;
    private int e;
    private String f;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.i(4);
        this.e = c19084pl0.g(5);
        this.f = c19084pl0.r(6);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        c19675ql0.g(4, this.d);
        c19675ql0.f(5, this.e);
        String str = this.f;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(6, str);
    }

    public String toString() {
        return "struct PointBalanceInfo{}";
    }
}
