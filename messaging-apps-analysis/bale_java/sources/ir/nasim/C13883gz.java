package ir.nasim;

/* renamed from: ir.nasim.gz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13883gz extends AbstractC17902nl0 {
    private EnumC14476hz a;
    private C9558aA b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC14476hz.p(iH);
        }
        this.b = (C9558aA) c19084pl0.z(2, new C9558aA());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC14476hz enumC14476hz = this.a;
        if (enumC14476hz != null) {
            c19675ql0.f(1, enumC14476hz.j());
        }
        C9558aA c9558aA = this.b;
        if (c9558aA != null) {
            c19675ql0.i(2, c9558aA);
        }
    }

    public String toString() {
        return "struct LinkPreview{}";
    }
}
