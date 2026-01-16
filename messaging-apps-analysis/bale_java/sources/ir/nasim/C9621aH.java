package ir.nasim;

/* renamed from: ir.nasim.aH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
final /* synthetic */ class C9621aH implements QG4, InterfaceC22409vB2 {
    private final /* synthetic */ UA2 a;

    C9621aH(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "function");
        this.a = ua2;
    }

    @Override // ir.nasim.QG4
    public final /* synthetic */ void a(Object obj) {
        this.a.invoke(obj);
    }

    @Override // ir.nasim.InterfaceC22409vB2
    public final InterfaceC18751pB2 b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
            return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
