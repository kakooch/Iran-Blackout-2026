package ir.nasim;

/* renamed from: ir.nasim.qD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19357qD extends AbstractC17902nl0 {
    private int a;
    private long b;
    private long c;

    public long h() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
    }

    public long q() {
        return this.b;
    }

    public int r() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "struct UserPayment{}";
    }
}
