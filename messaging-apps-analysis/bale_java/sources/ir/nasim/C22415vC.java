package ir.nasim;

/* renamed from: ir.nasim.vC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22415vC extends VB {
    private int a;

    public C22415vC(int i) {
        this.a = i;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
    }

    @Override // ir.nasim.VB
    public int s() {
        return 3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
    }

    public String toString() {
        return "struct ServiceExUserLeft{}";
    }

    public int u() {
        return this.a;
    }

    public C22415vC() {
    }
}
