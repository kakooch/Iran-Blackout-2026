package ir.nasim;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class PJ implements Collection, Set, InterfaceC18506om3, InterfaceC24531ym3 {
    private int[] a;
    private Object[] b;
    private int c;

    private final class a extends AbstractC12139e63 {
        public a() {
            super(PJ.this.o());
        }

        @Override // ir.nasim.AbstractC12139e63
        protected Object b(int i) {
            return PJ.this.B(i);
        }

        @Override // ir.nasim.AbstractC12139e63
        protected void c(int i) {
            PJ.this.t(i);
        }
    }

    public PJ() {
        this(0, 1, null);
    }

    public final void A(int i) {
        this.c = i;
    }

    public final Object B(int i) {
        return h()[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i;
        int iC;
        int iO = o();
        if (obj == null) {
            iC = RJ.d(this);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iC = RJ.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i2 = ~iC;
        if (iO >= i().length) {
            int i3 = 8;
            if (iO >= 8) {
                i3 = (iO >> 1) + iO;
            } else if (iO < 4) {
                i3 = 4;
            }
            int[] iArrI = i();
            Object[] objArrH = h();
            RJ.a(this, i3);
            if (iO != o()) {
                throw new ConcurrentModificationException();
            }
            if (!(i().length == 0)) {
                AbstractC9648aK.o(iArrI, i(), 0, 0, iArrI.length, 6, null);
                AbstractC9648aK.q(objArrH, h(), 0, 0, objArrH.length, 6, null);
            }
        }
        if (i2 < iO) {
            int i4 = i2 + 1;
            AbstractC9648aK.j(i(), i(), i4, i2, iO);
            AbstractC9648aK.l(h(), h(), i4, i2, iO);
        }
        if (iO != o() || i2 >= i().length) {
            throw new ConcurrentModificationException();
        }
        i()[i2] = i;
        h()[i2] = obj;
        A(o() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        f(o() + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (o() != 0) {
            x(AbstractC13738gk1.a);
            v(AbstractC13738gk1.c);
            A(0);
        }
        if (o() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int iO = o();
                for (int i = 0; i < iO; i++) {
                    if (((Set) obj).contains(B(i))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final void f(int i) {
        int iO = o();
        if (i().length < i) {
            int[] iArrI = i();
            Object[] objArrH = h();
            RJ.a(this, i);
            if (o() > 0) {
                AbstractC9648aK.o(iArrI, i(), 0, 0, o(), 6, null);
                AbstractC9648aK.q(objArrH, h(), 0, 0, o(), 6, null);
            }
        }
        if (o() != iO) {
            throw new ConcurrentModificationException();
        }
    }

    public final Object[] h() {
        return this.b;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrI = i();
        int iO = o();
        int i = 0;
        for (int i2 = 0; i2 < iO; i2++) {
            i += iArrI[i2];
        }
        return i;
    }

    public final int[] i() {
        return this.a;
    }

    public final int indexOf(Object obj) {
        return obj == null ? RJ.d(this) : RJ.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return o() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public int j() {
        return this.c;
    }

    public final int o() {
        return this.c;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        t(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        boolean z = false;
        for (int iO = o() - 1; -1 < iO; iO--) {
            if (!AbstractC15401jX0.i0(collection, h()[iO])) {
                t(iO);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return j();
    }

    public final Object t(int i) {
        int iO = o();
        Object obj = h()[i];
        if (iO <= 1) {
            clear();
        } else {
            int i2 = iO - 1;
            if (i().length <= 8 || o() >= i().length / 3) {
                if (i < i2) {
                    int i3 = i + 1;
                    AbstractC9648aK.j(i(), i(), i, i3, iO);
                    AbstractC9648aK.l(h(), h(), i, i3, iO);
                }
                h()[i2] = null;
            } else {
                int iO2 = o() > 8 ? o() + (o() >> 1) : 8;
                int[] iArrI = i();
                Object[] objArrH = h();
                RJ.a(this, iO2);
                if (i > 0) {
                    AbstractC9648aK.o(iArrI, i(), 0, 0, i, 6, null);
                    AbstractC9648aK.q(objArrH, h(), 0, 0, i, 6, null);
                }
                if (i < i2) {
                    int i4 = i + 1;
                    AbstractC9648aK.j(iArrI, i(), i, i4, iO);
                    AbstractC9648aK.l(objArrH, h(), i, i4, iO);
                }
            }
            if (iO != o()) {
                throw new ConcurrentModificationException();
            }
            A(i2);
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return AbstractC9648aK.s(this.b, 0, this.c);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(o() * 14);
        sb.append('{');
        int iO = o();
        for (int i = 0; i < iO; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objB = B(i);
            if (objB != this) {
                sb.append(objB);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final void v(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<set-?>");
        this.b = objArr;
    }

    public final void x(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<set-?>");
        this.a = iArr;
    }

    public PJ(int i) {
        this.a = AbstractC13738gk1.a;
        this.b = AbstractC13738gk1.c;
        if (i > 0) {
            RJ.a(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        Object[] objArrA = QJ.a(objArr, this.c);
        AbstractC9648aK.l(this.b, objArrA, 0, 0, this.c);
        AbstractC13042fc3.f(objArrA);
        return objArrA;
    }

    public /* synthetic */ PJ(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
