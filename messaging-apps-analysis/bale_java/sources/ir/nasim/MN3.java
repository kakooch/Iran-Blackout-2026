package ir.nasim;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes8.dex */
public final class MN3 extends AbstractC19240q1 implements Collection, InterfaceC18506om3 {
    private final JN3 a;

    public MN3(JN3 jn3) {
        AbstractC13042fc3.i(jn3, "backing");
        this.a = jn3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // ir.nasim.AbstractC19240q1
    public int f() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.a.d0();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.a.b0(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.retainAll(collection);
    }
}
