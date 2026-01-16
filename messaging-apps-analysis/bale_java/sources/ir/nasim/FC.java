package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class FC extends AbstractC17902nl0 {
    private String a;
    private int b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.g(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.b);
    }

    public String toString() {
        return "struct StateInfo{}";
    }
}
