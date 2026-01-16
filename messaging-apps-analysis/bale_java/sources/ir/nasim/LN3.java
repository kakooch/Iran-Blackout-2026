package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes8.dex */
public final class LN3 extends AbstractC21043t1 implements Set, InterfaceC24531ym3 {
    private final JN3 a;

    public LN3(JN3 jn3) {
        AbstractC13042fc3.i(jn3, "backing");
        this.a = jn3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // ir.nasim.AbstractC21043t1
    public int f() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.a.R();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.a.a0(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.retainAll(collection);
    }
}
