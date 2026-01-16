package ir.nasim;

/* renamed from: ir.nasim.ve1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22673ve1 implements InterfaceC20236rg4 {
    private final UA2 b;
    private A98 c;

    public C22673ve1(UA2 ua2) {
        this.b = ua2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22673ve1) && ((C22673ve1) obj).b == this.b;
    }

    @Override // ir.nasim.InterfaceC20236rg4
    public void g(InterfaceC24472yg4 interfaceC24472yg4) {
        A98 a98 = (A98) interfaceC24472yg4.t(AbstractC22050ua8.a());
        if (AbstractC13042fc3.d(a98, this.c)) {
            return;
        }
        this.c = a98;
        this.b.invoke(a98);
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
