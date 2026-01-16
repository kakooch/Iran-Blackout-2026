package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.cw3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11399cw3 extends AbstractC10678c1 {
    private final C9182Yv3 k;
    private final InterfaceC7583Si3 l;
    private final C7466Rv3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11399cw3(C9182Yv3 c9182Yv3, InterfaceC7583Si3 interfaceC7583Si3, int i, InterfaceC12795fB1 interfaceC12795fB1) {
        super(c9182Yv3.e(), interfaceC12795fB1, interfaceC7583Si3.getName(), KQ7.INVARIANT, false, i, JH6.a, c9182Yv3.a().u());
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC7583Si3, "javaTypeParameter");
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        this.k = c9182Yv3;
        this.l = interfaceC7583Si3;
        this.m = new C7466Rv3(c9182Yv3, interfaceC7583Si3, false, 4, null);
    }

    private final List L0() {
        Collection upperBounds = this.l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            XC6 xc6I = this.k.d().n().i();
            AbstractC13042fc3.h(xc6I, "c.module.builtIns.anyType");
            XC6 xc6I2 = this.k.d().n().I();
            AbstractC13042fc3.h(xc6I2, "c.module.builtIns.nullableAnyType");
            return AbstractC9766aX0.e(C4567Fr3.d(xc6I, xc6I2));
        }
        Collection collection = upperBounds;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.k.g().n((InterfaceC9056Yh3) it.next(), AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC13322g2
    protected List I0(List list) {
        AbstractC13042fc3.i(list, "bounds");
        return this.k.a().q().g(this, list, this.k);
    }

    @Override // ir.nasim.AbstractC13322g2
    protected void J0(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
    }

    @Override // ir.nasim.AbstractC13322g2
    protected List K0() {
        return L0();
    }

    @Override // ir.nasim.AbstractC11996du, ir.nasim.InterfaceC10612bu
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public C7466Rv3 getAnnotations() {
        return this.m;
    }
}
