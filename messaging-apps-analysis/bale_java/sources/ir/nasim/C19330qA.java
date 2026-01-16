package ir.nasim;

/* renamed from: ir.nasim.qA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19330qA extends AbstractC17902nl0 {
    private Boolean a;
    private AbstractC7944Tw b;
    private AbstractC7944Tw c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Boolean.valueOf(c19084pl0.u(1));
        if (c19084pl0.v(2) != null) {
            this.b = AbstractC7944Tw.r(c19084pl0.d(2));
        }
        if (c19084pl0.v(3) != null) {
            this.c = AbstractC7944Tw.r(c19084pl0.d(3));
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Boolean bool = this.a;
        if (bool != null) {
            c19675ql0.a(1, bool.booleanValue());
        }
        AbstractC7944Tw abstractC7944Tw = this.b;
        if (abstractC7944Tw != null) {
            c19675ql0.b(2, abstractC7944Tw.q());
        }
        AbstractC7944Tw abstractC7944Tw2 = this.c;
        if (abstractC7944Tw2 != null) {
            c19675ql0.b(3, abstractC7944Tw2.q());
        }
    }

    public String toString() {
        return "struct ParagraphStyle{}";
    }
}
