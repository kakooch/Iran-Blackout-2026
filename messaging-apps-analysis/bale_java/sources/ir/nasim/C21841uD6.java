package ir.nasim;

/* renamed from: ir.nasim.uD6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21841uD6 extends AbstractC22106ug4 {
    private final AbstractC19629qg4 a;
    private final InterfaceC9102Ym4 b;

    public C21841uD6(AbstractC19629qg4 abstractC19629qg4) {
        super(null);
        this.a = abstractC19629qg4;
        this.b = AbstractC13472gH6.d(null, null, 2, null);
    }

    private final Object c() {
        return this.b.getValue();
    }

    private final void e(Object obj) {
        this.b.setValue(obj);
    }

    @Override // ir.nasim.AbstractC22106ug4
    public boolean a(AbstractC19629qg4 abstractC19629qg4) {
        return abstractC19629qg4 == this.a;
    }

    @Override // ir.nasim.AbstractC22106ug4
    public Object b(AbstractC19629qg4 abstractC19629qg4) {
        if (!(abstractC19629qg4 == this.a)) {
            M73.b("Check failed.");
        }
        Object objC = c();
        if (objC == null) {
            return null;
        }
        return objC;
    }

    public void d(AbstractC19629qg4 abstractC19629qg4, Object obj) {
        if (!(abstractC19629qg4 == this.a)) {
            M73.b("Check failed.");
        }
        e(obj);
    }
}
