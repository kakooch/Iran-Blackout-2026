package ir.nasim;

/* renamed from: ir.nasim.be1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C10454be1 implements InterfaceC15631ju3 {
    private final C7773Td1 a;
    private final UA2 b;
    private final Object c;

    public C10454be1(C7773Td1 c7773Td1, UA2 ua2) {
        AbstractC13042fc3.i(c7773Td1, "ref");
        AbstractC13042fc3.i(ua2, "constrain");
        this.a = c7773Td1;
        this.b = ua2;
        this.c = c7773Td1.c();
    }

    @Override // ir.nasim.InterfaceC15631ju3
    public Object Y0() {
        return this.c;
    }

    public final UA2 a() {
        return this.b;
    }

    public final C7773Td1 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C10454be1) {
            C10454be1 c10454be1 = (C10454be1) obj;
            if (AbstractC13042fc3.d(this.a.c(), c10454be1.a.c()) && AbstractC13042fc3.d(this.b, c10454be1.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a.c().hashCode() * 31) + this.b.hashCode();
    }
}
