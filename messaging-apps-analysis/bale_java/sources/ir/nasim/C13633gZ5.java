package ir.nasim;

/* renamed from: ir.nasim.gZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13633gZ5 extends AbstractC10365bX5 {
    private EnumC23020wD b;
    private FB c;

    public static C13633gZ5 s(byte[] bArr) {
        return (C13633gZ5) AbstractC16720ll0.b(new C13633gZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.b = EnumC23020wD.p(iH);
        }
        this.c = (FB) c19084pl0.z(2, new FB());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC23020wD enumC23020wD = this.b;
        if (enumC23020wD != null) {
            c19675ql0.f(1, enumC23020wD.j());
        }
        FB fb = this.c;
        if (fb != null) {
            c19675ql0.i(2, fb);
        }
    }

    public String toString() {
        return "response GetScoreBoard{}";
    }
}
