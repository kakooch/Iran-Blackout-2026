package ir.nasim;

import ir.nasim.C10938cS7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.kJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C15867kJ1 extends AbstractC14076hJ1 {
    private final InterfaceC24340yS4 g;
    private final C9424Zw2 h;

    public C15867kJ1(InterfaceC24340yS4 interfaceC24340yS4, C8652Ww5 c8652Ww5, InterfaceC6692Oo4 interfaceC6692Oo4, AbstractC7310Re0 abstractC7310Re0, InterfaceC12258eJ1 interfaceC12258eJ1, TI1 ti1, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC24340yS4, "packageDescriptor");
        AbstractC13042fc3.i(c8652Ww5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        AbstractC13042fc3.i(ti1, "components");
        AbstractC13042fc3.i(sa2, "classNames");
        C12644ex5 c12644ex5Z = c8652Ww5.Z();
        AbstractC13042fc3.h(c12644ex5Z, "proto.typeTable");
        C7029Py7 c7029Py7 = new C7029Py7(c12644ex5Z);
        C10938cS7.a aVar = C10938cS7.b;
        C14464hx5 c14464hx5A0 = c8652Ww5.a0();
        AbstractC13042fc3.h(c14464hx5A0, "proto.versionRequirementTable");
        WI1 wi1A = ti1.a(interfaceC24340yS4, interfaceC6692Oo4, c7029Py7, aVar.a(c14464hx5A0), abstractC7310Re0, interfaceC12258eJ1);
        List listS = c8652Ww5.S();
        AbstractC13042fc3.h(listS, "proto.functionList");
        List listV = c8652Ww5.V();
        AbstractC13042fc3.h(listV, "proto.propertyList");
        List listY = c8652Ww5.Y();
        AbstractC13042fc3.h(listY, "proto.typeAliasList");
        super(wi1A, listS, listV, listY, sa2);
        this.g = interfaceC24340yS4;
        this.h = interfaceC24340yS4.e();
    }

    public void A(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        AbstractC21932uN7.b(q().c().o(), ij3, this.g, c6432No4);
    }

    @Override // ir.nasim.AbstractC14076hJ1, ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        A(c6432No4, ij3);
        return super.e(c6432No4, ij3);
    }

    @Override // ir.nasim.AbstractC14076hJ1
    protected void j(Collection collection, UA2 ua2) {
        AbstractC13042fc3.i(collection, "result");
        AbstractC13042fc3.i(ua2, "nameFilter");
    }

    @Override // ir.nasim.AbstractC14076hJ1
    protected C24948zU0 n(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return new C24948zU0(this.h, c6432No4);
    }

    @Override // ir.nasim.AbstractC14076hJ1
    protected Set t() {
        return AbstractC4597Fu6.d();
    }

    @Override // ir.nasim.AbstractC14076hJ1
    protected Set u() {
        return AbstractC4597Fu6.d();
    }

    @Override // ir.nasim.AbstractC14076hJ1
    protected Set v() {
        return AbstractC4597Fu6.d();
    }

    @Override // ir.nasim.AbstractC14076hJ1
    protected boolean x(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        if (!super.x(c6432No4)) {
            Iterable iterableK = q().c().k();
            if (!(iterableK instanceof Collection) || !((Collection) iterableK).isEmpty()) {
                Iterator it = iterableK.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC22578vU0) it.next()).b(this.h, c6432No4)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public List f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        Collection collectionK = k(c24841zI1, ua2, FA4.WHEN_GET_ALL_DESCRIPTORS);
        Iterable iterableK = q().c().k();
        ArrayList arrayList = new ArrayList();
        Iterator it = iterableK.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((InterfaceC22578vU0) it.next()).c(this.h));
        }
        return AbstractC15401jX0.R0(collectionK, arrayList);
    }
}
