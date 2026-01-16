package ir.nasim;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes8.dex */
public class GB7 extends AbstractList implements RandomAccess, InterfaceC4153Dx3 {
    private final InterfaceC4153Dx3 a;

    class a implements ListIterator {
        ListIterator a;
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
            this.a = GB7.this.a.listIterator(i);
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
            this.a = GB7.this.a.iterator();
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

    public GB7(InterfaceC4153Dx3 interfaceC4153Dx3) {
        this.a = interfaceC4153Dx3;
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public kotlin.reflect.jvm.internal.impl.protobuf.d F0(int i) {
        return this.a.F0(i);
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public void L0(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
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

    @Override // ir.nasim.InterfaceC4153Dx3
    public List n() {
        return this.a.n();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public InterfaceC4153Dx3 p() {
        return this;
    }
}
