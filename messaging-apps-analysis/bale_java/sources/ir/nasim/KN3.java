package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public final class KN3 extends AbstractC15694k1 {
    private final JN3 a;

    public KN3(JN3 jn3) {
        AbstractC13042fc3.i(jn3, "backing");
        this.a = jn3;
    }

    @Override // ir.nasim.AbstractC15694k1
    public boolean C(Map.Entry entry) {
        AbstractC13042fc3.i(entry, "element");
        return this.a.y(entry);
    }

    @Override // ir.nasim.AbstractC15694k1
    public boolean E(Map.Entry entry) {
        AbstractC13042fc3.i(entry, "element");
        return this.a.X(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        AbstractC13042fc3.i(entry, "element");
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
    public boolean containsAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.a.u(collection);
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
        return this.a.G();
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
