package ir.nasim;

/* renamed from: ir.nasim.Dh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4011Dh5 extends AbstractC17902nl0 {
    private int a;
    private int b;

    public C4011Dh5(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4011Dh5)) {
            return false;
        }
        C4011Dh5 c4011Dh5 = (C4011Dh5) obj;
        return this.a == c4011Dh5.a && this.b == c4011Dh5.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.g(2);
        this.b = c19084pl0.g(3);
    }

    public final int q() {
        return this.a;
    }

    public final int r() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.f(2, this.a);
        c19675ql0.f(3, this.b);
    }

    public C4011Dh5() {
        this(0, 0);
    }
}
