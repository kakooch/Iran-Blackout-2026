package ir.nasim;

/* renamed from: ir.nasim.Nx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6529Nx extends AbstractC17566nB {
    private double a;

    public C6529Nx(double d) {
        this.a = d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.f(1);
    }

    @Override // ir.nasim.AbstractC17566nB
    public int s() {
        return 4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.e(1, this.a);
    }

    public String toString() {
        return "struct DoubleValue{}";
    }

    public C6529Nx() {
    }
}
