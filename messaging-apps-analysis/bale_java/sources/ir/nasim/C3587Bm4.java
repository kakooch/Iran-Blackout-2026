package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: ir.nasim.Bm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3587Bm4 extends AbstractC23052wG4 {
    private b c;

    /* renamed from: ir.nasim.Bm4$a */
    private static final class a implements ListIterator, InterfaceC17915nm3 {
        private final List a;
        private int b;

        public a(List list, int i) {
            AbstractC13042fc3.i(list, "list");
            this.a = list;
            this.b = i - 1;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            List list = this.a;
            int i = this.b + 1;
            this.b = i;
            list.add(i, obj);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            List list = this.a;
            int i = this.b + 1;
            this.b = i;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b + 1;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            List list = this.a;
            int i = this.b;
            this.b = i - 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.a.remove(this.b);
            this.b--;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.a.set(this.b, obj);
        }
    }

    /* renamed from: ir.nasim.Bm4$b */
    private static final class b implements List, InterfaceC19688qm3 {
        private final C3587Bm4 a;

        public b(C3587Bm4 c3587Bm4) {
            AbstractC13042fc3.i(c3587Bm4, "objectList");
            this.a = c3587Bm4;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            return this.a.n(obj);
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            return this.a.o(i, collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.a.t();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.a.a(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            return this.a.b(collection);
        }

        public int f() {
            return this.a.e();
        }

        @Override // java.util.List
        public Object get(int i) {
            AbstractC23642xG4.d(this, i);
            return this.a.d(i);
        }

        public Object h(int i) {
            AbstractC23642xG4.d(this, i);
            return this.a.A(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.a.f(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.a.g();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new a(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.a.k(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new a(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i) {
            return h(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            return this.a.z(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            return this.a.D(collection);
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            AbstractC23642xG4.d(this, i);
            return this.a.E(i, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return f();
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            AbstractC23642xG4.e(this, i, i2);
            return new c(this, i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return UW0.a(this);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            this.a.m(i, obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            return this.a.q(collection);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return new a(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.a.y(obj);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "array");
            return UW0.b(this, objArr);
        }
    }

    /* renamed from: ir.nasim.Bm4$c */
    private static final class c implements List, InterfaceC19688qm3 {
        private final List a;
        private final int b;
        private int c;

        public c(List list, int i, int i2) {
            AbstractC13042fc3.i(list, "list");
            this.a = list;
            this.b = i;
            this.c = i2;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            List list = this.a;
            int i = this.c;
            this.c = i + 1;
            list.add(i, obj);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            this.a.addAll(i + this.b, collection);
            this.c += collection.size();
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.c - 1;
            int i2 = this.b;
            if (i2 <= i) {
                while (true) {
                    this.a.remove(i);
                    if (i == i2) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.c = this.b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i = this.c;
            for (int i2 = this.b; i2 < i; i2++) {
                if (AbstractC13042fc3.d(this.a.get(i2), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
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

        public int f() {
            return this.c - this.b;
        }

        @Override // java.util.List
        public Object get(int i) {
            AbstractC23642xG4.d(this, i);
            return this.a.get(i + this.b);
        }

        public Object h(int i) {
            AbstractC23642xG4.d(this, i);
            this.c--;
            return this.a.remove(i + this.b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i = this.c;
            for (int i2 = this.b; i2 < i; i2++) {
                if (AbstractC13042fc3.d(this.a.get(i2), obj)) {
                    return i2 - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.c == this.b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new a(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i = this.c - 1;
            int i2 = this.b;
            if (i2 > i) {
                return -1;
            }
            while (!AbstractC13042fc3.d(this.a.get(i), obj)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - this.b;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new a(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i) {
            return h(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            int i = this.c;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i != this.c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            int i = this.c;
            int i2 = i - 1;
            int i3 = this.b;
            if (i3 <= i2) {
                while (true) {
                    if (!collection.contains(this.a.get(i2))) {
                        this.a.remove(i2);
                        this.c--;
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2--;
                }
            }
            return i != this.c;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            AbstractC23642xG4.d(this, i);
            return this.a.set(i + this.b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return f();
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            AbstractC23642xG4.e(this, i, i2);
            return new c(this, i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return UW0.a(this);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            this.a.add(i + this.b, obj);
            this.c++;
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return new a(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i = this.c;
            for (int i2 = this.b; i2 < i; i2++) {
                if (AbstractC13042fc3.d(this.a.get(i2), obj)) {
                    this.a.remove(i2);
                    this.c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "array");
            return UW0.b(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            AbstractC13042fc3.i(collection, "elements");
            this.a.addAll(this.c, collection);
            this.c += collection.size();
            return collection.size() > 0;
        }
    }

    public C3587Bm4(int i) {
        super(i, null);
    }

    private final void F(int i) {
        AbstractC22970w76.c("Index " + i + " must be in 0.." + this.b);
    }

    public final Object A(int i) {
        if (i < 0 || i >= this.b) {
            l(i);
        }
        Object[] objArr = this.a;
        Object obj = objArr[i];
        int i2 = this.b;
        if (i != i2 - 1) {
            AbstractC9648aK.l(objArr, objArr, i, i + 1, i2);
        }
        int i3 = this.b - 1;
        this.b = i3;
        objArr[i3] = null;
        return obj;
    }

    public final void B(int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this.b) || i2 < 0 || i2 > i3) {
            AbstractC22970w76.c("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this.b);
        }
        if (i2 < i) {
            AbstractC22970w76.a("Start (" + i + ") is more than end (" + i2 + ')');
        }
        if (i2 != i) {
            int i4 = this.b;
            if (i2 < i4) {
                Object[] objArr = this.a;
                AbstractC9648aK.l(objArr, objArr, i, i2, i4);
            }
            int i5 = this.b;
            int i6 = i5 - (i2 - i);
            AbstractC9648aK.v(this.a, null, i6, i5);
            this.b = i6;
        }
    }

    public final void C(int i, Object[] objArr) {
        AbstractC13042fc3.i(objArr, "oldContent");
        int length = objArr.length;
        this.a = AbstractC9648aK.l(objArr, new Object[Math.max(i, (length * 3) / 2)], 0, 0, length);
    }

    public final boolean D(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        int i = this.b;
        Object[] objArr = this.a;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!collection.contains(objArr[i2])) {
                A(i2);
            }
        }
        return i != this.b;
    }

    public final Object E(int i, Object obj) {
        if (i < 0 || i >= this.b) {
            l(i);
        }
        Object[] objArr = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final void m(int i, Object obj) {
        if (i < 0 || i > this.b) {
            F(i);
        }
        int i2 = this.b + 1;
        Object[] objArr = this.a;
        if (objArr.length < i2) {
            C(i2, objArr);
        }
        Object[] objArr2 = this.a;
        int i3 = this.b;
        if (i != i3) {
            AbstractC9648aK.l(objArr2, objArr2, i + 1, i, i3);
        }
        objArr2[i] = obj;
        this.b++;
    }

    public final boolean n(Object obj) {
        int i = this.b + 1;
        Object[] objArr = this.a;
        if (objArr.length < i) {
            C(i, objArr);
        }
        Object[] objArr2 = this.a;
        int i2 = this.b;
        objArr2[i2] = obj;
        this.b = i2 + 1;
        return true;
    }

    public final boolean o(int i, Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        if (i < 0 || i > this.b) {
            F(i);
        }
        int i2 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        int size = this.b + collection.size();
        Object[] objArr = this.a;
        if (objArr.length < size) {
            C(size, objArr);
        }
        Object[] objArr2 = this.a;
        if (i != this.b) {
            AbstractC9648aK.l(objArr2, objArr2, collection.size() + i, i, this.b);
        }
        for (Object obj : collection) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            objArr2[i2 + i] = obj;
            i2 = i3;
        }
        this.b += collection.size();
        return true;
    }

    public final boolean p(AbstractC23052wG4 abstractC23052wG4) {
        AbstractC13042fc3.i(abstractC23052wG4, "elements");
        int i = this.b;
        v(abstractC23052wG4);
        return i != this.b;
    }

    public final boolean q(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        int i = this.b;
        w(iterable);
        return i != this.b;
    }

    public final boolean r(List list) {
        AbstractC13042fc3.i(list, "elements");
        int i = this.b;
        x(list);
        return i != this.b;
    }

    public final List s() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.c = bVar2;
        return bVar2;
    }

    public final void t() {
        AbstractC9648aK.v(this.a, null, 0, this.b);
        this.b = 0;
    }

    public final void u(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            y(it.next());
        }
    }

    public final void v(AbstractC23052wG4 abstractC23052wG4) {
        AbstractC13042fc3.i(abstractC23052wG4, "elements");
        if (abstractC23052wG4.g()) {
            return;
        }
        int i = this.b + abstractC23052wG4.b;
        Object[] objArr = this.a;
        if (objArr.length < i) {
            C(i, objArr);
        }
        AbstractC9648aK.l(abstractC23052wG4.a, this.a, this.b, 0, abstractC23052wG4.b);
        this.b += abstractC23052wG4.b;
    }

    public final void w(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }

    public final void x(List list) {
        AbstractC13042fc3.i(list, "elements");
        if (list.isEmpty()) {
            return;
        }
        int i = this.b;
        int size = list.size() + i;
        Object[] objArr = this.a;
        if (objArr.length < size) {
            C(size, objArr);
        }
        Object[] objArr2 = this.a;
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            objArr2[i2 + i] = list.get(i2);
        }
        this.b += list.size();
    }

    public final boolean y(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        A(iF);
        return true;
    }

    public final boolean z(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        int i = this.b;
        u(iterable);
        return i != this.b;
    }

    public /* synthetic */ C3587Bm4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 16 : i);
    }
}
