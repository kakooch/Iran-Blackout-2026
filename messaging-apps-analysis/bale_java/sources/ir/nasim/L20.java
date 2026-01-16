package ir.nasim;

/* loaded from: classes3.dex */
final /* synthetic */ class L20 implements CI4, InterfaceC22409vB2 {
    private final /* synthetic */ SA2 a;

    L20(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "function");
        this.a = sa2;
    }

    @Override // ir.nasim.CI4
    public final /* synthetic */ void a() {
        this.a.invoke();
    }

    @Override // ir.nasim.InterfaceC22409vB2
    public final InterfaceC18751pB2 b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof CI4) && (obj instanceof InterfaceC22409vB2)) {
            return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
