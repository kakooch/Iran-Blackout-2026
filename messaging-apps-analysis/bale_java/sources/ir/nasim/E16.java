package ir.nasim;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes8.dex */
final class E16 extends AbstractC19831r1 {
    private final List a;

    public static final class a implements ListIterator, InterfaceC17915nm3 {
        private final ListIterator a;

        a(int i) {
            this.a = E16.this.a.listIterator(AbstractC14201hX0.Y(E16.this, i));
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.a.add(obj);
            this.a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return AbstractC14201hX0.X(E16.this, this.a.previousIndex());
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return AbstractC14201hX0.X(E16.this, this.a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.a.remove();
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.a.set(obj);
        }
    }

    public E16(List list) {
        AbstractC13042fc3.i(list, "delegate");
        this.a = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        this.a.add(AbstractC14201hX0.Y(this, i), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // ir.nasim.AbstractC19831r1
    public int f() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.a.get(AbstractC14201hX0.W(this, i));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // ir.nasim.AbstractC19831r1
    public Object j(int i) {
        return this.a.remove(AbstractC14201hX0.W(this, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        return this.a.set(AbstractC14201hX0.W(this, i), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        return new a(i);
    }
}
