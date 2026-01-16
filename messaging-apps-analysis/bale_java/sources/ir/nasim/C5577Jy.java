package ir.nasim;

/* renamed from: ir.nasim.Jy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5577Jy extends AbstractC17566nB {
    private int a;

    public C5577Jy(int i) {
        this.a = i;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
    }

    @Override // ir.nasim.AbstractC17566nB
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
    }

    public String toString() {
        return "struct Int32Value{}";
    }

    public int u() {
        return this.a;
    }

    public C5577Jy() {
    }
}
