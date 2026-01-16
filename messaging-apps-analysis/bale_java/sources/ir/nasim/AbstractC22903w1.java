package ir.nasim;

import ir.nasim.InterfaceC19286q55;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: ir.nasim.w1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22903w1 extends AbstractC11442d1 implements InterfaceC19286q55 {

    /* renamed from: ir.nasim.w1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Collection e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Collection collection) {
            super(1);
            this.e = collection;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(this.e.contains(obj));
        }
    }

    @Override // java.util.Collection, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 addAll(Collection collection) {
        InterfaceC19286q55.a aVarM = m();
        aVarM.addAll(collection);
        return aVarM.a();
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
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

    @Override // ir.nasim.AbstractC11442d1, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 remove(Object obj) {
        int iIndexOf = indexOf(obj);
        return iIndexOf != -1 ? e0(iIndexOf) : this;
    }

    @Override // java.util.Collection, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 removeAll(Collection collection) {
        return Q0(new a(collection));
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public InterfaceC12119e43 subList(int i, int i2) {
        return super.subList(i, i2);
    }
}
