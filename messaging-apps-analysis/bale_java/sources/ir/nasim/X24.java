package ir.nasim;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class X24 implements W24 {
    @Override // ir.nasim.W24
    public Set a() {
        Collection collectionF = f(C24841zI1.v, IB2.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionF) {
            if (obj instanceof JC6) {
                C6432No4 name = ((JC6) obj).getName();
                AbstractC13042fc3.h(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.W24
    public Set c() {
        Collection collectionF = f(C24841zI1.w, IB2.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionF) {
            if (obj instanceof JC6) {
                C6432No4 name = ((JC6) obj).getName();
                AbstractC13042fc3.h(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return null;
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.W24
    public Set g() {
        return null;
    }
}
