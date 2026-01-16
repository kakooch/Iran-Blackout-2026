package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class EB7 extends AbstractList implements InterfaceC3685Bx3, RandomAccess {
    private final InterfaceC3685Bx3 a;

    class a implements ListIterator {
        ListIterator a;
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
            this.a = EB7.this.a.listIterator(i);
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class b implements Iterator {
        Iterator a;

        b() {
            this.a = EB7.this.a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public EB7(InterfaceC3685Bx3 interfaceC3685Bx3) {
        this.a = interfaceC3685Bx3;
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public void E1(AbstractC2345g abstractC2345g) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public String get(int i) {
        return (String) this.a.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        return new a(i);
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public List n() {
        return this.a.n();
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public Object q(int i) {
        return this.a.q(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public InterfaceC3685Bx3 p() {
        return this;
    }
}
