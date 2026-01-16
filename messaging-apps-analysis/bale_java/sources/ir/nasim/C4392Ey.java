package ir.nasim;

/* renamed from: ir.nasim.Ey, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4392Ey extends AbstractC17902nl0 {
    private C17557nA a;
    private long b;
    private long c;

    public C4392Ey(C17557nA c17557nA, long j, long j2) {
        this.a = c17557nA;
        this.b = j;
        this.c = j2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.z(1, new C17557nA());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17557nA c17557nA = this.a;
        if (c17557nA != null) {
            c19675ql0.i(1, c17557nA);
        }
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "struct HistoryMessageIdentifier{}";
    }

    public C4392Ey() {
    }
}
