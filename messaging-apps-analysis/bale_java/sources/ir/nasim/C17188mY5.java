package ir.nasim;

/* renamed from: ir.nasim.mY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17188mY5 extends AbstractC10365bX5 {
    private C17447mz b;

    public static C17188mY5 s(byte[] bArr) {
        return (C17188mY5) AbstractC16720ll0.b(new C17188mY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C17447mz) c19084pl0.z(1, new C17447mz());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C17447mz c17447mz = this.b;
        if (c17447mz != null) {
            c19675ql0.i(1, c17447mz);
        }
    }

    public String toString() {
        return "response GetLoanInfo{}";
    }
}
