package ir.nasim;

/* loaded from: classes4.dex */
public abstract class Ab8 extends AbstractC25020zb8 {
    private final int a;
    private AbstractC17902nl0 b;

    protected Ab8(int i, int i2, AbstractC17902nl0 abstractC17902nl0, AbstractC17902nl0 abstractC17902nl02) {
        super(i);
        this.a = i2;
        this.b = abstractC17902nl02;
        setWrapped(abstractC17902nl0);
    }

    @Override // ir.nasim.AbstractC25020zb8
    protected void applyWrapped(AbstractC17902nl0 abstractC17902nl0) {
        q(abstractC17902nl0, this.b);
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        byte[] bArrV = c19084pl0.v(this.a);
        if (bArrV != null) {
            this.b = AbstractC16720ll0.b(r(), bArrV);
        }
        super.parse(c19084pl0);
    }

    protected abstract void q(AbstractC17902nl0 abstractC17902nl0, AbstractC17902nl0 abstractC17902nl02);

    protected abstract AbstractC17902nl0 r();

    protected AbstractC17902nl0 s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC17902nl0 abstractC17902nl0 = this.b;
        if (abstractC17902nl0 != null) {
            c19675ql0.i(this.a, abstractC17902nl0);
        }
        super.serialize(c19675ql0);
    }

    protected Ab8(int i, int i2) {
        super(i);
        this.a = i2;
    }
}
