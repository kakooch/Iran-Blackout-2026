package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final class IH3 implements Collection, InterfaceC17915nm3 {
    public static final a c = new a(null);
    private static final IH3 d = new IH3(AbstractC10360bX0.m());
    private final List a;
    private final int b;

    public static final class a {
        private a() {
        }

        public final IH3 a() {
            return AbstractC14283hf5.a().b();
        }

        public final IH3 b() {
            return IH3.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public IH3(List list) {
        this.a = list;
        this.b = list.size();
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof CH3) {
            return h((CH3) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IH3) && AbstractC13042fc3.d(this.a, ((IH3) obj).a);
    }

    public boolean h(CH3 ch3) {
        return this.a.contains(ch3);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    public final CH3 i(int i) {
        return (CH3) this.a.get(i);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.a.iterator();
    }

    public final List j() {
        return this.a;
    }

    public int o() {
        return this.b;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return o();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    public String toString() {
        return "LocaleList(localeList=" + this.a + ')';
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return UW0.b(this, objArr);
    }
}
