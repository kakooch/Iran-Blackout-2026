package ir.nasim;

/* renamed from: ir.nasim.qw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19784qw extends AbstractC17566nB {
    private boolean a;

    public C19784qw(boolean z) {
        this.a = z;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
    }

    @Override // ir.nasim.AbstractC17566nB
    public int s() {
        return 7;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
    }

    public String toString() {
        return "struct BooleanValue{}";
    }

    public boolean u() {
        return this.a;
    }

    public C19784qw() {
    }
}
