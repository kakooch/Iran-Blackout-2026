package ir.nasim;

/* loaded from: classes4.dex */
public class EA extends AbstractC17902nl0 {
    private Long a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Long.valueOf(c19084pl0.y(1));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Long l = this.a;
        if (l != null) {
            c19675ql0.g(1, l.longValue());
        }
    }

    public String toString() {
        return "struct PfmConfig{}";
    }
}
