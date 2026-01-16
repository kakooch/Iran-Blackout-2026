package ir.nasim;

/* renamed from: ir.nasim.Ie5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5169Ie5 extends AbstractC17902nl0 {
    private C11458d25 a;
    private long b;
    private long c;

    public C5169Ie5(C11458d25 c11458d25, long j, long j2) {
        this.a = c11458d25;
        this.b = j;
        this.c = j2;
    }

    public static C5169Ie5 s(byte[] bArr) {
        return (C5169Ie5) AbstractC16720ll0.b(new C5169Ie5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = C11458d25.r(c19084pl0.i(1));
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
    }

    public C5169Ie5 q(long j) {
        return new C5169Ie5(this.a, this.b, j);
    }

    public C5169Ie5 r(long j) {
        return new C5169Ie5(this.a, j, this.c);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a.u());
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
    }

    public C11458d25 u() {
        return this.a;
    }

    public long w() {
        return this.c;
    }

    public long y() {
        return this.b;
    }

    private C5169Ie5() {
    }
}
