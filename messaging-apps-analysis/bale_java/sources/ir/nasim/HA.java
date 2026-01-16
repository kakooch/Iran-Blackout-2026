package ir.nasim;

/* loaded from: classes4.dex */
public class HA extends AbstractC17902nl0 {
    private GA a;
    private Long b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (GA) c19084pl0.z(1, new GA());
        this.b = Long.valueOf(c19084pl0.y(2));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        GA ga = this.a;
        if (ga != null) {
            c19675ql0.i(1, ga);
        }
        Long l = this.b;
        if (l != null) {
            c19675ql0.g(2, l.longValue());
        }
    }

    public String toString() {
        return "struct PfmTotalAmountsPerDay{}";
    }
}
