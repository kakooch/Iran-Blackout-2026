package ir.nasim;

import ir.nasim.AbstractC24247yI1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.e07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C12083e07 extends X24 {
    private final InterfaceC8507Wg4 b;
    private final C9424Zw2 c;

    public C12083e07(InterfaceC8507Wg4 interfaceC8507Wg4, C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        this.b = interfaceC8507Wg4;
        this.c = c9424Zw2;
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        if (!c24841zI1.a(C24841zI1.c.g())) {
            return AbstractC10360bX0.m();
        }
        if (this.c.d() && c24841zI1.n().contains(AbstractC24247yI1.b.a)) {
            return AbstractC10360bX0.m();
        }
        Collection collectionL = this.b.l(this.c, ua2);
        ArrayList arrayList = new ArrayList(collectionL.size());
        Iterator it = collectionL.iterator();
        while (it.hasNext()) {
            C6432No4 c6432No4G = ((C9424Zw2) it.next()).g();
            AbstractC13042fc3.h(c6432No4G, "subFqName.shortName()");
            if (((Boolean) ua2.invoke(c6432No4G)).booleanValue()) {
                YW0.a(arrayList, h(c6432No4G));
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set g() {
        return AbstractC4597Fu6.d();
    }

    protected final OS4 h(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        if (c6432No4.q()) {
            return null;
        }
        InterfaceC8507Wg4 interfaceC8507Wg4 = this.b;
        C9424Zw2 c9424Zw2C = this.c.c(c6432No4);
        AbstractC13042fc3.h(c9424Zw2C, "fqName.child(name)");
        OS4 os4Z0 = interfaceC8507Wg4.z0(c9424Zw2C);
        if (os4Z0.isEmpty()) {
            return null;
        }
        return os4Z0;
    }
}
