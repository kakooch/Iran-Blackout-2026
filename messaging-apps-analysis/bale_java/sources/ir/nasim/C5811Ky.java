package ir.nasim;

/* renamed from: ir.nasim.Ky, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5811Ky extends AbstractC17566nB {
    private long a;

    public C5811Ky(long j) {
        this.a = j;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
    }

    @Override // ir.nasim.AbstractC17566nB
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
    }

    public String toString() {
        return "struct Int64Value{}";
    }

    public long u() {
        return this.a;
    }

    public C5811Ky() {
    }
}
