package ir.nasim;

/* renamed from: ir.nasim.fX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12997fX5 extends AbstractC10365bX5 {
    private C15811kD b;
    private C12638ex c;
    private String d;

    public static C12997fX5 s(byte[] bArr) {
        return (C12997fX5) AbstractC16720ll0.b(new C12997fX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C15811kD) c19084pl0.z(2, new C15811kD());
        this.c = (C12638ex) c19084pl0.z(3, new C12638ex());
        this.d = c19084pl0.A(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C15811kD c15811kD = this.b;
        if (c15811kD != null) {
            c19675ql0.i(2, c15811kD);
        }
        C12638ex c12638ex = this.c;
        if (c12638ex != null) {
            c19675ql0.i(3, c12638ex);
        }
        String str = this.d;
        if (str != null) {
            c19675ql0.o(4, str);
        }
    }

    public String toString() {
        return "response Auth{}";
    }
}
