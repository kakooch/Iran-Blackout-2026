package ir.nasim;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes8.dex */
class F16 extends AbstractC11442d1 {
    private final List a;

    public static final class a implements ListIterator, InterfaceC17915nm3 {
        private final ListIterator a;

        a(int i) {
            this.a = F16.this.a.listIterator(AbstractC14201hX0.Y(F16.this, i));
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
            return AbstractC14201hX0.X(F16.this, this.a.previousIndex());
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return AbstractC14201hX0.X(F16.this, this.a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public F16(List list) {
        AbstractC13042fc3.i(list, "delegate");
        this.a = list;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        return this.a.get(AbstractC14201hX0.W(this, i));
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.a.size();
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator(int i) {
        return new a(i);
    }
}
