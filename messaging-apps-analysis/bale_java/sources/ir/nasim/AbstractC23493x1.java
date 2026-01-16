package ir.nasim;

import ir.nasim.InterfaceC19877r55;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: ir.nasim.x1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23493x1 extends AbstractC11442d1 implements InterfaceC19877r55 {
    @Override // java.util.Collection, java.util.List, ir.nasim.InterfaceC19877r55
    public InterfaceC19877r55 addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        if (collection.isEmpty()) {
            return this;
        }
        InterfaceC19877r55.a aVarM = m();
        aVarM.addAll(collection);
        return aVarM.a();
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean containsAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC13346g43 subList(int i, int i2) {
        return InterfaceC19877r55.b.a(this, i, i2);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }
}
