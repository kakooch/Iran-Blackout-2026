package ir.nasim;

import ir.nasim.InterfaceC19286q55;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class AE6 extends AbstractC22903w1 implements InterfaceC12119e43 {
    public static final a b = new a(null);
    public static final int c = 8;
    private static final AE6 d = new AE6(new Object[0]);
    private final Object[] a;

    public static final class a {
        private a() {
        }

        public final AE6 a() {
            return AE6.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AE6(Object[] objArr) {
        this.a = objArr;
        XZ0.a(objArr.length <= 32);
    }

    private final Object[] j(int i) {
        return new Object[i];
    }

    @Override // ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 Q0(UA2 ua2) {
        Object[] objArrCopyOf = this.a;
        int size = size();
        int size2 = size();
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            Object obj = this.a[i];
            if (((Boolean) ua2.invoke(obj)).booleanValue()) {
                if (!z) {
                    Object[] objArr = this.a;
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
                    z = true;
                    size = i;
                }
            } else if (z) {
                objArrCopyOf[size] = obj;
                size++;
            }
        }
        return size == size() ? this : size == 0 ? d : new AE6(AbstractC9648aK.s(objArrCopyOf, 0, size));
    }

    @Override // java.util.Collection, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 add(Object obj) {
        if (size() >= 32) {
            return new C22949w55(this.a, AbstractC24298yN7.c(obj), size() + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.a, size() + 1);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[size()] = obj;
        return new AE6(objArrCopyOf);
    }

    @Override // ir.nasim.AbstractC22903w1, java.util.Collection, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 addAll(Collection collection) {
        if (size() + collection.size() > 32) {
            InterfaceC19286q55.a aVarM = m();
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
        return new AE6(objArrCopyOf);
    }

    @Override // ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 e0(int i) {
        MB3.a(i, size());
        if (size() == 1) {
            return d;
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.a, size() - 1);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        AbstractC9648aK.l(this.a, objArrCopyOf, i, i + 1, size());
        return new AE6(objArrCopyOf);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        MB3.a(i, size());
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
        MB3.b(i, size());
        return new C5929Ll0(this.a, i, size());
    }

    @Override // ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55.a m() {
        return new C24129y55(this, null, this.a, 0);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 set(int i, Object obj) {
        MB3.a(i, size());
        Object[] objArr = this.a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i] = obj;
        return new AE6(objArrCopyOf);
    }

    @Override // java.util.List, ir.nasim.InterfaceC19286q55
    public InterfaceC19286q55 add(int i, Object obj) {
        MB3.b(i, size());
        if (i == size()) {
            return add(obj);
        }
        if (size() < 32) {
            Object[] objArrJ = j(size() + 1);
            AbstractC9648aK.q(this.a, objArrJ, 0, 0, i, 6, null);
            AbstractC9648aK.l(this.a, objArrJ, i + 1, i, size());
            objArrJ[i] = obj;
            return new AE6(objArrJ);
        }
        Object[] objArr = this.a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        AbstractC9648aK.l(this.a, objArrCopyOf, i + 1, i, size() - 1);
        objArrCopyOf[i] = obj;
        return new C22949w55(objArrCopyOf, AbstractC24298yN7.c(this.a[31]), size() + 1, 0);
    }
}
