package ir.nasim;

/* renamed from: ir.nasim.nA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17557nA extends AbstractC17902nl0 {
    private CA a;
    private int b;
    private long c;

    public C17557nA(CA ca, int i, long j) {
        this.a = ca;
        this.b = i;
        this.c = j;
    }

    public long getAccessHash() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = CA.p(iH);
        }
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(3);
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
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "struct OutPeer{}";
    }

    public C17557nA() {
    }
}
