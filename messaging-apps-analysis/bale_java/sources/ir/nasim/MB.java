package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class MB extends HB {
    private C17557nA a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.k(1, new C17557nA());
    }

    @Override // ir.nasim.HB
    public int s() {
        return 5;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c17557nA);
    }

    public String toString() {
        return "struct SearchPeerCondition{}";
    }
}
