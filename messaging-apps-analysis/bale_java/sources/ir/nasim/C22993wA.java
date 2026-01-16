package ir.nasim;

/* renamed from: ir.nasim.wA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22993wA extends AbstractC17902nl0 {
    private CA a;
    private int b;

    public C22993wA(CA ca, int i) {
        this.a = ca;
        this.b = i;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = CA.p(iH);
        }
        this.b = c19084pl0.g(2);
    }

    public int q() {
        return this.b;
    }

    public CA r() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        CA ca = this.a;
        if (ca != null) {
            c19675ql0.f(1, ca.j());
        }
        c19675ql0.f(2, this.b);
    }

    public String toString() {
        return "struct Peer{}";
    }

    public C22993wA() {
    }
}
