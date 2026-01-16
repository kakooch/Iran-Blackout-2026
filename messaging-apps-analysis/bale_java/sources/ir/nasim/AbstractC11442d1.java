package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* renamed from: ir.nasim.d1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11442d1 extends G0 implements List, InterfaceC17915nm3 {
    public static final a Companion = new a(null);
    private static final int maxArraySize = 2147483639;

    /* renamed from: ir.nasim.d1$a */
    public static final class a {
        private a() {
        }

        public final void a(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("startIndex: " + i + ", endIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i + " > endIndex: " + i2);
        }

        public final void b(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void c(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void d(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }

        public final int e(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - AbstractC11442d1.maxArraySize <= 0) {
                return i3;
            }
            if (i2 > AbstractC11442d1.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return AbstractC11442d1.maxArraySize;
        }

        public final boolean f(Collection collection, Collection collection2) {
            AbstractC13042fc3.i(collection, "c");
            AbstractC13042fc3.i(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!AbstractC13042fc3.d(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection collection) {
            AbstractC13042fc3.i(collection, "c");
            Iterator it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.d1$b */
    private class b implements Iterator, InterfaceC17915nm3 {
        private int a;

        public b() {
        }

        protected final int b() {
            return this.a;
        }

        protected final void c(int i) {
            this.a = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < AbstractC11442d1.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC11442d1 abstractC11442d1 = AbstractC11442d1.this;
            int i = this.a;
            this.a = i + 1;
            return abstractC11442d1.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: ir.nasim.d1$c */
    private class c extends b implements ListIterator, InterfaceC17915nm3 {
        public c(int i) {
            super();
            AbstractC11442d1.Companion.c(i, AbstractC11442d1.this.size());
            c(i);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC11442d1 abstractC11442d1 = AbstractC11442d1.this;
            c(b() - 1);
            return abstractC11442d1.get(b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: ir.nasim.d1$d */
    private static final class d extends AbstractC11442d1 implements RandomAccess {
        private final AbstractC11442d1 a;
        private final int b;
        private int c;

        public d(AbstractC11442d1 abstractC11442d1, int i, int i2) {
            AbstractC13042fc3.i(abstractC11442d1, "list");
            this.a = abstractC11442d1;
            this.b = i;
            AbstractC11442d1.Companion.d(i, i2, abstractC11442d1.size());
            this.c = i2 - i;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public Object get(int i) {
            AbstractC11442d1.Companion.b(i, this.c);
            return this.a.get(this.b + i);
        }

        @Override // ir.nasim.G0
        public int getSize() {
            return this.c;
        }
    }

    protected AbstractC11442d1() {
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.g(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (AbstractC13042fc3.d(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (AbstractC13042fc3.d(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<Object> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Object> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    public ListIterator<Object> listIterator(int i) {
        return new c(i);
    }
}
