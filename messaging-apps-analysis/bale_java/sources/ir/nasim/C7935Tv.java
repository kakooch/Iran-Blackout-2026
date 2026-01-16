package ir.nasim;

/* renamed from: ir.nasim.Tv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7935Tv extends AbstractC25211zv {
    private long a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
    }

    @Override // ir.nasim.AbstractC25211zv
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
    }

    public String toString() {
        return "struct BaleAd{}";
    }
}
