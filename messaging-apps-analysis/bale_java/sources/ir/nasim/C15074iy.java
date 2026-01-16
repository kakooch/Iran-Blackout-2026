package ir.nasim;

/* renamed from: ir.nasim.iy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15074iy extends AbstractC18620oy {
    private boolean a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
    }

    @Override // ir.nasim.AbstractC18620oy
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
    }

    public String toString() {
        return "struct FilterOwner{}";
    }
}
