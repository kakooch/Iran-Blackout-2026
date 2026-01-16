package ir.nasim;

/* loaded from: classes4.dex */
public class CC extends AbstractC17902nl0 {
    private long a;
    private C6035Lx b;

    public CC(long j, C6035Lx c6035Lx) {
        this.a = j;
        this.b = c6035Lx;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = (C6035Lx) c19084pl0.z(2, new C6035Lx());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        C6035Lx c6035Lx = this.b;
        if (c6035Lx != null) {
            c19675ql0.i(2, c6035Lx);
        }
    }

    public String toString() {
        return "struct SingleMedia{}";
    }

    public CC() {
    }
}
