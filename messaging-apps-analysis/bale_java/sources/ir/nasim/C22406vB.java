package ir.nasim;

/* renamed from: ir.nasim.vB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22406vB extends AbstractC17902nl0 {
    private long a;
    private String b;
    private EnumC23601xC c;
    private EnumC6993Pw d;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.A(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = EnumC23601xC.p(iH);
        }
        int iH2 = c19084pl0.h(4, 0);
        if (iH2 != 0) {
            this.d = EnumC6993Pw.p(iH2);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        EnumC23601xC enumC23601xC = this.c;
        if (enumC23601xC != null) {
            c19675ql0.f(3, enumC23601xC.j());
        }
        EnumC6993Pw enumC6993Pw = this.d;
        if (enumC6993Pw != null) {
            c19675ql0.f(4, enumC6993Pw.j());
        }
    }

    public String toString() {
        return "struct RecentCharge{}";
    }
}
