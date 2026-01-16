package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class PB extends HB {
    private OB a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = OB.p(c19084pl0.g(1));
    }

    @Override // ir.nasim.HB
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        OB ob = this.a;
        if (ob == null) {
            throw new IOException();
        }
        c19675ql0.f(1, ob.j());
    }

    public String toString() {
        return "struct SearchPeerTypeCondition{}";
    }
}
