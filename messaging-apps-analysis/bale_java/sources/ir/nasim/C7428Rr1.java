package ir.nasim;

/* renamed from: ir.nasim.Rr1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C7428Rr1 extends AbstractC15795kB1 {
    private final AbstractC16142km3 a;

    public C7428Rr1(AbstractC16142km3 abstractC16142km3) {
        AbstractC13042fc3.i(abstractC16142km3, "container");
        this.a = abstractC16142km3;
    }

    @Override // ir.nasim.AbstractC15795kB1, ir.nasim.InterfaceC15204jB1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC10536bm3 b(AB2 ab2, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(ab2, "descriptor");
        AbstractC13042fc3.i(c19938rB7, "data");
        return new C17324mm3(this.a, ab2);
    }

    @Override // ir.nasim.InterfaceC15204jB1
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public AbstractC10536bm3 f(InterfaceC20989sw5 interfaceC20989sw5, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
        AbstractC13042fc3.i(c19938rB7, "data");
        int i = (interfaceC20989sw5.N() != null ? 1 : 0) + (interfaceC20989sw5.Q() != null ? 1 : 0);
        if (interfaceC20989sw5.P()) {
            if (i == 0) {
                return new C21575tm3(this.a, interfaceC20989sw5);
            }
            if (i == 1) {
                return new C22755vm3(this.a, interfaceC20989sw5);
            }
            if (i == 2) {
                return new C23941xm3(this.a, interfaceC20989sw5);
            }
        } else {
            if (i == 0) {
                return new C4054Dm3(this.a, interfaceC20989sw5);
            }
            if (i == 1) {
                return new C4522Fm3(this.a, interfaceC20989sw5);
            }
            if (i == 2) {
                return new C5005Hm3(this.a, interfaceC20989sw5);
            }
        }
        throw new C25175zr3("Unsupported property: " + interfaceC20989sw5);
    }
}
