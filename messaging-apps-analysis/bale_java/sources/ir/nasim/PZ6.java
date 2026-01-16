package ir.nasim;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
final class PZ6 implements List, InterfaceC19688qm3 {
    private final C14063hH6 a;
    private final int b;
    private int c;
    private int d;

    public static final class a implements ListIterator, InterfaceC17915nm3 {
        final /* synthetic */ C11637dL5 a;
        final /* synthetic */ PZ6 b;

        a(C11637dL5 c11637dL5, PZ6 pz6) {
            this.a = c11637dL5;
            this.b = pz6;
        }

        @Override // java.util.ListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void add(Object obj) {
            AbstractC14665iH6.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            AbstractC14665iH6.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void set(Object obj) {
            AbstractC14665iH6.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a.a < this.b.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.a >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            int i = this.a.a + 1;
            AbstractC14665iH6.g(i, this.b.size());
            this.a.a = i;
            return this.b.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a.a + 1;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i = this.a.a;
            AbstractC14665iH6.g(i, this.b.size());
            this.a.a = i - 1;
            return this.b.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a.a;
        }
    }

    public PZ6(C14063hH6 c14063hH6, int i, int i2) {
        this.a = c14063hH6;
        this.b = i;
        this.c = c14063hH6.x();
        this.d = i2 - i;
    }

    private final void i() {
        if (this.a.x() != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        i();
        this.a.add(this.b + size(), obj);
        this.d = size() + 1;
        this.c = this.a.x();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        i();
        boolean zAddAll = this.a.addAll(i + this.b, collection);
        if (zAddAll) {
            this.d = size() + collection.size();
            this.c = this.a.x();
        }
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            i();
            C14063hH6 c14063hH6 = this.a;
            int i = this.b;
            c14063hH6.C(i, size() + i);
            this.d = 0;
            this.c = this.a.x();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
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

    public int f() {
        return this.d;
    }

    @Override // java.util.List
    public Object get(int i) {
        i();
        AbstractC14665iH6.g(i, size());
        return this.a.get(this.b + i);
    }

    public Object h(int i) {
        i();
        Object objRemove = this.a.remove(this.b + i);
        this.d = size() - 1;
        this.c = this.a.x();
        return objRemove;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        i();
        int i = this.b;
        Iterator it = AbstractC23053wG5.y(i, size() + i).iterator();
        while (it.hasNext()) {
            int iB = ((AbstractC18386oa3) it).b();
            if (AbstractC13042fc3.d(obj, this.a.get(iB))) {
                return iB - this.b;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        i();
        int size = this.b + size();
        do {
            size--;
            if (size < this.b) {
                return -1;
            }
        } while (!AbstractC13042fc3.d(obj, this.a.get(size)));
        return size - this.b;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* bridge */ Object remove(int i) {
        return h(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        i();
        C14063hH6 c14063hH6 = this.a;
        int i = this.b;
        int iE = c14063hH6.E(collection, i, size() + i);
        if (iE > 0) {
            this.c = this.a.x();
            this.d = size() - iE;
        }
        return iE > 0;
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        AbstractC14665iH6.g(i, size());
        i();
        Object obj2 = this.a.set(i + this.b, obj);
        this.c = this.a.x();
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= size())) {
            AbstractC5214Ij5.a("fromIndex or toIndex are out of bounds");
        }
        i();
        C14063hH6 c14063hH6 = this.a;
        int i3 = this.b;
        return new PZ6(c14063hH6, i + i3, i2 + i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        i();
        C11637dL5 c11637dL5 = new C11637dL5();
        c11637dL5.a = i - 1;
        return new a(c11637dL5, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return UW0.b(this, objArr);
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        i();
        this.a.add(this.b + i, obj);
        this.d = size() + 1;
        this.c = this.a.x();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
