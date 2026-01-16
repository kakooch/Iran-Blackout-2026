package ir.nasim;

/* renamed from: ir.nasim.fW, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12982fW extends AbstractC22106ug4 {
    private InterfaceC23882xg4 a;

    public C12982fW(InterfaceC23882xg4 interfaceC23882xg4) {
        super(null);
        this.a = interfaceC23882xg4;
    }

    @Override // ir.nasim.AbstractC22106ug4
    public boolean a(AbstractC19629qg4 abstractC19629qg4) {
        return abstractC19629qg4 == this.a.getKey();
    }

    @Override // ir.nasim.AbstractC22106ug4
    public Object b(AbstractC19629qg4 abstractC19629qg4) {
        if (!(abstractC19629qg4 == this.a.getKey())) {
            M73.b("Check failed.");
        }
        return this.a.getValue();
    }

    public final void c(InterfaceC23882xg4 interfaceC23882xg4) {
        this.a = interfaceC23882xg4;
    }
}
