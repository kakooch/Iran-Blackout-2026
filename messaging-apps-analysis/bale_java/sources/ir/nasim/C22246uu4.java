package ir.nasim;

/* renamed from: ir.nasim.uu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22246uu4 extends AbstractC21707u0 implements D48 {
    private final InterfaceC4308Eo5 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22246uu4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "modules");
        Object objA = I22.a(C5721Ko.a.d(), InterfaceC13191fo5.class);
        AbstractC13042fc3.h(objA, "get(...)");
        this.b = ((InterfaceC13191fo5) objA).V0();
    }

    @Override // ir.nasim.D48
    public boolean d(AbstractC20556sC7 abstractC20556sC7, long j) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        long jP = AbstractC20507s76.p();
        if (abstractC20556sC7 instanceof C21869uG7) {
            this.b.j(((C21869uG7) abstractC20556sC7).a(), jP);
            return true;
        }
        if (abstractC20556sC7 instanceof C20592sG7) {
            this.b.e(((C20592sG7) abstractC20556sC7).a(), jP);
            return true;
        }
        if (abstractC20556sC7 instanceof C14657iG7) {
            this.b.d(r9.b(), ((C14657iG7) abstractC20556sC7).a() * 1000);
            return true;
        }
        if (!(abstractC20556sC7 instanceof C15846kG7)) {
            return false;
        }
        InterfaceC4308Eo5 interfaceC4308Eo5 = this.b;
        C15846kG7 c15846kG7 = (C15846kG7) abstractC20556sC7;
        long jB = c15846kG7.b();
        Long lA = c15846kG7.a();
        interfaceC4308Eo5.g(jB, (lA != null ? lA.longValue() : 1L) * 1000);
        return true;
    }
}
