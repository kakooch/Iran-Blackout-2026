package ir.nasim;

/* renamed from: ir.nasim.tZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21381tZ5 extends AbstractC10365bX5 {
    private EnumC21160tD b;

    public static C21381tZ5 s(byte[] bArr) {
        return (C21381tZ5) AbstractC16720ll0.b(new C21381tZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.b = EnumC21160tD.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC21160tD enumC21160tD = this.b;
        if (enumC21160tD != null) {
            c19675ql0.f(1, enumC21160tD.j());
        }
    }

    public String toString() {
        return "response GetUserStatus{}";
    }
}
