package ir.nasim;

import ir.nasim.InterfaceC19877r55;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes8.dex */
public final class BE6 extends AbstractC23493x1 implements InterfaceC13346g43 {
    public static final a b = new a(null);
    private static final BE6 c = new BE6(new Object[0]);
    private final Object[] a;

    public static final class a {
        private a() {
        }

        public final BE6 a() {
            return BE6.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public BE6(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "buffer");
        this.a = objArr;
        WZ0.a(objArr.length <= 32);
    }

    @Override // ir.nasim.AbstractC23493x1, java.util.Collection, java.util.List, ir.nasim.InterfaceC19877r55
    public InterfaceC19877r55 addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        if (collection.isEmpty()) {
            return this;
        }
        if (size() + collection.size() > 32) {
            InterfaceC19877r55.a aVarM = m();
            aVarM.addAll(collection);
            return aVarM.a();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.a, size() + collection.size());
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new BE6(objArrCopyOf);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        LB3.a(i, size());
        return this.a[i];
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.a.length;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public int indexOf(Object obj) {
        return AbstractC10242bK.s0(this.a, obj);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public int lastIndexOf(Object obj) {
        return AbstractC10242bK.G0(this.a, obj);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator(int i) {
        LB3.b(i, size());
        return new C5695Kl0(this.a, i, size());
    }

    @Override // ir.nasim.InterfaceC19877r55
    public InterfaceC19877r55.a m() {
        return new C23539x55(this, null, this.a, 0);
    }
}
