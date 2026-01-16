package ir.nasim;

/* renamed from: ir.nasim.zy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C25238zy extends AbstractC10161bB {
    private int a;
    private long b;

    public C25238zy(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public long getAccessHash() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
    }

    public int q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
    }

    public String toString() {
        return "struct GroupOutPeer{}";
    }

    public C25238zy() {
    }
}
