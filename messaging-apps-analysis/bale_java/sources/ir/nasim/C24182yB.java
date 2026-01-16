package ir.nasim;

/* renamed from: ir.nasim.yB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24182yB extends AbstractC17902nl0 {
    private long a;
    private long b;
    private C23592xB c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = (C23592xB) c19084pl0.z(3, new C23592xB());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        C23592xB c23592xB = this.c;
        if (c23592xB != null) {
            c19675ql0.i(3, c23592xB);
        }
    }

    public String toString() {
        return "struct RepliesContainer{}";
    }
}
