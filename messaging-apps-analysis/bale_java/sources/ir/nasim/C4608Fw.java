package ir.nasim;

/* renamed from: ir.nasim.Fw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4608Fw extends AbstractC17902nl0 {
    private long a;
    private long b;
    private OC c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = (OC) c19084pl0.z(3, new OC());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        OC oc = this.c;
        if (oc != null) {
            c19675ql0.i(3, oc);
        }
    }

    public String toString() {
        return "struct BuyInternetBundleReceipt{}";
    }
}
